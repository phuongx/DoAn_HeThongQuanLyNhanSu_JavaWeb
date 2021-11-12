
package com.mp.quanlynhanvien.servlet;

import com.mp.quanlynhanvien.beans.TrinhDoHocVan;
import com.mp.quanlynhanvien.beans.UserAccount;
import com.mp.quanlynhanvien.utils.DBUtils;
import com.mp.quanlynhanvien.utils.StorageUtils;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class TKNhanVienTDHV extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        String errorString = null;
        //ktra dang nhap
        HttpSession session = request.getSession();
        UserAccount user = StorageUtils.getLoginedUser(session);
       int quyenUser = StorageUtils.getQuyenUser(session);
        if (user == null){
            response.sendRedirect(request.getContextPath()+"/login");
            return;
        } 
        
        //ktra quyen: chi co admin
        if (quyenUser == 2 ){
            errorString = "Quyền truy cập thất bại.";
            request.setAttribute("errorString", errorString);
            RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/WEB-INF/views/errorView.jsp");
            dispatcher.forward(request, response);
            return;
        }
        
        // xu ly
        Connection conn = StorageUtils.getStoredConnection(request);
        Map <TrinhDoHocVan,String> list = new LinkedHashMap<TrinhDoHocVan,String>();
        try{
            list = DBUtils.ds_TrinhDoHocVan(conn);
            
        } catch (SQLException e){
            e.printStackTrace();
            errorString = e.getMessage();
        }
        request.setAttribute("sodong", list.size());
        request.setAttribute("list", list);
        request.setAttribute("soluong", list);
        request.setAttribute("errorString", errorString);
        //chuyen huong
        RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/WEB-INF/views/tk-NV-TDHVView.jsp");
        dispatcher.forward(request, response);
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

}
