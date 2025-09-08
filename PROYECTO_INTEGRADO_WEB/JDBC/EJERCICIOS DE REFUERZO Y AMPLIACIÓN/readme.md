# 1. Proyecto para trabajar con los parámetros del request

![image](https://github.com/profeMelola/Programacion_2022-23/assets/91023374/aba4bbae-f21d-49dd-8780-37d2c9f6eb33)

## Objetivos

- Cargar todos los datos del formulario en una colección tipo Map. **PISTA:** usa request.getParameterMap()

- Volcar esa información en un fichero de propiedades.

- Repasar los pasos para realizar una conexión contra una base de datos y ejecutar una query.

## Fase I : persistencia de datos en fichero de propiedades

Crea un proyecto Dynamic Web Project en Eclipse con un único Servlet. 

Este proyecto no necesita conexión a bases de datos.

El servlet debe leer todos los datos rellenos del formulario y volcar esa información de forma persistente en un fichero de propiedades.

Ese fichero properties se debe crear en el directorio home del usuario (o en cualquier subcarpeta dentro de ese directorio, tú decides).


### Parte cliente

Utiliza los ficheros html adjuntos a la tarea.

El proyecto web consiste en las siguientes páginas:

![image](https://user-images.githubusercontent.com/91023374/236190585-65606954-b06b-49d4-b82e-0c6fe1b7b419.png)

___

![image](https://user-images.githubusercontent.com/91023374/236190662-f842d54c-d950-4038-a830-22cd6192a0a3.png)

___

![image](https://user-images.githubusercontent.com/91023374/236190998-18313685-0c9d-4b78-a8fe-ae4228952d6b.png)


## Fase II : persistencia de datos en una tabla de MySQL

Crea una base de datos con una única tabla llamada PARAMETROS formada por tres campos:
- id: autonumérico y clave primaria.
- nombre: con el nombre del campo del formulario
- valor: con el valor del campo del formulario

Realiza la inserción de esos datos en dicha tabla. En el campo valor:

- en el caso de que haya un único valor que se inserte como un String simple (coge el primer elemento del array). 
- en el caso de que haya más de un valor, insertálos separados por comas.

Para este ejercicio no necesitas usar patrón DAO. Crea una clase de utilidades que se encargue de todo el proceso: crear conexión, inserción de datos en la base de datos, cerrar conexión...

Añade en el cliente la opción de poder visualizar dichos datos haciendo una consulta contra la tabla. Muéstralos como una tabla.

# 2. Sistema de Login + subir fichero binario

## 2.1 Sistema de login

Implementa el sistema de login de una aplicación teniendo en cuenta que la información de los usuarios será una tabla de la base de datos.

![image](https://user-images.githubusercontent.com/91023374/236248525-4fcb71e1-8c66-4b41-8c85-fb16ff14f8b7.png)

Se proporciona el script sql para crear la base de datos y la tabla correspondiente.

___

También se proporciona toda la parte cliente (index.html):

![image](https://user-images.githubusercontent.com/91023374/236246627-a066ab3a-5a35-49bd-9b3b-b81b44d023da.png)

Como puedes comprobar vas a trabajar con tipo BLOB y con tipo DATE.

### Tipos Fecha

Para leer del ResulSet:

```
            while (rs.next()) {
                Pedido p = new Pedido();
                p.setId(rs.getInt("id"));
                p.setFecha(rs.getDate("fecha").toLocalDate());
                p.setPrecio(rs.getDouble("total"));
                p.setIdCliente(rs.getInt("id_cliente"));
                pedidos.add(p);

            }
```

Para establecer en el PreparedStatement:

```
ps.setDate(2, java.sql.Date.valueOf(t.getFecha()));

```

### Tipos Blob

```
            Path foto_path = Paths.get(t.getPath_foto());
            InputStream fotoStream = null;
            try {
                fotoStream = Files.newInputStream(foto_path);
                ps.setBlob(4, fotoStream);
                ps.executeUpdate();
            }catch(IOException e){
                System.err.println("[INSERT] error al crear el usuario");
                e.printStackTrace();
            }finally{
                if (fotoStream != null){
                    try{
                        fotoStream.close();
                    }catch(IOException e){
                        e.printStackTrace();
                    }
                }
            }

```

## 2.2 Subir fichero binario

Próximamente....

