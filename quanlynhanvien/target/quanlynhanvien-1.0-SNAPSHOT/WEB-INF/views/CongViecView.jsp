<%-- 
    Document   : CongViecView
    Created on : Sep 26, 2021, 9:56:19 PM
    Author     : Ms Phuong
--%>

<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <jsp:include page="_htmlHead.jsp"></jsp:include>
        <title>Việc cần làm</title>
        <script>
            var request;
            function TimKiem() {
             
                var status = document.frmTK.status.value;
                var url = "${pageContext.request.contextPath}/dsViecLam?trangthai="+status;

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
            function DanhDauHT(maCV) {
             
                var url = "${pageContext.request.contextPath}/danhDauHT_CV?maCV="+maCV;

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
                    document.getElementById('xemViec').innerHTML = val;
                }
            }
            
        </script>
    </head>
    <body>
        <jsp:include page="_header.jsp"></jsp:include>
        <form name="frmTK" class="form-horizontal">
             
            <div class="form-group">
                <label class="control-label col-lg-4" for="st">Trạng thái:</label>
                <div class="col-lg-4">
                    <div class="input-group">
                        <select class="form-control" id="st" name="status">
                            <option value="Chua hoan thanh" selected="selected">Chua hoan thanh</option>
                            <option value="Hoan thanh">Hoan thanh</option>
                        </select>
                        <div class="input-group-btn">
                            <button class="btn btn-primary" type="button" onclick="TimKiem()"><i class="glyphicon glyphicon-search"></i></button>
                        </div>
                    </div>
                </div>
                <div class="col-lg-4"></div>
            </div>
            
        </form>
        <div id="xemViec">
        <c:import url="/dsViecLam"/>
        </div>
        <jsp:include page="_footer.jsp"></jsp:include>
    </body>
</html>