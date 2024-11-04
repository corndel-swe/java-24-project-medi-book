package org.project.medibook.controllers;

import io.javalin.http.Context;
import org.project.medibook.model.User;
import org.project.medibook.model.UserRequest;
import org.project.medibook.repositories.UserRepository;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class UserController {

    public static void getAll(Context ctx) {
        try {
            List<User> Users = UserRepository.findAll();
            ctx.render("index.html", Map.of("Users", Users));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public static void userLogIn(Context ctx) {
        try {
            String email = ctx.formParam("email");
            String password = ctx.formParam("password");

            var user = UserRepository.logUserIn(email, password);
            ctx.sessionAttribute("userId", user.id());
            ctx.redirect("/dashboard");
        } catch (Exception e) {
            System.err.println(e.getMessage());
            ctx.status(500).result("Login failed.");
        }
    }
}
