<%-- 
    Document   : tk-NV-TDHV-View
    Created on : Nov 13, 2021, 2:45:02 AM
    Author     : Ms Phuong
--%>

<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <title>MP - Quản lý nhân sự</title>
        <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
        <jsp:include page="_htmlHead.jsp"></jsp:include>
        
    </head>
    <body>
        <jsp:include page="_header.jsp"></jsp:include>
        <div class="row">
            <div class="col-lg-1"></div>
            <div class="col-lg-10">
                <p>Danh sách này có <b style="color:blue">${sodong}</b> dòng.
                <table class="table table-striped table-bordered ">
                    <tr class="info">
                        <th class="text-center">Mã trình độ</th>   
                        <th>Tên trình độ</th>
                        <th class="text-center">Tổng số nhân viên</th>
                        <th class="text-center"> Xem danh sách </th>
                    </tr>

                <c:forEach items="${list}" var="values">
                    <tr>
                        <td class="text-center">${values.key.ma}</td>
                        <td>${values.key.ten}</td>
                        <td class="text-center">${values.value}</td>
                        <td class="text-center"><a href="${pageContext.request.contextPath}/getlist?name=TrinhDo&val=${values.key.ma}" target="_blank">Xem</a></td>
                    </tr>
                </c:forEach>
                </table>
            </div>
            <div class="col-lg-1"></div>
        </div>
       <jsp:include page="_footer.jsp"></jsp:include>
    </body>
</html>
