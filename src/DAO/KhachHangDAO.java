/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import utils.XJDBC;
import Entity.KhachHang;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author XUAN TRUONG
 */
public class KhachHangDAO extends NikeDAO<KhachHang, String> {

    @Override
    public void insert(KhachHang model) {
        String sql = "INSERT INTO KhachHang (MaKH, TenKH, DiaChi, SDT, Email, ThanhVien) VALUES (?, ?, ?, ?, ?, ?)";
        XJDBC.update(sql,
                model.getMaKH(),
                model.getTenKH(),
                model.getDiaChi(),
                model.getSDT(),
                model.getEmail(),
                model.getThanhVien().equalsIgnoreCase("Có")
        );
    }

    @Override
    public void update(KhachHang model) {
        String sql = "UPDATE KhachHAng SET TenKH=?, DiaChi=?, SDT=?, Email=?, ThanhVien=? WHERE MaKH=?";
        XJDBC.update(sql,
                model.getTenKH(),
                model.getDiaChi(),
                model.getSDT(),
                model.getEmail(),
                model.getThanhVien().equalsIgnoreCase("Có"),
                model.getMaKH());
    }

    @Override
    public void delete(String MaKH) {
        String sql = "DELETE FROM KhachHang WHERE MaKH=?";
        XJDBC.update(sql, MaKH);
    }

    @Override
    public List<KhachHang> selectAll() {
        String sql = "SELECT * FROM KhachHang";
        return selectBySQL(sql);
    }

    @Override
    public KhachHang selectById(String MaKH) {
        String sql = "SELECT * FROM KhachHang WHERE MaKH=?";
        List<KhachHang> list = selectBySQL(sql, MaKH);
        return list.size() > 0 ? list.get(0) : null;
    }

    @Override
    protected List<KhachHang> selectBySQL(String sql, Object... args) {
        List<KhachHang> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = XJDBC.query(sql, args);
                while (rs.next()) {
                    KhachHang entity = new KhachHang();
                    entity.setMaKH(rs.getString("MaKH"));
                    entity.setTenKH(rs.getString("TenKH"));
                    entity.setDiaChi(rs.getString("DiaChi"));
                    entity.setSDT(rs.getInt("SDT"));
                    entity.setEmail(rs.getString("Email"));
                    entity.setThanhVien(rs.getBoolean("ThanhVien") ? "Có" : "Không");
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

}
