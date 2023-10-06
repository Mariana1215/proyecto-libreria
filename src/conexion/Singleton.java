/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author LENOVO
 */
public class Singleton {
    
    private static Singleton instancia;
    private Connection conn;
    
    private static final String DATABASE_URL = "jdbc:mariadb://localhost:3306/trabajo_final";
    private static final String USER = "root";
    private static final String PASSWORD = "";
    
    private Singleton(){
        try{
            Class.forName("org.mariadb.jdbc.Driver");
            conn = DriverManager.getConnection(DATABASE_URL, USER, PASSWORD);
        }catch(SQLException ex){
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Singleton.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static Singleton getInstancia(){
        if(instancia == null){
            instancia = new Singleton();
        }
        return instancia;
    }
    
    public Connection getConnection(){
        return conn;
    }
    
    public void closeConnection(){
        if(conn != null){
            try{
                conn.close();
            }catch (SQLException ex){
                ex.printStackTrace();
            }
        }
    }
}
