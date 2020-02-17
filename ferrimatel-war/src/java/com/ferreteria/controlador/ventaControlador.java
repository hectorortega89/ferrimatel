package com.ferreteria.controlador;

import com.ferrimatel.modelo.Producto;
import com.ferrimatel.services.ClienteServicio;
import com.ferrimatel.services.ProductoServicio;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
public class ventaControlador {

    @EJB
    private ClienteServicio clienteServicio;

    private ProductoServicio productoServicio;
    private Producto producto;
    private List<Producto> listaProductoActivo;
    private String codigo;
    private int cantidad;
    private String detalle;
    private double precioUnit;

    public ventaControlador(ClienteServicio clienteServicio, ProductoServicio productoServicio, List<Producto> listaProductoActivo, String codigo, int cantidad, String detalle, double precioUnit) {
        this.clienteServicio = clienteServicio;
        this.productoServicio = productoServicio;
        this.listaProductoActivo = listaProductoActivo;
        this.codigo = codigo;
        this.cantidad = cantidad;
        this.detalle = detalle;
        this.precioUnit = precioUnit;
    }

    public ventaControlador() {
    }
    
    public void init(){
    producto = new Producto();
    
    listaProductoActivo = productoServicio.obtenerProductosActivos();
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

    public List<Producto> getListaProductoActivo() {
        return listaProductoActivo;
    }

    public void setListaProductoActivo(List<Producto> listaProductoActivo) {
        this.listaProductoActivo = listaProductoActivo;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public double getPrecioUnit() {
        return precioUnit;
    }

    public void setPrecioUnit(double precioUnit) {
        this.precioUnit = precioUnit;
    }

}
