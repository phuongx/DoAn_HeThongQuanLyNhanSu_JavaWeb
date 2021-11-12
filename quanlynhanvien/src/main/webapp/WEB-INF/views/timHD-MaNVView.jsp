<%-- 
    Document   : timHD-MaNVView
    Created on : Nov 12, 2021, 1:49:36 AM
    Author     : Ms Phuong
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div id="result">
            <p>Danh sách này có <b style="color:blue">${sodong}</b> dòng.</p>
    <form name="frm2">
        <table class="table table-striped " >
            <tr class="info">
                <th>Mã hợp đồng</th>                
                <th>Mã nhân viên</th>
                <th>Ngày ký</th>
                <th>Ngày hết hạn</th>
                <th>Xem</th> 
            </tr>
        <c:forEach items="${list}" var="values">
            <tr>
                <td>${values.maHD}</td>
                <td>${values.maNV}</td>
                <td>${values.ngayKy}</td>
                <td>${values.ngayHetHan}</td>
                <td><a href="${values.url}" target="_blank">Mở</a></td>
            </tr>
        </c:forEach>
        </table>
    </form>
    </div> 
    </body>
</html>
