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
            System.out.println("1. A�adir veh�culo.");
            System.out.println("2. Alquilar veh�culo.");
            System.out.println("3. Informe de flota");
            System.out.println("4. Informe de no alquilados");
            System.out.println("5. Informe de alquileres");
            System.out.println("6. Retirar alquiler");
            System.out.println("7. Salir");
            System.out.print("Elige una opci�n: ");
            op = scInt.nextInt();
            System.out.println("");

            switch (op) {
                case 1:
                    a�adirVehiculo();
                    break;
                case 2:

                    if (!comprobarFlotaVac�a()) {
                        alquilarVehiculo();
                    }

                    break;
                case 3:
                    if (!comprobarFlotaVac�a()) {
                        informeFlota();
                    }
                    break;
                case 4:
                    if (!comprobarFlotaVac�a()) {
                        informeNoAlquilado();
                    }
                    break;
                case 5:
                    if (!comprobarFlotaVac�a()) {
                        informeAlquilado();
                    }
                    break;
                case 6:
                    if (!comprobarFlotaVac�a()) {
                        retirarAlquiler();
                    }
                    break;
                case 7:
                    System.out.println("Saliendo de la aplicaci�n...");
                    break;
                default:
                    System.out.println("No has introducido una opci�n correcta");
            }

        } while (op != 7);
    }

}
