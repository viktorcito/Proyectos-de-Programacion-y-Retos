package es.daw.web.agendaWEB.util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import es.daw.web.agendaWEB.model.Persona;

public class UtilCSV {
	
	public static void loadCSV(String pathFileCSV,Map<String,Persona> agenda) throws IOException {
		
		Path pathCSV = Paths.get(pathFileCSV);
		
//		Path pathCSV2 = Paths.get("recursos","agenda","agenda.csv");
		
		// Con Files.readAllLines
        List<String> lineas = Files.readAllLines(pathCSV);
        String[] datos = new String[5];
        for(int i = 1; i< lineas.size();i++) {
        	System.out.println(lineas.get(i));
        	datos = lineas.get(i).split(";");
        	System.out.println(Arrays.toString(datos));
        	agenda.put(datos[0],new Persona(datos[1],datos[2],datos[3],LocalDate.parse(datos[4])));
        }
	}

}
