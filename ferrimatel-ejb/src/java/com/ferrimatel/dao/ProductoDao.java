package com.ferrimatel.dao;

import com.ferrimatel.modelo.Producto;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.faces.model.SelectItem;
import javax.persistence.Query;

@Stateless
public class ProductoDao extends Generico<Producto> {

    
    public Producto buscarProductoPorDetalleDao(String detalle) {
        try {
            List<Producto> resultado = new ArrayList<>();
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT p FROM Producto p WHERE p.detalleProd = :detalleProd");
            Query query;
            query = getEntityManager().createQuery(sql.toString()).setParameter("detalleProd", detalle);
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
    
    /*
    public List<Producto> obtenerProductoPorDetalleDao(Producto detalle){
        try {
            List<Producto> resultado = new ArrayList<>();
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT p FROM Producto p WHERE p.detalleProd = :detalleProd");
            Query query;
            query = getEntityManager().createQuery(sql.toString()).setParameter("detalleProd", detalle);
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
       */     
    /*
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
    }*/

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

    
    //RECIBE UN PARAMETRO DE TIPO PRODUCTO
    //OBTENGO UNA LISTA DE PRODUCTOS ACTIVOS CONSULTANDO EL ID Y LA BANDERA EN ESTADO TRUE
    //SI EXISTE EL IDPROD Y EL ESTADO ES TRUE, REGRESA UN RESULTADO
    //RESULTADO SE VA A OBTENERLISTAPRODUCTOSACTIVOS
    public List<Producto> obtenerListaProductosActivosDao(Producto producto) {
        try {
            List<Producto> resultado;
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT p FROM Producto p WHERE p.idProd = ").append(producto.getIdProd()).append(" AND p.flagProd = TRUE");
            Query query;
            query = getEntityManager().createNativeQuery(sql.toString(), Producto.class);
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
