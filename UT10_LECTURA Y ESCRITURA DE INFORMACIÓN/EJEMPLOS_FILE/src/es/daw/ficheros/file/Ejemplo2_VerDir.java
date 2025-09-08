package es.daw.ficheros.file;


import java.io.*;

public class Ejemplo2_VerDir {

    public static void main(String[] args) {
        String dir = ".";
        File f = new File(dir);
        File[] listaficheros = f.listFiles();
        System.out.printf("Ficheros en el directorio actual: %d %n", listaficheros.length);
        for (int i = 0; i < listaficheros.length; i++) {
            System.out.printf("Nombre: %s, es fichero?: %b, es directorio?: %b %n",
                listaficheros[i].getName(), listaficheros[i].isFile(), listaficheros[i].isDirectory());
        }
    }
}
