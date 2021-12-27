<%-- 
    Document   : addTDNgoaiNgu
    Created on : Nov 11, 2021, 1:11:21 AM
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
        
        <h3>Thêm danh mục Trình độ ngoại ngữ</h3>
        <p style="color:red;">${errorString}</p>
        <form method="post" action="${pageContext.request.contextPath}/trinhdongoaingu/add" class="form-horizontal"
              name="frmAdd">
            <div class="form-group">
                <label class="control-label col-lg-3" for="ngonngu">Ngôn ngữ</label>
                <div class="col-lg-6">
                    <input type="text" class="form-control" id="ngonngu" name="ngonngu"  placeholder="Tiếng Anh/Tiếng Nhật/...">
                </div>
                <div class="col-lg-3"></div>
             </div>
             <div class="form-group">
                <label class="control-label col-lg-3" for="ten">Tên trình độ</label>
                <div class="col-lg-6">
                    <input type="text" class="form-control" id="ten" name="ten"  placeholder="Trình độ A/Trình độ B/...">
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
