/**
 *
 */
package es.daw.ficheros.files;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class C_CrearLeer {

    /**
     * @param args
     */
    public static void main(String[] args) {

        try {
            Path p = Paths.get("files", "quijote.txt");
            Path p2 = Paths.get("files", "quijote2.txt");
            
            if (Files.exists(p)) {

                BufferedWriter bw = Files.newBufferedWriter(p2, Charset.forName("UTF-8"));
                
                /*
                    // Forma tradicional
                    bw = new BufferedWriter(new FileWriter("quijote.txt"));
                    for (String s : quijote) {
                        bw.write(s);
                        bw.newLine(); //salto de línea
                    }
                
                */

                //El Charset del fichero debe ser UTF-8
                //Recomendados para ficheros no muy grandes porque si no cargaríamos la memoria
                //Me ahorro hacer el new FileWriter
                List<String> lineas = Files.readAllLines(p);
                // Con el método forEcah podemos crear un consumidor que se ejecute por cada elemento que hay en el ArrayList
                // Este consumidor es una interface funcional y por tanto acepta funciones lambda o una referencia a un método.
                lineas.forEach((s) -> {
                    try {
                        bw.write(s);
                        bw.newLine();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    System.out.println(s);
                });

                bw.close();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
