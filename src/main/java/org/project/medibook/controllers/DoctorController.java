package org.project.medibook.controllers;
import io.javalin.http.Context;
import org.project.medibook.model.Doctor;
import org.project.medibook.repositories.DoctorRepository;
import java.util.List;
import java.util.Map;

public class DoctorController {

    public static void renderDoctors(Context ctx) {
        try {
            // Fetch user attributes from the session
            Map<String, Object> userAttributes = ctx.sessionAttribute("userAttributes");
            String name = (String) userAttributes.get("name");
            String userimage = (String) userAttributes.get("image");

            // Fetch doctors and render the profile page
            List<Doctor> doctors = DoctorRepository.getAllDoctors();
            ctx.render("doctor_profiles.html", Map.of("doctors", doctors, "userimage", userimage, "name", name));

        } catch (Exception e) {
            ctx.status(500).render("error.html", Map.of("errorMessage", "An error occurred. Please try again later."));
        }
    }


    public static void getAllDoctorsJson(Context ctx) {
        try {
            List<Doctor> doctors = DoctorRepository.getAllDoctors();
            ctx.json(doctors); // Return the list of doctors as JSON
        } catch (Exception e) {
            ctx.status(500).render("error.html", Map.of("errorMessage", "An error occurred. Please try again later."));
        }
    }

    public static void renderDoctor(Context ctx){
        try {
            // Fetch user attributes from the session
            Map<String, Object> userAttributes = ctx.sessionAttribute("userAttributes");
            String name = (String) userAttributes.get("name");
            String userimage = (String) userAttributes.get("image");
            String idString = ctx.pathParam("id");
            int id = Integer.parseInt(idString);

            // Fetch doctor and render the profile page
            Doctor doctor = DoctorRepository.getDoctor(id);

            if (doctor != null) {
                ctx.render("doctor_profile.html", Map.of("doctor", doctor, "userimage", userimage, "name", name));
            } else {
                ctx.status(404).render("error.html", Map.of("errorMessage", "Doctor not found"));
            }
        } catch (Exception e) {
            ctx.status(500).render("error.html", Map.of("errorMessage", "An error occurred. Please try again later."));
        }
    }

}
