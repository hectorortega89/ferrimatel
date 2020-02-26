package com.ferrimatel.services;

import com.ferrimatel.dao.VentasDao;
import com.ferrimatel.dto.TotalVenta;
import com.ferrimatel.modelo.Ventas;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

@LocalBean
@Stateless
public class VentasServicio {

    @EJB
    VentasDao ventasDao;

    public List<TotalVenta> obtenerVenta() {
        return ventasDao.obtenerVentaDao();
    }

}
