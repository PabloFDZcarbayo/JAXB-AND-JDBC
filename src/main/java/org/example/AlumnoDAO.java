package org.example;

import java.sql.*;

public class AlumnoDAO {

    private static final Connection connection = ConnectDB.getConnection();


    public static void InsertData(Alumno alumno) {
        String sqlQuery = "INSERT INTO Alumnos (nombre, apellido, curso, dni) VALUES (?, ?, ?, ?)";
        try {
            assert connection != null;
            PreparedStatement pStatement = connection.prepareStatement(sqlQuery);
            pStatement.setString(1, alumno.getNombre());
            pStatement.setString(2, alumno.getApellido());
            pStatement.setString(3, alumno.getCurso());
            pStatement.setString(4, alumno.getDni());
            ResultSet rs = pStatement.executeQuery();

        } catch (SQLIntegrityConstraintViolationException e) {
            System.out.println("DNI repetido");

        } catch (Exception e) {
            System.out.println("Error de insercion: "+ e.getMessage());

        }
    }

    public static void ReadData() {
        String sqlQuery = "SELECT * FROM Alumnos;";
        try {
            assert connection != null;
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(sqlQuery);
            while (rs.next()) {
                System.out.println("Nombre: " + rs.getString("nombre"));
                System.out.println("Apellido: " + rs.getString("apellido"));
                System.out.println("Curso: " + rs.getString("curso"));
                System.out.println("DNI: " + rs.getString("dni"));
                System.out.println("-------------");
                System.out.println();
            }
        } catch (Exception e) {
            System.out.println("Error de lectura");

        }
    }
}
