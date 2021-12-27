<%-- 
    Document   : addChucVuView
    Created on : Nov 10, 2021, 3:43:43 AM
    Author     : Ms Phuong
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Them phong ban</title>
    </head>
    <body>
        
        <h3>Thêm danh mục Chức vụ</h3>
        <p style="color:red;">${errorString}</p>
        <form method="post" action="${pageContext.request.contextPath}/chucvu/add" class="form-horizontal"
              name="frmAdd">
            <div class="form-group">
                <label class="control-label col-lg-3" for="mavt">Mã chức vụ</label>
                <div class="col-lg-6">
                  <input type="text" class="form-control" id="mavt" name="maVT" value="${vitri.maVT}">
                </div>
                <div class="col-lg-3"></div>
             </div>
             <div class="form-group">
                <label class="control-label col-lg-3" for="tenvt">Tên chức vụ</label>
                <div class="col-lg-6">
                  <input type="text" class="form-control" id="tenvt" name="tenVT" value="${vitri.tenVT}">
                </div>
                <div class="col-lg-3"></div>
             </div>
             <div class="form-group">        
                <div class="col-lg-offset-3 col-lg-9">
                    <input type="submit" value="Lưu" class="btn btn-primary" onclick="return KiemTra()">
                </div>
             </div>
        </form>
    </body>
</html>
