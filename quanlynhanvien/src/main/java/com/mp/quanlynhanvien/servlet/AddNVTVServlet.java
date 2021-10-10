
package com.mp.quanlynhanvien.servlet;
import com.mp.quanlynhanvien.beans.UserAccount;
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
import java.util.Calendar;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Ms Phuong
 */
public class AddNVTVServlet extends HttpServlet {

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
            response.sendRedirect(request.getContextPath()+"/login");
            return;
        }
        
        Connection conn = StorageUtils.getStoredConnection(request);
        
        //ktra quyen: chi  admin moi co quyen truy cap
        if (loginedUser.getTenVT().equals("Admin") == false ){
            errorString = "Quyen truy cap that bai.";
            request.setAttribute("errorString", errorString);
            RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/WEB-INF/views/errorView.jsp");
            dispatcher.forward(request, response);
            return;
        }
        
        String maNV = request.getParameter("maNV");
        Calendar c = Calendar.getInstance();
        int nam = c.get(Calendar.YEAR);
        int thang = c.get(Calendar.MONTH) + 1;
        int ngay = c.get(Calendar.DAY_OF_MONTH);
        String date = nam+"-"+thang+"-"+ngay;
        try{
            DBUtils.NhanVien_ThoiViec(conn,maNV,date);
            
        } catch(SQLException e){
            e.printStackTrace();
            errorString = e.getMessage();
        }
        request.setAttribute("errorString", errorString);
        // neu co loi
        
        if (errorString != null){
            
            RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/WEB-INF/views/danhSachNVView.jsp");
            dispatcher.forward(request, response);
            return;
        }
        
        //khong co loi
        
        response.sendRedirect(request.getContextPath()+"/danhSachNVTV");
    }
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

}
