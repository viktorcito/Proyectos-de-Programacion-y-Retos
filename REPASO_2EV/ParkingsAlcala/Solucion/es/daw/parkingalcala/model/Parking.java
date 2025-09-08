package es.daw.parkingalcala.model;

import java.util.ArrayList;

import es.daw.parkingalcala.excepciones.ParkingCompletoException;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

/**
 *
 * @author melola
 */
public abstract class Parking implements Profitable{

    private int id, capacidad;
    
    public static int contador = 0;
    
    private String nombre, direccion;
    
    //private double cantidadGanada;
    protected double cantidadGanada;
    
    private ArrayList<Coche> coches;
    
    private final int TARIFA = 5;
    
    private Seguro seguro;
    
    // Según se meten coches en los diferentes parkings
    public static int capacidadTotal = 0;
    public static int ocupacionTotal = 0;
    
    
    public Parking(String nombre, String direccion, int capacidad) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.capacidad = capacidad;
        coches = new ArrayList<>(); //Al crear el parking creo la lista de coches
                                    //para que puedan aparcar los coches
        
        contador++;
        this.id = contador;
        
        capacidadTotal += capacidad;
        
        // Para evitar problemas al trabajar con nulos creo un seguro por defecto
        this.seguro = new Seguro(0,"No asegurado", LocalDate.now());
        
    }

    /* Getter de todo, porsiaca */
    public int getId() {
        return id;
    }

    public static int getContador() {
        return contador;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public double getCantidadGanada() {
        return cantidadGanada;
    }

    public ArrayList<Coche> getCoches() {
        return coches;
    }
    
    /* Setters de los tres parámetros del constructor */

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    
    public void setSeguro(Seguro seguro){
        // ENCAPSULAR EL SEGURO!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
        Seguro miSeg = new Seguro(seguro.getNumPoliza(),seguro.getNombreAseguradora(),seguro.getFechaFinSeguro());
        this.seguro = miSeg;
    }

    /**
     * Método para obtener el % de ocupación local
     * @return 
     */
    private int getPorcentajeOcupacion(){
        float porcentaje =  ((float) coches.size()/ capacidad)*100; 
        return (int)porcentaje;
    }
    
    /**
     * Método para obtener el % de ocupación total
     * @return 
     */
    private int getPorcentajeOcupacionTotal(){
        float rdo = ((float)ocupacionTotal/capacidadTotal)*100;
        return (int)rdo;
    }
    
    // MÉTODOS PÚBLICOS
    /**
     * 
     * @param c
     * @throws ParkingCompletoException 
     */
    public void addCoche(Coche c) throws ParkingCompletoException{
        // Si el número de coches es menor que la capacidad puedo meter otro coche
        if (coches.size() < capacidad) {
            coches.add(c);
            ocupacionTotal++;
            if (!c.isEsElectrico())
                cantidadGanada += TARIFA;
        }
        else{
            ParkingCompletoException e = new ParkingCompletoException(nombre, capacidad);
            throw e;
        }
    }

    /**
     * 
     * @param posicion 
     */
    public void deleteCoche(int posicion){
        coches.remove(posicion);
    }
    
    /**
     * 
     * @return 
     */
    private int getNumero_Coches(){
        return coches.size();
    }
    
    /**
     * 
     * @return 
     */
    public String mostrarCoches(){
        StringBuilder sb = new StringBuilder();
        for (Coche c:coches) sb.append(c.toString()+"\n");
        return sb.toString();
    }
    
    /**
     * 
     * @return 
     */
    private String mostrarCochesElectricos(){
        StringBuilder sb = new StringBuilder();
        for (Coche c:coches) {
            if (c.isEsElectrico())
                sb.append(c.toString()+"\n");
        }
        return sb.toString();
    }
         
    private int getNumCochesElectricos(){
        int cont=0;
    
        for (Coche c: coches) if (c.isEsElectrico()) cont++;
            
        return cont;
    }
    
    @Override
    public String toString() {
        String mensaje = String.format("\n********* INFORMACIÓN DEL PARKING ****************"
                + "\nEl parking %s con id %d"
                + ", situado en %s, cuenta con una capacidad de %d coches."
                + "\nEl porcentaje de ocupación es del %d %%"
                + "\n\nEsta es la cantidad de coches aparcados en el parking: %d"
                + "\nSolo son eléctricos: %d"
                + "\n\nEn Alcalá hay %d plazas disponibles."
                + "\nEl porcentaje de ocupación total es del %d %%"
                + "\n\nEl seguro del parking está contratado con la aseguradora %s."
                + "\nEl número de póliza es %d y quedan %d días para que se cumpla el seguro."
                + "\n*************************************************************************",
                nombre,
                id,
                direccion,
                capacidad, 
                getPorcentajeOcupacion(),
                coches.size(),
                getNumCochesElectricos(),
                capacidadTotal,
                getPorcentajeOcupacionTotal(),
                seguro.getNombreAseguradora(),seguro.getNumPoliza(),ChronoUnit.DAYS.between(LocalDate.now(),seguro.getFechaFinSeguro()));
        return mensaje;
    }
    
    
    
    
}
