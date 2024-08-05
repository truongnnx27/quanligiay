/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

import java.util.Date;

/**
 *
 * @author XUAN TRUONG
 */
public class SanPham {

    private String MaSP;
    private String TenSP;
    private String TenLoai;
    private int KichThuoc;
    private double GiaBan;
    private String Image;
    private String ChuThich;

    public SanPham() {
    }

    public SanPham(String MaSP, String TenSP, String TenLoai, int KichThuoc, double GiaBan, String Image, String ChuThich) {
        this.MaSP = MaSP;
        this.TenSP = TenSP;
        this.TenLoai = TenLoai;
        this.KichThuoc = KichThuoc;
        this.GiaBan = GiaBan;
        this.Image = Image;
        this.ChuThich = ChuThich;
    }

    public String getMaSP() {
        return MaSP;
    }

    public void setMaSP(String MaSP) {
        this.MaSP = MaSP;
    }

    public String getTenSP() {
        return TenSP;
    }

    public void setTenSP(String TenSP) {
        this.TenSP = TenSP;
    }

    public String getTenLoai() {
        return TenLoai;
    }

    public void setTenLoai(String TenLoai) {
        this.TenLoai = TenLoai;
    }

    public int getKichThuoc() {
        return KichThuoc;
    }

    public void setKichThuoc(int KichThuoc) {
        this.KichThuoc = KichThuoc;
    }

    public double getGiaBan() {
        return GiaBan;
    }

    public void setGiaBan(double GiaBan) {
        this.GiaBan = GiaBan;
    }

    public String getImage() {
        return Image;
    }

    public void setImage(String Image) {
        this.Image = Image;
    }

    public String getChuThich() {
        return ChuThich;
    }

    public void setChuThich(String ChuThich) {
        this.ChuThich = ChuThich;
    }

}
