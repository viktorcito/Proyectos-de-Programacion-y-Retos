/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package es.daw.poo2.empleados.model;

/**
 *
 * @author melol
 */
public class Operario extends Empleado{

    private int codOperario;

    public Operario(int codOperario, String nombre) {
        super(nombre);
        this.codOperario = codOperario;
    }
    
    //constructor con un parámetro
    public Operario(String nombre) {
        super(nombre);
    }

    //constructor por defecto
    public Operario() {
    }

    //modificación del método toString() para mostrar el mensaje adecuado                                         
    @Override
    public String toString() {
        return super.toString() + " -> Operario";
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 79 * hash + this.codOperario;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Operario other = (Operario) obj;
        
        if (codOperario == 0) 
            return super.equals(obj);
        else return this.codOperario == other.codOperario;
    }
    
    
}