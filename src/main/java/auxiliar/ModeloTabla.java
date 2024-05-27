/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package auxiliar;

import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Victoria
 */
public class ModeloTabla extends DefaultTableModel {
   public ModeloTabla(){
        // Se asignan los nombres de las columnas de la tabla
        // en función de los atributos que tiene la persona
        String[] columnNames = {"id_producto", "nombre_producto", "precio_producto", "iva_producto", "stock_producto", "id_tipo", "descripcion_producto"}; 
        
        // Se le indica al modelo el nombre de las columnas y cantidad
        this.setColumnIdentifiers(columnNames); 
    }
    
    // Este método sobrescrito sirve para indicar qué celdas
    // del JTable son editables
   @Override
    public boolean isCellEditable (int row, int column)
    {
        // Aquí devolvemos true o false según queramos que una celda
        // identificada por fila,columna (row,column), sea o no editable
        // En nuestro caso ninguna celda se edita
        return false;
    }
}
