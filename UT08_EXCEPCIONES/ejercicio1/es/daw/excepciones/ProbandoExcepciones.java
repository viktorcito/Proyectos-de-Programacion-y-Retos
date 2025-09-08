
package es.daw.excepciones;

import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author melola
 */
public class ProbandoExcepciones {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        // ---------------------------------------------------------------
        // -------- PROBANDO CON EXCEPCIONES DE TIPO UNCHECKED -----------
        // ---------------------------------------------------------------
        
        //System.out.println("*************** INICIO PRUEBAS UNCHECKED EXCEPTIONS ****************");
        //probarUnCheckExceptions();
        
        // -------------------------------------------------------------
        // -------- PROBANDO CON EXCEPCIONES DE TIPO CHECKED -----------
        // -------------------------------------------------------------
        
        //System.out.println("\n*************** INICIO PRUEBAS CHECKED EXCEPTIONS ****************");
        //probarCheckedExceptions();
        
        // -------------------------------------------------------------
        // -------- PROBANDO CON EXCEPCIONES PROPIAS -------------------
        // -------------------------------------------------------------
        
        //System.out.println("\n*************** INICIO PRUEBAS DE EXCEPCIONES PROPIAS ****************");
        probarExcepcionesPropias();
        
        System.out.println("CHIMPÚN!!!!!!!!!");
        
    }

    // ----------------------------------------------------------------------
    // ------------------- EXCEPCIONES UNCHECKED ------------------------------
    // ----------------------------------------------------------------------
    public static void probarUnCheckExceptions(){
        
        int a = 2, b = 0;

        try {
            
            // -----------------------------------------
            // Generando exception ArithmeticException
            System.out.println("* Generando ArithmeticException...");
            b = 1;//para que no se produzca el error
            int c = a / b;
            
            // --------------------------------------
            //Generando exception NullPointerException
            String cadena = null;
            System.out.println("* Generando NullPointerException...");
            cadena = "Hola";//para que no se produzca el error
            cadena.toLowerCase();
            
            // -------------------------------------
            //Generando excepciones: ArrayIndexOutOfBoundsException
            System.out.println("* Generando ArrayIndexOutOfBoundsException...");
            String[] mensajes = {"En un lugar "," de la Mancha "," de cuyo nombre "," no quiero acordarme"}; 
            
            //for(int i=0; i<=mensajes.length;i++)
            //para que no se produzca el error
            for(int i=0; i<mensajes.length;i++)
                System.out.println(mensajes[i].toLowerCase());
            
            // -----------------
            // Generando excepción NumberFormatException
            String str = "   12   ";
            System.out.println("* Generando NumberFormatException...");
            str="12"; //para que no se produzca el error
            int numero = Integer.parseInt(str);
            
            
        } catch (ArithmeticException e){
            System.err.println("1. Mensaje de la excepción: " + e.getMessage());
            //e.printStackTrace();
            System.out.println("\t\tOye, error de división por cero!!!!");
            // aquí gestionas lo que consideres si se ha producido la excepción...
        } catch (NullPointerException | ArrayIndexOutOfBoundsException e){
            // Quiero hacer el mismo tratamiento a las dos excepciones
            System.err.println("2.Mensaje null o index:"+e.getMessage());
        } catch (NumberFormatException e){
            System.err.println("3.NumberException:"+e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("4.Excepción general!!!!!");
        } finally{
            System.out.println("[FINALLY] SIEMPRE SIEMPRE PASA POR AQUÍ...");
        }
        
        System.out.println("**********>>>>>>>>> final del método probarUnCheckExceptions!!!!");
        
    }
    
    // ----------------------------------------------------------------------
    // ------------------- EXCEPCIONES CHECKED ------------------------------
    // ----------------------------------------------------------------------
    /**
     * 
     */
    public static void probarCheckedExceptions(){
        //writeString2File(); //sin throw
            
        try{
            writeString2FileConThrows(); //con throw
        }catch(FileNotFoundException e){
            System.err.println(e.getMessage());
        }
        
    }
    
    public static void writeString2File() {
    
        PrintWriter out = null;
        
        //out = new PrintWriter("ruta/fichero.txt");
            
        try{
            out = new PrintWriter("ruta/fichero.txt");
            out.append("hola");
        }catch(FileNotFoundException e){
            
            //Imaginad que todas las trazas las he volcado a un fichero de log...
            System.err.println("Error: la ruta del fichero no es correcta");
            e.printStackTrace();
            
        }finally{
            System.out.println("--> Voy a cerrar el PrintWriter");
            if (out != null) out.close();
        }
        
//        // TRY CON RECURSOS.... NO NECESITO EL FINALLY PORQUE SE CIERRAN LOS RECUSOS AUTOMÁTICAMENTE
//        try( PrintWriter out2 = new PrintWriter("ruta/fichero.txt") ){
//             out2.append("hola");
//        } catch (FileNotFoundException ex) {
//            System.err.println(ex.getMessage());
//        }
        
    }

    public static void writeString2FileConThrows() throws FileNotFoundException{
        PrintWriter out= new PrintWriter("ruta/fichero.txt");
        out.append("hola");
    }

    // ----------------------------------------------------------------------
    // ------------------- EXCEPCIONES PROPIAS ------------------------------
    // ----------------------------------------------------------------------
    public static void probarExcepcionesPropias(){
        //comprobarDiaMes(45);
            
        try{
            comprobarDiaMes(45);
//        }catch(Exception e){
//            System.err.println(e.getMessage());
//        }
//        }catch(MiExceptionChecked e){
//            System.err.println(e.getMessage());            
//            e.printStackTrace();
//        }
        }catch(MiExceptionChecked2 e){
            System.err.println(e.getMessage());
            e.printStackTrace();
        }
    }
    
    //public static void comprobarDiaMes (int dia) throws Exception{
    //public static void comprobarDiaMes (int dia) throws MiExceptionChecked{
    public static void comprobarDiaMes (int dia) throws MiExceptionChecked2{
    //public static void comprobarDiaMes (int dia) throws MiExceptionUnchecked{
        if (dia > 31 || dia < 1){
            
            //Exception diaFueraRango = new Exception("Número de día fuera de rango");
            
            //MiExceptionChecked diaFueraRango = new MiExceptionChecked(dia,"Número de día fuera de rango");
            MiExceptionChecked2 diaFueraRango = new MiExceptionChecked2(dia);
            //MiExceptionUnchecked  diaFueraRango = new MiExceptionUnchecked(dia,"Número de día fuera de rango");
            throw diaFueraRango;
        }
    }
}