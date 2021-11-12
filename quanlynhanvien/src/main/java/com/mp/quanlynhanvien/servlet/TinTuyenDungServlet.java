
package com.mp.quanlynhanvien.servlet;

import java.io.PrintWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.mp.quanlynhanvien.beans.TinTuyenDung;
import com.mp.quanlynhanvien.utils.DBUtils;
import com.mp.quanlynhanvien.utils.StorageUtils;

public class TinTuyenDungServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        Connection conn = StorageUtils.getStoredConnection(request);
        List<TinTuyenDung> tin = new ArrayList<TinTuyenDung>(); 
        String errorString = null;
        try {
            tin = DBUtils.getTinTuyenDung(conn);
        } catch (SQLException e){
            e.printStackTrace();
            errorString = "Lỗi lấy dữ liệu.";
        }
        request.setAttribute("tin", tin);
        request.setAttribute("errorString", errorString);
        request.getRequestDispatcher("/WEB-INF/views/tinTuyenDungView.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}
