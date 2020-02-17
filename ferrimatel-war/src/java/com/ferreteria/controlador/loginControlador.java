package com.ferreteria.controlador;

import com.ferrimatel.modelo.Vendedor;
import java.util.ArrayList;
import java.util.List;
import javax.faces.view.ViewScoped;
import javax.inject.Named;


public class loginControlador {

    private Vendedor vendedor;
    private String usuario;
    private String pass;

    public loginControlador(Vendedor vendedor, String usuario, String pass) {
        this.vendedor = vendedor;
        this.usuario = usuario;
        this.pass = pass;
    }

    public loginControlador() {
    }

    public Boolean validarLogin(){
        return null;
    /*if(vendedor.getPassVendedor() == ){
        
    }else{
        
    }
    }
    */
    
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

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

}
