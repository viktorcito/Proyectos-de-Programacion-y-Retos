package es.daw.poo2.vehiculo.model;

/**
 *
 * @author melola
 */
public class Coche extends Vehiculo {

    // Atributos propios del coche
    private int numeroPuertas;
    private int capacidadMaletero;

    public Coche(int numeroPuertas, int capacidadMaletero, String matricula, String marca, String modelo, float potencia, int kilometros) {
        super(matricula, marca, modelo, potencia, kilometros);
        this.numeroPuertas = numeroPuertas;
        this.capacidadMaletero = capacidadMaletero;
    }

    public Coche(String matricula) {
        super(matricula);
    }

    public int getNumeroPuertas() {
        return numeroPuertas;
    }

    public void setNumeroPuertas(int numeroPuertas) {
        this.numeroPuertas = numeroPuertas;
    }

    public int getCapacidadMaletero() {
        return capacidadMaletero;
    }

    public void setCapacidadMaletero(int capacidadMaletero) {
        this.capacidadMaletero = capacidadMaletero;
    }

    @Override
    public String toString() {
        //return "Coche{" + super.toString() +"numeroPuertas=" + numeroPuertas + ", capacidadMaletero=" + capacidadMaletero + '}';
        
        StringBuilder sb = new StringBuilder("COCHE:\n");
        sb.append("kilometros: ");
        sb.append(super.getKilometros()+"\n");
        sb.append("matricula: ");
        sb.append(super.getMatricula()+"\n");
        
        //... resto de atributos obtenidos con getters....
        sb.append("capacidad maletero: ");
        sb.append(this.capacidadMaletero+"\n");
        sb.append("numero de puertas: ");
        sb.append(this.numeroPuertas+"\n");
        
        return sb.toString();
    }
    
    

}
