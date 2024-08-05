/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

import Entity.NhanVien;

/**
 *
 * @author space
 */
public class Auth {
    public static NhanVien user = null;
    public static boolean check = false;
    
    public static void clear()
    {
        Auth.user = null;
    }
    
    public static boolean checkLogin()
    {
        return Auth.check = true;
    }
    
    public static boolean isLogin()
    {
        return Auth.user != null;
    }
    public static boolean isManager()
    {
        return Auth.isLogin() && user.isVaiTro();
    }
}
