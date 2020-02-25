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

       
    
    public List<Vendedor> obtenerListaVendedorExisteDao() {
        try {
            List<Vendedor> resultado = new ArrayList<>();
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT v FROM Vendedor v WHERE v.flagVendedor = :flagVendedor");
            Query query;
            query = getEntityManager().createQuery(sql.toString()).setParameter("flagVendedor", true);
            resultado = query.getResultList();
            if (!resultado.isEmpty()) {    
                    return resultado;
            } else {
                return null;
            }
        } catch (Exception e) {
            return null;
        }

    }      

    public Vendedor obtenerVendedorExisteDao(String nombreV, String passV) {
        try {
            Vendedor resultado = new Vendedor();
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT v FROM Vendedor v WHERE v.nombreVendedor =:nombreVendedor AND v.passVendedor =:passVendedor");
            Query query;
            query = getEntityManager().createQuery(sql.toString()).setParameter("nombreVendedor", nombreV).setParameter("passVendedor", passV);
            resultado = (Vendedor) query.getResultList();
            if (resultado != null) {
                return resultado;
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
