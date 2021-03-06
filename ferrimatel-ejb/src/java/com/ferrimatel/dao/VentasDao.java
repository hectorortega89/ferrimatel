/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ferrimatel.dao;

import com.ferrimatel.dto.TotalVenta;
import com.ferrimatel.modelo.Ventas;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless
public class VentasDao extends Generico<Ventas> {

    public List<TotalVenta> obtenerVentaDao() {
        try {
            List<TotalVenta> resultado;
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT ROW_NUMBER () OVER (ORDER BY PR.CODIGO_PROD) AS id, PR.CODIGO_PROD AS codigoProd, PR.CANTIDAD_PROD as cantidadProd, PR.DETALLE_PROD as detalleProd, PR.PRECIO_PROD as puProd"
                    + " FROM PRODUCTO PR"
                    + " INNER JOIN PEDIDO P ON PR.ID_PROD=P.ID_PROD");
            Query query;
            query = getEntityManager().createNativeQuery(sql.toString(), TotalVenta.class);
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

    public VentasDao() {
        super(Ventas.class);
    }

}
