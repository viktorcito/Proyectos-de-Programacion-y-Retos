/*
 * https://github.com/profeMelola/Programacion_2022-23/tree/main/UT06_UT07_POO/Herencia/3_Astros
 */
package es.daw.poo2.astros;

import es.daw.poo2.astros.model.Planeta;
import es.daw.poo2.astros.model.Astro;
import es.daw.poo2.astros.model.Satelite;
import java.util.ArrayList;
import java.util.Scanner;
/**
 *
 * @author melol
 */
public class Ej3_Astros {

    /**
     * @param args the command line arguments
     */
   public static void main(String args[]) {

        // Creamos una lista
        ArrayList<Astro> astros;
       astros = new ArrayList<>();
       
       //ArrayList<Planeta> planetas;
       //ArrayList<Satelite> satelites;

        // Instanciamos planetas
        Planeta tierra = new Planeta("Tierra", 5.97E24, 12742.0, 1.0, 365.25, 
                14.05, 9.78, 146600000.0);
        Planeta venus = new Planeta("Venus", 4.869E24, 12103.6, 243.02, 584.0, 
                463.85, 8.87, 108200000.0);
        Planeta marte = new Planeta("Marte", 6.42E23, 6794.4, 24.62, 686.97, 
                -46.0, 3.711, 227940000.0);

        
        // Instanciamos satélites
        Satelite luna = new Satelite("Luna", 7.349E22, 3474.0, 27.5, 
                27.5, -153.0, 1.62, 384400.0, tierra);
        Satelite fobos = new Satelite("Fobos", 1.072E16, 11000.0, 0.0, 
                0.319, -40.15, 0.0084, 6000, marte);
        Satelite deimos = new Satelite("Deimos", 2.244E15, 12400.0, 0.0, 
                1.262, -40.15, 0.0039, 23460, marte);
        //Satelite nulo = null;
        // Luego cargaremos en el ArrayList astros los diferentes objetos astro (planetas y satélites)

        // Añadimos satélites a planetas
//        tierra.addSatelite(luna);
//        marte.addSatelite(fobos);
//        marte.addSatelite(deimos);

        // Añadimos planetas y satélites a la lista
        astros.add(tierra);
        astros.add(venus);
        //astros.add(nulo);
        astros.add(marte);
        astros.add(luna);
        astros.add(fobos);
        astros.add(deimos);
        
        // Muestra toda la información de los astros de la lista (sin menú)
        mostrarListaAstros(astros,false);
        
        // A través de un menú se elige el astro a mostra la información (con menú);
        //mostrarListaAstros(astros,true);
        
        
        // Para probar la ejecución del método abstracto
        System.out.println("Mostrar veces diametro sol es la distancia de la tierra al sol: "+tierra.obtenerNumeroDistanciaSoles());
        System.out.println("Mostrar veces diametro sol es la distancia de la luna al sol: "+luna.obtenerNumeroDistanciaSoles());
        
    }    
   
    // Imprime la lista de astros (solo sus nombres)
    public static void mostrarListaAstros(ArrayList<Astro> astros,boolean conMenu) {
        
        Scanner sc = new Scanner(System.in);
        
        System.out.println("=== LISTA DE ASTROS ===");
        
        // Muestra la información de cada astro (sin menú)
        if (!conMenu){
            int contador = 1;
            /*for (Astro a : astros) {
                if (a != null) {
                    System.out.println("----------------------------------------");
                    System.out.println("Astro "+contador+" : " + a.getNombre());
                    System.out.println("----------------------------------------");
                    contador++;
                    //System.out.println(a.toString());
                    System.out.println(a);
                    
                    //Muestro información extra en caso de que el astro sea un planeta
                    if (a instanceof Planeta){
                        // esto compila!!!!! cuidadín!!!!!
                        //Planeta p = (Planeta)a;
                        //System.out.println("Info extra: "+p.infoExtra());
                        System.out.println("Info extra: "+((Planeta) a).infoExtra());
                    }
                        
                }
            }*/
            // COSAS A TENER EN CUENTA EN LAMBDA, EL USO DE VARIABLES FUERA DE SU SCOPE...
            
            astros.forEach(a ->{
                int contador2 = 1;
                if (a != null){
                    System.out.println("----------------------------------------");
                    System.out.println("Astro "+contador2+" : " + a.getNombre());
                    System.out.println("----------------------------------------");
                    contador2++;
                    System.out.println(a.toString());
                    
                    //Muestro información extra en caso de que el astro sea un planeta
                    if (a instanceof Planeta){
                        // esto compila!!!!! cuidadín!!!!!
                        System.out.println("Info extra: "+((Planeta) a).infoExtra());
                    }
                }
            });
        }
        else{
            int opcion = -1;
            do{
                // Muestro el nombre de los astros que están en la lista
                for (int i = 0; i < astros.size(); i++) {
                    Astro a = astros.get(i);
                    if (a != null)
                        System.out.println("Astro "+(i+1)+" : " + a.getNombre()); 
                }
                
                System.out.println("Elige un número de astro (-1 para salir): ");
                if (sc.hasNextInt()){
                    opcion=sc.nextInt();
                    sc.nextLine();
                }
                else{
                    System.out.println("Debes introducir un número");
                    opcion = 0;
                }
                    
                if (opcion > 0 && opcion <= astros.size()){
                    Astro a = astros.get(opcion-1);
                    if (a != null)
                        System.out.println(a);
                }else if (opcion == -1){
                    System.out.println("Vas a salir del programa");
                }else{
                    System.out.println("Elige un número correcto de astro");
                    opcion = 0;
                }
                
                System.out.println("Enter para continuar");
                
                sc.nextLine();
                        
            }while(opcion != -1);
        }
    }
   
}
