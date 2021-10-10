
package com.mp.quanlynhanvien.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Connection;
import java.sql.SQLException;

import com.mp.quanlynhanvien.beans.UserAccount;
import com.mp.quanlynhanvien.utils.StorageUtils;
import com.mp.quanlynhanvien.utils.DBUtils;
public class TimNVServlet extends HttpServlet {

    
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        
        String errorString1  = null;
        String maNV = request.getParameter("maNV");
        UserAccount user = new UserAccount();
        if (maNV.equals("")){
            
            errorString1 = "Ban can dien ma so.";
            request.setAttribute("errorString1", errorString1);
            request.getRequestDispatcher("/WEB-INF/views/timNVView.jsp").forward(request, response);
            return;
        }
        Connection conn = StorageUtils.getStoredConnection(request);
        
        try{
            user = DBUtils.findUser(conn, maNV);
        } catch (SQLException e){
            e.printStackTrace();
            errorString1 = "Loi.";
        }
        if (user == null){
            errorString1 = "Khong tim thay thong tin.";
        }
        request.setAttribute("user", user);
        request.setAttribute("errorString1", errorString1);
        request.getRequestDispatcher("/WEB-INF/views/timNVView.jsp").forward(request, response);
  
    }
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
    
}
