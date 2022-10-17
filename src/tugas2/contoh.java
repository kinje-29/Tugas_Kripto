/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tugas2;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;
import java.sql.ResultSet;
import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author fajar
 */
public class contoh {
    public static void main(String[] args) {
        String nama, sandi;
        Scanner sc  = new Scanner(System.in);

        for(;;){            
            int input = Integer.parseInt(JOptionPane.showInputDialog("Tugas Vigener Chiper Login\n1.Login\n2.Registrasi\n3.Exin"
                    + "\nMasukan Pilihan"));
            Connection con = (Connection) Koneksi.getConnection();
            if(input == 1){
                PreparedStatement ps;
                ResultSet rs;
                String key = "bdg";
                String rss = "";
                String rss1 = "";
                int off, j =0, shif;
                nama = JOptionPane.showInputDialog("Masukan Email  " );
                sandi = JOptionPane.showInputDialog("Masukan Sandi  " );
                
                
                
                // Encrip
                for(int i = 0; i < nama.length(); i++){
                    shif = ((int) key.charAt(j)) - 97;
                    j++;
                    j %= key.length();
                    off = ((int) nama.charAt(i) + shif) % 256;
                    rss += (char) (off);
                }
                
                System.out.println("Email : " + rss);
                
                for(int i = 0; i < sandi.length(); i++){
                    shif = ((int) key.charAt(j)) - 97;
                    j++;
                    j %= key.length();
                    off = ((int) sandi.charAt(i) + shif) % 256;
                    rss1 += (char) (off);
                }
                System.out.println("Sandi : " + rss1);
                String sql = "select * from login where email = '"+ rss + "'and sandi = '"+rss1+"'";

                
                try {

                    Statement st = (Statement) con.createStatement();
                    rs = st.executeQuery(sql);
            
                    if(rs.next()){
                        
                        JOptionPane.showMessageDialog(null, "Berhasil Login"+"\nSelamat Datang Di Sistem Login" + JOptionPane.ICON_PROPERTY);
                        System.out.println("Login");
                    } else {
                        System.out.println("Gagal");
                        JOptionPane.showMessageDialog(null, "Gagal Login");
                        
                    }
                    
                } catch (Exception e) {

                }
                
                
            } else if(input == 2){
                PreparedStatement ps;
                ResultSet rs;
                String key = "bdg";
                String rss = "";
                String rss1 = "";
                int off, j =0, shif;
                nama = JOptionPane.showInputDialog("Masukan Email " + "\nKey : "+key);
                sandi = JOptionPane.showInputDialog("Masukan Sandi " + "\nKey : "+key);
                
                // Encrip
                for(int i = 0; i < nama.length(); i++){
                    shif = ((int) key.charAt(j)) - 97;
                    j++;
                    j %= key.length();
                    off = ((int) nama.charAt(i) + shif) % 256;
                    rss += (char) (off);
                }
                
                System.out.println("Email : " + rss);
                
                for(int i = 0; i < sandi.length(); i++){
                    shif = ((int) key.charAt(j)) - 97;
                    j++;
                    j %= key.length();
                    off = ((int) sandi.charAt(i) + shif) % 256;
                    rss1 += (char) (off);
                }
                System.out.println("Sandi : " + rss1);
                
                try {
                    // SQL
                String sql = "INSERT INTO login(email, sandi)values"
                        +"('"+rss
                        +"','" + rss1 + "')";
                
                ps = (PreparedStatement) Koneksi.getConnection().prepareStatement(sql);
                ps.executeUpdate(sql);
                System.out.println("Data Berhasil Di simpan");
                
                } catch (Exception e) {
                }
                
                
            } else if(input == 3){
                System.exit(0);
            }
            
        }
        

        
    }
       
    
}
