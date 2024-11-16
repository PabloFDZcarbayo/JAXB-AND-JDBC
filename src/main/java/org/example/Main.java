package org.example;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        AlumnoDAO alumnoDAO = new AlumnoDAO();
        JAXB.readXML(alumnoDAO);
        List<Alumno> alumnos = alumnoDAO.ReadData();
        printData(alumnos);

    }

    private  static void printData(List<Alumno> alumnos) {
        for (Alumno alumno : alumnos) {
            System.out.println("Nombre: " + alumno.getNombre());
            System.out.println("Apellido: " + alumno.getApellido());
            System.out.println("Curso: " + alumno.getCurso());
            System.out.println("DNI: " +  alumno.getDni());
            System.out.println("-------------");
            System.out.println();
        }
    }
}