/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mp.quanlynhanvien.conn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Ms Phuong
 */
public class ConnectionUtils {
    public static Connection getConnection() 
              throws ClassNotFoundException, SQLException {
        return getMySQLConnection();
        
    }
     
    public static void closeQuietly(Connection conn) {
        try {
            conn.close();
        } catch (Exception e) {
        }
    }
 
    public static void rollbackQuietly(Connection conn) {
        try {
            conn.rollback();
        } catch (Exception e) {
        }
    }
    public static Connection getMySQLConnection()
    throws ClassNotFoundException, SQLException {
     
        String hostName = "localhost";
        String dbName = "quanly_nhanvien";
        String userName = "root";
        String password = "";
        Connection conn = null;
        
        Class.forName("com.mysql.jdbc.Driver");

        String connectionURL = "jdbc:mysql://" + hostName + ":3306/" + dbName;
        conn = DriverManager.getConnection(connectionURL, userName,password);
        
        return conn;
    }

    
}

