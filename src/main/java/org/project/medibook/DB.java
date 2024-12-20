package org.project.medibook;

import io.github.cdimascio.dotenv.Dotenv;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DB {
    private static final Dotenv dotenv = Dotenv.load();
    public static final String dbUrl = dotenv.get("DB_URL");

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(dbUrl);
    }
}