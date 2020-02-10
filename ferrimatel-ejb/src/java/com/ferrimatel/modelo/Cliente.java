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
@Table(name = "cliente")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cliente.findAll", query = "SELECT c FROM Cliente c")
    , @NamedQuery(name = "Cliente.findByIdCliente", query = "SELECT c FROM Cliente c WHERE c.idCliente = :idCliente")
    , @NamedQuery(name = "Cliente.findByCedulaCl", query = "SELECT c FROM Cliente c WHERE c.cedulaCl = :cedulaCl")
    , @NamedQuery(name = "Cliente.findByNombreCl", query = "SELECT c FROM Cliente c WHERE c.nombreCl = :nombreCl")
    , @NamedQuery(name = "Cliente.findByApellidoCl", query = "SELECT c FROM Cliente c WHERE c.apellidoCl = :apellidoCl")
    , @NamedQuery(name = "Cliente.findByDireccionCl", query = "SELECT c FROM Cliente c WHERE c.direccionCl = :direccionCl")
    , @NamedQuery(name = "Cliente.findByTelefonoCl", query = "SELECT c FROM Cliente c WHERE c.telefonoCl = :telefonoCl")
    , @NamedQuery(name = "Cliente.findByEmailCl", query = "SELECT c FROM Cliente c WHERE c.emailCl = :emailCl")
    , @NamedQuery(name = "Cliente.findByFlagCl", query = "SELECT c FROM Cliente c WHERE c.flagCl = :flagCl")})
public class Cliente implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_cliente")
    private Integer idCliente;
    @Size(max = 13)
    @Column(name = "cedula_cl")
    private String cedulaCl;
    @Size(max = 30)
    @Column(name = "nombre_cl")
    private String nombreCl;
    @Size(max = 20)
    @Column(name = "apellido_cl")
    private String apellidoCl;
    @Size(max = 50)
    @Column(name = "direccion_cl")
    private String direccionCl;
    @Size(max = 13)
    @Column(name = "telefono_cl")
    private String telefonoCl;
    @Size(max = 35)
    @Column(name = "email_cl")
    private String emailCl;
    @Basic(optional = false)
    @NotNull
    @Column(name = "flag_cl")
    private boolean flagCl;
    @OneToMany(mappedBy = "idCliente", fetch = FetchType.LAZY)
    private List<Pedido> pedidoList;

    public Cliente() {
    }

    public Cliente(Integer idCliente) {
        this.idCliente = idCliente;
    }

    public Cliente(Integer idCliente, boolean flagCl) {
        this.idCliente = idCliente;
        this.flagCl = flagCl;
    }

    public Integer getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }

    public String getCedulaCl() {
        return cedulaCl;
    }

    public void setCedulaCl(String cedulaCl) {
        this.cedulaCl = cedulaCl;
    }

    public String getNombreCl() {
        return nombreCl;
    }

    public void setNombreCl(String nombreCl) {
        this.nombreCl = nombreCl;
    }

    public String getApellidoCl() {
        return apellidoCl;
    }

    public void setApellidoCl(String apellidoCl) {
        this.apellidoCl = apellidoCl;
    }

    public String getDireccionCl() {
        return direccionCl;
    }

    public void setDireccionCl(String direccionCl) {
        this.direccionCl = direccionCl;
    }

    public String getTelefonoCl() {
        return telefonoCl;
    }

    public void setTelefonoCl(String telefonoCl) {
        this.telefonoCl = telefonoCl;
    }

    public String getEmailCl() {
        return emailCl;
    }

    public void setEmailCl(String emailCl) {
        this.emailCl = emailCl;
    }

    public boolean getFlagCl() {
        return flagCl;
    }

    public void setFlagCl(boolean flagCl) {
        this.flagCl = flagCl;
    }

    @XmlTransient
    public List<Pedido> getPedidoList() {
        return pedidoList;
    }

    public void setPedidoList(List<Pedido> pedidoList) {
        this.pedidoList = pedidoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCliente != null ? idCliente.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cliente)) {
            return false;
        }
        Cliente other = (Cliente) object;
        if ((this.idCliente == null && other.idCliente != null) || (this.idCliente != null && !this.idCliente.equals(other.idCliente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ferrimatel.modelo.Cliente[ idCliente=" + idCliente + " ]";
    }
    
}
