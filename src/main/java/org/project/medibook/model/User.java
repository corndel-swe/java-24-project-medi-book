package org.project.medibook.model;

import java.sql.ResultSet;
import java.sql.SQLException;

public class User {

    private int id;
    private String name;
    private String email;
    private String profile_picture;

    public User() {
    }

    public User(int id, String name, String email, String profile_picture) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.profile_picture = profile_picture;
    }

    public static User of(ResultSet rs) throws SQLException {
        User user = new User();
        user.setId(rs.getInt("id"));
        user.setName(rs.getString("name"));
        user.setEmail(rs.getString("email"));
        user.setProfile_picture(rs.getString("image"));
        return user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getProfile_picture() {
        return profile_picture;
    }

    public void setProfile_picture(String profile_picture) {
        this.profile_picture = profile_picture;
    }

    @Override
    public String toString() {
        return "AppointmentModel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", profile_picture='" + profile_picture + '\'' +
                '}';
    }
}
