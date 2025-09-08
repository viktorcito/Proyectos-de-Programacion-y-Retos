/*
 * https://github.com/profeMelola/Programacion_2022-23/tree/main/UT06_UT07_POO/Herencia_vs_Interface#ejercicio-para-comparar-abstract-e-interface
 */
package es.daw.poo2.abstractvsinterface;

import es.daw.poo2.abstractvsinterface.model.DocumentoPDF;
import es.daw.poo2.abstractvsinterface.model.DocumentoWord;
import es.daw.poo2.abstractvsinterface.model.ServicioValidacion;
import es.daw.poo2.abstractvsinterface.model.Video;

/**
 *
 * @author melola
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        DocumentoPDF doc1 = new DocumentoPDF(true, "Introducción a Java");
        
        DocumentoWord doc2 = new DocumentoWord("v1.0", "Conceptos de Clean Code");
        
        Video video1 = new Video("MP4", "Aprende Java sin morir en el intento", 23.567f);
        
        ServicioValidacion sv = new ServicioValidacion();
        
        sv.addRecurso(doc1);
        sv.addRecurso(doc2);
        sv.addRecurso(video1);
        
        sv.validar();
        
        
    }
    
}
