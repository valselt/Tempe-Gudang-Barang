package DAO;

import DAOInterface.IDAOBarang;
import Helper.Koneksi;
import Model.ModelBarang;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;

/**
 *
 * @author aldo1
 */
public class DAOBarang implements IDAOBarang {

    Connection con;

    public DAOBarang() {
        con = Koneksi.getConnection();
    }

    @Override
    public List<ModelBarang> getAll() {
        List<ModelBarang> lstBarang = null;
        try {
            lstBarang = new ArrayList<ModelBarang>();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(read);  // Corrected this line
            while (rs.next()) {
                ModelBarang brg = new ModelBarang();
                brg.setKodeBarang(rs.getString("kode_barang"));
                brg.setNamaBarang(rs.getString("nama_barang"));
                brg.setSatuan(rs.getString("satuan"));
                brg.setHarga(rs.getInt("harga"));  // Corrected this line
                brg.setStok(rs.getInt("stok"));
                lstBarang.add(brg);  // Added this line to add the object to the list
            }

        } catch (SQLException e) {
            e.printStackTrace();  // Added this line for error handling
        }
        return lstBarang;
    }

    // SQL Query
    String read = "select * from barang;";
}
