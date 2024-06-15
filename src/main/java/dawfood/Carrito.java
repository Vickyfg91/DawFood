/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dawfood;

import entidades.Productos;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Victoria
 */
public class Carrito  {
    
    private Map<Productos, Integer> productosCarrito;

    public Carrito() {
        productosCarrito = new HashMap<>();
    }

    public void setProductosCarrito(Map<Productos, Integer> productosCarrito) {
        this.productosCarrito = productosCarrito;
    }

    public Map<Productos, Integer> getProductosCarrito() {
        return productosCarrito;
    }
    
    

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Carrito{");
        sb.append("productosCarrito=").append(productosCarrito);
        sb.append("\n");
        sb.append('}');
        return sb.toString();
    }
    
    
    public void agregarProducto(Productos producto, int cantidad) {
        if (productosCarrito.containsKey(producto)) {
            productosCarrito.put(producto, productosCarrito.get(producto) + cantidad);
        } else {
            productosCarrito.put(producto, cantidad);
        }
    }

    public void eliminarProducto(Productos producto) {
        productosCarrito.remove(producto);
    }

    

}
