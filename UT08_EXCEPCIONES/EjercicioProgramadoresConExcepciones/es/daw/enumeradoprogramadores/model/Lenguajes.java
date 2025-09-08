package es.daw.enumeradoprogramadores.model;

/**
 *
 * @author melola
 */
public enum Lenguajes {
    
    JAVA(4), 
    PHP(2), 
    C(5), 
    PERL(6), 
    RUBY(3), 
    PYTHON(4),
    UNDEFINED(0);
    
    private int aniosAprendizaje;
    
    private Lenguajes(int aniosAprendizaje){
        this.aniosAprendizaje = aniosAprendizaje;
    }
    
    public int getAniosAprendizaje(){
        return aniosAprendizaje;
    }
    
}
