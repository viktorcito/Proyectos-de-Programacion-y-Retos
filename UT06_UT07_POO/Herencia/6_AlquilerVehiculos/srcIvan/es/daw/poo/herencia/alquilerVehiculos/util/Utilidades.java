/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package es.daw.poo.herencia.alquilerVehiculos.util;

import static es.daw.poo.herencia.alquilerVehiculos.AlquilerApp.scInt;
import es.daw.poo.herencia.alquilerVehiculos.model.*;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Knox
 */
public class Utilidades {

    static Vehiculo vehiculoABuscar;
    static ArrayList<Vehiculo> flota = new ArrayList();
    static ArrayList<Vehiculo> vehiculosEnAlquiler = new ArrayList();
    static Scanner scStr = new Scanner(System.in);

    static boolean comprobarExistenciaEnFlota(String matricula) {
        vehiculoABuscar = new Vehiculo(matricula);
        return flota.contains(vehiculoABuscar);
    }

    public static void a�adirVehiculo() {
        int tipo, plazas = 0;
        String matricula;
        float peso = 0;

        System.out.println("Introduce el tipo de veh�culo");
        System.out.println("\t[1] Coche");
        System.out.println("\t[2] Microbus");
        System.out.println("\t[3] Furgoneta");
        System.out.println("\t[4] Camion");
        tipo = scInt.nextInt();

        if (tipo >= 1 && tipo <= 4) {
            System.out.println("Introduce la matr�cula");
            matricula = scStr.nextLine();

            if (comprobarExistenciaEnFlota(matricula)) {
                System.out.println("El veh�culo indicado ya existe");
            } else {
                if (tipo == 1 || tipo == 2) {
                    System.out.println("Introduce el n�mero de plazas");
                    plazas = scInt.nextInt();
                } else {
                    System.out.println("Introduce el PMA");
                    peso = scInt.nextFloat();
                }

                switch (tipo) {
                    case 1:
                        flota.add(new Coche(matricula, plazas));
                        break;
                    case 2:
                        flota.add(new Microbus(matricula, plazas));
                        break;
                    case 3:
                        flota.add(new Furgoneta(matricula, peso));
                        break;
                    case 4:
                        flota.add(new Camion(matricula, peso));
                }
            }

        } else {
            System.out.println("Indica un tipo v�lido de veh�culo");
        }

    }

    public static boolean comprobarFlotaVac�a() {
        if (flota.isEmpty()) {
            System.out.println("No hay veh�culos dados de alta en la base de datos");
            return true;
        } else {
            return false;
        }
    }

    public static Vehiculo obtenerVehiculo() {
        String matricula;

        System.out.println("Introduce la matr�cula del veh�culo");
        matricula = scStr.nextLine();

        if (comprobarExistenciaEnFlota(matricula)) {
            return flota.get(flota.indexOf(vehiculoABuscar));
        } else {
            System.out.println("El veh�culo no existe");
            return null;
        }

    }

    public static void alquilarVehiculo() {
        Vehiculo vehiculo = obtenerVehiculo();

        if (vehiculo != null) {
            vehiculo.setAlquilado(true);
            vehiculosEnAlquiler.add(vehiculo);
        }
    }

    public static void retirarAlquiler() {
        float precioAlquiler;
        Vehiculo vehiculo = obtenerVehiculo();

        if (vehiculo != null) {

            precioAlquiler = vehiculo.getPrecioAlquiler();

            System.out.println("\nPrecio del alquiler: " + precioAlquiler);
            vehiculo.setAlquilado(false);
            vehiculosEnAlquiler.remove(vehiculo);

            System.out.println("Alquiler retirado...");

        } else {
            System.out.println("El vehiculo no existe");
        }
    }

    public static void informeFlota() {
        flota.forEach(System.out::println);
    }

    public static void informeNoAlquilado() {
        if (vehiculosEnAlquiler.isEmpty()) {
            informeFlota();
        } else {
            flota.forEach(vehiculo -> {
                if (!vehiculosEnAlquiler.contains(vehiculo)) {
                    System.out.println(vehiculo);
                }
            });
        }
    }

    public static void informeAlquilado() {
        if (vehiculosEnAlquiler.isEmpty()) {
            System.out.println("Todav�a no hay veh�culos alquilados");
        } else {
            vehiculosEnAlquiler.forEach(System.out::println);
        }
    }

}
