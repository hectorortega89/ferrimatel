package com.ferrimatel.services;

import com.ferrimatel.dao.ClienteDao;
import com.ferrimatel.modelo.Cliente;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

@LocalBean
@Stateless
public class ClienteServicio {

    @EJB
    private ClienteDao clienteDao;

    public Cliente obtenerListaClientesPorCedula(String cedula) {
        return clienteDao.obtenerListaClientesPorCedulaDao(cedula);
    }

    public List<Cliente> obtenerListaClientesActivos() {
        return clienteDao.obtenerCategoriasActivasDao();
    }
    
    public Cliente guardarCliente(Cliente cliente) {
        return clienteDao.editEntity(cliente);
    }

    public Cliente buscarClientePorCedula(String cedula) {
        return clienteDao.buscarClientePorCedulaDao(cedula);
    }

}
