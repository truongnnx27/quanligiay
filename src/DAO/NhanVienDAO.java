/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Entity.NhanVien;
import java.util.List;
import java.sql.*;
import java.util.ArrayList;
import utils.XJDBC;

/**
 *
 * @author XUAN TRUONG
 */
public class NhanVienDAO extends NikeDAO<NhanVien,String>{

    ResultSet rs;
    String INSERT_SQL = "INSERT INTO NhanVien (MaNV,TenNV,MatKhau,GioiTinh,NgaySinh, VaiTro,Email) VALUES (?, ?, ?, ?,?,?,?)";
    String UPDATE_SQL = "UPDATE NhanVien SET TenNV=?,MatKhau = ?, GioiTinh=?,ngaysinh=?, VaiTro = ?,email=? WHERE MaNV = ?";
    String DELETE_SQL = "DELETE FROM NHAnVIEN WHERE MANV = ?";
    String SELECT_ALL_SQL = "SELECT * FROM NHAnVIEN";
    String SELECT_BY_ID_SQL = "SELECT * FROM NHAnVIEN WHERE MANV = ?";
    
    @Override
    public void insert(NhanVien entity) {
        XJDBC.update(INSERT_SQL,entity.getMaNV(),entity.getTenNV()
                        ,entity.getMatKhau(),entity.isGioiTinh(),entity.getNgaySinh()
                        ,entity.isVaiTro(),entity.getEmail());
    }

    @Override
    public void update(NhanVien entity) {
        XJDBC.update(UPDATE_SQL,entity.getTenNV()
                        ,entity.getMatKhau(),entity.isGioiTinh(),entity.getNgaySinh()
                        ,entity.isVaiTro(),entity.getEmail(),entity.getMaNV());
    }

    @Override
    public void delete(String key) {
        XJDBC.update(DELETE_SQL,key);
    }

    @Override
    public List<NhanVien> selectAll() {
        return this.selectBySQL(SELECT_ALL_SQL);
    }

    @Override
    public NhanVien selectById(String id) {
        List<NhanVien> list= this.selectBySQL(SELECT_BY_ID_SQL,id);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }
    
    @Override
    protected List<NhanVien> selectBySQL(String sql, Object... args) {
        List<NhanVien> list=new ArrayList<>();
        try {
            rs= XJDBC.query(sql,args);
            while (rs.next()) {
                NhanVien entity= new NhanVien();
                entity.setMaNV(rs.getString("MaNV"));
                entity.setTenNV(rs.getString("TenNV"));
                entity.setMatKhau(rs.getString("MatKhau"));
                entity.setGioiTinh(rs.getBoolean("GioiTinh"));
                entity.setNgaySinh(rs.getDate("NgaySinh"));
                entity.setVaiTro(rs.getBoolean("VaiTro"));
                entity.setEmail(rs.getString("Email"));
                list.add(entity);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
}
