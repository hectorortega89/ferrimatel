/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ferrimatel.modelo;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Hector
 */
@Entity
@Table(name = "proveedor")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Proveedor.findAll", query = "SELECT p FROM Proveedor p")
    , @NamedQuery(name = "Proveedor.findByIdProv", query = "SELECT p FROM Proveedor p WHERE p.idProv = :idProv")
    , @NamedQuery(name = "Proveedor.findByNombreProv", query = "SELECT p FROM Proveedor p WHERE p.nombreProv = :nombreProv")
    , @NamedQuery(name = "Proveedor.findByRucProv", query = "SELECT p FROM Proveedor p WHERE p.rucProv = :rucProv")
    , @NamedQuery(name = "Proveedor.findByFlagProv", query = "SELECT p FROM Proveedor p WHERE p.flagProv = :flagProv")})
public class Proveedor implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_prov")
    private Integer idProv;
    @Size(max = 30)
    @Column(name = "nombre_prov")
    private String nombreProv;
    @Size(max = 30)
    @Column(name = "ruc_prov")
    private String rucProv;
    @Basic(optional = false)
    @NotNull
    @Column(name = "flag_prov")
    private boolean flagProv;
    @OneToMany(mappedBy = "idProv", fetch = FetchType.LAZY)
    private List<Bodega> bodegaList;

    public Proveedor() {
    }

    public Proveedor(Integer idProv) {
        this.idProv = idProv;
    }

    public Proveedor(Integer idProv, boolean flagProv) {
        this.idProv = idProv;
        this.flagProv = flagProv;
    }

    public Integer getIdProv() {
        return idProv;
    }

    public void setIdProv(Integer idProv) {
        this.idProv = idProv;
    }

    public String getNombreProv() {
        return nombreProv;
    }

    public void setNombreProv(String nombreProv) {
        this.nombreProv = nombreProv;
    }

    public String getRucProv() {
        return rucProv;
    }

    public void setRucProv(String rucProv) {
        this.rucProv = rucProv;
    }

    public boolean getFlagProv() {
        return flagProv;
    }

    public void setFlagProv(boolean flagProv) {
        this.flagProv = flagProv;
    }

    @XmlTransient
    public List<Bodega> getBodegaList() {
        return bodegaList;
    }

    public void setBodegaList(List<Bodega> bodegaList) {
        this.bodegaList = bodegaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idProv != null ? idProv.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Proveedor)) {
            return false;
        }
        Proveedor other = (Proveedor) object;
        if ((this.idProv == null && other.idProv != null) || (this.idProv != null && !this.idProv.equals(other.idProv))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ferrimatel.modelo.Proveedor[ idProv=" + idProv + " ]";
    }
    
}
