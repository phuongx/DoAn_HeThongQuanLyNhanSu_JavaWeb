<%-- 
    Document   : timTinTD
    Created on : Nov 11, 2021, 2:27:17 AM
    Author     : Ms Phuong
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <p>Danh sách này có <b style="color:blue">${sodong}</b> dòng.</p>
        <form name="frm2">
            <table class="table table-striped table-bordered" >
                <tr class="info">
                    <th>Mã tin</th>                
                    <th>Phòng ban</th>
                    <th>Vị trí</th>
                    <th>Số lượng</th>
                    <th>Mô tả</th>
                    <th>Ngày nhận hồ sơ</th>
                    <th>Đến ngày</th> 
                    <th></th>
                    <th></th>
                </tr>
            <c:forEach items="${list}" var="values">
                <tr>
                    <td>${values.maTin}</td>
                    <td>${values.tenPB}</td>
                    <td>${values.tenVT}</td>
                    <td>${values.soluong}</td>
                    <td>${values.mota}</td>
                    <td>${values.ngayBD}</td>
                    <td>${values.ngayKT}</td>

                    <td class="text-center"><a href="#">Sửa</a></td>
                    <td class="text-center"><a href="#">Xóa</a></td>
                </tr>
            </c:forEach>
            </table>
        </form>
    </body>
</html>
