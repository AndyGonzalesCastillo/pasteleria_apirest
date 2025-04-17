-- Eliminamos la base de datos si existe
DROP DATABASE IF EXISTS bdpasteleria_valery;

-- Creamos la base de datos
CREATE DATABASE bdpasteleria_valery;

-- Seleccionamos la base de datos
USE bdpasteleria_valery;

-- Tabla categorias
CREATE TABLE categoria (
    codCategoria INT PRIMARY KEY AUTO_INCREMENT,
    nomCategoria VARCHAR(50) BINARY CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
    descripcionCategoria TEXT CHARACTER SET utf8 COLLATE utf8_bin NULL,
    estado BIT NOT NULL
) ENGINE=InnoDB CHARACTER SET=utf8;

-- Tabla empleados
CREATE TABLE empleado (
    codEmpleado INT PRIMARY KEY AUTO_INCREMENT,
    nomEmpleado VARCHAR(50) BINARY CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
    apeEmpleado VARCHAR(50) BINARY CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
    dirEmpleado VARCHAR(100) BINARY CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
    correoEmpleado VARCHAR(100) BINARY CHARACTER SET utf8 COLLATE utf8_bin NULL,
    telefonoEmpleado VARCHAR(15) BINARY CHARACTER SET utf8 COLLATE utf8_bin NULL,
    puesto VARCHAR(50) BINARY CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
    fecha_contratacion DATE NOT NULL,
    estado BIT NOT NULL
) ENGINE=InnoDB CHARACTER SET=utf8;

-- Tabla productos
CREATE TABLE producto (
    codProducto INT PRIMARY KEY AUTO_INCREMENT,
    codCategoria INT NOT NULL,
    nomProducto VARCHAR(100) BINARY CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
    descripcionProducto TEXT CHARACTER SET utf8 COLLATE utf8_bin NULL,
    precio DECIMAL(10, 2) NOT NULL,
    tiempo_preparacion INT NOT NULL, -- en minutos
    stock INT NOT NULL,
    estado BIT NOT NULL,
    FOREIGN KEY (codCategoria) REFERENCES categoria(codCategoria)
) ENGINE=InnoDB CHARACTER SET=utf8;

-- Tabla insumos
CREATE TABLE insumo (
    codInsumo INT PRIMARY KEY AUTO_INCREMENT,
    nomInsumo VARCHAR(100) BINARY CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
    descripcionInsumo TEXT CHARACTER SET utf8 COLLATE utf8_bin NULL,
    unidad_medida VARCHAR(20) BINARY CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
    stock_actual DECIMAL(10, 2) NOT NULL,
    stock_minimo DECIMAL(10, 2) NOT NULL,
    estado BIT NOT NULL
) ENGINE=InnoDB CHARACTER SET=utf8;


-- Tabla cliente
CREATE TABLE cliente (
    codCliente INT PRIMARY KEY AUTO_INCREMENT,
    nomCliente VARCHAR(50) BINARY CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
    apeCliente VARCHAR(50) BINARY CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
    dirCliente VARCHAR(100) BINARY CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
    correoCliente VARCHAR(100) BINARY CHARACTER SET utf8 COLLATE utf8_bin NULL,
    telefonoCliente VARCHAR(15) BINARY CHARACTER SET utf8 COLLATE utf8_bin NULL,
    estado BIT NOT NULL
) ENGINE=InnoDB CHARACTER SET=utf8;

-- Tabla pedidos
CREATE TABLE pedido (
    codPedido INT PRIMARY KEY AUTO_INCREMENT,
    codCliente INT NOT NULL,
    codEmpleado INT NOT NULL,
    fecha_pedido DATETIME NOT NULL,
    fecha_entrega DATETIME NOT NULL,
    tipo_entrega ENUM('Recojo en tienda', 'Delivery') NOT NULL,
    direccion_entrega VARCHAR(200) CHARACTER SET utf8 COLLATE utf8_bin NULL,
    estado_pedido ENUM('Pendiente', 'En preparación', 'Listo', 'Entregado', 'Cancelado') NOT NULL,
    total DECIMAL(10, 2) NOT NULL,
    observaciones TEXT CHARACTER SET utf8 COLLATE utf8_bin NULL,
    estado BIT NOT NULL,
    FOREIGN KEY (codCliente) REFERENCES cliente(codCliente),
    FOREIGN KEY (codEmpleado) REFERENCES empleado(codEmpleado)
) ENGINE=InnoDB CHARACTER SET=utf8;

-- Tabla detalle_pedido
CREATE TABLE detalle_pedido (
    codDetallePedido INT PRIMARY KEY AUTO_INCREMENT,
    codPedido INT NOT NULL,
    codProducto INT NOT NULL,
    cantidad INT NOT NULL,
    precio_unitario DECIMAL(10, 2) NOT NULL,
    subtotal DECIMAL(10, 2) NOT NULL,
    especificaciones TEXT CHARACTER SET utf8 COLLATE utf8_bin NULL,
    FOREIGN KEY (codPedido) REFERENCES pedido(codPedido),
    FOREIGN KEY (codProducto) REFERENCES producto(codProducto)
) ENGINE=InnoDB CHARACTER SET=utf8;

-- Tabla proveedores
CREATE TABLE proveedor (
    codProveedor INT PRIMARY KEY AUTO_INCREMENT,
    nomProveedor VARCHAR(100) BINARY CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
    dirProveedor VARCHAR(100) BINARY CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
    correoProveedor VARCHAR(100) BINARY CHARACTER SET utf8 COLLATE utf8_bin NULL,
    telefonoProveedor VARCHAR(15) BINARY CHARACTER SET utf8 COLLATE utf8_bin NULL,
    estado BIT NOT NULL
) ENGINE=InnoDB CHARACTER SET=utf8;

-- Tabla compras
CREATE TABLE compra (
    codCompra INT PRIMARY KEY AUTO_INCREMENT,
    codProveedor INT NOT NULL,
    codEmpleado INT NOT NULL,
    fechaCompra DATE NOT NULL,
    totalCompra DECIMAL(10, 2) NOT NULL,
    estado BIT NOT NULL,
    FOREIGN KEY (codProveedor) REFERENCES proveedor(codProveedor),
    FOREIGN KEY (codEmpleado) REFERENCES empleado(codEmpleado)
) ENGINE=InnoDB CHARACTER SET=utf8;


-- Tabla detalle_compra
CREATE TABLE detalle_compra (
    codDetalleCompra INT PRIMARY KEY AUTO_INCREMENT,
    codCompra INT NOT NULL,
    codInsumo INT NOT NULL,
    cantidad INT NOT NULL,
    precio_unitario DECIMAL(10, 2) NOT NULL,
    subtotal DECIMAL(10, 2) NOT NULL,
    FOREIGN KEY (codCompra) REFERENCES compra(codCompra),
    FOREIGN KEY (codInsumo) REFERENCES insumo(codInsumo)
) ENGINE=InnoDB CHARACTER SET=utf8;


-- Insertar categorías
INSERT INTO categoria (nomCategoria, descripcionCategoria, estado) VALUES
('Tortas Clásicas', 'Tortas tradicionales para toda ocasión', 1),
('Tortas Temáticas', 'Tortas personalizadas con diseños especiales', 1),
('Cupcakes', 'Pequeños pasteles individuales decorados', 1),
('Postres Fríos', 'Variedad de mousses, cheesecakes y helados', 1),
('Bocaditos', 'Pequeños dulces y salados para eventos', 1);

-- Insertar empleados
INSERT INTO empleado (nomEmpleado, apeEmpleado, dirEmpleado, correoEmpleado, telefonoEmpleado, puesto, fecha_contratacion, estado) VALUES
('María', 'González', 'Av. Los Jazmines 123, Surquillo', 'maria.gonzalez@tortasvalery.com', '987654321', 'Maestro Pastelero', '2020-01-15', 1),
('Juan', 'Pérez', 'Jr. Las Rosas 456, Surquillo', 'juan.perez@tortasvalery.com', '987654322', 'Ayudante de Pastelería', '2021-03-20', 1),
('Ana', 'López', 'Calle Los Girasoles 789, Miraflores', 'ana.lopez@tortasvalery.com', '987654323', 'Vendedor', '2021-06-10', 1),
('Carlos', 'Ramírez', 'Av. Benavides 234, Surquillo', 'carlos.ramirez@tortasvalery.com', '987654324', 'Repartidor', '2022-01-05', 1),
('Laura', 'Torres', 'Jr. Las Dalias 567, San Borja', 'laura.torres@tortasvalery.com', '987654325', 'Cajero', '2022-04-15', 1);

-- Insertar productos
INSERT INTO producto (codCategoria, nomProducto, descripcionProducto, precio, tiempo_preparacion, stock, estado) VALUES
(1, 'Torta Tres Leches', 'Bizcocho bañado en tres tipos de leche', 85.00, 120, 5, 1),
(1, 'Torta Selva Negra', 'Torta de chocolate con cerezas', 90.00, 150, 3, 1),
(2, 'Torta Unicornio', 'Torta decorada con motivos de unicornio', 120.00, 180, 2, 1),
(3, 'Cupcake Vainilla', 'Cupcake clásico de vainilla con frosting', 8.50, 60, 20, 1),
(4, 'Cheesecake Fresa', 'Cheesecake con cobertura de fresa', 95.00, 240, 4, 1);

-- Insertar insumos
INSERT INTO insumo (nomInsumo, descripcionInsumo, unidad_medida, stock_actual, stock_minimo, estado) VALUES
('Harina', 'Harina de trigo para pastelería', 'KG', 50.00, 10.00, 1),
('Azúcar', 'Azúcar blanca refinada', 'KG', 40.00, 8.00, 1),
('Huevos', 'Huevos frescos', 'UNIDAD', 100.00, 24.00, 1),
('Leche', 'Leche fresca entera', 'LITRO', 30.00, 5.00, 1),
('Chocolate', 'Chocolate semi amargo', 'KG', 15.00, 3.00, 1);



-- Insertar clientes
INSERT INTO cliente (nomCliente, apeCliente, dirCliente, correoCliente, telefonoCliente, estado) VALUES
('Pedro', 'García', 'Av. Angamos 789, Surquillo', 'pedro.garcia@gmail.com', '999888777', 1),
('Carmen', 'Silva', 'Jr. Mercaderes 456, Miraflores', 'carmen.silva@gmail.com', '999888778', 1),
('José', 'Martínez', 'Calle Las Begonias 123, San Isidro', 'jose.martinez@gmail.com', '999888779', 1),
('Rosa', 'Flores', 'Av. La Marina 567, San Miguel', 'rosa.flores@gmail.com', '999888780', 1),
('Miguel', 'Castro', 'Jr. Libertad 890, Magdalena', 'miguel.castro@gmail.com', '999888781', 1);

-- Insertar pedidos
INSERT INTO pedido (codCliente, codEmpleado, fecha_pedido, fecha_entrega, tipo_entrega, direccion_entrega, estado_pedido, total, observaciones, estado) VALUES
(1, 3, '2024-03-15 10:00:00', '2024-03-15 15:00:00', 'Recojo en tienda', NULL, 'Entregado', 85.00, 'Cliente satisfecho', 1),
(2, 3, '2024-03-16 11:00:00', '2024-03-16 14:00:00', 'Delivery', 'Jr. Mercaderes 456, Miraflores', 'Entregado', 120.00, 'Entregar con cuidado', 1),
(3, 3, '2024-03-17 09:00:00', '2024-03-17 13:00:00', 'Recojo en tienda', NULL, 'En preparación', 95.00, NULL, 1),
(4, 3, '2024-03-17 14:00:00', '2024-03-17 17:00:00', 'Delivery', 'Av. La Marina 567, San Miguel', 'Pendiente', 90.00, 'Cliente frecuente', 1),
(5, 3, '2024-03-18 10:00:00', '2024-03-18 15:00:00', 'Recojo en tienda', NULL, 'Pendiente', 85.00, NULL, 1);

-- Insertar detalle_pedido
INSERT INTO detalle_pedido (codPedido, codProducto, cantidad, precio_unitario, subtotal, especificaciones) VALUES
(1, 1, 1, 85.00, 85.00, 'Decoración clásica'),
(2, 3, 1, 120.00, 120.00, 'Colores pasteles'),
(3, 5, 1, 95.00, 95.00, NULL),
(4, 2, 1, 90.00, 90.00, 'Extra chocolate'),
(5, 1, 1, 85.00, 85.00, NULL);

-- Insertar proveedores
INSERT INTO proveedor (nomProveedor, dirProveedor, correoProveedor, telefonoProveedor, estado) VALUES
('Alicorp SAA', 'Av. Argentina 4793, Callao', 'ventas@alicorp.com.pe', '5114315400', 1),
('Gloria SA', 'Av. República de Panamá 2461, La Victoria', 'ventas@gloria.com.pe', '5114707170', 1),
('Puratos Perú', 'Av. Los Castillos 340, Ate', 'ventas@puratos.pe', '5113260660', 1),
('Negociaciones Casino SAC', 'Jr. Amazonas 456, Centro de Lima', 'ventas@casino.com.pe', '5114524789', 1),
('Distribuidora Premium EIRL', 'Av. Colonial 789, Lima', 'ventas@premium.com.pe', '5114789632', 1);

-- Insertar compras
INSERT INTO compra (codProveedor, codEmpleado, fechaCompra, totalCompra, estado) VALUES
(1, 2, '2024-03-01', 1500.00, 1),
(2, 3, '2024-03-05', 800.00, 1),
(3, 1, '2024-03-10', 2000.00, 1),
(4, 4, '2024-03-12', 1200.00, 1),
(5, 5, '2024-03-15', 950.00, 1);


-- Insertar detalle_compra
INSERT INTO detalle_compra (codCompra, codInsumo, cantidad, precio_unitario, subtotal) VALUES
(1, 1, 50, 15.00, 750.00),
(1, 2, 50, 15.00, 750.00),
(2, 4, 40, 20.00, 800.00),
(3, 5, 20, 100.00, 2000.00),
(4, 3, 300, 4.00, 1200.00);


select * from categoria;
select * from empleado;
select * from producto;
select * from insumo;
select * from cliente;
select * from pedido;
select * from detalle_pedido;
select * from proveedor;
select * from compra;
select * from detalle_compra;
