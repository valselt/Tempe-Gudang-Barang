/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author aldo1
 */
public class TabelModelBarang extends AbstractTableModel{
    List<Barang> lstBarang;
    public TabelModelBarang(List<Barang> lstBarang){
        this.lstBarang = lstBarang;
    }    
    @Override
    public int getRowCount() {
        return this.lstBarang.size();
    }

    @Override
    public int getColumnCount() {
        return 5;
    }
    
    @Override
    public String getColumnName(int column){
        switch(column){
            case 0:
                return "Kode Barang";
            case 1:
                return "Nama Barang";
            case 2:
                return "Satuan";
            case 3:
                return "Harga";
            case 4:
                return "Stok";
            default:
                return null;
        }
    }
    

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(columnIndex){
            case 0:
                return lstBarang.get(rowIndex).getKodeBarang();
            case 1:
                return lstBarang.get(rowIndex).getNamaBarang();
            case 2:
                return lstBarang.get(rowIndex).getSatuan();
            case 3:
                return Integer.toString(lstBarang.get(rowIndex).getHarga());
            case 4:
                return Integer.toString(lstBarang.get(rowIndex).getStok());
 
            default:
                return null;
        }
        
            
    }
}
