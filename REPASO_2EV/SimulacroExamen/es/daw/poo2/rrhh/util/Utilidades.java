package es.daw.poo2.rrhh.util;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author melol
 */
public class Utilidades {

    /**
     * Método que calcula el número de días desde una fecha anterior a otra.
     * @param dateBefore String con la fecha anterior
     * @param dateAfter String con la fecha posterior
     * @return 
     */
    public static int calculaDiasEntreFechas(LocalDate dateBefore, LocalDate dateAfter) {

        //calculating number of days in between
        return (int)ChronoUnit.DAYS.between(dateBefore,dateAfter);

    }
    
    
    /**
     * Método que devuelve verdadero/falso dependiendo de si se cumple la 
     * expresión regular
     * @param expresionRegular String con la expresión regular
     * @param cadena String con la cadena de texto a validar
     * @return 
     */
    public static boolean checkExpresionRegular(String expresionRegular, String cadena){
        Pattern pat = Pattern.compile(expresionRegular);
        Matcher mat = pat.matcher(cadena);
        return (mat.matches());
    }
}
