<%-- 
    Document   : danhSachNVTVView
    Created on : Aug 30, 2021, 9:04:46 PM
    Author     : Ms Phuong
--%>

<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Nhan vien da nghi viec</title>
        <jsp:include page="_htmlHead.jsp"></jsp:include>
    </head>
    <body>
        <jsp:include page="_header.jsp"></jsp:include>
        
        <p style="color: red;">${errorString}</p>
        
        <table class="table table-striped" >
            <tr class="text-center">
                <th>Mã nhân viên</th>                
                <th>Họ tên</th>
                <th>Giới tính</th>
                <th>Địa chỉ</th>
                <th>Phòng ban</th>
                <th>Phòng ban</th>
                <th>Ngày bắt đầu</th>
                <th>Ngày thôi việc</th>
                <th>Ghi chú</th>
                <th>Xem chi tiết</th>
            </tr>
            
            <c:forEach items="${list}" var="val">
            <tr>
                <td>${val.user.maNV}</td>
                <td>${val.user.hoten}</td>
                <td>${val.user.gioitinh}</td>
                <td>${val.user.diachi}</td>
                <td>${val.user.tenPB}</td>
                <td>${val.user.tenVT}</td>
                <td>${val.user.ngayBD}</td>
                <td>${val.ngay}</td>
                <td>${val.user.ghichu}</td>
                <td><a href="thongTinNV?maNV=${val.user.maNV}">Xem</a></td>
            </tr>
            </c:forEach>
            
        </table>
        <jsp:include page="_footer.jsp"></jsp:include>
    </body>
</html>

