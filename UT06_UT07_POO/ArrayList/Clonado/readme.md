# Ejercicio de clonado de ArrayList y clonado de los objetos del mismo

Con este ejercicio vemos la diferencia de hacer un clonado de ArrayList superficial a un clonado profundo clonando cada uno de los objetos que lo componen.

![image](https://user-images.githubusercontent.com/91023374/217520139-4fcccc2d-ebb6-45bd-9b02-3bac8c658209.png)


# TEORÍA: Aclaraciones sobre interface Clonable

**No es necesario implementar la interface Cloneable** para hacer que una clase se pueda clonar en Java (aunque sí recomendable),  ya que todas las clases en Java 

heredan de java.lang.Object, que tiene un método clone(). 

Sin embargo, implementar Cloneable indica explícitamente que una clase es clonable y que se espera que su método clone() sea invocado para crear una copia del objeto.


Además, si una clase no implementa Cloneable, y se llama al método clone() en un objeto de esa clase, se lanzará una excepción CloneNotSupportedException. 

Por lo tanto, implementar Cloneable permite que una clase controle y personalice su comportamiento de clonación.

En resumen, implementar Cloneable en Java es una buena práctica para indicar explícitamente que una clase es clonable y para controlar su comportamiento de clonación.

La clonación real se logra a través del método **clone() protegido de la clase Object**, que debe ser **redefinido en la clase a clonar y hacer que sea público.**

Ejemplo:

```

class ClonableExample implements Cloneable {
    private int value;

    public ClonableExample(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public ClonableExample clone() throws CloneNotSupportedException {
        return (ClonableExample) super.clone();
    }
}

```

También podríamos sobreescribir el método clone() de la siguiente forma:

```
    @Override
    public Object clone() throws CloneNotSupportedException {
        return  super.clone();
    }
```

Pero en este caso habría que hacer un cast al clonar el objeto, por ejemplo:

```
lista.add((ClonableExample)p.clone());

```

En algunos casos se opta por realizar la clonación profunda con el operador new.

No es necesario usar el operador new en el método clone(). De hecho, el método clone() proporcionado por la clase Object realiza una clonación superficial por defecto, por lo que en muchos casos es suficiente con llamar a super.clone() para obtener una clonación funcional.

Sin embargo, en algunos casos es posible que se quiera realizar una clonación profunda en lugar de una clonación superficial.

En ese caso, se puede optar por implementar una clonación manual en el método clone() en lugar de llamar a super.clone(). 

En ese caso, se crearía una nueva instancia usando el operador new y se asignarían manualmente los valores a los campos correspondientes.

En general, se recomienda usar super.clone() para realizar una clonación superficial y crear una clonación profunda manual si es necesario. 

Esto asegura que se cumpla con las buenas prácticas de programación y se eviten errores de implementación.

Ejemplos:

![image](https://user-images.githubusercontent.com/91023374/217517923-995b3794-a695-454a-a310-bad5ba36ad75.png)


![image](https://user-images.githubusercontent.com/91023374/217517996-1d82e9d8-664a-4a03-89dc-5910b8dc2cb6.png)



## En base a nuestro ejercicio quedaría finalmente así

**En la clase Persona**

![image](https://user-images.githubusercontent.com/91023374/217518781-c92d8b1b-688e-4ac9-8898-bd00c0f3e5b5.png)

**En la clase Principal**

![image](https://user-images.githubusercontent.com/91023374/217518938-7dbb2aed-6f8a-4158-868e-d30a67dadd7a.png)


La gestión de **Excepciones** la veremos próximamente....


# AVANZADO

## En Javascript

![image](https://user-images.githubusercontent.com/91023374/217523779-96d51f69-c238-4cd9-ad3c-1964b9198dd5.png)


## API Stream Java

Se crea un stream a partir de la lista original list, se ordena con el método sorted() y luego se convierte en una nueva lista clonedList usando el método collect(Collectors.toList()). La lista original list sigue siendo intacta y no se modifica.

```
List<Integer> clonedList = list.stream().sorted().collect(Collectors.toList());
```











