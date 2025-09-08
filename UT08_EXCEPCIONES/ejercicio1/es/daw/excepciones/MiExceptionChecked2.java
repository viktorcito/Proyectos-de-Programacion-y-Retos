package es.daw.excepciones;

/**
 * FORMA 2: usando el constructor del padre
 * @author melola
 */
public class MiExceptionChecked2 extends Exception{
    private int dia;
    private static final String MENSAJE="Número de día fuera de rango";

    public MiExceptionChecked2(int dia) {
        super(MENSAJE+" : "+dia); //Si paso el mensaje al padre
        this.dia = dia;
    }

    public int getDia() {
        return dia;
    }

}
