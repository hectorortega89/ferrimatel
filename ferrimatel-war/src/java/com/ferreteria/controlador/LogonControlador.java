package com.ferreteria.controlador;

import com.ferrimatel.modelo.Vendedor;
import com.ferrimatel.services.VendedorServicio;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

@ManagedBean
@ViewScoped
public class LogonControlador {

    @EJB
    private VendedorServicio vendedorServicio;

    private Vendedor vendedor;

    @PostConstruct
    public void init() {

        setVendedor(new Vendedor());
        autenticar();
    }

    public void autenticar() {
        try {
            if (vendedor.getNombreVendedor() != null) {
                Vendedor vendedorExiste = vendedorServicio.buscarVendedorExisteServicio(vendedor.getNombreVendedor(), vendedor.getPassVendedor());
                if (vendedorExiste.getNombreVendedor() == vendedor.getNombreVendedor()) {
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "ACCESO CORRECTO"));
                } else {
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "USUARIO O CONTRASEÑA NO ENCONTRADOS"));
                }
            } else {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "INGRESE LOS DATOS DE LOGIN"));
            }
        } catch (Exception e) {
            e.getMessage();
        }

    }

    public VendedorServicio getVendedorServicio() {
        return vendedorServicio;
    }

    public void setVendedorServicio(VendedorServicio vendedorServicio) {
        this.vendedorServicio = vendedorServicio;
    }

    public Vendedor getVendedor() {
        return vendedor;
    }

    public void setVendedor(Vendedor vendedor) {
        this.vendedor = vendedor;
    }

}
