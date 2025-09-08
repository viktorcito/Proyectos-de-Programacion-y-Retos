package es.daw.exam2ev.hotel.model;

import es.daw.exam2ev.hotel.dao.ReservasDAO;
import es.daw.exam2ev.hotel.excepciones.ReferenciaClienteNoEncontradaException;
import es.daw.exam2ev.hotel.model.interfaces.Gestionable;
import es.daw.exam2ev.hotel.model.interfaces.Reservable;
import java.util.ArrayList;
import java.util.Collections;

public class Hotel implements Gestionable {

    private ArrayList<Reservable> reservas;

    // Primera forma
    public Hotel(ArrayList<Reservable> reservas) {
        this.reservas = reservas;
    }

    // Segunda forma
    public Hotel() {
        ReservasDAO dao = new ReservasDAO();
        this.reservas = dao.select();

    }

    //COMPLETAR CÓDIGO
    @Override
    public ArrayList<Habitacion> obtenerReservasHabitacionOrdenadasDeFormaNatural() {

        ArrayList<Habitacion> habitaciones = new ArrayList<>();

        for (Reservable r : reservas) {
            if (r instanceof Habitacion) {
                habitaciones.add((Habitacion) r);
            }
        }
        
        // NO SE PINTA LA COLECCIÓN EN EL MÉTODO. SE DEVUELVE Y QUIEN HAYA LLAMADO AL MÉTODO DECIDE QUÉ HACER!!!
        //habitaciones.forEach(System.out::println);

        //habitaciones.sort(Comparator.naturalOrder());
        Collections.sort(habitaciones);
        
        return habitaciones;

    }

    @Override
    public ArrayList<ServicioSPA> obtenerReservasServicioSPAOrdenadosPorReferenciaCliente() {
        
        // 1. Crear la colección de serviciosSPA
        
        // 2. Recorrer la colección de reservas y filtra por serviciosSPA (instanceof)
        
        // 3. Con la colección de spas usar un Comparator que ordene por referenciaCliente
        
        // 4. Devolver la colección de spas ordenada correctamente
        
        return null;
        
    }

    @Override
    public ArrayList<Reservable> obtenerReservasPorReferenciaCliente(String referenciaCliente) throws ReferenciaClienteNoEncontradaException {
        
        boolean noEncontrado = true;
        
        // Creo colección de colección de reservas
        
        // Recorrer la colección de reservas y dependiendo del tipo de reservas localiza la referenciaCliente
        
            // for
                // if
                    // habitación ==> getCliente() y coger el string refCliente
                    
                    // spa ==> cojo el strigRefCliente
                    
                    // Compara la refCliente con la enviada como argumento.....
                    
                    // TENGO QUE DETECTAR SI LA REFCLIENTE EXISTE!!!!!!!
                    
        // En el caso de que la refCliente no exista...
        
        if (noEncontrado){
            // 1. Se crea el objeto excepción
            ReferenciaClienteNoEncontradaException e = new ReferenciaClienteNoEncontradaException(referenciaCliente);
            // 2. Lanzar la excepción (propagarla)
            throw e;
        }
        
        return null;
        
        
    }

    @Override
    public ArrayList<Habitacion> obtenerReservasHabitacionPorCliente(Cliente cliente) {

        // TENED EN CUENTA EN EL EQUALS LOS ATRIBUTOS QUE NECESITO!!!!!!!!
        
        return null;
    }

    @Override
    public String obtenerFacturaReservaPorPosicion(int posicion) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
