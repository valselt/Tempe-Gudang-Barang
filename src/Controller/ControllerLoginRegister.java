/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import DAO.DAOLoginRegister;
import DAOInterface.InterfaceDAOLoginRegister;
import Model.LoginRegister;
import ViewBarang.Dashboard;
import ViewLoginRegister.FormLogin;
import ViewLoginRegister.FormRegister;
import ViewLoginRegister.FormUser;
import javax.swing.JOptionPane;

/**
 *
 * @author aldo1
 */
public class ControllerLoginRegister {
    
    public ControllerLoginRegister(FormRegister frmRegister){
        this.frmRegister = frmRegister;
        ifaceLoginRegister = new DAOLoginRegister();
    }
    public ControllerLoginRegister(FormLogin frmLogin){
        this.frmLogin = frmLogin;
        ifaceLoginRegister = new DAOLoginRegister();
    }
        public ControllerLoginRegister(FormUser frmUser){
        this.frmUser = frmUser;
        ifaceLoginRegister = new DAOLoginRegister();
    }
    
    //register
    void bersihField(){
        frmRegister.getFieldIdPengguna().setText("");
        frmRegister.getFieldNamaPengguna().setText("");
        frmRegister.getFieldNoTeleponPengguna().setText("");
        frmRegister.getFieldPasswordPengguna().setText("");
    }
    public void checkAvailableIdPengguna(){
        LoginRegister lr = new LoginRegister();
        
        lr.setId_pengguna(frmRegister.getFieldIdPengguna().getText());
        boolean itIsAlreadyTaken = ifaceLoginRegister.checkAvailableIdPengguna(lr);
        
        if (itIsAlreadyTaken) {
            JOptionPane.showMessageDialog(null, "Username Telah Dipakai!");
            bersihField();
            
        } else {
            register();
            FormLogin login = new FormLogin();
            login.setVisible(true);
            login.revalidate();
        } 
    }
    public void register(){
        LoginRegister lr = new LoginRegister();
        String idPengguna = frmRegister.getFieldIdPengguna().getText();
        
        lr.setId_pengguna(frmRegister.getFieldIdPengguna().getText());
        lr.setNama_pengguna(frmRegister.getFieldNamaPengguna().getText());
        lr.setNo_telepon(Long.parseLong(frmRegister.getFieldNoTeleponPengguna().getText()));
        lr.setLevel("user");
        lr.setPassword(frmRegister.getFieldPasswordPengguna().getText());
        lr.setLogin_condition(0);
        
        ifaceLoginRegister.register(lr);
        JOptionPane.showMessageDialog(null, "Data dengan username "+ idPengguna +" berhasil ditambahkan!");
        frmRegister.dispose();
    }
    
    
    //login
    public void checkLogin(){
        LoginRegister lr = new LoginRegister();
        String username = frmLogin.getTxtUser().getText();
        lr.setId_pengguna(username);
        lr.setPassword(frmLogin.getTxtPassword().getText());
        
        boolean itIsOkay = ifaceLoginRegister.checkLogin(lr);
        if (itIsOkay) {
            
            ensureLoginCondition();
            
            
        } else {
            JOptionPane.showMessageDialog(null, "Username atau Password Salah!");
            FormLogin login = new FormLogin();
            login.setVisible(true);
            login.revalidate();
        } 
    }
    
    private void ensureLoginCondition() {
        LoginRegister lr = new LoginRegister();
        lr.setConditionEnsure(0);
        ifaceLoginRegister.ensureLoginCondition(lr);
        updateLoginCondition();
    }

    private void updateLoginCondition() {
        LoginRegister lr = new LoginRegister();
        lr.setCondition(1);
        lr.setId_pengguna(frmLogin.getTxtUser().getText());
        ifaceLoginRegister.updateLoginCondition(lr);
        Dashboard menu = new Dashboard();
        menu.setVisible(true);
        menu.revalidate();
        frmLogin.dispose();
    }
    
    public void user(){
        frmUser.getFieldIdPengguna().setText(ifaceLoginRegister.user().getId_pengguna());
        frmUser.getFieldNamaPengguna().setText(ifaceLoginRegister.user().getNama_pengguna());
        frmUser.getFieldNoTelepon().setText(String.valueOf(ifaceLoginRegister.user().getNo_telepon()));
        frmUser.getFieldLevel().setText(ifaceLoginRegister.user().getLevel());
    }
    
    
    FormLogin frmLogin;
    FormRegister frmRegister;
    FormUser frmUser;
    InterfaceDAOLoginRegister ifaceLoginRegister;

    
    
}

