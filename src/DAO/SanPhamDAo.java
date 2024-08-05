/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Entity.LoaiSp;
import utils.XJDBC;
import Entity.SanPham;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author nguye
 */
public class SanPhamDAo extends NikeDAO<SanPham, String> {

    public LoaiSpDao LspDao = new LoaiSpDao();
    public String maLoai;

    @Override
    public void insert(SanPham model) {
        List<LoaiSp> lsLoai = LspDao.selectAll();
        String tenL = model.getTenLoai();
        for (LoaiSp loaiSp : lsLoai) {
            if (tenL.equals(loaiSp.getTenLoai())) {
                maLoai = loaiSp.getMaLoai();
            }
        }

        String sql = "INSERT INTO SanPham (MaSp, TenSP, MaLoaiSP, size, GiaBan, HinhAnh, GhiChu) VALUES (?, ?, ?, ?, ?, ?,? )";
        XJDBC.update(sql,
                model.getMaSP(),
                model.getTenSP(),
                maLoai,
                model.getKichThuoc(),
                model.getGiaBan(),
                model.getImage(),
                model.getChuThich()
        );
    }

    @Override
    public void update(SanPham model) {
        List<LoaiSp> lsLoai = LspDao.selectAll();
        String tenL = model.getTenLoai();
        for (LoaiSp loaiSp : lsLoai) {
            if (tenL.equals(loaiSp.getTenLoai())) {
                maLoai = loaiSp.getMaLoai();
            }
        }
        String sql = "UPDATE SanPham SET TenSP=?, MaLoaiSp=?, size=?, GiaBan=?, HinhAnh=?,GhiChu=? WHERE MaSp=?";
        XJDBC.update(sql,
                model.getTenSP(),
                maLoai, 
                model.getKichThuoc(),
                model.getGiaBan(),
                model.getImage(),
                model.getChuThich(),
                model.getMaSP());
    }

    @Override
    public void delete(String MaSp) {
        String sql = "DELETE FROM SanPham WHERE MaSp=?";
        XJDBC.update(sql, MaSp);
    }

    @Override
    public List<SanPham> selectAll() {
        String sql = "select MaSP,TenSP, TenLoaiSanPham,Size,GiaBan,HinhAnh,Ghichu  from SanPham,LoaiSanPham where sanpham.MaLoaiSP=LoaiSanPham.MaLoaiSP;";
        return selectBySQL(sql);
    }

    public List<SanPham> selectTenMa() {
        String sql = "select MaSP,TenSP from SanPham";
        return selectBySQL(sql);
    }

    @Override
    public SanPham selectById(String id) {
        String sql = "select masp, TenSP, TenLoaiSanPham,Size,GiaBan,HinhAnh,Ghichu  from SanPham,LoaiSanPham where sanpham.MaLoaiSP=LoaiSanPham.MaLoaiSP and MaSp=?;";
//        String sql = "SELECT * FROM SanPham WHERE MaSp=?";
        List<SanPham> list = selectBySQL(sql, id);
        return list.size() > 0 ? list.get(0) : null;
    }

    @Override
    protected List<SanPham> selectBySQL(String sql, Object... args) {
        List<SanPham> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = XJDBC.query(sql, args);
                while (rs.next()) {
                    SanPham entity = new SanPham();
                    entity.setMaSP(rs.getString("MaSP"));
                    entity.setTenSP(rs.getString("TenSp"));
                    entity.setTenLoai(rs.getString("TenLoaiSanPham"));
                    entity.setGiaBan(rs.getFloat("GiaBan"));
                    entity.setKichThuoc(rs.getInt("Size"));
                    entity.setImage(rs.getString("HinhAnh"));
                    entity.setChuThich(rs.getString("GhiChu"));
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
