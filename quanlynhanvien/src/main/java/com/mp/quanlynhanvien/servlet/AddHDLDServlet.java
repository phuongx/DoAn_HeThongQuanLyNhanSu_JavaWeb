
package com.mp.quanlynhanvien.servlet;

import com.mp.quanlynhanvien.beans.HopDongLaoDong;
import com.mp.quanlynhanvien.beans.UserAccount;
import com.mp.quanlynhanvien.utils.AutoFillUtils;
import com.mp.quanlynhanvien.utils.DBUtils;
import com.mp.quanlynhanvien.utils.StorageUtils;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

@MultipartConfig
public class AddHDLDServlet extends HttpServlet {

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
        
        //tu dong dien
        Connection conn = StorageUtils.getStoredConnection(request);
        
        request.setAttribute("errorString",errorString);
        //chuyen sang trang addThanhTichView
        RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/WEB-INF/views/add-hdldView.jsp");
        dispatcher.forward(request, response);
    }
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        
        String errorString = null;
        String maNV = request.getParameter("maNV");
        String ngayKy = request.getParameter("ngayKy");
        String ngayHH = request.getParameter("ngayHH");
        String tenfile = null;
        String fullduongdan = null;
                
         // Danh mục các phần đã upload lên .
         Part part = request.getPart("hopdong");
        
        //chi lay ten file
        String fileName = extractFileName(part);

        fullduongdan = "D:/WebApp/quanlynhanvien/src/main/webapp/file/hdld/"+maNV+ "_"+fileName;
        tenfile = "file/hdld/"+maNV+ "_"+fileName;

        //luu file
        part.write(fullduongdan);
        HopDongLaoDong hd = new HopDongLaoDong(0,maNV,ngayKy,ngayHH,tenfile);

        Connection conn = StorageUtils.getStoredConnection(request);

        try{
            DBUtils.insertHopDongLaoDong(conn, hd);
        } catch (SQLException e){
            e.printStackTrace();
            errorString = "Loi du lieu";
        }
        if (errorString != null){
            
            request.setAttribute("errorString", errorString);
            request.setAttribute("hopdong", hd);
            RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/WEB-INF/views/dsHopDongLaoDongView.jsp");
            dispatcher.forward(request, response);
            return;
        }
        
        //neu khong co loi
        
        response.sendRedirect(request.getContextPath()+"/hopdonglaodong");
    }
    //ham tach ten file
    private String extractFileName(Part part) {
       // form-data; name="file"; filename="C:\file1.zip"
       // form-data; name="file"; filename="C:\Note\file2.zip"
       String contentDisp = part.getHeader("content-disposition");
       String[] items = contentDisp.split(";");
       for (String s : items) {
           if (s.trim().startsWith("filename")) {
               // C:\file1.zip
               // C:\Note\file2.zip
               String clientFileName = s.substring(s.indexOf("=") + 2, s.length() - 1);
               clientFileName = clientFileName.replace("\\", "/");
               int i = clientFileName.lastIndexOf('/');
               // file1.zip
               // file2.zip
               int j  = clientFileName.lastIndexOf('.');
               return clientFileName.substring(i);
           }
       }
       return null;
   }
}
