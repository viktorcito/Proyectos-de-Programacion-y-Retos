package es.daw.poo2.mediaMark.model;

/**
 *
 * @author melol
 */
public class Portatil extends Ordenador{
    // Atributos privados
    private float peso;
    
    // Atributos públicos constantes
    public final static String SLOGAN ="Ideal para sus viajes";
    public final static int GARANTIA_INICIAL = 12;
    public final static int GARANTIA_LIMITE = 60;
    

    public Portatil(float peso, String codigo, float precio) {
        super(codigo, precio);
        this.peso = peso;
        
        super.setDuracion(GARANTIA_INICIAL);
    }

    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    @Override
    public void setDuracion(int duracion) {
        if (duracion <= GARANTIA_LIMITE) super.setDuracion(duracion);
        
        // A GUSTO DEL CONSUMIDOR: si la duración supera la garantía límite
        // o lo dejo como está (garantía inicial) o le asigno la garantí límite
    }

    @Override
    public String toString() {
        return "Portatil{" +super.toString() +" peso=" + peso + '}';
    }
    
    
    
    
    
}
