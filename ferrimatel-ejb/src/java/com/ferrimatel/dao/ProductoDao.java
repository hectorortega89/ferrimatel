/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ferrimatel.dao;

import com.ferrimatel.modelo.Producto;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless
public class ProductoDao extends Generico<Producto> {

    @PersistenceContext(unitName = "ferrimatel-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public boolean buscarProductoPorDetalleDao(String detalleProducto) {

        try {
            List<Producto> listaProducto = new ArrayList<>();
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT p FROM Producto p WHERE p.detalleProd = :detalleProd");
            Query nuevaQuery;
            nuevaQuery = getEntityManager().createQuery(sql.toString()).setParameter("detalle_prod", detalleProducto); //EL NOMBRE DE LA VARIABLE ES EL PARAMETRO QUE SE RECIBE
            listaProducto = nuevaQuery.getResultList();
            if (listaProducto != null && !listaProducto.isEmpty()) {
                return true;
            } else {
                return false;
            }

        } catch (Exception e) {
            return false;
        }
    }

    public List<Producto> obtenerProductosActivosDao() {
        try {
            List<Producto> resultado = new ArrayList<>();
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT p FROM Producto p WHERE p.flagProd = :flagProd");
            Query query;
            query = getEntityManager().createQuery(sql.toString()).setParameter("flagProd", true);
            resultado = query.getResultList();
            if (resultado != null && !resultado.isEmpty()) {
                return resultado;
            } else {
                return null;
            }
        } catch (Exception e) {
            return null;
        }
    }

    public ProductoDao() {
        super(Producto.class);
    }

}
