/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package es.daw.poo2.Alquilervehiculos.Model.Util;

import static es.daw.poo2.Alquilervehiculos.AlquileVehiculosAPP.scLetras;
import static es.daw.poo2.Alquilervehiculos.AlquileVehiculosAPP.scNums;
import static es.daw.poo2.Alquilervehiculos.AlquileVehiculosAPP.vehiculos;
import es.daw.poo2.Alquilervehiculos.Model.*;

/**
 *
 * @author Dani
 */
public class Utilidades {

    public static void muestraMenu() {
        System.out.println("1.Añadir vehículo");
        System.out.println("2.Marcar vehículo como alquilado y ver precio");
        System.out.println("3.Mostrar flota");
        System.out.println("4.Mostrar vehículos no alquilados");
        System.out.println("5.Mostrar vehículos alquilados");
        System.out.println("6.Marcar vehículo como no alquilado");
        System.out.println("7.Salir");
        System.out.println("Introduce una opción");
    }

    public static void añadirVehiculo(String tipo) {

        String matricula;
        int plazas;
        float pma;
        
        
        if(!tipo.equalsIgnoreCase("camion")&&!tipo.equalsIgnoreCase("coche")&&
           !tipo.equalsIgnoreCase("furgoneta")&&!tipo.equalsIgnoreCase("microbus")){
            System.out.println("Has introducido una opción no válida\n");
        }else{

        if (tipo.equalsIgnoreCase("coche")) {
            System.out.println("\n");
            System.out.println("Introduce el número de plazas");
            plazas = scNums.nextInt();
            System.out.println("Introduce la matrícula");
            matricula = scLetras.nextLine();
            vehiculos.add(new Coche(plazas, matricula));
        }
        if (tipo.equalsIgnoreCase("microbus")) {
            System.out.println("\n");
            System.out.println("Introduce el número de plazas");
            plazas = scNums.nextInt();
            System.out.println("Introduce la matrícula");
            matricula = scLetras.nextLine();
            vehiculos.add(new Microbus(plazas, matricula));
        }
        if (tipo.equalsIgnoreCase("furgoneta")) {
            System.out.println("\n");
            System.out.println("Introduce el PMA");
            pma = scNums.nextFloat();
            System.out.println("Introduce la matrícula");
            matricula = scLetras.nextLine();
            vehiculos.add(new Furgoneta(pma, matricula));
        }
        if (tipo.equalsIgnoreCase("camion")) {
            System.out.println("\n");
            System.out.println("Introduce el PMA");
            pma = scNums.nextFloat();
            System.out.println("Introduce la matrícula");
            matricula = scLetras.nextLine();
            vehiculos.add(new Camion(pma, matricula));
        }
        System.out.println("**El vehículo se ha añadido a la flota**");
        }
    }

    public static void muestraNoAlquilados() {

        System.out.println("\n**INFORMACIÓN SOBRE LOS VEHÍCULOS NO ALQUILADOS EN FLOTA**");
        for (Vehiculo v2 : vehiculos) {
            if (!v2.isAlquilado()) {
                System.out.println("El vehículo [" + v2.getClass().getSimpleName() + "] con matrícula : " + v2.getMatricula() + " no está alquilado");
            }
        }
        System.out.println("\n");
    }

    public static void muestraAlquilados() {
        System.out.println("\n**INFORMACIÓN SOBRE LOS VEHÍCULOS ALQUILADOS EN FLOTA**");
        for (Vehiculo v : vehiculos) {
            if(v.isAlquilado()){
                System.out.println("El vehículo["+v.getClass().getSimpleName()+"] con matrícula : " + v.getMatricula() + " está alquilado");
            }
            
        }
        System.out.println("\n");

    }

    public static void muestraFlota() {
        System.out.println("\n\t********LISTA DE VEHÍCULOS EN FLOTA********");
        vehiculos.forEach(System.out::println);
        System.out.println("*********************************************************************");
        System.out.println("\n");
    }

    public static void marcaAlquiladoPrecio(String matricula, int dias) {

        for (Vehiculo v : vehiculos) {
            
            if (v.getMatricula().equalsIgnoreCase(matricula)) {
                v.setDias(dias);
                v.setAlquilado(true);
                System.out.println("El precio de alquiler del vehículo con"
                        + " matrícula [" + matricula + "] es de: " + v.calcularAlquiler());
            }
        }

    }
        public static void marcaNoAlquilado(String matricula) {

        for (Vehiculo v : vehiculos) {
        
            if (v.getMatricula().equalsIgnoreCase(matricula) && v.isAlquilado()) {
                v.setAlquilado(false);
                System.out.println("El vehículo con"
                        + " matrícula [" + matricula + "] ya no está alquilado\n");
            }else{
                System.out.println("O la matrícula no coincide o ese vehículo no está alquilado.\n");
            }
        }

    }

}
