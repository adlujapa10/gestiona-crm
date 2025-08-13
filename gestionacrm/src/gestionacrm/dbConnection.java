/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestionacrm;
import java.sql.*;
/**
 *
 * @author Lucia
 */
public class dbConnection {
    static String url="jdbc:mysql://localhost:3306/crm";
    static String user="root";
    static String pass="12345678";
    
    public static Connection conectar()
    {
        Connection con=null;
        try
            {
                con=DriverManager.getConnection(url,user,pass);
                    System.out.println("Conexion exitosa");
            }catch(SQLException e)
            {
                e.printStackTrace();
                    System.out.println("Error de conexion");
            }
        
            return con;
        
    }
    
    
}
