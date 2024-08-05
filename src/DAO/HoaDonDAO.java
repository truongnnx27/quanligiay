/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Entity.HoaDon;
import java.util.List;
import java.sql.*;
import java.util.ArrayList;
import utils.XJDBC;
/**
 *
 * @author XUAN TRUONG
 */
public class HoaDonDAO extends NikeDAO<HoaDon, String>{

    ResultSet rs;
    String INSERT_SQL = "INSERT INTO HoaDon (MaHD, MaSP, TenSP, Soluong, DonGia,  MaKH, ThanhTien) VALUES (?, ?, ?, ?,?,?,?)";
    String UPDATE_SQL = "UPDATE HoaDon SET MaSP = ? , TenSP = ?, Soluong = ?, DonGia= ?, MaKH = ?,ThanhTien = ? WHERE MaHD =?";
    String DELETE_SQL = "DELETE FROM HoaDon WHERE MaHD=?";
    String SELECT_ALL_SQL = "SELECT * FROM HoaDon";
    String SELECT_BY_ID_SQL = "SELECT * FROM HoaDon WHERE MaHD = ?";
    @Override
    public void insert(HoaDon entity) {
        XJDBC.update(INSERT_SQL,
                entity.getMaHD(),
                entity.getMaSP(),
                entity.getTenSP(),
                entity.getDonGia(),
                entity.getSoLuong(),
                entity.getMaKH(),
                entity.getThanhTien());
    }

    @Override
    public void update(HoaDon model) {
        XJDBC.update(UPDATE_SQL, 
                model.getMaSP(),
                model.getTenSP(),
                model.getDonGia(),
                model.getSoLuong(),
                model.getMaKH(),
                model.getThanhTien(),
                model.getMaHD());
    }

    @Override
    public void delete(String key) {
        XJDBC.update(DELETE_SQL,key);
    }

    @Override
    public List<HoaDon> selectAll() {
        return this.selectBySQL(SELECT_ALL_SQL);
    }

    @Override
    public HoaDon selectById(String id) {
        List<HoaDon> list = this.selectBySQL(SELECT_BY_ID_SQL,id);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Override
    protected List<HoaDon> selectBySQL(String sql, Object... args) {
        List<HoaDon> list = new ArrayList<>();
        try {
            rs= XJDBC.query(sql,args);
            while (rs.next()) {
                HoaDon entity= new HoaDon();
                entity.setMaHD(rs.getString("MaHD"));
                entity.setMaSP(rs.getString("MaSP"));
                entity.setTenSP(rs.getString("TenSP"));
                entity.setSoLuong(rs.getInt("SoLuong"));
                entity.setDonGia(rs.getDouble("DonGia"));
                entity.setMaKH(rs.getString("MaKH"));
                entity.setThanhTien(rs.getDouble("ThanhTien"));
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
