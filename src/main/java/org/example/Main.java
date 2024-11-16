package org.example;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        AlumnoDAO alumnoDAO = new AlumnoDAO();
        JAXB.readXML(alumnoDAO);
        List<Alumno> alumnos;


        Alumno alumno1 = new Alumno("Jose", "Perez", "DAM", "13990456L");
        Alumno alumno2 = new Alumno("Juan Carlos", "Ramirez", "DAW", "13429364Z");
        alumnoDAO.InsertData(alumno1);
        alumnoDAO.InsertData(alumno2);

        alumnos = alumnoDAO.ReadData();


        printData(alumnos);


    }

    private static void printData(List<Alumno> alumnos) {
        for (Alumno alumno : alumnos) {
            System.out.println("Nombre: " + alumno.getNombre());
            System.out.println("Apellido: " + alumno.getApellido());
            System.out.println("Curso: " + alumno.getCurso());
            System.out.println("DNI: " + alumno.getDni());
            System.out.println("-------------");
            System.out.println();
        }
    }
}