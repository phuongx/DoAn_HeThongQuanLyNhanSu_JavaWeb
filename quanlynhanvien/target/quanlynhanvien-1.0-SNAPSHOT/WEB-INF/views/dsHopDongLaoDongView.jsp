<%-- 
    Document   : dsHopDongLaoDongView
    Created on : Nov 12, 2021, 1:24:37 AM
    Author     : Ms Phuong
--%>

<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <title>MP - Nhan vien</title>
        <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
        <jsp:include page="_htmlHead.jsp"></jsp:include>
        <script>
            
            var request;
            function TimTheoMa(ma) {
                var url = "${pageContext.request.contextPath}/timhd-manv?ma=" + ma;

                if (window.XMLHttpRequest) {
                    request = new XMLHttpRequest();
                } else if (window.ActiveXObject) {
                    request = new ActiveXObject("Microsoft.XMLHTTP");
                }

                try {
                    request.onreadystatechange = getInfo;
                    request.open("GET", url, true);
                    request.send();
                } catch (e) {
                    alert("Unable to connect to server");
                }
            }

            function getInfo() {
                if (request.readyState == 4) {
                 var val = request.responseText;
                 document.getElementById('result').innerHTML = val;
                }
            }
        </script>
    </head>
    <body>
        <jsp:include page="_header.jsp"></jsp:include>
        <p style="color: red;">${errorString}</p>
        <a href="${pageContext.request.contextPath}/add-hdld" ><input type="button" value="Thêm mới" class="btn btn-primary"></a>
    <form name="TK">
        <div class="row">
        <div class="col-lg-4"></div>
        <div class="form-group col-lg-4" >
            <input class="form-control" type="text" name ="ten" onkeyup="TimTheoMa(this.value)" placeholder="Nhập mã nhân viên để tìm kiếm">
        </div>
        <div class="col-lg-4"></div>
        </div>
    </form>
        
    <div id="result">    
        <p>Danh sách này có <b style="color:blue">${sodong}</b> dòng.</p>
    <form name="frm2">
        <table class="table table-striped " >
            <tr class="info">
                <th>Mã hợp đồng</th>                
                <th>Mã nhân viên</th>
                <th>Ngày ký</th>
                <th>Ngày hết hạn</th>
                <th>Xem</th> 
            </tr>
        <c:forEach items="${list}" var="values">
            <tr>
                <td>${values.maHD}</td>
                <td>${values.maNV}</td>
                <td>${values.ngayKy}</td>
                <td>${values.ngayHetHan}</td>
                <td><a href="${values.url}" target="_blank">Mở</a></td>
            </tr>
        </c:forEach>
        </table>
    </form>
    </div> 
       <jsp:include page="_footer.jsp"></jsp:include>
    </body>
</html>


