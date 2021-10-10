<%-- 
    Document   : homeView
    Created on : Aug 7, 2021, 11:03:23 PM
    Author     : Ms Phuong
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Home Page</title>
        <jsp:include page="_htmlHead.jsp"></jsp:include>

    </head>
    <body>
        <c:if test="${empty loginedUser}"><jsp:include page="_headerHome.jsp"></jsp:include></c:if>
        <c:if test="${not empty loginedUser}"><jsp:include page="_header.jsp"></jsp:include></c:if>
        <div class="row">
            <div class="col-lg-3"></div>
            <div class="col-lg-9">
                <h3>Home Page</h3>
                He thong quan ly nhan vien <br><br>
                <b>It includes the following functions:</b>
                <ul>
                   <li>Login</li>
                   <li>Storing user information in cookies</li>
                   <li>Cac chuc nang danh co nguoi quan ly</li>
                   <li>Cac chuc nang danh cho nhan vien</li>

                </ul>
            </div>
        </div>

        <jsp:include page="_footer.jsp"></jsp:include>

    </body>
</html>