
package com.emergentes.dao;

import com.emergentes.modelo.Cliente;
import com.emergentes.utiles.ConexionDB;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAOimpl extends ConexionDB implements ClienteDAO {

    @Override
    public void insert(Cliente cliente) throws Exception {
        String sql = "insert into clientes (nombre,correo,celular) values (?,?,?)";
        this.conectar();
        PreparedStatement ps = this.conn.prepareStatement(sql);
        ps.setString(1, cliente.getNombre());
        ps.setString(2, cliente.getCorreo());
        ps.setString(3, cliente.getCelular());
        ps.executeUpdate();
        this.desconectar();
    }

    @Override
    public void update(Cliente cliente) throws Exception {
        String sql = "update clientes set nombre=?,correo=?,celular=? where id=?";
        this.conectar();
        PreparedStatement ps = this.conn.prepareStatement(sql);
        ps.setString(1, cliente.getNombre());
        ps.setString(2, cliente.getCorreo());
        ps.setString(3, cliente.getCelular());
        ps.setInt(4, cliente.getId());
        ps.executeUpdate();
        this.desconectar();
    }

    @Override
    public void delete(int id) throws Exception {
        String sql = "delete from clientes where id = ?";
        this.conectar();
        PreparedStatement ps = this.conn.prepareStatement(sql);
        ps.setInt(1, id);
        ps.executeUpdate();
    }

    @Override
    public Cliente getById(int id) throws Exception {
        Cliente cli = new Cliente();
        String sql = "select * from clientes where id = ?";
        this.conectar();
        PreparedStatement ps = this.conn.prepareStatement(sql);
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {            
            cli.setId(rs.getInt("id"));
            cli.setNombre(rs.getString("nombre"));
            cli.setCorreo(rs.getString("correo"));
            cli.setCelular(rs.getString("celular"));
        }
        this.desconectar();
        return cli;
    }

    @Override
    public List<Cliente> getAll() throws Exception {
        List<Cliente> lista = null;
        String sql = "select * from clientes";
        this.conectar();
        PreparedStatement ps = this.conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        lista = new ArrayList<Cliente>();
        while (rs.next()) {            
            Cliente cli = new Cliente();
            cli.setId(rs.getInt("id"));
            cli.setNombre(rs.getString("nombre"));
            cli.setCorreo(rs.getString("correo"));
            cli.setCelular(rs.getString("celular"));
            lista.add(cli);
        }
        this.desconectar();
        return lista;
    }
    
}
