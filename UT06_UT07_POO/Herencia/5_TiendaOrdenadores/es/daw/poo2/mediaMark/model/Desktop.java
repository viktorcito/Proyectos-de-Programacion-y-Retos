
package es.daw.poo2.mediaMark.model;

/**
 *
 * @author melol
 */
public class Desktop extends Ordenador{
    private String tipo;
    
    /*
        Las variables declaradas como final indican que su valor no puede ser cambiado después de ser asignado. 
        Esto significa que una vez que se ha asignado un valor a una variable final, 
        no se puede reasignar un nuevo valor a esa variable. ES UNA CONSTANTE

        Las variables declaradas como static son variables de clase, lo que significa que 
        pertenecen a la clase en lugar de a una instancia específica de la clase (objeto). 
        Esto significa que solo hay una única copia de esa variable para todas las instancias de la clase, 
        en lugar de tener una copia de esa variable para cada instancia de la clase.

        Cuando se combinan las dos palabras clave final y static, 
        se obtiene una variable de clase que no puede ser reasignada después de ser inicializada.
        Solo hay una única copia para todas las instancias de la clase.
    */    
    
    public final static String SLOGAN ="Es el que más pesa, pero el que menos cuesta";
    
    public final static int GARANTIA_INICIAL = 6;
    public final static int GARANTIA_LIMITE = 24;

    public Desktop(String tipo, String codigo, float precio) {
        super(codigo, precio);
        this.tipo = tipo;
        
        super.setDuracion(GARANTIA_INICIAL);
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    
    @Override
    public void setDuracion(int duracion) {
        if (duracion <= GARANTIA_LIMITE) super.setDuracion(duracion);
        
        // A GUSTO DEL CONSUMIDOR: si la duración supera la garantía límite
        // o lo dejo como está (garantía inicial) o le asigno la garantí límite
    }

    @Override
    public String toString() {
        return "Desktop{ "+super.toString()+" tipo=" + tipo + '}';
    }

    
    
    
}
