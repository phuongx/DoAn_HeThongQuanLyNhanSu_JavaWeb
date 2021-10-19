<%-- 
    Document   : loginView
    Created on : Aug 22, 2021, 11:39:26 PM
    Author     : Ms Phuong
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
     <jsp:include page="_htmlHead.jsp"></jsp:include>
     <title>Login Page</title>
  </head>
  <body>
 
    <c:if test="${empty loginedUser}"><jsp:include page="_headerHome.jsp"></jsp:include></c:if>
    <c:if test="${not empty loginedUser}"><jsp:include page="_header.jsp"></jsp:include></c:if>
    <br>
  
  <div class="alert alert-info">
      <p style="color: red;">${errorString}</p>
      <br>
    <form class="form-horizontal" action="${pageContext.request.contextPath}/login" method="POST">
        
      <div class="form-group">
        <label class="control-label col-lg-4" for="manv">Mã nhân viên</label>
        <div class="col-lg-4">
          <input type="text" class="form-control" id="manv" placeholder="Nhập mã nhân viên" name="maNV">
        </div>
        <div class="col-lg-4"></div>
      </div>
      <div class="form-group">
        <label class="control-label col-lg-4" for="pass">Password</label>
        <div class="col-lg-4">
          <input type="password" class="form-control" id="pass" placeholder="Nhập password" name="password">
        </div>
        <div class="col-lg-4"></div>
      </div>
      <div class="form-group">        
        <div class="col-lg-offset-4 col-lg-8">
          <div class="checkbox">
            <label><input type="checkbox" name="rememberMe" value= "Y" > Ghi nhớ</label>
          </div>
        </div>
      </div>
      <div class="form-group">        
        <div class="col-lg-offset-4 col-lg-8">
          <button type="submit" class="btn btn-primary">Submit</button>
        </div>
      </div>
    </form>  
    </div>
    <jsp:include page="_footer.jsp"></jsp:include>
 
  </body>
</html>

