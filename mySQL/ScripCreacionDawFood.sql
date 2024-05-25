DROP DATABASE IF EXISTS dawfood;
CREATE DATABASE dawfood;
USE dawfood;

CREATE TABLE IF NOT EXISTS tpv(
  id_tpv INT AUTO_INCREMENT,
  ciudad VARCHAR(25) NOT NULL,
  tpv_fecha DATE NOT NULL,
  tpv_hora TIME NOT NULL,
  CONSTRAINT pk_tpv PRIMARY KEY (id_tpv)
);

CREATE TABLE IF NOT EXISTS tickets (
    id_ticket INT AUTO_INCREMENT,
    fecha_ticket DATE NOT NULL,
    subtotal_producto DECIMAL(5, 2) NOT NULL,
    total_ticket DECIMAL(5, 2) NOT NULL,
    cod_transaccion INT NOT NULL,
    id_tpv INT NOT NULL,
    CONSTRAINT pk_tickets PRIMARY KEY (id_ticket),
    CONSTRAINT fk_tpv_ticket FOREIGN KEY (id_tpv)
        REFERENCES tpv (id_tpv)
        ON DELETE NO ACTION ON UPDATE NO ACTION
);

CREATE TABLE IF NOT EXISTS tipos_productos(
	id_tipo INT,
	nombre_subcategoria VARCHAR(30),
	categoria ENUM('comida', 'bebida', 'postre') NOT NULL,
  CONSTRAINT pk_tipoprod PRIMARY KEY (id_tipo)
);
CREATE TABLE IF NOT EXISTS productos(
	id_producto INT AUTO_INCREMENT,
	nombre_producto VARCHAR(30) NOT NULL,
	precio_producto DECIMAL(5,2) NOT NULL,
	iva_producto DECIMAL(5,2) NOT NULL,
	stock_producto INT NOT NULL,
    id_tipo INT NOT NULL,
    descripcion_producto VARCHAR(200), 
	  CONSTRAINT pk_producto PRIMARY KEY (id_producto),
      CONSTRAINT fk_producto_tipo FOREIGN KEY (id_tipo) REFERENCES tipos_productos(id_tipo)
		ON DELETE NO ACTION ON UPDATE CASCADE 
);

CREATE TABLE IF NOT EXISTS detalle_ticket(
	id_producto INT NOT NULL,
	id_ticket INT NOT NULL,
	cantidad_producto INT NOT NULL,
	  CONSTRAINT pk_detalleventa_producto_ticket PRIMARY KEY (id_producto, id_ticket),
		  CONSTRAINT fk_detalle_producto FOREIGN KEY (id_producto) 
			REFERENCES productos(id_producto),
			  CONSTRAINT fk_detalle_ticket FOREIGN KEY (id_ticket) 
				REFERENCES tickets(id_ticket)
);