
package com.mp.quanlynhanvien.servlet;

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


public class ThayDoiQuyen extends HttpServlet {
protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        
        HttpSession session = request.getSession();
        UserAccount loginedUser = StorageUtils.getLoginedUser(session);
        
        String errorString = null;
        int quyenUser = StorageUtils.getQuyenUser(session);
        if (loginedUser == null){
            response.sendRedirect(request.getContextPath()+"/login");
            return;
        } 
        //ktra quyen: chi co admin
        if (quyenUser == 2 ){
            errorString = "Quyền truy cập thất bại.";
            request.setAttribute("errorString", errorString);
            RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/WEB-INF/views/errorView.jsp");
            dispatcher.forward(request, response);
            return;
        }
        String id = request.getParameter("id");
        Connection conn = StorageUtils.getStoredConnection(request);
        UserAccount user = new UserAccount();
        try {
            user = DBUtils.findUser(conn, id);
            if (user!= null){
                if (user.getQuyen()==1){
                    DBUtils.changeQuyen(conn, id, 2);
                } else if (user.getQuyen()==2){
                   DBUtils.changeQuyen(conn, id, 1); 
                }
            } else errorString = "Yêu cầu không hợp lệ.";
        } catch (SQLException e){
            errorString = "Đã có lỗi xảy ra.";
            e.printStackTrace();
        }
        if (errorString != null ) {
            request.setAttribute("errorString", errorString);
            request.getRequestDispatcher("/WEB-INF/views/qlyQuyenView.jsp").forward(request, response);
            return;
        }
        response.sendRedirect(request.getContextPath()+"/qlyquyen");

    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       doGet(request, response);
    }

}
