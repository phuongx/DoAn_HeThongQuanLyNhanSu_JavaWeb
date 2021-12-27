
package com.mp.quanlynhanvien.servlet;
import com.mp.quanlynhanvien.beans.UserAccount;
import com.mp.quanlynhanvien.utils.DBUtils;
import com.mp.quanlynhanvien.utils.StorageUtils;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Connection;
import java.sql.SQLException;
import javax.servlet.http.HttpSession;

public class DanhDauHT_CVServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        
        HttpSession session = request.getSession();
        UserAccount logined = StorageUtils.getLoginedUser(session);
        String errorString = null;
        String maCV = request.getParameter("maCV");
        String maNV = logined.getMaNV();
        System.out.println("maNV="+maNV+" maCV="+maCV);

        Connection conn = StorageUtils.getStoredConnection(request);
        
        boolean check;
        try {
            check = DBUtils.updateTrangThaiCV(conn, maCV, maNV);
        } catch (SQLException e){
            errorString = "Đã có lỗi xảy ra.";
            e.printStackTrace();
        }
        if (check = false ) {
            errorString  = "Yêu cầu không hợp lệ.";
            request.setAttribute("errorString", errorString);
            request.getRequestDispatcher("/WEB-INF/views/errorView.jsp").forward(request, response);
            return;
        }
        response.sendRedirect(request.getContextPath()+"/viec/list");

    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       doGet(request, response);
    }

}
