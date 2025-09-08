package es.daw.poo2.abstractvsinterface.dao;

import es.daw.poo2.abstractvsinterface.model.DocumentoPDF;
import es.daw.poo2.abstractvsinterface.model.DocumentoWord;
import es.daw.poo2.abstractvsinterface.model.Validator;
import es.daw.poo2.abstractvsinterface.model.Video;
import java.util.ArrayList;

/**
 *
 * @author melola
 */
public class ValidatorDAO {

    private ArrayList<Validator> recursos;
    
    public ValidatorDAO(){
        
        if (recursos == null){
            recursos = new ArrayList<>();

            DocumentoPDF doc1 = new DocumentoPDF(true, "Introducción a Java");
            DocumentoWord doc2 = new DocumentoWord("v1.0", "Conceptos de Clean Code");
            Video video1 = new Video("MP4", "Aprende Java sin morir en el intento", 23.567f);

            recursos.add(doc1);
            recursos.add(doc2);
            recursos.add(video1);
        }
        
    }
    
    public ArrayList<Validator> select(){
        return new ArrayList<>(recursos);
    }
    
}
