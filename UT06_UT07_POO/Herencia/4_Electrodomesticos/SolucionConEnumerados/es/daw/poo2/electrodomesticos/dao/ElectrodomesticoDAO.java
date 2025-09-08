package es.daw.poo2.electrodomesticos.dao;

import es.daw.poo2.electrodomesticos.enumerados.Color;
import es.daw.poo2.electrodomesticos.enumerados.ConsumoEnergetico;
import es.daw.poo2.electrodomesticos.model.Electrodomestico;
import es.daw.poo2.electrodomesticos.model.Lavadora;
import es.daw.poo2.electrodomesticos.model.Television;
import java.util.ArrayList;

/**
 *
 * @author melola
 */
public class ElectrodomesticoDAO {
    private final ArrayList<Electrodomestico> electrodomesticos;

    
    public ElectrodomesticoDAO(){
        electrodomesticos = new ArrayList<>();
        electrodomesticos.add(new Lavadora(200, 60, ConsumoEnergetico.C, Color.AZUL));
        electrodomesticos.add(new Lavadora(150, 30));
        electrodomesticos.add(new Television(500, 80, ConsumoEnergetico.E, Color.NEGRO, 42, false));
        electrodomesticos.add(new Lavadora());
        electrodomesticos.add(new Lavadora(600, 20, ConsumoEnergetico.D, Color.GRIS));
        electrodomesticos.add(new Lavadora(300, 40, ConsumoEnergetico.F, Color.BLANCO, 40));
        electrodomesticos.add(new Television(250, 70));
        electrodomesticos.add(new Lavadora(400, 100, ConsumoEnergetico.A, Color.GRIS, 15));
        electrodomesticos.add(new Television(200, 60, ConsumoEnergetico.C, Color.ROJO, 30, true));
        electrodomesticos.add(new Television(50, 10));
        
    }
    
    public ArrayList<Electrodomestico> select(){
        return (ArrayList<Electrodomestico>) electrodomesticos.clone();
    }    
    
}
