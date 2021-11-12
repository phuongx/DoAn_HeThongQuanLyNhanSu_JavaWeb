
package com.mp.quanlynhanvien.filter;


import com.mp.quanlynhanvien.beans.CongViec;
import java.io.IOException;

import java.sql.Connection;
import java.sql.SQLException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.mp.quanlynhanvien.beans.UserAccount;

import com.mp.quanlynhanvien.utils.StorageUtils;
import com.mp.quanlynhanvien.utils.DBUtils;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Ms Phuong
 */
public class CookieFilter implements Filter {
    
   @Override
    public void init(FilterConfig fConfig) throws ServletException {
 
    }
 
    @Override
    public void destroy() {
 
    }
 
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpSession session = req.getSession();
        // Connection đã được tạo trong JDBCFilter.
        Connection conn = StorageUtils.getStoredConnection(request);
        
        UserAccount userInSession = StorageUtils.getLoginedUser(session);
        
        List<CongViec> list1 = new ArrayList<CongViec>();
        // 
        if (userInSession != null) {
            try {
                list1 = DBUtils.getCongViec(conn, userInSession.getMaNV(), "Chua hoan thanh");
            } catch (SQLException e) {
                e.printStackTrace();
            }
            StorageUtils.storeSoluong(session, list1.size());
            
            StorageUtils.storeQuyen(session, userInSession.getQuyen());
            
            session.setAttribute("COOKIE_CHECKED", "CHECKED");
            chain.doFilter(request, response);
            return;
        }
        
 
        // Cờ (flag) để kiểm tra Cookie.
        String checked = (String) session.getAttribute("COOKIE_CHECKED");
        
        if (checked == null && conn != null) {
            String userName = StorageUtils.getUserNameInCookie(req);
            try {
                UserAccount user = DBUtils.findUser(conn, userName);
                StorageUtils.storeLoginedUser(session, user);
                
            } catch (SQLException e) {
                e.printStackTrace();
            }
            
            // Đánh dấu đã kiểm tra Cookie.
            session.setAttribute("COOKIE_CHECKED", "CHECKED");
        }
 
        chain.doFilter(request, response);
    }
}
