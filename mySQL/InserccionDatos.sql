USE dawfood;

INSERT INTO tpv (id_tpv, ciudad, tpv_fecha, tpv_hora) 
VALUES
	(111, 'Málaga', curdate(), current_time()),
    (154, 'Esteona',curdate(), current_time()),
    (187, 'Madrid', curdate(), current_time())
;

INSERT INTO tickets (id_ticket, fecha_ticket, subtotal_producto, total_ticket, cod_transaccion, id_tpv) 
VALUES
	(901, '2024-01-20', 8.45, 9.99, 123456, 154),
    (902, '2024-02-24', 17.45, 24.43, 4654654, 187),
    (903, '2024-02-25', 22.48, 24.43, 7589584, 187),
    (904, '2024-02-25', 74.55, 83.49, 9574812, 111 ),
    (905, '2024-02-26', 52.78, 60.16, 7845246, 154)
    
    
;
INSERT INTO tipos_productos (id_tipo, nombre_subcategoria, categoria) 
VALUES
	(600, 'Patatas fritas', 'comida'),
    (603, 'Ensaladas', 'comida'),
    (620, 'Complementos', 'comida'),
    (602, 'Hamburguesa', 'comida'),
    (612, 'Helados', 'postre'),
    (605, 'Postre Caseros', 'postre'),
    (607, 'Azucaradas', 'bebida'),
    (608, 'SinAzucar', 'bebida'),
    (609, 'Cervezas', 'bebida')
;
INSERT INTO tipos_productos (id_tipo, nombre_subcategoria, categoria) 
VALUES

    (610, 'Agua', 'bebida')
;
-- categoria ENUM('comida', 'bebida', 'postre') NOT NULL

INSERT INTO productos (id_producto, nombre_producto, precio_producto, 
iva_producto, stock_producto,id_tipo, descripcion_producto) 
VALUES
	(1, 'Hamburguesa simple', 9.99, 4, 120, 602, 'Hamburguesa de ternera con ketchup y mostaza'),
    (2, 'Hamburguesa con queso', 10.99, 4, 85, 602, 'Hamburguesa de ternera simple con queso ketchup y mostaza' ),
    (3, 'Hamburguesa dobleCheddar', 12.99, 4, 71, 602, 'Hamburguesa doble de ternera con doble queso cheddar ketchup y mostaza'),
    (4, 'Hamburguesa Halal', 8.99, 4, 21, 602, 'Hamburguesa de ternera Halal sin condimentos'),
    (5, 'Hamburguesa CrispyChicken', 11.99, 4, 87, 602, 'Hamburguesa de pollo rebozado en crujiente de cereal con lechuga tomate y mayonesa'),
	(6, 'Hamburguesa pollopollo', 15.99, 4, 142, 602, 'Hamburguesa de Pollo a la Plancha con lechuga tomate y mayonesa'),
    (7, 'Hamburguesa Completa', 12.99, 4, 165, 602, 'Hamburguesa de ternera simple con queso lechuga tomate keptuch y mostaza'),
    (8, 'Hamburguesa Vegetariana', 15.99, 4, 132, 602, 'Hamburguesa de toffu con keptuch y mostaza'),
    (9, 'Hamburguesa Egg', 16.99, 4, 97, 602, 'Hamburguesa de ternera doble con huevo queso lechuga tomate keptuch y mostaza'),
    (10, 'Hamburguesa Roll', 14.99, 4, 12, 602, 'Hamburguesa CrispyChicken cortada a la mitad y puesta en un torta de trigo con lechuga y mayonesa'),
	(11, 'Patatas Gajo', 2.99, 7, 130, 600, 'Patatas gajos sazonadas'),
    (12, 'Aros de Cebolla Crispy', 4.50, 7, 90, 620, 'Aros de cebolla crujientes con salsa especial'),
    (13, 'Ensalada César', 6.75, 7, 60, 603, 'Ensalada con pollo a la parrilla queso parmesano y aderezo César'),
    (14, 'Patatas Clásicas', 3.25, 7, 80, 600, 'Patatas fritas clásicas acompañadas de ketchup'),
    (15, 'Nachos Supreme', 7.99, 7, 50, 620, 'Nachos cubiertos de queso jalapeños carne de res guacamole y crema agria'),
    (16, 'Ensalada de Frutas Frescas', 5.50, 7, 70, 603, 'Selección de frutas frescas de temporada con aderezo de miel'),
    (17, 'Patatas Bravas', 3.99, 7, 100, 600, 'Patatas fritas acompañadas de salsa brava y alioli'),
    (18, 'Palitos de Mozzarella', 6.25, 7, 45, 620, 'Palitos de queso mozzarella empanado con salsa marinara'),
    (19, 'Ensalada Caprese', 8.25, 7, 55, 603, 'Ensalada de tomate mozzarella fresca albahaca y vinagreta balsámica'),
    (20, 'Papas Finas', 2.75, 7, 120, 600, 'Papas fritas muy finas y crujientes con sal'),
    (21, 'Pepsi', 1.99, 12, 100, 607, ''),
    (22, 'Cerveza sin', 1.99, 12, 100, 609, 'Cerveza sin alcohol 0,0%'),
    (23, 'Cerveza', 2.00, 12, 100, 609, 'Cerveza basica'),
    (24, 'Kas', 1.99, 12, 100, 610, 'Kas de Naranja'),
    (25, 'Pepsi Max', 1.99, 7, 100, 610, 'Pepsi zero zero'),
    (26, 'Nestea', 1.99, 12, 100, 610, 'Nestea Clásica'),
    (27, 'Kas Max', 2.35, 12, 100, 610, 'Kas de Naranja sin azúcar'),
    (28, 'Aquarade Max', 1.99, 7, 100, 610, 'Bebida isotónica zero'),
    (29, 'Cerveza DawFood', 1.99, 12, 100, 609, 'Cerveza original con doble lúpulo'),
    (30, 'Agua Mineral', 0.99, 7, 150, 610, 'Agua mineral natural'),
    (31, 'Mochi', 4.99, 7, 120, 605, 'Pastel Helado Japonés'),
    (32, 'CafeConHelado', 2.99, 7, 97, 612, 'Helado Americano'),
    (33, 'McDawFlurry', 3.99, 7, 78, 612, 'Helado con leche'),
    (34, 'ConoChocolateNata', 1.99, 7, 127, 612, 'Helado de cono con chocolate'),
    (35, 'Yogur con toppin', 2.99, 7, 57, 612, 'Yogur helado natural'),
    (36, 'Tarta de queso', 7.99, 7, 25, 605, 'Tarta de queso con mermelada de fresa'),
    (37, 'Brownie de Chocolate', 5.50, 7, 85, 605, 'Brownie de chocolate con nueces'),
    (38, 'Pastel de Zanahoria', 6.75, 7, 70, 605, 'Pastel de zanahoria con crema de queso'),
    (39, 'Gelatina de Frutas', 3.25, 7, 110, 605, 'Gelatina de frutas variadas'),
    (40, 'Helado de Vainilla', 2.25, 7, 150, 612, 'Helado clásico de vainilla')
    ;

INSERT INTO detalle_ticket (id_producto, id_ticket, cantidad_producto) 
VALUES
    (20, 901, 1),
    (12, 902, 2),
    (18, 903, 1),
    (5, 904, 3),
    (8, 905, 2)
;


