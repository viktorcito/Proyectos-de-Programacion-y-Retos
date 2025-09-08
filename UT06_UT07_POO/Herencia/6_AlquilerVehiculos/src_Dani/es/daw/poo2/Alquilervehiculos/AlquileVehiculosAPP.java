/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package es.daw.poo2.Alquilervehiculos;

import static es.daw.poo2.Alquilervehiculos.Model.Util.Utilidades.*;
import es.daw.poo2.Alquilervehiculos.Model.Vehiculo;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Dani
 */
public class AlquileVehiculosAPP {

    public static ArrayList<Vehiculo> vehiculos = new ArrayList<>();
    public static Scanner scNums = new Scanner(System.in);
    public static Scanner scLetras = new Scanner(System.in);

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        int opcion = 0;
        String matricula;
        int dias;

        while (opcion != 7) {

            muestraMenu();

            opcion = scNums.nextInt();
            switch (opcion) {
                case 1:
                    System.out.println("Solo podrás añadir hasta un máximo de 10 vehículos.");
                    System.out.println("\n¿Qué tipo de vehículo vas a añadir?");

                    añadirVehiculo(scLetras.nextLine());

                    break;
                case 2:
                    System.out.println("\nIntroduce una matrtícula");
                    matricula = scLetras.nextLine();
                    System.out.println("¿De cuántos días será el alquiler?");
                    dias = scNums.nextInt();
                    marcaAlquiladoPrecio(matricula, dias);
                    break;

                case 3:
                    muestraFlota();
                    break;

                case 4:
                    muestraNoAlquilados();
                    break;

                case 5:
                    muestraAlquilados();
                    break;
                    
                case 6:
                    System.out.println("Introduce una matrícula");
                    matricula=scLetras.nextLine();
                     marcaNoAlquilado(matricula);

                default:
                    System.out.println("Introduce una opción válida");
            }

        }

    }

}
