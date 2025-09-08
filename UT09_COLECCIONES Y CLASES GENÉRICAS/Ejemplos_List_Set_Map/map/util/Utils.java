package map.util;


import java.util.Iterator;
import java.util.Map;


/**
 *
 * @author melola
 */
public class Utils {
    
    /**
     * Método generico para recorrer un Map
     * @param <K> key
     * @param <V> value
     * @param map 
     */
    private static <K,V> void printHash(Map<K, V> map){
        System.out.println("\t-------------- "+map.size()+"---------------------");
        map.forEach((k, v) -> {
            System.out.println("\tkey: " + k);
            System.out.println("\tvalue: " + v);
            System.out.println("\t--------------------------------------------------");
        });
        
    }
    
    /**
     * Método genérico para buscar un valor a través de la clave
     * @param <K> 
     * @param <V> 
     * @param map 
     * @param key
     * @return
     * @throws RuntimeException 
     */
    public static <K, V> V searchValueByKey(Map<K, V> map, K key) throws RuntimeException {
        // Se puede comprobar si se contiene alguna clave, o algún valor.
        if (map.containsKey(key)) {
            return map.get(key);
        } else {
            throw new RuntimeException("No existe en la agenda de teléfono la persona con el teléfono " + key);
        }
    }    
    
    /**
     * Método genérico que cambia la clave de un map
     * @param <K>
     * @param <V>
     * @param map
     * @param value
     * @param key
     * @return 
     */
    public static <K, V> V setKeyByValue(Map<K, V> map, V value, K key) {
        
        /*
        //Esto falla....ConcurrentModificationException....
        map.forEach((k, v) -> {
            if (v.equals(value)) {
                map.remove(k);
                map.put(key, value);
            }
        });
        */
        
        
        Iterator it = map.entrySet().iterator();
        while (it.hasNext()){
            Map.Entry<K,V> entry = (Map.Entry)it.next();
            if (entry.getValue().equals(value))
                it.remove();
        }
        map.put(key,value);

        return value;
    }    
    
    
}
