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
@Table(name = "locales")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Locales.findAll", query = "SELECT l FROM Locales l")
    , @NamedQuery(name = "Locales.findByIdLocales", query = "SELECT l FROM Locales l WHERE l.idLocales = :idLocales")
    , @NamedQuery(name = "Locales.findByUbicacionLocales", query = "SELECT l FROM Locales l WHERE l.ubicacionLocales = :ubicacionLocales")
    , @NamedQuery(name = "Locales.findByFlagLocales", query = "SELECT l FROM Locales l WHERE l.flagLocales = :flagLocales")})
public class Locales implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_locales")
    private Integer idLocales;
    @Size(max = 20)
    @Column(name = "ubicacion_locales")
    private String ubicacionLocales;
    @Basic(optional = false)
    @NotNull
    @Column(name = "flag_locales")
    private boolean flagLocales;
    @JoinColumn(name = "id_prod", referencedColumnName = "id_prod")
    @ManyToOne(fetch = FetchType.LAZY)
    private Producto idProd;

    public Locales() {
    }

    public Locales(Integer idLocales) {
        this.idLocales = idLocales;
    }

    public Locales(Integer idLocales, boolean flagLocales) {
        this.idLocales = idLocales;
        this.flagLocales = flagLocales;
    }

    public Integer getIdLocales() {
        return idLocales;
    }

    public void setIdLocales(Integer idLocales) {
        this.idLocales = idLocales;
    }

    public String getUbicacionLocales() {
        return ubicacionLocales;
    }

    public void setUbicacionLocales(String ubicacionLocales) {
        this.ubicacionLocales = ubicacionLocales;
    }

    public boolean getFlagLocales() {
        return flagLocales;
    }

    public void setFlagLocales(boolean flagLocales) {
        this.flagLocales = flagLocales;
    }

    public Producto getIdProd() {
        return idProd;
    }

    public void setIdProd(Producto idProd) {
        this.idProd = idProd;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idLocales != null ? idLocales.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Locales)) {
            return false;
        }
        Locales other = (Locales) object;
        if ((this.idLocales == null && other.idLocales != null) || (this.idLocales != null && !this.idLocales.equals(other.idLocales))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ferrimatel.modelo.Locales[ idLocales=" + idLocales + " ]";
    }
    
}
