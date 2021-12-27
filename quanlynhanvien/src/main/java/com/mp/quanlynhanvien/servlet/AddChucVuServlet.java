
package com.mp.quanlynhanvien.servlet;

import com.mp.quanlynhanvien.beans.ViTri;
import com.mp.quanlynhanvien.beans.UserAccount;
import com.mp.quanlynhanvien.utils.AutoFillUtils;
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

/**
 *
 * @author Ms Phuong
 */
public class AddChucVuServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        
        //ktra dang nhap
        HttpSession session = request.getSession();
        UserAccount loginedUser = StorageUtils.getLoginedUser(session);
        String errorString = null;
        
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
        
        //tu dong dien
        Connection conn = StorageUtils.getStoredConnection(request);
        String maVT = AutoFillUtils.getMaVT(conn);
        ViTri vitri = new ViTri(maVT,null);
        //luu thong tin vao request
        request.setAttribute("vitri", vitri);
        request.setAttribute("errorString",errorString);
        //chuyen sang trang addThanhTichView
        RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/WEB-INF/views/addChucVuView.jsp");
        dispatcher.forward(request, response);
    }
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        
        String errorString = null;
        String maVT = request.getParameter("maVT");
        String tenVT = request.getParameter("tenVT");
        ViTri vitri = new ViTri (maVT, tenVT);

        Connection conn = StorageUtils.getStoredConnection(request);
        
        
        try{
            DBUtils.insertViTri(conn, vitri);
        } catch (SQLException e){
            e.printStackTrace();
            errorString = "Loi du lieu";
        }
        if (errorString != null){
            
            request.setAttribute("errorString", errorString);
            request.setAttribute("vitri", vitri);
            RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/WEB-INF/views/dmChucVuView.jsp");
            dispatcher.forward(request, response);
            return;
        }
        
        //neu khong co loi
        
        response.sendRedirect(request.getContextPath()+"/chucvu/list");
    }


}
