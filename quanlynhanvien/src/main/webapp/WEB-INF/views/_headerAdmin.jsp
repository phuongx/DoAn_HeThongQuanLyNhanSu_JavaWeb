<%-- 
    Document   : _headerAdmin
    Created on : Nov 9, 2021, 11:37:42 PM
    Author     : Ms Phuong
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>

<nav class="navbar navbar-inverse navbar-fixed-top" >
  <div class="container-fluid">
    <div class="navbar-header">
        <a href="#" class="navbar-brand" style="color: lightgrey; font-size: 30px">MP</a>
    </div>
      
    <ul class="nav navbar-nav">
        <li class="active"><a href="${pageContext.request.contextPath}/">Home</a></li>
        <li><a href="${pageContext.request.contextPath}/thongbao">Thông báo</a></li>
        <li><a href="${pageContext.request.contextPath}/addNV">Tạo tài khoản</a></li>
        <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">Danh mục <span class="caret"></span></a>
            <ul class="dropdown-menu">
                <li><a href="${pageContext.request.contextPath}/dsPhongBan">Phòng ban</a></li>
                <li><a href="${pageContext.request.contextPath}/dsPhongBan">Chức vụ</a></li>
                <li><a href="${pageContext.request.contextPath}/dsPhongBan">Trình độ học vấn</a></li>
                <li><a href="${pageContext.request.contextPath}/dsPhongBan">Trình độ ngoại ngữ</a></li>
                <li><a href="${pageContext.request.contextPath}/dangTinTuyenDung">Đăng tin tuyển dụng</a></li>
            </ul>
        </li>
        <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">Tuyển dụng <span class="caret"></span></a>
            <ul class="dropdown-menu">
                <li><a href="${pageContext.request.contextPath}/dsPhongBan">Xem-Sửa-Xóa</a></li>
                <li><a href="${pageContext.request.contextPath}/dangTinTuyenDung">Thêm tin mới</a></li>
            </ul>
        </li>
    </ul>
    <li><a href="${pageContext.request.contextPath}/addNV">Quản lý quyền truy cập</a></li>
    <ul class="nav navbar-nav navbar-right">
        <li><a href="${pageContext.request.contextPath}/thongTinNV?maNV=${loginedUser.maNV}"><span class="glyphicon glyphicon-user"></span> ${loginedUser.hoten}</a></li>
      <li><a href="${pageContext.request.contextPath}/logout"><span class="glyphicon glyphicon-log-out"></span> Logout</a></li> 
    </ul>
  </div>
</nav>
<div class="container" style="margin-top:72px">
    

