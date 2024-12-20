package org.project.medibook.controllers;

import io.javalin.http.Context;
import org.project.medibook.model.Appointment;
import org.project.medibook.model.Doctor;
import org.project.medibook.repositories.AppointmentRepository;
import org.project.medibook.repositories.DoctorRepository;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class AppointmentController {

  private static final AppointmentRepository appointmentRepository = new AppointmentRepository();

  public static void renderDashboard(Context ctx) throws SQLException {
    Map<String, Object> userAttributes = ctx.sessionAttribute("userAttributes");
    int userId = (int) userAttributes.get("id");
    String name = (String) userAttributes.get("name");
    String userimage = (String) userAttributes.get("image");
    String sortOrder = ctx.queryParam("sortOrder");
    if (sortOrder == null) {
      sortOrder = "asc";
    }
    List<Appointment> appointments = AppointmentRepository.findUpcomingAppointmentsByUserId(userId, sortOrder);
    ctx.render("user_dashboard", Map.of("appointments", appointments, "userimage", userimage, "name", name));
  }


  public static void renderAppointmentHistory(Context ctx) throws SQLException {
    Map<String, Object> userAttributes = ctx.sessionAttribute("userAttributes");
    int userId = (int) userAttributes.get("id");
    String name = (String) userAttributes.get("name");
    String userimage = (String) userAttributes.get("image");
    List<Appointment> appointments = appointmentRepository.findPastAppointmentsByUserId(userId);
    ctx.render("past_appointments", Map.of("appointments", appointments, "userimage", userimage, "name", name));
  }

  public static void renderSingleAppointment(Context ctx) throws SQLException {
    Map<String, Object> userAttributes = ctx.sessionAttribute("userAttributes");
    int userId = (int) userAttributes.get("id");
    String name = (String) userAttributes.get("name");
    String userimage = (String) userAttributes.get("image");
    String idString = ctx.pathParam("id");

    try {
      int id = Integer.parseInt(idString);
      Appointment appointment = AppointmentRepository.getSingleAppointment(id);

      if (appointment != null) {
        Doctor doctor = DoctorRepository.getDoctor(appointment.getDoctor_id());
        ctx.render("single_appointment.html", Map.of("appointment", appointment, "doctor", doctor, "userimage", userimage, "name", name,
            "currentDate", LocalDate.now()));
      } else {
        System.out.println("...");
        ctx.status(404).render("error.html", Map.of("errorMessage", "Appointment not found"));
      }
    } catch (NumberFormatException e) {
      ctx.status(400).render("error.html", Map.of("errorMessage", "Invalid Appointment ID"));
    }
  }


  public static void getAvailableDates(Context ctx) {
    int doctorId = Integer.parseInt(ctx.queryParam("doctor_id"));
    List<String> availableDates = appointmentRepository.getAvailableDatesForDoctor(doctorId);
    ctx.json(availableDates);
  }

  public static void getAvailableTimes(Context ctx) {
    int doctorId = Integer.parseInt(ctx.queryParam("doctor_id"));
    String selectedDate = ctx.queryParam("date");

    // Define all possible time slots for a day
    List<String> allTimeSlots = Arrays.asList("09:00", "10:00", "11:00", "12:00",
        "13:00", "14:00", "15:00", "16:00");

    // Fetch booked times for the selected doctor and date
    List<String> bookedTimes = appointmentRepository.getBookedTimesForDoctorAndDate(doctorId, selectedDate);

    // Filter out booked times from all possible time slots
    List<String> availableTimes = new ArrayList<>(allTimeSlots);
    availableTimes.removeAll(bookedTimes);

    // Send the available times as JSON
    ctx.json(availableTimes);
  }


  public static void renderBookingPage(Context ctx) throws SQLException {
    Map<String, Object> userAttributes = ctx.sessionAttribute("userAttributes");
    int userId = (int) userAttributes.get("id");
    String name = (String) userAttributes.get("name");
    String userimage = (String) userAttributes.get("image");
    List<Doctor> doctors = DoctorRepository.getAllDoctors();
    ctx.render("book_appointment.html", Map.of("doctors", doctors, "userimage", userimage, "name", name));
  }


  public static void bookAppointment(Context ctx) throws SQLException {
    Map<String, Object> userAttributes = ctx.sessionAttribute("userAttributes");
    int userId = (int) userAttributes.get("id");

    int doctorId = Integer.parseInt(ctx.formParam("doctor_id"));
    String date = ctx.formParam("date");
    String time = ctx.formParam("time");
    String comment = ctx.formParam("comment");

    Appointment appointment = new Appointment();
    appointment.setUser_id(userId);
    appointment.setDoctor_id(doctorId);
    appointment.setDate(LocalDate.parse(date));
    appointment.setStart_time(LocalTime.parse(time));
    appointment.setComment(comment);

    appointmentRepository.saveAppointment(appointment);
    ctx.status(200).json(Map.of("message", "Appointment booked successfully"));
  }

  public static void removeAppointment(Context ctx) throws SQLException {
    int appointmentId = Integer.parseInt(ctx.pathParam("id"));
    try {
      AppointmentRepository.deleteUpcomingAppointment(appointmentId);
      ctx.status(204).redirect("/dashboard");
    } catch (Exception e) {
      if (e.getMessage().equals("Appointment not found.")) {
        ctx.status(404).render("error.html", Map.of("errorMessage", "Appointment not found."));
      }
    }
  }

}


