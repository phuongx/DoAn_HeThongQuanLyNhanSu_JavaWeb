
package com.mp.quanlynhanvien.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mp.quanlynhanvien.beans.NVThoiViec;
import com.mp.quanlynhanvien.beans.UserAccount;
import com.mp.quanlynhanvien.utils.DBUtils;
import com.mp.quanlynhanvien.utils.StorageUtils;
/**
 *
 * @author Ms Phuong
 */
public class DanhSachNVTVServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        
        //ktra dang nhap
        HttpSession session = request.getSession();
        
        UserAccount user = StorageUtils.getLoginedUser(session);
        String errorString = null;
        if (user == null){
            errorString = "Ban chua dang nhap.";
            request.setAttribute("errorString", errorString);
            response.sendRedirect(request.getContextPath()+"/login");
            return;
        }
        
        Connection conn = StorageUtils.getStoredConnection(request);
        
        List <NVThoiViec> list = new ArrayList<NVThoiViec>();
        
        try{
            list = DBUtils.dsNhanVien_ThoiViec(conn);
            
        } catch(SQLException e){
            e.printStackTrace();
            errorString = e.getMessage();
        }
        request.setAttribute("errorString", errorString);
        // neu co loi
        
        if (errorString != null){
            
            RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/WEB-INF/views/homeView.jsp");
            dispatcher.forward(request, response);
            return;
        }
        
        //khong co loi
        request.setAttribute("sodong", list.size());
        request.setAttribute("list", list);
        
        RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/WEB-INF/views/danhSachNVTVView.jsp");
        dispatcher.forward(request, response);
    }
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

}
