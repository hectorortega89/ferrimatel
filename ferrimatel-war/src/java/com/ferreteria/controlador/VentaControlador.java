package com.ferreteria.controlador;

import com.ferrimatel.modelo.Cliente;
import com.ferrimatel.modelo.Producto;
import com.ferrimatel.services.ClienteServicio;
import com.ferrimatel.services.ProductoServicio;
import com.ferrimatel.services.VentasServicio;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.model.SelectItem;

@ManagedBean
@ViewScoped
public class VentaControlador {

    @EJB
    private ClienteServicio clienteServicio;

    @EJB 
    private VentasServicio ventasServicio;
    
    @EJB
    private ProductoServicio productoServicio;
    
    
    Cliente cliente;
    private List<SelectItem> listaProductoActivo;
    

    public void init(){
        cliente = new Cliente();
        
    }


    
}
