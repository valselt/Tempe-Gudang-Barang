/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author aldo1
 */
public class LoginRegister {

    /**
     * @return the condition
     */
    

    /**
     * @return the id_pengguna
     */
    public String getId_pengguna() {
        return id_pengguna;
    }

    /**
     * @param id_pengguna the id_pengguna to set
     */
    public void setId_pengguna(String id_pengguna) {
        this.id_pengguna = id_pengguna;
    }

    /**
     * @return the nama_pengguna
     */
    public String getNama_pengguna() {
        return nama_pengguna;
    }

    /**
     * @param nama_pengguna the nama_pengguna to set
     */
    public void setNama_pengguna(String nama_pengguna) {
        this.nama_pengguna = nama_pengguna;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the no_telepon
     */
    public Long getNo_telepon() {
        return no_telepon;
    }

    /**
     * @param no_telepon the no_telepon to set
     */
    public void setNo_telepon(Long no_telepon) {
        this.no_telepon = no_telepon;
    }

    /**
     * @return the level
     */
    public String getLevel() {
        return level;
    }

    /**
     * @param level the level to set
     */
    public void setLevel(String level) {
        this.level = level;
    }

    /**
     * @return the login_condition
     */
    public Integer getLogin_condition() {
        return login_condition;
    }

    /**
     * @param login_condition the login_condition to set
     */
    public void setLogin_condition(Integer login_condition) {
        this.login_condition = login_condition;
    }
    public Integer getCondition() {
        return condition;
    }

    /**
     * @param condition the condition to set
     */
    public void setCondition(Integer condition) {
        this.condition = condition;
    }

    /**
     * @return the conditionEnsure
     */
    public Integer getConditionEnsure() {
        return conditionEnsure;
    }

    /**
     * @param conditionEnsure the conditionEnsure to set
     */
    public void setConditionEnsure(Integer conditionEnsure) {
        this.conditionEnsure = conditionEnsure;
    }
    
    private String id_pengguna;
    private String nama_pengguna;
    private String password;
    private Long no_telepon;
    private String level;
    private Integer login_condition;
    private Integer condition;
    private Integer conditionEnsure;
    
}
