package es.daw.carrera.model;

import es.daw.carrera.util.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author melol
 */
public abstract class Participante implements Comparable<Participante>{
    private static int contDorsal = 1;
    private String nombre, apellido1, apellido2, dni, direccionCompleta;
    private int numTelef;
    private String email;
    private int dorsal;
    
    private int tiempoMedioCarrera; //será != 0 si se ha completado
    
    private double puntos;
    
    private int[] tiempos;//tiempo medido en segundos. Va a ver tantos tiempos como puntos kms.
    
    //private static String regx = "^(.+)@(.+)$";
    private static String regx = "^(.+)@(.+)$";
    
    public enum SEXO  { MASCULINO, FEMENINO };
    
    //Constructor
    public Participante(String nombre, String apellido1, String apellido2, String dni, String direccionCompleta, int numTelef, String email) {
        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.dni = dni;
        this.direccionCompleta = direccionCompleta;
        this.numTelef = numTelef;
        setDorsal();
        setEmailCorrecto(email);
        
    }
    
    /**
     * setEmailCorrecto. Si no cumple la expresión regular le asigno una cadena vacía
     * @param email 
     */
    public void setEmailCorrecto(String email){
        /*if (!Utilidades.checkEmail(email))
            this.email = "";
        else
            this.email = email;*/
        
    }
    /**
     * Incrementa el número de dorsal cada vez que se da de alta un participante
     * @return 
     */
    private void setDorsal(){
        this.dorsal = contDorsal++;
    }
    
    /**
     * Dependiendo del número de puntos kms de la carrera
     * @param NumPuntoskms 
     */
    public void inicializaPuntoskms(int NumPuntoskms){
        this.tiempos = new int[NumPuntoskms];
    }
    
    //Getters
    public int getDorsal(){
        return dorsal;
    }
    
    public String getNombre() {
        return nombre;
    }

    public String getApellido1() {
        return apellido1;
    }

    public String getApellido2() {
        return apellido2;
    }

    public String getDni() {
        return dni;
    }

    public String getDireccionCompleta() {
        return direccionCompleta;
    }

    public int getNumTelef() {
        return numTelef;
    }

    public String getEmail() {
        return email;
    }
    
    public int getTiempoMedioCarrera(){
        return tiempoMedioCarrera;
    }

    
    public int[] getTiempos(){
        return tiempos;
    }
    
    // -----------
    public double getPuntos() {
        return puntos;
    }
    public void setPuntos(double puntos){
        this.puntos = puntos;
    }
    // --------------
    
    /**
     * setTiempoMedioCarrera: solo en el caso de que estén completado todos los tiempos
     * @return 
     */
    public int setTiempoMedioCarrera() {
        //Compruebo que el array tiene todos los tiempos para calcular el tiempo medio de carrera
        boolean noCompletadaCarrera = false;
        
        System.out.println("[setTiempoMedioCarrera] tiempos:"+Arrays.toString(tiempos));
        
        //Para obtener el tiempo medio de carrera recorro los tiempos y lo divido
        for (int i=0; i< tiempos.length;i++){
            if (tiempos[i] != 0){
                tiempoMedioCarrera += tiempos[i];
            }else 
                noCompletadaCarrera = true;
                
        }
        
        tiempoMedioCarrera = tiempoMedioCarrera / tiempos.length;
        
        System.out.println("[setTiempoMedioCarrera] tiempoMedioCarrera:"+tiempoMedioCarrera);
        
        if (noCompletadaCarrera) return 0; //devuelvo cero si no ha completado la carrera
        else return tiempoMedioCarrera;
        
    }

    /**
     * getTiempoTotalCarrera: solo en el caso de que estén completados todos los tiempos
     * @return 
     */
    public int getTiempoTotalCarrera(){
        int tiempoTotal = 0;
        
        for (int i=0; i < tiempos.length;i++){
            if (tiempos[i] != 0)
                tiempoTotal += tiempos[i];
            else{
                i=tiempos.length;
                tiempoTotal=0;
            }
        }
        
        return tiempoTotal;
    }
    

    /**
     * addCrono
     * @param ptoKm
     * @param tiempo
     * @throws Exception 
     */
    public void addCrono(int ptoKm, int tiempo) throws ExcepcionTiempo{
        // Los puntos kilométricos se indican empezando por el 1
        // En el caso de que ptoKm sea mayor que 1 (no es el primer crono),
        // Compruebo previamente si el ptoKm anterior tiene un tiempo distinto de cero
        if (ptoKm > 1) {
            if (tiempos[ptoKm - 2] == 0){
                tiempos[ptoKm - 1] = tiempo;
                throw new ExcepcionTiempo(dorsal,ptoKm-1);
            }
            else tiempos[ptoKm - 1] = tiempo;                
        }
        else tiempos[ptoKm - 1] = tiempo;
    }
    
    /**
     * Considero que el participante ha abandonado si no hay tiempo de meta (último tramo)
     * @return 
     */
    public boolean esAbandono(){
        if (tiempos[tiempos.length-1] == 0) return true;
        else return false;
            
    }
    
    // --------------------------------------------------
    // Método abstracto
    public abstract void setPuntosTotales();
    // --------------------------------------------------

    @Override
    public String toString() {
        return "Participante{" + "dorsal="+dorsal +", nombre=" + nombre + ", apellido1=" + apellido1 + ", apellido2=" + apellido2 + ", dni=" + dni + ", direccionCompleta=" + direccionCompleta + ", numTelef=" + numTelef + ", email=" + email + ", tiempoMedioCarrera=" + tiempoMedioCarrera + ", puntos=" + puntos + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 61 * hash + Objects.hashCode(this.dni);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        /*
        // Para comprobar que el participante existe tanto en Ciclista como Corredor
        // CUIDADÍN
        if (this == obj) {
            return true;
        }*/
        
        if (obj == null) {
            return false;
        }
        
        /*
        // Para comprobar que el participante existe tanto en Ciclista como Corredor
        if (getClass() != obj.getClass()) {
            return false;
        }*/
        
        final Participante other = (Participante) obj;
        if (!Objects.equals(this.dni, other.dni)) {
            return false;
        }
        
        return true;
    }

    /**
     * Criterio para la ordenación natural, por número dorsal
     * @param otro
     * @return 
     */
    @Override
    public int compareTo(Participante otro) {
//        Integer d1 = Integer.valueOf(dorsal);
//        Integer d2 = Integer.valueOf(otro.getDorsal());
//        return d1.compareTo(d2);

        return dorsal - otro.getDorsal();

//          return Integer.compare(dorsal, otro.getDorsal());
        
        
    }
    
}
