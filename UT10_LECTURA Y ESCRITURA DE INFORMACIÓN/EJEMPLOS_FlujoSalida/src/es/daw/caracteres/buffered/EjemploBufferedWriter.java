/**
 * Practicando con BufferedWriter.
 * Flujo de salida de caracteres.
 * Flujo que permite escribir líneas de texto.
 * Lo utilizamos en combinación don FileWriter para escribir en un fichero en disco
 */
package es.daw.caracteres.buffered;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class EjemploBufferedWriter {

    /**
     * @param args
     */
    public static void main(String[] args) {

        BufferedWriter bw = null;

        List<String> quijote = Arrays.asList(new String[]{"En un lugar de la Mancha,",
            "de cuyo nombre no quiero acordarme,", "no ha mucho tiempo que vivía un hidalgo",
            "de los de lanza en astillero,", "adarga antigua, rocín flaco y galgo corredor."});

        try {
            bw = new BufferedWriter(new FileWriter("quijote.txt"));
            for (String s : quijote) {
                bw.write(s);
                bw.newLine(); //salto de línea
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bw != null){
                try {
                    bw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

}
