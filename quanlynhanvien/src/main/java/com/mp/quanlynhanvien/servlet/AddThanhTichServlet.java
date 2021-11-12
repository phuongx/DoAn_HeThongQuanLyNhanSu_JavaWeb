/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mp.quanlynhanvien.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.Connection;
import java.sql.SQLException;

import com.mp.quanlynhanvien.beans.UserAccount;
import com.mp.quanlynhanvien.beans.ThanhTich;
import com.mp.quanlynhanvien.utils.DBUtils;
import com.mp.quanlynhanvien.utils.StorageUtils;

/**
 *
 * @author Ms Phuong
 */
public class AddThanhTichServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        
        //ktra dang nhap
        HttpSession session = request.getSession();
        UserAccount loginedUser = StorageUtils.getLoginedUser(session);
        String errorString = null;
        if (loginedUser == null){
            errorString = "Bạn chưa đăng nhập..";
            request.setAttribute("errorString", errorString);
            RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/WEB-INF/views/loginView.jsp");
            dispatcher.forward(request, response);
            return;
        }
        
        //ktra quyen: chi co admin
        int quyenUser = StorageUtils.getQuyenUser(session);
        if (quyenUser == 2 ){
            errorString = "Quyền truy cập thất bại..";
            request.setAttribute("errorString", errorString);
            RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/WEB-INF/views/errorView.jsp");
            dispatcher.forward(request, response);
            return;
        }
        
        //ktra user ton tai 
        String maNV = request.getParameter("maNV"); //lay maNV dc gui ve
        UserAccount user = new UserAccount();
        Connection conn = StorageUtils.getStoredConnection(request);
        try{
            user = DBUtils.findUser(conn, maNV);
            if (user == null){
                errorString = "Ma nhan vien khong ton tai.";
                request.setAttribute("errorString", errorString);
                RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/WEB-INF/views/danhSachNVView.jsp");
                dispatcher.forward(request, response);
                return;
            }

        } catch (SQLException e){
            e.printStackTrace();
            errorString = e.getMessage();
        }
        
        //xu ly
        //luu thong tin vao request
        request.setAttribute("user", user);
        request.setAttribute("errorString",errorString);
        //chuyen sang trang addThanhTichView
        RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/WEB-INF/views/addThanhTichView.jsp");
        dispatcher.forward(request, response);
    }
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        
        String maNV = request.getParameter("maNV");
        String noidung = request.getParameter("noidung");
        String ngay = request.getParameter("ngay");
        
        Connection conn = StorageUtils.getStoredConnection(request);
        ThanhTich thanhtich = new ThanhTich(maNV,noidung,ngay);
        String errorString = null;
        try{
            DBUtils.insertThanhTich(conn, thanhtich);
        } catch (SQLException e){
            e.printStackTrace();
            errorString = e.getMessage();
        }
        if (errorString != null){
            request.setAttribute("errorString", errorString);
            RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/WEB-INF/views/addThanhTichView.jsp");
            dispatcher.forward(request, response);
            return;
        }
        
        //neu khong co loi
        request.setAttribute("errorString", errorString);
        response.sendRedirect(request.getContextPath()+"/thongTinNV?maNV="+maNV);
    }
}
