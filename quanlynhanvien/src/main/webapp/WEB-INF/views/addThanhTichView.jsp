<%-- 
    Document   : addThanhTichView
    Created on : Aug 25, 2021, 8:48:05 PM
    Author     : Ms Phuong
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <jsp:include page="_htmlHead.jsp"></jsp:include>
        <title>Them Thanh Tich</title>
        <script>
            function KiemTra() {
                var noidung = document.frmTT.noidung.value;
                var ngay = document.frmTT.ngay.value;
                if (noidung=="" || ngay=="" || noidung==null || ngay==null){
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
        <p><i style="color: red">Lưu ý: Cần điền đầy đủ các trường thông tin (*) bên dưới.</i></p>
        <form class="form-horizontal" action="${pageContext.request.contextPath}/addThanhTich" method="POST" name="frmTT">
            <input type="hidden" name="maNV" value="${user.maNV}">
            <div class="form-group">
                <label class="control-label col-lg-3">Mã nhân viên</label>
                <div class="col-lg-6">
                    <p class="form-control-static">${user.maNV}</p>
                </div>
                <div class="col-lg-3"></div>
            </div>
            <div class="form-group">
                <label class="control-label col-lg-3" for="nd">Nội dung (*)</label>
                <div class="col-lg-6">
                    <textarea class="form-control col-lg-6" rows="5" id="nd" name="noidung"></textarea>
                </div>
                <div class="col-lg-3"></div>
            </div>
            
            <div class="form-group">
                <label class="control-label col-lg-3" for="ngay">Ngày quyết định (*)</label>
                <div class="col-lg-6">
                    <input class="form-control" id="ngay" type="text" name="ngay" placeholder="yyyy-mm-dd">
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
        <jsp:include page="_footer.jsp"></jsp:include>
    </body>
</html>

