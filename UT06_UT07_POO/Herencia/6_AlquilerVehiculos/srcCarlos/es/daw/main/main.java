/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package es.daw.main;

import es.daw.model.*;
import es.daw.util.Utilidades;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author carlo
 */
public class main {

    public static Scanner sc = new Scanner(System.in);

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ArrayList<Vehiculo> listaCoches = new ArrayList<>();
        ArrayList<Vehiculo> listaMicrobus = new ArrayList<>();
        ArrayList<Vehiculo> listaFurgoneta = new ArrayList<>();
        ArrayList<Vehiculo> listaCamion = new ArrayList<>();

        int opcion = 1;

        do {

            Utilidades.menuAlquiler();
            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    Utilidades.menuVehiculo();
                    int opcion2 = sc.nextInt();
                    switch (opcion2) {
                        case 1:
                            Utilidades.addCoche(listaCoches);
                            break;
                        case 2:
                            Utilidades.addMicrobus(listaMicrobus);
                            break;
                        case 3:
                            Utilidades.addFurgoneta(listaFurgoneta);
                            break;
                        case 4:
                            Utilidades.addCamion(listaCamion);
                            break;
                        default:
                            System.out.println("TE EQUIVOCASTE DE OPCION");
                    }
                    break;
                case 2:
                    Utilidades.menuVehiculo();
                    int opcion3 = sc.nextInt();
                    switch (opcion3) {
                        case 1:
                            Utilidades.alquiler(listaCoches);
                            break;
                        case 2:
                            Utilidades.alquiler(listaMicrobus);
                            break;
                        case 3:
                            Utilidades.alquiler(listaFurgoneta);
                            break;
                        case 4:
                            Utilidades.alquiler(listaCamion);
                            break;
                        default:
                            System.out.println("TE EQUIVOCASTE DE OPCION");

                    }
                    break;
                case 3:
                    System.out.println("LISTADO DE COCHES :");
                    Utilidades.listado(listaCoches);
                    System.out.println("LISTADO DE MICROBUSES :");
                    Utilidades.listado(listaMicrobus);
                    System.out.println("LISTADO DE FURGONETAS :");
                    Utilidades.listado(listaFurgoneta);
                    System.out.println("LISTADO DE CAMIONES : ");
                    Utilidades.listado(listaCamion);
                    break;
                case 4:
                    System.out.println("LISTADO DE COCHES NO ALQUILADOS:");
                    Utilidades.listadoNO(listaCoches);
                    System.out.println("LISTADO DE MICROBUSES NO ALQUILADOS:");
                    Utilidades.listadoNO(listaMicrobus);
                    System.out.println("LISTADO DE FURGONETAS NO ALQUILADOS:");
                    Utilidades.listadoNO(listaFurgoneta);
                    System.out.println("LISTADO DE CAMIONES NO ALQUILADOS: ");
                    Utilidades.listadoNO(listaCamion);
                    break;
                case 5:
                    System.out.println("LISTADO DE COCHES NO ALQUILADOS:");
                    Utilidades.listadoSI(listaCoches);
                    System.out.println("LISTADO DE MICROBUSES NO ALQUILADOS:");
                    Utilidades.listadoSI(listaMicrobus);
                    System.out.println("LISTADO DE FURGONETAS NO ALQUILADOS:");
                    Utilidades.listadoSI(listaFurgoneta);
                    System.out.println("LISTADO DE CAMIONES NO ALQUILADOS: ");
                    Utilidades.listadoSI(listaCamion);
                    break;
                default : 
                    System.out.println("TE EQUIVOCASTE DE OPCION.");
                    break;
            }

        } while (opcion != 6);

    }

}
