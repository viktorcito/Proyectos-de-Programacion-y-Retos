package es.daw.web.util;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;

public class Utils {

	public static void printRequestParameters(Map<String,String[]> propiedades) {
		
		for (String key: propiedades.keySet()) {
			String[] values = propiedades.get(key);
			System.out.printf("%s %s %n",key,Arrays.toString(values));
		}
		
		/*for(Entry<String,String[]> entrada: propiedades.entrySet()) {
			for (String valor: entrada.getValue()) {
				System.out.println(valor);
			}
		}*/
		
	}
	
	public static <K,V> void printMap(Map<K,V> map) {
		System.out.println("************ "+map.size()+"*********");
		map.forEach( (k,v) -> {
			System.out.println("\tkey: "+k);
			System.out.println("\tvalue: "+v);
		});
	}
	
	public static void createPropertiesFile(Map<String,String[]> propiedades, String rutaFichero) throws IOException {
		Path pathProp = Paths.get(rutaFichero);
		
		if (Files.notExists(pathProp)) {
			Files.createFile(pathProp);
		}
		
		Properties props = new Properties(); 
		
		for (String key: propiedades.keySet()) {
			String[] values = propiedades.get(key);
			
			if (values.length == 1)
				props.put(key, values[0]);
			else
				props.put(key, Arrays.toString(values));
			
			try(OutputStream os = Files.newOutputStream(pathProp)){
				props.store(os, "Archivo de propiedades web");
			}
		}
	}
	
	
	
	
	
	
	
	
	
	
}
