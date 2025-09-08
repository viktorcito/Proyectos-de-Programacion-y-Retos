package es.daw.web.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import es.daw.web.model.Oficina;

/**
 *
 * @author daw1a
 */
public class Utils {

    /**
     * Método que devuelve una cadena de texto con la fecha actual del sistema
     * en formato dd/MM/YYYY HH:mm:ss
     * @return 
     */
    public static String getDateTime(){
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/YYYY HH:mm:ss");
        String formatoFecha = sdf.format(new Date());
        return formatoFecha;
    }  
    
    public static Oficina getOficinaByCod(String cod_oficina, List<Oficina> oficinas) {
    	
    	// Forma imperativa
    	/*for(Oficina o: oficinas) {
    		if (o.getCodigo_oficina().equals(cod_oficina))
    			return o;
    	}
    	return new Oficina();*/
    	
    	// Con stream(). Programación funcional
    	return oficinas.stream()
    		.filter(o -> o.getCodigo_oficina().equals(cod_oficina))
    		.findFirst()
    		.orElse(new Oficina());
    	
    }
    
    public static Oficina getOficinaByCodRecursiva(String cod_oficina, int posicion, List<Oficina> oficinas) {
    	// condición de parada
    	if (posicion == oficinas.size())
    		return new Oficina();
    	else {
    		if (oficinas.get(posicion).getCodigo_oficina().equals(cod_oficina))
    			return oficinas.get(posicion);
    		else
    			return getOficinaByCodRecursiva(cod_oficina,posicion+1,oficinas);
    				
    	}
    	
    	
    }
    
}
