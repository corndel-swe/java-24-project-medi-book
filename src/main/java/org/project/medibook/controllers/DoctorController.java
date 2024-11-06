package org.project.medibook.controllers;
import io.javalin.http.Context;
import org.project.medibook.model.Doctor;
import org.project.medibook.repositories.DoctorRepository;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class DoctorController {

    public static void renderDoctors(Context ctx) throws SQLException {
        Map<String, Object> userAttributes = ctx.sessionAttribute("userAttributes");
        String userimage = (String) userAttributes.get("image");
        List<Doctor> doctors = DoctorRepository.getAllDoctors();
        String name = (String) userAttributes.get("name");
        ctx.render("doctor_profiles.html", Map.of("doctors", doctors, "userimage", userimage, "name", name));
    }

    public static void getAllDoctorsJson(Context ctx) throws SQLException {
        List<Doctor> doctors = DoctorRepository.getAllDoctors();
        ctx.json(doctors); // Return the list of doctors as JSON
    }

    public static void renderDoctor(Context ctx) throws SQLException {
        try {
            String idString = ctx.pathParam("id");
            int id = Integer.parseInt(idString);

            Doctor doctor = DoctorRepository.getDoctor(id);

            if (doctor != null) {
                System.out.println(doctor.getProfile_picture());
                ctx.render("doctor_profile.html", Map.of("doctor", doctor));
            } else {
                ctx.status(404).result("Doctor not found");
            }
        } catch (NumberFormatException e) {
            // Handle the case where the id is not a valid integer
            ctx.status(400).result("Invalid doctor ID");
        }
    }


}
