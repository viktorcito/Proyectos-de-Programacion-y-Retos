package es.daw.poo2.astros.model;


public class Satelite extends Astro {

    // Atributos
    private double distPlaneta;
    private double orbPlaneta;
    private Planeta planeta;

    // Constructor
    public Satelite(String nombre, double radio, double rotEje, double masa, 
            double tempMedia, double gravedad, double distPlaneta, double orbPlaneta, Planeta planeta) {
        super(nombre, radio, rotEje, masa, tempMedia, gravedad);
        this.distPlaneta = distPlaneta;
        this.orbPlaneta = orbPlaneta;
        this.planeta = planeta;
        if (planeta != null)
            planeta.addSatelite(this);
            
    }


    // GETTERS Y SETTERS
    
    public double getDistPlaneta() {
        return distPlaneta;
    }

    public void setDistPlaneta(double distPlaneta) {
        this.distPlaneta = distPlaneta;
    }

    public double getOrbPlaneta() {
        return orbPlaneta;
    }

    public void setOrbPlaneta(double orbPlaneta) {
        this.orbPlaneta = orbPlaneta;
    }

    public Planeta getPlaneta() {
        return planeta;
    }

    public void setPlaneta(Planeta planeta) {
        this.planeta = planeta;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("\n*** "+getClass().getSimpleName()+" "+super.getNombre()+" ***");
        sb.append(super.toString());
        sb.append("\ndistPlaneta=").append(distPlaneta);
        sb.append("\norbPlaneta=").append(orbPlaneta);
        sb.append("\nplaneta=").append(planeta.getNombre());
        return sb.toString();
    }

    
}
