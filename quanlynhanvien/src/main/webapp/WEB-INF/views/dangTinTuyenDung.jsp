<%-- 
    Document   : dangTinTuyenDung
    Created on : Oct 7, 2021, 11:45:55 PM
    Author     : Ms Phuong
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <jsp:include page="_htmlHead.jsp"></jsp:include>
        <title>MP - Tuyển dụng</title>
        <script>
            function KiemTra() {
                var mota = document.frmTT.mota.value;
                var soluong = document.frmTT.soluong.value;
                var ngaybd = document.frmTT.ngayBD.value;
                var ngaykt = document.frmTT.ngayKT.value;
                if ( mota=="" || soluong=="" || ngaykt=="" || ngaybd=="" || 
                    mota==null || soluong==null || ngaykt==null || ngaybd==null ){
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
        
        <form method="post" action="${pageContext.request.contextPath}/tintuyendung/add" class="form-horizontal" name="frmTT">
            
            <div class="form-group">
                <label class="control-label col-lg-3" for="pb">Phòng ban *</label>
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
                <label class="control-label col-lg-3" for="vt">Vị trí việc làm *</label>
                <div class="col-lg-6">
                    <input type="text" class="form-control" id="vt" name="tenVT" placeholder="Nhập Vị trí việc làm">
                </div>
                <div class="col-lg-3"></div>
            </div>
             
            <div class="form-group">
                <label class="control-label col-lg-3" for="soluong">Số lượng *</label>
                <div class="col-lg-6">
                  <input type="text" class="form-control" id="soluong" name="soluong" placeholder="Nhập số lượng">
                </div>
                <div class="col-lg-3"></div>
            </div>
            <div class="form-group">
                <label class="control-label col-lg-3" for="mt">Mô tả ngắn gọn *</label>
                <div class="col-lg-6">
                    <textarea class="form-control" rows="5" cols="30" id="mt" name="mota"></textarea>
                </div>
                <div class="col-lg-3"></div>
            </div>
            <div class="form-group">
                <label class="control-label col-lg-3" for="ngaybd">Ngày bắt đầu *</label>
                <div class="col-lg-6">
                    <input class="form-control" id="ngaybd" type="text" name="ngayBD" placeholder="yyyy-mm-dd">
                </div>
                <div class="col-lg-3"></div>
            </div>
            <div class="form-group">
                <label class="control-label col-lg-3" for="ngaykt">Ngày kết thúc *</label>
                <div class="col-lg-6">
                    <input class="form-control" id="ngaykt" type="text" name="ngayKT" placeholder="yyyy-mm-dd">
                </div>
                <div class="col-lg-3"></div>
            </div>
            <div class="form-group">        
                <div class="col-lg-offset-5 col-lg-1">
                    <input type="submit" value="Đăng" class="btn btn-primary" onclick="return KiemTra()" >
                </div>
                <div class="col-lg-6">
                    <input type="reset" class="btn btn-danger" value="Làm lại">
                </div>
            </div>
        </form>
        <jsp:include page="_footer.jsp"></jsp:include>
    </body>
</html>
