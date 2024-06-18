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
public class Carrito {

    private Map<Productos, Integer> productosCarrito;
    private double totalIva;
    private static Carrito carrito;

    public Carrito() {
        productosCarrito = new HashMap<>();
        totalIva = 0;
    }

    public static Carrito getCarrito() {
        if (carrito == null) {
            carrito = new Carrito();
        }
        return carrito;
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
        sb.append("productos =").append(productosCarrito);
        sb.append(", total Iva=").append(totalIva);
        sb.append('}');
        return sb.toString();
    }

    
    public void agregarProducto(Productos producto, int cantidad) {
        if (productosCarrito.containsKey(producto)) {
            productosCarrito.put(producto, productosCarrito.get(producto) + cantidad);
        } else {
            productosCarrito.put(producto, cantidad);
        }
        //Contador para la suma del iva
        totalIva += calcularIvaProducto(producto, cantidad);
    }

    
    public void limpiarCarrito() {
        productosCarrito.clear();
        totalIva = 0;
    }

    public String imprimirCarrito() {
        StringBuilder sb = new StringBuilder();

        productosCarrito.forEach((producto, cantidad) -> {
            sb.append(producto.getNombreProducto()).append(", Cantidad: ").append(cantidad).append("\n");
        });

        return sb.toString();
    }

    public String calcularTotalCarrito() {
        double subtotal = 0;

        for (Map.Entry<Productos, Integer> entry : productosCarrito.entrySet()) {
            Productos producto = entry.getKey();
            int cantidad = entry.getValue();
            subtotal += calcularSubtotalProducto(producto, cantidad);
        }

        double totalConIva = subtotal + totalIva;

        return String.format("%.2f", totalConIva);
    }

    private double calcularSubtotalProducto(Productos producto, int cantidad) {
        return producto.getPrecioProducto() * cantidad;
    }

    private double calcularIvaProducto(Productos producto, int cantidad) {
        return calcularSubtotalProducto(producto, cantidad) * (producto.getIvaProducto() / 100.0);
    }

    public double getTotalIva() {
        return totalIva;
    }
}

////////////////