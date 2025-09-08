package es.daw.web.pokedex.util;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import es.daw.web.pokedex.model.Pokemon;
import es.daw.web.pokedex.model.PokemonList;

public class UtilJSON {

	public static Pokemon leer(String pathJson) throws StreamReadException, DatabindException, IOException {
		
		Pokemon pokemon = null;
		
		ObjectMapper mapper = new ObjectMapper();
		
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,false);
		
		pokemon = mapper.readValue(new File(pathJson), Pokemon.class);
		
		System.out.println("[UtilJSON] pokemon:"+pokemon);
		
		return pokemon;
	}
	
	public static List<String> getNombres(int numPokemons) throws StreamReadException, DatabindException, MalformedURLException, IOException{
		
		String apiUrl = "https://pokeapi.co/api/v2/pokemon?limit="+numPokemons;
		
		ObjectMapper mapper = new ObjectMapper();
		
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,false);
		
        PokemonList pokemonList = mapper.readValue(new URL(apiUrl), PokemonList.class);	
        
        List<String> names = new ArrayList<>();
        
        for(Pokemon pokemon: pokemonList.getResults()){
        	names.add(pokemon.getName());
        }
		
		return names;
		
	}
}
