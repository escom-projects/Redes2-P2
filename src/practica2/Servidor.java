/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica2;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.SQLException;
import java.util.StringTokenizer;
import practica2.productos.Producto;

/**
 *
 * @author xcali
 */
public class Servidor {
	static ServerSocket server;
        static Socket client;
        public static void main(String[] args) throws SQLException, IOException{
            //Producto p = new Producto();
            
            /*try{
                ServerSocket s=new ServerSocket(2000);
                System.out.println("Servicio iniciado.... esperando clientes...");
                
                Socket cl=s.accept();
                // System.out.println("SI");
                System.out.println("-----Cliente conectado desde:"+cl.getInetAddress().getHostAddress()+": "+cl.getPort());
                
            }catch(Exception e){e.printStackTrace();}
            */
            try{
                server = new ServerSocket(4060);
                System.out.println("Servidor activo...");
                client = server.accept();
                System.out.println("Cliente conectado");
                ObjectInputStream ois = new ObjectInputStream( client.getInputStream() );
                Producto p = (Producto) ois.readObject();
                System.out.println("Conexion establecida con servidor");
                //Pronto... sdoc está pronto para ser usado no servidor...
                }catch( Exception e ){}
                finally{ 
                  //ois.close();
                  client.close();
               }
             
        }
}