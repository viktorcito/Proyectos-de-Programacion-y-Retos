package es.daw.poo2.abstractvsinterface.model;

import java.util.ArrayList;

/**
 *
 * @author melola
 */
public class ServicioValidacion {

    private ArrayList<Validator> lista;
    //private ArrayList<Documento> lista = new ArrayList<>();

    // No es necesario crear el constructor por defecto
    public ServicioValidacion() {
        lista = new ArrayList<>();
    }

    public void addRecurso(Validator recurso) {
        lista.add(recurso);
    }

    public void validar() {
        for (Validator recurso : lista) {
            recurso.validar();
        }
    }

}
