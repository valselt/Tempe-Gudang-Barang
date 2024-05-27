/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Helper.Koneksi;
import Model.Histori;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;
import DAOInterface.InterfaceDAOHistori;
import java.sql.PreparedStatement;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author aldo1
 */
public class DAOHistori implements InterfaceDAOHistori{
    public DAOHistori() {
        con = Koneksi.getConnection();
    }
    public List<Histori> getAll() {
        List<Histori> lstHistori = null;
        try {
            lstHistori = new ArrayList<Histori>();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(read); 
            while (rs.next()) {
                Histori hstr = new Histori();
                hstr.setKodeHistori(rs.getString("kode_histori"));
                hstr.setKodeBarang(rs.getString("kode_barang"));
                hstr.setStatus(rs.getString("status"));
                hstr.setBanyak(rs.getString("banyak"));
                hstr.setIdPengguna(rs.getString("id_pengguna"));
                
                lstHistori.add(hstr);  // Added this line to add the object to the list
            }

        } catch (SQLException e) {
            System.out.println("Error Menampilkan dan Menghubungkan Data!");  // Added this line for error handling
        }
        return lstHistori;
        
    }
    
    
    public String getLastKodeHistori(){
                
        try{
            PreparedStatement statement = con.prepareStatement(lastKodeHistori);
            ResultSet rs = statement.executeQuery();
            
            if (rs.next()) {
                String kodeLama = rs.getString("kode_histori");
                return kodeLama;
            } else {
                System.out.println("Error Mengambil Kode Histori Terakhir!(ELSE)");
                return null;
            }
        }catch(SQLException e){
            System.out.println("Error Mengambil Kode Histori Terakhir!(CATCH)");
            return null;
        }
    }
    
    @Override
    public void histori(Histori hstr){
        PreparedStatement statement = null;
        try {
            statement = con.prepareStatement(histori);
            
            statement.setString(1, hstr.getKodeHistoriBaru());
            System.out.println("Kode Histori : "+ hstr.getKodeHistoriBaru());
            statement.setString(2, hstr.getKodeBarang());
            System.out.println("Kode Barang : "+ hstr.getKodeBarang());
            statement.setString(3, hstr.getStatus());
            System.out.println("Status : "+ hstr.getStatus());
            statement.setString(4, hstr.getBanyak());
            System.out.println("Banyak : "+ hstr.getBanyak());
            statement.setString(5, hstr.getIdPengguna());
            System.out.println("ID : "+ hstr.getIdPengguna());
            statement.execute();
        }
        catch(SQLException e){
            System.out.println("Gagal Update Histori(CATCH)!");
        }
        finally{
            try {
                statement.close();
            } catch (SQLException ex) {
                System.out.println("Gagal Update Histori(FINALLY)!");
            }
        }
    }
    
    Connection con;

    // SQL Query
    String read = "select * from histori;";
    String lastKodeHistori = "SELECT kode_histori FROM histori ORDER BY kode_histori DESC LIMIT 1;;";
    String histori = "insert into histori(kode_histori, kode_barang, status, banyak, id_pengguna) values (?, ?, ?, ?, ?);";
    
}
