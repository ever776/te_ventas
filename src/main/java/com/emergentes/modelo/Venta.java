
package com.emergentes.modelo;

import java.sql.Date;

public class Venta {
    private int id;
    private int producto_id;
    private int cliente_id;
    private Date fecha;
    private String producto;
    private String cliente;

    public Venta() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getProducto_id() {
        return producto_id;
    }

    public void setProducto_id(int producto_id) {
        this.producto_id = producto_id;
    }

    public int getCliente_id() {
        return cliente_id;
    }

    public void setCliente_id(int cliente_id) {
        this.cliente_id = cliente_id;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    @Override
    public String toString() {
        return "Venta{" + "id=" + id + ", producto_id=" + producto_id + ", cliente_id=" + cliente_id + ", fecha=" + fecha + ", producto=" + producto + ", cliente=" + cliente + '}';
    }
    
    
}
