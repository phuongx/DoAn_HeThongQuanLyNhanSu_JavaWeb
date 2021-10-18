<%-- 
    Document   : danhSachNVView
    Created on : Aug 25, 2021, 8:19:55 PM
    Author     : Ms Phuong
--%>

<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Danh sach nhan vien</title>
        <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
        <jsp:include page="_htmlHead.jsp"></jsp:include>
        <script>
            function check_confirm(maNV) {
                var name = confirm("Bạn có chắc muốn thêm người này vào danh sách thôi việc?");
                if (name == true) {
                    window.location.replace("${pageContext.request.contextPath}/addNVTV?maNV="+maNV);
                } 
            }
            var request;
            function TimTheoTen(ten) {
                var trangthai = document.frmLoc.trangthai.value;
                var url = "${pageContext.request.contextPath}/timTheoTen?ten=" + ten +"&trangthai="+trangthai;

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
        
        <form action="${pageContext.request.contextPath }/danhSachNV" method="get" name="frmLoc">
            <div class="col-lg-9"></div>
            <div class="form-group col-lg-3" >
                <div class="input-group">
                    <select class="form-control" id="sel1" name="trangthai">
                        <option selected="selected" value="${trangthai}">${trangthai}</option>
                        <c:if test="${trangthai!='Hoat dong'}"><option value="Hoat dong" >Hoat dong</option></c:if>
                        <c:if test="${trangthai!='Da nghi viec'}"><option value="Da nghi viec">Da nghi viec</option></c:if>
                        <c:if test="${trangthai!='Tat ca'}"><option value="Tat ca" >Tat ca</option></c:if>
                    </select>
                    <div class="input-group-btn">
                        <button class="btn btn-default" type="submit"><i class="glyphicon glyphicon-search"></i></button>
                    </div>
                </div>
            </div>  
        </form>
    <form name="TK">
        <div class="col-lg-4"></div>
        <div class="form-group col-lg-4" >
            <input class="form-control" type="text" name ="ten" onkeyup="TimTheoTen(this.value)" placeholder="Nhập họ tên để tìm kiếm">
        </div>
        <div class="col-lg-4"></div>
    </form>
    <div id="result">    
    <form name="frm2">
        <table class="table table-striped" >
            <tr class="text-center">
                <th>Mã nhân viên</th>                
                <th>Họ tên</th>
                <th>Email</th>
                <th>Giới tính</th>
                <th>Phòng ban</th>
                <th>Vị trí</th>
                
                <th>Xem chi tiết</th>
                <c:if test="${not empty role}">
                <th>Chỉnh sửa</th>
                <th>Thêm thành tích</th>
                <th>Thêm vi phạm</th>
                </c:if>
                <c:if test="${loginedUser.tenVT=='Admin'}">
                <th>Thôi việc</th>  
                </c:if>
                
            </tr>
        <c:forEach items="${list}" var="values">
            <tr>
                <input type="hidden" name="maNV${values.maNV}" value="${values.maNV}">
                <td>${values.maNV}</td>
                <td>${values.hoten}</td>
                <td>${values.email}</td>
                <td>${values.gioitinh}</td>
                <td>${values.tenPB}</td>
                <td>${values.tenVT}</td>
                
                <td class="text-center"><a href="thongTinNV?maNV=${values.maNV}">Xem</a></td>
                <c:if test="${values.tenTT!='Thoi viec'}">
                    <c:if test="${not empty role}">
                    <td class="text-center"><a href="editTTNV?maNV=${values.maNV}">Sửa</a></td>
                    <td class="text-center"><a href="addThanhTich?maNV=${values.maNV}">Thêm</a></td>
                    <td class="text-center"><a href="addViPham?maNV=${values.maNV}">Thêm</a></td>  
                    </c:if>
                    <c:if test="${loginedUser.tenVT=='Admin'}">
                    <td class="text-center"><input type="button" class="btn btn-danger" value="Đánh dấu" onclick="check_confirm(maNV${values.maNV}.value)"></td>  
                    </c:if>
                </c:if>
                <c:if test="${values.tenTT=='Thoi viec'}">
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                </c:if>
            </tr>
        </c:forEach>
        </table>
    </form>
    </div> 
       <jsp:include page="_footer.jsp"></jsp:include>
    </body>
</html>

