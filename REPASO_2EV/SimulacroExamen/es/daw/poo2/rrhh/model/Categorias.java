package es.daw.poo2.rrhh.model;

/**
 *
 * @author melol
 */
public enum Categorias {
    DIRECTIVO(3),
    SENIOR(2),
    JUNIOR(1);
            
    private int factor;
    
    private Categorias(int factor){
        this.factor = factor;
    }

    public int getFactor() {
        return factor;
    }
    
    
    
}
