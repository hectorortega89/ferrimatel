package com.ferrimatel.dto;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@XmlRootElement
public class TotalVenta {

    @Id
    private int id;
    private String codigoProd;
    private int cantidadProd;
    private String detalleProd;
    private double puProd;
    private double ptProd;
    
    

    public TotalVenta() {
    }

    public TotalVenta(int id, String codigoProd, int cantidadProd, String detalleProd, double puProd, double ptProd) {
        this.id = id;
        this.codigoProd = codigoProd;
        this.cantidadProd = cantidadProd;
        this.detalleProd = detalleProd;
        this.puProd = puProd;
        this.ptProd = ptProd;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCodigoProd() {
        return codigoProd;
    }

    public void setCodigoProd(String codigoProd) {
        this.codigoProd = codigoProd;
    }

    public int getCantidadProd() {
        return cantidadProd;
    }

    public void setCantidadProd(int cantidadProd) {
        this.cantidadProd = cantidadProd;
    }

    public String getDetalleProd() {
        return detalleProd;
    }

    public void setDetalleProd(String detalleProd) {
        this.detalleProd = detalleProd;
    }

    public double getPuProd() {
        return puProd;
    }

    public void setPuProd(double puProd) {
        this.puProd = puProd;
    }

    public double getPtProd() {
        return ptProd;
    }

    public void setPtProd(double ptProd) {
        this.ptProd = ptProd;
    }

}
