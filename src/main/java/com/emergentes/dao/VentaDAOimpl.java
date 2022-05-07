
package com.emergentes.dao;

import com.emergentes.modelo.Venta;
import com.emergentes.utiles.ConexionDB;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class VentaDAOimpl extends ConexionDB implements VentaDAO {

    @Override
    public void insert(Venta venta) throws Exception {
        String sql = "insert into ventas (producto_id,cliente_id,fecha) values (?,?,?)";
        this.conectar();
        PreparedStatement ps = this.conn.prepareStatement(sql);
        ps.setInt(1, venta.getProducto_id());
        ps.setInt(2, venta.getCliente_id());
        ps.setDate(3, venta.getFecha());
        ps.executeUpdate();
        this.desconectar();
    }

    @Override
    public void update(Venta venta) throws Exception {
        String sql = "update ventas set producto_id=?,cliente_id=?,fecha=? where id=?";
        this.conectar();
        PreparedStatement ps = this.conn.prepareStatement(sql);
        ps.setInt(1, venta.getProducto_id());
        ps.setInt(2, venta.getCliente_id());
        ps.setDate(3, venta.getFecha());
        ps.setInt(4, venta.getId());
        ps.executeUpdate();
        this.desconectar();
    }

    @Override
    public void delete(int id) throws Exception {
        String sql = "delete from ventas where id = ?";
        this.conectar();
        PreparedStatement ps = this.conn.prepareStatement(sql);
        ps.setInt(1, id);
        ps.executeUpdate();
        this.desconectar();
    }

    @Override
    public Venta getById(int id) throws Exception {
        Venta ven = new Venta();
        String sql = "select * from ventas where id = ?";
        this.conectar();
        PreparedStatement ps = this.conn.prepareStatement(sql);
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {            
            ven.setId(rs.getInt("id"));
            ven.setProducto_id(rs.getInt("producto_id"));
            ven.setCliente_id(rs.getInt("cliente_id"));
            ven.setFecha(rs.getDate("fecha"));
        }
        this.desconectar();
        return ven;
    }

    @Override
    public List<Venta> getAll() throws Exception {
        List<Venta> list = null;
        String sql = "SELECT v.*,p.nombre as producto,c.nombre as cliente from ventas v ";
        sql += "left join productos p on v.producto_id = p.id ";
        sql += "left join clientes c on v.cliente_id = c.id";
        this.conectar();
        PreparedStatement ps = this.conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        list = new ArrayList<Venta>();
        while (rs.next()) {            
            Venta ven = new Venta();
            ven.setId(rs.getInt("id"));
            ven.setProducto_id(rs.getInt("producto_id"));
            ven.setCliente_id(rs.getInt("cliente_id"));
            ven.setFecha(rs.getDate("fecha"));
            ven.setCliente(rs.getString("cliente"));
            ven.setProducto(rs.getString("producto"));
            list.add(ven);
        }
        this.desconectar();
        return list;
    }
    
}
