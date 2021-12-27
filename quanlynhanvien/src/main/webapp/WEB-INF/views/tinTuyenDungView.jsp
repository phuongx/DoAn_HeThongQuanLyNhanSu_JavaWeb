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
        <title>MP - Tuyển dụng</title>
        <jsp:include page="_htmlHead.jsp"></jsp:include>

    </head>
    <body>
        <c:if test="${empty loginedUser}"><jsp:include page="_headerHome.jsp"></jsp:include></c:if>
        <c:if test="${quyen=='1'}"><jsp:include page="_header.jsp"></jsp:include></c:if>
        <c:if test="${quyen=='2'}"><jsp:include page="_headerNhanvien.jsp"></jsp:include></c:if>
        <div class="row">
            <div class="col-lg-1">
            </div>
            <div class="col-lg-9">
                <h2>Tuyển dụng</h2>
                
                <div class="panel-group" id="accordion">
            <c:forEach items="${tin}" var="value">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            <h4 class="panel-title">
                                <a data-toggle="collapse" data-parent="#accordion" href="#${value.maTin}">${value.tenVT}</a>
                            </h4>
                        </div>
                        <div id="${value.maTin}" class="panel-collapse collapse in">
                            <div class="panel-body">
                                Số lượng: ${value.soluong}<br>
                                Mô tả/ Yêu cầu:<br>
                                ${value.mota}<br>
                                Thời gian nhận hồ sơ: từ ${value.ngayBD} đến ${value.ngayKT} <br><br>
                                <a href="${pageContext.request.contextPath}/ungtuyen?id=${value.maTin}">
                                    <input type="button" class="btn btn-success" value="Apply Now"></a>
                            </div>
                        </div>
                    </div>
                        </c:forEach>
                </div>
            </div>
            <div class="col-lg-1">
            </div>
        </div>
        

        <jsp:include page="_footer.jsp"></jsp:include>

    </body>
</html>