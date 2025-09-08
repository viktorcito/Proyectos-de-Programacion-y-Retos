# Tienda JDBC DAO

Vamos a realizar las cuatro operaciones básicas contra una tabla usando la base de datos **tienda**.

**[ C ]** **Create:** daremos de alta un producto indicando todos los campos necesarios (nombre, precio, fabricante).

**[ R ]** **Read:** obtendremos el listado de todos los productos.

**[ U ]** **Update:** actualizaremos el nombre de un producto.

**[ D ]** **Delete:** borraremos un producto por id.

Monta el proyecto Web + Maven de Eclipse y carga:

- en **src/main/java** los fuentes java (paquete es.daw.web...)
- en  **src/main/webapp** la parte cliente (index.html y error.jsp)


Además, en el directorio home **/home/daw** copia el fichero properties de conexión a base de datos **JDBC.properties**

![image](https://user-images.githubusercontent.com/91023374/235313497-3dc482bc-cc62-4972-8ea4-a3d000da3825.png)


Vamos a actualizar la versión del driver mysql para que sea la misma que la versión instalada del servidor de B.D. Pasamos de la versión 29 a la 32:

```
	<dependencies>
		<!-- https://mvnrepository.com/artifact/mysql/mysql-connector-java -->
		<dependency>
			<groupId>mysql</groupId>
			<artifactId>mysql-connector-java</artifactId>
			<version>8.0.32</version>
		</dependency>
	</dependencies>
```

## Estructura del proyecto

![image](https://user-images.githubusercontent.com/91023374/235313807-3fd1c712-11bb-4c53-9dd0-b3bd4097ac1c.png)


## Parte cliente: HTML

![image](https://user-images.githubusercontent.com/91023374/236427112-80e2f6a3-db49-4542-b6ac-7b4405074943.png)

## Parte servidor: Java

### Servlets
Tendremos dos servlets:

#### SERVLET ENCARGADO DE LISTAR LOS PRODUCTOS

![image](https://user-images.githubusercontent.com/91023374/236147497-30b576a2-e261-449c-85be-8192095838fd.png)

#### SERVLET ENCARGADO DE OPERACIONES DE MODIFICACIÓN (INSERT, UPDATE, DELETE)

![image](https://user-images.githubusercontent.com/91023374/236151179-8c72e070-2cc8-4c71-ab50-bcb98103c185.png)

___

![image](https://user-images.githubusercontent.com/91023374/235313345-fdab822e-35a2-4cc0-88f9-508b0a36e25e.png)

___

![image](https://user-images.githubusercontent.com/91023374/236151374-86d5ee72-d8f7-42b5-aa65-bb6021baf569.png)


### 

# Mejoras

## En la consulta

- Mejorar el código para que se cierren todas las clases de JDBC involucradas.

- En la tabla resultado con todos los productos que se muestre el nombre del fabricante, no el código.

- Ordenaciones: devolver la lista de productos ordenados de forma descendente. Lo usaremos después de insertar.

## En operaciones de modificación de datos

___
### 1. Gestionar excepciones al insertar un nuevo producto

Si intento insertar un nuevo producto con todos los campos y no he rellenado los datos obtengo la siguiente excepción:

![image](https://user-images.githubusercontent.com/91023374/236151940-b4b27c12-c2ee-4063-8e79-646e1de996af.png)

**Existen varias alternativas que vamos a debatir juntos en clase.**


Lo mismo sucedería que introducimos un valor incorrecto en el campo precio:

![image](https://user-images.githubusercontent.com/91023374/236152564-51399576-5568-4c26-9b98-0767cf8b7f79.png)

**En este caso hay que capturar la excepción y redirigir la salida a una página jsp de error que os proporciono. Copiadla en el proyecto en la carpeta webapp**

Forma de redirigir desde el Servlet a una página JSP:

```
        	// Obtener un objeto RequestDispatcher
        	RequestDispatcher dispatcher = request.getRequestDispatcher("error.jsp");

        	// Establecer el atributo "message" en el objeto HttpServletRequest
        	request.setAttribute("message", "El precio debe ser un valor numérico que permite decimales. Ejemplo 125.99");

        	// Redirigir la salida a la página JSP y pasar los objetos HttpServletRequest y HttpServletResponse
        	dispatcher.forward(request, response);

```

También se podría hacer con:

```

getServletContext().getRequestDispatcher("/error.jsp").forward(request, response);

```

Observa que la ruta cambia y lleva la /

- quest.getRequestDispatcher() se utiliza para obtener un RequestDispatcher relacionado con la ruta de la solicitud actual.
- getServletContext().getRequestDispatcher() se utiliza para obtener un RequestDispatcher relacionado con el contexto de la aplicación web.
        	 
___

![image](https://user-images.githubusercontent.com/91023374/236155337-3848c6d1-cb3f-42a8-b210-bb6a5ccc3ffc.png)

___

### 2. Al insertar que devuelva la lista de productos ordenados de forma descendente

### 3. Falta implementar las opciones de borrar y modificar:

![image](https://user-images.githubusercontent.com/91023374/235883272-d23c6ec5-a170-4e32-aaa9-1d9745486463.png)



