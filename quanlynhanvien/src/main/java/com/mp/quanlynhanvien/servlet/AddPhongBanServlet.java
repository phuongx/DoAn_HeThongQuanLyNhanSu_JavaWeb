
package com.mp.quanlynhanvien.servlet;

import com.mp.quanlynhanvien.beans.PhongBan;
import com.mp.quanlynhanvien.beans.UserAccount;
import com.mp.quanlynhanvien.utils.DBUtils;
import com.mp.quanlynhanvien.utils.StorageUtils;
import com.mp.quanlynhanvien.utils.AutoFillUtils;

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
public class AddPhongBanServlet extends HttpServlet {

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
        
        //tu dong dien
        Connection conn = StorageUtils.getStoredConnection(request);
        String maPB = AutoFillUtils.getMaPB(conn);
        PhongBan phongban = new PhongBan(maPB,null);
        //luu thong tin vao request
        request.setAttribute("phongban", phongban);
        request.setAttribute("errorString",errorString);
        //chuyen sang trang addThanhTichView
        RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/WEB-INF/views/addPhongBanView.jsp");
        dispatcher.forward(request, response);
    }
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        
        String errorString = null;
        String maPB = request.getParameter("maPB");
        String tenPB = request.getParameter("tenPB");
        PhongBan phongban = new PhongBan(maPB, tenPB);
        System.out.println(tenPB+"    "+ maPB);
        //ktra du lieu
        
        if (maPB.equals("") || tenPB.equals("")){
            errorString = "Cac truong du lieu trong";
            request.setAttribute("errorString",errorString);
            request.setAttribute("phongban", phongban);
            RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/WEB-INF/views/addPhongBanView.jsp");
            dispatcher.forward(request, response);
        }
        
        Connection conn = StorageUtils.getStoredConnection(request);
        
        
        try{
            DBUtils.insertPhongBan(conn, phongban);
        } catch (SQLException e){
            e.printStackTrace();
            errorString = "Loi du lieu";
        }
        if (errorString != null){
            
            request.setAttribute("errorString", errorString);
            request.setAttribute("phongban", phongban);
            RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/WEB-INF/views/addPhongBanView.jsp");
            dispatcher.forward(request, response);
            return;
        }
        
        //neu khong co loi
        
        response.sendRedirect(request.getContextPath()+"/dsPhongBan");
    }
}
