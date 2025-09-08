/**
 *
 */
package es.daw.ficheros.files;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;


public class B_CopiarBorrarMover {

    
    // OJO!!!!!! QUITAR LA PROPAGACIÓN DE LA EXCEPCIÓN DEL MAIN Y AJUSTAR EL CÓDIGO
    public static void main(String[] args) throws IOException {

        //Creamos una ruta para crear un fichero
        Path p = Paths.get("files", "fichero.txt");

        //Creamos un fichero, y abrimos el flujo de texto para escribir
        //Compararlo con la forma tradicional que hemos visto antes (proyecto EJEMPLOS_flujoSalida/EjemploBufferedWriter
        BufferedWriter bw = Files.newBufferedWriter(p);
        bw.write("Aprendiendo a usar java.nio en el módulo de Programación de DAW");
        bw.close();

        //Copiamos el fichero
        Path copia = Paths.get("files", "fichero_copiado.txt");
        Files.copy(p, copia, StandardCopyOption.REPLACE_EXISTING); //3 opciones REPLACE_EXISTING, ATOMIC_MOVE (evita problemas de sincronización), COPY_ATTRIBUTES (fich destino mismos atributos que fichero origen)
        
        //Lo movemos fuera del directorio
        Files.move(copia, Paths.get("files", "copiado.txt"), StandardCopyOption.REPLACE_EXISTING);

        //Lo eliminamos
        Files.deleteIfExists(Paths.get("files", "copiado.txt"));

    }

}
