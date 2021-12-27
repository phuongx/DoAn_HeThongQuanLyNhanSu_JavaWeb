<%-- 
    Document   : giaoViecView
    Created on : Sep 7, 2021, 8:18:05 PM
    Author     : Ms Phuong
--%>

<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <jsp:include page="_htmlHead.jsp"></jsp:include>
        <title>MP - Giao viec</title>  
        <script>
            var request;
            function TimKiem() {
             
                var maNV = document.frmTK.maNV.value;
                var url = "${pageContext.request.contextPath}/timnv?maNV=" + maNV;

                if (window.XMLHttpRequest) {
                    request = new XMLHttpRequest();
                } else if (window.ActiveXObject) {
                    request = new ActiveXObject("Microsoft.XMLHTTP");
                }

                try {
                    request.onreadystatechange = getInfo;
                    request.open("GET", url, true);
                    request.send();
                } catch (e) {
                    alert("Unable to connect to server");
                }
            }

            function getInfo() {
                if (request.readyState == 4) {
                 var val = request.responseText;
                 document.getElementById('rs_search').innerHTML = val;
                }
            }
            function XoaTB(){
                document.getElementById("oke").innerHTML="";
                document.getElementById("err").innerHTML="";
            }
            function KiemTra() {
           
                var noidung = document.frmGV.noidung.value;
                var ngayHT = document.frmGV.ngayHT.value;
                var gioHT = document.frmGV.gioHT.value;
                if (noidung=="" || ngayHT=="" || noidung==null || ngayHT==null){
                    document.getElementById("thongbao").innerHTML="(*): Các thông tin bắt buộc điền";
                    return false;
                }
                return true;
            }
        </script>

    </head>
    <body>
         <c:if test="${quyen=='1'}"><jsp:include page="_header.jsp"></jsp:include></c:if>
        <c:if test="${quyen=='2'}"><jsp:include page="_headerNhanvien.jsp"></jsp:include></c:if>
        <div id="err" style="color: red;">${errorString}</div>
        <div id="oke" style="color: blue;">${thongbao}</div>

        <div id="thongbao" style="color: red;"></div>
           
            <form action="${pageContext.request.contextPath}/giaoviec" method="POST" name="frmGV" onsubmit="return KiemTra()" class="form-horizontal">
                
                <div class="form-group">
                    <label class="control-label col-lg-4" for="nd">Nội dung công việc (*)</label>
                    <div class="col-lg-4">
                        <textarea class="form-control" rows="5" cols="30" id="nd" name="noidung"></textarea>
                    </div>
                    <div class="col-lg-4"></div>
                </div>
                <div class="form-group">
                    <label class="control-label col-lg-4" for="ngay">Ngày hết hạn (*)</label>
                    <div class="col-lg-4">
                        <input class="form-control" id="ngay" type="text" name="ngayHT" placeholder="yyyy-mm-dd">
                    </div>
                    <div class="col-lg-4"></div>
                </div>
                <div class="form-group">
                    <label class="control-label col-lg-4" for="gio">Giờ hết hạn</label>
                    <div class="col-lg-4">
                        <input class="form-control" id="ngay" type="text" name="gioHT" placeholder="hh:mm">
                    </div>
                    <div class="col-lg-4"></div>
                </div>
                <div class="form-group">        
                    <div class="col-lg-offset-5 col-lg-1">
                        <input type="submit" value="Gửi" class="btn btn-primary" onclick="return KiemTra()">
                    </div>
                    <div class="col-lg-6">
                        <a href="${pageContext.request.contextPath}/viec"><button type="button" class="btn btn-default">Hủy</button></a>
                    </div>
                </div>
            </form>
        
       <jsp:include page="_footer.jsp"></jsp:include>
    </body>
</html>