/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Until;

import DAO.NhanVienDAO;
import Entity.NhanVien;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import utils.Auth;
import utils.MsgBox;

/**
 *
 * @author XUAN TRUONG
 */
public class dangnhap extends JFrame {

    Container container;
    JTextField txtTaiKhoan;
    JPasswordField matKhau;
    JCheckBox xemMatKhau;
    JButton btnDangNhap, btnThoat;
    JLabel quenMK;
    NhanVienDAO dao = new NhanVienDAO();

    public dangnhap() {
        giaodiendangnhap();
        ChucNang();
    }

    public void giaodiendangnhap() {
        container = getContentPane();
        container.setBackground(Color.white);
        setTitle("ĐĂNG NHẬP");
        setLayout(null);
        setSize(600, 350);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //set logo cho phần setitle
        ImageIcon image = new ImageIcon("D:\\fpoly\\duann1\\src\\img\\nike.png");
        setIconImage(image.getImage());

        JLabel logo3 = new JLabel(new ImageIcon("D:\\fpoly\\duann1\\src\\img\\jodan1.png"));
        logo3.setBounds(20, -10, 170, 70);
        JLabel duongke = new JLabel(new ImageIcon("D:\\fpoly\\duann1\\src\\img\\duongke.png"));
        duongke.setBounds(50, 60, 120, 2);
        JLabel nike3 = new JLabel("NIKE STORE");
        nike3.setBounds(70, 70, 100, 25);
        Font nikefont = new Font("Cooper Black", Font.BOLD, 12);
        nike3.setFont(nikefont);

        Font fontchu = new Font("times new roman", Font.BOLD, 23);
        JLabel anh = new JLabel(new ImageIcon("D:\\fpoly\\duann1\\src\\img\\nenDangNhap1.png"));
        anh.setBounds(10, 100, 200, 200);
        JLabel login = new JLabel("ĐĂNG NHẬP");
        login.setBounds(320, 10, 250, 40);
        login.setFont(fontchu);
        login.setForeground(Color.BLUE);

        Font fontchu1 = new Font("times new roman", Font.BOLD, 18);
        JLabel lbltaikhoan = new JLabel("Tài khoản:");
        lbltaikhoan.setBounds(250, 100, 100, 25);
        lbltaikhoan.setFont(fontchu1);
        txtTaiKhoan = new JTextField();
        txtTaiKhoan.setBounds(350, 100, 220, 30);
        JLabel lblMK = new JLabel("Mật khẩu:");
        lblMK.setFont(fontchu1);
        lblMK.setBounds(250, 180, 100, 25);
        matKhau = new JPasswordField();
        matKhau.setBounds(350, 180, 220, 30);
        xemMatKhau = new JCheckBox("Hiện mật khẩu?");
        xemMatKhau.setBounds(460, 220, 150, 30);
        xemMatKhau.setBackground(Color.WHITE);
        quenMK = new JLabel("Quên mật khẩu?");
        quenMK.setForeground(Color.BLUE);
        quenMK.setBounds(210, 260, 100, 30);
        btnDangNhap = new JButton("Đăng nhập", new ImageIcon("D:\\fpoly\\duann1\\src\\img\\dangnhap.png"));
        btnDangNhap.setBackground(Color.CYAN);
        btnDangNhap.setBounds(320, 260, 135, 35);
        btnThoat = new JButton("Thoát", new ImageIcon("D:\\fpoly\\duann1\\src\\img\\thoat.png"));
        btnThoat.setBackground(Color.CYAN);
        btnThoat.setBounds(460, 260, 120, 35);

        container.add(logo3);
        container.add(duongke);
        container.add(nike3);
        container.add(anh);
        container.add(login);
        container.add(lbltaikhoan);
        container.add(txtTaiKhoan);
        container.add(lblMK);
        container.add(matKhau);
        container.add(xemMatKhau);
        container.add(quenMK);
        container.add(btnDangNhap);
        container.add(btnThoat);

        setVisible(true);
    }

    public boolean login() {
        String user = txtTaiKhoan.getText();
        String pass = String.valueOf(matKhau.getPassword());
        NhanVien nv = dao.selectById(user);
        if (nv == null) {
            MsgBox.alert(container, "Sai tên đăng nhập!");
        } else if (!pass.equals(nv.getMatKhau())) {
            MsgBox.alert(container, "Sai mật khẩu!");
        } else {
            Auth.user = nv;
            MsgBox.alert(container, "Đăng nhập thành công! \nVai Trò: "
                    + String.valueOf(nv.isVaiTro() ? "Quản lí" : "Nhân viên") + "\nGiới tính: "
                    + String.valueOf(nv.isGioiTinh() ? "Nữ" : "Nam") + ""
                    + "\nTên:" + nv.getTenNV());
            dispose();
            return Auth.checkLogin();
        }
        return false;
    }

    public void ChucNang() {
        btnDangNhap.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (login() == true) {
                    trangchu tt = new trangchu();
                    tt.setVisible(true);
                    return;
                } else {
                    return;
                }
            }
        });
        btnThoat.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (MsgBox.confirm(container, "Bạn muốn kết thúc đăng nhập?")) {
                    System.exit(0);
                }
            }
        });
        xemMatKhau.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                matKhau.setEchoChar(xemMatKhau.isSelected() ? '\0' : '*');
            }
        });
    }

    public static void main(String[] args) {
        dangnhap dn = new dangnhap();
    }
}
