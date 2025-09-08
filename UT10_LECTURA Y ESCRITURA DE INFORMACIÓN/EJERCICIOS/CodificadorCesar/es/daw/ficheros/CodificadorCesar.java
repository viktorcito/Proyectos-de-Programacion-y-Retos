package es.daw.ficheros;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class CodificadorCesar {
    
    /**
     * @param args
     */
    public static void main(String[] args) {

        final int OFFSET = 3; //desplazamiento

        BufferedReader br = null;
        BufferedWriter bw = null;
        
        try {
            
            escribirTextoFalso();
            
            br = new BufferedReader(new FileReader("mensaje.txt"));
            
            bw = new BufferedWriter(new FileWriter("mensaje_cifrado.txt"));

            String linea = null;

            while ((linea = br.readLine()) != null) { //devuelve la cadena de caracteres (línea) 
                                                        //y cuando no quedan más datos devuelve null
                StringBuilder sb = new StringBuilder(linea.length());
                
                //Recorremos la línea ....
                
                // PENDIENTE COMPLETAR!!!!
                
                bw.write(sb.toString());
                bw.newLine();

            }
            System.out.println("El mensaje ha sido cifrado correctamente");
            
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (bw != null) {
                try {
                    bw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    /**
     * Escribe texto falso con Files.write
     * @throws IOException 
     */
    public static void escribirTextoFalso() throws IOException{
        String texto = "MI TEXTO DE PRUEBA Y CON FILES.WRITE";

        Path path_mensaje = Paths.get("mensaje.txt");
        if (Files.notExists(path_mensaje)) Files.createFile(path_mensaje);
        Files.write(path_mensaje, texto.getBytes(StandardCharsets.UTF_8),StandardOpenOption.APPEND);  
    }
    
   /**
     * Escribe texto falso con BufferedWriter
     * BufferWriter, donde usamos el método write que te permite escribir cadenas o arreglos de caracteres
     * @param path
     * @throws IOException
     */
    public static void escribirTextoFalso(Path path) throws IOException {
        // Podemos indicar opciones a la hora de abrir el fichero
        //try ( BufferedWriter br = Files.newBufferedWriter(path,
        //        Charset.defaultCharset(), StandardOpenOption.CREATE)) {
        try ( BufferedWriter br = Files.newBufferedWriter(path,Charset.defaultCharset() )) {
            br.write("ESTE ES MI TEXTO DE PRUEBA Y CHIMPUN");
            br.newLine();
        }
    }

    /**
     * Escribe texto falso con PrintWriter
     * Te permite hacer más o menos lo mismo, pero de una forma más resumida y con la posibilidad de escribir otros tipos de datos sobre el archivo.
     * El trabajo de escritura se hace con el método println, que permite escribir otros tipos de datos como enteros, de punto flotante, booleanos y caracteres
     * @param fileName
     * @param encoding
     * @throws IOException 
     */
    public static void escribirTextoFalso(String fileName, String encoding) throws IOException{
        try (PrintWriter writer = new PrintWriter(fileName, encoding)) {
            writer.println("CON PRINTWRITER MI TEXTO DE PRUEBA Y CHIMPUN");
        }
    }    

}
