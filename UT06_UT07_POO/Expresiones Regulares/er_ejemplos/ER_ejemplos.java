/*
 * EJEMPLO DE USO DE EXPRESIONES REGULARES CON JAVA
 * https://regexr.com/
 */
package er_ejemplos;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author melol
 */
public class ER_ejemplos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // ------------------------
        // Ejemplo 1
        // Comprobar que una cadena coinicide con la expresión regular
        //------------------------
        System.out.println("\n*********** EJEMPLO 1 **********");
        String regExp = "^[AEIOU].*DAW.*[$&*]{6,}";
        // ^[AEIOU].*DAW.*[$&*]{6,}

        String pwd = "AmelolaDAW2023$";
        //String pwd = "ADAW$";
        
        // usando el método matchRegExp (que usa Patter y Matcher)
        System.out.printf("¿Es la contraseña fuerte? %s\n",matchRegExp(pwd,regExp)?"si":"no");
        
        // usando el método matches de la clase String
        if (pwd.matches(regExp)) System.out.println("La contraseña es fuerte!!!!");
        else System.out.println("La contraseña no es fuerte!!! torpedo!!!");                                                                                
           
        // ------------------------
        // Ejemplo 2
        // Buscar en un texto la primera ocurrencia
        // ------------------------
        System.out.println("\n*********** EJEMPLO 2 **********");
        matcherExample();
        
        
        // ------------------------
        // Ejemplo 3
        // Buscar en un texto más de una ocurrencia
        // ------------------------
        System.out.println("\n*********** EJEMPLO 3 **********");
        String txt = "Hola mundo, esto es un ejemplo. El objetivo es buscar las palabras"
                + "que coincidan con la expresión regular.";
        findInText(txt,"([hH]ola|mundo)");
        
        
        // ------------------------
        // Ejemplo 4
        // reemplazar en un texto una palabra concreta por otra
        // ------------------------
        System.out.println("\n*********** EJEMPLO 4 **********");
        txt = "El perro corre por el parque. El perro es un mamífero.";
        String searchWord = "perro";
        String replaceWord = "gato";
        
        System.out.println("NUEVO TEXTO: "+txt.replaceAll(searchWord,replaceWord));
        
        txt = "El perro corre por el parque. El PERRO es un mamífero.";
        System.out.println("NUEVO TEXTO (no sensible a may y min): "+txt.replaceAll("(?i)"+searchWord,replaceWord));
        
        
    }
    
    /**
     * Para que contraseña sea fuerte debe:
        - empezar con una vocal en mayúsculas
        - acabar con uno de estos tres carácteres $ & *
        - contener exactamente el texto DAW en cualquier parte de la contraseña.
        - como mínimo una longitud de 6
     * 
     * @param string
     * @param regExp
     * @return 
     */
    public static boolean matchRegExp(String string,String regExp){
        Pattern pat = Pattern.compile(regExp);
        Matcher mat = pat.matcher(string); 
        return mat.matches();
        
    }
    
    /**
     * Este método es ejemplo del uso de diferentes métodos de la clase Matcher
     * Muestra solo la primera coincidencia encontrada en el texto.
     */
    public static void matcherExample(){
        String string = "Some random string 1aaa5 some random string";

        Pattern pattern = Pattern.compile("\\d\\w+\\d");

        Matcher matcher = pattern.matcher(string);
        
        int start = 0;
        int end = 0;
        String text ="";
        
        if (matcher.find()) {
            start = matcher.start();
            end = matcher.end();
            text = matcher.group();
        }
        
        System.out.println("start position: "+start);
        System.out.println("end position: "+end);
        System.out.println("text founded: "+text);
    }
    
    /**
     * Método que muestra las palabras encontradas en un texto que coinciden
     * con la expresión regular
     * @param text
     * @param regExp 
     */
    public static void findInText(String text, String regExp){
        Pattern patron = Pattern.compile(regExp);
        Matcher matcher = patron.matcher(text);

        while (matcher.find()) {
          System.out.println("Palabra encontrada: " + matcher.group());
        }
        
    }
    
        
}
