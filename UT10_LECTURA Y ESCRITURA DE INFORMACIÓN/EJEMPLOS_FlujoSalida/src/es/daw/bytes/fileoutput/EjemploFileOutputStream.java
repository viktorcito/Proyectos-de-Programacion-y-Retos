/**
 * Practicando con FileOutputStream.
 * Flujo de salida de bytes.
 * Flujo que permite escribir esscribir en un fichero, byte a byte.
 */
package es.daw.bytes.fileoutput;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class EjemploFileOutputStream {

    /**
     * Escribir un conjunto de números enteros...
     * @param args
     */
    public static void main(String[] args) {

        OutputStream fOut = null;

        // try ... catch tradicional. En finally cierro el flujo
        try {
            fOut = new FileOutputStream("primero.dat"); //recibe ruta al fichero
            /*
             Java tiene el tipo byte y a la hora de escribir bytes lo hace como enteros.
             Solamente imprime la parte correspondiente a un byte. Los bits del entero ( 32 bits), los descartaría.
             Incluso si queremos escribir enteros más largos no los tendría en cuenta.
             Solo se puede almacenar de 0 a 255 (2 ^8). Solo usa los 8 bits y el resto se desprecia.
            */
            
            for (int i = 0; i < 1000; i++) {
                fOut.write(i);
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
