
package com.emergentes.dao;

import com.emergentes.modelo.Venta;
import java.util.List;

public interface VentaDAO {
    public void insert(Venta venta) throws Exception;
    public void update(Venta venta) throws Exception;
    public void delete(int id) throws Exception;
    public Venta getById(int id) throws Exception;
    public List<Venta> getAll() throws Exception;
}
