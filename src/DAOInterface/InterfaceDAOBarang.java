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
    //login
    boolean verifyLogin(String username, String password);
    public void updateLoginCondition(String username, int condition);
    public void ensureLoginCondition(int conditionEnsure);
    // untuk read data
    public List<Barang> getAll();
    public List<String> getDaftarKodeBarang();
    public List<String> getDaftarNamaBarang();
    // untuk insert data
    public void insert(Barang brg);
    //untuk update data pada FormSelectAndUpdate
    public void updateSelect(Barang brg);
    public void stokAdd (Barang brg);
    public void stokReduce (Barang brg);
    //untuk delete data pada FormDelete
    public void deleteDelete(Barang brg);
    
    
}
