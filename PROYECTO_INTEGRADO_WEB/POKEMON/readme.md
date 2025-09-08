# POKEDEX: proyecto por fases

![image](https://user-images.githubusercontent.com/91023374/231422148-c2699d1c-2aab-452c-915d-406c4fc85eb4.png)

## Con la realización de este proyecto vamos a aprender a:

- conectar a un API de Pokemon vía web **https://pokeapi.co/api/v2/pokemon/**
- guardar el JSON en el filesystem con la información pertinente
- usar la librería **jackson** para convertir el json a objetos Java, concretamente a objetos Pokemon
- mostrar la información del Pokemon en cuestión en una página HTML
- usar la librería **jackson** para leer el json devuelto por el API en memoria y obtener una lista (List) de objetos Pokemon.


___

## Fase I

Indicar en un formulario el nombre del Pokemon y mostrar la imagen frontal.

**index.html**

![image](https://user-images.githubusercontent.com/91023374/231422481-7491415d-b1f7-46f0-b8a5-6c092728f41c.png)

___

**Página HTML resultado**

![image](https://user-images.githubusercontent.com/91023374/231717132-f6bf5bdf-991d-4141-8ed1-177a780788e5.png)


___

## Fase II: imagen back o front

Añadir a la página HTML de inicio un radio button para seleccionar si se quiere mostrar la imagen FRONT o  BACK

![image](https://user-images.githubusercontent.com/91023374/231716826-47eb0cf9-edc9-4a92-855d-9f0f6a5582df.png)


___

## Fase III: mostrar una ficha completa del pokemon.

**index.html**

![image](https://user-images.githubusercontent.com/91023374/231729308-8aec30d0-d840-423d-a4ed-0a7f1c5ac6e8.png)

___

**Página HTML resultado**

![image](https://user-images.githubusercontent.com/91023374/231729364-0ae60908-bf0d-4b6d-bbf2-fc7eb4465ad2.png)

___
## Fase IV

URL para obtener los nombres de todos los Pokemon en el Pokédex es:

https://pokeapi.co/api/v2/pokemon?limit=1118

En esta URL, "limit" es un parámetro que indica cuántos Pokemon se deben incluir en la respuesta. Actualmente, hay 1118 Pokemon en el Pokédex de la octava generación, por lo que ese es el valor máximo que se puede usar para este parámetro.

La respuesta a esta solicitud será un objeto JSON que contiene una lista de los nombres de todos los Pokemon en el Pokédex. 

La estructura del objeto JSON se verá así:

![image](https://user-images.githubusercontent.com/91023374/232441506-3ee6f0ad-17a0-4bca-9d9b-3ef2e2009adc.png)


```json
{
  "count": 1118,
  "next": null,
  "previous": null,
  "results": [
    {"name": "bulbasaur", "url": "https://pokeapi.co/api/v2/pokemon/1/"},
    {"name": "ivysaur", "url": "https://pokeapi.co/api/v2/pokemon/2/"},
    {"name": "venusaur", "url": "https://pokeapi.co/api/v2/pokemon/3/"},
    ...
  ]
}
```

**Debemos crear una aplicación web con los siguientes requisitos:**

- Su página html principal tendrá un enlace para "cargar lista de pokemons". 

![image](https://user-images.githubusercontent.com/91023374/232776616-a110aac0-e6e5-4af7-9ed6-5c4f1a21757b.png)

- Ese enlace llamará a un **servlet** que se conectará al API de Pokemon para obtener el JSON con 10 pokemons. No es necesario guardar el json en el sistema de ficheros. Pista:
```java
        String apiUrl = "https://pokeapi.co/api/v2/pokemon?limit=10";
        ObjectMapper objectMapper = new ObjectMapper();
        PokemonList pokemonList = objectMapper.readValue(new URL(apiUrl), PokemonList.class);
```
- El servlet devolverá una página HTML que contendrá una lista con los nombres de los pokemon y las opciones de las fases anteriores

![image](https://user-images.githubusercontent.com/91023374/232777009-2726dc45-5abe-4675-baa4-a4804dbe86c1.png)

___

![image](https://user-images.githubusercontent.com/91023374/232777126-59457b0b-d430-4115-bdd4-780bd857c91d.png)


- En dicha página html cuando el usuario seleccione un pokemon de la lista se llamará al Servlet de las fases anteriores para mostrar la información seleccionada.

![image](https://user-images.githubusercontent.com/91023374/232777194-5ceb51a7-e61e-4745-a437-cc4d8649759b.png)


___

### WEB INTERESANTE: Generate Plain Old Java Objects from JSON or JSON-Schema

https://www.jsonschema2pojo.org/

![image](https://user-images.githubusercontent.com/91023374/232442531-d80411cd-9af9-490a-98fa-eea8959e85f9.png)

