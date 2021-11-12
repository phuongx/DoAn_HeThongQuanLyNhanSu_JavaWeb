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
        <title>MP - Phòng ban</title>
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
        <script>
            function KiemTra() {
                var ma = document.frmAdd.maPB.value;
                var ten = document.frmAdd.tenPB.value;
                if (ma=="" || ten=="" ||  ma==null || ten==null){
                    alert("Các trường thông tin không được trống.");
                    return false;
                }
                return true;
            }
        </script>
    </head>
    <body>
        <jsp:include page="_header.jsp"></jsp:include>
        <div class="row">
            <div class="col-lg-2"></div>
            <div class="col-lg-8">
                <p style="color: red;">${errorString}</p>
                <ul class="nav nav-tabs">
                    <li class="active"><a href="${pageContext.request.contextPath}/dsPhongBan">Danh mục Phòng ban</a></li>
                    <li><c:if test="${quyen=='1'}">
                        <input type="button" value="Thêm mới" id="buttonClickMe" class="btn btn-primary">
                        </c:if></li>
                </ul>
                <br>
                <p>Danh sách này có <b style="color:blue">${sodong}</b> dòng.</p>
                <table class="table table-striped table-bordered ">
                    <tr class="info">
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
            <div class="col-lg-2"></div>
        </div>
       <jsp:include page="_footer.jsp"></jsp:include>
    </body>
</html>


