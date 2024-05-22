/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import DAO.DAOBarang;
import DAOInterface.InterfaceDAOBarang;
import Model.Barang;
import Model.TabelModelBarang;
import View.FormMenu;
import java.awt.Frame;
import java.util.List;

/**
 *
 * @author aldo1
 */
public class ControllerBarang {
    
    public ControllerBarang(FormMenu frmMenu){
        this.frmMenu = frmMenu;
        ifaceBarang = new DAOBarang(); 
    }
    
    public void isiTable(){
        lstBarang = ifaceBarang.getAll();
        TabelModelBarang tabelBarang = new TabelModelBarang(lstBarang);
        frmMenu.getTabelData().setModel(tabelBarang);
    }
    
    FormMenu frmMenu;
    InterfaceDAOBarang ifaceBarang;
    List<Barang> lstBarang;
}
