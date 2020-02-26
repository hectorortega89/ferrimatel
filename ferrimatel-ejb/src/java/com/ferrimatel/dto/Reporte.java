
package com.ferrimatel.dto;

import java.sql.Date;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@XmlRootElement
public class Reporte {

    @Id
    private Integer idpedido;
    private Date fecha_pedido;
    private String nombre_cl;
    private String apellido_cl;
    private String detalle_prod;

    public Reporte() {
    }

    public Reporte(Integer idpedido, Date fecha_pedido, String nombre_cl, String apellido_cl, String detalle_prod) {
        this.idpedido = idpedido;
        this.fecha_pedido = fecha_pedido;
        this.nombre_cl = nombre_cl;
        this.apellido_cl = apellido_cl;
        this.detalle_prod = detalle_prod;
    }

    public Integer getIdpedido() {
        return idpedido;
    }

    public void setIdpedido(Integer idpedido) {
        this.idpedido = idpedido;
    }

    public Date getFecha_pedido() {
        return fecha_pedido;
    }

    public void setFecha_pedido(Date fecha_pedido) {
        this.fecha_pedido = fecha_pedido;
    }

    public String getNombre_cl() {
        return nombre_cl;
    }

    public void setNombre_cl(String nombre_cl) {
        this.nombre_cl = nombre_cl;
    }

    public String getApellido_cl() {
        return apellido_cl;
    }

    public void setApellido_cl(String apellido_cl) {
        this.apellido_cl = apellido_cl;
    }

    public String getDetalle_prod() {
        return detalle_prod;
    }

    public void setDetalle_prod(String detalle_prod) {
        this.detalle_prod = detalle_prod;
    }

}
