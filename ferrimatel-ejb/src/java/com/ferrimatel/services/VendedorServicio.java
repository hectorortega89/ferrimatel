package com.ferrimatel.services;

import com.ferrimatel.dao.VendedorDao;
import com.ferrimatel.modelo.Vendedor;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

/**
 *
 * @author Hector
 */
@LocalBean
@Stateless
public class VendedorServicio {

    @EJB
    private VendedorDao vendedorDao;

    private Vendedor vendedor;

    public Vendedor buscarVendedorExisteServicio(String nombreV, String passV) {
        return vendedorDao.buscarVendedorExisteDao(nombreV, passV);
    }

}
