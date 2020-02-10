/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ferrimatel.modelo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Hector
 */
@Entity
@Table(name = "bodega")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Bodega.findAll", query = "SELECT b FROM Bodega b")
    , @NamedQuery(name = "Bodega.findByIdBodega", query = "SELECT b FROM Bodega b WHERE b.idBodega = :idBodega")
    , @NamedQuery(name = "Bodega.findByRackBodega", query = "SELECT b FROM Bodega b WHERE b.rackBodega = :rackBodega")
    , @NamedQuery(name = "Bodega.findByFlagBodega", query = "SELECT b FROM Bodega b WHERE b.flagBodega = :flagBodega")})
public class Bodega implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_bodega")
    private Integer idBodega;
    @Size(max = 20)
    @Column(name = "rack_bodega")
    private String rackBodega;
    @Basic(optional = false)
    @NotNull
    @Column(name = "flag_bodega")
    private boolean flagBodega;
    @JoinColumn(name = "id_prod", referencedColumnName = "id_prod")
    @ManyToOne(fetch = FetchType.LAZY)
    private Producto idProd;
    @JoinColumn(name = "id_prov", referencedColumnName = "id_prov")
    @ManyToOne(fetch = FetchType.LAZY)
    private Proveedor idProv;

    public Bodega() {
    }

    public Bodega(Integer idBodega) {
        this.idBodega = idBodega;
    }

    public Bodega(Integer idBodega, boolean flagBodega) {
        this.idBodega = idBodega;
        this.flagBodega = flagBodega;
    }

    public Integer getIdBodega() {
        return idBodega;
    }

    public void setIdBodega(Integer idBodega) {
        this.idBodega = idBodega;
    }

    public String getRackBodega() {
        return rackBodega;
    }

    public void setRackBodega(String rackBodega) {
        this.rackBodega = rackBodega;
    }

    public boolean getFlagBodega() {
        return flagBodega;
    }

    public void setFlagBodega(boolean flagBodega) {
        this.flagBodega = flagBodega;
    }

    public Producto getIdProd() {
        return idProd;
    }

    public void setIdProd(Producto idProd) {
        this.idProd = idProd;
    }

    public Proveedor getIdProv() {
        return idProv;
    }

    public void setIdProv(Proveedor idProv) {
        this.idProv = idProv;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idBodega != null ? idBodega.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Bodega)) {
            return false;
        }
        Bodega other = (Bodega) object;
        if ((this.idBodega == null && other.idBodega != null) || (this.idBodega != null && !this.idBodega.equals(other.idBodega))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ferrimatel.modelo.Bodega[ idBodega=" + idBodega + " ]";
    }
    
}
