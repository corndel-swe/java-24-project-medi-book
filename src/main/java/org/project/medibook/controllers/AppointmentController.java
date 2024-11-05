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

  // Static instance of AppointmentRepository
  private static final AppointmentRepository appointmentRepository = new AppointmentRepository();

  // Static method to render the dashboard
  public static void renderDashboard(Context ctx) throws SQLException {
    Map<String, Object> userAttributes = ctx.sessionAttribute("userAttributes");
    int userId = (int) userAttributes.get("id");
    List<Appointment> appointments = appointmentRepository.findUpcomingAppointmentsByUserId(userId);
    ctx.render("user_dashboard", Map.of("appointments", appointments));
  }

  // Static method to render appointment history
  public static void renderAppointmentHistory(Context ctx) throws SQLException {
    Map<String, Object> userAttributes = ctx.sessionAttribute("userAttributes");
    int userId = (int) userAttributes.get("id");
    List<Appointment> appointments = appointmentRepository.findPastAppointmentsByUserId(userId);
    ctx.render("past_appointments", Map.of("appointments", appointments));
  }

  public static void renderSingleAppointment(Context ctx) throws SQLException {
    try {
      String idString = ctx.pathParam("id");
      int id = Integer.parseInt(idString);

      Appointment appointment = AppointmentRepository.getSingleAppointment(id);
      Doctor doctor = DoctorRepository.getDoctor(appointment.getDoctor_id());

      if (appointment != null) {
        ctx.render("single_appointment.html", Map.of("appointment", appointment, "doctor",doctor));
      } else {
        ctx.status(404).result("Appointment not found");
      }
    } catch (NumberFormatException e) {
      ctx.status(400).result("Invalid Appointment ID");
    }
  }



  public static void getAvailableDates(Context ctx) {
    int doctorId = Integer.parseInt(ctx.queryParam("doctor_id"));
    List<String> availableDates = appointmentRepository.getAvailableDatesForDoctor(doctorId); // Update to String
    ctx.json(availableDates);
  }

  public static void getAvailableTimes(Context ctx) {
    int doctorId = Integer.parseInt(ctx.queryParam("doctor_id"));
    String selectedDate = ctx.queryParam("date");

    // Define all possible time slots for a day
    List<String> allTimeSlots = Arrays.asList("09:00:00", "10:00:00", "11:00:00", "12:00:00",
            "13:00:00", "14:00:00", "15:00:00", "16:00:00", "17:00:00");

    // Fetch booked times for the selected doctor and date
    List<String> bookedTimes = appointmentRepository.getBookedTimesForDoctorAndDate(doctorId, selectedDate);

    // Filter out booked times from all possible time slots
    List<String> availableTimes = new ArrayList<>(allTimeSlots);
    availableTimes.removeAll(bookedTimes);

    // Send the available times as JSON
    ctx.json(availableTimes);
  }


  public static void renderBookingPage(Context ctx) throws SQLException {
    List<Doctor> doctors = DoctorRepository.getAllDoctors();
    ctx.render("book_appointment.html", Map.of("doctors", doctors));
  }

  // Handles appointment booking
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
    ctx.status(200).json(Map.of("message", "Appointment booked successfully")); // Send success response
  }

}


