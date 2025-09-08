/*
 * https://github.com/profeMelola/Programacion_2022-23/tree/main/UT06_UT07_POO/Herencia_vs_Interface#ejercicio-para-comparar-abstract-e-interface
 */
package es.daw.poo2.abstractvsinterface;

import es.daw.poo2.abstractvsinterface.dao.ValidatorDAO;
import es.daw.poo2.abstractvsinterface.model.DocumentoPDF;
import es.daw.poo2.abstractvsinterface.model.DocumentoWord;
import es.daw.poo2.abstractvsinterface.model.ServicioValidacion;
import es.daw.poo2.abstractvsinterface.model.Validator;
import es.daw.poo2.abstractvsinterface.model.Video;
import java.util.ArrayList;

/**
 *
 * @author melola
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        ValidatorDAO dao = new ValidatorDAO();
        ArrayList<Validator> recursos = dao.select();
        
        ServicioValidacion sv = new ServicioValidacion();
        
        for(Validator r: recursos)
            sv.addRecurso(r);
        
        sv.validar();
        
        
    }
    
}
