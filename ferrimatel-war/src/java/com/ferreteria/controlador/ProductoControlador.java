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
    private Boolean botonActualizarVisible;

    @PostConstruct
    public void init() {
        setProducto(new Producto());
        setListaProductosActivos(productoServicio.obtenerProductosActivos());
        setBotonActualizarVisible((Boolean) false);

    }

    //ERROR, SOLO ALGUNOS PRODUCTOS ME RETORNAN, EL RESTO NO EXISTEN
    public void guardarProducto() {
        boolean productoExiste = productoServicio.buscarProductoPorCodigo(producto.getCodigoProd());
        if (productoExiste) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "El producto ingresado ya existe."));
        } else {
            this.producto.setFlagProd(Boolean.TRUE);
            productoServicio.guardarProductoServicio(producto);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Exito", "El producto ha sido guardado existosamente."));
            init();
        }
    }

    //metodo actualizar (boton oculto)
    public void actualizarProducto() {

        setBotonActualizarVisible((Boolean) false);
        if (producto != null) {
            Boolean categoriaExiste = productoServicio.guardarProducto(producto);
            if (categoriaExiste) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "El registro ha sido actualizado exitosamente."));
            } else {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "El registro no ha sido actualizado."));
            }
            init();
        }

    }

    //metodo eliminar x
    public void eliminarProducto(Producto pro) {
        if (pro != null) {
            pro.setFlagProd(false);
            Boolean categoriaExiste = productoServicio.guardarProducto(pro);
            if (categoriaExiste) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "El registro ha sido eliminado exitosamente."));
            } else {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "El registro no ha sido eliminado."));
            }
            init();
        }

    }

    public void buscarProductoPorDetalle() {
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

    public Boolean getBotonActualizarVisible() {
        return botonActualizarVisible;
    }

    public void setBotonActualizarVisible(Boolean botonActualizarVisible) {
        this.botonActualizarVisible = botonActualizarVisible;
    }

}
