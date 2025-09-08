package es.daw.poo2.horaApp.model;

public class Hora {

    private int hora, minutos; 

   
    public Hora(int hora, int minutos) { 
        this.hora = 0;
        this.minutos = 0;
        
        if (!setHora(hora)) { 
        //if (setHora(hora) == false) { 
            System.out.println("La hora es incorrecta");
        }
        if (!setMinutos(minutos)) {
            System.out.println("Los minutos no son válidos");
        }
    }

    public void inc() { 
        minutos++;
        if (minutos > 59) { 
            minutos = 0; 
            hora++; 
            if (hora > 23) { 
                hora = 0; 
            }
        }
    }

    public boolean setMinutos(int minutos) {
        boolean correcto = false;
        if (0 <= minutos && minutos < 60) { 
            this.minutos = minutos;
            correcto = true;
        }
        return correcto;
    }

    public boolean setHora(int hora) {
        boolean correcto = false;
        if (hora >= 0 && hora < 24) { 
            this.hora = hora;
            correcto = true;
        }
        return correcto;
    }

    public int getHora() {
        return hora;
    }

    public int getMinutos() {
        return minutos;
    }

    @Override 
    public String toString() {
        String result;
        result = hora + ":" + minutos;
        return result;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + this.hora;
        hash = 59 * hash + this.minutos;
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
        final Hora other = (Hora) obj;
        if (this.hora != other.hora) {
            return false;
        }
        return this.minutos == other.minutos;
    }

    
    
    
}

