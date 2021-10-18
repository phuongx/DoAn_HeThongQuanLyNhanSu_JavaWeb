
package com.mp.quanlynhanvien.servlet;

import com.mp.quanlynhanvien.beans.PhongBan;
import com.mp.quanlynhanvien.beans.UserAccount;
import com.mp.quanlynhanvien.utils.DBUtils;
import com.mp.quanlynhanvien.utils.StorageUtils;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class ChangePasswordServlet extends HttpServlet {

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
        
        //ktra quyen: chi  admin moi co quyen truy cap
        if (loginedUser.getTenVT().equals("Admin") == false ){
            errorString = "Quyen truy cap that bai.";
            request.setAttribute("errorString", errorString);
            RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/WEB-INF/views/errorView.jsp");
            dispatcher.forward(request, response);
            return;
        }
        String maNV = request.getParameter("maNV");
        System.out.println("GET " +maNV);

        request.setAttribute("maNV",maNV);
        //chuyen sang changePassword
        RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/WEB-INF/views/changePassword.jsp");
        dispatcher.forward(request, response);
    }
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        
        String errorString = null;
        String maNV = request.getParameter("maNV");
        String password = request.getParameter("password");
        
        System.out.println("POST "+maNV);
        
        Connection conn = StorageUtils.getStoredConnection(request);

        try{
            DBUtils.changePassword(conn, maNV, password);
        } catch (SQLException e){
            e.printStackTrace();
            errorString = "Loi du lieu";
        }
        if (errorString != null){
            
            request.setAttribute("errorString", errorString);
            RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/WEB-INF/views/editTTNVView.jsp");
            dispatcher.forward(request, response);
            return;
        }
        
        //neu khong co loi
        String thongbao = "Thay đổi mật khẩu thành công.";
        request.setAttribute("thongbao", thongbao);
        request.getRequestDispatcher("/WEB-INF/views/thongBao01.jsp").forward(request, response);
    }

}
