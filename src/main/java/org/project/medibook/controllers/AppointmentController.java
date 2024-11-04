package org.project.medibook.controllers;

import io.javalin.http.Context;
import org.project.medibook.model.Appointment;
import org.project.medibook.repositories.AppointmentRepository;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AppointmentController {
  public static void getUpcomingAppointmentsByUserId(Context ctx) throws SQLException {
    Map<String, Object> userAttributes = ctx.sessionAttribute("userAttributes");

    Integer userId = (Integer) userAttributes.get("id"); // Adjust type if needed
    String userName = (String) userAttributes.get("name");
    String userImage = (String) userAttributes.get("image");
    List<Appointment> appointments = AppointmentRepository.findUpcomingAppointmentsByUserId(userId);
    ctx.render("user_dashboard", Map.of("appointments", appointments));
  }
}
