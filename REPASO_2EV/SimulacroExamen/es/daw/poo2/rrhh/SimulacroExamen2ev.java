package es.daw.poo2.rrhh;

import es.daw.poo2.rrhh.dao.EmpleadoDAO;
import es.daw.poo2.rrhh.exceptions.FormatoDNIException;
import es.daw.poo2.rrhh.model.Categorias;
import es.daw.poo2.rrhh.model.Empleado;
import es.daw.poo2.rrhh.model.EmpleadoFijo;
import es.daw.poo2.rrhh.model.EmpleadoTemporal;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;

/**
 *
 * @author melol
 */
public class SimulacroExamen2ev {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        
        // ------------------------------------------------
        // Cargar la lista de empleados del DAO
        
        ArrayList<Empleado> empleados = new ArrayList<>();
        
        EmpleadoDAO dao;
        
        try {
            dao = new EmpleadoDAO();
            empleados = dao.select();
        } catch (FormatoDNIException ex) {
            System.out.println(ex.getMessage());
        }
        
        // ------------------------------------------------
        // Añado dos empleados. Uno con DNI correcto y otro con DNI incorrecto
        System.out.println("\n* AÑADIENDO EMPLEADOS: ");
        try{
            Empleado nuevoEmpleadoCorrecto = new EmpleadoFijo(3000,"Mari", "A", "B", "88888888K", "dasdfasdf", 0, "email", Categorias.JUNIOR);
            Empleado nuevoEmpleadoIncorrecto = new EmpleadoFijo(3000,"Mari", "A", "B", "7776j", "dasdfasdf", 0, "email", Categorias.SENIOR);
        }catch(FormatoDNIException e){
            System.out.println(e.getMessage());
        }
        // ------------------------------------------------

        // ------------------------------------------------
        // Muestro la lista de empleados en orden natural descendente
        empleados.sort(Comparator.reverseOrder());
        System.out.println("\n* LISTA DE EMPLEADOS por orden natural descendente: ");
        for(Empleado e:empleados){
            System.out.println(e);
            System.out.println("Paga extra:"+e.calcularFactorPagaExtra());
        }

        // ------------------------------------------------
        // Muestro la lista de empleados por apellido1, apellido2 y nombre
        
        empleados.sort( (pa,pb) -> pa.getApellido1().concat(pa.getApellido2().concat(pa.getNombre())).compareTo(pb.getApellido1().concat(pb.getApellido2().concat(pb.getNombre()))));
        
//        Comparator<Empleado> compApell1 = (pa,pb) -> pa.getApellido1().compareTo(pb.getApellido2());
//        Comparator<Empleado> compApell_1_2 = compApell1.thenComparing((pa,pb) -> pa.getApellido2().compareTo(pb.getApellido2()));
//        Comparator<Empleado> compNombreCompleto = compApell_1_2.thenComparing((pa,pb) -> pa.getNombre().compareTo(pb.getNombre()));
//        
//        empleados.sort(compNombreCompleto);
        
        System.out.println("\n* LISTA DE EMPLEADOS por apellido 1, 2 y nombre: ");
        empleados.forEach(System.out::println);
        // ------------------------------------------------

        // ------------------------------------------------
        // Eliminar de la lista aquellos empleados
        
        System.out.println("\n* BORRANDO EMPLEADO CON FECHA FIN DE CONTRATO 2023-04-01");
        Iterator<Empleado> it = empleados.iterator();
        while(it.hasNext()){
            Empleado e = it.next();
            if (e instanceof EmpleadoTemporal ){
                LocalDate ffc = ((EmpleadoTemporal) e).getFechaFinContrato();
                if (ffc.equals(LocalDate.of(2023, Month.APRIL, 1)))
                    it.remove();
            }
                       
        }
        System.out.println("\n* LISTA DE EMPLEADOS actualizados:");
        empleados.forEach(System.out::println);
        // ------------------------------------------------
        
    }
    
}
