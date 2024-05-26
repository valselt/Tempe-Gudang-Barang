/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author aldo1
 */
public class Barang {
    private String kode_barang;
    private String nama_barang;
    private String satuan;
    private Integer harga;
    private Integer stok;
    private Integer stokSementara;
    
        
    public String getKodeBarang() {
        return kode_barang;
    }
    
    public void setKodeBarang(String kode_barang) {
        this.kode_barang = kode_barang;
    }

    
    public String getNamaBarang() {
        return nama_barang;
    }

    
    public void setNamaBarang(String nama_barang) {
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
    
    public Integer getStokSementara() {
        return stokSementara;
    }

    
    public void setStokSementara(Integer stokSementara) {
        this.stokSementara = stokSementara;
    }
    
}
