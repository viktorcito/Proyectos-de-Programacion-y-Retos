package es.daw.carrera.model;

import java.util.ArrayList;

/**
 *
 * @author melol
 */
public class Carrera {

    private int tiempoLimite; //en segundos
    private String nombreCarrera;
    private int numPuntosKms;
    private ArrayList<Participante> participantes;
    
    private ArrayList<ExcepcionTiempo> excepciones;

    public Carrera(int tiempoLimite, String nombreCarrera, int numPuntosKms) {
        this.tiempoLimite = tiempoLimite;
        this.nombreCarrera = nombreCarrera;
        this.numPuntosKms = numPuntosKms;
        this.participantes = new ArrayList<>();
        this.excepciones = new ArrayList<>();
    }

    public int getTiempoLimite() {
        return tiempoLimite;
    }

    public String getNombreCarrera() {
        return nombreCarrera;
    }

    public int getNumPuntosKms() {
        return numPuntosKms;
    }

    public ArrayList<Participante> getParticipantes() {
        return (ArrayList<Participante>)participantes.clone();
    }

    /**
     *
     * @param participante
     * @return
     */
    public boolean addParticipante(Participante participante) {

        // falta comparar después si el participante ya esta inscrito
        /*for (Participante p : participantes) {
            if (p.equals(participante)) {
                System.out.println("ERROR DNI");
                return false;
            }
        }*/

        participantes.add(participante);

        return true;
    }

    /**
     * Método para comprobar si existe un participante con el mismo DNI
     *
     */
//    public boolean comprobarExisteParticipante(String dni) {
//        int cont = 0;
//        boolean encontrado = false;
//
//        if (participantes.size() > 0){
//            do {
//                Participante p = participantes.get(cont);
//                if (p.getDni().equals(dni)) {
//                    encontrado = true;
//                }
//                cont++;
//            } while (!encontrado && cont < participantes.size());
//        }
//        return encontrado;
//
//    }
    /**
     * Método para comprobar si existe un participante con el mismo DNI 
     * (usando el equals implementado en Participante)
     * @param p
     * @return 
     */
    public boolean comprobarExisteParticipante(Participante p){
        return participantes.contains(p);
    }

    /**
     *
     * @param numDorsal
     * @return
     * @throws Exception
     */
    public Participante encontrarParticipanteXDorsal(int numDorsal) throws Exception {
        int cont = 0;
        boolean noEncontrado = true;
        Participante p = null;

        do {
            p = participantes.get(cont); //realmente el número de dorsal coincide con el índice como se han creado los participantes
            if (numDorsal == p.getDorsal()) noEncontrado = false;
            cont++;
        } while (noEncontrado && cont < participantes.size());

        if (noEncontrado) {
            Exception e = new Exception("No se ha encontrado el participante para introducir datos");
            throw e;
        }

        return p;
    }

    /**
     * GESTIÓN DE EXCEPCIONES..............
     */
    public void addException(ExcepcionTiempo e){
        excepciones.add(e);
    }

    public ArrayList<ExcepcionTiempo> getExcepciones(){
        return (ArrayList<ExcepcionTiempo>)excepciones.clone();
    }
    
    @Override
    public String toString() {
        return "Carrera{" + "tiempoLimite=" + tiempoLimite + ", nombreCarrera=" + nombreCarrera + ", numPuntosKms=" + numPuntosKms + '}';
    }
    
    
    
}
