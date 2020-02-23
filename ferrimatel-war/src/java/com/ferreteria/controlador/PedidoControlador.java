/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ferreteria.controlador;

import com.ferrimatel.modelo.Pedido;
import com.ferrimatel.services.PedidoServicio;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
public class PedidoControlador {

    @EJB
    private PedidoServicio pedidoServicio;

    private Pedido pedido;
    private List<Pedido> listaPedidosActivos;
    private Boolean botonActualizarVisible; 

    @PostConstruct
    public void init() {

        pedido = new Pedido();
        listaPedidosActivos = pedidoServicio.obtenerPedidosActivos();
        setBotonActualizarVisible((Boolean) false);
    }

    public void habilitarActualizacion(Pedido pedi) {
        pedido = pedi;
        setBotonActualizarVisible((Boolean) true);
    }

    public PedidoServicio getPedidoServicio() {
        return pedidoServicio;
    }

    public void setPedidoServicio(PedidoServicio pedidoServicio) {
        this.pedidoServicio = pedidoServicio;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public List<Pedido> getListaPedidosActivos() {
        return listaPedidosActivos;
    }

    public void setListaPedidosActivos(List<Pedido> listaPedidosActivos) {
        this.listaPedidosActivos = listaPedidosActivos;
    }

    public Boolean getBotonActualizarVisible() {
        return botonActualizarVisible;
    }

    public void setBotonActualizarVisible(Boolean botonActualizarVisible) {
        this.botonActualizarVisible = botonActualizarVisible;
    }

}
