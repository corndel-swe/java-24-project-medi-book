package org.project.medibook.doctors;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.javalin.Javalin;
import io.javalin.testtools.JavalinTest;
import org.junit.jupiter.api.Test;
import org.project.medibook.App;
import org.project.medibook.controllers.DoctorController;
import org.project.medibook.model.Doctor;
import org.project.medibook.repositories.DoctorRepository;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class DoctorRepositoryTests {
    Javalin app = App.createApp();

    @Test
    public void getAllDoctors_returns_doctors() {
        JavalinTest.test(app, (server, client) -> {
            List<Doctor> doctors = DoctorRepository.getAllDoctors();

            assertThat(doctors).isNotEmpty();

            ObjectMapper objectMapper = new ObjectMapper();
            String doctorsjson = objectMapper.writeValueAsString(doctors);

            var response = client.get("/doctors/list");

            assertThat(response.code()).isEqualTo(200);
            assertThat(response.body().string()).isEqualTo(doctorsjson);
        });
    }

    @Test
    public void getDoctorbyId_returns_single_Doctor() {
        JavalinTest.test(app, (server, client) -> {
            Doctor doctor = DoctorRepository.getDoctor(5);


            assertThat(doctor.getName()).isEqualTo("Dr. Olivia Green");
            assertThat(doctor.getId()).isEqualTo(5);
            assertThat(doctor.getSpeciality()).isEqualTo("Psychiatry");
            assertThat(doctor.getProfile_picture()).isEqualTo("olivia.jpg");

        });
    }

}
