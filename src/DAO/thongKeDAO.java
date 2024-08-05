/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.util.ArrayList;
import java.util.List;
import utils.XJDBC;
import java.sql.*;

/**
 *
 * @author XUAN TRUONG
 */
public class thongKeDAO {

    private List<Object[]> getListOfArray(String sql, String[] cols, Object... args) {
        try {
            List<Object[]> list = new ArrayList<>();
            ResultSet rs = XJDBC.query(sql, args);
            while (rs.next()) {
                Object[] vals = new Object[cols.length];
                for (int i = 0; i < vals.length; i++) {
                    vals[i] = rs.getObject(cols[i]);
                }
                list.add(vals);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    public List<Object[]> getSanPhamTheoLoai()
    {
        String sql= "{CALL ThongKe_SanPhamTheoLoai}";
        String cols[]={"maloaisp","TenSp","SoLuongSanPham"};
        return this.getListOfArray(sql, cols);
    }
    public  List<Object[]> getThongKe_HoaDonTheoNhanVien()
    {
        String sql="{CALL ThongKe_HoaDonTheoNhanVien}";
        String cols[]={"manv","soluonghoadon"};
        return this.getListOfArray(sql, cols);
    }
    public List<Object[]> getThongKe_KhachHangThanhVien()
    {
        String sql= "{CALL ThongKe_KhachHangThanhVien}";
        String cols[]= {"soluongthanhvien"};
        return this.getListOfArray(sql, cols);
    }
    public List<Object[]> getThongKe_TongDoanhThu()
    {
        String sql= "{CALL ThongKe_TongDoanhThu}";
        String cols[]= {"tongdoanhthu"};
        return this.getListOfArray(sql, cols);
    }

}
