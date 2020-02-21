package com.ferrimatel.services;

import com.ferrimatel.dao.VendedorDao;
import com.ferrimatel.modelo.Vendedor;
import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

/**
 *
 * @author Hector
 */
@LocalBean
@Stateless
public class VendedorServicio {
    private VendedorDao vendedorDao;
    private Vendedor vendedor;
    
    
    public List<Vendedor> obtenerNombresVendedorActivo(){
        return vendedorDao.obtenerNombresVendedorActivoDao();
    }
    
    public boolean validarVendedor(Vendedor vendedor){
        return vendedorDao.obtenerVendedorExisteDao(vendedor)!=null;
    }
    
    public Vendedor obtenerVendedorExiste(){
        return vendedorDao.obtenerVendedorExisteDao(vendedor);
    }
    
}
