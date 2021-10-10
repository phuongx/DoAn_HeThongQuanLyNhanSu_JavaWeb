
package com.mp.quanlynhanvien.servlet;

import com.mp.quanlynhanvien.beans.PhongBan;
import com.mp.quanlynhanvien.beans.TrangThai;
import com.mp.quanlynhanvien.beans.ViTri;
import com.mp.quanlynhanvien.beans.HSUngTuyen;
import com.mp.quanlynhanvien.utils.AutoFillUtils;
import com.mp.quanlynhanvien.utils.DBUtils;
import com.mp.quanlynhanvien.utils.StorageUtils;
import java.sql.Connection;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import javax.servlet.annotation.MultipartConfig;

/**
 *
 * @author Ms Phuong
 */
@MultipartConfig
public class UngTuyenServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
             throws IOException, ServletException{
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        
        Connection conn = StorageUtils.getStoredConnection(request);
        
        List<PhongBan> listPB = AutoFillUtils.getListPB(conn);
        List<ViTri> listVT = AutoFillUtils.getListVT(conn);
        List<TrangThai> listTT = AutoFillUtils.getListTT(conn);

        request.setAttribute("listPB",listPB);
        request.setAttribute("listVT",listVT);
        request.setAttribute("listTT",listTT);
        
        request.getRequestDispatcher("/WEB-INF/views/ungTuyenView.jsp").forward(request, response);
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
             throws IOException, ServletException{
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        
        Connection conn = StorageUtils.getStoredConnection(request);
        String errorString = null;
        
        String hoten = request.getParameter("hoten");
        String sdt = request.getParameter("sdt");
        String email = request.getParameter("email");
        String tenVT = request.getParameter("tenVT");
        String tenPB = request.getParameter("tenPB");
        String maHS = AutoFillUtils.getMaHSUT(conn);
        String ketqua = null;
        String ngayduyet = null;
        
        String tenfile = null;
        String fullduongdan = null;
                
         // Danh mục các phần đã upload lên (Có thể là nhiều file).
         Part part = request.getPart("cv");
        
        //chi lay duoi file
        String fileName = extractFileName(part);

        fullduongdan = "D:/WebApp/quanlynhanvien/src/main/webapp/file/cv/"+maHS+"_"+hoten+fileName;
        tenfile = maHS+"_"+hoten+fileName;

        //luu file
        part.write(fullduongdan);
 
        
        // Ghi vào database.
        try{
            HSUngTuyen hoso = new HSUngTuyen(maHS, hoten, sdt, email, tenVT, tenPB, tenfile, ketqua, ngayduyet);
            DBUtils.insertHoSoUT(conn, hoso);

            request.setAttribute("hoso", hoso);
        } catch (SQLException e){
            e.printStackTrace();
            errorString = e.getMessage();
        }
        if (errorString != null){
            request.setAttribute("errorString", errorString);
            request.getRequestDispatcher("/WEB-INF/views/errorView.jsp").forward(request, response);
            return;
        }
        
        
        request.setAttribute("errorString", errorString);
        request.getRequestDispatcher("/WEB-INF/views/thongBaoView.jsp").forward(request, response);
        
        
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
               return clientFileName.substring(j);
           }
       }
       return null;
   }
}
    