package org.project.medibook;

import org.project.medibook.controllers.AppointmentController;
import org.project.medibook.controllers.DoctorController;
import org.project.medibook.controllers.UserController;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;
import io.javalin.Javalin;
import io.javalin.http.staticfiles.Location;
import io.javalin.rendering.template.JavalinThymeleaf;

public class App {
    public static void main(String[] args) {
        var javalin = createApp();
        javalin.start(8081);
    }

    public static Javalin createApp() {
        var app = Javalin.create(config -> {
            config.staticFiles.add("src/main/resources/public", Location.EXTERNAL);

            var resolver = new ClassLoaderTemplateResolver();
            resolver.setPrefix("/templates/");
            resolver.setSuffix(".html");
            resolver.setTemplateMode("HTML");

            var engine = new TemplateEngine();
            engine.setTemplateResolver(resolver);

            config.fileRenderer(new JavalinThymeleaf(engine));
        });

        app.get("/hello", ctx -> ctx.result("Hello, World!"));

        // USER ENDPOINTS
        app.get("/", UserController::getAll);
        app.post("/login", UserController::userLogIn);
        app.get("/logout", UserController::userLogOut);


        // APPOINTMENT ENDPOINTS
        app.get("/dashboard", AppointmentController::renderDashboard);
        app.get("/appointment-history", AppointmentController::renderAppointmentHistory);
        app.get("/appointments/dates", AppointmentController::getAvailableDates);
        app.get("/appointments/times", AppointmentController::getAvailableTimes);
        app.get("/appointments/book", AppointmentController::renderBookingPage);
        app.post("/appointments/book", AppointmentController::bookAppointment);
        app.get("/appointment/{id}", AppointmentController::renderSingleAppointment);
        app.post("/appointment/{id}", ctx -> {
            // custom logic to override POST method with DELETE request
            if ("DELETE".equals(ctx.formParam("_method"))) {
                AppointmentController.removeAppointment(ctx);
            }
        });

        // DOCTOR ENDPOINTS
        app.get("/doctors/list", DoctorController::getAllDoctorsJson);
        app.get("/doctors", DoctorController::renderDoctors);
        app.get("/doctor/{id}", DoctorController::renderDoctor);

        return app;
    }
}
