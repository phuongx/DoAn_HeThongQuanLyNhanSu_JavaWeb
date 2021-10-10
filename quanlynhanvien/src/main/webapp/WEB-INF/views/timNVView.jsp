<%-- 
    Document   : timNVView
    Created on : Sep 16, 2021, 10:23:33 PM
    Author     : Ms Phuong
--%>

<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>

</head>
<body>

    <p style="color: red;">${errorString1}</p>

    <c:if test="${empty errorString1}">
        <c:if test="${not empty user}">
            <p class="text-left"><b>Thông tin nhân viên:</b> </p>
            <table class="table table-striped">
                <tr class="text-center">
                    <th>Họ và tên</th>
                    <th>Email</th>
                    <th>Vị trí</th>
                    <th>Phòng ban</th>
                </tr>
                <tr>
                    <td>${user.hoten}</td>
                    <td>${user.email}</td>
                    <td>${user.tenVT}</td>
                    <td>${user.tenPB}</td>
                </tr>
            </table>
                
            <div id="thongbao" style="color: red;"></div>
            <p><i style="color: red">Lưu ý: Cần điền đầy đủ các trường thông tin (*) bên dưới.</i></p>
            <form action="${pageContext.request.contextPath}/giaoViec" method="POST" name="frmGV" onsubmit="return KiemTra()" class="form-horizontal">
                <input type="hidden" name="maNV" value="${user.maNV}">
                <div class="form-group">
                    <label class="control-label col-lg-4" for="nd">Nội dung công việc (*)</label>
                    <div class="col-lg-4">
                        <textarea class="form-control" rows="5" cols="30" id="nd" name="noidung"></textarea>
                    </div>
                    <div class="col-lg-4"></div>
                </div>
                <div class="form-group">
                    <label class="control-label col-lg-4" for="ngay">Ngày hết hạn (*)</label>
                    <div class="col-lg-4">
                        <input class="form-control" id="ngay" type="text" name="ngayHT" placeholder="yyyy-mm-dd">
                    </div>
                    <div class="col-lg-4"></div>
                </div>
                <div class="form-group">
                    <label class="control-label col-lg-4" for="gio">Giờ hết hạn</label>
                    <div class="col-lg-4">
                        <input class="form-control" id="ngay" type="text" name="gioHT" placeholder="hh:mm">
                    </div>
                    <div class="col-lg-4"></div>
                </div>
                <div class="form-group">        
                    <div class="col-lg-offset-5 col-lg-1">
                        <input type="submit" value="Gửi" class="btn btn-primary" onclick="return KiemTra()">
                    </div>
                    <div class="col-lg-6">
                        <a href="${pageContext.request.contextPath}/giaoViec"><button type="button" class="btn btn-default">Hủy</button></a>
                    </div>
                </div>
            </form>
        </c:if>
    </c:if>

</body>
</html>
