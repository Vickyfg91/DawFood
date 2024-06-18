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
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Victoria
 */
@Entity
@Table(name = "tipos_productos")
@NamedQueries({
    @NamedQuery(name = "TiposProductos.findAll", query = "SELECT t FROM TiposProductos t"),
    @NamedQuery(name = "TiposProductos.findByIdTipo", query = "SELECT t FROM TiposProductos t WHERE t.idTipo = :idTipo"),
    @NamedQuery(name = "TiposProductos.findByNombreSubcategoria", query = "SELECT t FROM TiposProductos t WHERE t.nombreSubcategoria = :nombreSubcategoria"),
    @NamedQuery(name = "TiposProductos.findByCategoria", query = "SELECT t FROM TiposProductos t WHERE t.categoria = :categoria")})
public class TiposProductos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_tipo")
    private Integer idTipo;
    @Column(name = "nombre_subcategoria")
    private String nombreSubcategoria;
    @Basic(optional = false)
    @Column(name = "categoria")
    private String categoria;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTipo")
    private Collection<Productos> productosCollection;

    public TiposProductos() {
    }

    public TiposProductos(Integer idTipo) {
        this.idTipo = idTipo;
    }

    public TiposProductos(Integer idTipo, String categoria) {
        this.idTipo = idTipo;
        this.categoria = categoria;
    }

    public Integer getIdTipo() {
        return idTipo;
    }

    public void setIdTipo(Integer idTipo) {
        this.idTipo = idTipo;
    }

    public String getNombreSubcategoria() {
        return nombreSubcategoria;
    }

    public void setNombreSubcategoria(String nombreSubcategoria) {
        this.nombreSubcategoria = nombreSubcategoria;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public Collection<Productos> getProductosCollection() {
        return productosCollection;
    }

    public void setProductosCollection(Collection<Productos> productosCollection) {
        this.productosCollection = productosCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTipo != null ? idTipo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TiposProductos)) {
            return false;
        }
        TiposProductos other = (TiposProductos) object;
        if ((this.idTipo == null && other.idTipo != null) || (this.idTipo != null && !this.idTipo.equals(other.idTipo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.TiposProductos[ idTipo=" + idTipo + " ]";
    }
    
}
