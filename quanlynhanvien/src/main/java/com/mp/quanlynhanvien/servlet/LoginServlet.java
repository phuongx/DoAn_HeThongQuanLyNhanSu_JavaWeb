/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mp.quanlynhanvien.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Connection;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;

import com.mp.quanlynhanvien.beans.UserAccount;
import com.mp.quanlynhanvien.utils.DBUtils;
import com.mp.quanlynhanvien.utils.StorageUtils;
import javax.servlet.http.HttpSession;
import org.apache.commons.codec.digest.DigestUtils;
import java.security.NoSuchAlgorithmException;

public class LoginServlet extends HttpServlet {

    
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        
        RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/WEB-INF/views/loginView.jsp");
        dispatcher.forward(request, response);
    }
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        
        String maNV = request.getParameter("maNV");
        String pass = request.getParameter("password");
        String rememberMeStr = request.getParameter("rememberMe");
        boolean remember = "Y".equals(rememberMeStr);
        
        String password = DigestUtils.sha256Hex(pass);

        UserAccount user = null;
        boolean hasError = false;
        String errorString = null;
 
        if (maNV == null || password == null || maNV.length() == 0 || password.length() == 0) {
            hasError = true;
            errorString = "Required username and password!";
        } else {
            Connection conn = StorageUtils.getStoredConnection(request);
            try {
                // Tìm user trong DB.
                user = DBUtils.findUser(conn, maNV, password);
 
                if (user == null) {
                    hasError = true;
                    errorString = "Tên đăng nhập và mật khẩu không hợp lệ!";
                }
            } catch (SQLException e) {
                e.printStackTrace();
                hasError = true;
                errorString = e.getMessage();
            }
        }
        // Trong trường hợp có lỗi,
        // forward (chuyển hướng) tới /WEB-INF/views/login.jsp
        if (hasError) {
            user = new UserAccount();
            user.setMaNV(maNV);
            user.setPassword(password);
 
            // Lưu các thông tin vào request attribute trước khi forward.
            request.setAttribute("errorString", errorString);
            request.setAttribute("user", user);
 
            // Forward (Chuyển tiếp) tới trang /WEB-INF/views/login.jsp
            RequestDispatcher dispatcher //
                    = this.getServletContext().getRequestDispatcher("/WEB-INF/views/loginView.jsp");
 
            dispatcher.forward(request, response);
        }
        // Trường hợp không có lỗi.
        // Lưu thông tin người dùng vào Session.
        // Và chuyển hướng sang trang userInfo.
        else {
            
            
                HttpSession session = request.getSession();
                StorageUtils.storeLoginedUser(session, user);

                // Nếu người dùng chọn tính năng "Remember me".
                if (remember) {
                    StorageUtils.storeUserCookie(response, user);
                }
                // Ngược lại xóa Cookie
                else {
                    StorageUtils.deleteUserCookie(response);
                }
                request.setAttribute("user", user);
                // Redirect (Chuyển hướng) sang trang /viecDuocGiao.
                response.sendRedirect(request.getContextPath() + "/viecDuocGiao");
 
        }
    }

}
