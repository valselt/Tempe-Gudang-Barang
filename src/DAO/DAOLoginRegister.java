/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Model.LoginRegister;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.util.logging.Level;
import java.util.logging.Logger;
import DAOInterface.InterfaceDAOLoginRegister;
import Helper.Koneksi;

public class DAOLoginRegister implements InterfaceDAOLoginRegister {
    public DAOLoginRegister() {
        con = Koneksi.getConnection();
    }
    
    @Override
    public boolean checkAvailableIdPengguna(LoginRegister lr){
        try (PreparedStatement statement = con.prepareStatement(check)) {
            statement.setString(1, lr.getId_pengguna());
            ResultSet rs = statement.executeQuery();
            return rs.next(); // returns true if a match is found
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    @Override
    public void register(LoginRegister lr) {
        PreparedStatement statement = null;
        try {
            statement = con.prepareStatement(register);
            statement.setString(1, lr.getId_pengguna());
            statement.setString(2, lr.getNama_pengguna());
            statement.setString(3, lr.getPassword());
            statement.setLong(4, lr.getNo_telepon());
            statement.setString(5, lr.getLevel());
            statement.setInt(6, lr.getLogin_condition());
            statement.execute();
        }
        catch(SQLException e){
            System.out.println("Gagal Register!");
        }
        finally{
            try {
                statement.close();
            } catch (SQLException ex) {
                System.out.println("Gagal Register!");
            }
        }
    }
    @Override
    public boolean checkLogin(LoginRegister lr){
        try (PreparedStatement statement = con.prepareStatement(login)) {
            statement.setString(1, lr.getId_pengguna());
            statement.setString(2, lr.getPassword());
            ResultSet resultSet = statement.executeQuery();
            return resultSet.next(); // returns true if a match is found
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public void ensureLoginCondition(LoginRegister lr) {
        try {
            PreparedStatement statement = con.prepareStatement(loginEnsure);
            statement.setInt(1, lr.getConditionEnsure());
            statement.execute();
        } catch (SQLException e) {
            System.out.println("Error Memverifikasi: " + e.getMessage());
        }
    }

    @Override
    public void updateLoginCondition(LoginRegister lr) {
        try {
            PreparedStatement statement = con.prepareStatement(loginCondition);
            statement.setInt(1, lr.getCondition());
            statement.setString(2, lr.getId_pengguna());
            statement.execute();
        } catch (SQLException e) {
            System.out.println("Error Memverifikasi Login Menjadi 1");
        }
    }
    
    public String whichUser(){
        try{
            PreparedStatement statement = con.prepareStatement(which);
            ResultSet rs = statement.executeQuery();
            
            if (rs.next()) {
                String whichUser = rs.getString("id_pengguna");
                return whichUser;
            } else {
                System.out.println("Error Mengambil Data Orang yang sedang Login");
                return null;
            }
        }catch(SQLException e){
            System.out.println("Error Mengambil Data Orang yang sedang Login");
            return null;
        }
    }
    
    Connection con;
    //SQL Query
    String check = "SELECT * FROM user WHERE id_pengguna = ?;";
    String login = "SELECT * FROM user WHERE id_pengguna = ? AND password = ?;";
    String loginEnsure = "UPDATE user SET login_condition = ?;";
    String loginCondition = "UPDATE user SET login_condition = ? WHERE id_pengguna = ?";
    String register = "INSERT INTO user(id_pengguna, nama_pengguna, password, no_telepon, level, login_condition) values (?, ?, ?, ?, ?, ?);";
    String which = "SELECT * FROM user WHERE login_condition=1;";

    

    
}
