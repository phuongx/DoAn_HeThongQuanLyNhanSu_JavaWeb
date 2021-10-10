<%-- 
    Document   : _header
    Created on : Jul 20, 2021, 9:25:13 PM
    Author     : Ms Phuong
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>

<nav class="navbar navbar-inverse navbar-fixed-top" >
  <div class="container-fluid">
    <div class="navbar-header">
        <a href="#" class="navbar-brand" style="color: lightgrey; font-size: 30px">HRM</a>
    </div>
      
    <ul class="nav navbar-nav">
        <li class="active"><a href="${pageContext.request.contextPath}/">Home</a></li>
        <li><a href="${pageContext.request.contextPath}/thongTinNV?maNV=${loginedUser.maNV}">Thông tin nhân viên</a></li>
        <li><a href="${pageContext.request.contextPath}/viecDuocGiao">Việc được giao</a></li>
        <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">Danh sách <span class="caret"></span></a>
            <ul class="dropdown-menu">
                <li><a href="${pageContext.request.contextPath}/danhSachNV">Nhân viên</a></li>
                <li><a href="${pageContext.request.contextPath}/danhSachNVTV">Nhân viên đã nghĩ</a></li>
                <li><a href="${pageContext.request.contextPath}/dsPhongBan">Phòng ban</a></li>
            </ul>
        </li>
        <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">For Manager <span class="caret"></span></a>
            <ul class="dropdown-menu">
                <li><a href="${pageContext.request.contextPath}/giaoViec">Giao việc</a></li>
                <li><a href="${pageContext.request.contextPath}/dsHSUT">Hồ sơ ứng viên</a></li>
             
            </ul>
        </li>
        <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">For Admin <span class="caret"></span></a>
            <ul class="dropdown-menu">
                <li><a href="${pageContext.request.contextPath}/addNV">Tạo tài khoản</a></li>
                <li><a href="${pageContext.request.contextPath}/dsPhongBan">Thêm phòng ban</a></li>
                <li><a href="${pageContext.request.contextPath}/dangTinTuyenDung">Đăng tin tuyển dụng</a></li>
            </ul>
        </li>
        <li><a href="${pageContext.request.contextPath}/ungTuyen"> Ứng tuyển </a></li>
            <li> <a href="${pageContext.request.contextPath}/ungTuyen"> Hướng dẫn </a></li>
    </ul>
      
    <ul class="nav navbar-nav navbar-right">
        <li><a href="${pageContext.request.contextPath}/thongTinNV?maNV=${loginedUser.maNV}"><span class="glyphicon glyphicon-user"></span> ${loginedUser.hoten}</a></li>
      <li><a href="${pageContext.request.contextPath}/logout"><span class="glyphicon glyphicon-log-out"></span> Logout</a></li> 
    </ul>
  </div>
</nav>
<div class="container" style="margin-top:72px">
    
