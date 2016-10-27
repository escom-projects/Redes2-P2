/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica2.productos;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import practica2.dao.CRUD;

/**
 *
 * @author xcali
 */
public class Producto implements Serializable{
    private String id;
    private String nombre;
    private String descripcion;
    private int existencias;
    private String foto;
    private float precio;
    CRUD c = new CRUD();
    
    public Producto(String id, String nombre, String descripcion, short existencias, String foto, float precio, Calendar fechaOferta, int oferta){
        
        this.id=id;
        this.nombre=nombre;
        this.descripcion=descripcion;
        this.existencias=existencias;
        this.foto=foto;
        this.precio=precio;
    }
    
    public Producto() throws SQLException{
        ResultSet rs = c.selectXid(1);
        while (rs.next())
            {
                //this.id = rs.getInt("ID");
                this.nombre = rs.getString(2);
                this.descripcion = rs.getString(3);
            }
        //System.out.println("Id: 1, nombre: "+this.nombre+", desc: "+this.descripcion);
    }
    
    public void comprar(int numeroProductos){
        if(existencias-numeroProductos<0){return;}
        existencias-=numeroProductos;
        
    }
    
    public void agregar(int numeroProductos){
        existencias+=numeroProductos;
    }
    
    public String getFoto(){
        return foto;
    }
    
    public String toString(){
        return "\nNombre: "+nombre+"\nExistencias: "+existencias;
    }
}