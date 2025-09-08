package es.daw.carrera.model;


/**
 *
 * @author melol
 */
public class Corredor extends Participante{
    private SEXO sexo;

    public Corredor(SEXO sexo, String nombre, String apellido1, String apellido2, String dni, String direccionCompleta, int numTelef, String email) {
        super(nombre, apellido1, apellido2, dni, direccionCompleta, numTelef, email);
        this.sexo = sexo;
    }

    @Override
    public void setPuntosTotales(){
        this.setPuntos(this.setTiempoMedioCarrera()*0.15);
        System.out.println("[Corredor, setPuntosTotales]getTiempoMedioCarrera():"+getTiempoMedioCarrera());        
        System.out.println("[Corredor, setPuntosTotales]getPuntos():"+this.getPuntos());

    }

    public SEXO getSexo() {
        return sexo;
    }

    public void setSexo(SEXO sexo) {
        this.sexo = sexo;
    }

    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Corredor{");
        sb.append(super.toString());
        sb.append("sexo=" + sexo + '}');
        return sb.toString();
    }
    
    
    
}
