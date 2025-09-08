package es.daw.poo2.rrhh.dao;

import es.daw.poo2.rrhh.exceptions.FormatoDNIException;
import es.daw.poo2.rrhh.model.*;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author melol
 */
public class EmpleadoDAO {
    private ArrayList<Empleado> empleados = new ArrayList<>();

    // CAMBIADA LA EXCEPCIÓN PARA QUE SEA MÁS ESPECÍFICA (NO EXCEPTION)
    //public EmpleadoDAO(){
    public EmpleadoDAO() throws FormatoDNIException{
        
        //(double importePlanPensiones, String nombre, String apellido1, String apellido2, String DNI, String domicilioCompleto, int movil, String email, Categorias categoria)
        empleados.add(new EmpleadoFijo(1000, "B", "B", "B", "11111111C", "Dir 1", 111111111, "b@gmail.com", Categorias.DIRECTIVO));
        empleados.add(new EmpleadoFijo(2000, "B", "B", "C", "11111111B", "Dir 2", 222222222, "b@gmail.es", Categorias.SENIOR));
        empleados.add(new EmpleadoFijo(3000, "A", "B", "C", "11111111A", "Dir 3", 333333333, "a@gmail.com", Categorias.JUNIOR));
        
        // (LocalDate fechaFinContrato, String nombre, String apellido1, String apellido2, String DNI, String domicilioCompleto, int movil, String email, Categorias categoria)
        empleados.add(new EmpleadoTemporal(LocalDate.of(2023,04,01), "C", "B", "B", "11111111Y", "Dir 4", 444444444, "c@gmail.com", Categorias.DIRECTIVO));
        empleados.add(new EmpleadoTemporal(LocalDate.of(2023,04,01), "D", "B", "C", "22222222B", "Dir 5", 555555555, "d@gmail.com", Categorias.SENIOR));
        empleados.add(new EmpleadoTemporal(LocalDate.of(2023,05,19), "C", "B", "C", "22222222A", "Dir 6", 666666666, "c@gmail.es", Categorias.JUNIOR));
        
    }
    
    public ArrayList<Empleado> select() {
       return new ArrayList<Empleado> (empleados);
    }    
    
}
