package com.ferrimatel.dao;

import com.ferrimatel.modelo.Cliente;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Hector
 */
@Stateless
public class ClienteDao extends Generico<Cliente> {

    public Cliente obtenerListaClientesPorCedulaDao(String cedula) {
        try {
            List<Cliente> resultado = new ArrayList<>();
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT c FROM Cliente c WHERE c.cedulaCl = :cedulaCl");
            Query query;
            query = getEntityManager().createQuery(sql.toString()).setParameter("cedulaCl", cedula);
            resultado = query.getResultList();
            if (resultado != null && !resultado.isEmpty()) {
                return resultado.get(0);
            } else {
                return null;
            }
        } catch (Exception e) {
            return null;
        }
    }

    public List<Cliente> obtenerCategoriasActivasDao() {
        try {
            List<Cliente> resultado = new ArrayList<>();
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT c FROM Cliente c WHERE c.flagCl = :flagCl");
            Query query;
            query = getEntityManager().createQuery(sql.toString()).setParameter("flagCl", true);
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

    public Cliente buscarClientePorCedulaDao(String cedula) {
        try {
            List<Cliente> resultado = new ArrayList<>();
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT c FROM Cliente c WHERE c.cedulaCl = :cedulaCl");
            Query query;
            query = getEntityManager().createQuery(sql.toString()).setParameter("cedulaCl", cedula);
            resultado = query.getResultList();
            if (resultado != null && !resultado.isEmpty()) {
                return resultado.get(0);
            } else {
                return null;
            }
        } catch (Exception e) {
            return null;
        }
    }

    public ClienteDao() {
        super(Cliente.class);
    }

}
