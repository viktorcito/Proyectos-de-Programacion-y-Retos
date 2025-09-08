/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package es.daw.poo.herencia.alquilerVehiculos;


import static es.daw.poo.herencia.alquilerVehiculos.util.Utilidades.*;
import java.util.Scanner;

/**
 *
 * @author Knox
 */
public class AlquilerApp {

    public static Scanner scInt = new Scanner(System.in);
    



    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int op;

        do {
            System.out.println("\n************* CONCESIONARIO *********************");
            System.out.println("1. Añadir vehículo.");
            System.out.println("2. Alquilar vehículo.");
            System.out.println("3. Informe de flota");
            System.out.println("4. Informe de no alquilados");
            System.out.println("5. Informe de alquileres");
            System.out.println("6. Retirar alquiler");
            System.out.println("7. Salir");
            System.out.print("Elige una opción: ");
            op = scInt.nextInt();
            System.out.println("");

            switch (op) {
                case 1:
                    añadirVehiculo();
                    break;
                case 2:

                    if (!comprobarFlotaVacía()) {
                        alquilarVehiculo();
                    }

                    break;
                case 3:
                    if (!comprobarFlotaVacía()) {
                        informeFlota();
                    }
                    break;
                case 4:
                    if (!comprobarFlotaVacía()) {
                        informeNoAlquilado();
                    }
                    break;
                case 5:
                    if (!comprobarFlotaVacía()) {
                        informeAlquilado();
                    }
                    break;
                case 6:
                    if (!comprobarFlotaVacía()) {
                        retirarAlquiler();
                    }
                    break;
                case 7:
                    System.out.println("Saliendo de la aplicación...");
                    break;
                default:
                    System.out.println("No has introducido una opción correcta");
            }

        } while (op != 7);
    }

}
