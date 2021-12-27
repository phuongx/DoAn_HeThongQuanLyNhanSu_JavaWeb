
package com.mp.quanlynhanvien.servlet;

import com.mp.quanlynhanvien.beans.PhongBan;
import com.mp.quanlynhanvien.beans.TinTuyenDung;
import com.mp.quanlynhanvien.beans.TrangThai;
import com.mp.quanlynhanvien.beans.UserAccount;
import com.mp.quanlynhanvien.beans.ViTri;
import com.mp.quanlynhanvien.utils.AutoFillUtils;
import com.mp.quanlynhanvien.utils.DBUtils;
import com.mp.quanlynhanvien.utils.StorageUtils;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class DangTinTuyenDungServlet extends HttpServlet {

    
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        
        //ktra dang nhap
        HttpSession session = request.getSession();
        UserAccount loginedUser = StorageUtils.getLoginedUser(session);
        String errorString = null;
        if (loginedUser == null){
            errorString = "Bạn chưa đăng nhập..";
            request.setAttribute("errorString", errorString);
            RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/WEB-INF/views/loginView.jsp");
            dispatcher.forward(request, response);
            return;
        }
        
        //ktra quyen: chi co admin
        int quyenUser = StorageUtils.getQuyenUser(session);
        if (quyenUser == 2 ){
            errorString = "Quyền truy cập thất bại..";
            request.setAttribute("errorString", errorString);
            RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/WEB-INF/views/errorView.jsp");
            dispatcher.forward(request, response);
            return;
        }
        
        //xu ly
        Connection conn = StorageUtils.getStoredConnection(request);
        List<PhongBan> listPB = AutoFillUtils.getListPB(conn);
        List<ViTri> listVT = AutoFillUtils.getListVT(conn);
        List<TrangThai> listTT = AutoFillUtils.getListTT(conn);
        
        //luu thong tin vao request
        request.setAttribute("listPB",listPB);
        request.setAttribute("listVT",listVT);
        request.setAttribute("listTT",listTT);
        
        request.getRequestDispatcher("/WEB-INF/views/dangTinTuyenDung.jsp").forward(request, response);
    }
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        
        String errorString = null;
        int maTin = 0;
        String tenPB = request.getParameter("tenPB");
        String tenVT = request.getParameter("tenVT");
        String soluong = request.getParameter("soluong");
        String mota = request.getParameter("mota");
        String ngayBD = request.getParameter("ngayBD");
        String ngayKT = request.getParameter("ngayKT");
        int soLuong = Integer.parseInt(soluong);
        TinTuyenDung tin = new TinTuyenDung(maTin,tenPB,tenVT,soLuong,mota,ngayBD,ngayKT);
        Connection conn = StorageUtils.getStoredConnection(request);
        try {
            DBUtils.insertTinTuyenDung(conn, tin);
        } catch (SQLException e){
            e.printStackTrace();
            errorString = "Yêu cầu bị từ chối. Vui lòng thử lại sau.";
        }
        if (errorString != null){
            request.setAttribute("errorString", errorString);
            request.getRequestDispatcher("/WEB-INF/views/dangTinTuyenDung.jsp").forward(request, response);
            return;
        }
        String thongbao = "Đã thêm tin thành công.";
        request.setAttribute("thongbao", thongbao);
        response.sendRedirect(request.getContextPath()+"/tuyendung/qly");
    }

}
