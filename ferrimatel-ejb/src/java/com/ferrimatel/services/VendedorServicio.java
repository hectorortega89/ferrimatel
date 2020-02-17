/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
    
    
    public List<Vendedor> obtenerNombresVendedorActivo(){
        return vendedorDao.obtenerNombresVendedorActivoDao();
    }

    
    
}
