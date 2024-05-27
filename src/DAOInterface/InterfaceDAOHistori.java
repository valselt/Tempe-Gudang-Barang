/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DAOInterface;

import Model.Histori;
import java.util.List;

/**
 *
 * @author aldo1
 */
public interface InterfaceDAOHistori {
    //read
    public void histori(Histori hstr);
    public List<Histori> getAll();
    public String getLastKodeHistori();
}
