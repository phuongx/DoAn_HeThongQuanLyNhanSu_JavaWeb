
package com.mp.quanlynhanvien.servlet;

import com.mp.quanlynhanvien.beans.UserAccount;
import com.mp.quanlynhanvien.utils.DBUtils;
import com.mp.quanlynhanvien.utils.StorageUtils;
import com.mp.quanlynhanvien.beans.CongViec;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author Ms Phuong
 */
public class GiaoViecServlet extends HttpServlet {

    
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

        request.getRequestDispatcher("/WEB-INF/views/giaoViecView.jsp").forward(request, response);
    }
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        //ktra dang nhap
        HttpSession session = request.getSession();
        UserAccount loginedUser = StorageUtils.getLoginedUser(session);
        String errorString = null;
        String maNV = loginedUser.getMaNV();
        String noidung = request.getParameter("noidung");
        String ngayHT = request.getParameter("ngayHT");
        String gioHT = request.getParameter("gioHT");
        Calendar c = Calendar.getInstance();
        int nam = c.get(Calendar.YEAR);
        int thang = c.get(Calendar.MONTH) + 1;
        int ngay = c.get(Calendar.DAY_OF_MONTH);
        String ngayGiao = nam+"-"+thang+"-"+ngay;
        if (gioHT.equals("")){
            gioHT = "23:59";
        }
        String trangthai = "Chua hoan thanh";
        
        Connection conn = StorageUtils.getStoredConnection(request);
        CongViec cv = new CongViec("",maNV,ngayGiao,noidung,ngayHT,gioHT,trangthai);
        
        try{
            DBUtils.insertCongViec(conn, cv);
        } catch (SQLException e){
            e.printStackTrace();
            errorString = "Loi xu ly du lieu";
        }
        if (errorString != null){
            request.setAttribute("errorString", errorString);
            
            request.getRequestDispatcher("/WEB-INF/views/giaoViecView.jsp").forward(request, response);
            return;
        }
        request.setAttribute("congviec", cv);
        request.setAttribute("thongbao", "Da them thanh cong.");
        request.getRequestDispatcher("/WEB-INF/views/CongViecView.jsp").forward(request, response);
    }

}
