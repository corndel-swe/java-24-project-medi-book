package org.project.medibook.repositories;

import org.project.medibook.DB;
import java.sql.SQLException;

import org.project.medibook.model.Appointment;

import java.util.ArrayList;
import java.util.List;

public class AppointmentRepository {

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
}
