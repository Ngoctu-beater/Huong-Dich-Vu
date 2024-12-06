<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Quản lý</title>
        <link rel="stylesheet" href="css/management.css" />
        <link href="css/menu.css" rel="stylesheet" type="text/css"/>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap/5.1.3/css/bootstrap.min.css">
    </head>
    <body style="margin: 0; padding: 0">
        <div class="container" style="display: flex; max-width: 100%">
            <div class="menu" style="width: 18%">
                <jsp:include page="menu.jsp" />
            </div>

            <div class="content" style="width: 82%">
                <h2>Quản lý xe</h2>

                <a href="add.jsp"><button class="add-button">Thêm xe</button></a>

                <!-- Search -->
                <form action="car" method="get" class="form-search">
                    <div class="search-box">
                        <input value="${txtSearch}" name="txt" type="text" placeholder="Search" />
                        <button type="submit">
                            <i class="fa fa-search"></i>
                        </button>
                    </div>
                </form>

                <!-- bảng hiển thị -->
                <table>
                    <thead>
                        <tr>
                            <th>ID</th>
                            <th>Tên</th>
                            <th>Giá</th>
                            <th>Năm SX</th>
                            <th>Xuất xứ</th>
                            <th></th>
                        </tr>
                    </thead>

                    <tbody>
                        <c:forEach items="${listCar}" var="o">
                            <tr>
                                <td>${o.id}</td>
                                <td>${o.tenXe}</td>
                                <td>${o.gia}</td>
                                <td>${o.nam}</td>
                                <td>${o.xuatXu}</td>
                                <td style="display: flex">
                                    <a href="LoadController?cid=${o.id}" style="margin-right: 5px"><button class="edit-button">Sửa</button></a>
                                    <a href="DeleteController?cid=${o.id}"><button class="delete-button">Xóa</button></a>
                                </td>
                            </tr>   
                        </c:forEach>  
                    </tbody>
                </table>

                <!-- các trang -->
                <div class="pagination" style="justify-content: center">
                    <c:if test="${tag > 1}">
                        <a href="car?index=${tag - 1}&txt=${txtSearch != null ? txtSearch : ''}"><< Prev</a>
                    </c:if>
                    <!-- Hiển thị trang đầu tiên nếu trang hiện tại không nằm ở đầu -->
                    <c:if test="${tag > 3}">
                        <a href="car?index=1&txt=${txtSearch != null ? txtSearch : ''}">1</a>
                        <span>...</span> <!-- Dấu 3 chấm nếu cách xa -->
                    </c:if>

                    <!-- Hiển thị 2 trang trước trang hiện tại, trang hiện tại, và 2 trang sau trang hiện tại -->
                    <c:forEach begin="${tag - 2 > 1 ? tag - 2 : 1}" end="${tag + 2 < numPage ? tag + 2 : numPage}" var="i">
                        <a class="${tag == i ? 'active' : ''}" href="car?index=${i}&txt=${txtSearch != null ? txtSearch : ''}">${i}</a>
                    </c:forEach>

                    <!-- Hiển thị trang cuối cùng nếu trang hiện tại không nằm ở cuối -->
                    <c:if test="${tag < numPage - 2}">
                        <span>...</span> <!-- Dấu 3 chấm nếu cách xa -->
                        <a href="car?index=${numPage}&txt=${txtSearch != null ? txtSearch : ''}">${numPage}</a>
                    </c:if>
                    <c:if test="${tag < numPage}">
                        <a href="car?index=${tag + 1}&txt=${txtSearch != null ? txtSearch : ''}">Next >></a>
                    </c:if>
                </div>
            </div>
        </div>
    </body>
</html>
