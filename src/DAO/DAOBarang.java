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
            System.out.println("Error Menampilkan dan Menghubungkan Data!");  // Added this line for error handling
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
            System.out.println("Gagal Update Data!");
        }
        finally{
            try {
                statement.close();
            } catch (SQLException ex) {
                System.out.println("Gagal Update Data!");
            }
        }
    }
    
    @Override
    public void stokAdd(Barang brg){
        PreparedStatement statement = null;
        try {
            statement = con.prepareStatement(stokAdd);
            statement.setInt(1, brg.getStokSementara());
            statement.setString(2, brg.getNamaBarang());
            statement.executeUpdate(); // Gunakan executeUpdate untuk perintah yang mengubah data
        }
        catch(SQLException e){
            System.out.println("Gagal Menambahkan Stok!");
            e.printStackTrace(); // Print stack trace untuk melihat detail error
        }
        finally{
            // Tutup statement di blok finally
            try {
                if(statement != null) {
                    statement.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    @Override
    public void stokReduce(Barang brg){
        PreparedStatement statement = null;
        try {
            statement = con.prepareStatement(stokReduce);
            statement.setInt(1, brg.getStokSementara());
            statement.setString(2, brg.getNamaBarang());
            statement.executeUpdate(); // Gunakan executeUpdate untuk perintah yang mengubah data
        }
        catch(SQLException e){
            System.out.println("Gagal Mengurangi Stok!");
            e.printStackTrace(); // Print stack trace untuk melihat detail error
        }
        finally{
            // Tutup statement di blok finally
            try {
                if(statement != null) {
                    statement.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    
    @Override
    public void deleteDelete(Barang brg) {
        PreparedStatement statement = null;
        try {
            statement = con.prepareStatement(deleteDelete);
            statement.setString(1, brg.getKodeBarang());
            statement.execute();
        }
        catch(SQLException e){
            System.out.println("Gagal Delete Data!");
        }
        finally{
            try {
                statement.close();
            } catch (SQLException ex) {
                System.out.println("Gagal Delete Data!");
            }
        }
    }
    
    public List<String> getDaftarKodeBarang() {
        List<String> daftarKodeBarang = new ArrayList<>();
        try {
            
            PreparedStatement statement = con.prepareStatement(listKodeBarang);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                String kodeBarang = resultSet.getString("kode_barang");
                daftarKodeBarang.add(kodeBarang);
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
        return daftarKodeBarang;
    }
    
    public List<String> getDaftarNamaBarang() {
        List<String> daftarNamaBarang = new ArrayList<>();
        try {
            
            PreparedStatement statement = con.prepareStatement(listNamaBarang);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                String namaBarang = resultSet.getString("nama_barang");
                daftarNamaBarang.add(namaBarang);
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
        return daftarNamaBarang;
    }
    
    @Override
    public boolean verifyLogin(String username, String password) {
        
        
        try (PreparedStatement preparedStatement = con.prepareStatement(login)) {
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            ResultSet resultSet = preparedStatement.executeQuery();
            return resultSet.next(); // returns true if a match is found
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    
  
    
    Connection con;

    // SQL Query
    String login = "SELECT * FROM user WHERE id_pengguna = ? AND password = ?;";
    String read = "select * from barang;";
    String insert = "insert into barang(kode_barang, nama_barang, satuan, harga, stok) values (?, ?, ?, ?, ?);";
    String updateSelect = "update barang set nama_barang=?, satuan=?, harga=?, stok=? where kode_barang=?;";
    String deleteDelete = "delete from barang where kode_barang=?;";
    String listKodeBarang = "select kode_barang FROM barang;";
    String listNamaBarang = "select nama_barang FROM barang;";
    String stokAdd = "update barang set stok=stok+? where nama_barang=?;";
    String stokReduce = "update barang set stok=stok-? where nama_barang=?;";
    

    
}
