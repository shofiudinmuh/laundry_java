/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package koneksi;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;


/**
 *
 * @author asus
 */
public class koneksi {
    private static Connection conn;
    public Statement cn;
    public static Connection getkoneksi()throws SQLException{
        try {
            if(conn==null){
            Class.forName("com.mysql.jdbc.Driver");
            conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/laundry_rpl","root","");
            }
        }catch(Exception e){
           JOptionPane.showMessageDialog(null,"koneksi gagal");
           System.out.println(e.getMessage());
        }
         return  conn;
        
    }
}

