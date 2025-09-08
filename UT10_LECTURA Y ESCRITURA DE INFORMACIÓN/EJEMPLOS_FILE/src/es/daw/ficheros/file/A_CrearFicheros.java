package es.daw.ficheros.file;

import java.io.File;
import java.io.IOException;

/**
 *
 * @author melola
 */
public class A_CrearFicheros {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        File f = new File("primer.txt");
        
        try {
            f.createNewFile();
            // Los ficheros temporales los borra el S.O según lo planificado
            File temp = File.createTempFile("temporal", ".tmp");
            
            System.out.println("Ruta completa del fichero temporal:"+temp.getAbsolutePath());
        } catch (IOException ex) {
            //Logger.getLogger(A_CrearFicheros.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
            System.out.println(ex.getMessage());
        }
        
        System.out.println("Fichero "+f.getName()+" creado.");
        
    }
    
}
