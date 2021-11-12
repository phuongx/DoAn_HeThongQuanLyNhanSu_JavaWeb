
package com.mp.quanlynhanvien.servlet;

import com.mp.quanlynhanvien.beans.PhongBan;
import com.mp.quanlynhanvien.beans.UserAccount;
import com.mp.quanlynhanvien.utils.DBUtils;
import com.mp.quanlynhanvien.utils.StorageUtils;

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



/**
 *
 * @author Ms Phuong
 */
public class DSPhongBanServlet extends HttpServlet {

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
        
        
        // xu ly
        Connection conn = StorageUtils.getStoredConnection(request);
        String errorString = null;
        List <PhongBan> list = new ArrayList<PhongBan>();
        try{
            list = DBUtils.dsPhongBan(conn);
        } catch (SQLException e){
            e.printStackTrace();
            errorString = e.getMessage();
        }
        // luu thong tin vao request
        request.setAttribute("sodong", list.size());
        request.setAttribute("list", list);
        request.setAttribute("errorString", errorString);
        //chuyen huong
        RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/WEB-INF/views/dmPhongBanView.jsp");
        dispatcher.forward(request, response);
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}
