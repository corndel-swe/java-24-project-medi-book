package org.project.medibook.User;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.javalin.Javalin;
import io.javalin.json.JavalinJackson;
import io.javalin.testtools.JavalinTest;
import org.junit.jupiter.api.Test;
import org.project.medibook.App;
import org.project.medibook.controllers.UserController;
import org.project.medibook.model.User;
import org.project.medibook.model.UserRequest;
import org.project.medibook.repositories.UserRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class UserTests {

    Javalin app = App.createApp();

    @Test
    public void get_Users_returns_users() {
        JavalinTest.test(app, (server, client) -> {
            List<User> users = UserRepository.findAll();

            assertThat(users).isNotEmpty();

            ObjectMapper objectMapper = new ObjectMapper();
            String usersJson = objectMapper.writeValueAsString(users);

            var response = client.get("/users");

            assertThat(response.code()).isEqualTo(200);
            assertThat(response.body().string()).isEqualTo(usersJson);
        });
    }




}
