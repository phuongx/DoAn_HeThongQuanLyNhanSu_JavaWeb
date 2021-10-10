/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mp.quanlynhanvien.filter;

import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.sql.Connection;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import com.mp.quanlynhanvien.conn.ConnectionUtils;
import com.mp.quanlynhanvien.utils.StorageUtils;
/**
 *
 * @author Ms Phuong
 */
public class JDBCFilter implements Filter {
    
   
    
    public JDBCFilter() {
    }    
    @Override
    public void init(FilterConfig fConfig) throws ServletException {
 
    }
 
    @Override
    public void destroy() {
 
    }
    
    public void doFilter(ServletRequest request, ServletResponse response,FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        System.out.println("JDBC Filter");
        System.out.println("Open Connection for: " + req.getServletPath());
 
            Connection conn = null;
            try {
                // Tạo đối tượng Connection kết nối database.
                conn = ConnectionUtils.getConnection();
                // Sét tự động commit false, để chủ động điều khiển.
                conn.setAutoCommit(false);
 
                // Lưu trữ đối tượng Connection vào attribute của request.
                StorageUtils.storeConnection(request, conn);
 
                // Cho phép request đi tiếp.
                // (Đi tới Filter tiếp theo hoặc đi tới mục tiêu).
                chain.doFilter(request, response);
 
                // Gọi phương thức commit() để hoàn thành giao dịch với DB.
                conn.commit();
            } catch (Exception e) {
                e.printStackTrace();
                ConnectionUtils.rollbackQuietly(conn);
                //throw new ServletException();
            } finally {
                ConnectionUtils.closeQuietly(conn);
            }
        
    }

    
}
