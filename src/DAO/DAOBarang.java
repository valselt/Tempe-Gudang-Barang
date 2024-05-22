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

/**
 *
 * @author aldo1
 */
public class DAOBarang implements InterfaceDAOBarang {

    Connection con;

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

    // SQL Query
    String read = "select * from barang;";
}
