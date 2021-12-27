
package com.mp.quanlynhanvien.servlet;

import com.mp.quanlynhanvien.beans.PhongBan;
import com.mp.quanlynhanvien.beans.TrangThai;
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

import com.mp.quanlynhanvien.beans.UserAccount;
import com.mp.quanlynhanvien.beans.ViTri;
import com.mp.quanlynhanvien.utils.AutoFillUtils;
import com.mp.quanlynhanvien.utils.StorageUtils;
import com.mp.quanlynhanvien.utils.DBUtils;
import java.util.List;
/**
 *
 * @author Ms Phuong
 */
public class EditTTNVServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        
        String errorString = null;
        //ktra dang nhap
        HttpSession session = request.getSession();
        UserAccount loginedUser = StorageUtils.getLoginedUser(session);
        int quyenUser = StorageUtils.getQuyenUser(session);
        if (loginedUser == null){
            response.sendRedirect(request.getContextPath()+"/login");
            return;
        }
        //xu ly
        String maNV = request.getParameter("maNV");
        //ktra quyen: 
        if (loginedUser.getMaNV().equals(maNV)==false && quyenUser!=1){
            errorString = "Quyen truy cap that bai.";
            request.setAttribute("errorString", errorString);
            RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/WEB-INF/views/errorView.jsp");
            dispatcher.forward(request, response);
            return;
        }
        
        
        Connection conn = StorageUtils.getStoredConnection(request);
        UserAccount userUpdate = new UserAccount();
        
        try{
            userUpdate = DBUtils.findUser(conn, maNV);
        } catch (SQLException e){
            e.printStackTrace();
            errorString = e.getMessage();
        }
        if (userUpdate == null){
            errorString = "Nguoi dung khong ton tai";
            response.sendRedirect(request.getContextPath()+"/nv/list");
            return;
        }
        
        // du lieu tu dong dien
       
        List<PhongBan> listPB = AutoFillUtils.getListPB(conn);
        List<ViTri> listVT = AutoFillUtils.getListVT(conn);
        List<TrangThai> listTT = AutoFillUtils.getListTT(conn);
        
        //luu thong tin vao request
        request.setAttribute("listPB",listPB);
        request.setAttribute("listVT",listVT);
        request.setAttribute("listTT",listTT);
        request.setAttribute("user", userUpdate);
        request.setAttribute("errorString", errorString);
        //chuyen huong
        RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/WEB-INF/views/editTTNVView.jsp");
        dispatcher.forward(request, response);
        
    }
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        
        String maNV = request.getParameter("maNV");
        String cmnd = request.getParameter("cmnd");
        String email = request.getParameter("email");
        String sdt = request.getParameter("sdt");
        String diachi = request.getParameter("diachi");
        String tenPB = request.getParameter("tenPB");
        String tenVT = request.getParameter("tenVT");
        
        
        Connection conn = StorageUtils.getStoredConnection(request);
        
        UserAccount user = new UserAccount();
        String errorString = null;
        
        //ktra 
        try{
            user = DBUtils.findUser(conn, maNV);
            if (user != null){
                user.setCmnd(cmnd);
                user.setEmail(email);
                user.setSdt(sdt);
                user.setDiachi(diachi);
                user.setTenPB(tenPB);
                user.setTenVT(tenVT);
                
                DBUtils.updateNhanVien(conn, user);
            } else {
                errorString = "da co loi xay ra ";
            }
        } catch(SQLException e){
            e.printStackTrace();
            errorString = e.getMessage();
        }
        
        //luu thong tin
        request.setAttribute("user", user);
        request.setAttribute("errorString",errorString);
        if (errorString == null){
            response.sendRedirect(request.getContextPath()+"/nv/thongtin?maNV="+maNV);
        } else {
            RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/WEB-INF/views/editTTNVView.jsp");
            dispatcher.forward(request, response);
        }
        
        
    }
}
