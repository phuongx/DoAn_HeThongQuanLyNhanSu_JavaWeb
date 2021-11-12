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
        <a href="#" class="navbar-brand" style="color: lightgrey; font-size: 30px">MP</a>
    </div>
      
    <ul class="nav navbar-nav">
        
        <li><a href="${pageContext.request.contextPath}/thongbao">Thông báo</a></li>
        <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">Danh mục <span class="caret"></span></a>
            <ul class="dropdown-menu">
                <li><a href="${pageContext.request.contextPath}/dsPhongBan">Phòng ban</a></li>
                <li><a href="${pageContext.request.contextPath}/chucvu">Chức vụ</a></li>
                <li><a href="${pageContext.request.contextPath}/trinhdohocvan">Trình độ học vấn</a></li>
                <li><a href="${pageContext.request.contextPath}/trinhdongoaingu">Trình độ ngoại ngữ</a></li>
            </ul>
        </li>
        <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">Hồ sơ <span class="caret"></span></a>
            <ul class="dropdown-menu">
                <li><a href="${pageContext.request.contextPath}/danhSachNV">Nhân viên</a></li>
                <li><a href="${pageContext.request.contextPath}/danhSachNVTV">Nhân viên đã nghĩ</a></li>
                <li><a href="${pageContext.request.contextPath}/dsHSUT">Hồ sơ ứng viên</a></li>
                <li><a href="${pageContext.request.contextPath}/addNV">Tiếp nhận nhân viên</a></li>
            </ul>
        </li>
        <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">Hợp đồng <span class="caret"></span></a>
            <ul class="dropdown-menu">
                <li><a href="${pageContext.request.contextPath}/hopdonglaodong">Hợp đồng lao động</a></li>
            </ul>
        </li>
        <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">Thống kê-Báo cáo <span class="caret"></span></a>
            <ul class="dropdown-menu">
                <li><a href="${pageContext.request.contextPath}/tk-nv-pb">Nhân viên theo phòng ban</a></li>
                <li><a href="${pageContext.request.contextPath}/tk-nv-tdhv">Nhân viên theo trình độ</a></li>
                <li><a href="${pageContext.request.contextPath}/thongkenv?name=tuoi">Nhân viên theo độ tuổi</a></li>
            </ul>
        </li>
        <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">Tuyển dụng <span class="caret"></span></a>
            <ul class="dropdown-menu">
                
                <li><a href="${pageContext.request.contextPath}/qlytuyendung">Xem-Sửa-Xóa</a></li>
                <li><a href="${pageContext.request.contextPath}/dangTinTuyenDung">Thêm tin mới</a></li>
            </ul>
        </li>
        <li><a href="${pageContext.request.contextPath}/">Quản lý quyền truy cập</a></li>
    </ul>
    
    <ul class="nav navbar-nav navbar-right">
        <li><a href="${pageContext.request.contextPath}/thongTinNV?maNV=${loginedUser.maNV}"><span class="glyphicon glyphicon-user"></span> ${loginedUser.hoten}</a></li>
      <li><a href="${pageContext.request.contextPath}/logout"><span class="glyphicon glyphicon-log-out"></span> Logout</a></li> 
    </ul>
  </div>
</nav>
<div class="container" style="margin-top:60px">