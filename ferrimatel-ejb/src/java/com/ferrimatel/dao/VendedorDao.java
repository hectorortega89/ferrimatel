/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ferrimatel.dao;

import com.ferrimatel.modelo.Vendedor;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless
public class VendedorDao extends Generico<Vendedor> {

    public List<Vendedor> obtenerNombresVendedorActivoDao() {
        try {
            List<Vendedor> resultado = new ArrayList<>();
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT v FROM Vendedor v WHERE v.nombreVendedor = ? AND v.passVendedor = ?");
            Query query;
            query = getEntityManager().createQuery(sql.toString()).setParameter("nombreVendedor", true);
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
    
     public Vendedor obtenerVendedorExisteDao(Vendedor vendedor) {
        try {
            List<Vendedor> resultado = new ArrayList<>();
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT v FROM Vendedor v WHERE v.nombreVendedor =:nombreVendedor AND v.passVendedor =:passVendedor");
            Query query;
            query = getEntityManager().createQuery(sql.toString()).setParameter("nombreVendedor", vendedor.getNombreVendedor()).setParameter("passVendedor", vendedor.getPassVendedor());
            resultado = (List<Vendedor>) query.getSingleResult();
            if (resultado != null && !resultado.isEmpty()) {
                return (Vendedor) resultado;
            } else {
                return null;
            }
        } catch (Exception e) {
            return null;
        }

    }
    

    public VendedorDao() {
        super(Vendedor.class);
    }

}
