/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import DAO.DAOBarang;
import DAOInterface.InterfaceDAOBarang;
import Model.Barang;
import Model.TabelModelBarang;
import View.Dashboard;
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
    
    
    
    
    //proses login
    public boolean verifyLogin(String username, String password) {
        return ifaceBarang.verifyLogin(username, password);
    }
    
    public void ensureLoginCondition(int conditionEnsure){
        ifaceBarang.ensureLoginCondition(conditionEnsure);
    }
    public void updateLoginCondition(String username, int condition) {
        ifaceBarang.updateLoginCondition(username, condition);
    }
    
    
    // menu + tambah kurangi stok
    public void isiTable(){
        lstBarang = ifaceBarang.getAll();
        TabelModelBarang tabelBarang = new TabelModelBarang(lstBarang);
        frmMenu.getTabelData().setModel(tabelBarang);
    }
    
    public void stokAdd(){
        Barang brg = new Barang();
        
        brg.setStokSementara(Integer.parseInt(frmMenu.getFieldStok().getText()));
        brg.setNamaBarang(frmMenu.getComboNamaBarang().getSelectedItem().toString());
        ifaceBarang.stokAdd(brg);
        
        JOptionPane.showMessageDialog(null, "Stok Berhasil Ditambahkan!");
    }
    
    public void stokReduce(){
        Barang brg = new Barang();
        
        brg.setStokSementara(Integer.parseInt(frmMenu.getFieldStok().getText()));
        brg.setNamaBarang(frmMenu.getComboNamaBarang().getSelectedItem().toString());
        ifaceBarang.stokReduce(brg);
        
        JOptionPane.showMessageDialog(null, "Stok Berhasil Dikurangin!");
    }
    public void resetFieldStok(){
        frmMenu.getFieldStok().setText("");
    }
    
    
    //select and update
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
    
    //delete
    public void deleteBarang() {
        
        Barang brg = new Barang();
        
        brg.setKodeBarang(frmDelete.getComboKodeBarang().getSelectedItem().toString());
        ifaceBarang.deleteDelete(brg); // Memanggil metode penghapusan barang dari DAO
        JOptionPane.showMessageDialog(null, "Data berhasil dihapus!");
    }
    
    //insert barang
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
    
    //update barang
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
    
    public void isiComboboxNamaBarang(JComboBox<String> comboboxNamaBarang){
        comboboxNamaBarang.removeAllItems();
        List<String> daftarNamaBarang = ifaceBarang.getDaftarNamaBarang();
        for (String namaBarang : daftarNamaBarang){
            comboboxNamaBarang.addItem(namaBarang);
        }
    }


     
    
    
    
    
    FormLogin frmLogin;
    FormMenu frmMenu;
    FormInsert frmInsert;
    FormDelete frmDelete;
    FormSelectAndUpdate frmSelect;
    InterfaceDAOBarang ifaceBarang;
    List<Barang> lstBarang;
    
}
