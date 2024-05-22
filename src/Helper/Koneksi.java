/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Helper;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author aldo1
 */
public class Koneksi {
    static Connection con;
    
    public static Connection getConnection(){
        if(con == null){
            MysqlDataSource data = new MysqlDataSource();
            data.setDatabaseName("db_gudang");
            data.setUser("root");
            data.setPassword("");
            try{
                con = data.getConnection();
                System.err.println("Konek");
            }
            catch(SQLException e){
                System.err.println("Tidak Konek");
            }
        }
        return con;
    }
   
   
}
    
