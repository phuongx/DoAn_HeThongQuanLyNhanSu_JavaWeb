<%-- 
    Document   : addPhongBanView
    Created on : Aug 27, 2021, 10:50:08 PM
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
        
        <h3>Thêm danh mục Phòng ban</h3>
        <p style="color:red;">${errorString}</p>
        <form method="post" action="${pageContext.request.contextPath}/phongban/add" class="form-horizontal"
              name="frmAdd">
            <div class="form-group">
                <label class="control-label col-lg-3" for="mapb">Mã phòng ban</label>
                <div class="col-lg-6">
                  <input type="text" class="form-control" id="mapb" name="maPB" value="${phongban.maPB}">
                </div>
                <div class="col-lg-3"></div>
             </div>
             <div class="form-group">
                <label class="control-label col-lg-3" for="tenpb">Tên phòng ban</label>
                <div class="col-lg-6">
                    <input type="text" class="form-control" id="tenpb" name="tenPB" value="${phongban.tenPB}" placeholder="Nhập tên">
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
