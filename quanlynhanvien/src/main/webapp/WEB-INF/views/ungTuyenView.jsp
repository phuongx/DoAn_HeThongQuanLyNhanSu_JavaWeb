<%-- 
    Document   : ungTuyenView
    Created on : Sep 2, 2021, 9:54:07 PM
    Author     : Ms Phuong
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <jsp:include page="_htmlHead.jsp"></jsp:include>
    <title>Ung tuyen</title>
    <script>
        function KiemTra() {
            var hoten = document.frmTT.hoten.value;
            var sdt = document.frmTT.sdt.value;
            var email = document.frmTT.email.value;
            if (hoten=="" || sdt=="" || email=="" || hoten==null || sdt==null || email==null){
                alert("Các thông tin (*) không được trống.");
                return false;
            }
            return true;
        }
    </script>
</head>
<body>
    <c:if test="${empty loginedUser}"><jsp:include page="_headerHome.jsp"></jsp:include></c:if>
    <c:if test="${not empty loginedUser}"><jsp:include page="_header.jsp"></jsp:include></c:if>
    <p style="color:red;">${errorString}</p>
    <p><i style="color: red">Lưu ý: Cần điền đầy đủ các trường thông tin (*) bên dưới.</i></p>
    <form action="${pageContext.request.contextPath}/ungTuyen" method="POST" enctype="multipart/form-data" 
          class="form-horizontal" name="frmTT">
        <div class="form-group">
            <label class="control-label col-lg-3" for="hoten">Họ và tên (*)</label>
            <div class="col-lg-6">
                <input class="form-control" id="hoten" type="text" name="hoten" placeholder="Nhập họ và tên">
            </div>
            <div class="col-lg-3"></div>
        </div>
        <div class="form-group">
            <label class="control-label col-lg-3" for="sdt">Số điện thoại (*)</label>
            <div class="col-lg-6">
                <input class="form-control" id="sdt" type="text" name="sdt" placeholder="Nhập số điện thoại">
            </div>
            <div class="col-lg-3"></div>
        </div>
        <div class="form-group">
            <label class="control-label col-lg-3" for="email">Email (*)</label>
            <div class="col-lg-6">
                <input class="form-control" id="email" type="text" name="email" placeholder="Nhập email">
            </div>
            <div class="col-lg-3"></div>
        </div>
        <div class="form-group">
            <label class="control-label col-lg-3" for="vt">Vị trí ứng tuyển (*)</label>
            <div class="col-lg-6">
                <select class="form-control" id="vt" name="tenVT">
                    <c:forEach items="${listVT}" var="values">
                        <option value="${values.tenVT}">${values.maVT}-${values.tenVT}</option>
                    </c:forEach>
                </select>
            </div>
            <div class="col-lg-3"></div>
        </div>
        <div class="form-group">
            <label class="control-label col-lg-3" for="pb">Phòng ban ứng tuyển (*)</label>
            <div class="col-lg-6">
                <select class="form-control" id="pb" name="tenPB">
                    <c:forEach items="${listPB}" var="values">
                        <option value="${values.tenPB}">${values.maPB}-${values.tenPB}</option>
                    </c:forEach>
                </select>
            </div>
            <div class="col-lg-3"></div>
        </div>      
        <div class="form-group">
            <label class="control-label col-lg-3" for="cv">Tải lên CV (*)</label>
            <div class="col-lg-6">
                <input class="form-control" type="file" id="cv" name="cv">
            </div>
            <div class="col-lg-3"></div>
        </div>
        <div class="form-group">        
            <div class="col-lg-offset-5 col-lg-1">
                <input type="submit" value="Gửi" class="btn btn-primary" onclick="return KiemTra()">
            </div>
            <div class="col-lg-6">
                <a href="${pageContext.request.contextPath}/danhSachNV"><button type="button" class="btn btn-danger">Hủy</button></a>
            </div>
        </div>
    </form>

    <jsp:include page="_footer.jsp"></jsp:include>
</body>
</html>

