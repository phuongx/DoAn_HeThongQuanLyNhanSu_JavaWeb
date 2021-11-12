<%-- 
    Document   : thongBaoView
    Created on : Sep 4, 2021, 9:32:44 PM
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

        <h4 style="color:red;">${errorString}</h4>
        <div class="alert alert-success">
            <strong>Xin chúc mừng!</strong> Bạn đã gửi hồ sơ ứng tuyển thành công.
        </div>
        <p>
            Xin chào <b>${hoso.hoten}</b>. <br>
            Mã số hồ sơ của bạn là: <b>${hoso.maHS}</b>. <br>
            Chúng tôi sẽ gửi kết quả qua email trong thời gian sớm nhất.<br>
            Cảm ơn bạn đã ứng tuyển.<br>
        </p>
       <jsp:include page="_footer.jsp"></jsp:include>

    </body>
</html>

