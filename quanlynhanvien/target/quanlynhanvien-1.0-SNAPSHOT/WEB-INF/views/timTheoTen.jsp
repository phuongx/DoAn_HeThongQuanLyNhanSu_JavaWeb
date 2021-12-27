<%-- 
    Document   : timTheoTen
    Created on : Oct 18, 2021, 9:18:43 PM
    Author     : Ms Phuong
--%>

<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <body>
        <p>Danh sách này có <b style="color:blue">${sodong}</b> dòng.</p>
        <form name="frm2">
        <table class="table table-striped" >
            <tr class="text-center">
                <th>Mã nhân viên</th>                
                <th>Họ tên</th>
                <th>Email</th>
                <th>Số điện thoại</th>
                <th>Giới tính</th>
                <th>Phòng ban</th>
                <th>Vị trí</th>
                <th>Xem chi tiết</th>
                <th>Chỉnh sửa</th>
                <th>Thêm thành tích</th>
                <th>Thêm vi phạm</th>
                <th>Thôi việc</th> 
                
            </tr>
        <c:forEach items="${list}" var="values">
            <tr>
                <input type="hidden" name="maNV${values.maNV}" value="${values.maNV}">
                <td>${values.maNV}</td>
                <td>${values.hoten}</td>
                <td>${values.email}</td>
                <td>${values.sdt}</td>
                <td>${values.gioitinh}</td>
                <td>${values.tenPB}</td>
                <td>${values.tenVT}</td>
                
                <td class="text-center"><a href="nv/thongtin?maNV=${values.maNV}">Xem</a></td>
                <td class="text-center"><a href="nv/edit?maNV=${values.maNV}">Sửa</a></td>
                <td class="text-center"><a href="nv/thanhtich/add?maNV=${values.maNV}">Thêm</a></td>
                <td class="text-center"><a href="nv/vipham/add?maNV=${values.maNV}">Thêm</a></td>  
                <td class="text-center"><input type="button" class="btn btn-danger" value="Đánh dấu" onclick="check_confirm(maNV${values.maNV}.value)"></td>
                <c:if test="${values.tenTT=='Thoi viec'}">
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                </c:if>
            </tr>
        </c:forEach>
        </table>
    </form>
    </body>
</html>
