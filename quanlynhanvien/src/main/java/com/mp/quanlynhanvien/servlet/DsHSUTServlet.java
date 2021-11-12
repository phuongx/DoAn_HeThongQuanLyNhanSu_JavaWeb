
package com.mp.quanlynhanvien.servlet;

import com.mp.quanlynhanvien.beans.UserAccount;
import com.mp.quanlynhanvien.beans.HSUngTuyen;
import com.mp.quanlynhanvien.utils.DBUtils;
import com.mp.quanlynhanvien.utils.StorageUtils;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpSession;

        
/**
 *
 * @author Ms Phuong
 */
public class DsHSUTServlet extends HttpServlet {

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
        
        // xu ly
        //String trangthai = request.getParameter("trangthai");
        Connection conn = StorageUtils.getStoredConnection(request);
        
        List <HSUngTuyen> list = new ArrayList<HSUngTuyen>();
        try{
            list = DBUtils.dsHSUT(conn,"Chua duyet");
        } catch (SQLException e){
            e.printStackTrace();
            errorString = e.getMessage();
        }
        
        // luu thong tin vao request
        request.setAttribute("sodong", list.size());
        request.setAttribute("trangthai", "Chua duyet");
        request.setAttribute("list", list);
        request.setAttribute("errorString", errorString);
        //chuyen huong
        request.getRequestDispatcher("/WEB-INF/views/dsHSUTView.jsp").forward(request, response);
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        
        String trangthai = request.getParameter("trangthai");
        System.out.println(trangthai);
        Connection conn = StorageUtils.getStoredConnection(request);
        String errorString = null;
        List <HSUngTuyen> list = new ArrayList<HSUngTuyen>();
        try{
            list = DBUtils.dsHSUT(conn,trangthai);
        } catch (SQLException e){
            e.printStackTrace();
            errorString = e.getMessage();
        }
        
        // luu thong tin vao request
        request.setAttribute("sodong", list.size());
        request.setAttribute("trangthai", trangthai);
        request.setAttribute("list", list);
        request.setAttribute("errorString", errorString);
        //chuyen huong
        request.getRequestDispatcher("/WEB-INF/views/dsHSUTView.jsp").forward(request, response);
        
    }

}
