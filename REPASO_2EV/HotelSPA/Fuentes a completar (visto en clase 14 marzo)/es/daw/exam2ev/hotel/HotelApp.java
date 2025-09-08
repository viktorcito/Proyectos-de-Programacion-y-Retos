package es.daw.exam2ev.hotel;

import es.daw.exam2ev.hotel.dao.ReservasDAO;
import es.daw.exam2ev.hotel.excepciones.ReferenciaClienteNoEncontradaException;
import es.daw.exam2ev.hotel.model.Cliente;
import es.daw.exam2ev.hotel.model.Habitacion;
import java.util.ArrayList;
import es.daw.exam2ev.hotel.model.Hotel;
import es.daw.exam2ev.hotel.model.ServicioSPA;
import es.daw.exam2ev.hotel.model.interfaces.Reservable;
import java.util.Collections;
import java.util.Comparator;
import java.util.logging.Level;
import java.util.logging.Logger;

public class HotelApp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        ArrayList<Habitacion> habitaciones = new ArrayList<>();
        ArrayList<ServicioSPA> spas = new ArrayList<>();
        
        //COMPLETAR CÓDIGO: CREACIÓN DEL HOTEL CON SUS RESERVAS
        // Primera forma de crear el hotel con sus reservas
        ReservasDAO dao = new ReservasDAO();
        ArrayList<Reservable> reservas = dao.select();
        
        Hotel hotel = new Hotel(dao.select());
        
        // Segunda forma de crear el hotel con sus reservas
        //Hotel hotel = new Hotel();
        
                
        System.out.println("\n* 1. LISTADO DE LAS RESERVAS DE HABITACIÓN ORDENADAS DE FORMA NATURAL:\n");
        //COMPLETAR CÓDIGO
        habitaciones = hotel.obtenerReservasHabitacionOrdenadasDeFormaNatural();
        habitaciones.forEach(System.out::println);

        System.out.println("\n* 2. LISTADO DE LAS RESERVAS DE SPA ORDENADAS POR REFERENCIA DEL CLIENTE:\n");
        //COMPLETAR CÓDIGO

        System.out.println("\n* 3.1 LISTADO DE RESERVAS POR REFERENCIA DEL CLIENTE (probando con NH000001):\n");
        try {
            //COMPLETAR CÓDIGO
            hotel.obtenerReservasPorReferenciaCliente("NH000001");
        } catch (ReferenciaClienteNoEncontradaException ex) {
            ex.getMessage();
        }

        System.out.println("\n* 3.2 LISTADO DE RESERVAS POR REFERENCIA DEL CLIENTE (probando con KK000001):\n");
        //COMPLETAR CÓDIGO
        
        System.out.println("\n* 4. LISTADO DE RESERVAS DE HABITACIÓN POR CLIENTE:\n");
        Cliente c = new Cliente("NH000001", "nombreapellidos1", "email_1@gmail.com", "111111111");
        //COMPLETAR CÓDIGO
        
        System.out.println("\n* 5. OBTENER FACTURA DE LA RESERVA POR POSICIÓN:\n");
        System.out.println(" 5.1. FACTURA DE LA PRIMERA RESERVA:\n");
        //COMPLETAR CÓDIGO
        
        System.out.println("\n5.2. FACTURA DE LA ÚLTIMA RESERVA:\n");
        //COMPLETAR CÓDIGO
        
    }

}
