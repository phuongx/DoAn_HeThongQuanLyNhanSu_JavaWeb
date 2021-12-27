<%-- 
    Document   : thongBao01
    Created on : Oct 19, 2021, 12:20:15 AM
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
    </head>
    <body>


       <c:if test="${empty loginedUser}"><jsp:include page="_headerHome.jsp"></jsp:include></c:if>
       <c:if test="${quyen=='1'}"><jsp:include page="_header.jsp"></jsp:include></c:if>
        <c:if test="${quyen=='2'}"><jsp:include page="_headerNhanvien.jsp"></jsp:include></c:if>
        <div class="alert alert-success">
            <strong>Success!</strong> ${thongbao}
        </div>


       <jsp:include page="_footer.jsp"></jsp:include>

    </body>
</html>
