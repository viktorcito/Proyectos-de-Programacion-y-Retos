
package es.daw.poo2.rrhh.model;

import es.daw.poo2.rrhh.exceptions.FormatoDNIException;
import static es.daw.poo2.rrhh.util.Utilidades.checkExpresionRegular;
import java.time.LocalDate;

/**
 *
 * @author melol
 */
public abstract class Empleado implements Comparable<Empleado>{
    
    public static int contador;
    
    private String nombre;
    private String apellido1;
    private String apellido2;
    private String DNI;
    private String domicilioCompleto;
    private int movil;
    private String email;
    private LocalDate fechaInicioContrato;
    private Categorias categoria;
    
    public Empleado(String nombre, String apellido1, String apellido2, String DNI, String domicilioCompleto, int movil, String email, Categorias categoria)  throws FormatoDNIException{
        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        //this.DNI = DNI;
        checkDNI(DNI);
        this.domicilioCompleto = domicilioCompleto;
        this.movil = movil;
        this.email = email;
        this.categoria = categoria;
        this.fechaInicioContrato= LocalDate.now();
        
        contador++;
        
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido1() {
        return apellido1;
    }

    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    public String getApellido2() {
        return apellido2;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    public String getDNI() {
        return DNI;
    }

    public String getDomicilioCompleto() {
        return domicilioCompleto;
    }

    public void setDomicilioCompleto(String domicilioCompleto) {
        this.domicilioCompleto = domicilioCompleto;
    }

    public int getMovil() {
        return movil;
    }

    public void setMovil(int movil) {
        this.movil = movil;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getFechaInicioContrato() {
        return fechaInicioContrato;
    }

    public void setFechaInicioContrato(LocalDate fechaInicioContrato) {
        this.fechaInicioContrato = fechaInicioContrato;
    }

    public Categorias getCategoria() {
        return categoria;
    }

    public void setCategoria(Categorias categoria) {
        this.categoria = categoria;
    }

    // El método debe ser privado
    /**
     * 
     * @param dni
     * @throws FormatoDNIException 
     */
    private void checkDNI(String dni) throws FormatoDNIException{
    //private void checkDNI(String dni){
        if (!checkExpresionRegular("[0-9]{8}[A-Z]{1}",dni)) {
                throw new FormatoDNIException(dni);
        }else 
            this.DNI = dni;
    }
    
    
    @Override
    public String toString() {
        return "\n{ DNI=" + DNI + ",nombre=" + nombre + ", apellido1=" + apellido1 + ", apellido2=" + apellido2 + ", , domicilioCompleto=" + domicilioCompleto + ", movil=" + movil + ", email=" + email + ", fechaInicioContrato=" + fechaInicioContrato + ", categoria=" + categoria + '}';
    }

    public abstract int calcularFactorPagaExtra();

    @Override
    public int compareTo(Empleado otro) {
        return DNI.compareTo(otro.DNI);
    }
    
    
}
