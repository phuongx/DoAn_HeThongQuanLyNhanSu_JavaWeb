<%-- 
    Document   : tinTuyenDungView
    Created on : Oct 10, 2021, 10:02:57 PM
    Author     : Ms Phuong
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Tuyển dụng</title>
        <jsp:include page="_htmlHead.jsp"></jsp:include>

    </head>
    <body>
        <c:if test="${empty loginedUser}"><jsp:include page="_headerHome.jsp"></jsp:include></c:if>
        <c:if test="${not empty loginedUser}"><jsp:include page="_header.jsp"></jsp:include></c:if>
        <div class="row">
            <div class="col-lg-3">
                Tuyển dụng
            </div>
            <div class="col-lg-6">
                Tin Tức
            </div>
            <div class="col-lg-3">
                Sự kiện
            </div>
        </div>
        

        <jsp:include page="_footer.jsp"></jsp:include>

    </body>
</html>