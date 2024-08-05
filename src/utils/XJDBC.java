/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

import java.sql.*;

/**
 *
 * @author space
 */
public class XJDBC {

    public static ResultSet querryAll(String sql) {
        try {
            return getConnection().createStatement().executeQuery(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static PreparedStatement pre(String sql, Object... args) {
        try {
//            getConnection();
            PreparedStatement preSta = null;
            // Kiểm tra xem câu sql đó có phải thực thi proc trong sql kh
            // nếu có { thì là proc
            if (sql.trim().startsWith("{")) {
                preSta = getConnection().prepareCall(sql);
            } else {
                preSta = getConnection().prepareStatement(sql);
            }
            for (int i = 0; i < args.length; i++) {
                preSta.setObject(i+1, args[i]);
            }
            return preSta;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void update(String sql, Object... args) {
        try {
            getConnection();
            PreparedStatement stmt = XJDBC.pre(sql, args);
            try {
                stmt.executeUpdate();
            } finally {
                stmt.getConnection().close();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static ResultSet query(String sql, Object...args) {
        try {
            PreparedStatement stmt = XJDBC.pre(sql, args);
            return stmt.executeQuery();
        } 
        catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public static Object value(String sql, Object... args) {
        try {
            getConnection();
            ResultSet rs = XJDBC.query(sql, args);
            if (rs.next()) {
                return rs.getObject(0);
            }
            rs.getStatement().getConnection().close();
            return null;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static Connection getConnection() {
        try {
            String URL = "jdbc:sqlserver://localhost:1433;databaseName=DuAn1_Polyy;username=sa;password=12345;encrypt=false";
           // String URL = "jdbc:sqlserver://localhost;databaseName=LAB5_JAVA3;username=sa;password=080304;encrypt=false";
            return DriverManager.getConnection(URL);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
