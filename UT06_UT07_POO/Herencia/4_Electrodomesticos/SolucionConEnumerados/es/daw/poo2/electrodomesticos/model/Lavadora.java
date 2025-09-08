package es.daw.poo2.electrodomesticos.model;

import es.daw.poo2.electrodomesticos.enumerados.Color;
import es.daw.poo2.electrodomesticos.enumerados.ConsumoEnergetico;

public class Lavadora extends Electrodomestico{
  
    private final static int CARGA_DEF=5;
    private int carga;

    

    /*public Lavadora(int carga) {
        this.carga = carga;
    }

    public Lavadora(int carga, double precioBase, double peso) {
        super(precioBase, peso);
        this.carga = carga;
    }

    public Lavadora(int carga, double precioBase, double peso, char consumoEnergetico, String color) {
        super(precioBase, peso, consumoEnergetico, color);
        this.carga = carga;
    }*/
    
    
    
    public Lavadora(){
        this(PRECIO_BASE_DEF,PESO_DEF,CONSUMO_ENERGETICO_DEF,COLOR_DEF,CARGA_DEF);
    }
  
    public Lavadora(double precioBase, double peso){
        this(precioBase,peso,CONSUMO_ENERGETICO_DEF,COLOR_DEF,CARGA_DEF);
    }
    
    public Lavadora(double precioBase, double peso, ConsumoEnergetico consumoEnergetico, Color color){
        this(precioBase,peso, consumoEnergetico,color, CARGA_DEF);
        
    }
    
    public Lavadora(double precioBase, double peso, ConsumoEnergetico consumoEnergetico, Color color, int carga){
        super(precioBase,peso, consumoEnergetico,color);
        this.carga=carga;
    }
    
    /**
     * Devuelve la carga de la lavadora
     * @return
     */
    public int getCarga() {
        return carga;
    }
  
    /**
     * Precio final de la lavadora
     * @return precio final de la lavadora
     */
    @Override
    public double getPrecioFinal(){
        //Invocamos el método getPrecioFinal del método padre
        double precioFinal=super.getPrecioFinal();
  
        //añadimos el código necesario
        precioFinal += (carga>30)? 50:0;
        /*if (carga>30){
            precioFinal += 50;
            System.out.println("Carga mayor de 30. Aplicado plus de 50 euros");
        }*/
  
        return precioFinal;
    }

    @Override
    public String toString() {
        return super.toString()+" Lavadora{" + "carga=" + carga + '}';
    }
  
   
}