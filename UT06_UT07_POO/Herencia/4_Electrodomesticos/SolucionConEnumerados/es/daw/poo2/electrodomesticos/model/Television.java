package es.daw.poo2.electrodomesticos.model;

import es.daw.poo2.electrodomesticos.enumerados.Color;
import es.daw.poo2.electrodomesticos.enumerados.ConsumoEnergetico;

public class Television extends Electrodomestico{

    private final static int RESOLUCION_DEF=20;

    private int resolucion;
    private boolean sintonizadorTDT;
  
  
    //Constructor
  
    /**
     * Constructor por defecto
     */
    public Television(){
        this(PRECIO_BASE_DEF, PESO_DEF, CONSUMO_ENERGETICO_DEF, COLOR_DEF, RESOLUCION_DEF, false);
    }
  
    /**
     * Constructor con 2 parametros
     * @param precioBase
     * @param peso
     */
    public Television(double precioBase, double peso){
        this(precioBase, peso, CONSUMO_ENERGETICO_DEF, COLOR_DEF, RESOLUCION_DEF, false);
    }
  
    /**
     * Contructor con 6 parametros
     * @param precioBase
     * @param peso
     * @param consumoEnergetico
     * @param color
     * @param resolucion
     * @param sintonizadorTDT
     */
    public Television(double precioBase, double peso, ConsumoEnergetico consumoEnergetico, Color color, int resolucion, boolean sintonizadorTDT){
        super(precioBase, peso, consumoEnergetico, color);
        this.resolucion=resolucion;
        this.sintonizadorTDT=sintonizadorTDT;
    }
    
    //Métodos publicos
  
    /**
     * Precio final de la television
     * @return precio final de la television
     */
    @Override
    public double getPrecioFinal(){
        //Invocamos el método getPrecioFinal del método padre
        double precioFinal=super.getPrecioFinal();
  
        //Añadimos el codigo necesario
        if (resolucion>40){
            //precioFinal+=getPrecioBase()*0.3;
            
            precioFinal = precioFinal * 1.3;
            //System.out.println("Aplicado plus del 30%: "+getPrecioBase()*0.3);
        }
        if (sintonizadorTDT){
            precioFinal+=50;
            //System.out.println("Aplicado plus de 50 euros");
        }
  
        return precioFinal;
    }
    

    @Override
    public String toString() {
        return super.toString()+" Television{" + "resolucion=" + resolucion + ", sintonizadorTDT=" + sintonizadorTDT + '}';
    }
    
}