package com.ferreteria.controlador;

import com.ferrimatel.modelo.Cliente;
import com.ferrimatel.services.ClienteServicio;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

@ManagedBean
@ViewScoped
public class ClienteControlador {

    @EJB
    private ClienteServicio clienteServicio;

    private Cliente cliente;
    private List<Cliente> listaClientesActivos;

    @PostConstruct
    public void init() {
        cliente = new Cliente();
        listaClientesActivos = clienteServicio.obtenerListaClientesActivos();
        setCliente(new Cliente());

    }

    public void buscarCliente() {
        try {
            if (cliente.getCedulaCl() != null) {
                Cliente usuarioExiste = clienteServicio.buscarClientePorCedula(cliente.getCedulaCl());
                if (usuarioExiste != null) {
                    cliente = usuarioExiste;
                    //setBotonActualizarVisible(true);
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "El cliente ya existe puede modificarlo."));
                } else {
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "El cliente no existe puede registralo."));
                }
                //setCamposHabilitados(true);
            } else {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Verifique la cantidad de dìgitos del número de documento."));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public void guardarCliente() {
        try {
            if (cliente != null) {
                cliente.setFlagCl(true);
                Cliente clienteExiste = clienteServicio.buscarClientePorCedula(cliente.getCedulaCl());
                Cliente clienteGuardado = null;
                if (clienteExiste != null) {
                    getCliente().setIdCliente(clienteExiste.getIdCliente());
                }
                clienteGuardado = clienteServicio.guardarCliente(getCliente());
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "El registro ha sido almacenado exitosamente."));
                init();
            }

        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "El registro no ha sido registrado."));
        }

    }

    public ClienteServicio getClienteServicio() {
        return clienteServicio;
    }

    public void setClienteServicio(ClienteServicio clienteServicio) {
        this.clienteServicio = clienteServicio;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<Cliente> getListaClientesActivos() {
        return listaClientesActivos;
    }

    public void setListaClientesActivos(List<Cliente> listaClientesActivos) {
        this.listaClientesActivos = listaClientesActivos;
    }

}
