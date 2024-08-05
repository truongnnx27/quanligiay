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
import javax.swing.Action;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import utils.Auth;
import utils.MsgBox;

/**
 *
 * @author XUAN TRUONG
 */
public class doiMatKhau extends JFrame {

    Container container;
    JButton btnDoiMK, btnThoat;
    JTextField txtMKCu, txtMKMoi, txtXacNhanMK;
    NhanVienDAO nvDao = new NhanVienDAO();

    public doiMatKhau() {
        doimk();
        chucnang();
    }

    public void doimk() {
        container = getContentPane();
        setTitle("ĐỔI MẬT KHẨU");
        setSize(500, 300);
        setLayout(null);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //set logo cho phần setitle
        ImageIcon image = new ImageIcon("D:\\fpoly\\duann1\\src\\img\\nike.png");
        setIconImage(image.getImage());

        JLabel lblDoiMK = new JLabel("ĐỔI MẬT KHẨU");
        lblDoiMK.setBounds(170, 10, 200, 50);
        Font font = new Font("times new roman", Font.BOLD, 20);
        lblDoiMK.setFont(font);
        lblDoiMK.setForeground(Color.BLUE);
        JLabel lblMkCu = new JLabel("Mật khẩu cũ:");
        lblMkCu.setBounds(30, 60, 100, 25);
        txtMKCu = new JTextField();
        txtMKCu.setBounds(150, 60, 300, 30);
        JLabel lblMKMoi = new JLabel("Mật khẩu mới:");
        lblMKMoi.setBounds(30, 120, 100, 25);
        txtMKMoi = new JTextField();
        txtMKMoi.setBounds(150, 120, 300, 30);
        JLabel lblXNMK = new JLabel("Xác nhận mật khẩu:");
        lblXNMK.setBounds(30, 180, 180, 25);
        txtXacNhanMK = new JTextField();
        txtXacNhanMK.setBounds(150, 180, 300, 30);
        btnDoiMK = new JButton("Đổi mật khẩu");
        btnDoiMK.setBounds(150, 230, 130, 30);
        btnDoiMK.setBackground(Color.YELLOW);
        btnThoat = new JButton("Thoát");
        btnThoat.setBounds(320, 230, 130, 30);
        btnThoat.setBackground(Color.YELLOW);

        container.add(lblDoiMK);
        container.add(lblMkCu);
        container.add(txtMKCu);
        container.add(lblMKMoi);
        container.add(txtMKMoi);
        container.add(lblXNMK);
        container.add(txtXacNhanMK);
        container.add(btnDoiMK);
        container.add(btnThoat);
        setVisible(true);
    }

    public void chucnang() {
        btnDoiMK.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String matKhau = String.valueOf(txtMKCu.getText());
                String mkMoi = String.valueOf(txtMKMoi.getText());
                String XacNhanMK = String.valueOf(txtXacNhanMK.getText());
                if (!matKhau.equalsIgnoreCase(Auth.user.getMatKhau())) {
                    MsgBox.alert(container, "Sai mật khẩu hiện tại!");
                } 
                else if (!mkMoi.equals(XacNhanMK)) {
                    MsgBox.alert(container, "Mật khẩu không khớp");
                } else {
                    Auth.user.setMatKhau(mkMoi);
                    nvDao.update(Auth.user);
                    MsgBox.alert(container, "Thay đổi mật khẩu thành công");
                    dispose();
                    
                }
            }
        });
        btnThoat.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                huyBo();
            }
        });
    }
    private void huyBo()
    {
        this.dispose();;
    }

    public static void main(String[] args) {
        doiMatKhau mk = new doiMatKhau();
    }
}
