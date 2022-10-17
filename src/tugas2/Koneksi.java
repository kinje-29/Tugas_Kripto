/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tugas2;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import static java.lang.Class.forName;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;
/**
 *
 * @author fajar
 */
public class Koneksi {
    public static java.sql.Connection getConnection(){
        java.sql.Connection con = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/vegenere_chiper","root","");
        } catch (Exception e) {
            System.out.print("Koneksi Database gagal"+e.getMessage());
        }
    return con;
    }
}
