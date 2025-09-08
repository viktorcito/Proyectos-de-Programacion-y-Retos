/**
 * Practicando con FileInputStream y FileOutputString 
 * Practicando con BufferedInputStream y BufferedInputStream
 * Combinación de ambos flujos
 * Flujo de entrada/salida de bytes
 * Flujo que permite leer/escribir grupos(buffers) de bytes para escribir/leer en un fichero en disco
 */
package es.daw.bytes.buffered;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Leer fichero y copiar fichero
 */
public class CopyBytes {

    /**
     * @param args
     */
    public static void main(String[] args) {

        /*
        // Para pasar los ficheros por argumento
        if (args.length != 2) {
            System.err.println("Error de sintaxis. Se necesitan dos argumentos");
            return;
        }
        */

        // try...catch tradicional: es necesario crear las clases inicializadas a null. Luego se instancian dentro del try
        // y finalmente se cierran en el finally
        
        //BufferedInputStream bin = null;
        //BufferedOutputStream bout = null;

        final int TAM = 1024 * 16; //15 kbytes de información cada bloque

        
        
        //try...catch con varios recursos
        try(BufferedInputStream bin = new BufferedInputStream(new FileInputStream("openwebinars.jpg"));
                BufferedOutputStream bout = new BufferedOutputStream(new FileOutputStream("image_copy.jpg"));){
        
        //try {
            //bin = new BufferedInputStream(new FileInputStream("openwebinars.jpg"));
            //bout = new BufferedOutputStream(new FileOutputStream("image_copy.jpg"));
            
            //bin = new BufferedInputStream(new FileInputStream(args[0]));
            //bout = new BufferedOutputStream(new FileOutputStream(args[1]));

            int cantidadBytes = 0;
            byte[] buffer = new byte[TAM];

            //TAM:expectativa
            //cantidadBytes: la espectativa: la última será menor salvo que el tamaño del fichero sea múltiplo del tamaño del buffer
            //En el caso de que sea -1 hemos terminado de leer....
            //Al leer metemos los datos en el buffer, desde la posición 0 y esperamos leer hasta posición TAM...
            while ((cantidadBytes = bin.read(buffer, 0, TAM)) != -1) {
                bout.write(buffer, 0, cantidadBytes); //desde posición 0 hasta cantidadBytes.... para que valga en todas las operaciones y la última
            }

            System.out.println("El fichero se ha copiado "
                    + "");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } /*finally {
            if (bin != null){
                try {
                    bin.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (bout != null){
                try {
                    bout.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }*/

    }

}
