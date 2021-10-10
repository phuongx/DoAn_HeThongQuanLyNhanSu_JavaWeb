
package com.mp.quanlynhanvien.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.Connection;
import java.sql.SQLException;

import com.mp.quanlynhanvien.beans.UserAccount;
import com.mp.quanlynhanvien.utils.DBUtils;
import com.mp.quanlynhanvien.utils.StorageUtils;
/**
 *
 * @author Ms Phuong
 */
public class DanhSachNVServlet extends HttpServlet {

    public DanhSachNVServlet(){
        
    }
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        
        //ktra dang nhap
        HttpSession session = request.getSession();
        UserAccount user = StorageUtils.getLoginedUser(session);
        if (user == null){
            response.sendRedirect(request.getContextPath()+"/login");
            return;
        } 
        
        // Ai cung co the truy cap
        // Xac dinh pham vi co the thao tac voi du lieu 
        String role = null;
        if (user.getTenVT().equals("Admin") == true ||  
                user.getTenVT().equals("Quan ly") == true){
            role = "yes";
            
        }
        request.setAttribute("role", role);
        
        // xu ly
        String trangthai = null;
        trangthai = request.getParameter("trangthai");
        if (trangthai == null) trangthai = "Hoat dong";
        System.out.println(trangthai);
        Connection conn = StorageUtils.getStoredConnection(request);
        String errorString = null;
        List <UserAccount> list = new ArrayList<UserAccount>();
        try{
            list = DBUtils.dsNhanVien(conn,trangthai);
        } catch (SQLException e){
            e.printStackTrace();
            errorString = e.getMessage();
        }
        
        // luu thong tin vao request
        request.setAttribute("trangthai", trangthai);
        request.setAttribute("list", list);
        request.setAttribute("errorString", errorString);
        //chuyen huong
        RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/WEB-INF/views/danhSachNVView.jsp");
        dispatcher.forward(request, response);
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

}
