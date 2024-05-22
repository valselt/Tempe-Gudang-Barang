/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author aldo1
 */
public class ModelBarang {

    private String kode_barang;
    private String nama_barang;
    private String satuan;
    private Integer harga;
    private Integer stok;
    
    public String getKode_barang() {
        return kode_barang;
    }
    
    public void setKode_barang(String kode_barang) {
        this.kode_barang = kode_barang;
    }

    
    public String getNama_barang() {
        return nama_barang;
    }

    
    public void setNama_barang(String nama_barang) {
        this.nama_barang = nama_barang;
    }

    
    public String getSatuan() {
        return satuan;
    }

    
    public void setSatuan(String satuan) {
        this.satuan = satuan;
    }

    
    public Integer getHarga() {
        return harga;
    }

    
    public void setHarga(Integer harga) {
        this.harga = harga;
    }

    
    public Integer getStok() {
        return stok;
    }

   
    public void setStok(Integer stok) {
        this.stok = stok;
    }
    
}
