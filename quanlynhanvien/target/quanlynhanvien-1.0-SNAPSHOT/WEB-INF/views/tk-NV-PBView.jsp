<%-- 
    Document   : tk-NV-PBView
    Created on : Nov 13, 2021, 1:40:09 AM
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
                        <th>Mã phòng ban</th>   
                        <th>Tên phòng ban</th>
                        <th class="text-center">Tổng số nhân viên</th>
                        <th class="text-center"> Xem danh sách </th>
                    </tr>

                <c:forEach items="${list}" var="values">
                    <tr>
                        <td>${values.key.maPB}</td>
                        <td>${values.key.tenPB}</td>
                        <td class="text-center">${values.value}</td>
                        <td class="text-center"><a href="${pageContext.request.contextPath}/getlist?name=PhongBan&val=${values.key.tenPB}" target="_blank">Xem</a></td>
                    </tr>
                </c:forEach>
                </table>
            </div>
            <div class="col-lg-1"></div>
        </div>
       <jsp:include page="_footer.jsp"></jsp:include>
    </body>
</html>


