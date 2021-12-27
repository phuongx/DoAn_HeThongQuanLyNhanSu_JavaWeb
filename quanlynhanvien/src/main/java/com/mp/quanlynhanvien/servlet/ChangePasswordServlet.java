
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
import org.apache.commons.codec.digest.DigestUtils;


public class ChangePasswordServlet extends HttpServlet {

   protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        
        //ktra dang nhap
        HttpSession session = request.getSession();
        UserAccount loginedUser = StorageUtils.getLoginedUser(session);
        int quyenUser = StorageUtils.getQuyenUser(session);
        String errorString = null;
        
        if (loginedUser == null){
            errorString = "Ban chua dang nhap.";
            request.setAttribute("errorString", errorString);
            
            request.getRequestDispatcher("/WEB-INF/views/loginView.jsp").forward(request, response);
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
        String old_pass = request.getParameter("oldpass");
        String new_pass = request.getParameter("password");
        String hpass_old = DigestUtils.sha256Hex(old_pass);
        String hpass = DigestUtils.sha256Hex(new_pass);
        System.out.println("POST "+maNV);
        
        Connection conn = StorageUtils.getStoredConnection(request);
        //ktra
        HttpSession session = request.getSession();
        UserAccount loginedUser = StorageUtils.getLoginedUser(session);
        int quyenUser = StorageUtils.getQuyenUser(session);
        if (maNV.equals(loginedUser.getMaNV())==false){
            errorString = "Yêu cầu bị từ chối.";
            request.setAttribute("errorString", errorString);
            request.getRequestDispatcher("/WEB-INF/views/errorView.jsp").forward(request, response);
            return;
        }
        if (quyenUser == 2 && maNV.equals(loginedUser.getMaNV())){
            try{
               UserAccount user = DBUtils.findUser(conn, maNV, hpass_old);
               if (user == null){
                   errorString = "Mật khẩu cũ không đúng.";
               }       
            } catch (SQLException e){
                e.printStackTrace();
                errorString = "Lỗi dữ liệu.";
            }
        }
        if (errorString != null){
            request.setAttribute("errorString", errorString);
            request.setAttribute("user", loginedUser);
            request.getRequestDispatcher("/WEB-INF/views/editTTNVView.jsp").forward(request, response);
            return;
        }
        try{
            DBUtils.changePassword(conn, maNV, hpass);
         } catch (SQLException e){
             e.printStackTrace();
             errorString = "Lỗi dữ liệu.";
         }
        //neu khong co loi
        String thongbao = "Thay đổi mật khẩu thành công.";
        request.setAttribute("thongbao", thongbao);
        request.getRequestDispatcher("/WEB-INF/views/thongBao01.jsp").forward(request, response);
    }

}
