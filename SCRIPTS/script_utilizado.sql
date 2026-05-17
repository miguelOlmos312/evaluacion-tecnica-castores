USE escenario_db_castores;

CREATE TABLE IF NOT EXISTS roles (
    id_rol INT(2) PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(30)
);

CREATE TABLE IF NOT EXISTS usuarios (
    id_usuario INT(6) PRIMARY KEY AUTO_INCREMENT,
    id_rol INT(2),
    nombre VARCHAR(100),
    correo VARCHAR(100),
    contrasena VARCHAR(25),
    estatus INT(1),
    
    FOREIGN KEY (id_rol) REFERENCES roles(id_rol)
);

CREATE TABLE IF NOT EXISTS permisos (
    id_permiso INT(2) PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(40)
);

CREATE TABLE IF NOT EXISTS roles_permisos (
    id_rol INT(2) ,
    id_permiso INT(2),
    
	FOREIGN KEY (id_rol) REFERENCES roles(id_rol),
    FOREIGN KEY (id_permiso) REFERENCES permisos(id_permiso)
);

CREATE TABLE IF NOT EXISTS productos (
    id_producto INT(6) PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(50),
    precio DECIMAL(16,2),
    estatus INT(1),
    stock INT(6)
);

CREATE TABLE IF NOT EXISTS tipos_movimientos (
    id_tipo_movimiento INT(6) PRIMARY KEY AUTO_INCREMENT,
    nombre  VARCHAR(40)
);

CREATE TABLE IF NOT EXISTS movimientos (
	id_movimiento INT(6) PRIMARY KEY AUTO_INCREMENT,
    id_tipo_movimiento INT(6),
    id_producto INT(6),
    Id_usuario INT(6),
    fecha  DATETIME,
    
	FOREIGN KEY (id_tipo_movimiento) REFERENCES tipos_movimientos(id_tipo_movimiento),
    FOREIGN KEY (id_producto) REFERENCES productos(id_producto),
	FOREIGN KEY (Id_usuario) REFERENCES usuarios(Id_usuario)
);

INSERT INTO roles(nombre) VALUES ("Administrador"),("Almacenista");
SELECT * FROM roles;
SELECT * FROM roles_permisos;
SELECT * FROM permisos;
INSERT INTO permisos (nombre)
VALUES 
("Ver módulo inventario"),
("Agregar nuevos productos"),
("Aumentar inventario"),
("Dar de baja/reactivar un producto"),
("Ver módulo para Salida de productos"),
("Sacar inventario del almacén"),
("Ver módulo del histórico");

INSERT INTO roles_permisos (id_rol,id_permiso)
VALUES 
	(1,1), -- Administrador x Ver módulo inventario
	(1,2), -- Adminstrador x Agregar nuevos productos
	(1,3), -- Adminstrador x Aumentar inventario 
	(1,4), -- Adminstrador x Dar de baja/reactivar un producto
	-- Adminstrador x Ver módulo para Salida de productos
	-- Adminstrador x Sacar inventario del almacén 
	(1,7), -- Adminstrador x Ver módulo del histórico
 
	(2,1), -- Administrador x Ver módulo inventario
	-- Adminstrador x Agregar nuevos productos
    -- Adminstrador x Aumentar inventario 
	-- Adminstrador x Dar de baja/reactivar un producto
	(2,5), -- Adminstrador x Ver módulo para Salida de productos
	(2,6); -- Adminstrador x Sacar inventario del almacén 
	-- Adminstrador x Ver módulo del histórico
    
    
INSERT INTO usuarios(id_rol, nombre, correo, contrasena, estatus) VALUES (1, 'Luis Moreno', 'luis570lp@gmail.com', '1234', 1);
INSERT INTO usuarios(id_rol, nombre, correo, contrasena, estatus) VALUES (2, 'Pedro Mendoza', 'pedro570lp@gmail.com', '1234', 1);

INSERT INTO tipos_movimientos(nombre) VALUES ('ENTRADA'), ('SALIDA');

INSERT INTO productos (nombre, precio, estatus, stock)
VALUES 
('LAPTOP', 3000.00, 1, 10),
('PC', 4000.00, 1, 10),
('MOUSE', 3000.00, 1, 17),
