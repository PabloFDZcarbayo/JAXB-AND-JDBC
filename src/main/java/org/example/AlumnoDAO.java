package org.example;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AlumnoDAO {

    private static Connection connection;

    public AlumnoDAO(){
        connection = ConnectDB.getConnection();
    }

    public void InsertData(Alumno alumno) {
        String sqlQuery = "INSERT INTO Alumnos (nombre, apellido, curso, dni) VALUES (?, ?, ?, ?)";
        try {
            assert connection != null;
            PreparedStatement pStatement = connection.prepareStatement(sqlQuery);
            pStatement.setString(1, alumno.getNombre());
            pStatement.setString(2, alumno.getApellido());
            pStatement.setString(3, alumno.getCurso());
            pStatement.setString(4, alumno.getDni());
            pStatement.executeUpdate();


        } catch (SQLException e) {
            String check = "SELECT dni FROM Alumnos WHERE dni = ?";
            try {
                PreparedStatement pStatement = connection.prepareStatement(check);
                pStatement.setString(1, alumno.getDni());
                ResultSet rs = pStatement.executeQuery();
                if (rs.next()) {
                    System.out.println("Error de insercion -> DNI repetido: "+alumno.getDni());
                }

            } catch  (SQLException ex) {;
                System.out.println("Error de insercion no identificado");
            }


        }
    }
    public  List<Alumno> ReadData() {
        String sqlQuery = "SELECT * FROM Alumnos;";
            List<Alumno> alumnos = new ArrayList<Alumno>();
        try {
            assert connection != null;
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(sqlQuery);
            while (rs.next()) {
                Alumno alumno = new Alumno ();
                alumno.setNombre(rs.getString("nombre"));
                alumno.setApellido(rs.getString("apellido"));
                alumno.setCurso(rs.getString("curso"));
                alumno.setDni(rs.getString("dni"));
                alumnos.add(alumno);

            }
        } catch (Exception e) {
            System.out.println("Error de lectura");

        }
        return alumnos;
    }
}

