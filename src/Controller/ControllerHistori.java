/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import DAO.DAOHistori;
import DAO.DAOLoginRegister;
import DAOInterface.InterfaceDAOHistori;
import DAOInterface.InterfaceDAOLoginRegister;
import Model.Histori;
import Model.LoginRegister;
import Model.TabelModelHistori;
import ViewBarang.FormDelete;
import ViewBarang.FormInsert;
import ViewBarang.FormMenu;
import ViewBarang.FormSelectAndUpdate;
import ViewHistori.FormHistori;
import java.util.List;

/**
 *
 * @author aldo1
 */
public class ControllerHistori {
    
    private String kodeBaru;
    
    public ControllerHistori(FormMenu frmMenu) {
        this.frmMenu = frmMenu;
        ifaceHistori = new DAOHistori();
        ifaceLoginRegister = new DAOLoginRegister();
    }
    public ControllerHistori(FormHistori frmHistori) {
        this.frmHistori = frmHistori;
        ifaceHistori = new DAOHistori();
    }
    
    public ControllerHistori(FormDelete frmDelete) {
        this.frmDelete = frmDelete;
        ifaceHistori = new DAOHistori();
        ifaceLoginRegister = new DAOLoginRegister();
    }
    
    public ControllerHistori(FormInsert frmInsert) {
        this.frmInsert = frmInsert;
        ifaceHistori = new DAOHistori();
        ifaceLoginRegister = new DAOLoginRegister();
    }
    
    public ControllerHistori(FormSelectAndUpdate frmSelect) {
        this.frmSelect = frmSelect;
        ifaceHistori = new DAOHistori();
        ifaceLoginRegister = new DAOLoginRegister();
    }
    
    public void isiTableHistori(){
        lstHistori = ifaceHistori.getAll();
        TabelModelHistori tabelHistori = new TabelModelHistori(lstHistori);
        frmHistori.getTabelData().setModel(tabelHistori);
    }
    public void generateNewKodeHistori(){
        String prevKode = ifaceHistori.getLastKodeHistori();
        
        String data = prevKode.replace("HSTR", "");
        int num = Integer.parseInt(data);
        num = num+1;
        
        String nextKode = getNumberingFormat(num);
        
        this.kodeBaru = nextKode;
    }
    public String getNumberingFormat(int number){
        String numberData = "HSTR";
        if(number >= 1 && number <= 9){
            numberData =numberData + "0000" + number;
        }else if(number >= 10 && number <= 99){
            numberData =numberData + "000" + number;
        }else if(number >= 100 && number <= 999){
            numberData =numberData + "00" + number;
        }else if(number >= 1000 && number <= 9999){
            numberData =numberData + "0" + number;
        }else if(number >= 10000 && number <= 99999){
            numberData =numberData + "" + number;
        }
        
        return numberData;
    }
    public void historiDelete(){
        Histori hstr = new Histori();
                
        generateNewKodeHistori();
        
        hstr.setKodeHistoriBaru(kodeBaru);
        hstr.setKodeBarang(frmDelete.getComboKodeBarang().getSelectedItem().toString());
        hstr.setStatus("KELUAR");
        hstr.setBanyak("DELETE ALL");
        
        String idAktif = ifaceLoginRegister.whichUser();
        System.out.println("User Aktif Saat ini : "+ idAktif);  
        hstr.setIdPengguna(idAktif);
              
        ifaceHistori.histori(hstr);
    }
    
    public void historiInsert(){
        Histori hstr = new Histori();
        
        generateNewKodeHistori();
        hstr.setKodeHistoriBaru(kodeBaru);
        hstr.setKodeBarang(frmInsert.getFieldKodeBarang().getText());
        hstr.setStatus("MASUK");
        hstr.setBanyak("INSERT ALL");
        
        String idAktif = ifaceLoginRegister.whichUser();
        hstr.setIdPengguna(idAktif);
        ifaceHistori.histori(hstr);
        
    }
    
    public void historiUpdate(){
        Histori hstr = new Histori();
        
        generateNewKodeHistori();
        hstr.setKodeHistoriBaru(kodeBaru);
        hstr.setKodeBarang(frmSelect.getFieldKodeBarang().getText());
        hstr.setStatus("UPDATE");
        hstr.setBanyak("UPDATE");
        
        String idAktif = ifaceLoginRegister.whichUser();
        hstr.setIdPengguna(idAktif);
        ifaceHistori.histori(hstr);
        
    }
    
    public void historiTambahStok(){
        Histori hstr = new Histori();
        
        generateNewKodeHistori();
        hstr.setKodeHistoriBaru(kodeBaru);
        hstr.setKodeBarang(frmMenu.getComboNamaBarang().getSelectedItem().toString());
        hstr.setStatus("MASUK");
        hstr.setBanyak(frmMenu.getFieldStok().getText());
        
        String idAktif = ifaceLoginRegister.whichUser();
        hstr.setIdPengguna(idAktif);
        ifaceHistori.histori(hstr);
        
    }
    
    public void historiKurangiStok(){
        Histori hstr = new Histori();
        
        generateNewKodeHistori();
        hstr.setKodeHistoriBaru(kodeBaru);
        hstr.setKodeBarang(frmMenu.getComboNamaBarang().getSelectedItem().toString());
        hstr.setStatus("KELUAR");
        hstr.setBanyak(frmMenu.getFieldStok().getText());
        
        String idAktif = ifaceLoginRegister.whichUser();
        hstr.setIdPengguna(idAktif);
        ifaceHistori.histori(hstr);
        
    }
    
    FormMenu frmMenu;
    FormInsert frmInsert;
    FormSelectAndUpdate frmSelect;
    FormHistori frmHistori;
    FormDelete frmDelete;
    InterfaceDAOHistori ifaceHistori;
    InterfaceDAOLoginRegister ifaceLoginRegister;
    List<Histori> lstHistori;
}
