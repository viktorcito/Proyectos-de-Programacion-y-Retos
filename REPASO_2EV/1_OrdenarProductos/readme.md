# ORDENACIÓN DE PRODUCTOS

## Objetivos

- Uso de clases, uso método toString() para mostrar datos. 

- Uso de arrays (ArrayList)  de objetos. 

- Uso de interfaces para ordenación de datos. 

- Concepto de paso de argumentos por referencia.

- Uso de interfaces Comparable y Comparator. 

- Conocer el **patrón DAO** para abstraer y encapsular todos los accesos a la fuente de datos.

## Problema a resolver

Nos piden hacer la lógica que podrá ordenar(por distintos parámetros) una colección de Prodcutos. 

Para esto crearemos una clase **Ordenaciones** que deberá tener tres métodos con las siguientes firmas: 

```

public ArrayList<Producto> ordenarAltoProducto(  ArrayList<Producto>   coleccion);
  

public ArrayList<Producto> ordenarAnchoProducto(  ArrayList<Producto>   coleccion);
  

public ArrayList<Producto> ordenarLargoProducto(  ArrayList<Producto>   coleccion); 
  
```

### La clase Producto

- Se ordenará por **criterio natural** por el atributo de **nombre**. 
- Es posible crear un Producto con el nombre, de forma que las medidas por defecto son las mínimas expresadas a continuación.
- Los datos del paquete no podrán ser modificados una vez creado.
- Todos los productos están empaquetados en cajas con medidas que no superan los siguientes límites: 

```
(Si se pasan valores superiores o inferiores se  truncará al valor mínimo o máximo)

Alto: desde 2 cm hasta 30 cm 

Ancho: desde 2 cm hasta 10 cm 

Largo: desde 2 cm hasta 10 cm 
```

Podremos **ordenar los productos** por cualquiera de estas tres medidas, siempre de mayor a menor. 


### Pruebas

Para hacer la prueba de los algoritmos se debe hacer un conjunto de 10 objetos Producto, utilizando el DAO facilitado. Descarga el ZIP y monta el proyecto.


Antes de finalizar el programa, mostraremos los catálogos de la siguiente forma: 

catálogo de productos

catálogo de productos ordenados por nombre

catálogo de productos 

catálogo de productos ordenados por alto

catálogo de productos 

catálogo de productos ordenados por ancho

catálogo de productos 

catálogo de productos ordenados por largo
