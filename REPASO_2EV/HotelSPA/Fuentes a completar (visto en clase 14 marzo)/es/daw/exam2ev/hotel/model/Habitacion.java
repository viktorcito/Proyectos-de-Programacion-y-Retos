package es.daw.exam2ev.hotel.model;

import es.daw.exam2ev.hotel.enumerados.TipoHabitacion;
import es.daw.exam2ev.hotel.model.interfaces.Reservable;
import java.time.LocalDate;

public class Habitacion implements Reservable, Comparable<Habitacion>{
    
    private Cliente cliente;
    private int numero;
    private LocalDate diaReserva;
    private int cantidadNoches;
    private TipoHabitacion tipo;
    
    private static final int PRECIO_BASE = 50;
   

    //COMPLETAR CÓDIGO
    //Habitacion(Cliente cliente, int numero,  LocalDate diaReserva, int cantidadNoches, TipoHabitacion tipo)

    public Habitacion(Cliente cliente, int numero, LocalDate diaReserva, int cantidadNoches, TipoHabitacion tipo) {
        this.cliente = cliente;
        this.numero = numero;
        this.diaReserva = diaReserva;
        this.cantidadNoches = cantidadNoches;
        this.tipo = tipo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public int getNumero() {
        return numero;
    }

    public LocalDate getDiaReserva() {
        return diaReserva;
    }

    public int getCantidadNoches() {
        return cantidadNoches;
    }

    public TipoHabitacion getTipo() {
        return tipo;
    }

    public static int getPRECIO_BASE() {
        return PRECIO_BASE;
    }
    
    

    @Override
    public String obtenerFacturaReserva() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int calcularPrecioReserva() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int compareTo(Habitacion t) {
        return this.diaReserva.compareTo(t.diaReserva);
        //return this.diaReserva.compareTo(t.getDiaReserva());
        
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Habitacion{");
        sb.append("cliente=").append(cliente);
        sb.append(", numero=").append(numero);
        sb.append(", diaReserva=").append(diaReserva);
        sb.append(", cantidadNoches=").append(cantidadNoches);
        sb.append(", tipo=").append(tipo);
        sb.append('}');
        return sb.toString();
    }
    
    
    
    
}
