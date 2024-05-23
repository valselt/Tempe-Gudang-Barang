package DAO;

import Helper.Koneksi;
import Model.Barang;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;
import DAOInterface.InterfaceDAOBarang;
import java.sql.PreparedStatement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author aldo1
 */
public class DAOBarang implements InterfaceDAOBarang {

    public DAOBarang() {
        con = Koneksi.getConnection();
    }

    @Override
    public List<Barang> getAll() {
        List<Barang> lstBarang = null;
        try {
            lstBarang = new ArrayList<Barang>();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(read);  // Corrected this line
            while (rs.next()) {
                Barang brg = new Barang();
                brg.setKodeBarang(rs.getString("kode_barang"));
                brg.setNamaBarang(rs.getString("nama_barang"));
                brg.setSatuan(rs.getString("satuan"));
                brg.setHarga(rs.getInt("harga"));  // Corrected this line
                brg.setStok(rs.getInt("stok"));
                lstBarang.add(brg);  // Added this line to add the object to the list
            }

        } catch (SQLException e) {
            System.out.println("error");  // Added this line for error handling
        }
        return lstBarang;
    }

    @Override
    public void insert(Barang brg) {
        PreparedStatement statement = null;
        try {
            statement = con.prepareStatement(insert);
            statement.setString(1, brg.getKodeBarang());
            statement.setString(2, brg.getNamaBarang());
            statement.setString(3, brg.getSatuan());
            statement.setInt(4, brg.getHarga());
            statement.setInt(5, brg.getStok());
            statement.execute();
        }
        catch(SQLException e){
            System.out.println("Gagal Menginput Data!");
        }
        finally{
            try {
                statement.close();
            } catch (SQLException ex) {
                System.out.println("Gagal Menginput Data!");
            }
        }
    }
    @Override
    public void updateSelect(Barang brg) {
        PreparedStatement statement = null;
        try {
            statement = con.prepareStatement(updateSelect);
            
            statement.setString(1, brg.getNamaBarang());
            statement.setString(2, brg.getSatuan());
            statement.setInt(3, brg.getHarga());
            statement.setInt(4, brg.getStok());
            statement.setString(5, brg.getKodeBarang());
            statement.execute();
        }
        catch(SQLException e){
            System.out.println("Gagal Updatet Data!");
        }
        finally{
            try {
                statement.close();
            } catch (SQLException ex) {
                System.out.println("Gagal Update Data!");
            }
        }
    }
   
    
    Connection con;

    // SQL Query
    String read = "select * from barang;";
    String insert = "insert into barang(kode_barang, nama_barang, satuan, harga, stok) values (?, ?, ?, ?, ?);";
    String updateSelect = "update barang set nama_barang=?, satuan=?, harga=?, stok=? where kode_barang=?;";

    
}
