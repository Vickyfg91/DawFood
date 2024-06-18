/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dawfood;

import controladores.DetalleTicketJpaController;
import controladores.ProductosJpaController;
import controladores.TicketsJpaController;
import entidades.DetalleTicket;
import entidades.Productos;
import entidades.Tickets;
import entidades.Tpv;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.TimeZone;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Victoria
 */
public class GenerarTickets {

    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.mycompany_DawFoodVicky_jar_1.0-SNAPSHOTPU");
    private static final EntityManager em = emf.createEntityManager();
    private static final TicketsJpaController ticketContr = new TicketsJpaController(emf);
    private static final DetalleTicketJpaController detallContr = new DetalleTicketJpaController(emf);
    private static final ProductosJpaController prodContr = new ProductosJpaController(emf);
   // private double importeTotal;
   // private double importeSubTotal;
    

    //crear un nuevo ticket en la bbdd
    public static void GenerarTicket(Tickets ticket) {
        ticketContr.create(ticket);
    }

    public static void GenerarDetalle(DetalleTicket dt) throws Exception {
        detallContr.create(dt);
    }

    public static Tickets generarNuevoTicket(double importeTotal, double importeSubTotal, Tpv tpv, Carrito carrito) throws Exception {
        Random random = new Random();
        Tickets ticket = new Tickets();

        int cdtrans = random.nextInt(99999999);

        ticket.setCodTransaccion(cdtrans);
        ticket.setFechaTicket(Date.from(LocalDate.now().atStartOfDay(ZoneId.systemDefault()).toInstant()));
        ticket.setHoraTicket(Date.from(LocalTime.now().atDate(LocalDate.of(1970, 1, 1)).atZone(ZoneId.systemDefault()).toInstant()));
        ticket.setTotalTicket(BigDecimal.valueOf(importeTotal));
        System.out.println(importeTotal);
        ticket.setSubtotalProducto(BigDecimal.valueOf(importeSubTotal));
        ticket.setIdTpv(tpv);

        GenerarTickets.GenerarTicket(ticket);

        // Asignar los detalles del ticket al ticket principal
         List<DetalleTicket> detallesTicket = crearDetallesTicket(carrito, ticket);
        for (DetalleTicket detalle : detallesTicket) {
            GenerarDetalle(detalle);
        }
        return ticket;
       
    }

     private static List<DetalleTicket> crearDetallesTicket(Carrito carrito, Tickets ticket) throws Exception {
        List<DetalleTicket> detallesTicket = new ArrayList<>();
        for (Map.Entry<Productos, Integer> producto : carrito.getProductosCarrito().entrySet()) {
            DetalleTicket aux = new DetalleTicket();
            aux.setProductos(producto.getKey());
            aux.setTickets(ticket);
            aux.setCantidadProducto(producto.getValue());
            prodContr.restarInventario(producto.getKey(), producto.getValue());
            detallesTicket.add(aux);
        }
        return detallesTicket;
    }
    
    public static String generarTextoTicket(int idTicket, Date fechaTicket, Date horaTicket, double importeTotal, int codTransaccion, Carrito carrito) {
        StringBuilder sb = new StringBuilder();
        DecimalFormat df = new DecimalFormat("#.00");
        /*aqui hay que añadir las variables de precio total, iva total, fecha y hora actual formateada*/
        TimeZone.setDefault(TimeZone.getTimeZone("Europe/Madrid"));
        SimpleDateFormat formatoFecha = new SimpleDateFormat("dd-MM-yyyy");
        SimpleDateFormat formatoHora = new SimpleDateFormat("HH:mm:ss");
        sb.append("************************************************************\n");
        sb.append("*********************DawFood*********************\n");
        sb.append("************************************************************\n");
        sb.append("\n");
        sb.append("Ticket ID: ").append(idTicket).append("\n");
        sb.append("Código de Transacción: ").append(codTransaccion).append("\n");
        sb.append(formatoFecha.format(fechaTicket)).append("\t");
        sb.append(formatoHora.format(horaTicket)).append("\n");
        sb.append("-----------------------------------------------------\n");
        sb.append("\n");
        sb.append("\n");
        sb.append("Cantidad \t ").append(" Producto \t ").append("Precio \t ").append("Subtotal \n");
        for (Map.Entry<Productos, Integer> entry : carrito.getProductosCarrito().entrySet()) {
            Productos producto = entry.getKey();
            int cantidad = entry.getValue();
            sb.append(cantidad).append(" \t ")
                    .append(producto.getNombreProducto()).append(" \t ")
                    .append(producto.getPrecioProducto()).append(" \t ")
                    .append(producto.getPrecioProducto() * cantidad).append("\n");
        }
        sb.append("\n");
        sb.append("-----------------------------------------------------------\n");
        sb.append("Total a Pagar + IVA: ").append(df.format(importeTotal)).append("€\n");
        sb.append("************************************************************\n");
        sb.append("*********************Gracias por su compra*********************\n");
        sb.append("************************************************************\n");

        return sb.toString();
    }

    public static String consultaTicket(int idTic){
        Tickets ticket = ticketContr.findTickets(idTic);
        if (ticket == null) {
            return "Ticket no encontrado.";
        }
        
        List<DetalleTicket> detallesTicket = detallContr.findDetalleTicketEntities();
        StringBuilder sb = new StringBuilder();
        sb.append("Ticket ID: ").append(ticket.getIdTicket()).append("\n");
        sb.append("Fecha: ").append(ticket.getFechaTicket()).append("\n");
        sb.append("Hora: ").append(ticket.getHoraTicket()).append("\n");
        sb.append("Subtotal: ").append(ticket.getSubtotalProducto()).append("\n");
        sb.append("Total: ").append(ticket.getTotalTicket()).append("\n");
        sb.append("Código de Transacción: ").append(ticket.getCodTransaccion()).append("\n");
        sb.append("Detalles del Ticket:\n");
        sb.append("-----------------------------------------------------\n");

        for (DetalleTicket detalle : detallesTicket) {
            if (detalle.getTickets().getIdTicket().equals(ticket.getIdTicket())) {
                Productos producto = detalle.getProductos();
                sb.append("Producto: ").append(producto.getNombreProducto()).append("\n");
                sb.append("Cantidad: ").append(detalle.getCantidadProducto()).append("\n");
                sb.append("Precio: ").append(producto.getPrecioProducto()).append("\n");
                sb.append("-----------------------------------------------------\n");
            }
        }

        return sb.toString();
    
    }
}
