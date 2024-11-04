package org.project.medibook.controllers;

import io.javalin.http.Context;
import org.project.medibook.model.Appointment;
import org.project.medibook.repositories.AppointmentRepository;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class AppointmentController {
  public static void getUpcomingAppointmentsByUserId(Context ctx) throws SQLException {
    int user_id = ctx.sessionAttribute("userId");
    List<Appointment> appointments = AppointmentRepository.findUpcomingAppointmentsByUserId(user_id);
    ctx.render("user_dashboard", Map.of("appointments", appointments));
  }
}
