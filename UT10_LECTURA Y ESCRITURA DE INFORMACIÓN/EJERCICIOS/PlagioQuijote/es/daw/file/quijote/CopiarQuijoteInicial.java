package es.daw.file.quijote;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 * https://github.com/profeMelola/Programacion_2022-23/tree/main/UT10_LECTURA%20Y%20ESCRITURA%20DE%20INFORMACI%C3%93N/EJERCICIOS/PlagioQuijote
 */
public class CopiarQuijoteInicial {
    static String COPYRIGTH = "'ESTA ES UNA COPIA PERMITIDA DEL QUIJOTE'";

    /**
     * @param args
     */
    public static void main(String[] args) {

        // RUTAS A LOS FICHEROS
        // Ruta al fichero de texto original
        Path pathOriginal = Paths.get("original", "quijote.txt");

        // Ruta al fichero de texto donde hacer una copia
        Path pathCopia = Paths.get("copia", "quijote_copia.txt");

        try {
            copiarQuijote(pathOriginal, pathCopia);
            System.out.println("[INFO] Quijote plagiado ...");
            
            addCopyRight(pathCopia);
            System.out.println("[INFO] Quijote con copyright...");

        } catch (IOException ex) {
            ex.printStackTrace();
            System.err.println(ex.getMessage());
        }

    }

    /**
     * 
     * @param pathOriginal
     * @param pathCopia
     * @throws IOException 
     */
    private static void copiarQuijote(Path pathOriginal, Path pathCopia) throws IOException {
        
        // Si el fichero original no existe se crea uno
        
        // Si el fichero copia existe se borra
        
        // Si el directorio copia no existe se crea
        
        

    }

    
    /**
     * Si el fichero original no existe se crea uno
     * @param pathOriginal
     * @throws IOException 
     */
    private static void crearQuijoteOriginal(Path pathOriginal) throws IOException {

        /*List<String> quijote = Arrays.asList(new String[]{"En un lugar de la Mancha,",
            "de cuyo nombre no quiero acordarme,", "no ha mucho tiempo que vivía un hidalgo",
            "de los de lanza en astillero,", "adarga antigua, rocín flaco y galgo corredor."});*/
        String texto = "En un lugar de la Mancha, de cuyo nombre no quiero acordarme, no ha mucho tiempo que vivía un hidalgo de los de lanza en astillero, adarga antigua, rocín flaco y galgo corredor. \n"
                + "Una olla de algo más vaca que carnero, salpicón las más noches, duelos y quebrantos los sábados, lentejas los viernes, algún palomino de añadidura los domingos, consumían las tres partes de su hacienda. \n"
                + "El resto della concluían sayo de velarte, calzas de velludo para las fiestas con sus pantuflos de lo mismo, los días de entre semana se honraba con su vellori de lo más fino.\n";

    }

    /**
     * Método para añadir al final del fichero de texto la frase copyrigth
     *
     * @param copyright
     * @param destino
     * @throws IOException
     */
    private static void addCopyRight(Path destino) throws IOException {


    }

    /**
     * Método que pinta por consola el contenido del fichero pasado como
     * argumento
     *
     * @param destino
     * @throws IOException
     */
    private static void printCopiaQuijote(Path destino) throws IOException {
        System.out.println("*********** CONTENIDO DEL PLAGIO DEL QUIJOTE ***********");

        
        System.out.println("********************************************************");

    }
    
}
