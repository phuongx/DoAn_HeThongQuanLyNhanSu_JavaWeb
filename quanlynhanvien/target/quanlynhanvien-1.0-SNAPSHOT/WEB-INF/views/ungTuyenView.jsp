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
    <title>MP - Quản lý nhân sự</title>
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
    <c:if test="${quyen=='1'}"><jsp:include page="_header.jsp"></jsp:include></c:if>
    <c:if test="${quyen=='2'}"><jsp:include page="_headerNhanvien.jsp"></jsp:include></c:if>
    <p style="color:red;">${errorString}</p>
    
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
            <label class="control-label col-lg-3" for="vt">Tên vị trí ứng tuyển (*)</label>
            <div class="col-lg-6">
                <input class="form-control" id="vt" type="text" name="tenVT" value="${tin.tenVT}">
            </div>
            <div class="col-lg-3"></div>
        </div>
        <div class="form-group">
            <label class="control-label col-lg-3" for="pb">Phòng ban ứng tuyển (*)</label>
            <div class="col-lg-6">
                <input class="form-control" id="vt" type="text" name="tenPB" value="${tin.tenPB}">
            </div>
            <div class="col-lg-3"></div>
        </div>      
        <div class="form-group">
            <label class="control-label col-lg-3" for="cv">Tải lên CV <i>(.pdf)</i> (*)</label>
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

