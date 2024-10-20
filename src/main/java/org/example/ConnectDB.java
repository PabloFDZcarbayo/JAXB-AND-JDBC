package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class ConnectDB {

    /* IMPORTANT:
     * This class is used to connect to a local PostgreSQL database for example purposes.
     * Please ensure you update the URL, user, and password to match your system's configuration.
     */
    private static final String url = "jdbc:postgresql://localhost:5432/Clase";
    private static final String user = "postgres";
    private static final String password = "1234";


    public static Connection getConnection() {
        try {
            Connection connection = DriverManager.getConnection(url, user, password);
            String sqlQuery = "CREATE TABLE   IF NOT EXISTS alumnos (id SERIAL PRIMARY KEY, nombre VARCHAR(255), apellido VARCHAR(255), curso VARCHAR(255), dni VARCHAR(255) UNIQUE);";
            Statement st = connection.createStatement();
            st.execute(sqlQuery);
            return connection;
        } catch (Exception e) {
            System.out.println("Error de conexion");
            return null;
        }
    }
}

