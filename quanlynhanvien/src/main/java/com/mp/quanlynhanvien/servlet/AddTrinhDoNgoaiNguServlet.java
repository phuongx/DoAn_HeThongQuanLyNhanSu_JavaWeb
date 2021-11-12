
package com.mp.quanlynhanvien.servlet;

import com.mp.quanlynhanvien.beans.TrinhDoNgoaiNgu;
import com.mp.quanlynhanvien.beans.UserAccount;
import com.mp.quanlynhanvien.utils.DBUtils;
import com.mp.quanlynhanvien.utils.StorageUtils;
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

public class AddTrinhDoNgoaiNguServlet extends HttpServlet {

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
            request.getRequestDispatcher("/WEB-INF/views/loginView.jsp").forward(request, response);
            return;
        }
        
        //ktra quyen: chi co admin
        int quyenUser = StorageUtils.getQuyenUser(session);
        if (quyenUser == 2 ){
            errorString = "Quyền truy cập thất bại..";
            request.setAttribute("errorString", errorString);
            request.getRequestDispatcher("/WEB-INF/views/errorView.jsp").forward(request, response);
            return;
        }
        
        //tu dong dien
        Connection conn = StorageUtils.getStoredConnection(request);
        
        request.setAttribute("errorString",errorString);
        //chuyen sang trang addThanhTichView
        RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/WEB-INF/views/addTDNgoaiNguView.jsp");
        dispatcher.forward(request, response);
    }
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        
        String errorString = null;
        String ngonngu = request.getParameter("ngonngu");
        String ten = request.getParameter("ten");
        TrinhDoNgoaiNgu trinhdo = new TrinhDoNgoaiNgu(0, ngonngu, ten);

        Connection conn = StorageUtils.getStoredConnection(request);
        
        
        try{
            DBUtils.insertTrinhDoNgoaiNgu(conn, trinhdo);
        } catch (SQLException e){
            e.printStackTrace();
            errorString = "Loi du lieu";
        }
        if (errorString != null){
            
            request.setAttribute("errorString", errorString);
            request.setAttribute("trinhdo", trinhdo);
            RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/WEB-INF/views/dmTrinhDoNgoaiNguView.jsp");
            dispatcher.forward(request, response);
            return;
        }
        
        //neu khong co loi
        
        response.sendRedirect(request.getContextPath()+"/trinhdongoaingu");
    }
}
