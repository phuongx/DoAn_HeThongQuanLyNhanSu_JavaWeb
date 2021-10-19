<%-- 
    Document   : editTTNVView
    Created on : Aug 28, 2021, 11:22:05 PM
    Author     : Ms Phuong
--%>

<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        
        <title>Chỉnh sửa thông tin</title>
        <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
        <jsp:include page="_htmlHead.jsp"></jsp:include>
        <script>
            function KiemTra() {

                var cmnd = document.frmTT.cmnd.value;
                var email = document.frmTT.email.value;
                var diachi = document.frmTT.diachi.value;
                var ngaybd = document.frmTT.ngayBD.value;
                if ( diachi=="" || ngaybd=="" || diachi==null || ngaybd==null
                        || cmnd=="" || email=="" || cmnd==null || email==null){
                    alert("Các thông tin không được trống.");
                    return false;
                }
                return true;
            }
            function KiemTraPW() {

                var password = document.frmPW.password.value;
                var repassword = document.frmPW.repassword.value;
                if ( password=="" || password==null ){
                    alert("Mật khẩu rỗng.");
                    return false;
                }
                if (password!=repassword){
                    alert("Mật khẩu không khớp.");
                    return false;
                }
                return true;
            }
            function ChangePass() {
                var maNV = document.frmTT.maNV.value;
                
                var url = "${pageContext.request.contextPath}/changePassword?maNV="+maNV;

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
        <div class="row">
            <div class="col-lg-1"></div>
            <div class="col-lg-10">
                <p style="color: red;">${errorString}</p>
                
                <ul class="nav nav-tabs">
                    <li class="active"><a href="${pageContext.request.contextPath}/editTTNV?maNV=${user.maNV}">Chỉnh sửa thông tin</a></li>
                    <c:if test="${loginedUser.tenVT=='Admin'}">
                    <li><input type="button" value="Đổi mật khẩu" class="btn btn-primary" onclick="ChangePass()"></li>
                    <li><input type="button" value="Thêm trình độ học vấn" class="btn btn-primary" onclick="ChangePass()"></li>
                    <li><input type="button" value="Thêm trình độ Ngoại ngữ" class="btn btn-primary" onclick="ChangePass()"></li>
                    </c:if>
                    
                </ul>
                <br>
                <span id="result">
            <form action="${pageContext.request.contextPath}/editTTNV" method="POST" class="form-horizontal" name="frmTT">
                <input type="hidden" name="maNV" value="${user.maNV}"/>
                <div class="form-group">
                    <label class="control-label col-lg-3">Mã nhân viên</label>
                    <div class="col-lg-6">
                        <p class="form-control-static">${user.maNV}</p>
                    </div>
                    <div class="col-lg-3"></div>
                </div>
                <div class="form-group">
                    <label class="control-label col-lg-3">Họ và tên</label>
                    <div class="col-lg-6">
                        <p class="form-control-static">${user.hoten}</p>
                    </div>
                    <div class="col-lg-3"></div>
                </div>
                <div class="form-group">
                    <label class="control-label col-lg-3" for="dc">Địa chỉ</label>
                    <div class="col-lg-6">
                        <input class="form-control" id="dc" type="text" name="diachi" value="${user.diachi}">
                    </div>
                    <div class="col-lg-3"></div>
                </div> 
                <div class="form-group">
                    <label class="control-label col-lg-3" for="cmnd">CMND/CCCD</label>
                    <div class="col-lg-6">
                        <input class="form-control" id="cmnd" type="text" name="cmnd" value="${user.cmnd}">
                    </div>
                    <div class="col-lg-3"></div>
                </div>

                <div class="form-group">
                    <label class="control-label col-lg-3" for="email">Email</label>
                    <div class="col-lg-6">
                        <input class="form-control" id="email" type="text" name="email" value="${user.email}">
                    </div>
                    <div class="col-lg-3"></div>
                </div>
               <div class="form-group">
                    <label class="control-label col-lg-3" for="pb">Phòng ban</label>
                    <div class="col-lg-6">
                        <select class="form-control" id="pb" name="tenPB">
                            <option value="${user.tenPB}" selected="selected">${user.tenPB}</option>
                            <c:forEach items="${listPB}" var="values">
                                <option value="${values.tenPB}">${values.maPB}-${values.tenPB}</option>
                            </c:forEach>
                        </select>
                    </div>
                    <div class="col-lg-3"></div>
                </div>
                <div class="form-group">
                    <label class="control-label col-lg-3" for="vt">Vị trí</label>
                    <div class="col-lg-6">
                        <select class="form-control" id="vt" name="tenVT">
                            <option value="${user.tenVT}" selected="selected">${user.tenVT}</option>
                            <c:forEach items="${listVT}" var="values">
                                <option value="${values.tenVT}">${values.maVT}-${values.tenVT}</option>
                            </c:forEach>
                        </select>
                    </div>
                    <div class="col-lg-3"></div>
                </div>

                <div class="form-group">
                    <label class="control-label col-lg-3" for="gc">Ghi chú</label>
                    <div class="col-lg-6">
                        <input class="form-control" id="gc" type="text" name="ghichu" placeholder="Ghi chú">
                    </div>
                    <div class="col-lg-3"></div>
                </div>
                <div class="form-group">        
                    <div class="col-lg-offset-5 col-lg-1">
                        <input type="submit" value="Lưu" class="btn btn-primary" onclick="return KiemTra()">
                    </div>
                    <div class="col-lg-6">
                        <a href="${pageContext.request.contextPath}/danhSachNV"><button type="button" class="btn btn-default">Hủy</button></a>
                    </div>
                </div>

           </form>
                    </span>
            </div>
            <div class="col-lg-1"></div>
        </div>
                
       <jsp:include page="_footer.jsp"></jsp:include>
    </body>
</html>

