/**
 * Practicando con BufferedOutputStream.
 * Flujo de salida de bytes.
 * Flujo que permite escribir grupos (buffers) de bytes.
 * Lo utilizamos en combinación don FileOutputStream para escribir en un fichero en disco
 */
package es.daw.bytes.buffered;

import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;

public class EjemploBufferedOutputStream {

    /**
     * @param args
     */
    public static void main(String[] args) {

        // El tamaño del buffer depende.... muy pequeño, muy grande... depende del flujo de información que estéis leyendo
        // Mejor indicarlo en un fichero de propiedades...
        
        byte[] buffer = new byte[1024 * 32]; // de 32 kbytes
        Arrays.fill(buffer, Byte.parseByte("1"));
        BufferedOutputStream bos = null;
        try {
            // No se crea sobre un fichero directamente, sino sobre otro flujo.
            bos = new BufferedOutputStream(new FileOutputStream("buffered.dat"));
            bos.write(buffer); //de una atacada escribimos 32 kbytes...
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bos != null){
                try {
                    bos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

}
