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
@Table(name = "vendedor")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Vendedor.findAll", query = "SELECT v FROM Vendedor v")
    , @NamedQuery(name = "Vendedor.findByIdVendedor", query = "SELECT v FROM Vendedor v WHERE v.idVendedor = :idVendedor")
    , @NamedQuery(name = "Vendedor.findByNombreVendedor", query = "SELECT v FROM Vendedor v WHERE v.nombreVendedor = :nombreVendedor")
    , @NamedQuery(name = "Vendedor.findByPassVendedor", query = "SELECT v FROM Vendedor v WHERE v.passVendedor = :passVendedor")
    , @NamedQuery(name = "Vendedor.findByFlagVendedor", query = "SELECT v FROM Vendedor v WHERE v.flagVendedor = :flagVendedor")})
public class Vendedor implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_vendedor")
    private Integer idVendedor;
    @Size(max = 25)
    @Column(name = "nombre_vendedor")
    private String nombreVendedor;
    @Size(max = 32)
    @Column(name = "pass_vendedor")
    private String passVendedor;
    @Basic(optional = false)
    @NotNull
    @Column(name = "flag_vendedor")
    private boolean flagVendedor;
    @OneToMany(mappedBy = "idVendedor", fetch = FetchType.LAZY)
    private List<Ventas> ventasList;

    public Vendedor() {
    }

    public Vendedor(Integer idVendedor) {
        this.idVendedor = idVendedor;
    }

    public Vendedor(Integer idVendedor, boolean flagVendedor) {
        this.idVendedor = idVendedor;
        this.flagVendedor = flagVendedor;
    }

    public Integer getIdVendedor() {
        return idVendedor;
    }

    public void setIdVendedor(Integer idVendedor) {
        this.idVendedor = idVendedor;
    }

    public String getNombreVendedor() {
        return nombreVendedor;
    }

    public void setNombreVendedor(String nombreVendedor) {
        this.nombreVendedor = nombreVendedor;
    }

    public String getPassVendedor() {
        return passVendedor;
    }

    public void setPassVendedor(String passVendedor) {
        this.passVendedor = passVendedor;
    }

    public boolean getFlagVendedor() {
        return flagVendedor;
    }

    public void setFlagVendedor(boolean flagVendedor) {
        this.flagVendedor = flagVendedor;
    }

    @XmlTransient
    public List<Ventas> getVentasList() {
        return ventasList;
    }

    public void setVentasList(List<Ventas> ventasList) {
        this.ventasList = ventasList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idVendedor != null ? idVendedor.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Vendedor)) {
            return false;
        }
        Vendedor other = (Vendedor) object;
        if ((this.idVendedor == null && other.idVendedor != null) || (this.idVendedor != null && !this.idVendedor.equals(other.idVendedor))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ferrimatel.modelo.Vendedor[ idVendedor=" + idVendedor + " ]";
    }
    
}
