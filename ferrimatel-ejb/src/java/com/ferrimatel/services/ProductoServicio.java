package com.ferrimatel.services;

import com.ferrimatel.dao.ProductoDao;
import com.ferrimatel.modelo.Producto;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.faces.model.SelectItem;

@LocalBean
@Stateless
public class ProductoServicio {

    @EJB
    private ProductoDao productoDao;

    public Boolean guardarProducto(Producto producto) {
        Producto produ = productoDao.editEntity(producto);
        return produ != null;
    }

    public Producto buscarProductoPorDetalle(String detalle) {
        return productoDao.buscarProductoPorDetalleDao(detalle);
    }

    public void guardarProductoServicio(Producto producto) {
        productoDao.create(producto);
    }

    public boolean buscarProductoPorCodigo(String codigoProd) {
        return productoDao.buscarProductoPorCodigoDao(codigoProd);
    }

    public List<Producto> obtenerProductosActivos() {
        return productoDao.obtenerProductosActivosDao();
    }

    public List<SelectItem> obtenerListaItemProducto() {
        List<SelectItem> listaSelectItems = new ArrayList<>();
        List<Producto> listaProductos = productoDao.obtenerProductosActivosDao();
        if (listaProductos != null && !listaProductos.isEmpty()) {
            for (Producto producto : listaProductos) {
                listaSelectItems.add(new SelectItem(producto.getIdProd(), producto.getCodigoProd()));
            }
            return listaSelectItems;
        } else {
            return null;
        }

    }

    //RECIBE UN PARAMETRO DE TIPO PRODUCTO
    //VIENE DEL DAO OBTENERLISTAPRODUCTOSACTIVOSDAO
    //CREA UNA LISTA SELECTITEM, QUE ES UN ARRAY
    //SE CREA LA VARIABLE LISTAPRODUCTOS QUE GUARDA OBJETOPRODUCTO.METODO:OBTENERLISTAPRODUCTOSACTIVOSDAO QUE TIENE DE PARAMETRO UN PRODUCTO
    //
    public List<SelectItem> obtenerListaProductosActivos(Producto producto) {
        List<SelectItem> listaSelectItems = new ArrayList<>();
        List<Producto> listaProductos = productoDao.obtenerListaProductosActivosDao(producto);
        listaProductos.forEach((pro) -> {
            listaSelectItems.add(new SelectItem(pro.getIdProd(), pro.getDetalleProd()));
        });
        if (listaSelectItems != null && !listaSelectItems.isEmpty()) {
            return listaSelectItems;
        } else {
            return null;
        }
    }

}
