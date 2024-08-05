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
public class HoaDon {
    private String MaSP;
    private String TenSP;
    private String MaHD;
    private double DonGia;
    private int SoLuong;
    private String MaKH;
    private double ThanhTien;

    public HoaDon(String MaSP, String TenSP, String MaHD, double DonGia, int SoLuong, String MaKH, double ThanhTien) {
        this.MaSP = MaSP;
        this.TenSP = TenSP;
        this.MaHD = MaHD;
        this.DonGia = DonGia;
        this.SoLuong = SoLuong;
        this.MaKH = MaKH;
        this.ThanhTien = ThanhTien;
       
    }

    public HoaDon() {
        
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

    public String getMaHD() {
        return MaHD;
    }

    public void setMaHD(String MaHD) {
        this.MaHD = MaHD;
    }

    public double getDonGia() {
        return DonGia;
    }

    public void setDonGia(double DonGia) {
        this.DonGia = DonGia;
    }

    public int getSoLuong() {
        return SoLuong;
    }

    public void setSoLuong(int SoLuong) {
        this.SoLuong = SoLuong;
    }

    public String getMaKH() {
        return MaKH;
    }

    public void setMaKH(String MaKH) {
        this.MaKH = MaKH;
    }

    public double getThanhTien() {
        return ThanhTien;
    }

    public void setThanhTien(double ThanhTien) {
        this.ThanhTien = ThanhTien;
    }
    
}
