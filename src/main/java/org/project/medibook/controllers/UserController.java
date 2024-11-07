package org.project.medibook.controllers;

import io.javalin.http.Context;
import org.project.medibook.model.User;
import org.project.medibook.model.UserRequest;
import org.project.medibook.repositories.UserRepository;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserController {

    public static void renderLogInPage(Context ctx) {
        ctx.render("index.html");
        ctx.status(200);

    }

    public static void getAll(Context ctx) {
        try {
            List<User> Users = UserRepository.findAll();
            ctx.json(Users).status(200);
            System.out.println(Users);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public static void userLogIn(Context ctx) {
        try {
            String email = ctx.formParam("email");
            String password = ctx.formParam("password");

            var user = UserRepository.logUserIn(email, password);


            Map<String, Object> userAttributes = new HashMap<>();
            userAttributes.put("id", user.id());
            userAttributes.put("name", user.name());
            userAttributes.put("image", user.image());
            ctx.sessionAttribute("userAttributes", userAttributes);

            ctx.redirect("/dashboard");
        } catch (Exception e) {
            System.err.println(e.getMessage());

            ctx.sessionAttribute("errorMessage", "Login failed: " + e.getMessage());
            ctx.redirect("/");
        }
    }
    public static void userLogOut(Context ctx) {
        ctx.sessionAttribute("userAttributes", null);
        ctx.redirect("/");
    }

}
