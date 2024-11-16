package org.example;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.Unmarshaller;

import java.io.File;

public class JAXB {

    private static String FILE_PATH = "src/main/java/Archivos XML/Alumnos.xml";

    public static void readXML(AlumnoDAO alumnoDAO) {
        File data = new File(FILE_PATH);
        try {
            //Crear el contexto y leer el XML
            JAXBContext context = JAXBContext.newInstance(Alumnos.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            Alumnos alumnos = (Alumnos) unmarshaller.unmarshal(data);

            for (Alumno alumno : alumnos.getAlumnos()) {
                alumnoDAO.InsertData(alumno);
            }
        } catch (Exception e){
            e.printStackTrace();
           ;
        }
    }
}
