/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import utils.XJDBC;
import Entity.LoaiSp;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author nguye
 */
public class LoaiSpDao extends NikeDAO<LoaiSp, String> {

    @Override
    public List<LoaiSp> selectAll() {
        String sql = "SELECT * FROM LoaiSanPham";
        return selectBySQL(sql); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }


    @Override
    public LoaiSp selectById(String MaLoaiSp) {
        String sql = "SELECT * FROM LoaiSanPham WHERE MaLoaiSp=?";
        List<LoaiSp> list = selectBySQL(sql, MaLoaiSp);
        return list.size() > 0 ? list.get(0) : null;
    }

    @Override
    protected List<LoaiSp> selectBySQL(String sql, Object... args) {
        List<LoaiSp> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = XJDBC.query(sql, args);
                while (rs.next()) {
                    LoaiSp entity = new LoaiSp();
                    entity.setTenLoai(rs.getString("TenLoaiSanPham"));
                    entity.setMaLoai(rs.getString("MaLoaiSP"));
                    list.add(entity);
                }
            } finally {
                rs.getStatement().getConnection().close();
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return list;
    }

    @Override
    public void insert(LoaiSp entity) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void update(LoaiSp entity) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(String key) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
