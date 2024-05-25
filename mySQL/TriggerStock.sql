-- Trigger
-- comprobar que hay producto suficiente para la venta
DROP TRIGGER IF EXISTS comprobarstock;
DELIMITER $$
CREATE TRIGGER comprobarstock BEFORE INSERT ON detalle_ticket
FOR EACH ROW
BEGIN
     DECLARE stock_disponible INT;

    SELECT stock_producto INTO stock_disponible
    FROM productos
    WHERE id_producto = NEW.id_producto;

	IF stock_disponible < NEW.cantidad_producto THEN
        SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'Error. No hay suficiente stock del producto';
    END IF;
END $$

DELIMITER ;


-- TRIGGER REDUCIR STOCK AL HACER UNA VENTA 

DROP TRIGGER IF EXISTS reducirStock;
DELIMITER $$

CREATE TRIGGER reducirStock 
AFTER INSERT ON detalle_ticket
FOR EACH ROW
BEGIN
    
    UPDATE productos
    SET stock_producto = stock_producto - NEW.cantidad_producto
    WHERE id_producto = NEW.id_producto;
    
END $$

DELIMITER ;

-- Aqui comprobamos que se pueden quitar 5 productos 
INSERT INTO detalle_ticket
values
(19,905,5);

-- Aqui comprobamos que no hay suficiente stock y que no se pueden quitar 55 productos 
INSERT INTO detalle_ticket
values
(19,905,55);

-- Aqui comprobamos el stock actual
select stock_producto from productos where id_producto=19;