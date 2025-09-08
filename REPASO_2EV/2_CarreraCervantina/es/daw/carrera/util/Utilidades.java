package es.daw.carrera.util;


import es.daw.carrera.model.Corredor;
import es.daw.carrera.model.Participante;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author melol
 */
public class Utilidades {
        /**
     *
     * @param email
     * @return
     */
    public static boolean checkEmail(String email) {
        Pattern pat = Pattern.compile("^[\\w-]+(\\.[\\w-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
        Matcher mat = pat.matcher(email);
        if (mat.find()) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * AUXILIAR PORQUE ESTOY CARGANDO TODOS LOS CORREDORES YA EN UN ARRAYLIST
     *
     * @param dni
     * @param participantes
     * @return
     */
    public static boolean existeDNI(String dni, ArrayList<Participante> participantes) {
        int cont = 0;
        boolean encontrado = false;
        
        if (participantes.size() > 0) {
            do {

                Participante p = participantes.get(cont);
                if (p.getDni().equals(dni)) {
                    encontrado = true;
                }
                cont++;
            } while (!encontrado && cont < participantes.size());
        }


        return encontrado;

    }
}
