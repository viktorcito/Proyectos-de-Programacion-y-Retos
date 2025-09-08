package es.daw.poo2.horaApp.model;

public class HoraExacta extends Hora {

    private int segundos;

    public HoraExacta(int hora, int minutos, int segundos) {
        super(hora, minutos);
        if (!setSegundos(segundos)) {
            System.out.println("Segundos incorrectos ");
        }
    }

    public boolean setSegundos(int segundos) {
        boolean correcto = false;
        if (0 <= segundos && segundos < 60) {
            this.segundos = segundos;
            correcto = true;
        }
        return correcto;
    }

    @Override
    public void inc() {
        segundos++;
        if (segundos > 59) {
            segundos = 0;
            super.inc(); 
        }
    }

    @Override
    public String toString() {
        String result = super.toString();
        result += ":" + segundos;
        return result;
    }

    
    
    
    /*
    @Override
    public boolean equals(Object o) {
        HoraExacta otroReloj = (HoraExacta) o; 
        boolean iguales;
        if (this.hora == otroReloj.hora 
                && this.minutos == otroReloj.minutos
                && this.segundos == otroReloj.segundos) {
            iguales = true; 
        } else {
            iguales = false;
        }
        return iguales;
    } */
    /*@Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + this.segundos;
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
        final HoraExacta other = (HoraExacta) obj;

        return super.equals(obj) && this.segundos == other.segundos;
    }*/

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + this.segundos;
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
        final HoraExacta other = (HoraExacta) obj;
        return super.equals(other) && this.segundos == other.segundos;
    }
}
