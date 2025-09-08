package es.daw.poo2.rrhh.model;

import es.daw.poo2.rrhh.exceptions.FormatoDNIException;
import java.time.LocalDate;

/**
 *
 * @author melol
 */
public class EmpleadoTemporal extends Empleado{

    private LocalDate fechaFinContrato;

    public EmpleadoTemporal(LocalDate fechaFinContrato, String nombre, String apellido1, String apellido2, String DNI, String domicilioCompleto, int movil, String email, Categorias categoria) throws FormatoDNIException{
        super(nombre, apellido1, apellido2, DNI, domicilioCompleto, movil, email, categoria);
        this.fechaFinContrato = fechaFinContrato;
    }

    public LocalDate getFechaFinContrato() {
        return fechaFinContrato;
    }

    public void setFechaFinContrato(LocalDate fechaFinContrato) {
        this.fechaFinContrato = fechaFinContrato;
    }
    
       
    @Override
    /**
     * Método abstracto
     */
    public int calcularFactorPagaExtra() {
        //return es.daw.poo2.rrhh.util.Utilidades.calculaDiasDesdeFechaHastaAhora(getFechaInicioContrato());
        return es.daw.poo2.rrhh.util.Utilidades.calculaDiasEntreFechas(getFechaInicioContrato(), getFechaFinContrato());
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append("\nEmpleadoTemporal{" + "fechaFinContrato=" + fechaFinContrato + '}');
        return sb.toString();        
    }
    
    
}
