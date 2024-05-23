/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import DAO.DAOBarang;
import DAOInterface.InterfaceDAOBarang;
import Model.Barang;
import Model.TabelModelBarang;
import View.FormInsert;
import View.FormMenu;
import View.FormSelect;
import java.awt.Frame;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author aldo1
 */
public class ControllerBarang {
    
    public ControllerBarang(FormMenu frmMenu){
        this.frmMenu = frmMenu;
        ifaceBarang = new DAOBarang(); 
    }
    
    public ControllerBarang(FormSelect frmSelect){
        this.frmSelect = frmSelect;
        ifaceBarang = new DAOBarang(); 
    }
    
    public ControllerBarang(FormInsert frmInsert){
        this.frmInsert = frmInsert;
        ifaceBarang = new DAOBarang(); 
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
    
    public void insert(){
        Barang brg = new Barang();
        
        brg.setKodeBarang(frmInsert.getFieldKodeBarang().getText());
        brg.setNamaBarang(frmInsert.getFieldNamaBarang().getText());
        brg.setSatuan(frmInsert.getFieldSatuan().getText());
        brg.setHarga(Integer.parseInt(frmInsert.getFieldHarga().getText()));
        brg.setStok(Integer.parseInt(frmInsert.getFieldStok().getText()));
        ifaceBarang.insert(brg);
        JOptionPane.showConfirmDialog(null, "Simpan Perubahan?");
        
    }
    
    
    FormMenu frmMenu;
    FormInsert frmInsert;
    FormSelect frmSelect;
    InterfaceDAOBarang ifaceBarang;
    List<Barang> lstBarang;
    
}
