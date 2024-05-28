/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author vickyfg
 */
@Entity
@Table(name = "tickets")
@NamedQueries({
    @NamedQuery(name = "Tickets.findAll", query = "SELECT t FROM Tickets t"),
    @NamedQuery(name = "Tickets.findByIdTicket", query = "SELECT t FROM Tickets t WHERE t.idTicket = :idTicket"),
    @NamedQuery(name = "Tickets.findByFechaTicket", query = "SELECT t FROM Tickets t WHERE t.fechaTicket = :fechaTicket"),
    @NamedQuery(name = "Tickets.findBySubtotalProducto", query = "SELECT t FROM Tickets t WHERE t.subtotalProducto = :subtotalProducto"),
    @NamedQuery(name = "Tickets.findByTotalTicket", query = "SELECT t FROM Tickets t WHERE t.totalTicket = :totalTicket"),
    @NamedQuery(name = "Tickets.findByCodTransaccion", query = "SELECT t FROM Tickets t WHERE t.codTransaccion = :codTransaccion")})
public class Tickets implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_ticket")
    private Integer idTicket;
    @Basic(optional = false)
    @Column(name = "fecha_ticket")
    @Temporal(TemporalType.DATE)
    private Date fechaTicket;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "subtotal_producto")
    private BigDecimal subtotalProducto;
    @Basic(optional = false)
    @Column(name = "total_ticket")
    private BigDecimal totalTicket;
    @Basic(optional = false)
    @Column(name = "cod_transaccion")
    private int codTransaccion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tickets")
    private Collection<DetalleTicket> detalleTicketCollection;
    @JoinColumn(name = "id_tpv", referencedColumnName = "id_tpv")
    @ManyToOne(optional = false)
    private Tpv idTpv;

    public Tickets() {
    }

    public Tickets(Integer idTicket) {
        this.idTicket = idTicket;
    }

    public Tickets(Integer idTicket, Date fechaTicket, BigDecimal subtotalProducto, BigDecimal totalTicket, int codTransaccion) {
        this.idTicket = idTicket;
        this.fechaTicket = fechaTicket;
        this.subtotalProducto = subtotalProducto;
        this.totalTicket = totalTicket;
        this.codTransaccion = codTransaccion;
    }

    public Integer getIdTicket() {
        return idTicket;
    }

    public void setIdTicket(Integer idTicket) {
        this.idTicket = idTicket;
    }

    public Date getFechaTicket() {
        return fechaTicket;
    }

    public void setFechaTicket(Date fechaTicket) {
        this.fechaTicket = fechaTicket;
    }

    public BigDecimal getSubtotalProducto() {
        return subtotalProducto;
    }

    public void setSubtotalProducto(BigDecimal subtotalProducto) {
        this.subtotalProducto = subtotalProducto;
    }

    public BigDecimal getTotalTicket() {
        return totalTicket;
    }

    public void setTotalTicket(BigDecimal totalTicket) {
        this.totalTicket = totalTicket;
    }

    public int getCodTransaccion() {
        return codTransaccion;
    }

    public void setCodTransaccion(int codTransaccion) {
        this.codTransaccion = codTransaccion;
    }

    public Collection<DetalleTicket> getDetalleTicketCollection() {
        return detalleTicketCollection;
    }

    public void setDetalleTicketCollection(Collection<DetalleTicket> detalleTicketCollection) {
        this.detalleTicketCollection = detalleTicketCollection;
    }

    public Tpv getIdTpv() {
        return idTpv;
    }

    public void setIdTpv(Tpv idTpv) {
        this.idTpv = idTpv;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTicket != null ? idTicket.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tickets)) {
            return false;
        }
        Tickets other = (Tickets) object;
        if ((this.idTicket == null && other.idTicket != null) || (this.idTicket != null && !this.idTicket.equals(other.idTicket))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Tickets[ idTicket=" + idTicket + " ]";
    }
    
}
