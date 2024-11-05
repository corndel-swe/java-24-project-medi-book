package org.project.medibook.repositories;

import ch.qos.logback.core.model.Model;
import org.project.medibook.DB;
import org.project.medibook.model.Doctor;


import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class DoctorRepository {

    public static List<Doctor> getAllDoctors() throws SQLException {
        var query = "SELECT * FROM doctors";

        try (var con = DB.getConnection();
             var stmt = con.createStatement();
             var rs = stmt.executeQuery(query);) {

            var users = new ArrayList<Doctor>();
            while (rs.next()) {
                var id = rs.getInt("id");
                var name = rs.getString("name");
                var speciality = rs.getString("speciality");
                var image = rs.getString("image");
                var biography = rs.getString("biography");

                users.add(new Doctor(id, name, speciality, image, biography));
            }

            return users;
        }
    }
    public static Doctor getDoctor(int id) throws SQLException {
        var query = "SELECT * FROM doctors WHERE id = ?";

        try (var con = DB.getConnection();
             var stmt = con.prepareStatement(query)) {

            stmt.setInt(1, id);

            try (var rs = stmt.executeQuery()) {
                if (!rs.next()) {
                    return null;
                }

                var name = rs.getString("name");
                var speciality = rs.getString("speciality");
                var image = rs.getString("image");
                var biography = rs.getString("biography");

                return new Doctor(id, name, speciality, image, biography);
            }
        }
    }


}
