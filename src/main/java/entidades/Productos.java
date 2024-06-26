/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

import java.io.Serializable;
import java.util.Collection;
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

/**
 *
 * @author Victoria
 */
@Entity
@Table(name = "productos")
@NamedQueries({
    //consultas a la bd con metodos predefinidos que se encuentra en el JPA 
    @NamedQuery(name = "Productos.findAll", query = "SELECT p FROM Productos p"),
    @NamedQuery(name = "Productos.findByIdProducto", query = "SELECT p FROM Productos p WHERE p.idProducto = :idProducto"),
    @NamedQuery(name = "Productos.findByNombreProducto", query = "SELECT p FROM Productos p WHERE p.nombreProducto = :nombreProducto"),
    @NamedQuery(name = "Productos.findByPrecioProducto", query = "SELECT p FROM Productos p WHERE p.precioProducto = :precioProducto"),
    @NamedQuery(name = "Productos.findByIvaProducto", query = "SELECT p FROM Productos p WHERE p.ivaProducto = :ivaProducto"),
    @NamedQuery(name = "Productos.findByStockProducto", query = "SELECT p FROM Productos p WHERE p.stockProducto = :stockProducto"),
    @NamedQuery(name = "Productos.findByDescripcionProducto", query = "SELECT p FROM Productos p WHERE p.descripcionProducto = :descripcionProducto")})
public class Productos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_producto")
    private Integer idProducto;
    @Basic(optional = false)
    @Column(name = "nombre_producto")
    private String nombreProducto;
    @Basic(optional = false)
    @Column(name = "precio_producto")
    private double precioProducto;
    @Basic(optional = false)
    @Column(name = "iva_producto")
    private int ivaProducto;
    @Basic(optional = false)
    @Column(name = "stock_producto")
    private int stockProducto;
    @Column(name = "descripcion_producto")
    private String descripcionProducto;
    //Un producto está relacionado con muchos DetalleTicket (en un producto aparecen muchos detalle de tickets, pero en un DetalleTicket solo aparece un producto)
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "productos")
    private Collection<DetalleTicket> detalleTicketCollection;
    @JoinColumn(name = "id_tipo", referencedColumnName = "id_tipo")
    // Un producto está relacionado con un tipo de producto (muchos productos pueden pertenecer a un tipo de producto, pero un producto solo puede pertenecer a un tipo)
    @ManyToOne(optional = false)
    private TiposProductos idTipo;

    public Productos() {
    }

    public Productos(Integer idProducto) {
        this.idProducto = idProducto;
    }

    public Productos(Integer idProducto, String nombreProducto, double precioProducto, int ivaProducto, int stockProducto) {
        this.idProducto = idProducto;
        this.nombreProducto = nombreProducto;
        this.precioProducto = precioProducto;
        this.ivaProducto = ivaProducto;
        this.stockProducto = stockProducto;
    }

    public Integer getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Integer idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public double getPrecioProducto() {
        return precioProducto;
    }

    public void setPrecioProducto(double precioProducto) {
        this.precioProducto = precioProducto;
    }

    public int getIvaProducto() {
        return ivaProducto;
    }

    public void setIvaProducto(int ivaProducto) {
        this.ivaProducto = ivaProducto;
    }

    public int getStockProducto() {
        return stockProducto;
    }

    public void setStockProducto(int stockProducto) {
        this.stockProducto = stockProducto;
    }

    public String getDescripcionProducto() {
        return descripcionProducto;
    }

    public void setDescripcionProducto(String descripcionProducto) {
        this.descripcionProducto = descripcionProducto;
    }

    public Collection<DetalleTicket> getDetalleTicketCollection() {
        return detalleTicketCollection;
    }

    public void setDetalleTicketCollection(Collection<DetalleTicket> detalleTicketCollection) {
        this.detalleTicketCollection = detalleTicketCollection;
    }

    public TiposProductos getIdTipo() {
        return idTipo;
    }

    public void setIdTipo(TiposProductos idTipo) {
        this.idTipo = idTipo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idProducto != null ? idProducto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Productos)) {
            return false;
        }
        Productos other = (Productos) object;
        if ((this.idProducto == null && other.idProducto != null) || (this.idProducto != null && !this.idProducto.equals(other.idProducto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Productos[ idProducto=" + idProducto + " ]";
    }
    
    
}
