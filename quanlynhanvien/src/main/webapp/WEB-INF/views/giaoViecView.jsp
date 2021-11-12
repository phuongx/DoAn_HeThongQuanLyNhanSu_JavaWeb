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
                var url = "${pageContext.request.contextPath}/timNV?maNV=" + maNV;

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
             
                var maNV = document.frmGV.maNV.value;
                var noidung = document.frmGV.noidung.value;
                var ngayHT = document.frmGV.ngayHT.value;
                var gioHT = document.frmGV.gioHT.value;
                if (maNV=="" || noidung=="" || ngayHT=="" || maNV==null || noidung==null || ngayHT==null){
                    document.getElementById("thongbao").innerHTML="(*): Các thông tin bắt buộc điền";
                    return false;
                }
                return true;
            }
        </script>

    </head>
    <body>
         <jsp:include page="_header.jsp"></jsp:include>
        <div id="err" style="color: red;">${errorString}</div>
        <div id="oke" style="color: blue;">${thongbao}</div>

        <form  name="frmTK" class="form-horizontal">
            <div class="form-group">
                <div class="col-lg-4"></div>
                <div class="col-lg-4">
                    <div class="input-group">
                        <input class="form-control" type="text" name ="maNV" value="${user.maNV}" onClick="XoaTB()" placeholder="Nhập mã nhân viên">
                        <div class="input-group-btn">
                            <button class="btn btn-primary" type="button" onclick="TimKiem()"><i class="glyphicon glyphicon-search"></i></button>
                        </div>
                    </div>
                </div>
                <div class="col-lg-4"></div>
            </div>
        </form>
           
        <div id="rs_search">
            
        </div>
        
       <jsp:include page="_footer.jsp"></jsp:include>
    </body>
</html>