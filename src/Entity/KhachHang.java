/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;


/**
 *
 * @author XUAN TRUONG
 */
public class KhachHang {

    private String MaKH;
    private String TenKH;
    private String DiaChi;
    private int SDT;
    private String Email;
    private String ThanhVien;

    public KhachHang(String MaKH, String TenKH, boolean GioiTinh, String DiaChi, int SDT, String Email, String ThanhVien) {
        this.MaKH = MaKH;
        this.TenKH = TenKH;
        this.DiaChi = DiaChi;
        this.SDT = SDT;
        this.Email = Email;
        this.ThanhVien = ThanhVien;
    }

    public KhachHang() {
    }

    public String getMaKH() {
        return MaKH;
    }

    public void setMaKH(String MaKH) {
        this.MaKH = MaKH;
    }

    public String getTenKH() {
        return TenKH;
    }

    public void setTenKH(String TenKH) {
        this.TenKH = TenKH;
    }

    public String getDiaChi() {
        return DiaChi;
    }

    public void setDiaChi(String DiaChi) {
        this.DiaChi = DiaChi;
    }

    public int getSDT() {
        return SDT;
    }

    public void setSDT(int SDT) {
        this.SDT = SDT;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getThanhVien() {
        return ThanhVien;
    }

    public void setThanhVien(String ThanhVien) {
        this.ThanhVien = ThanhVien;
    }

    

}
