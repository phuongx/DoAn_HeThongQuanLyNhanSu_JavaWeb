
package com.mp.quanlynhanvien.servlet;

import com.mp.quanlynhanvien.beans.UserAccount;
import com.mp.quanlynhanvien.utils.StorageUtils;
import com.mp.quanlynhanvien.beans.CongViec;
import com.mp.quanlynhanvien.utils.DBUtils;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.SQLException;
public class DsViecLamServlet extends HttpServlet {

    
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        
        //ktra dang nhap
        HttpSession session = request.getSession();
        UserAccount loginedUser = StorageUtils.getLoginedUser(session);
        String errorString = null;
        
        if (loginedUser == null){
            errorString = "Ban chua dang nhap.";
            request.setAttribute("errorString", errorString);
            
            request.getRequestDispatcher("/WEB-INF/views/loginView.jsp").forward(request, response);
            return;
        }
        Connection conn = StorageUtils.getStoredConnection(request);
        String trangthai = request.getParameter("trangthai");
        if (trangthai == null || trangthai.equals("")){
            trangthai = "Chua hoan thanh";
        }
        System.out.println(trangthai);
        List<CongViec> list = new ArrayList<CongViec>();
        try {
            list = DBUtils.getCongViec(conn, loginedUser.getMaNV(), trangthai);
        } catch (SQLException e){
            e.printStackTrace();
            errorString = "Loi xu ly du lieu.";
        }
        if (errorString != null){
            request.setAttribute("errorString", errorString);
            request.getRequestDispatcher("/WEB-INF/views/errorView.jsp").forward(request, response);
            return;
        }
        request.setAttribute("trangthai", trangthai);
        request.setAttribute("list", list);
        request.setAttribute("errorString", errorString);
        request.getRequestDispatcher("/WEB-INF/views/dsCongViecView.jsp").forward(request, response);
        
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

}
