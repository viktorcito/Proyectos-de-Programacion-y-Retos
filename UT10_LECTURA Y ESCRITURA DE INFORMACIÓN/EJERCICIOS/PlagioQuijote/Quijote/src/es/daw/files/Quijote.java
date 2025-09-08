package es.daw.files;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;


public class Quijote {
	
	static final String COPYRIGTH = "'ESTA ES UNA COPIA PERMITIDA DEL QUIJOTE'";

    /**
     * @param args
     */
    public static void main(String[] args) {

        // RUTAS A LOS FICHEROS
        // Ruta al fichero de texto original
        Path pathOriginal = Paths.get("original", "quijote.txt");

        // Ruta al fichero de texto donde hacer una copia
        Path pathCopia = Paths.get("copia", "quijote_copia.txt");

        try {
            copiarQuijote(pathOriginal, pathCopia);
            System.out.println("[INFO] Quijote plagiado ...");
            
            addCopyRight(pathCopia);
            System.out.println("[INFO] Quijote con copyright...");
            
            printCopiaQuijote(pathCopia);

        } catch (IOException ex) {
            ex.printStackTrace();
            System.err.println(ex.getMessage());
        }

    }

    /**
     * 
     * @param pathOriginal
     * @param pathCopia
     * @throws IOException 
     */
    private static void copiarQuijote(Path pathOriginal, Path pathCopia) throws IOException {
        
        // Si el fichero original no existe se crea uno
    	if (Files.notExists(pathOriginal)) {
    		System.err.println("[ERROR] El fichero original del Quijote no "
                    + "existe en la ruta: " + pathOriginal.toString());    		
    		crearQuijoteOriginal(pathOriginal);
    		
    		System.out.println("[INFO] Creado el fichero original del Quijote...");
            
            copiarQuijote(pathOriginal,pathCopia);
    		
    	}
    	else {
    		// Si existe nos ponemos a plagiar
    		if(Files.notExists(pathCopia.getParent())) {
    			// Si el directorio copia no existe se crea
    			Files.createDirectory(pathCopia.getParent());
    			Files.createFile(pathCopia);
    		}else {
    			// Si el fichero copia existe se borra
    			Files.delete(pathCopia);
    			//Files.delete(pathCopia.getParent()); //No hace falta borrar el directorio padre
    		}
    		
    		//BufferedWriter bw = new BufferedWriter(new FileWriter("copia"+File.separator+"quijote_plagio.txt"));
    		
    		try (BufferedWriter bw = Files.newBufferedWriter(pathCopia, Charset.forName("UTF-8"),StandardOpenOption.CREATE);
    				BufferedReader br = Files.newBufferedReader(pathOriginal)){
    			
    			String linea = br.readLine();
    			do {
    				bw.write(linea);
    				linea = br.readLine();
    				bw.newLine();
    			}while (linea != null);
    		}
    	}
        
        
        

    }

    
    /**
     * Si el fichero original no existe se crea uno
     * @param pathOriginal
     * @throws IOException 
     */
    private static void crearQuijoteOriginal(Path pathOriginal) throws IOException {

        String texto = "En un lugar de la Mancha, de cuyo nombre no quiero acordarme, no ha mucho tiempo que vivía un hidalgo de los de lanza en astillero, adarga antigua, rocín flaco y galgo corredor. \n"
                + "Una olla de algo más vaca que carnero, salpicón las más noches, duelos y quebrantos los sábados, lentejas los viernes, algún palomino de añadidura los domingos, consumían las tres partes de su hacienda. \n"
                + "El resto della concluían sayo de velarte, calzas de velludo para las fiestas con sus pantuflos de lo mismo, los días de entre semana se honraba con su vellori de lo más fino.\n";
        
       if (Files.notExists(pathOriginal.getParent()) )
    		   Files.createDirectory(pathOriginal.getParent());
       
    	//Files.createFile(pathOriginal); // No hace falta crear el fichero original
       
       try(BufferedWriter bw = Files.newBufferedWriter(pathOriginal, Charset.forName("UTF-8"))){
    	   bw.write(texto);
    	   bw.newLine();
       }

    }

    /**
     * Método para añadir al final del fichero de texto la frase copyrigth
     *
     * @param copyright
     * @param destino
     * @throws IOException
     */
    private static void addCopyRight(Path destino) throws IOException {
        // FORMA O: sin clase Files!!!!!!!!!
        /*
        try(BufferedWriter bw = new BufferedWriter(new FileWriter("copia"+File.separator+"quijote_copia.txt",true))){
            bw.append(copyright);
            bw.newLine(); //salto de línea
        }
        
         */
    	
        // FORMA 1: Creando BufferedWriter con java.nio.Files
        /*try(BufferedWriter bw = Files.newBufferedWriter(destino, 
                Charset.forName("UTF-8"),StandardOpenOption.APPEND)){
            bw.write(copyright);
        }*/
    	
        // FORMA 2: Con FileWriter
        // `true` agregará los nuevos datos
        /*try(FileWriter fw = new FileWriter("copia"+File.separator+"quijote_copia.txt", true))
        {
            fw.write(copyright);
        } */
    	
        // FORMA 3: con Files.write. Recomendada!!!!!!!!!!!
        //Files.write(destino, copyright.getBytes(), StandardOpenOption.APPEND);
        // El código anterior arroja java.nio.file.NoSuchFileException si el archivo de destino no existe
    	
        Files.write(destino,
                COPYRIGTH.getBytes(),
                StandardOpenOption.APPEND,
                StandardOpenOption.CREATE
        );
    }

    /**
     * Método que pinta por consola el contenido del fichero pasado como
     * argumento
     *
     * @param destino
     * @throws IOException
     */
    private static void printCopiaQuijote(Path destino) throws IOException {
        System.out.println("*********** CONTENIDO DEL PLAGIO DEL QUIJOTE ***********");
        
        // Con Files.readAllLines
        List<String> lineas = Files.readAllLines(destino);
        for(String linea: lineas){
            System.out.println(linea);
        }
        
        
        // Con Files.newBufferedReader
        /*try ( BufferedReader br = Files.newBufferedReader(destino)) {
            String linea = null;
            while ((linea = br.readLine()) != null) {
                System.out.println(linea);
            }
        }*/
        
        System.out.println("********************************************************");

    }
    	


