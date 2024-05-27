/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package auxiliar;

import static auxiliar.TareasCrud.crearListaProducto;
import entidades.Productos;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Victoria
 */
public class ListaProductos {
    private List<Productos> lista;

    public ListaProductos(List<Productos> lista) {
        this.lista = lista;
    }

    public ListaProductos() {
        lista = new ArrayList<>();
        lista = crearListaProducto();
    }
    
    
    public List<Productos> getLista() {
        return lista;
    }
  
    
    
    
    
}
