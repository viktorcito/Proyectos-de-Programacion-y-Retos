package es.daw.web.agendaWEB.util;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.Map.Entry;

import es.daw.web.agendaWEB.model.Persona;

public class UtilAgenda {

	/**
	 * 
	 * @param agenda
	 */
	public static void pintaAgenda(Map<String,Persona> agenda) {
	    //La forma más normal de recorrer un Map es tomar su conjunto de claves, iterar por ellas, y
	    //para cada una de ellas, obtener el valor.
	    for (String key : agenda.keySet()) {
	        //System.out.printf("%s %s %n", key, agenda.get(key));
	        System.out.println("* Clave:"+key);
	        System.out.println("* Valor:"+agenda.get(key));
	    }
	    
	    //También podemos iterar por sus Entry
	    /*for (Map.Entry<String, Persona> entry : agenda.entrySet()) {
	        String key = entry.getKey();
	        Persona value = entry.getValue();
	        System.out.println("clave: " + key + ", valor: " + value);
	    }*/
	    
	}
	
	/**
	 * 
	 * @param agenda
	 * @param telefono
	 * @return
	 * @throws Exception
	 */
    public static Persona buscaPersonaPorTelefono(Map<String,Persona> agenda,String telefono) throws Exception {
        if (agenda.containsKey(telefono)) 
        	return agenda.get(telefono);
        else {
            //return null; //si devuelvo nulo, desde donde llamo al método debe controlar if != null
            throw new Exception("No existe en la agenda una persona con el teléfono "+telefono); //propaga una excepción que debes chequear con try catch y volvera a propagar
            //throw new RuntimeException("No existe en la agenda una persona con el teléfono "+telefono);
        }
    }
    
    /**
     * 
     * @param agenda
     * @param persona
     * @return
     * @throws Exception
     */
    public static String buscaTelefonoPorPersona(Map<String,Persona> agenda,Persona persona) throws Exception {
        if (agenda.containsValue(persona)){
            for (String k: agenda.keySet()){
                if (agenda.get(k).equals(persona))
                    return k;
            }
        }
        //else throw new RuntimeException("No existe en la agenda de teléfonos la persona con DNI " + persona.getDni());
        else throw new Exception("No existe en la agenda de teléfonos la persona " + persona);
        
        return null;
    	
    }
    
    public static void actualizaTelefPorPersona(Map<String,Persona> agenda,Persona persona,String telefonoNuevo) throws Exception{
        String phone = buscaTelefonoPorPersona(agenda, persona);
        if (phone != null){
            //Ha encontrado el teléfono de la persona
            agenda.remove(phone);
            agenda.put(telefonoNuevo,persona);
        }
        
    }
    
    /*
    Puedes obtener un iterador (Iterator) para iterar sobre las claves, valores o pares clave-valor de un Map 
    utilizando los métodos keySet(), values() y entrySet() respectivamente:

    keySet(): devuelve un conjunto (Set) de todas las claves del Map.
    values(): devuelve una colección (Collection) de todos los valores del Map.
    entrySet(): devuelve un conjunto (Set) de pares clave-valor (Map.Entry) del Map.
    */
    public static Persona updatePhoneByIterator(Map<String,Persona> agenda,Persona persona,String telefonoNuevo){
        Iterator it = agenda.entrySet().iterator();
        while (it.hasNext()){
            //Nested classes (anidadas)
            Map.Entry<String,Persona> entry = (Map.Entry)it.next();
            if (entry.getValue().equals(persona)) it.remove();
        }
        agenda.put(telefonoNuevo,persona);

        return persona;        
    }
    
    /**
     * 
     * @param agenda
     * @param persona
     * @param telefono
     * @return
     */
    public static Persona darAltaPersona(Map<String,Persona> agenda,Persona persona, String telefono) {
        //Se puede insertar un valor sí o solo sí la clave no está insertada,
        //y si lo está, nos devuelve el valor antiguo. En otro caso devuelve nulo
        return agenda.putIfAbsent(telefono, persona);
    }    
    
    /**
     * 
     * @param agenda
     * @param persona
     * @throws Exception
     */
    public static void borrarPersona(Map<String,Persona> agenda,Persona persona) throws Exception{
        if (agenda.containsValue(persona)) 
            agenda.remove(buscaTelefonoPorPersona(agenda,persona));
        
    }
    

    /**
     * 
     * @param agenda
     * @return
     */
    /*public static List<Entry<String,Persona>> getListOfPersonsOrderByDNI(Map<String,Persona> agenda){
        
        //TreeMap<String, Persona> agendaOrdenada = new TreeMap<>(agenda);
        
        TreeMap<String, Persona> agendaOrdenada = new TreeMap<>();
        agendaOrdenada.putAll(agenda);
        
        List<Entry<String,Persona>> list = new ArrayList<>(agenda.entrySet());
        list.sort(Entry.comparingByValue());
        
        return list;
        
    } */
    
    public static TreeMap<String,Persona> obtenerAgendaOrdenadaNatural(Map<String,Persona> agenda){
    	return new TreeMap<String,Persona>(agenda);
    	
    }
    
	
	
	
}
