package es.daw.poo2.rrhh.exceptions;

/**
 *
 * @author melol
 */
public class FormatoDNIException extends Exception{
    private String DNI;

    public FormatoDNIException(String DNI) {
        super("El DNI  "+DNI+" tiene un formato incorrecto. Debe empezar por 8 dígitos y acabar con una letra en mayúsculas");
        this.DNI = DNI;
    }

    /*
    @Override
    public String getMessage() {
        return "El DNI  "+DNI+" tiene un formato incorrecto. Debe empezar por 8 dígitos y acabar con una letra en mayúsculas";
    }*/
            
    
}
