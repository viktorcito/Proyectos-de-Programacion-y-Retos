package es.daw.carrera.model;

/**
 *
 * @author melol
 */
public class Ciclista extends Participante{
    
    public Ciclista(String nombre, String apellido1, String apellido2, String dni, String direccionCompleta, int numTelef, String email) {
        super(nombre, apellido1, apellido2, dni, direccionCompleta, numTelef, email);
    }    

    
    @Override
    public void setPuntosTotales(){
        this.setPuntos(this.setTiempoMedioCarrera()*1.25);
        System.out.println("[Ciclista, setPuntosTotales]getTiempoMedioCarrera():"+getTiempoMedioCarrera());
        System.out.println("[Ciclista, setPuntosTotales]getPuntos():"+this.getPuntos());
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Ciclista{");
        sb.append(super.toString());
        return sb.toString();
    }
    
    
}
