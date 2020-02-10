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
@Table(name = "producto")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Producto.findAll", query = "SELECT p FROM Producto p")
    , @NamedQuery(name = "Producto.findByIdProd", query = "SELECT p FROM Producto p WHERE p.idProd = :idProd")
    , @NamedQuery(name = "Producto.findByPrecioProd", query = "SELECT p FROM Producto p WHERE p.precioProd = :precioProd")
    , @NamedQuery(name = "Producto.findByCategoriaProd", query = "SELECT p FROM Producto p WHERE p.categoriaProd = :categoriaProd")
    , @NamedQuery(name = "Producto.findByCantidadProd", query = "SELECT p FROM Producto p WHERE p.cantidadProd = :cantidadProd")
    , @NamedQuery(name = "Producto.findByDetalleProd", query = "SELECT p FROM Producto p WHERE p.detalleProd = :detalleProd")
    , @NamedQuery(name = "Producto.findByFlagProd", query = "SELECT p FROM Producto p WHERE p.flagProd = :flagProd")
    , @NamedQuery(name = "Producto.findByDescripcionProd", query = "SELECT p FROM Producto p WHERE p.descripcionProd = :descripcionProd")
    , @NamedQuery(name = "Producto.findByCategoriaProd1", query = "SELECT p FROM Producto p WHERE p.categoriaProd1 = :categoriaProd1")
    , @NamedQuery(name = "Producto.findByCodigoProd", query = "SELECT p FROM Producto p WHERE p.codigoProd = :codigoProd")
    , @NamedQuery(name = "Producto.findByMarcaProd", query = "SELECT p FROM Producto p WHERE p.marcaProd = :marcaProd")})
public class Producto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_prod")
    private Integer idProd;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "precio_prod")
    private Double precioProd;
    @Size(max = 30)
    @Column(name = "categoria_prod")
    private String categoriaProd;
    @Column(name = "cantidad_prod")
    private Integer cantidadProd;
    @Size(max = 50)
    @Column(name = "detalle_prod")
    private String detalleProd;
    @Basic(optional = false)
    @NotNull
    @Column(name = "flag_prod")
    private boolean flagProd;
    @Size(max = 60)
    @Column(name = "descripcion_prod")
    private String descripcionProd;
    @Size(max = 25)
    @Column(name = "categoria_prod1")
    private String categoriaProd1;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "codigo_prod")
    private String codigoProd;
    @Size(max = 30)
    @Column(name = "marca_prod")
    private String marcaProd;
    @OneToMany(mappedBy = "idProd", fetch = FetchType.LAZY)
    private List<Locales> localesList;
    @OneToMany(mappedBy = "idProd", fetch = FetchType.LAZY)
    private List<Pedido> pedidoList;
    @OneToMany(mappedBy = "idProd", fetch = FetchType.LAZY)
    private List<Bodega> bodegaList;

    public Producto() {
    }

    public Producto(Integer idProd) {
        this.idProd = idProd;
    }

    public Producto(Integer idProd, boolean flagProd, String codigoProd) {
        this.idProd = idProd;
        this.flagProd = flagProd;
        this.codigoProd = codigoProd;
    }

    public Integer getIdProd() {
        return idProd;
    }

    public void setIdProd(Integer idProd) {
        this.idProd = idProd;
    }

    public Double getPrecioProd() {
        return precioProd;
    }

    public void setPrecioProd(Double precioProd) {
        this.precioProd = precioProd;
    }

    public String getCategoriaProd() {
        return categoriaProd;
    }

    public void setCategoriaProd(String categoriaProd) {
        this.categoriaProd = categoriaProd;
    }

    public Integer getCantidadProd() {
        return cantidadProd;
    }

    public void setCantidadProd(Integer cantidadProd) {
        this.cantidadProd = cantidadProd;
    }

    public String getDetalleProd() {
        return detalleProd;
    }

    public void setDetalleProd(String detalleProd) {
        this.detalleProd = detalleProd;
    }

    public boolean getFlagProd() {
        return flagProd;
    }

    public void setFlagProd(boolean flagProd) {
        this.flagProd = flagProd;
    }

    public String getDescripcionProd() {
        return descripcionProd;
    }

    public void setDescripcionProd(String descripcionProd) {
        this.descripcionProd = descripcionProd;
    }

    public String getCategoriaProd1() {
        return categoriaProd1;
    }

    public void setCategoriaProd1(String categoriaProd1) {
        this.categoriaProd1 = categoriaProd1;
    }

    public String getCodigoProd() {
        return codigoProd;
    }

    public void setCodigoProd(String codigoProd) {
        this.codigoProd = codigoProd;
    }

    public String getMarcaProd() {
        return marcaProd;
    }

    public void setMarcaProd(String marcaProd) {
        this.marcaProd = marcaProd;
    }

    @XmlTransient
    public List<Locales> getLocalesList() {
        return localesList;
    }

    public void setLocalesList(List<Locales> localesList) {
        this.localesList = localesList;
    }

    @XmlTransient
    public List<Pedido> getPedidoList() {
        return pedidoList;
    }

    public void setPedidoList(List<Pedido> pedidoList) {
        this.pedidoList = pedidoList;
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
        hash += (idProd != null ? idProd.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Producto)) {
            return false;
        }
        Producto other = (Producto) object;
        if ((this.idProd == null && other.idProd != null) || (this.idProd != null && !this.idProd.equals(other.idProd))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ferrimatel.modelo.Producto[ idProd=" + idProd + " ]";
    }
    
}
