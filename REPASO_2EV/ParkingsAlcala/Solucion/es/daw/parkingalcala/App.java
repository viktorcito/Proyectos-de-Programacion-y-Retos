/**
 * https://github.com/profeMelola/Programacion_2022-23/tree/main/REPASO_2EV/ParkingsAlcala
 */
package es.daw.parkingalcala;

import es.daw.parkingalcala.dao.CocheDAO;
import es.daw.parkingalcala.dao.ParkingDAO;
import es.daw.parkingalcala.excepciones.ParkingCompletoException;
import es.daw.parkingalcala.model.Coche;
import es.daw.parkingalcala.model.Parking;
import es.daw.parkingalcala.model.ParkingPrivado;
import es.daw.parkingalcala.model.ParkingPublico;
import es.daw.parkingalcala.model.Profitable;
import es.daw.parkingalcala.model.Seguro;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;

/**
 *
 * @author melola
 */
public class App {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        ArrayList<Profitable> listaParkings = new ArrayList<>();
        
        ArrayList<Coche> listaCoches = new ArrayList<>();
        
        ArrayList<ParkingCompletoException> excepciones = new ArrayList<>();         
        
        
        ParkingDAO daoP = new ParkingDAO();
        listaParkings = daoP.select();
        
        
        CocheDAO daoC = new CocheDAO();
        listaCoches = daoC.select();
        
        // ------------------------------------------------------------------
        // En total voy a dejar 2 plazas sin ocupar en toda Alcalá:
        
        // Metemos 3 coches
        ParkingPublico pp = (ParkingPublico) listaParkings.get(0);
        for (int i = 0; i < 3; i++) {
            try {
                pp.addCoche(listaCoches.get(i));
            } catch (ParkingCompletoException a) {
                excepciones.add(a);
            }
        }  
        
        // Metemos 4 coches
        ParkingPublico pp2 = (ParkingPublico) listaParkings.get(1);
        Seguro seg = new Seguro(666, "COMPLUTUM_SEG", LocalDate.of(2023, Month.MARCH, 31));
        pp2.setSeguro(seg);
        for (int i = 0; i < 4; i++) {
            try {
                pp2.addCoche(listaCoches.get(i));
            } catch (ParkingCompletoException a) {
                excepciones.add(a);
            }
        }  
        // Metemos todos los coches
        ParkingPrivado ppriv = (ParkingPrivado) listaParkings.get(2);
        for (int i = 0; i < listaCoches.size(); i++) {
            try {
                ppriv.addCoche(listaCoches.get(i));
            } catch (ParkingCompletoException a) {
                excepciones.add(a);
            }
        }  
        
        // Metemos 3 coches
        ParkingPrivado ppriv2 = (ParkingPrivado) listaParkings.get(3);
        for (int i = 0; i < 3; i++) {
            try {
                ppriv2.addCoche(listaCoches.get(i));
            } catch (ParkingCompletoException a) {
                excepciones.add(a);
            }
        }  

        // Información de los parking
        for(Profitable p: listaParkings){
            System.out.println(p.toString());
            System.out.println("\n\tLas ganancias totales del parking: "+p.mostrarGananciasTotales());
        }
//        System.out.println("Ganancias: "+listaParkings.get(0).mostrarGananciasTotales());
//        System.out.println("Ganancias: "+priv.mostrarGananciasTotales());
        
        // Pinto informaicón de todas las excepciones
        System.out.println("*********** LISTADO DE EXCEPCIONES **************");
        for(ParkingCompletoException e: excepciones)
            System.out.println(e);
        
    }
    
}
