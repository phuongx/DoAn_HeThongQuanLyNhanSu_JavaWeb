<%-- 
    Document   : addNVView
    Created on : Aug 25, 2021, 11:55:45 PM
    Author     : Ms Phuong
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <jsp:include page="_htmlHead.jsp"></jsp:include>
        <title>Them nhan vien moi</title>
        <script>
            function KiemTra() {
             
                var maNV = document.frmTT.maNV.value;
                var password = document.frmTT.password.value;
                var repassword = document.frmTT.repassword.value;
                var hoten = document.frmTT.hoten.value;
                var cmnd = document.frmTT.cmnd.value;
                var email = document.frmTT.email.value;
                var gioitinh = document.frmTT.gioitinh.value;
                var diachi = document.frmTT.diachi.value;
                var ngaybd = document.frmTT.ngayBD.value;
                if (maNV=="" || password=="" || hoten=="" || gioitinh=="" || diachi=="" || ngaybd=="" ||
                    cmnd=="" || email=="" || maNV==null || password==null || hoten==null || gioitinh==null || 
                    diachi==null || ngaybd==null || cmnd==null || email==null ){
                    alert("Các thông tin (*) không được trống.");
                    return false;
                }
                if (password!=repassword){
                    alert("Mật khẩu không khớp.");
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
        <form action="${pageContext.request.contextPath}/addNV" method="POST" class="form-horizontal" name="frmTT">
            <div class="form-group">
                <label class="control-label col-lg-3" for="manv">Mã nhân viên (*)</label>
                <div class="col-lg-6">
                    <input class="form-control" id="manv" type="text" name="maNV" value="${maNV}">
                </div>
                <div class="col-lg-3"></div>
            </div>
                
            <div class="form-group">
                <label class="control-label col-lg-3" for="pass">Mật khẩu (*)</label>
                <div class="col-lg-6">
                    <input class="form-control" id="pass" type="password"  name="password" placeholder="Nhập mật khẩu">
                </div>
                <div class="col-lg-3"></div>
            </div>
                
            <div class="form-group">
                <label class="control-label col-lg-3" for="re-pass">Nhập lại mật khẩu (*)</label>
                <div class="col-lg-6">
                    <input class="form-control" id="re-pass" type="password"  name="repassword" placeholder="Nhập lại mật khẩu">
                </div>
                <div class="col-lg-3"></div>
            </div>    
                
            <div class="form-group">
                <label class="control-label col-lg-3" for="hoten">Họ và tên (*)</label>
                <div class="col-lg-6">
                    <input class="form-control" id="hoten" type="text" name="hoten" placeholder="Nhập họ và tên">
                </div>
                <div class="col-lg-3"></div>
            </div>
            
            <div class="form-group">
                <label class="control-label col-lg-3" for="cmnd">CMND/CCCD (*)</label>
                <div class="col-lg-6">
                    <input class="form-control" id="cmnd" type="text" name="cmnd" placeholder="Nhập CMND/CCCD">
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
                <label class="control-label col-lg-3" for="gt">Giới tính (*)</label>
                <div class="col-lg-6">
                    <input class="form-control" id="gt" type="text" name="gioitinh" placeholder="Nam/Nu">
                </div>
                <div class="col-lg-3"></div>
            </div>
                
            <div class="form-group">
                <label class="control-label col-lg-3" for="dc">Địa chỉ (*)</label>
                <div class="col-lg-6">
                    <input class="form-control" id="dc" type="text" name="diachi" placeholder="Nhập địa chỉ">
                </div>
                <div class="col-lg-3"></div>
            </div> 
                
            <div class="form-group">
                <label class="control-label col-lg-3" for="pb">Phòng ban (*)</label>
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
                <label class="control-label col-lg-3" for="vt">Vị trí việc làm (*)</label>
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
                <label class="control-label col-lg-3" for="ngay">Ngày bắt đầu (*)</label>
                <div class="col-lg-6">
                    <input class="form-control" id="ngay" type="text" name="ngayBD" placeholder="yyyy-mm-dd">
                </div>
                <div class="col-lg-3"></div>
            </div>
            
            <div class="form-group">
                <label class="control-label col-lg-3" for="gc">Ghi chú</label>
                <div class="col-lg-6">
                    <input class="form-control" id="gc" type="text" name="ghichu" placeholder="Ghi chú">
                </div>
                <div class="col-lg-3"></div>
            </div>
                
            <div class="form-group">        
                <div class="col-lg-offset-5 col-lg-1">
                    <input type="submit" value="Lưu" class="btn btn-primary" onclick="return KiemTra()">
                </div>
                <div class="col-lg-6">
                    <input type="reset" value="Làm lại" class="btn btn-danger">
                </div>
            </div>
        </form>
        
        <jsp:include page="_footer.jsp"></jsp:include>
    </body>
</html>
