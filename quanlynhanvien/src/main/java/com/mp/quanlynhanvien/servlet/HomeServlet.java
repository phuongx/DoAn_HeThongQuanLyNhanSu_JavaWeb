
package com.mp.quanlynhanvien.servlet;

import com.mp.quanlynhanvien.beans.TinTuyenDung;
import com.mp.quanlynhanvien.utils.DBUtils;
import com.mp.quanlynhanvien.utils.StorageUtils;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Ms Phuong
 */
public class HomeServlet extends HttpServlet {

   
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        
        String errorString = null;
       
        List <TinTuyenDung> list = new ArrayList<TinTuyenDung>();
        Connection conn = StorageUtils.getStoredConnection(request);
         try {
            DBUtils.getTinTuyenDung(conn);
        } catch (SQLException e){
            e.printStackTrace();
            errorString = "Yêu cầu bị từ chối. Vui lòng thử lại sau.";
        }
        request.setAttribute("errorString", errorString);
        request.getRequestDispatcher("/WEB-INF/views/homeView.jsp").forward(request, response);
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

   
}
