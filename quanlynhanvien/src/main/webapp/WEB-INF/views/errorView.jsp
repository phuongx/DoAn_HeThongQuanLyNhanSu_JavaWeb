<%-- 
    Document   : errorView
    Created on : Aug 24, 2021, 9:31:19 PM
    Author     : Ms Phuong
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
       <jsp:include page="_htmlHead.jsp"></jsp:include>
       <title>Error</title>
    </head>
    <body>


       <c:if test="${empty loginedUser}"><jsp:include page="_headerHome.jsp"></jsp:include></c:if>
       <c:if test="${not empty loginedUser}"><jsp:include page="_header.jsp"></jsp:include></c:if>

        <div class="alert alert-danger">
            <strong>Rất tiếc!</strong> ${errorString}
        </div>


       <jsp:include page="_footer.jsp"></jsp:include>

    </body>
</html>
