package es.daw.poo2.empleados.model;

import java.util.Objects;

/**
 *
 * @author melol
 */
public class Tecnico extends Operario {

    private String especialidad;

    public Tecnico() {
    }

    public Tecnico(String nombre, String especialidad) {
        super(nombre);
        this.especialidad = especialidad;
    }

    @Override
    public String toString() {
        return super.toString() + " -> Tecnico";
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 43 * hash + Objects.hashCode(this.especialidad);
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
        final Tecnico other = (Tecnico) obj;
        if (!Objects.equals(this.especialidad, other.especialidad)) {
            return false;
        }
        return true;
    }
}
