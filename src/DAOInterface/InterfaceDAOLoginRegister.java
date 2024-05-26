/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DAOInterface;

import Model.LoginRegister;
        
public interface InterfaceDAOLoginRegister {
    public boolean checkAvailableIdPengguna(LoginRegister lr);
    public void register(LoginRegister lr);
    public boolean checkLogin(LoginRegister lr);
    public void ensureLoginCondition(LoginRegister lr);
    public void updateLoginCondition(LoginRegister lr);
    
}
