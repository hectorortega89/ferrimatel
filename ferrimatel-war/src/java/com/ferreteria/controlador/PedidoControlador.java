/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ferreteria.controlador;

import com.ferrimatel.dto.Reporte;
import com.ferrimatel.modelo.Cliente;
import com.ferrimatel.modelo.Pedido;
import com.ferrimatel.modelo.Producto;
import com.ferrimatel.services.ClienteServicio;
import com.ferrimatel.services.PedidoServicio;
import com.ferrimatel.services.ProductoServicio;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

@ManagedBean
@ViewScoped
public class PedidoControlador {

    @EJB
    private PedidoServicio pedidoServicio;
    
    @EJB
    private ClienteServicio clienteServicio;

    @EJB
    private ProductoServicio productoServicio;

    private List<Producto> listaPedidosActivos;
    private List<Cliente> listaClientes;
    private List<Reporte> listaPedidosActivosReporte;
    private Pedido pedido;
    private Integer idCliente;
    private Integer idProducto;

    @PostConstruct
    public void init() {
        pedido = new Pedido();
        setListaPedidosActivosReporte(pedidoServicio.obtenerReportePedidosLista());
    }
    
    public void eliminarProductos(Pedido ped) {
        if (ped != null) {
            ped.setFlagPedido(false);
            Boolean pedidoExiste = pedidoServicio.guardarPedidos(ped);
            if (pedidoExiste) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "El registro ha sido eliminado exitosamente."));
            } else {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "El registro no ha sido eliminado."));
            }
            init();
        }

    }

    public PedidoServicio getPedidoServicio() {
        return pedidoServicio;
    }

    public void setPedidoServicio(PedidoServicio pedidoServicio) {
        this.pedidoServicio = pedidoServicio;
    }

    public ClienteServicio getClienteServicio() {
        return clienteServicio;
    }

    public void setClienteServicio(ClienteServicio clienteServicio) {
        this.clienteServicio = clienteServicio;
    }

    public ProductoServicio getProductoServicio() {
        return productoServicio;
    }

    public void setProductoServicio(ProductoServicio productoServicio) {
        this.productoServicio = productoServicio;
    }

    public List<Producto> getListaPedidosActivos() {
        return listaPedidosActivos;
    }

    public void setListaPedidosActivos(List<Producto> listaPedidosActivos) {
        this.listaPedidosActivos = listaPedidosActivos;
    }

    public List<Cliente> getListaClientes() {
        return listaClientes;
    }

    public void setListaClientes(List<Cliente> listaClientes) {
        this.listaClientes = listaClientes;
    }

    public List<Reporte> getListaPedidosActivosReporte() {
        return listaPedidosActivosReporte;
    }

    public void setListaPedidosActivosReporte(List<Reporte> listaPedidosActivosReporte) {
        this.listaPedidosActivosReporte = listaPedidosActivosReporte;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public Integer getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }

    public Integer getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Integer idProducto) {
        this.idProducto = idProducto;
    }

    

}
