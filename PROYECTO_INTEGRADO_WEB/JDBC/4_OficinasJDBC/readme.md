# Oficina JDBC

![image](https://github.com/profeMelola/Programacion_2022-23/assets/91023374/5b7d18d2-89d6-4909-aec5-4e84085deb18)


## Crear y configurar la BD

- Crea la base de datos ejecutando en WorkBench MySQL el script oficinas.sql
- Copia el fichero JDBC.properties en tu directorio home y configura los parámetros de conexión si fuera necesario

## Montar entorno Java

Se proporciona la carpeta src. 

Crea un proyecto WEB JDBC (Maven).

Copia los fuentes java (parte servidor) y los fuentes clientes (html, jsp) en dicho proyecto.

## Especificaciones

### INFORME PERSONALIZADO DE OFICINA

Al hacer click en el botón de **Obtener Informe** se generará una página html con una tabla que contendrá información de la oficina cuyo código se haya seleccionado en la lista html.

La lista de códigos de oficina es monoselección, por tanto el informe resultado estará compuesto por una tabla con solo una fila con tantas columnas como campos checkbox se hayan seleccionado. A tener en cuenta:
- El campo dirección hace referencia a la dirección completa (campos de base de datos linea_direccion1 + linea_direccion2)
- No debes tocar nada de la página index.html.

En el caso de que no se haya seleccionado ningún campo, el **Servlet1** parará de procesar y redirigirá la salida a la página error.html (response.sendRedirect("error.html"))

![image](https://github.com/profeMelola/Programacion_2022-23/assets/91023374/1bdfdac7-4f4e-439b-9636-b978a8d011a9)

![image](https://github.com/profeMelola/Programacion_2022-23/assets/91023374/fc51e95c-4fd2-4427-b52a-a0ecbf6f5eba)

**A TENER EN CUENTA A LA HORA DE PROGRAMAR:**
- Toda la información del informe se obtiene de las colecciones que has cargado y tienes en memoria. 
- Debes trabajar con las colecciones de los pedidos y los clientes para obtener la información. No debes realizar querys complejas (joins) contra base de datos cruzando las dos tablas.
- Las ordenaciones también se realizan directamente sobre las colecciones Java. No debes hacer order by en la query contra la B.D

### DAR DE ALTA UN EMPLEADO A TRAVÉS DE DATOS EN FORMATO CSV

El **Servlet2** va a recibir una cadena de texto con toda la información necesaria para dar de alta un empleado en la base de datos.

Debes leer esa información y tratarla para poder hacer la inserción. Daremos por hecho que siempre va a llegar una cadena con el formato correcto.

Cuando se haya creado el empleado correctamente el Servlet2 el mensaje:

```
El empleado NOMBRE APELLIDO1 se ha dado de alta correctamente
```

Antes de dar de alta el empleado, hay que verificar que el código de oficina exista. En caso de que no sea así, el Servlet2 redirigirá la salida a la página error.jsp con el mensaje 
```
ERROR: El código de oficina ALCALA-ES no existe en la base de datos
```

Observa que en los datos de prueba aparece el código **ALCALA-ES en el textarea (código que no existe)**. Te servirá para tus pruebas. Debes insertar al menos dos empleados bien.

Por otro lado, si se produjera cualquier excepcion (SQLException, IOException ….), el Servlet2 también redirigirá el mensaje de error a error.jsp.

