<%-- 
    Document   : dsHSUTChuaDuyetView
    Created on : Sep 4, 2021, 11:31:40 PM
    Author     : Ms Phuong
--%>

<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <title>MP - Ứng tuyển</title>
        <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
        <jsp:include page="_htmlHead.jsp"></jsp:include>
        <script type="text/javascript">
            $(document).ready(function() {

                $('#Search').submit(function() {
                    $.ajax({
                        type : 'POST',
                        url : '${pageContext.request.contextPath }/hsut/list',
                        success : function(result) {
                                $('#result').html(result);
                        }
                    });
                });

            });
        </script>
        <script>
            function KiemTra() {
                var ngay = document.frmTT.ngay.value;
                var ketqua = document.frmTT.ketqua.value;
                if (ketqua=="" || ngay=="" || ketqua==null || ngay==null){
                    alert("Các thông tin (*) không được trống.");
                    return false;
                }
                return true;
            }
            function DuyetHSUT(maHS) {
                
                var url = "${pageContext.request.contextPath}/hsut/duyet?maHS="+maHS;

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
                    document.getElementById('duyetHS').innerHTML = val;
                }
            }
        </script>
    </head>
    <body>
        <jsp:include page="_header.jsp"></jsp:include>
        <p style="color: red;">${errorString}</p>
        <form id="Search" method="post">
            <div class="row">
            <div class="col-lg-4"></div>
            <div class="form-group col-lg-4" >
                <div class="input-group">
                    <select class="form-control" id="sel1" name="trangthai">
                        <option selected="selected" value="${trangthai}">${trangthai}</option>
                        <c:if test="${trangthai!='Chua duyet'}"><option value="Chua duyet" >Chua duyet</option></c:if>
                        <c:if test="${trangthai!='Da duyet'}"><option value="Da duyet" >Da duyet</option></c:if>
                        <c:if test="${trangthai!='Tat ca'}"><option value="Tat ca" >Tat ca</option></c:if>
                    </select>
                    <div class="input-group-btn">
                        <button class="btn btn-default" type="submit"><i class="glyphicon glyphicon-search"></i></button>
                    </div>
                </div>
            </div>
            <div class="col-lg-4"></div>
            </div>
        </form>
                  
        <span id="result">
            <p>Danh sách này có <b style="color:blue">${sodong}</b> dòng.</p>
            <form name="frm1">
            <table class="table table-striped" >
                <tr class="text-center info">
                    <th>Mã hồ sơ</th>                
                    <th>Họ tên ứng viên</th>
                    <th>Số điện thoại</th>
                    <th>Email</th>
                    <th>Vị trí ứng tuyển</th>
                    <th>Phòng ban ứng tuyển</th>
                    <th>CV</th>
                <c:if test="${trangthai!='Chua duyet'}">
                    <th>Kết quả</th>
                    <th>Ngày duyệt</th>
                </c:if>
                <c:if test="${trangthai=='Chua duyet'}">
                    <th>Duyệt</th>
                </c:if>
                </tr>
            <c:forEach items="${list}" var="values">
                <tr>
                    <input type="hidden" name="maHS${values.maHS}" value="${values.maHS}">
                    <td>${values.maHS}</td>
                    <td>${values.hoten}</td>
                    <td>${values.sdt}</td>
                    <td>${values.email}</td>
                    <td>${values.tenVT}</td>
                    <td>${values.tenPB}</td>
                    <td><a href="${pageContext.request.contextPath}/file/cv/${values.urlCV}">Xem</a></td>
                <c:if test="${trangthai!='Chua duyet'}">
                    <td>${values.ketqua}</td>
                    <td>${values.ngayduyet}</td>
                </c:if>
                <c:if test="${trangthai=='Chua duyet'}">
                    <td><input type="button" class="btn btn-success" value="Duyệt" onclick="DuyetHSUT(maHS${values.maHS}.value)"></td>
                </c:if>
 
                </tr>
            </c:forEach>
            </table>
            </form>
        </span>
                    <div id="duyetHS"></div>
       <jsp:include page="_footer.jsp"></jsp:include>
    </body>
</html>

