/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dawfood;

import entidades.Productos;
import entidades.Tickets;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.stream.Collectors;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import static views.MostrarProducto.crearListas;

/**
 *
 * @author vickyfg
 */
public class ModeloTabla extends DefaultTableModel {

    public ModeloTabla() {
        // Se asignan los nombres de las columnas de la tabla
        // en función de los atributos que tiene la persona
        String[] columnNames = {"id_producto", "nombre_producto", "precio_producto", "iva_producto", "stock_producto", "id_tipo", "descripcion_producto"};

        // Se le indica al modelo el nombre de las columnas y cantidad
        this.setColumnIdentifiers(columnNames);
    }

    //Constructor para la tabla comida
    public ModeloTabla(boolean porProductos) {
        if (porProductos) {
            String[] columnNames = {"id_ticket", "Fecha", "Hora", "Subtotal", "Total", "cod_Transaccion", "TPV"};
            this.setColumnIdentifiers(columnNames);
        } else {
            // En caso de no ser específico de comida, usar el constructor general
            String[] columnNames = {"id_producto", "nombre_producto", "precio_producto", "iva_producto", "stock_producto", "id_tipo", "descripcion_producto"};
            this.setColumnIdentifiers(columnNames);
        }
    }

    // Este método sobrescrito sirve para indicar qué celdas
    // del JTable son editables
    @Override
    public boolean isCellEditable(int row, int column) {
        // Aquí devolvemos true o false según queramos que una celda
        // identificada por fila,columna (row,column), sea o no editable
        // En nuestro caso ninguna celda se edita
        return false;
    }

// Método para cargar datos en un JTable
    public void cargarDatosJTable(JTable tabla, String tipoProducto, List<Productos> listaComida) {
        // Filtrar la lista de productos por tipo
        listaComida = crearListas().stream()
                .filter(p -> p.getIdTipo().getCategoria().equalsIgnoreCase(tipoProducto))
                .collect(Collectors.toList());

        // Crear el modelo de datos
        ModeloTabla modelo = new ModeloTabla(false);

        // Rellenar el modelo con datos
        for (Productos producto : listaComida) {
            Object[] fila = new Object[7];
            fila[0] = producto.getIdProducto();
            fila[1] = producto.getNombreProducto();
            fila[2] = producto.getPrecioProducto();
            fila[3] = producto.getIvaProducto();
            fila[4] = producto.getStockProducto();
            fila[5] = producto.getIdTipo().getCategoria();
            fila[6] = producto.getDescripcionProducto();
            modelo.addRow(fila);
        }

        // Asignar el modelo al JTable
        tabla.setModel(modelo);
    }

    public void cargarDatosJTicket(JTable tabla, List<Tickets> listaTickets) {

        // Filtrar la lista de productos por tipo
        listaTickets = listaTickets.stream()
                .sorted((t1, t2) -> t2.getFechaTicket().compareTo(t1.getFechaTicket()))
                .collect(Collectors.toList());

        // Crear el modelo de datos
        ModeloTabla modelo = new ModeloTabla(true);

        // Formateadores para fecha y hora
        SimpleDateFormat formatoFecha = new SimpleDateFormat("dd-MM-yyyy");
        SimpleDateFormat formatoHora = new SimpleDateFormat("HH:mm:ss");

        // Rellenar el modelo con datos
        for (Tickets tickes : listaTickets) {
            Object[] fila = new Object[7];
            fila[0] = tickes.getIdTicket();
            fila[1] = formatoFecha.format(tickes.getFechaTicket());
            fila[2] = formatoHora.format(tickes.getHoraTicket());
            fila[3] = tickes.getSubtotalProducto();
            fila[4] = tickes.getTotalTicket();
            fila[5] = tickes.getCodTransaccion();
            fila[6] = tickes.getIdTpv().getCiudad();
            modelo.addRow(fila);
        }

        // Asignar el modelo al JTable
        tabla.setModel(modelo);
    }
}
