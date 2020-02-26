package com.ferrimatel.dao;

import com.ferrimatel.dto.Reporte;
import com.ferrimatel.modelo.Pedido;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless
public class PedidoDao extends Generico<Pedido> {

    public List<Reporte> obtenerReportePedidosDao() {
        try {
            List<Reporte> resultado;
            StringBuilder sql = new StringBuilder();
            sql.append("select ROW_NUMBER () OVER (ORDER BY p.fecha_pedido) as idpedido, p.fecha_pedido, c.nombre_cl, c.apellido_cl, pr.detalle_prod, pr.cantidad_prod"
                    + " from pedido p, cliente c, producto pr"
                    + " where p.id_pedido = c.id_cliente"
                    + " and p.id_cliente = pr.id_prod ");
            Query query;
            query = getEntityManager().createNativeQuery(sql.toString(), Reporte.class);
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
