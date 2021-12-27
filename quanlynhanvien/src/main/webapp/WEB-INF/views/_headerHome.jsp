<%-- 
    Document   : _headerHome
    Created on : Aug 8, 2021, 11:09:50 AM
    Author     : Ms Phuong
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<nav class="navbar navbar-inverse navbar-fixed-top" >
    <div class="container-fluid">
        <div class="navbar-header">
            <a href="${pageContext.request.contextPath}/home" class="navbar-brand" style="color: lightgrey; font-size: 30px">MP</a>
        </div>

        <ul class="nav navbar-nav">
            <li class="active"><a href="${pageContext.request.contextPath}/">Home</a></li>
            <li><a href="${pageContext.request.contextPath}/tintuyendung">Tuyển dụng</a></li>
        </ul>

        <ul class="nav navbar-nav navbar-right">
          <li><a href="${pageContext.request.contextPath}/login"><span class="glyphicon glyphicon-log-in"></span> Login</a></li> 
        </ul>
    </div>
</nav>
<div class="container" style="margin-top:50px">

