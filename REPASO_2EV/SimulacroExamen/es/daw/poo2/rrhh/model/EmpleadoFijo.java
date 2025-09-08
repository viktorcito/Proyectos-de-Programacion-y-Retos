package es.daw.poo2.rrhh.model;

import es.daw.poo2.rrhh.exceptions.FormatoDNIException;

/**
 *
 * @author melol
 */
public class EmpleadoFijo extends Empleado{

    private float importePlanPensiones;

    public EmpleadoFijo(float importePlanPensiones, String nombre, String apellido1, String apellido2, String DNI, String domicilioCompleto, int movil, String email, Categorias categoria) throws FormatoDNIException{
        super(nombre, apellido1, apellido2, DNI, domicilioCompleto, movil, email, categoria);
        this.importePlanPensiones = importePlanPensiones;
    }

    public float getImportePlanPensiones() {
        return importePlanPensiones;
    }

    // Necesito el set para ir añadiendo importe al plan de pensiones
    public void setImportePlanPensiones(float importePlanPensiones) {
        this.importePlanPensiones = importePlanPensiones;
    }
    
    // Método propio
    /*public double calcularPlanPensiones(){
        return importePlanPensiones * 0.5;

    }*/
    
    
    @Override
    public int calcularFactorPagaExtra() {
        return super.getCategoria().getFactor();
        
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append("\nEmpleadoFijo{" + "importePlanPensiones=" + importePlanPensiones + '}');
        return sb.toString();
    }
  
    
    
}
