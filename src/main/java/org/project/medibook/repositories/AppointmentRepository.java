package org.project.medibook.repositories;

import java.sql.Connection;

public class AppointmentRepository {
    private Connection connection;

    // Constructor that accepts a Connection object
    public AppointmentRepository(Connection connection) {
        this.connection = connection;
    }
}
