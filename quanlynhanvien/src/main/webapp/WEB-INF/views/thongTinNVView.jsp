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
    <title>MP - Quản lý nhân sự</title>
    <script src='https://kit.fontawesome.com/a076d05399.js' crossorigin='anonymous'></script>
 </head>
 <body>

    <c:if test="${quyen=='1'}"><jsp:include page="_header.jsp"></jsp:include></c:if>
    <c:if test="${quyen=='2'}"><jsp:include page="_headerNhanvien.jsp"></jsp:include></c:if>
    <p style="color: red;">${errorString}</p>
                <hr>
            <h4 style="text-align: center;">Thông tin nhân viên <b style="color:blue;">${user.hoten}</b></h4>
            <hr />
    <div class="row">
        <div class="col-lg-2">
        </div>
        <div class="col-lg-4">


            <table class="table table-striped">

                <tr>
                    <th colspan="2" class="info">THÔNG TIN CÁ NHÂN</th>
                </tr>
                <tr>
                    <th >Mã nhân viên</td>
                    <td>${user.maNV}</td>
                </tr>
                <tr>
                    <th >Phòng ban </td>
                    <td>${user.tenPB } </td>
                </tr>
                <tr>
                    <th >Vị trí</td>
                    <td>${user.tenVT } </td>
                </tr>
                <tr>
                    <th >Trạng thái </td>
                    <td>${user.tenTT} </td>
                </tr>
            </table>
        </div>
        <div class="col-lg-4">
            <table class="table table-striped">

                <tr>
                    <th >Họ và tên </td>
                    <td>${user.hoten } </td>
                </tr>
                
                <tr>
                    <th >Email </td>
                    <td>${user.email } </td>
                </tr>
                <tr>
                    <th >Số điện thoại </td>
                    <td>${user.sdt } </td>
                </tr>
                <tr>
                    <th >Ngày sinh </td>
                    <td>${user.ngaysinh } </td>
                </tr>
                <tr>
                    <th >Giới tính</td>
                    <td>${user.gioitinh }</td>
                </tr> 
                <tr>
                    <th >Địa chỉ</td>
                    <td>${user.diachi } </td>
                </tr>

                </tr>
            </table>
        </div>
        <div class="col-lg-2"></div>
    </div>
    <div class="row">
        <div class="col-lg-2">
        </div>
        <div class="col-lg-8">
            <hr>
            <table class="table table-striped">
                <tr>
                    <th colspan="2" class="info">THÀNH TÍCH TIÊU BIỂU</th>
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
                <hr>
            <table class="table table-striped">
                <tr>
                    <th colspan="2" class="info">VI PHẠM</th>
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
        <div class="col-lg-2"></div>
    </div>
 
    <jsp:include page="_footer.jsp"></jsp:include>
 
 </body>
</html>
