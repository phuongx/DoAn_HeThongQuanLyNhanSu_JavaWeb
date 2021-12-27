<%-- 
    Document   : duyetHSUTView
    Created on : Oct 5, 2021, 11:14:03 PM
    Author     : Ms Phuong
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        
    </head>
    <body>
        <form class="form-horizontal" action="${pageContext.request.contextPath}/hsut/duyet" method="POST" name="frmTT">
            <input type="hidden" name="maHS" value="${maHS}">
            <div class="form-group">
                <label class="control-label col-lg-3">Mã hồ sơ</label>
                <div class="col-lg-6">
                    <p class="form-control-static">${values.maHS}</p>
                </div>
                <div class="col-lg-3"></div>
            </div>
            <div class="form-group">
                <label class="control-label col-lg-3" for="ngay">Ngày duyệt (*)</label>
                <div class="col-lg-6">
                    <input class="form-control" id="ngay" type="text" name="ngay" placeholder="yyyy-mm-dd">
                </div>
                <div class="col-lg-3"></div>
            </div>
            <div class="form-group">
                <label class="control-label col-lg-3" for="kq">Kết quả (*)</label>
                <div class="col-lg-6">
                    <input class="form-control" id="kq" type="text" name="ketqua" placeholder="Pass/Fail">
                </div>
                <div class="col-lg-3"></div>
            </div>
            <div class="form-group">        
                <div class="col-lg-offset-5 col-lg-1">
                    <input type="submit" value="Lưu" class="btn btn-primary" onclick="return KiemTra()">
                </div>
                <div class="col-lg-6">
                    <a href="${pageContext.request.contextPath}/hsut/list"><button type="button" class="btn btn-default">Hủy</button></a>
                </div>
            </div>
        </form>
    </body>
</html>
