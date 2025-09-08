package es.daw.ficheros.file;


import java.io.*;

public class D_CreaDir {

    public static void main(String[] args) {
        
        
        File pathInicial = new File("data");
        
        File subdir = new File(pathInicial,"NUEVODIR");
        
        File f1 = new File(subdir, "FICHERO1.TXT");
        
        File f2 = new File(subdir, "FICHERO2.TXT");
        
        File z = null;
        
        //CREAR DIRECTORIOS
        if (pathInicial.mkdir()){
            if (subdir.mkdir()) {
                System.out.println("SE HA CREADO EL DIRECTORIO A PARTIR DEL ACTUAL"); //directorio que creo a partir del actual
            } else {
                System.out.println("NO SE HA CREADO EL DIRECTORIO");
            }
        }else
            System.out.println("No se ha podido crear el directorio data!!!!!!!!!!!!");
        
        //CREAR FICHEROS DENTRO DEL DIRECTORIO
        try {
            
            // si el fichero existe, simplemente no te lo crea, no propaga excepción
            //f1.createNewFile(); 
            
            if (!f1.exists()){
                if (f1.createNewFile())
                        System.out.println("FICHERO1 creado correctamente...");
                    else
                        System.out.println("No se ha podido crear FICHERO1...");
                
            }
            else
                System.out.println("El fichero ya existe");
            
            if (f2.createNewFile()) {
                System.out.println("FICHERO2 creado correctamente...");
            } else {
                System.out.println("No se ha podido crear FICHERO2...");
            }
            
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        
        //RENOMBRAR FICHEROS
        if (f1.renameTo(new File(subdir, "FICHERO1NUEVO")));//renombro FICHERO1
        
        //f2.renameTo(z);//renombro FICHERO1; //Esto da un NullpointerException

        try {
            File f3 = new File(pathInicial+File.separator+"NUEVODIR"+File.separator+"FICHERO3.TXT");
            f3.createNewFile();//crea FICHERO3 en NUEVODIR
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
}
