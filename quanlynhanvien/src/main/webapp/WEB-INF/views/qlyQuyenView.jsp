<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Quản lý quyền truy cập</title>
        <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
        <jsp:include page="_htmlHead.jsp"></jsp:include>
        <script>
            function check_confirm(maNV) {
                var name = confirm("Bạn có chắc muốn thay đổi quyền của người dùng này?");
                if (name == true) {
                    window.location.replace("${pageContext.request.contextPath}/quyen/thaydoi?id="+maNV);
                } 
            }
            
        </script>
    </head>
    <body>
        <jsp:include page="_header.jsp"></jsp:include>
        
        <p style="color: red;">${errorString}</p>
    <h4>Quyền Admin</h4>
        <p>Danh sách này có <b style="color:blue">${sodong1}</b> dòng.</p>
        <form name="frm2">
            <table class="table table-striped " >
                <tr class="info">
                    <th>Mã nhân viên</th>                
                    <th>Họ tên</th>
                    <th>Email</th>
                    <th>Phòng ban</th>
                    <th>Vị trí</th>
                    <th>Thay đổi</th>
                      
                </tr>
            <c:forEach items="${list1}" var="values">
                <tr>
                    <input type="hidden" name="maNV${values.maNV}" value="${values.maNV}">
                    <td>${values.maNV}</td>
                    <td>${values.hoten}</td>
                    <td>${values.email}</td>
                    <td>${values.tenPB}</td>
                    <td>${values.tenVT}</td>
                    <td ><input type="button" class="btn btn-danger" value="Gỡ quyền" onclick="check_confirm(maNV${values.maNV}.value)"></td>
  
                </tr>
            </c:forEach>
            </table>
        </form>
        <hr>
        <h4>Quyền Nhân viên</h4>
        <p>Danh sách này có <b style="color:blue">${sodong2}</b> dòng.</p>
        <form name="frm3">
            <table class="table table-striped " >
                <tr class="info">
                    <th>Mã nhân viên</th>                
                    <th>Họ tên</th>
                    <th>Email</th>
                    <th>Phòng ban</th>
                    <th>Vị trí</th>
                    <th>Thay đổi</th>
                      
                </tr>
            <c:forEach items="${list2}" var="values">
                <tr>
                    <input type="hidden" name="maNV${values.maNV}" value="${values.maNV}">
                    <td>${values.maNV}</td>
                    <td>${values.hoten}</td>
                    <td>${values.email}</td>
                    <td>${values.tenPB}</td>
                    <td>${values.tenVT}</td>
                    <td ><input type="button" class="btn btn-success" value="Cấp quyền" onclick="check_confirm(maNV${values.maNV}.value)"></td>
  
                </tr>
            </c:forEach>
            </table>
        </form>
       <jsp:include page="_footer.jsp"></jsp:include>
    </body>
</html>

