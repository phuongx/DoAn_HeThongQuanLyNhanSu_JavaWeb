<%-- 
    Document   : dsPhongBanView
    Created on : Aug 27, 2021, 9:30:25 PM
    Author     : Ms Phuong
--%>

<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Danh sach phong ban</title>
        <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
        <jsp:include page="_htmlHead.jsp"></jsp:include>
        <script type="text/javascript">
                $(document).ready(function() {

                        $('#buttonClickMe').click(function() {
                                $.ajax({
                                        type : 'GET',
                                        url : '${pageContext.request.contextPath }/addPhongBan',
                                        success : function(result) {
                                                $('#result').html(result);
                                        }
                                });
                        });

                });
        </script>
    </head>
    <body>
        <jsp:include page="_header.jsp"></jsp:include>
        <div class="row">
            <div class="col-lg-1"></div>
            <div class="col-lg-10">
                <p style="color: red;">${errorString}</p>
                <ul class="nav nav-tabs">
                    <li class="active"><a href="${pageContext.request.contextPath}/dsPhongBan">Danh sách phòng ban</a></li>
                    <li><c:if test="${loginedUser.tenVT=='Admin'}">
                        <input type="button" value="Thêm phòng ban mới" id="buttonClickMe" class="btn btn-primary">
                        </c:if></li>
                </ul>
                <br>

                <table class="table table-striped">
                    <tr class="text-right">
                        <th>Ma phong ban</th>   
                        <th>Ten phong ban</th>
                    </tr>

                <c:forEach items="${list}" var="values">
                    <tr>
                        <td>${values.maPB}</td>
                        <td>${values.tenPB}</td>

                    </tr>
                </c:forEach>
                </table>
                <span id="result"></span>
            </div>
            <div class="col-lg-1"></div>
        </div>
       <jsp:include page="_footer.jsp"></jsp:include>
    </body>
</html>


