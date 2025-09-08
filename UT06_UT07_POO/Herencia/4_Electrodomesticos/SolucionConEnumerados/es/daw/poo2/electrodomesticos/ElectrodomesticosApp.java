package es.daw.poo2.electrodomesticos;

import es.daw.poo2.electrodomesticos.model.Electrodomestico;
import es.daw.poo2.electrodomesticos.model.Television;
import es.daw.poo2.electrodomesticos.model.Lavadora;
import es.daw.poo2.electrodomesticos.dao.ElectrodomesticoDAO;
import java.util.ArrayList;
/**
 *
 * @author melol
 */
public class ElectrodomesticosApp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        double sumaLavadoras = 0, sumaTelevisiones = 0, total=0; 
        
        //1. Creo el DAO y cargo los datos
        ElectrodomesticoDAO dao = new ElectrodomesticoDAO();
        ArrayList<Electrodomestico> electrodomesticos = dao.select();
        
        // PEDIR POR CONSOLA DATOS PARA DAR DE ALTA UNA LAVADORA COMPLETA Y UNA TELE COMPLETA
        
        for(Electrodomestico e: electrodomesticos){
            
            if( e instanceof Lavadora)
                sumaLavadoras += e.getPrecioFinal();
            else if (e instanceof Television)
                sumaTelevisiones += e.getPrecioFinal();
        }
        
        //Mostramos los resultados
        System.out.println("La suma del precio de los electrodomesticos es de "+ (sumaLavadoras + sumaTelevisiones));
        System.out.println("La suma del precio de las lavadoras es de "+sumaLavadoras);
        System.out.println("La suma del precio de las televisiones es de "+sumaTelevisiones);
        
    }
    
}
