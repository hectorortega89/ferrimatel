/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ferrimatel.dao;

import com.ferrimatel.modelo.Producto;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Hector
 */
@Stateless
public class ProductoDao extends Generico<Producto> {

    @PersistenceContext(unitName = "ferrimatel-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ProductoDao() {
        super(Producto.class);
    }
    
}
