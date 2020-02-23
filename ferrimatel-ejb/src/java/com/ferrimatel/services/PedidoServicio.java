package com.ferrimatel.services;

import com.ferrimatel.dao.PedidoDao;
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
    
    
    public List<Pedido> obtenerPedidosActivos() {
        return pedidoDao.obtenerPedidosActivosDao();
    }
    
}
