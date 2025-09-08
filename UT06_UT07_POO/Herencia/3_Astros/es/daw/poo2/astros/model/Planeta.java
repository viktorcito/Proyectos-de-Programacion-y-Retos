package es.daw.poo2.astros.model;

import java.util.ArrayList;

public class Planeta extends Astro {

    // Atributos
    private double distSol;
    private double orbSol;
    private ArrayList<Satelite> satelites;

    // Constructor
    public Planeta(String nombre, double radio, double rotEje, double masa, double tempMedia, double gravedad, double distSol, double orbSol) {
        super(nombre, radio, rotEje, masa, tempMedia, gravedad);
        this.distSol = distSol;
        this.orbSol = orbSol;

        this.satelites = new ArrayList<>();
    }


    // Añadimos un satélite
    public void addSatelite(Satelite s) {
        if (s != null)
            satelites.add(s);
    }

    // GETTERS Y SETTERS
    public double getDistSol() {
        return distSol;
    }

    public void setDistSol(double distSol) {
        this.distSol = distSol;
    }

    public double getOrbSol() {
        return orbSol;
    }

    public void setOrbSol(double orbSol) {
        this.orbSol = orbSol;
    }

    public void setSatelites(ArrayList<Satelite> satelites) {
        this.satelites = satelites;
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("\n*** "+getClass().getSimpleName()+" "+super.getNombre()+" ***");
        sb.append(super.toString());
        sb.append("\ndistSol=").append(distSol);
        sb.append("\norbSol=").append(orbSol);
        if (satelites.size() > 0 ){
            sb.append("\n\tLista de satélites:");
            /*int cont=1;
            for(Satelite s:satelites){
                if (s != null){
                    sb.append("\n\t- Satélite " + cont + ": " + s.getNombre());
                    cont++;
                }
            }*/
            for (int i = 0; i < satelites.size(); i++) {
                if (satelites.get(i) != null)
                    sb.append("\n\t- Satélite " + (i+1) + ": " + satelites.get(i).getNombre());
            }
            
        }
        else sb.append("\n\t No tiene satélites");
        return sb.toString();
    }
    
    

}
