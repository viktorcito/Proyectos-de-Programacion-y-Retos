/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package es.daw.json.demogson;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author melola
 */
public class DemoGSON {

    public static void main(String[] args) {
        
        // Crear objeto persona para escribi en JSON
        Persona persona = new Persona("Mari","Pérez",25,"juan@example.com");
        
        // Escribir el objeto en JSON
        
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        
        
        // TRY TRADICIONAL
        /*FileWriter writer = null;
        try {
            writer = new FileWriter("personaGSON.json");
            gson.toJson(persona, writer);
            
        } catch (IOException ex) {
            ex.printStackTrace();
        }finally{
            try {
                writer.close();
            } catch (IOException ex) {
                ex.getMessage();
            }
        }*/
        
        // TRY CON RECURSOS
        try(FileWriter writer = new FileWriter("personaGSON.json",StandardCharsets.UTF_8)){
            gson.toJson(persona, writer);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        
        System.out.println("****> Fichero json creado!!!!");
        
        try(FileReader reader = new FileReader("personaGSON_2.json")){
            Persona personFromJSON = gson.fromJson(reader, Persona.class);
            System.out.println("PERSONA FROM JSON: "+personFromJSON);
        } catch (FileNotFoundException ex ) {
            System.out.println(ex.getMessage());
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        
        
    }
}

// Inner class (clases internas).
// Existen las nested static classes (clases estáticas anidadas).... no lo vamos a ver...
class Persona {
    String nombre;
    String apellido;
    int edad;
    String email;

    public Persona(String nombre, String apellido, int edad, String email) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.email = email;
    }

    @Override
    public String toString() {
        return "Persona{" + "nombre=" + nombre + ", apellido=" + apellido + ", edad=" + edad + ", email=" + email + '}';
    }
    
    
    
}
