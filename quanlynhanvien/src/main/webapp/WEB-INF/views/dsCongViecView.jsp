<%-- 
    Document   : dsCongViecView
    Created on : Sep 26, 2021, 9:56:06 PM
    Author     : Ms Phuong
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        
    </head>
    <body>
        <form name="frm1">
            <table class="table table-striped">
                <tr class="info">
                    <th>#</th>
                    <th>Nội dung công việc</th>
                    <th>Ngày giao</th>
                    <th>Ngày hết hạn</th>
                    <th>Giờ hết hạn</th>
                    <c:if test="${trangthai=='Chua hoan thanh'}">
                    <th>Đánh dấu đã hoàn thành</th>
                    </c:if>

                </tr>
                <c:forEach items="${list}" var="value">
                <tr>
                    <input type="hidden" name="maCV${value.maCV}" value="${value.maCV}">
                    <td>${value.maCV}</td>
                    <td>${value.noidung}</td>
                    <td>${value.ngayGiao}</td>
                    <td>${value.ngayHH}</td>
                    <td>${value.gioHH}</td>

                    <c:if test="${value.trangthai=='Chua hoan thanh'}">
                        <td><input type="button" class="btn btn-success" value="Đánh dấu" onclick="DanhDauHT(maCV${value.maCV}.value)"></td>
                    </c:if>
                   
                </tr>
                </c:forEach>
            </table>
            </form> 
    </body>
</html>
