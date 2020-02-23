package com.ferreteria.controlador;

import com.ferrimatel.modelo.Producto;
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

    
    //ERROR, SOLO ALGUNOS PRODUCTOS ME RETORNAN, EL RESTO NO EXISTEN
    
    public void buscarProductoPorDetalle(){
        try {
            if (producto.getDetalleProd() != null) {
                Producto productoExiste = productoServicio.buscarProductoPorDetalle(producto.getDetalleProd());
                if (productoExiste != null) {
                    producto = productoExiste;
                    //setBotonActualizarVisible(true);
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "El producto ha sido seleccionado"));
                } else {
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "El producto no existe, por favor registrelo."));
                }
                
                //setCamposHabilitados(true);
            } else {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Por favor verifique los productos."));
            }
            init();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

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
