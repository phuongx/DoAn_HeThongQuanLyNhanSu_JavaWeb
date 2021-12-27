<%-- 
    Document   : dsChucVuView
    Created on : Nov 10, 2021, 3:28:42 AM
    Author     : Ms Phuong
--%>

<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <title>MP - Chuc vu</title>
        <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
        <jsp:include page="_htmlHead.jsp"></jsp:include>
        <script type="text/javascript">
                $(document).ready(function() {

                        $('#buttonClickMe').click(function() {
                                $.ajax({
                                        type : 'GET',
                                        url : '${pageContext.request.contextPath }/chucvu/add',
                                        success : function(result) {
                                                $('#result').html(result);
                                        }
                                });
                        });

                });
        </script>
        <script>
            function KiemTra() {
                var ma = document.frmAdd.maVT.value;
                var ten = document.frmAdd.tenVT.value;
                if (ma=="" || ten=="" ||  ma==null || ten==null){
                    alert("Các trường thông tin không được trống.");
                    return false;
                }
                return true;
            }
        </script>
    </head>
    <body>
        <c:if test="${quyen=='1'}"><jsp:include page="_header.jsp"></jsp:include></c:if>
        <c:if test="${quyen=='2'}"><jsp:include page="_headerNhanvien.jsp"></jsp:include></c:if>
        <div class="row">
            <div class="col-lg-2"></div>
            <div class="col-lg-8">
                <p style="color: red;">${errorString}</p>
                <ul class="nav nav-tabs">
                    <li class="active"><a href="${pageContext.request.contextPath}/chucvu/list">Danh mục Chức vụ/Vị trí</a></li>
                    <li><c:if test="${quyen=='1'}">
                        <input type="button" value="Thêm mới" id="buttonClickMe" class="btn btn-primary">
                        </c:if></li>
                </ul>
                <br>
                <p>Danh sách này có <b style="color:blue">${sodong}</b> dòng.</p>
                <table class="table table-striped">
                    <tr class="info">
                        <th>Mã chức vụ</th>   
                        <th>Tên chức vụ</th>
                        <th></th>
                        <th></th>
                    </tr>
                <c:forEach items="${list}" var="values">
                    <tr>
                        <td>${values.maVT}</td>
                        <td>${values.tenVT}</td>
                        <td><a href="${pageContext.request.contextPath}/unknown" target="_blank">Sửa</a></td>
                        <td><a href="${pageContext.request.contextPath}/unknown" target="_blank">Xóa</a></td>
                    </tr>
                </c:forEach>
                </table>
                <span id="result"></span>
            </div>
            <div class="col-lg-8"></div>
        </div>
       <jsp:include page="_footer.jsp"></jsp:include>
    </body>
</html>



