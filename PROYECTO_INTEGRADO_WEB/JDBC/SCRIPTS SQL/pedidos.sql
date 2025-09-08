DROP DATABASE IF EXISTS pedidos;
CREATE DATABASE pedidos CHARACTER SET utf8mb4;
USE pedidos;

CREATE TABLE cliente (
  id INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
  nombre VARCHAR(100) NOT NULL,
  apellido1 VARCHAR(100) NOT NULL,
  apellido2 VARCHAR(100),
  ciudad VARCHAR(100),
  categoría INT UNSIGNED
);


CREATE TABLE pedido (
  id INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
  total DOUBLE NOT NULL,
  fecha DATE,
  id_cliente INT UNSIGNED NOT NULL,
  FOREIGN KEY (id_cliente) REFERENCES cliente(id)
);

INSERT INTO cliente VALUES(1, 'Aarón', 'Rivero', 'Gómez', 'Almería', 100);
INSERT INTO cliente VALUES(2, 'Adela', 'Salas', 'Díaz', 'Granada', 200);
INSERT INTO cliente VALUES(3, 'Adolfo', 'Rubio', 'Flores', 'Sevilla', NULL);
INSERT INTO cliente VALUES(4, 'Adrián', 'Suárez', NULL, 'Jaén', 300);
INSERT INTO cliente VALUES(5, 'Marcos', 'Loyola', 'Méndez', 'Almería', 200);
INSERT INTO cliente VALUES(6, 'María', 'Santana', 'Moreno', 'Cádiz', 100);
INSERT INTO cliente VALUES(7, 'Pilar', 'Ruiz', NULL, 'Sevilla', 300);
INSERT INTO cliente VALUES(8, 'Pepe', 'Ruiz', 'Santana', 'Huelva', 200);
INSERT INTO cliente VALUES(9, 'Guillermo', 'López', 'Gómez', 'Granada', 225);
INSERT INTO cliente VALUES(10, 'Daniel', 'Santana', 'Loyola', 'Sevilla', 125);


INSERT INTO pedido VALUES(1, 150.5, '2017-10-05', 5);
INSERT INTO pedido VALUES(2, 270.65, '2016-09-10', 1);
INSERT INTO pedido VALUES(3, 65.26, '2017-10-05', 2);
INSERT INTO pedido VALUES(4, 110.5, '2016-08-17', 8);
INSERT INTO pedido VALUES(5, 948.5, '2017-09-10', 5);
INSERT INTO pedido VALUES(6, 2400.6, '2016-07-27', 7);
INSERT INTO pedido VALUES(7, 5760, '2015-09-10', 2);
INSERT INTO pedido VALUES(8, 1983.43, '2017-10-10', 4);
INSERT INTO pedido VALUES(9, 2480.4, '2016-10-10', 8);
INSERT INTO pedido VALUES(10, 250.45, '2015-06-27', 8);
INSERT INTO pedido VALUES(11, 75.29, '2016-08-17', 3);
INSERT INTO pedido VALUES(12, 3045.6, '2017-04-25', 2);
INSERT INTO pedido VALUES(13, 545.75, '2019-01-25', 6);
INSERT INTO pedido VALUES(14, 145.82, '2017-02-02', 6);
INSERT INTO pedido VALUES(15, 370.85, '2019-03-11', 1);
INSERT INTO pedido VALUES(16, 2389.23, '2019-03-11', 1);
