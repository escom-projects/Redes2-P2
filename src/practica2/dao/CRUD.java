/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica2.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author xcali
 */
public class CRUD {
    private Conexion conexion = new Conexion();
    private Connection con;
    private Statement st;
    private ResultSet rs;
 
    public CRUD() {
        try{
            if((con = conexion.getConexionMYSQL())==null){
                System.out.println("Error con la conexion a la BD");
                return;
            }
            st = con.createStatement();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
 
    //Inserta una nueva pelicula en la Base de Datos
    public boolean insert(String nombre,float precio,String desc, int existencia){
        try {
            String query = "INSERT INTO productos ( Nombre, Precio, Descripcion, Existencia) VALUES('"+nombre+"','"+precio+"','"+desc+"','"+existencia+"');";
            st.executeUpdate(query);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
 
    //Devuelve el resultset con los datos de peliculas
    public ResultSet selectXtodas(){
        try {
            String query = "SELECT * FROM productos";
            rs = st.executeQuery(query);
            return rs;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
 
    //Devuelve el resultset con los datos de peliculas con select por genero
    public ResultSet selectXid(int id){
        try {
            String query = "SELECT * FROM productos WHERE ID = '"+id+"'";
            rs = st.executeQuery(query);
            return rs;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
 
    //Elimina la pelicula
    public boolean delete(int id){
        try {
            String query = "DELETE FROM producto WHERE id = '"+id+"'";
            st.executeUpdate(query);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
 
    //Actualiza los datos de la pelicula
    public boolean update(int id,String nombre,float precio,String desc,int existencia){
        try {
            String query = "UPDATE producto SET"
                    + " Nombre = '"+nombre+"',"
                    + " Precio = '"+precio+"',"
                    + " Descripcion = '"+desc+"',"
                    + " Existencia = '"+existencia+"' WHERE id = '"+id+"';";
            st.executeUpdate(query);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
   
}
