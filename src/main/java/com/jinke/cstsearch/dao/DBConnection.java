package com.jinke.cstsearch.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    public Connection conn;
    private String dbType;
    private String status;

    public DBConnection() {
        status = "disconnected";
    }


    public void getConnection(String url, String username, String password, String dbType) {
        String driverName = "";
        try {
            if ("oracle".equals(dbType)) {
                driverName = "oracle.jdbc.driver.OracleDriver";
            }
            if ("sql server".equals(dbType)) {
                driverName = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
            }
            System.out.println("开始连接" + dbType + "数据库");
            Class.forName(driverName);
            conn = DriverManager.getConnection(url, username, password);
            status = "connected";
            System.out.println("连接成功！");
        } catch (Exception e) {
            System.out.println("出错:\n" + e);
        }
    }

    public void closeConnection() {
        try {
            conn.close();
            status = "disconnected";
            System.out.println("成功关闭数据库");
        } catch (SQLException sqle) {
            System.out.println("关闭数据库连接出错");
        }
    }

    public String getStatus() {
        return status;
    }
}
