package es.daw.carrera;

import es.daw.carrera.model.Carrera;
import es.daw.carrera.model.Ciclista;
import es.daw.carrera.model.Corredor;
import es.daw.carrera.model.Participante;
import es.daw.carrera.model.ExcepcionTiempo;
import es.daw.carrera.util.Pantalla;
import java.util.ArrayList;
import java.util.Comparator;

/**
 *
 * @author melol
 */
public class Main {

    static ArrayList<Participante> participantesInscritos = new ArrayList<>();
    static ArrayList<Participante> ciclistas = new ArrayList<>();
    static ArrayList<Participante> corredores = new ArrayList<>();
    static ArrayList<Participante> corredoras = new ArrayList<>();
    
    
    public static void main(String[] args) {

        // -------------------------------------------------------------------
        // 1. PANTALLA PARA CREAR LA CARRERA
        // Tiempo límete = 1 hora (3.600 segundos)
        // Puntos kms 4
        //Carrera miCarrera = new Carrera(3600, "Complu Mari", 4);
        Carrera miCarrera = Pantalla.datosCarrera();

        System.out.println("*****************************************");
        System.out.println("* INFO CARRERA: " + miCarrera.toString());
        System.out.println("*****************************************");

        // -------------------------------------------------------------------
        // 2. INSCRIPCIÓN DE LOS PARTICIPANTES
        Pantalla.inscripcionParticipantes(miCarrera);
        participantesInscritos = miCarrera.getParticipantes();
        // -------------------------------------------------------------------
        // 3. CARRERA EN CURSO
        Pantalla.carreraEnCurso(miCarrera);

        /*
        System.out.println("*****************************************");
        System.out.println("* LISTADO DE CRONOS POR ORDEN DE INSCRIPCIÓN:");
        for (Participante p : participantesInscritos) {
            System.out.println("++++++++++++++++++++++");
            System.out.println("PARTICIPANTE: " + p.getDorsal());
            System.out.println(Arrays.toString(p.getTiempos()));
            System.out.println("++++++++++++++++++++++");
        }
        System.out.println("*****************************************");*/

        // Una vez acabada la carrera hago el conteo de los puntos......
        asignarPuntos(miCarrera);
        
        // --------------------------------------------------------------------
        //4. SACAR INFORMES DE DATOS .....................
        System.out.println("*********************************");
        System.out.println("********** INFORMES *************");
        System.out.println("*********************************");
        //System.out.println("\n0. Listado completo de participantes inscritos:");
        //participantesInscritos.forEach(System.out::println);
        
        System.out.println("\n1. Listado completo de participantes ordenados alfabéticamente por primer y segundo apellido:");
        informe1();
        
        System.out.println("\n2. Listado 3 categorías por orden de dorsal:");
        informe2();
        
        System.out.println("\n3. Listado completo por orden de tiempos:");
        informe3();

        System.out.println("\n4. Mostrar listado de abandonos por las tres categorías:");
        informe4();
        
        System.out.println("\n5. Listado de todos los participantes por ptos descendente:");
        informe5();
        
        System.out.println("\n6. Listado de excepciones:");
        informe6(miCarrera);

    }
    
    /**
     * Listado completo de participantes ordenados alfabéticamente por primer y segundo apellido
     */
    private static void informe1(){
        participantesInscritos.sort((pa, pb) -> (pa.getApellido1() + pa.getApellido2()).compareTo(pb.getApellido1() + pb.getApellido2()));
        participantesInscritos.forEach(System.out::println);
    }

    /**
     * Listado 3 categorías por orden de dorsal
     */
    private static void informe2(){
        for (Participante p : participantesInscritos) {
            if (p instanceof Ciclista) {
                ciclistas.add((Ciclista)p);
            } else if (p instanceof Corredor) {
                Corredor c = (Corredor) p;
                if (c.getSexo() == Participante.SEXO.MASCULINO) {
                    corredores.add(c);
                } else {
                    corredoras.add(c);
                }
            }

        }
        System.out.println("\t2.1 Listado de ciclistas:");
        ciclistas.sort(Comparator.naturalOrder());
        ciclistas.forEach(System.out::println);

        System.out.println("\t2.1 Listado de corredores:");
        corredores.sort(Comparator.naturalOrder());
        corredores.forEach(System.out::println);

        System.out.println("\t2.1 Listado de corredoras:");
        corredoras.sort(Comparator.naturalOrder());
        corredoras.forEach(System.out::println);
    }
    
    /**
     * Listado completo por orden de tiempos
     */
    public static void informe3(){
        participantesInscritos.sort((pa, pb) -> Integer.valueOf(pa.getTiempoTotalCarrera()).compareTo(Integer.valueOf(pb.getTiempoTotalCarrera())));
        //participantesInscritos.forEach(System.out::println);
        for (Participante p : participantesInscritos) {
            if (p.getTiempoTotalCarrera() > 0){
                System.out.println("\t\t ---------------------------------");
                System.out.println("\t\t Dorsal:" + p.getDorsal());
                System.out.println("\t\t Tiempo Total Carrera:" + p.getTiempoTotalCarrera());
                System.out.println("\t\t ---------------------------------");
            }
        }
        System.out.println("\t3.1 Listado ciclistas por orden de tiempos:");
        for (Participante p : ciclistas) {
            if (p.getTiempoTotalCarrera() > 0) {
                System.out.println("\t\t ---------------------------------");
                System.out.println("\t\t Dorsal:" + p.getDorsal());
                System.out.println("\t\t Tiempo Total Carrera:" + p.getTiempoTotalCarrera());
                System.out.println("\t\t ---------------------------------");
            }
        }
        System.out.println("\t3.2 Listado corredores por orden de tiempos:");
        for (Participante p : corredores) {
            if (p.getTiempoTotalCarrera() > 0) {
                System.out.println("\t\t ---------------------------------");
                System.out.println("\t\t Dorsal:" + p.getDorsal());
                System.out.println("\t\t Tiempo Total Carrera:" + p.getTiempoTotalCarrera());
                System.out.println("\t\t ---------------------------------");
            }
        }
        System.out.println("\t3.3 Listado corredoras por orden de tiempos:");
        for (Participante p : corredoras) {
            if (p.getTiempoTotalCarrera() > 0) {
                System.out.println("\t\t ---------------------------------");
                System.out.println("\t\t Dorsal:" + p.getDorsal());
                System.out.println("\t\t Tiempo Total Carrera:" + p.getTiempoTotalCarrera());
                System.out.println("\t\t ---------------------------------");
            }
        }
    }
    
    /**
     * Mostrar listado de abandonos por las tres categorías
     */
    public static void informe4(){
        System.out.println("\t4.1 Listado abandonos de ciclistas:");
        for (Participante p : ciclistas) {
            if (p.esAbandono() ) {
                System.out.println("\t\t ---------------------------------");
                System.out.println("\t\t Abandono- Dorsal:" + p.getDorsal());
                System.out.println("\t\t ---------------------------------");
            }
        }
        System.out.println("\t4.2 Listado abandonos de corredores:");
        for (Participante p : corredores) {
            if (p.esAbandono() ) {
                System.out.println("\t\t ---------------------------------");
                System.out.println("\t\t Abandono- Dorsal:" + p.getDorsal());
                System.out.println("\t\t ---------------------------------");
            }
        }
        System.out.println("\t4.3 Listado abandonos de corredoras:");
        for (Participante p : corredoras) {
            if (p.esAbandono() ) {
                System.out.println("\t\t ---------------------------------");
                System.out.println("\t\t Abandono- Dorsal:" + p.getDorsal());
                System.out.println("\t\t ---------------------------------");
            }
        }
        
    }
    
    /**
     * Listado de todos los participantes por ptos descendente
     */
    public static void informe5(){
        //participantesInscritos.sort((pa,pb)->Double.valueOf(pb.getPuntos()).compareTo(Double.valueOf(pa.getPuntos())));
        participantesInscritos.sort((pa,pb)->Double.compare(pb.getPuntos(), pa.getPuntos()));
        //participantesInscritos.sort(Comparator.reverseOrder());
        //participantesInscritos.forEach(System.out::println);
        for(Participante p:participantesInscritos){
            System.out.println("Dorsal <"+p.getDorsal()+"> , puntos: "+p.getPuntos());
        }
    }
    
    /**
     * Listado de excepciones
     * @param miCarrera 
     */
    public static void informe6(Carrera miCarrera){
        for (ExcepcionTiempo e : miCarrera.getExcepciones()) {
            System.out.println(e.getMessage());
        }
    }
    
    /**
     * Una vez completada la carrera
     * @param miCarrera 
     */
    public static void asignarPuntos(Carrera miCarrera){
        for (Participante p : participantesInscritos) {
            p.setPuntosTotales(); //este método llamará a calcular el tiempo medio de la carrera y dará los puntos
            int tiempoTotal = p.getTiempoTotalCarrera();
            if (tiempoTotal > miCarrera.getTiempoLimite()) {
                System.out.println(">>>>>>>>MULTIPLICO POR DOS!!!!!!!!!!!!!!!!!! DORSAL:"+p.getDorsal());
                System.out.println(">>>>>>>>MULTIPLICO POR DOS!!!!!!!!!!!!!!!!!! DORSAL:"+p.getPuntos());
                p.setPuntos(p.getPuntos() * 2);
            }
        }
        
    }
    
}
