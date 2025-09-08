/**
 *
 */
package map;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

import modelo.Persona;

public class EjemploMap {

    static Map<String, Persona> agenda = new HashMap<>();
    
    /**
     * @param args
     */
    public static void main(String[] args) {

        //Insertamos los pares clave, valor
        //Simulando una agenda de teléfono: clave el teléfono y el valor la persona con su datos
        agenda.put("954000001", new Persona("11111111A", "Pepe", "Perez", LocalDate.of(1990, 1, 2)));
        agenda.put("954000004", new Persona("44444444D", "María", "López", LocalDate.of(1993, 4, 5)));
        agenda.put("954000002", new Persona("22222222B", "Juan", "Martínez", LocalDate.of(1991, 2, 3)));
        agenda.put("954000003", new Persona("33333333C", "Ana", "Ramírez", LocalDate.of(1992, 3, 4)));
        
        //Si insertamos un elemento con la misma clave, lo sustituimos
        //No podemos tener dos claves que tenga valores diferentes
        agenda.put("954000004", new Persona("56789012E", "Martín", "García", LocalDate.of(1990, 12, 15)));

        //La forma más normal de recorrer un Map es tomar su conjunto de claves, iterar por ellas, y
        //para cada una de ellas, obtener el valor.
        for (String key : agenda.keySet()) {
            //System.out.printf("%s %s %n", key, agenda.get(key));
            System.out.println("* Clave:"+key);
            System.out.println("* Valor:"+agenda.get(key));
        }
        
        /*
        // Si falla el primero, el segundo no se busca
        try{
            System.out.println("Persona con teléfono 8888888: "+searchPersonByPhone("8888888"));
            System.out.println("Persona con teléfono 954000002: "+searchPersonByPhone("954000002"));
        }catch(Exception e){
            System.out.println(e.getMessage());
        }*/

        try{
            System.out.println("Persona con teléfono 8888888: "+searchPersonByPhone("8888888"));
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        
        try{
            System.out.println("Persona con teléfono 954000002: "+searchPersonByPhone("954000002"));
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        
        /*
        for (int i =0; i < ...; i++){
            try{
                String telef = arrayInventado[i];
                System.out.println("Persona con teléfono 954000002: "+searchPersonByPhone(telef));
            }catch(Exception e){
                System.out.println(e.getMessage());
            }
        
        }*/
        
        System.out.println("1. ");
        Persona martin = new Persona("56789012E", "Martín", "García", LocalDate.of(1990, 12, 15));
        System.out.println("Teléfono de Martín: "+searchPhoneByPerson(martin));
        
        System.out.println("2.1 ");
        updatePhone(martin,"1111101111");
        System.out.println("Agenda después de cambiar el teléfono de Martín por 11110111");
        printMap();
        
        System.out.println("2.2 ");
        updatePhoneByIterator(martin,"66666666");
        System.out.println("Agenda después de cambiar el teléfono de Martín por 11110111");
        printMap();
        
        // PENDIENTE LLAMAR AL RESTO DE MÉTODO Y HACER LAS PRUEBAS.......
        // ......
        
        //6. 
        System.out.println("6.");
        // TreeMap ordena las claves. Por ordenación natural del objeto
        // Podemos ordenar por otro criterio de clave a través de Comparator...
        // En el API - Constructor: TreeMap​(Comparator<? super K> comparator)
        // SortedMap es la interface de donde proviene TreeMap
        // Ordenaremos las claves por nombre cuando recojamos valores de un formulario (web)
        
        List list = getListOfPersonsOrderByDNI();
        System.out.println("\t* Lista (Map convertido) ordenada por DNI de la persona:");
        list.forEach(System.out::println);
        
        
        //BidiMap ????? Es de Apache Commons Collections (BidiMap, MultiMap, LazyMap)
        /*
         Para obtener la clave usando su valor. Asegura que no haya valores duplicados en el mapa y que el valor pueda ser usado para
         obtener la clase....
        */
            
        // Se utiliza para obtener el valor asignado con la clave especificada. 
        // Si no se asigna ningún valor con la clave proporcionada, se devuelve el valor predeterminado
        System.out.println("DEFAULT:"+agenda.getOrDefault("4545454545", new Persona("000000", "default", "default", LocalDate.of(1975, 05, 19))));        
        
        System.out.println("FINNNNNNNNNNNNNNNNNNNNNN");

    }
    
    /*
     AMPLICACIÓN DEL EJERCICIO
     - 1. Método para buscar los datos de una persona a través del teléfono.
     - 2. Método para buscar el teléfono de una persona.
     - 3. Método para modificar el teléfono de una pesona en concreto.
     - 4. Método para dar de alta una nueva Persona con su teléfono en la agenda
     - 5. Método para borrar una persona concreta de la agenda.
     - 6. Método para devolver la lista de personas con su teléfono ordenados por DNI
    */
    public static void printMap(){
    // También podemos recorrer el HashMap con un estilo "más lambda"
        agenda.forEach((k,v) -> {System.out.println("clave:"+k+"\n");
                            System.out.println("valor:"+v+"\n");
                             });
        
    }
    
    // 1. Método para buscar los datos de una persona a través del teléfono.
    public static Persona searchPersonByPhone(String telefono) throws Exception{
    //public static Persona searchPersonByPhone(String telefono) throws RuntimeException{
        
        if (agenda.containsKey(telefono)) return agenda.get(telefono);
        else {
            //return null; //si devuelvo nulo, desde donde llamo al método debe controlar if != null
            throw new Exception("No existe en la agenda una persona con el teléfono "+telefono); //propaga una excepción que debes chequear con try catch y volvera a propagar
            //throw new RuntimeException("No existe en la agenda una persona con el teléfono "+telefono);
        }
    }
    
    // 2. Método para buscar el teléfono de una persona.
    public static String searchPhoneByPerson(Persona persona){
        if (agenda.containsValue(persona)){
            for (String k: agenda.keySet()){
                if (agenda.get(k).equals(persona))
                    return k;
            }
        }
        //else return null;
        else throw new RuntimeException("No existe en la agenda de teléfonos la persona con DNI " + persona.getDni());
        
        return null;
    }
    
    //3.1 Método para modificar el teléfono de una pesona en concreto.
    public static void updatePhone(Persona persona,String telefonoNuevo){
        String phone = searchPhoneByPerson(persona);
        if (phone != null){
            //Ha encontrado el teléfono de la persona
            agenda.remove(phone);
            agenda.put(telefonoNuevo,persona);
        }
        
    }
    
    //3.2 Método para modificar el teléfono de una pesona en concreto.
    /*
    Puedes obtener un iterador (Iterator) para iterar sobre las claves, valores o pares clave-valor de un Map 
    utilizando los métodos keySet(), values() y entrySet() respectivamente:

    keySet(): devuelve un conjunto (Set) de todas las claves del Map.
    values(): devuelve una colección (Collection) de todos los valores del Map.
    entrySet(): devuelve un conjunto (Set) de pares clave-valor (Map.Entry) del Map.
    */
    public static Persona updatePhoneByIterator(Persona persona,String telefonoNuevo){
        Iterator it = agenda.entrySet().iterator();
        while (it.hasNext()){
            //Nested classes (anidadas)
            Map.Entry<String,Persona> entry = (Map.Entry)it.next();
            if (entry.getValue().equals(persona)) it.remove();
        }
        agenda.put(telefonoNuevo,persona);

        return persona;        
    }
    
    //4. Método para dar de alta una nueva Persona con su teléfono en la agenda
    public static Persona addPerson(Persona persona, String telefono) {
        //Se puede insertar un valor sí o solo sí la clave no está insertada,
        //y si lo está, nos devuelve el valor antiguo. En otro caso devuelve nulo
        return agenda.putIfAbsent(telefono, persona);
    }    
    
    //5. Método para borrar una persona concreta de la agenda.
    public static void deletePerson(Persona persona) throws RuntimeException {
        if (agenda.containsValue(persona)) {
            agenda.remove(searchPhoneByPerson(persona));
        } else {
            throw new RuntimeException("No existe en la agenda de teléfonos la persona " + persona);
        }
        
    }
    
    //6. Método para devolver la lista de personas con su teléfono ordenados por DNI    
    public static List getListOfPersonsOrderByDNI(){
        
        //TreeMap<String, Persona> agendaOrdenada = new TreeMap<>(agenda);
        
        TreeMap<String, Persona> agendaOrdenada = new TreeMap<>();
        agendaOrdenada.putAll(agenda);
        
        List<Entry<String,Persona>> list = new ArrayList<>(agenda.entrySet());
        list.sort(Entry.comparingByValue());
        
        return list;
        
    } 
    
}
