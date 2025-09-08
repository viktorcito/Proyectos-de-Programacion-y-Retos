
package es.daw.poo2.login;

import es.daw.poo2.login.model.Password;
import es.daw.poo2.login.model.User;
import java.util.Scanner;

/**
 *
 * @author melola
 */
public class UserApp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        /*
         * MOCK OBJECTS
         * objetos que simulan parte del comportamiento de una clase
         * Mockito es un framework de pruebas unitarias que te permite crear 
         * objectos simulados (mocks) con una API limpia y simple haciendo 
         * que las pruebas sean legibles.
         * Los objetos Mock nos permiten simular ser un objeto real y eliminan dependencias, 
         * permitiendo que los test se ejecuten de forma aislada
         * ENTORNO: JUnit y Mockito como dependencias de Maven
         */
        
        // ---------- FASE 1 DE PRUEBAS: VALIDAR EL COMPORTAMIENTO DE LA CLASE PASSWORD ---------
        /*Password p1 = new Password();
        Password p2 = new Password("kk"); //voy cambiando la pwd para ver mensajes de error
        Password p3 = new Password("A666DAW$");
        
        System.out.println("pwd 1: "+p1);
        System.out.println("pwd 2: "+p2);*/

        // -------------------------
        
        // -------------- FASE 2 DE PRUEBAS: VALIDAR EL COMPORTAMIENTO DE LA CLASE USER
        /*User user1 = new User("melola");
        User user2 = new User("melola",p3);
        
        System.out.println("user 1:"+user1);
        System.out.println("user 2:"+user2);*/
        // -------------------------
        
        // --------------- MENÚ ----------------
        System.out.println("*** CREACIÓN DE CUENTAS DE USUARIO *****");
        System.out.println("1. Introduce el login: ");
        Scanner sc = new Scanner(System.in);
        String login = sc.nextLine();
        
        System.out.println("2. Introduce la contraseña: ");
        System.out.println("En caso de querer que se genere una contraseña automática pulsa intro...");
        String pwd = sc.nextLine();
        
        User user;
        if (pwd.equals("")){
            user = new User(login);
        }else{
            Password p = new Password(pwd);
            
            user = new User(login,p);
        }
        
        System.out.println("INFO DE LA CUENTA DE USUARIO GENERADA EN EL SISTEMA: "+user);
        
    }
    
}
