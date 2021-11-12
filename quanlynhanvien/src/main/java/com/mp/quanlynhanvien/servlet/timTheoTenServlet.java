
package com.mp.quanlynhanvien.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.ArrayList;

import com.mp.quanlynhanvien.beans.UserAccount;
import com.mp.quanlynhanvien.utils.StorageUtils;
import com.mp.quanlynhanvien.utils.DBUtils;
import java.sql.Connection;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpSession;
public class timTheoTenServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        String errorString1  = null;
        
        //ktra dang nhap
        HttpSession session = request.getSession();
        UserAccount user = StorageUtils.getLoginedUser(session);
        if (user == null){
            response.sendRedirect(request.getContextPath()+"/login");
            return;
        } 
        
        //ktra quyen: chi co admin
        int quyenUser = StorageUtils.getQuyenUser(session);
        if (quyenUser == 2 ){
            errorString1 = "Quyền truy cập thất bại..";
            request.setAttribute("errorString", errorString1);
            RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/WEB-INF/views/errorView.jsp");
            dispatcher.forward(request, response);
            return;
        }
        
        
        String ten = request.getParameter("ten");
        String trangthai = "Hoat dong";
        Connection conn = StorageUtils.getStoredConnection(request);
        List<UserAccount> list = new ArrayList<UserAccount>();
        try{
            list = DBUtils.findUsers(conn, ten, trangthai);
        } catch (SQLException e){
            e.printStackTrace();
            errorString1 = "Loi.";
        }
        request.setAttribute("sodong", list.size());
        request.setAttribute("list", list);
        request.setAttribute("errorString1", errorString1);
        request.getRequestDispatcher("/WEB-INF/views/timTheoTen.jsp").forward(request, response);
  
    }
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}
