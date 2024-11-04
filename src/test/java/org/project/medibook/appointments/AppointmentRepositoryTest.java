package org.project.medibook.appointments;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.project.medibook.model.Appointment;
import org.project.medibook.repositories.AppointmentRepository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AppointmentRepositoryTest {
    private Connection connection;
    private AppointmentRepository appointmentRepository;

    @BeforeEach
    public void setUp() throws SQLException {
        // Setup in-memory SQLite database
        connection = DriverManager.getConnection("jdbc:sqlite::memory:");
        createTables();
        insertSampleData();
        appointmentRepository = new AppointmentRepository(connection);
    }

    private void createTables() throws SQLException {
        String createAppointmentsTable = "CREATE TABLE IF NOT EXISTS appointments (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "user_id INT NOT NULL," +
                "doctor_id INT NOT NULL," +
                "start_time TEXT NOT NULL," +
                "date TEXT NOT NULL," +
                "comment TEXT NOT NULL);";
        connection.createStatement().execute(createAppointmentsTable);
    }

    private void insertSampleData() throws SQLException {
        String insertAppointment = "INSERT INTO appointments (user_id, doctor_id, start_time, date, comment) VALUES (?, ?, ?, ?, ?)";
        var preparedStatement = connection.prepareStatement(insertAppointment);
        // Adding some sample appointments
        preparedStatement.setInt(1, 1); preparedStatement.setInt(2, 1); preparedStatement.setString(3, "09:00:00"); preparedStatement.setString(4, "2024-11-01"); preparedStatement.setString(5, "Routine follow-up check."); preparedStatement.executeUpdate();
        preparedStatement.setInt(1, 1); preparedStatement.setInt(2, 2); preparedStatement.setString(3, "10:00:00"); preparedStatement.setString(4, "2024-11-02"); preparedStatement.setString(5, "Another appointment for checkup."); preparedStatement.executeUpdate();
        preparedStatement.setInt(1, 2); preparedStatement.setInt(2, 1); preparedStatement.setString(3, "11:00:00"); preparedStatement.setString(4, "2024-11-01"); preparedStatement.setString(5, "Consultation for skin care."); preparedStatement.executeUpdate();
        preparedStatement.setInt(1, 3); preparedStatement.setInt(2, 1); preparedStatement.setString(3, "12:00:00"); preparedStatement.setString(4, "2024-11-01"); preparedStatement.setString(5, "Pediatric visit."); preparedStatement.executeUpdate();
    }

    @AfterEach
    public void tearDown() throws SQLException {
        if (connection != null) {
            connection.close();
        }
    }

//    @Test
//    public void testGetAllAppointments() throws SQLException {
//        List<Appointment> appointments = appointmentRepository.getAllAppointments();
//        assertEquals(4, appointments.size());
//    }
//
//    @Test
//    public void testGetAppointmentsByUserId() throws SQLException {
//        List<Appointment> appointments = appointmentRepository.findAppointmentsByUserId(1);
//        assertEquals(2, appointments.size());
//    }
}

