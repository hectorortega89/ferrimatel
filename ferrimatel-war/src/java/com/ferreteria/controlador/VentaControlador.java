package com.ferreteria.controlador;

import com.ferrimatel.dto.TotalVenta;
import com.ferrimatel.modelo.Cliente;
import com.ferrimatel.modelo.Pedido;
import com.ferrimatel.modelo.Producto;
import com.ferrimatel.modelo.Ventas;
import com.ferrimatel.services.ClienteServicio;
import com.ferrimatel.services.PedidoServicio;
import com.ferrimatel.services.ProductoServicio;
import com.ferrimatel.services.VentasServicio;
import java.lang.reflect.Array;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
public class VentaControlador {

    @EJB
    private VentasServicio ventasServicio;

    @EJB
    private ProductoServicio productoServicio;

    @EJB
    private ClienteServicio clienteServicio;

    @EJB
    private PedidoServicio pedidoServicio;

    private Pedido pedido;
    private Producto producto;
    private Cliente cliente;
    private Ventas ventas;
    private List<TotalVenta> listaTotalVenta;
    private List<Ventas> listaVentas;
    private VentasServicio ventaServicio;

    @PostConstruct
    public void init() {
        ventas = new Ventas();

        setListaTotalVenta(ventaServicio.obtenerVenta());
    }

    public VentasServicio getVentasServicio() {
        return ventasServicio;
    }

    public void setVentasServicio(VentasServicio ventasServicio) {
        this.ventasServicio = ventasServicio;
    }

    public List<Ventas> getListaVentas() {
        return listaVentas;
    }

    public void setListaVentas(List<Ventas> listaVentas) {
        this.listaVentas = listaVentas;
    }

    public ProductoServicio getProductoServicio() {
        return productoServicio;
    }

    public void setProductoServicio(ProductoServicio productoServicio) {
        this.productoServicio = productoServicio;
    }

    public ClienteServicio getClienteServicio() {
        return clienteServicio;
    }

    public void setClienteServicio(ClienteServicio clienteServicio) {
        this.clienteServicio = clienteServicio;
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

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Ventas getVentas() {
        return ventas;
    }

    public void setVentas(Ventas ventas) {
        this.ventas = ventas;
    }

    public VentasServicio getVentaServicio() {
        return ventaServicio;
    }

    public void setVentaServicio(VentasServicio ventaServicio) {
        this.ventaServicio = ventaServicio;
    }

    public List<TotalVenta> getListaTotalVenta() {
        return listaTotalVenta;
    }

    public void setListaTotalVenta(List<TotalVenta> listaTotalVenta) {
        this.listaTotalVenta = listaTotalVenta;
    }

}
