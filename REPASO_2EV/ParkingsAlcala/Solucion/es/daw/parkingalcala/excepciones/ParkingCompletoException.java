package es.daw.parkingalcala.excepciones;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author melola
 */
public class ParkingCompletoException extends Exception{
    private String nombreParking;
    private int numPlazasOcupadas;

    public ParkingCompletoException(String nombreParking, int numPlazasOcupadas) {
        this.nombreParking = nombreParking;
        this.numPlazasOcupadas = numPlazasOcupadas;
    }

    public String getNombreParking() {
        return nombreParking;
    }

    public int getNumPlazasOcupadas() {
        return numPlazasOcupadas;
    }

    @Override
    public String getMessage() {
        return "[ "+LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy/MM/dd hh:mm:ss"))+" ] El parking "+nombreParking+" tiene todas las plazas ocupadas. Num plazas: "+numPlazasOcupadas;
    }
    
    
}
