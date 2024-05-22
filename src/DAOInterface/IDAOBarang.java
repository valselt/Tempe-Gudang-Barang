/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DAOInterface;

import Model.ModelBarang;
import java.util.List;

/**
 *
 * @author aldo1
 */
public interface IDAOBarang {
    // untuk read data
    public List<ModelBarang> getAll();
    
}
