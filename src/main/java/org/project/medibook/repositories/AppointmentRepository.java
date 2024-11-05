package org.project.medibook.repositories;

import org.project.medibook.DB;
import org.project.medibook.model.Appointment;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class AppointmentRepository {

  // Method to find upcoming appointments by user ID
  public static List<Appointment> findUpcomingAppointmentsByUserId(int user_id) throws SQLException {
    String query = "SELECT * FROM appointments INNER JOIN doctors ON appointments.doctor_id = doctors.id WHERE appointments.user_id = ? AND (appointments.date > CURRENT_DATE OR (appointments.date = CURRENT_DATE AND appointments.start_time > CURRENT_TIME));";

    List<Appointment> appointments = new ArrayList<>();

    try (var con = DB.getConnection();
         var stmt = con.prepareStatement(query)) {
      stmt.setInt(1, user_id);

      try (var rs = stmt.executeQuery()) {
        while (rs.next()) {
          appointments.add(Appointment.of(rs));
        }
      }
    }
    return appointments;
  }

  public static List<Appointment> findPastAppointmentsByUserId(int user_id) throws SQLException {
    String query = "SELECT * FROM appointments INNER JOIN doctors ON appointments.doctor_id = doctors.id WHERE appointments.user_id = ? AND (appointments.date < CURRENT_DATE OR (appointments.date = CURRENT_DATE AND appointments.start_time < CURRENT_TIME));";

    List<Appointment> appointments = new ArrayList<>();

    try (var con = DB.getConnection();
         var stmt = con.prepareStatement(query)) {
      stmt.setInt(1, user_id);

      try (var rs = stmt.executeQuery()) {
        while (rs.next()) {
          appointments.add(Appointment.of(rs));
        }
      }
    }
    return appointments;
  }

  public List<String> getAvailableDatesForDoctor(int doctorId) {
    List<String> availableDates = new ArrayList<>();
//    LocalDate today = LocalDate.now();
//    LocalDate twoWeeksFromNow = today.plusWeeks(2);
//
//    // Populate the list with the next two weeks of dates
//    for (LocalDate date = today; !date.isAfter(twoWeeksFromNow); date = date.plusDays(1)) {
//      availableDates.add(date.toString()); // Convert to "YYYY-MM-DD" format
//    }

    // Now we fetch booked dates for the doctor
    List<String> bookedDates = new ArrayList<>();

    String query = "SELECT DISTINCT date FROM appointments WHERE doctor_id = ? AND date BETWEEN ? AND ?";
    try (var con = DB.getConnection();
         var stmt = con.prepareStatement(query)) {
      stmt.setInt(1, doctorId);
//      stmt.setDate(2, java.sql.Date.valueOf(today));
//      stmt.setDate(3, java.sql.Date.valueOf(twoWeeksFromNow));

      try (var rs = stmt.executeQuery()) {
        while (rs.next()) {
          bookedDates.add(rs.getDate("date").toLocalDate().toString());
        }
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }

    // Remove booked dates from available dates
    availableDates.removeAll(bookedDates);

    return availableDates;
  }


  public List<String> getBookedTimesForDoctorAndDate(int doctorId, String date) {
    List<String> bookedTimes = new ArrayList<>();
    String query = "SELECT start_time FROM appointments WHERE doctor_id = ? AND date = ?";
    try (var con = DB.getConnection();
         var stmt = con.prepareStatement(query)) {
      stmt.setInt(1, doctorId);
      stmt.setString(2, date);
      ResultSet rs = stmt.executeQuery();
      while (rs.next()) {
        bookedTimes.add(rs.getString("start_time"));
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return bookedTimes;
  }



  public void saveAppointment(Appointment appointment) throws SQLException {
    String query = "INSERT INTO appointments (user_id, doctor_id, date, start_time, comment) VALUES (?, ?, ?, ?, ?)";

    try (var con = DB.getConnection();
         var stmt = con.prepareStatement(query)) {
      stmt.setInt(1, appointment.getUser_id());
      stmt.setInt(2, appointment.getDoctor_id());
      stmt.setString(3, appointment.getDate().toString());
      stmt.setString(4, appointment.getStart_time().toString());
      stmt.setString(5, appointment.getComment());

      stmt.executeUpdate();
    }
  }
}
