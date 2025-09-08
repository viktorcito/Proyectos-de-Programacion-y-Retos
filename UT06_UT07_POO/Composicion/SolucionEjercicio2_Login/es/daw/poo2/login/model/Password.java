package es.daw.poo2.login.model;

import java.util.Random;

/**
 *
 * @author melola
 */
public class Password {
    
    // -------------------
    // Atributos
    // -------------------
    
    // constante pública que puede ser accesible desde cualquier punto
    public static final int LONGITUD = 6; 
    private String pwd;
    
    private static final char[] especiales = {'$','&','*'};
    private static final char[] vocalesUp = {'A','E','I','O','U'};    
    private static final String pattern = "DAW";
    
    // -------------------
    // Constructores
    // -------------------
    public Password(){
        // En este caso el programa generará automáticamente la contraseña
        this.pwd = generarPwd();
    }
    
    public Password(String pwd){
        // Habrá que validar que dicha contraseña es fuerte. 
        // Si no es fuerte el usuario recibirá un aviso y el programa terminará.
        
        if (esFuerte(pwd)){
            this.pwd = pwd;
        }
        else{
            System.out.println("Contraseña incorrecta!!!");
        }
    }
    
    // Getters & Setters

    public String getPwd() {
        return pwd;
    }

    // No podrá modificarse la pwd una vez creado el objeto
    /*public void setPwd(String pwd) {
        this.pwd = pwd;
    }*/
    
    // -------------------------------
    // MÉTODOS DE COMPORTAMIENTO
    // -------------------------------
    
    private boolean esFuerte(String pwd){
        /*
        empezar con una vocal en mayúsculas
        acabar con uno de estos tres carácteres $ & *
        contener exactamente el texto DAW en cualquier parte de la contraseña.
        como mínimo una longitud de 6
        */
        
        // Creo un boolean por cada restricción. En total son 4 restricciones
        boolean ok_longitud = false;
        boolean ok_Vocal = false;
        boolean ok_Especial = false;
        boolean ok_DAW = false;
        
        //Comprobamos una a una cada restricción
        // 1. Comprobar la longitud
        if (pwd.length() >= LONGITUD) ok_longitud = true;
        
        // 2. Comprobar que empieza por vocal en mayúsculas
        int i=0;
        char primer = pwd.charAt(0);
        while (!ok_Vocal && i < vocalesUp.length){
            
            /*
            //pruebas con starstWith y convirtiendo char a String
            if (pwd.startsWith(""+vocalesUp[i])){}
            if (pwd.startsWith(Character.toString(vocalesUp[i]))){}
            if (pwd.startsWith(String.valueOf(vocalesUp[i])))
            */
            if ( primer == vocalesUp[i]) ok_Vocal = true;
            i++;
        }
        
        //3. Comprobar que acaba en carácter especial
        i = 0;
        char ulti = pwd.charAt(pwd.length()-1);
        while (!ok_Especial && i < especiales.length){
            if ( ulti == especiales[i] )ok_Especial = true;
            i++;
        }
            
        //4. Commprobar que tiene el texto DAW
        int pos = pwd.indexOf("DAW");
        if (pos > 0) ok_DAW = true;

        System.out.println("AVISOS:");
        if (!ok_longitud) 
            System.out.println("La constraseña debe tener una longitud mínima de "+LONGITUD);
        if (!ok_Vocal) 
            System.out.println("La constraseña debe empezar por una vocal en mayúsculas.");
        if (!ok_Especial) 
            System.out.println("La constraseña debe acabar por uno de estos caracteres  $  &  * ");
        if (!ok_DAW) 
            System.out.println("La constraseña debe contener el texto DAW");
        
        //return ok_longitud && ok_Vocal && ok_Especial && ok_DAW;
        
        
        // Cuando no se cumpla alguna condición se mostrará un mensaje 
        // por consola indicando al usuario las condiciones que no se cumplen en su contraseña.
        
        return true;
    }
    
    //private void generarPwd(){
    private String generarPwd(){
        String defaultPwd ="ADAWcualquiercosa&";
        
        String pwd = "";
        
        Random r = new Random();
        // 1. empezar con una vocal en mayúsculas
        pwd += vocalesUp[r.nextInt(5)]; //empezar por vocal may
        // 2. Para rellenar meto 1 número aleatorio (más fácil que meter una letra aleatoria)
        pwd += r.nextInt(10);
        // 3. Meto el texto DAW
        pwd += "DAW";
        // 4. Acaba en un carácter especial
        pwd += especiales[r.nextInt(3)]; //acabar con carácter especial
        
        return pwd;
    }

    @Override
    public String toString() {
        return "Password{" + "pwd=" + pwd + '}';
    }
    
    
}
