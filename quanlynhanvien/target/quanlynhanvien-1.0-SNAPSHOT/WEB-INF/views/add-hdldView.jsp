<%-- 
    Document   : add-hdldView
    Created on : Nov 12, 2021, 2:25:05 AM
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
            var maNV = document.frmTT.maNV.value;
            var ngayKy = document.frmTT.ngayKy.value;
            var ngayHH = document.frmTT.ngayHH.value;
            var hopdong = document.frmTT.hopdong.value;
            if (maNV=="" || ngayKy=="" || ngayHH=="" || hopdong="" ||
                    maNV==null || ngayKy==null || ngayHH==null || hopdong==null){
                alert("Các thông tin (*) không được trống.");
                return false;
            }
            return true;
        }
    </script>
</head>
<body>
    <jsp:include page="_header.jsp"></jsp:include>
    <p style="color:red;">${errorString}</p>
    
    <form action="${pageContext.request.contextPath}/add-hdld" method="POST" enctype="multipart/form-data" 
          class="form-horizontal" name="frmTT">
        <div class="form-group">
            <label class="control-label col-lg-4" for="ma">Hợp đồng cho nhân viên (*)</label>
            <div class="col-lg-5">
                <input class="form-control" id="ma" type="text" name="maNV" placeholder="Nhập mã nhân viên">
            </div>
            <div class="col-lg-3"></div>
        </div>
        <div class="form-group">
            <label class="control-label col-lg-4" for="ngay">Ngày ký hợp đồng (*)</label>
            <div class="col-lg-5">
                <input class="form-control" id="ngay" type="text" name="ngayKy" placeholder="yyyy-mm-dd">
            </div>
            <div class="col-lg-3"></div>
        </div>
        <div class="form-group">
            <label class="control-label col-lg-4" for="ngayhh">Ngày hết hạn hợp đồng (*)</label>
            <div class="col-lg-5">
                <input class="form-control" id="ngayhh" type="text" name="ngayHH" placeholder="yyyy-mm-dd">
            </div>
            <div class="col-lg-3"></div>
        </div>
        
        <div class="form-group">
            <label class="control-label col-lg-4" for="hopdong">Tải lên hợp đồng <i>(.pdf)</i> (*)</label>
            <div class="col-lg-5">
                <input class="form-control" type="file" id="hopdong" name="hopdong">
            </div>
            <div class="col-lg-3"></div>
        </div>
        <div class="form-group">        
            <div class="col-lg-offset-5 col-lg-1">
                <input type="submit" value="Lưu" class="btn btn-primary" onclick="return KiemTra()">
            </div>
            <div class="col-lg-6">
                <a href="${pageContext.request.contextPath}/danhSachNV"><button type="button" class="btn btn-danger">Hủy</button></a>
            </div>
        </div>
    </form>

    <jsp:include page="_footer.jsp"></jsp:include>
</body>
</html>


