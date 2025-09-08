/**
 * Practicando con ByteArrayOutputStream.
 * Flujo de salida de bytes.
 * Flujo que permite escribir en memoria, obteniendo lo escrito en un array de bytes
 * Lo utilizamos en combinación don FileOutputStream para escribir en un fichero en disco
 */
package es.daw.bytes.array;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;

public class EjemploByteArrayOutputStream {

    /**
     * @param args
     */
    public static void main(String[] args) {
        
        byte[] buffer = new byte[1024 * 32]; // tamaño de 32 KB
        
        Arrays.fill(buffer, Byte.parseByte("1"));
        
        //Flujo que trabaja en memoria. 
        //Leer un fichero completo en memoria y poder después trabajar con él.
        // Ejemplo: tratamiento de imágenes en Android, convertir jpg a png... se utilizan ByteArrays para ello
        ByteArrayOutputStream baos = null; 
                                            
        try {
            baos = new ByteArrayOutputStream();
            baos.write(buffer);
            System.out.println(baos.toByteArray().length);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (baos != null){
                try {
                    baos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

}
