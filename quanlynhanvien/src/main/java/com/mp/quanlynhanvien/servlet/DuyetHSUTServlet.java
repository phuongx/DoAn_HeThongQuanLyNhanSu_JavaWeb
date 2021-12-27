package com.mp.quanlynhanvien.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Connection;
import java.sql.SQLException;

import com.mp.quanlynhanvien.beans.HSUngTuyen;
import com.mp.quanlynhanvien.beans.UserAccount;
import com.mp.quanlynhanvien.utils.DBUtils;
import com.mp.quanlynhanvien.utils.StorageUtils;
import javax.servlet.http.HttpSession;
public class DuyetHSUTServlet extends HttpServlet {


    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        
        //ktra dang nhap
        HttpSession session = request.getSession();
        String errorString = null;
        UserAccount loginedUser = StorageUtils.getLoginedUser(session);
        if (loginedUser == null){
            errorString = "Bạn chưa đăng nhập..";
            request.setAttribute("errorString", errorString);
            request.getRequestDispatcher("/WEB-INF/views/loginView.jsp").forward(request, response);
            return;
        }
        
        //ktra quyen: chi co admin
        int quyenUser = StorageUtils.getQuyenUser(session);
        if (quyenUser == 2 ){
            errorString = "Quyền truy cập thất bại..";
            request.setAttribute("errorString", errorString);
            request.getRequestDispatcher("/WEB-INF/views/errorView.jsp").forward(request, response);
            return;
        }
        System.out.println("call get");
        String maHS = request.getParameter("maHS");
        request.setAttribute("maHS", maHS);
        errorString  = "Yêu cầu không hợp lệ.";
        request.getRequestDispatcher("/WEB-INF/views/duyetHSUTView.jsp").forward(request, response);
        
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        
        System.out.println("call post");
        String errorString = null;
        String maHS = request.getParameter("maHS");
        String ketqua = request.getParameter("ketqua");
        String ngay = request.getParameter("ngay");
        Connection conn = StorageUtils.getStoredConnection(request);
        HSUngTuyen hoso = new HSUngTuyen();
        try{
            hoso = DBUtils.findHSUT(conn, maHS);
            hoso.setKetqua(ketqua);
            hoso.setNgayduyet(ngay);
            DBUtils.updateTrangThaiHSUT(conn, hoso);
        } catch (SQLException e){
            e.printStackTrace();
            errorString = "Yêu cầu không hợp lệ.";
        }
        if (ketqua.equals("Pass"))
            response.sendRedirect(request.getContextPath()+"/nv/add");
        else response.sendRedirect(request.getContextPath()+"/hsut/list");
    }

}
