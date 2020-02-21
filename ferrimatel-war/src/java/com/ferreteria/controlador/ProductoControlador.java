package com.ferreteria.controlador;

import com.ferrimatel.modelo.Producto;
import com.ferrimatel.services.ProductoServicio;

import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
public class ProductoControlador {

    @EJB
    private ProductoServicio productoServicio;

    private List<Producto> listaProductosActivos;
    private Producto producto;

    @PostConstruct
    public void init() {
        setProducto(new Producto());
        //setIdCategoria(null);
        getProducto().setPrecioProd(new Double("0.00"));
        //getProducto().setPrecioProd(new Double("0.00"));
        setListaProductosActivos(productoServicio.obtenerProductosActivos());

    }

    public void guardarProductos() {
        // this.producto.setDescripcionProd(producto);
    }

    public ProductoServicio getProductoServicio() {
        return productoServicio;
    }

    public void setProductoServicio(ProductoServicio productoServicio) {
        this.productoServicio = productoServicio;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public List<Producto> getListaProductosActivos() {
        return listaProductosActivos;
    }

    public void setListaProductosActivos(List<Producto> listaProductosActivos) {
        this.listaProductosActivos = listaProductosActivos;
    }

}
