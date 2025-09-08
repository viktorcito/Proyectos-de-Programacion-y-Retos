/**
 * Practicando con FileWriter.
 * Flujo de salida de caracteres.
 * Flujo que permite escribir en un fichero carácter a carácter.
 */
package es.daw.caracteres.file;

import java.io.FileWriter;
import java.io.IOException;


public class EjemploFileWriter {

    /**
     * @param args
     */
    public static void main(String[] args) {

        // ----------------------------------
        // FORMA TRADICIONAL
        
        FileWriter fw = null;
        String intro = "En un lugar de La Mancha, de cuyo nombre no quiero acordarme";

        // La estructura del flujo es la misa: en try creamos y recorremos, excepciones y cerrar flujo...
        try {
            fw = new FileWriter("introquijote.txt"); //equivalente a FileOutPutStream...
            // Escribe letra a letra. Entero que representa un carácter (no un byte)
            for (char c : intro.toCharArray()) {
                fw.write(c);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fw != null){
                try {
                    fw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        
        // ---------------------------------
        // try catch with resources.....
        /*
        try-with-resources es uno de los varios try declaraciones en Java, 
        destinadas a liberar a los desarrolladores de la obligación de liberar los recursos 
        utilizados en un try bloquear
        */
        try (FileWriter fw2 = new FileWriter("introquijote2.txt")){
            for (char c : intro.toCharArray()) {
                fw2.write(c);
            }
            
        }catch(IOException e){
            e.printStackTrace();
        }
        // ---------------------------------

    }

}
