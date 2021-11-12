<%-- 
    Document   : qlyTinTuyenDungView
    Created on : Nov 11, 2021, 1:41:36 AM
    Author     : Ms Phuong
--%>

<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <title>MP - Tuyển dụng</title>
        <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
        <jsp:include page="_htmlHead.jsp"></jsp:include>
        <script>
            var request;
            function TimTheoTen(ten) {
                var col_name = document.frmTK.col_name.value;
                var url = "${pageContext.request.contextPath}/timtintd?ten=" + ten +"&col_name="+col_name;

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
        <form name="frmTK">
            <div class="row">
            <div class="col-lg-3"></div>
            <div class="form-group col-lg-2">
                <select class="form-control" id="sel1" name="col_name">
                        <option selected="selected" value="ma_tin">Mã tin</option>
                        <option value="ten_pb" >Phòng ban</option>
                        <option value="ten_vt" >Vị trí</option>
                    </select>
            </div>
            <div class="col-lg-3">
                <input class="form-control" type="text" name ="ten" onkeyup="TimTheoTen(this.value)" placeholder="Nhập để tìm kiếm">
            </div>
            <div class="col-lg-4"></div>
            </div>
        </form>
        
        <div id="result">    
            <p>Danh sách này có <b style="color:blue">${sodong}</b> dòng.</p>
        <form name="frm2">
            <table class="table table-striped table-bordered" >
                <tr class="info">
                    <th>Mã tin</th>                
                    <th>Phòng ban</th>
                    <th>Vị trí</th>
                    <th>Số lượng</th>
                    <th>Mô tả</th>
                    <th>Ngày nhận hồ sơ</th>
                    <th>Đến ngày</th> 
                    <th></th>
                    <th></th>
                </tr>
            <c:forEach items="${list}" var="values">
                <tr>
                    <td>${values.maTin}</td>
                    <td>${values.tenPB}</td>
                    <td>${values.tenVT}</td>
                    <td>${values.soluong}</td>
                    <td>${values.mota}</td>
                    <td>${values.ngayBD}</td>
                    <td>${values.ngayKT}</td>

                    <td class="text-center"><a href="#">Sửa</a></td>
                    <td class="text-center"><a href="#">Xóa</a></td>
                </tr>
            </c:forEach>
            </table>
        </form>
        </div> 
       <jsp:include page="_footer.jsp"></jsp:include>
    </body>
</html>
