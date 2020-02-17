package com.ferrimatel.services;

import com.ferrimatel.dao.ProductoDao;
import com.ferrimatel.modelo.Producto;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

@LocalBean
@Stateless
public class ProductoServicio {

    @EJB
    private ProductoDao productoDao;

    public Boolean guardarProducto(Producto producto) {
        Producto produ = productoDao.editEntity(producto);
        return produ != null;
    }

    public void guardarProductoServicio(Producto producto) {
        productoDao.create(producto);
    }

    public boolean buscarProductoPorDetalle(String producto) {
        return productoDao.buscarProductoPorDetalleDao(producto);
    }

    public List<Producto> obtenerProductosActivos() {
        return productoDao.obtenerProductosActivosDao();
    }
}
