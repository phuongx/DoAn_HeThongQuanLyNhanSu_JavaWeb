<%-- 
    Document   : changePassword
    Created on : Oct 18, 2021, 11:18:17 PM
    Author     : Ms Phuong
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <p style="color:red;">${errorString}</p>
        <form method="post" action="${pageContext.request.contextPath}/changePassword" class="form-horizontal" name="frmPW">
            <input type="hidden" name="maNV" value="${maNV}"/>
            <div class="form-group">
                <label class="control-label col-lg-3">Mã nhân viên</label>
                <div class="col-lg-6">
                    <p class="form-control-static">${maNV}</p>
                </div>
                <div class="col-lg-3"></div>
            </div>
            <div class="form-group">
                <label class="control-label col-lg-3" for="password">Mật khẩu mới</label>
                <div class="col-lg-6">
                  <input type="password" class="form-control" id="password" name="password" placeholder="Nhập mật khẩu mới">
                </div>
                <div class="col-lg-3"></div>
             </div>
             <div class="form-group">
                <label class="control-label col-lg-3" for="repassword">Nhập lại mật khẩu</label>
                <div class="col-lg-6">
                  <input type="password" class="form-control" id="repassword" name="repassword" placeholder="Nhập lại mật khẩu">
                </div>
                <div class="col-lg-3"></div>
             </div>
            <div class="form-group">        
                <div class="col-lg-offset-5 col-lg-1">
                    <input type="submit" value="Lưu" class="btn btn-primary" onclick="return KiemTraPW()">
                </div>
                <div class="col-lg-6">
                    <a href="${pageContext.request.contextPath}/editTTNV"><button type="button" class="btn btn-default">Hủy</button></a>
                </div>
            </div>
        </form>
    </body>
</html>
