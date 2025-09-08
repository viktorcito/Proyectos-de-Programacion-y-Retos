package es.daw.ficheros.file;

import java.io.File;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author melola
 */
public class C_ListarDir {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        File f = new File("./");
        
        if (f.isDirectory()){
            
            //0. Array de String
            System.out.println("\n0.0. LS como un Array de String");
            
            String[] nombreFicheros = f.list();
            for (int i = 0; i < nombreFicheros.length; i++) {
                System.out.println(nombreFicheros[i]);
            }
            
            System.out.println("\n0.1. LS como un Array de String");
            for(String s: f.list()){
                System.out.println(s);
            }
            
            //1. List (colección dinámica de String)
            System.out.println("\n1.LS como una lista de String");
            List<String> lista = Arrays.asList(f.list());
            lista.forEach(System.out::println);
            
            //2. List con lambdas
            System.out.println("\n2.LS como una lista de String con lambdas");
            List<File> listaFicheros = Arrays.asList(f.listFiles());
            listaFicheros.forEach(fich -> System.out.println(fich.getName()));
            
            //3. List con STREAM
            System.out.println("\n3.LS con STREAM");
            // Encaminamiento, filtrar, reordenar, reducir, etc...
            listaFicheros.stream().map(File::getName).forEach(System.out::println);
                    
            
        }
        
        
        
    }
    
}
