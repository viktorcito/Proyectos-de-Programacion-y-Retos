/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package es.daw.util;

import es.daw.model.*;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author carlo
 */
public class Utilidades {

    public static Scanner sc = new Scanner(System.in);

    public static void menuAlquiler() {
        System.out.println("**************** MENU PARA ALQUILAR ******************");
        System.out.println("1. AÑADIR VEHICULOS (MAX 10 VEHICULOS)");
        System.out.println("2. ALQUILAR VEHICULO + PRECIO DE ALQUILER A PAGAR");
        System.out.println("3. MOSTRAR TODOS LOS VEHICULOS");
        System.out.println("4. MOSTRAR TODOS LOS VEHICULOS NO ALQUILADOS");
        System.out.println("5. MOSTRAR TODOS LOS VEHICULOS ALQUILADOS");
        System.out.println("6. SALIR");
        System.out.println("-------------------------------------------------------");
        System.out.println("ELIGE UNA OPCION :");
    }

    public static void menuVehiculo() {
        System.out.println("ESCOGE UNO DE ESTOS VEHICULOS :");
        System.out.println("1.COCHE");
        System.out.println("2.MICROBUS");
        System.out.println("3.FURGONETA");
        System.out.println("4.CAMION");
    }

    public static ArrayList<Vehiculo> addCoche(ArrayList<Vehiculo> addCoches) {
        System.out.println("INTRODUCE LA MATRICULA (ESTAMOS EN ANDORRA A SI QUE VALE CUALQUIERA) :");
        String matricula = sc.nextLine();
        System.out.println("¿CUANTOS DIAS?");
        int dias = sc.nextInt();
        System.out.println("¿CUANTAS PLAZAS?");
        int plazas = sc.nextInt();

        addCoches.add(new Coche(matricula, dias, plazas, false));

        return addCoches;

    }

    public static ArrayList<Vehiculo> addMicrobus(ArrayList<Vehiculo> addMicrobus) {
        System.out.println("INTRODUCE LA MATRICULA (ESTAMOS EN ANDORRA A SI QUE VALE CUALQUIERA) :");
        String matricula = sc.nextLine();
        System.out.println("¿CUANTOS DIAS?");
        int dias = sc.nextInt();
        System.out.println("¿CUANTAS PLAZAS?");
        int plazas = sc.nextInt();

        addMicrobus.add(new Microbus(matricula, dias, plazas, false));

        return addMicrobus;

    }

    public static ArrayList<Vehiculo> addFurgoneta(ArrayList<Vehiculo> addFurgoneta) {
        System.out.println("INTRODUCE LA MATRICULA (ESTAMOS EN ANDORRA A SI QUE VALE CUALQUIERA) :");
        String matricula = sc.nextLine();
        System.out.println("¿CUANTOS DIAS?");
        int dias = sc.nextInt();
        System.out.println("¿CUANTO PESA?");
        float peso = sc.nextInt();

        addFurgoneta.add(new Furgoneta(matricula, dias, peso, false));

        return addFurgoneta;

    }

    public static ArrayList<Vehiculo> addCamion(ArrayList<Vehiculo> addCamion) {
        System.out.println("INTRODUCE LA MATRICULA (ESTAMOS EN ANDORRA A SI QUE VALE CUALQUIERA) :");
        String matricula = sc.nextLine();
        System.out.println("¿CUANTOS DIAS?");
        int dias = sc.nextInt();
        System.out.println("¿CUANTO PESA?");
        float peso = sc.nextInt();

        addCamion.add(new Camion(matricula, dias, peso, false));

        return addCamion;
    }

    public static ArrayList<Vehiculo> alquiler(ArrayList<Vehiculo> alq) {
        System.out.println("INTRODUCE LA MATRICULA DEL VEHICULO QUE QUIERES ALQUILAR :");
        String matricula = sc.nextLine();

        for (Vehiculo v : alq) {

            if (v.getMatricula().equals(matricula)) {
                v.setEsAlquilado(true);
            } else {
                System.out.println("No existe ese coche con esa matricula.");
            }

        }

        return alq;

    }

    public static ArrayList<Vehiculo> listado(ArrayList<Vehiculo> lista) {

        lista.forEach(x -> System.out.println(x));

        return lista;

    }

    public static ArrayList<Vehiculo> listadoNO(ArrayList<Vehiculo> lista) {

        for (Vehiculo v : lista) {

            if (!v.isEsAlquilado()) {
                lista.forEach(x -> System.out.println(x));
            }

        }

        return null;

    }

    public static ArrayList<Vehiculo> listadoSI(ArrayList<Vehiculo> lista) {

        for (Vehiculo v : lista) {

            if (v.isEsAlquilado()) {
                lista.forEach(x -> System.out.println(x));
            }

        }

        return null;

    }
}
