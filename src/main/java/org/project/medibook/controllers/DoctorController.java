package org.project.medibook.controllers;
import io.javalin.http.Context;
import org.project.medibook.model.DoctorModel;
import org.project.medibook.repositories.DoctorRepository;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class DoctorController {

    public static void renderDoctors(Context ctx) throws SQLException {

        List<DoctorModel> doctors = DoctorRepository.getAllDoctors();
        ctx.render("doctor_profiles.html", Map.of("doctors", doctors)); // Render welcome page with username
    }
}
