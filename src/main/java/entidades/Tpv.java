/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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
@Table(name = "tpv")
@NamedQueries({
    @NamedQuery(name = "Tpv.findAll", query = "SELECT t FROM Tpv t"),
    @NamedQuery(name = "Tpv.findByIdTpv", query = "SELECT t FROM Tpv t WHERE t.idTpv = :idTpv"),
    @NamedQuery(name = "Tpv.findByCiudad", query = "SELECT t FROM Tpv t WHERE t.ciudad = :ciudad"),
    @NamedQuery(name = "Tpv.findByTpvFecha", query = "SELECT t FROM Tpv t WHERE t.tpvFecha = :tpvFecha"),
    @NamedQuery(name = "Tpv.findByTpvHora", query = "SELECT t FROM Tpv t WHERE t.tpvHora = :tpvHora")})
public class Tpv implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_tpv")
    private Integer idTpv;
    @Basic(optional = false)
    @Column(name = "ciudad")
    private String ciudad;
    @Basic(optional = false)
    @Column(name = "tpv_fecha")
    @Temporal(TemporalType.DATE)
    private Date tpvFecha;
    @Basic(optional = false)
    @Column(name = "tpv_hora")
    @Temporal(TemporalType.TIME)
    private Date tpvHora;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTpv")
    private Collection<Tickets> ticketsCollection;

    public Tpv() {
    }

    public Tpv(Integer idTpv) {
        this.idTpv = idTpv;
    }

    public Tpv(Integer idTpv, String ciudad, Date tpvFecha, Date tpvHora) {
        this.idTpv = idTpv;
        this.ciudad = ciudad;
        this.tpvFecha = tpvFecha;
        this.tpvHora = tpvHora;
    }

    public Integer getIdTpv() {
        return idTpv;
    }

    public void setIdTpv(Integer idTpv) {
        this.idTpv = idTpv;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public Date getTpvFecha() {
        return tpvFecha;
    }

    public void setTpvFecha(Date tpvFecha) {
        this.tpvFecha = tpvFecha;
    }

    public Date getTpvHora() {
        return tpvHora;
    }

    public void setTpvHora(Date tpvHora) {
        this.tpvHora = tpvHora;
    }

    public Collection<Tickets> getTicketsCollection() {
        return ticketsCollection;
    }

    public void setTicketsCollection(Collection<Tickets> ticketsCollection) {
        this.ticketsCollection = ticketsCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTpv != null ? idTpv.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tpv)) {
            return false;
        }
        Tpv other = (Tpv) object;
        if ((this.idTpv == null && other.idTpv != null) || (this.idTpv != null && !this.idTpv.equals(other.idTpv))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Tpv[ idTpv=" + idTpv + " ]";
    }
    
}
