package es.daw.ficheros.file;

import java.io.File;

/**
 *
 * @author melola
 */
public class B_TiposFicheros {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        File f = new File (".");
        
        if (f.isFile())
            System.out.println("Es un fichero");
        else if (f.isDirectory())
            System.out.println("Es un directorio");
        else
            System.out.println("Ni es fichero ni directorio");
        
    }
    
}
