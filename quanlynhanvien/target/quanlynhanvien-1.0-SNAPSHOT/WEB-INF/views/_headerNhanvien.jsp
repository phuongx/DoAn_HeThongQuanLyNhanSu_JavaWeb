<%-- 
    Document   : _headerQuanly
    Created on : Nov 9, 2021, 11:46:26 PM
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
        <li><a href="${pageContext.request.contextPath}/viecDuocGiao">Công việc <span class="badge">${soluong}</span></a></li>
        <li><a href="${pageContext.request.contextPath}/thongTinNV?maNV=${loginedUser.maNV}">Hồ sơ cá nhân</a></li>
        
    </ul>
      
    <ul class="nav navbar-nav navbar-right">
        <li><a href="${pageContext.request.contextPath}/thongTinNV?maNV=${loginedUser.maNV}"><span class="glyphicon glyphicon-user"></span> ${loginedUser.hoten}</a></li>
      <li><a href="${pageContext.request.contextPath}/logout"><span class="glyphicon glyphicon-log-out"></span> Logout</a></li> 
    </ul>
  </div>
</nav>
<div class="container" style="margin-top:72px">
    

