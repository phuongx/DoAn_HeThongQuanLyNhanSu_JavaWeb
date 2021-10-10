<%-- 
    Document   : thongTinNVView
    Created on : Aug 24, 2021, 9:34:39 PM
    Author     : Ms Phuong
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
 <head>
    <jsp:include page="_htmlHead.jsp"></jsp:include>
    <title>User Info</title>
    <script src='https://kit.fontawesome.com/a076d05399.js' crossorigin='anonymous'></script>
 </head>
 <body>
 
    <jsp:include page="_header.jsp"></jsp:include>

    <p style="color: red;">${errorString}</p>
    <div class="row">
        <div class="col-lg-1"></div>
        <div class="col-lg-10">
            <h4>Thông tin nhân viên <b style="color:blue;">${user.hoten}</b></h4>
            <br />

            <c:if test="${not empty user.hinhanh}">
                <img src="<c:url value="/file/hinhanh/${user.hinhanh}" />" alt="anh dai dien" style="height:100px;width:80px"><br>
            </c:if>
                <a href="${pageContext.request.contextPath}/uploadAnh?maNV=${user.maNV}"><button type="button"><i class='fas fa-camera-retro'></i></button></a>

            <table class="table table-striped">

                <tr>
                    <th colspan="2" >THÔNG TIN CÁ NHÂN</th>
                </tr>
                <tr>
                    <th class="text-right">Mã nhân viên</td>
                    <td>${user.maNV}</td>
                </tr>
                <tr>
                    <th class="text-right">Họ tên </td>
                    <td>${user.hoten } </td>
                </tr>
                <tr>
                    <th class="text-right">CMND/CCCD</td>
                    <td>${user.cmnd } </td>
                </tr>
                <tr>
                    <th class="text-right">Email </td>
                    <td>${user.email } </td>
                </tr>
                <tr>
                    <th class="text-right">Giới tính</td>
                    <td>${user.gioitinh }</td>
                </tr> 
                <tr>
                    <th class="text-right">Địa chỉ</td>
                    <td>${user.diachi } </td>
                </tr>
                <tr>
                    <th class="text-right">Phòng ban </td>
                    <td>${user.tenPB } </td>
                </tr>
                <tr>
                    <th class="text-right">Vị trí</td>
                    <td>${user.tenVT } </td>
                </tr>
                <tr>
                    <th class="text-right">Ngày bắt đầu </td>
                    <td>${user.ngayBD } </td>
                </tr>
                <tr>
                    <th class="text-right">Trạng thái </td>
                    <td>${user.tenTT} </td>
                </tr>
                <tr>
                    <th class="text-right">Ghi chú</td>
                    <td>${user.ghichu } </td>
                </tr>
            </table>
            <table class="table table-striped">
                <tr>
                    <th colspan="2">THÀNH TÍCH TIÊU BIỂU</th>
                </tr>
                <tr>
                    <th>Nội dung</th>
                    <th>Ngày quyết định</th>
                </tr>
                <c:forEach items="${thanhtich}" var="values">
                    <tr>
                        <td>${values.noidung}</td>
                        <td>${values.ngay}</td>
                    </tr>
                </c:forEach>
            </table>
            <table class="table table-striped">
                <tr>
                    <th colspan="2">VI PHẠM</th>
                </tr>
                <tr>
                    <th>Ngày vi phạm</th>
                    <th>Nội dung</th>
                </tr>
                <c:forEach items="${vipham}" var="values">
                    <tr>
                        <td>${values.ngay}</td>
                        <td>${values.noidung}</td>
                    </tr>
                </c:forEach>
            </table>
        </div>
        <div class="col-lg-1"></div>
    </div>
 
    <jsp:include page="_footer.jsp"></jsp:include>
 
 </body>
</html>
