package es.daw.enumeradoprogramadores.util;

import static es.daw.enumeradoprogramadores.EnumeradoProgramadores.sc;
import es.daw.enumeradoprogramadores.model.Lenguajes;
import es.daw.enumeradoprogramadores.model.Programador;
import java.util.ArrayList;

/**
 *
 * @author melol
 */
public class Utilidades {

    public static void pintaMenu() {

        System.out.println("************** MENÚ PRINCIPAL ***************");
        System.out.println("1.- Dar de alta un programador");
        System.out.println("2.- Consultar información de programador (por DNI)");
        System.out.println("3.- Consultar información de todos los programadores");
        System.out.println("4.- Eliminar un programador de la lista (por DNI)");
        System.out.println("5.- Número total de programadores expertos en un lenguaje concreto");
        System.out.println("6.- Salir");
        System.out.println("-------------------------------------------------------------------");
        System.out.println("Elige una opción:");

    }

    /**
     * OPCIÓN 1 DEL MENÚ
     * Dar de alta un programador
     * @param programadores 
     */
    public static void darProgramadorAlta(ArrayList<Programador> programadores){
        System.out.println("Vas a dar de alta un nuevo programador:");
        System.out.println("1. Escribe el DNI");
        String dni = sc.nextLine();
        System.out.println("2. Escribe el nombre:");
        String nombre = sc.nextLine();
        System.out.println("3. Escribe la edad:");
        int edad = sc.nextInt();
        sc.nextLine();
        System.out.println("4. Escribe el lenguaje de programación. \n Estos son los posibles lenguajes:");

        // -------------- pintar los nombres de los lenguajes de programación ---
        Lenguajes[] lenguajes = Lenguajes.values();

        for (int i = 0; i < lenguajes.length; i++) {
            Lenguajes l = lenguajes[i];
            System.out.println(l.name());
        }
        System.out.println("----------------------------");
        
        Lenguajes leng = null;
        
        // -------------------------------
        try{
            
            leng = Lenguajes.valueOf(sc.nextLine());

        }catch(java.lang.IllegalArgumentException e){
            System.out.println("he capturado una excepción!!!!!!");
            e.printStackTrace();
            
        }
        // -----------------------------

        System.out.println("5. Escribe los años de experiencia:");
        int anios = sc.nextInt();

        Programador p = new Programador(dni, nombre, edad, leng, anios);

        programadores.add(p);

    }
    
    /**
     * OPCIÓN 2 DEL MENÚ
     * Consultar información de programador (por DNI)
     * @param programadores
     * @return 
     */
    public static String consultarProgramadorById(ArrayList<Programador> programadores){
        String info = "";
        
        int posicion = getPosicionProgramadorEnLista(programadores);
        if ( posicion != -1)
            info=programadores.get(posicion).toString();
        else
            info="No existe el programador";
        
        return info;
        
    }

    /**
     * Método que devuelve la posción del programador en la lista
     * @param programadores
     * @return 
     */
    private static int getPosicionProgramadorEnLista(ArrayList<Programador> programadores){
        System.out.println("Indica el DNI del programador:");
        String dni = sc.nextLine();
        
        Programador p = new Programador(dni);
        return programadores.indexOf(p);

        
    }
    /**
     * OPCIÓN 3 DEL MENÚ
     * Eliminar un programador de la lista (por DNI)
     */
    public static void eliminarProgramadorById(ArrayList<Programador> programadores){
        int posicion = getPosicionProgramadorEnLista(programadores);
        if ( posicion != -1){
            programadores.remove(posicion).toString();
            System.out.println("Programador borrado");
        }
        else
            System.out.println("No existe el programador");
        
    }
                    
    public static Lenguajes getListadoLenguajes() {
        // -------------------------------------------------
        // Elegir el lenguaje de programación y que se muestre el número total de programadores expertos en el lenguaje
        // y un informe de los programadores
        // 1. Recorro el tipo enumerado para que el usuario elija la opción y obtener el lenguaje (objeto de un class Enum)
        boolean correcto = true;
        Lenguajes lenguajeConsultar = Lenguajes.C; //Valor por defecto
        do {
            Lenguajes[] lenguajes = Lenguajes.values();
            for (int i = 0; i < lenguajes.length; i++) {
                Lenguajes l = lenguajes[i];
                System.out.println((i + 1) + " - " + l.name());
            }
            System.out.println("Elige el número del lenguaje: ");
            int posicionLenguaje = sc.nextInt();

            switch (posicionLenguaje) {
                case 1:
                    lenguajeConsultar = Lenguajes.JAVA;
                    break;
                case 2:
                    lenguajeConsultar = Lenguajes.PHP;
                    break;
                case 3:
                    lenguajeConsultar = Lenguajes.C;
                    break;
                case 4:
                    lenguajeConsultar = Lenguajes.PERL;
                    break;
                case 5:
                    lenguajeConsultar = Lenguajes.RUBY;
                    break;
                case 6:
                    lenguajeConsultar = Lenguajes.PYTHON;
                    break;
                default:
                    System.out.println("Has introducido un número de opción incorrecta");
                    correcto = false;
            }
        } while (!correcto);

        return lenguajeConsultar;
    }

    /**
     * Método que obtiene el número de programadores expertos de un lenguaje concreto
     * @param programadores
     * @param lenguajeConsultar
     * @return 
     */
    public static int getNumProgsExpByLeng(ArrayList<Programador> programadores, Lenguajes lenguajeConsultar) {
        int contExpertos = 0;
        for (Programador p : programadores) {

            if (p.getLenguaje() == lenguajeConsultar) {
                if (p.getAniosExperiencia() >= lenguajeConsultar.getAniosAprendizaje()) {
                    contExpertos++;
                }
            }
        }
        return contExpertos;
    }
}
