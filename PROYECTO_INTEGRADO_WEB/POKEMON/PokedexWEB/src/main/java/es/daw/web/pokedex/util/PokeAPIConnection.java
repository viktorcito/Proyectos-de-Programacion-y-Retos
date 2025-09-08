package es.daw.web.pokedex.util;

import java.net.MalformedURLException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.io.*;
import java.net.*;

public class PokeAPIConnection {
	
	public static void connect(String nombre, String pathJson) throws MalformedURLException, IOException {
		
		String urlString="https://pokeapi.co/api/v2/pokemon/";
		urlString += nombre;
		
		System.out.println("[PokeAPIConnection] urlString:"+urlString);
		
		URL url = new URL(urlString); 
		
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		connection.setRequestMethod("GET");
		connection.setRequestProperty("Accept", "application/json");
		
		Path pJson = Paths.get(pathJson);
		
		// --------------------------- EN BINARIO -----------------------
		/*try(
				InputStream inputStream = connection.getInputStream();
				FileOutputStream outputStream = new FileOutputStream(PATH_JSON);
				
				){
	        byte[] buffer = new byte[4096];
	        int bytesRead = -1;
	        while ((bytesRead = inputStream.read(buffer)) != -1) {
	            outputStream.write(buffer, 0, bytesRead);
	        }
		}*/
		//---------------------
		
		try(
				BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
				BufferedWriter json = Files.newBufferedWriter(pJson, Charset.forName("UTF-8"), StandardOpenOption.CREATE)
				)
		{
			String linea;
			while ( (linea = reader.readLine()) != null) {
				json.write(linea);
				json.newLine();
			}
		}
	}

}
