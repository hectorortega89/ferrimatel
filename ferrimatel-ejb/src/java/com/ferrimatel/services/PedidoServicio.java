package com.ferrimatel.services;

import com.ferrimatel.dao.PedidoDao;
import com.ferrimatel.dao.ProductoDao;
import com.ferrimatel.dto.Reporte;
import com.ferrimatel.modelo.Pedido;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;


@LocalBean
@Stateless
public class PedidoServicio {
    
    @EJB
    private PedidoDao pedidoDao;
    
    @EJB
    private ProductoDao productoDao;

    public Boolean guardarPedidos(Pedido pedido) {
        Pedido ped = pedidoDao.editEntity(pedido);
        return ped != null;
    }
/*
    public List<Pedido> obtenerListaPedidosActivos() {
        return pedidoDao.obtenerPedidosActivosDao();
    }
*/
    public List<Reporte> obtenerReportePedidosLista() {
        return pedidoDao.obtenerReportePedidosDao();
    }

    
    //public List<Reporte> obtenerReporteDeProductos() {
    //    return pedidoDao.obtenerReportePedidosDao();
   // }

    public Pedido buscarPedidosPorId(Integer idPedido) {
        return pedidoDao.find(idPedido);
    }
    
    
    public List<Pedido> obtenerPedidosActivos() {
        return pedidoDao.obtenerPedidosActivosDao();
    }
    
}
