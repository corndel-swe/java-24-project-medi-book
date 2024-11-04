package org.project.medibook.repositories;

import org.project.medibook.DB;
import org.project.medibook.model.User;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserRepository {

    public static List<User> findAll() throws SQLException {
        var query = "SELECT * FROM Users";

        try (var con = DB.getConnection();
             var stmt = con.createStatement();
             var rs = stmt.executeQuery(query);) {

            var users = new ArrayList<User>();

            if (!rs.next()) {
                return null;
            }
            else {
                var id = rs.getInt("id");
                var name = rs.getString("name");
                var email = rs.getString("email");
                var profile_picture = rs.getString("image");

                users.add(new User(id, name, email, profile_picture));
            }
            return users;
        }


    }
    public static LoginResponse logUserIn(String email,  String password) throws SQLException, Exception {
        String query = "SELECT id, email, password FROM users WHERE email = ?";

        try (var con = DB.getConnection();
             var stmt = con.prepareStatement(query)) {

            stmt.setString(1, email);
            try (var rs = stmt.executeQuery()) {
                if (rs.next()) {
                    String emailDB = rs.getString("email");
                    String passwordDB = rs.getString("password");
                    Integer id = rs.getInt("id");

                    if (passwordDB.equals(password)) {
                        System.out.println("Passwords match, logging in");
                        return new LoginResponse(email, password, id);
                    } else {
                        throw new Exception("Passwords do not match, cannot log in");
                    }
                } else {
                    System.out.println("No user found to log in");
                    return null;
                }
            }
        }
    }
    public static record LoginResponse(String email, String password, Integer id) {
    }

}
