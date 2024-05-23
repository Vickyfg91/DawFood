/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author vickyfg
 */
@Embeddable
public class DetalleTicketPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "id_producto")
    private int idProducto;
    @Basic(optional = false)
    @Column(name = "id_ticket")
    private int idTicket;
    @Basic(optional = false)
    @Column(name = "cantidad_producto")
    private int cantidadProducto;

    public DetalleTicketPK() {
    }

    public DetalleTicketPK(int idProducto, int idTicket, int cantidadProducto) {
        this.idProducto = idProducto;
        this.idTicket = idTicket;
        this.cantidadProducto = cantidadProducto;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public int getIdTicket() {
        return idTicket;
    }

    public void setIdTicket(int idTicket) {
        this.idTicket = idTicket;
    }

    public int getCantidadProducto() {
        return cantidadProducto;
    }

    public void setCantidadProducto(int cantidadProducto) {
        this.cantidadProducto = cantidadProducto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idProducto;
        hash += (int) idTicket;
        hash += (int) cantidadProducto;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DetalleTicketPK)) {
            return false;
        }
        DetalleTicketPK other = (DetalleTicketPK) object;
        if (this.idProducto != other.idProducto) {
            return false;
        }
        if (this.idTicket != other.idTicket) {
            return false;
        }
        if (this.cantidadProducto != other.cantidadProducto) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.DetalleTicketPK[ idProducto=" + idProducto + ", idTicket=" + idTicket + ", cantidadProducto=" + cantidadProducto + " ]";
    }
    
}
