/**
 * Practicando con FileInputStream
 * Flujo de entrada de bytes
 * Flujo que permite leer de un fichero byte a byte
 */
package es.daw.bytes.fileinput;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class EjemploFileInputStream {

    /**
     * @param args
     */
    public static void main(String[] args) {

        FileInputStream fIn = null;

        try {
            // Escribir fichero binario
            creaDat("primero.dat");
            
            //Path fichero = Paths.get("primero.dat");
            //if (Files.notExists(fichero)) Files.createFile(fichero);
            
            System.out.println("*********Leyendo el DAT***********");
            fIn = new FileInputStream("primero.dat");
            int c;
            while ((c = fIn.read()) != -1) { //hasta que lleguemos a final del fichero
                System.out.println(c);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fIn != null){
                try {
                    fIn.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    
    public static void creaDat(String nombreFich){
        OutputStream fOut = null;

        // try ... catch tradicional. En finally cierro el flujo
        try {
            // Aunque exista no hay problema, machaca el contenido....
            fOut = new FileOutputStream(nombreFich); //recibe ruta al fichero
            /*
             Java tiene el tipo byte y a la hora de escribir bytes lo hace come enteros.
             Solamente imprime la parte correspondiente a un byte (el menos significativo, el que tiene menos valor, el que está más a la derecha).
             Los otros bits del entero ( 24 bits), los descartaría.
             Incluso si queremos escribir enteros más largos no los tendría en cuenta.
             Solo se puede almacenar de 0 a 255 (2 ^8). Solo usa los 8 bits y el resto se desprecia.
            */
            System.out.println("*********Escribiendo en DAT***********");
            for (int i = 0; i < 100; i++) {
            //for (int i = 0; i < 1000; i++) {
                System.out.println(i);
                fOut.write(i); //Writes the specified byte to this file output stream (el byte menos significativo de int)
            }
            // Se va a escribir en binario... necesitamos 
            // Trabajar directamente con un flujo binario no aporta nada. No se usa...
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fOut != null){
		try {
                    fOut.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        
    }
}
