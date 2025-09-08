

package es.daw.poo2.electrodomestico.model;

/**
 * 
 * @author idesadadaw
 *
 */

public abstract class Electrodomestico {

    //VALORES POR DEFECTO USANDO CONSTANTES
    protected final static String COLOR_DEF="Blanco";
    protected final static char CONSUMO_ENERGETICO_DEF='F';
    protected final static double PRECIO_BASE_DEF=100;
    protected final static double PESO_DEF=5;
    
    private final static String[] COLORES = {"BLANCO","NEGRO","ROJO","AZUL","GRIS"};
    private final static char[] CONSUMO_ENERGETICO = {'A','B','C','D','E','F'};
    private final static int[]  SUPLEMENTO_ENERGETICO ={100,80,60,50,30,10};
    
    //ATRIBUTOS
    private double precioBase;
    private String color;
    private char consumoEnergetico;
    private double peso;
   
    //MÉTODO ABSTRACTO
    //public abstract double getPrecioFinal();
    
    //CONSTRUCTORES
    /**
     * Contructor por defecto
     */
    public Electrodomestico(){
        //this(PRECIO_BASE_DEF, PESO_DEF, CONSUMO_ENERGETICO_DEF, COLOR_DEF);
        
//        this.precioBase = PRECIO_BASE_DEF;
//        this.peso = PESO_DEF;
//        this.consumoEnergetico = CONSUMO_ENERGETICO_DEF;
//        this.color = COLOR_DEF;
        
        this(PRECIO_BASE_DEF,PESO_DEF);
        
    }
   
    /**
     * Contructor con 2 parametros
     * @param precioBase del electrodomestico
     * @param peso del electrodomestico
     */
    public Electrodomestico(double precioBase, double peso){
        //this(precioBase, peso, CONSUMO_ENERGETICO_DEF, COLOR_DEF);
                
        this.precioBase = precioBase;
        this.peso = peso;
        this.consumoEnergetico = CONSUMO_ENERGETICO_DEF;
        this.color = COLOR_DEF;
        
    }
   
    /**
     * Constructor con 4 parametros
     * @param precioBase
     * @param peso
     * @param consumoEnergetico
     * @param color
     */
    public Electrodomestico(double precioBase, double peso, char consumoEnergetico, String color){
        this.precioBase=precioBase;
        this.peso=peso;
        comprobarConsumoEnergetico(consumoEnergetico);
        comprobarColor(color);
    }
    
    // OTROS MÉTODOS
    /**
     * Comprueba el color y le asigna el color por defecto si no se encuentra dentro de la lista de enumerados
     * @param color 
     */
    private void comprobarColor(String color){
        boolean encontrado=false;
        int i = 0;
        
        while( !encontrado && (i < COLORES.length)){
            if (COLORES[i].equalsIgnoreCase(color))
                encontrado=true;
            i++;
        }
        
        this.color = (encontrado)? color:COLOR_DEF;
        
          
    }
      
    /**
     * Comprueba el consumo energetico
     * Solo mayusculas, si es una 'a' no lo detecta como una 'A'
     * @param consumoEnergetico
     */
    private void comprobarConsumoEnergetico(char consumoEnergetico){

        // FORMA 1
        // Código ASCII: del 65 al 70 son  A,B, ...F
        /*if(consumoEnergetico>=65 && consumoEnergetico<=70){
            this.consumoEnergetico=consumoEnergetico;
        }else{
            this.consumoEnergetico=CONSUMO_ENERGETICO_DEF;
        }*/
        
        // FORMA 2: con expresión regular. Que el String matches "ABCDEF"...
        
        // FORMA 3: con String.contains....
        
        
        // FORMA 4
        boolean encontrado=false;
        int i = 0;
        
        while( !encontrado && (i < CONSUMO_ENERGETICO.length)){
            if (CONSUMO_ENERGETICO[i] == consumoEnergetico)
                encontrado=true;
            i++;
        }
        
        //if (!encontrado) this.consumoEnergetico= CONSUMO_ENERGETICO_DEF;
        this.consumoEnergetico = (encontrado)? consumoEnergetico:CONSUMO_ENERGETICO_DEF;
        
    }
   
    //Métodos publicos
    /**
     * Devuelve el precio base del electrodomestico
     * @return precio base del electrodomestico
     */
    public double getPrecioBase() {
        return precioBase;
    }
    /**
     * Devuelve el color del electrodomestico
     * @return color del elesctrodomestico
     */
    public String getColor() {
        return color;
    }
   
     /**
     * Devuelve el consumo energetico del electrodomestico
     * @return consumo energetico del electrodomestico
     */
    public char getConsumoEnergetico() {
        return consumoEnergetico;
    }
    /**
     * Devuelve el peso del electrodomestico
     * @return peso del electrodomestico
     */
    public double getPeso() {
        return peso;
    }
    /**
     * Precio final del electrodomestico
     * @return precio final del electrodomestico
     */
    public double getPrecioFinal(){
        double precioFinal=0;

        // 1. Según su consumo energético
        int i=0;
        while(CONSUMO_ENERGETICO[i] != consumoEnergetico)
            i++;
               
        precioFinal=precioBase+ SUPLEMENTO_ENERGETICO[i];
        
   
        // 2. Cálculo del plus al precio base según su peso
        if(peso>=0 && peso<19){
            //System.out.println("Peso entre 0 y 19 -> Aplicado plus de 10" );
            precioFinal+=10;
        }else if(peso>=20 && peso<49){
            //System.out.println("Peso entre 20 y 49 -> Aplicado plus de 50" );
            precioFinal+=50;
        }else if(peso>=50 && peso<=79){
            //System.out.println("Peso entre 50 y 79 -> Aplicado plus de 80" );
            precioFinal+=80;
        }else if(peso>=80){
            //System.out.println("Peso mayor de 80 -> Aplicado plus de 100" );
            precioFinal+=100;
        }
   
        return precioFinal;
    }

    @Override
    public String toString() {
        return "Electrodomestico{" + "precioBase=" + precioBase + ", color=" + color + ", consumoEnergetico=" + consumoEnergetico + ", peso=" + peso + '}';
    }

   
}