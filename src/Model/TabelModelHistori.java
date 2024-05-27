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
public class TabelModelHistori extends AbstractTableModel {
    List<Histori> lstHistori;
    
    public TabelModelHistori(List<Histori> lstHistori){
        this.lstHistori = lstHistori;
    }    
    @Override
    public int getRowCount() {
        return this.lstHistori.size();
    }

    @Override
    public int getColumnCount() {
        return 5;
    }
    
    @Override
    public String getColumnName(int column){
        switch(column){
            case 0:
                return "Kode Histori";
            case 1:
                return "Kode Barang";
             case 2:
                return "Status";
            case 3:
                return "Sebanyak";
            case 4:
                return "Oleh Pengguna";
            default:
                return null;
        }
    }
    

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(columnIndex){
            case 0:
                return lstHistori.get(rowIndex).getKodeHistori();
            case 1:
                return lstHistori.get(rowIndex).getKodeBarang();
            case 2:
                return lstHistori.get(rowIndex).getStatus();
            case 3:
                return lstHistori.get(rowIndex).getBanyak();
            case 4:
                return lstHistori.get(rowIndex).getIdPengguna();
            default:
                return null;
        }
        
            
    }
}
