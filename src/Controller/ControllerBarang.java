/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import DAO.DAOBarang;
import DAOInterface.InterfaceDAOBarang;
import Model.Barang;
import Model.TabelModelBarang;
import View.FormDelete;
import View.FormInsert;
import View.FormLogin;
import View.FormMenu;
import View.FormSelectAndUpdate;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

/**
 *
 * @author aldo1
 */
public class ControllerBarang {
    
    public ControllerBarang(FormLogin frmLogin) {
        this.frmLogin = frmLogin;
        ifaceBarang = new DAOBarang();
    }
    
    public ControllerBarang(FormMenu frmMenu){
        this.frmMenu = frmMenu;
        ifaceBarang = new DAOBarang(); 
    }
    
    public ControllerBarang(FormSelectAndUpdate frmSelect){
        this.frmSelect = frmSelect;
        ifaceBarang = new DAOBarang(); 
    }
    
    public ControllerBarang(FormInsert frmInsert){
        this.frmInsert = frmInsert;
        ifaceBarang = new DAOBarang(); 
    }
    public ControllerBarang(FormDelete frmDelete){
        this.frmDelete = frmDelete;
        ifaceBarang = new DAOBarang(); 
    }
    
    public boolean verifyLogin(String username, String password) {
        return ifaceBarang.verifyLogin(username, password);
    }
    
    public void isiTable(){
        lstBarang = ifaceBarang.getAll();
        TabelModelBarang tabelBarang = new TabelModelBarang(lstBarang);
        frmMenu.getTabelData().setModel(tabelBarang);
    }
    
    public void isiTableSelect(){
        lstBarang = ifaceBarang.getAll();
        TabelModelBarang tabelBarang = new TabelModelBarang(lstBarang);
        frmSelect.getTabelData().setModel(tabelBarang);
    }
    
    public void resetSelect(){
        frmSelect.getFieldKodeBarang().setText("");
        frmSelect.getFieldNamaBarang().setText("");
        frmSelect.getFieldSatuan().setText("");
        frmSelect.getFieldHarga().setText("");
        frmSelect.getFieldStok().setText("");
        
    }
    
    public void insert(){
        
        Barang brg = new Barang();
        
        brg.setKodeBarang(frmInsert.getFieldKodeBarang().getText());
        brg.setNamaBarang(frmInsert.getFieldNamaBarang().getText());
        brg.setSatuan(frmInsert.getFieldSatuan().getText());
        brg.setHarga(Integer.parseInt(frmInsert.getFieldHarga().getText()));
        brg.setStok(Integer.parseInt(frmInsert.getFieldStok().getText()));
        ifaceBarang.insert(brg);
        JOptionPane.showMessageDialog(null, "Data Berhasil Dimasukkan kedalam Database!");
    }
    
    public void isiFieldSelect (int row){
        frmSelect.getFieldKodeBarang().setEnabled(false);
        frmSelect.getFieldKodeBarang().setText(lstBarang.get(row).getKodeBarang());
        frmSelect.getFieldNamaBarang().setText(lstBarang.get(row).getNamaBarang());
        frmSelect.getFieldSatuan().setText(lstBarang.get(row).getSatuan());
        frmSelect.getFieldHarga().setText(lstBarang.get(row).getHarga().toString());
        frmSelect.getFieldStok().setText(lstBarang.get(row).getStok().toString());
    }    
    
    public void updateSelect(){
        
        Barang brg = new Barang();
        
        brg.setNamaBarang(frmSelect.getFieldNamaBarang().getText());
        brg.setSatuan(frmSelect.getFieldSatuan().getText());
        brg.setHarga(Integer.parseInt(frmSelect.getFieldHarga().getText()));
        brg.setStok(Integer.parseInt(frmSelect.getFieldStok().getText()));
        brg.setKodeBarang(frmSelect.getFieldKodeBarang().getText());
        ifaceBarang.updateSelect(brg);
        JOptionPane.showMessageDialog(null, "Data berhasil diupdate!");
    }

    
    public void isiComboboxKodeBarang(JComboBox<String> comboboxKodeBarang) {
        comboboxKodeBarang.removeAllItems();
        List<String> daftarKodeBarang = ifaceBarang.getDaftarKodeBarang(); // Panggil metode baru dari DAOBarang untuk mendapatkan daftar kode barang
        for (String kodeBarang : daftarKodeBarang) {
            comboboxKodeBarang.addItem(kodeBarang); // Tambahkan setiap kode barang ke dalam combobox
        }
    }


     
    public void deleteBarang(String kodeBarang) {
        
        Barang brg = new Barang();
        
        brg.setKodeBarang(frmDelete.getComboKodeBarang().getSelectedItem().toString());
        ifaceBarang.deleteDelete(brg); // Memanggil metode penghapusan barang dari DAO
        JOptionPane.showMessageDialog(null, "Data berhasil dihapus!");
    }
    
    //public void deleteDelete(){
        
        //Barang brg = new Barang();
        //brg.setKodeBarang(frmDelete.getComboKodeBarang().getText());
       // ifaceBarang.deleteDelete(brg);
       // JOptionPane.showConfirmDialog(null, "Apakah anda yakin ingin menghapus data ini dari Database anda selamanya?");
    //} 
    
    FormLogin frmLogin;
    FormMenu frmMenu;
    FormInsert frmInsert;
    FormDelete frmDelete;
    FormSelectAndUpdate frmSelect;
    InterfaceDAOBarang ifaceBarang;
    List<Barang> lstBarang;
    
}
