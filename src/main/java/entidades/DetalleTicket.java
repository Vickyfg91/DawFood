/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author Victoria
 */
@Entity
@Table(name = "detalle_ticket")
@NamedQueries({
    ////consultas a la bd con metodos predefinidos que se encuentra en el JPA 
    @NamedQuery(name = "DetalleTicket.findAll", query = "SELECT d FROM DetalleTicket d"),
    @NamedQuery(name = "DetalleTicket.findByIdProducto", query = "SELECT d FROM DetalleTicket d WHERE d.detalleTicketPK.idProducto = :idProducto"),
    @NamedQuery(name = "DetalleTicket.findByIdTicket", query = "SELECT d FROM DetalleTicket d WHERE d.detalleTicketPK.idTicket = :idTicket"),
    @NamedQuery(name = "DetalleTicket.findByCantidadProducto", query = "SELECT d FROM DetalleTicket d WHERE d.cantidadProducto = :cantidadProducto")})
public class DetalleTicket implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected DetalleTicketPK detalleTicketPK;
    @Basic(optional = false)
    @Column(name = "cantidad_producto")
    private int cantidadProducto;
    @JoinColumn(name = "id_producto", referencedColumnName = "id_producto", insertable = false, updatable = false)
    //La entidad DetalleTicket tiene una relacion muchos a uno quiere decir que un detalle ticket tiene solo un producto y solo un ticket 
    @ManyToOne(optional = false)
    private Productos productos;
    @JoinColumn(name = "id_ticket", referencedColumnName = "id_ticket", insertable = false, updatable = false)
    //Indica una relación de muchos a uno con la entidad Tickets, lo que significa que cada DetalleTicket debe estar asociado con un ticket y que esta asociación es obligatoria
    @ManyToOne(optional = false)
    private Tickets tickets;

    public DetalleTicket() {
    }

    public DetalleTicket(DetalleTicketPK detalleTicketPK) {
        this.detalleTicketPK = detalleTicketPK;
    }

    public DetalleTicket(DetalleTicketPK detalleTicketPK, int cantidadProducto) {
        this.detalleTicketPK = detalleTicketPK;
        this.cantidadProducto = cantidadProducto;
    }

    public DetalleTicket(int idProducto, int idTicket) {
        this.detalleTicketPK = new DetalleTicketPK(idProducto, idTicket);
    }

    public DetalleTicketPK getDetalleTicketPK() {
        return detalleTicketPK;
    }

    public void setDetalleTicketPK(DetalleTicketPK detalleTicketPK) {
        this.detalleTicketPK = detalleTicketPK;
    }

    public int getCantidadProducto() {
        return cantidadProducto;
    }

    public void setCantidadProducto(int cantidadProducto) {
        this.cantidadProducto = cantidadProducto;
    }

    public Productos getProductos() {
        return productos;
    }

    public void setProductos(Productos productos) {
        this.productos = productos;
    }

    public Tickets getTickets() {
        return tickets;
    }

    public void setTickets(Tickets tickets) {
        this.tickets = tickets;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (detalleTicketPK != null ? detalleTicketPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DetalleTicket)) {
            return false;
        }
        DetalleTicket other = (DetalleTicket) object;
        if ((this.detalleTicketPK == null && other.detalleTicketPK != null) || (this.detalleTicketPK != null && !this.detalleTicketPK.equals(other.detalleTicketPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.DetalleTicket[ detalleTicketPK=" + detalleTicketPK + " ]";
    }
    
}
