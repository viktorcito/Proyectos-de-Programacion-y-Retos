package es.daw.carrera.util;

import es.daw.carrera.model.Carrera;
import es.daw.carrera.model.Ciclista;
import es.daw.carrera.model.Corredor;
import es.daw.carrera.model.ExcepcionTiempo;
import es.daw.carrera.model.Participante;
import es.daw.carrera.model.Participante.SEXO;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author melol
 */
public class Pantalla {

    private static Scanner sc = new Scanner(System.in);

    /**
     * Pantalla para introducir los datos de la carrera y darla de alta
     * @return 
     */
    public static Carrera datosCarrera() {

        String nombre="";
        int numPuntosKm=0,segundos=0;
        
        /*System.out.println(" * DAR DE ALTA LA CARRERA:");
        System.out.println("Introduce el nombre de la carrera:");
        nombre = sc.nextLine();
        System.out.println("Introduce el número de puntos kms en los que se realizan controles:");
        numPuntosKm = sc.nextInt();
        System.out.println("Introduce el tiempo límite para completar la carrera:");
        segundos = sc.nextInt();*/

        nombre = "Carrera 2ev";
        segundos = 11500;
        numPuntosKm = 3;
        
        return new Carrera(segundos, nombre, numPuntosKm);

    }

    /**
     *
     * @param miCarrera
     * @return false si ha habido algún problema en la inscripción (¿de todos
     * los participantes?)
     */
    public static boolean inscripcionParticipantes(Carrera miCarrera) {
        /*String siOno = "S";
        do {
            System.out.println(" * DAR DE ALTA A LOS PARTICIPANTES:");
            sc.nextLine();
            System.out.println("Nombre:");
            String nombre = sc.nextLine();
            System.out.println("Apellido 1:");
            String apell1 = sc.nextLine();
            System.out.println("Apellido 2:");
            String apell2 = sc.nextLine();
            System.out.println("DNI:");
            String dni = sc.nextLine();
            System.out.println("Dirección completa:");
            String dir = sc.nextLine();
            System.out.println("Número teléfono:");
            int telefono = sc.nextInt();
            sc.nextLine();
            System.out.println("Email:");
            String email = sc.nextLine();
            //Pendiente controlar la expresión regular de email
            if (!checkEmail(email)) {
                email = "";
            }
            System.out.println("Participa en :\n[1].Carrera ciclista\n[2].Maratón femenina\n[3].Maratón masculina");
            int participa = sc.nextInt();
            Sexo sex = Sexo.FEMENINO; //por defecto
            switch (participa) {
                case 2:
                    sex = Sexo.FEMENINO;
                    break;
                case 3:
                    sex = Sexo.MASCULINO;
                    break;
            }

            System.out.println("¿Quieres introducir otro corredor? [S/N]");
            sc.nextLine();
            siOno = sc.nextLine();
        } while (siOno.equalsIgnoreCase("S"));*/

        
        // -----------------------------------------------------------------------------------------
        // CARGA DE PARTICIPANTES EN UN ARRAY AUXILIAR POR NO METER LOS DATOS POR CONSOLA
        // Si meto los corredores en un ArrayList luego puedo con un bucle hacer el inicializaPuntoskms del tirón
        ArrayList<Participante> participantes = new ArrayList<>();
        participantes.add(new Ciclista("Pepe", "A", "B", "11111111Y", "Dir 1", 111111111, "pp@mail.es"));
        participantes.add(new Ciclista("Pedro", "A", "B", "11111111A", "Dir 2", 222222222, "pe@mail"));
        
        //Truqui para que no aumente el idDorsal ya que sé que no se va a dar de alta porque el DNI está duplicado
        //if (!Utilidades.existeDNI("11111111A", participantes))
            participantes.add(new Corredor(SEXO.MASCULINO, "Pedro", "A", "B", "11111111A", "Dir 3", 333333333, "pe@gmail.es"));
        
        participantes.add(new Ciclista("Mario", "Z", "B", "11111111B", "Dir 4", 444444444, "ma@mail.es"));
        participantes.add(new Corredor(SEXO.MASCULINO, "Pedro", "B", "A", "11111111C", "Dir 5", 555555555, "pe@gmail.com"));
        participantes.add(new Corredor(SEXO.FEMENINO, "Ana", "C", "B", "10000000A", "Dir 6", 666666666, "an@mail.es"));
        participantes.add(new Corredor(SEXO.FEMENINO, "Ana", "B", "C", "01111111A", "Dir 7", 777777777, "an@mail.com"));
        participantes.add(new Corredor(SEXO.MASCULINO, "Pepe", "C", "B", "01111111B", "Dir 8", 888888888, "pp@mai.org"));
        participantes.add(new Corredor(SEXO.FEMENINO, "Blanca", "A", "B", "11111111D", "Dir 9", 999999999, "bl@gmail.com"));
        participantes.add(new Corredor(SEXO.MASCULINO, "Mario", "A", "B", "10000000Z", "Dir 10", 101010101, "ma@gmail.org"));
        participantes.add(new Ciclista("Pepe", "A", "A", "10000000Y", "Dir 11", 101111111, "pp@mail.es"));
        participantes.add(new Corredor(SEXO.MASCULINO, "Mario", "B", "A", "10000000B", "Dir 12", 100111111, "ma@ma.com"));

        //Para asignar a cada participante el número de cronos que va a almacenar. Podría haberlo pasado como constructor
        for (Participante p : participantes) {
            p.inicializaPuntoskms(3); //lo he puesto a pelo en base a los datos de prueba
        }
        // ------------------------------------------------------------------------------------------------

        // AÑADIR PARTICIPANTES A LA CARRERA
        //Como irá en un buble, cada vez que se incribe un participante se comprueba si ha habido algún problema en realizar la inscripción
        for (Participante p : participantes) {
            System.out.println("\t**** Añadiendo participante con dorsal <" + p.getDorsal() + "> y DNI <" + p.getDni() + ">");
            if (! miCarrera.comprobarExisteParticipante(p)){
            //if (! miCarrera.comprobarExisteParticipante(p.getDni())){
                miCarrera.addParticipante(p);
            }
            else
                System.out.println("\t\t**** No se ha añadido el participante por estar ya inscrito!");
        }

        // Por ahora considero que no hay problema al inscribir a todos los participantes.
        return true;
    }

    /**
     * carreraEnCurso
     *
     * @param miCarrera
     */
    public static void carreraEnCurso(Carrera miCarrera) {

        // Introducción de datos de los corredores
        // Dorsal
        // Punto de control
        // Tiempo cronometrado
        //A través del numDorsal busco el objeto en la lista de participantes
        //Le meto el tiempo en el punto de control
        int dorsal, puntoControl, tiempoCronometrado;
        Participante pAux = null;

        /*
        System.out.println("* Vas a introducir datos en tiempo real de la carrera.");
        String siOno = "S";
        do {
            System.out.println("Introduce dorsal:");
            //Compruebo que existe?????
            dorsal = sc.nextInt();

            System.out.println("En la carrera hay " + miCarrera.getNumPuntosKms() + " puntos de control.");
            System.out.println("Introduce el número del punto km (del 0 al " + (miCarrera.getNumPuntosKms() - 1) + "):");
            puntoControl = sc.nextInt();

            System.out.println("Introduce tiempo en segundos:");
            tiempoCronometrado = sc.nextInt();

            // ------------------
            try {
                // si me aseguro de que nunca van a modificar la lista de inscritos desde fuera de la carrera
                // puedo asegurar que el número de dorsal corresponde con el indice en el array
                // hay que buscar el participante            
                pAux = miCarrera.encontrarParticipanteXDorsal(dorsal);

            } catch (Exception e) {
                System.out.println(e.getMessage());
            } finally {
                
            }
            if (pAux != null) {
                System.out.println("* ENCONTRADO PARTICIPANTE CON DORSAL :" + dorsal);
                System.out.println(pAux);
                try{
                    pAux.addCrono(puntoControl,tiempoCronometrado);
                }catch(Exception e){
                    System.out.println(e.getMessage());
                }

            }

            System.out.println("¿Quieres introducir otro dato? [S/N]");
            sc.nextLine();
            siOno = sc.nextLine();

        } while (siOno.equalsIgnoreCase("S"));*/
        
        //TRUCO PARA CARGAR LOS DATOS
        int[] dorsales = {1, 1, 1, 2, 2, 3, 3, 4, 4, 4, 5, 5, 5, 6, 6, 7, 7, 8, 8, 8, 9, 9, 9, 10, 10, 10, 11, 11};
        int[] puntos = {1, 2, 3, 1, 3, 1, 2, 1, 2, 3, 1, 2, 3, 2, 3, 1, 2, 1, 2, 3, 1, 2, 3, 1, 2, 3, 1, 2};
        int[] tiempos = {1000, 2000, 3000, 1000, 3000, 1000, 2000, 1000, 2000, 4000, 1000, 1000, 2000, 1000, 1000, 2000, 2000, 1000, 1000, 1000, 2000, 1000, 1500, 1000, 1500, 1500, 1000, 1000};

        for (int i = 0; i < dorsales.length; i++) {
            try {
                pAux = miCarrera.encontrarParticipanteXDorsal(dorsales[i]);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            } finally {

            }
            if (pAux != null) {
                try {
                    pAux.addCrono(puntos[i], tiempos[i]);
                } catch (ExcepcionTiempo e) {
                    miCarrera.addException(e);
                }
            }
        }

    }


}
