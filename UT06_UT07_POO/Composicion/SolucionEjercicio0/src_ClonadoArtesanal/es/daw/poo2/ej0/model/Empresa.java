
package es.daw.poo2.ej0.model;

/**
 *
 * @author melola
 */
public class Empresa {

    private String cif;
    private Direccion dirección;

//    public Empresa(){
//        
//    }
    
    public Direccion getDirección() {
        return dirección;
    }

    public void setDirección(Direccion dirección) {
        this.dirección = dirección;
    }

    public String getCif() {
        return cif;
    }

    public void setCif(String cif) {
        this.cif = cif;
    }

    @Override
    public String toString() {
        return "Empresa{" + "cif=" + cif + ", direccion=" + dirección + '}';
    }

    
}
