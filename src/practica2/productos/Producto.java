/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica2.productos;

import java.io.Serializable;
import java.util.Calendar;

/**
 *
 * @author xcali
 */
public class Producto implements Serializable{
    private String id;
    private String nombre;
    private String descripcion;
    private short existencias;
    private String foto;
    private float precio;
    private Calendar fechaOferta;
    private int oferta;
    
    public Producto(String id, String nombre, String descripcion, short existencias, String foto, float precio, Calendar fechaOferta, int oferta){
        this.id=id;
        this.nombre=nombre;
        this.descripcion=descripcion;
        this.existencias=existencias;
        this.foto=foto;
        this.precio=precio;
        this.fechaOferta=fechaOferta;
        this.oferta=oferta;
    }
    
    public Producto(){
        this("","","",(short)0,"",0.0f,Calendar.getInstance(),0);
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