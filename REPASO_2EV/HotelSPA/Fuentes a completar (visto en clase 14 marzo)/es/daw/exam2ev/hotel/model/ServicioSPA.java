package es.daw.exam2ev.hotel.model;

import es.daw.exam2ev.hotel.enumerados.TipoSPA;
import es.daw.exam2ev.hotel.model.interfaces.Reservable;
import es.daw.exam2ev.hotel.util.UtilFechas;
import java.time.LocalDateTime;

// PENDIENTE!!!!! USAD diaHoraCita como forma natural de ordenación
public class ServicioSPA implements Reservable{
    private String referenciaCliente;
    private TipoSPA tipo;
    private LocalDateTime diaHoraCita;
    

    //COMPLETAR CÓDIGO
    // ServicioSPA(String referenciaCliente, TipoSPA tipo, LocalDateTime diaReservaHoraEntrada)

    public ServicioSPA(String referenciaCliente, TipoSPA tipo, LocalDateTime diaHoraCita) {
        this.referenciaCliente = referenciaCliente;
        this.tipo = tipo;
        this.diaHoraCita = diaHoraCita;
    }

    @Override
    public String obtenerFacturaReserva() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int calcularPrecioReserva() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    

}
