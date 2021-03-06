package com.ferreteria.controlador;

import com.ferreteria.utilitarios.Utilitarios;
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
public class LogonControlador extends Utilitarios {

    @EJB
    private VendedorServicio vendedorServicio;

    private Vendedor vendedor;
    private List<Vendedor> listaVendedor;
    private List<VendedorServicio> listaVendedorServicio;

    @PostConstruct
    public void init() {
        setVendedor(new Vendedor());
        this.setListaVendedor(vendedorServicio.obtenerListaVendedorExiste());

    }

    public void autenticar() {
        try {
            if (vendedor.getNombreVendedor() != null) {
                List<Vendedor> vendedorExiste = listaVendedor;
                for (Vendedor datos : vendedorExiste) {
                    if (datos.getNombreVendedor().equals(vendedor.getNombreVendedor()) && datos.getPassVendedor().equals(vendedor.getPassVendedor())) {
                        redirect("/pages/ventas.jsf");
                    }
                }
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "INGRESE EL USUARIO Y CONTRASEÑA CORRECTA"));
            }

        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "INGRESE LOS DATOS DE LOGIN"));
        }

    }

    public VendedorServicio getVendedorServicio() {
        return vendedorServicio;
    }

    public void setVendedorServicio(VendedorServicio vendedorServicio) {
        this.vendedorServicio = vendedorServicio;
    }

    public List<VendedorServicio> getListaVendedorServicio() {
        return listaVendedorServicio;
    }

    public void setListaVendedorServicio(List<VendedorServicio> listaVendedorServicio) {
        this.listaVendedorServicio = listaVendedorServicio;
    }

    public List<Vendedor> getListaVendedor() {
        return listaVendedor;
    }

    public void setListaVendedor(List<Vendedor> listaVendedor) {
        this.listaVendedor = listaVendedor;
    }

    public Vendedor getVendedor() {
        return vendedor;
    }

    public void setVendedor(Vendedor vendedor) {
        this.vendedor = vendedor;
    }

}
