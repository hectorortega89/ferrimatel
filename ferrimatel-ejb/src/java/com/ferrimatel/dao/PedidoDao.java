package com.ferrimatel.dao;

import com.ferrimatel.modelo.Pedido;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;


@Stateless
public class PedidoDao extends Generico<Pedido> {


    public List<Pedido> obtenerPedidosActivosDao() {
        try {
            List<Pedido> resultado = new ArrayList<>();
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT p FROM Pedido p WHERE p.flagPedido = :flagPedido");
            Query query;
            query = getEntityManager().createQuery(sql.toString()).setParameter("flagPedido", true);
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
    
    
    public PedidoDao() {
        super(Pedido.class);
    }
    
}
