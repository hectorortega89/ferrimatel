
package com.ferreteria.controlador;

import com.ferrimatel.modelo.Vendedor;
import com.ferrimatel.services.VendedorServicio;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
public class LogonControlador {
    
    @EJB
    private VendedorServicio vendedorServicio;
    
    private Vendedor vendedor;
    private String usuario;
    private String us;
    private String ps;
    private String password;
    
    public LogonControlador() {
    }
    
    
    @PostConstruct
    public void init(){
        
        
    }
    
    public String validarLogin(){
        us = vendedor.getNombreVendedor();
        ps = vendedor.getPassVendedor();
        boolean existeVendedor = vendedorServicio.validarVendedor(vendedor);
        if(existeVendedor){
            if(us != usuario && ps != password){
                return "ventas";
            }else{
                return null;
            }
            
    }
        return null;
    }
   
  
    
    
     public void cancelar(){
     
     }
        
    

    public Vendedor getVendedor() {
        return vendedor;
    }

    public void setVendedor(Vendedor vendedor) {
        this.vendedor = vendedor;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUs() {
        return us;
    }

    public void setUs(String us) {
        this.us = us;
    }

    public String getPs() {
        return ps;
    }

    public void setPs(String ps) {
        this.ps = ps;
    }
    
}
