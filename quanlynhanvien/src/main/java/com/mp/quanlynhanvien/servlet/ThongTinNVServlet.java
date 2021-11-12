
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

import com.mp.quanlynhanvien.beans.UserAccount;
import com.mp.quanlynhanvien.beans.ViPham;
import com.mp.quanlynhanvien.beans.ThanhTich;
import com.mp.quanlynhanvien.utils.DBUtils;
import com.mp.quanlynhanvien.utils.StorageUtils;

/**
 *
 * @author Ms Phuong
 */
public class ThongTinNVServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        
        //ktra nguoi dung da dang nhap hay chua va quyen
        HttpSession session = request.getSession();
        
        UserAccount loginedUser = StorageUtils.getLoginedUser(session);
        
        String errorString = null;
        Connection conn = StorageUtils.getStoredConnection(request);
        if (loginedUser == null){
            errorString = "Bạn chưa đăng nhập.";
            request.setAttribute("errorString", errorString);
            //response.sendRedirect(request.getContextPath()+"/login");
            RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/WEB-INF/views/loginView.jsp");
            dispatcher.forward(request, response);
            return;
        } 
        
        // tìm user va cac thanh tich va vi pham ; va ktra quyen
        String maNV = request.getParameter("maNV");
        UserAccount user = new UserAccount();
        List <ThanhTich> thanhtich = new ArrayList<ThanhTich>();
        List <ViPham> vipham = new ArrayList<ViPham>();
        try{
            user = DBUtils.findUser(conn, maNV);
            if (user == null){
                errorString = "Ma nhan vien khong ton tai.";
                request.setAttribute("errorString", errorString);
                RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/WEB-INF/views/errorView.jsp");
                dispatcher.forward(request, response);
                return;
            }
            
            // kiem tra quyen truy cap
            if (loginedUser.getTenVT().equals("Admin") == false &&  
                    loginedUser.getMaNV().equals(user.getMaNV()) == false){
                errorString = "Quyen truy cap that bai.";
                request.setAttribute("errorString", errorString);
                RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/WEB-INF/views/errorView.jsp");
                dispatcher.forward(request, response);
                return;
            }
            thanhtich = DBUtils.findThanhTich(conn, maNV);
            vipham = DBUtils.findViPham(conn, maNV);
        } catch (SQLException e){
            e.printStackTrace();
            errorString = e.getMessage();
        }
        request.setAttribute("user",user);
        request.setAttribute("thanhtich",thanhtich);
        request.setAttribute("vipham", vipham);
        RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/WEB-INF/views/thongTinNVView.jsp");
        dispatcher.forward(request, response);

        
        
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}
