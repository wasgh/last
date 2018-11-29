/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author virtualali
 */
public class OracleConnection {
    
    public static Connection DBConnector(){
        
       Connection conn=null;
          
try {
   String dbURL = "jdbc:oracle:thin:@localhost:1521:orcl";
String username = "hr";
String password = "hr";
 
     conn = DriverManager.getConnection(dbURL, username, password);
    
    
} catch (SQLException ex) {
}
   
        return conn;
    }
    
}/*
String sql = "SELECT NAME FROM SKILLS";
        Statement statement = conn.createStatement();
        ResultSet result = statement.executeQuery(sql);
        while (result.next()){
            String name = result.getString("NAME");
            System.out.printf(name);
        }*/