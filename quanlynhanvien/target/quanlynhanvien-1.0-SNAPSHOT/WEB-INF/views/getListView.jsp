<%-- 
    Document   : getListView
    Created on : Nov 13, 2021, 2:15:41 AM
    Author     : Ms Phuong
--%>

<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <title>MP - Nhan vien</title>
        <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
        <jsp:include page="_htmlHead.jsp"></jsp:include>
        
    </head>
    <body>
        <jsp:include page="_header.jsp"></jsp:include>
        <p style="color: red;">${errorString}</p>
        <p>Danh sách này có <b style="color:blue">${sodong}</b> dòng</p>
        <p><a href="#">Tải xuống danh sách</a></p>
    <table class="table table-striped table-bordered" >
        <tr class="info">
            <th>Mã nhân viên</th>                
            <th>Họ tên</th>
            <th>Giới tính</th>
            <th>Ngày sinh</th>
            <th>Vị trí</th> 
        </tr>
    <c:forEach items="${list}" var="values">
        <tr>
            <td>${values.maNV}</td>
            <td>${values.hoten}</td>
            <td>${values.gioitinh}</td>
            <td>${values.ngaysinh}</td>
            <td>${values.tenVT}</td>


        </tr>
    </c:forEach>
    </table>


       <jsp:include page="_footer.jsp"></jsp:include>
    </body>
</html>

