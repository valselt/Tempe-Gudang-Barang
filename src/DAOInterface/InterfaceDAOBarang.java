/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DAOInterface;

import Model.Barang;
import java.util.List;

/**
 *
 * @author aldo1
 */
public interface InterfaceDAOBarang {
    // untuk read data
    public List<Barang> getAll();
    // untuk insert data
    public void insert(Barang brg);
    //untuk update data
    public void updateSelect(Barang brg);
    
}
