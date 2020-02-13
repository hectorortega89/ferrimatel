
package com.ferreteria.controlador;

import com.ferrimatel.modelo.Producto;
import com.ferrimatel.services.ProductoServicio;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;



@ManagedBean
@ViewScoped
public class productoControlador {
    
    @EJB
    private ProductoServicio productoServicio;
        
    private Producto producto;
    
    @PostConstruct
    public void init(){
        producto = new Producto();
    
    }
    
    public void guardarProducto(){
    //this.producto.setDescripcionProd(producto);
    
    
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }
    
}
