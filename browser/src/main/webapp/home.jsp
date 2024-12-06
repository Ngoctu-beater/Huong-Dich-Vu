<%-- 
    Document   : home
    Created on : Dec 4, 2024, 1:56:15 PM
    Author     : Admin
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home</title>
        <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
        <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
        <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <!-- Include the above in your HEAD tag -->
        <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet" integrity="sha384-wvfXpqpZZVQGK6TAh5PVlGOfQNHSoD2xbE+QkPxCAFlNEevoEH3Sl0sibVcOQVnN" crossorigin="anonymous">
        <link href="css/home.css" rel="stylesheet" type="text/css"/>
        <style>
            table {
                width: 100%;
                border-collapse: collapse;
                margin-bottom: 20px;
            }

            table, th, td {
                border: 1px solid #ddd;
                padding: 8px;
                text-align: center;
            }

            th {
                background-color: #f2f2f2;
            }
        </style>
    </head>
    <body>
        <!--begin of menu-->
        <nav class="navbar navbar-expand-md navbar-dark bg-dark">
            <div class="container">
                <a class="navbar-brand" href="home">Car</a>
                <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarsExampleDefault" aria-controls="navbarsExampleDefault" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>

                <div class="collapse navbar-collapse justify-content-end" id="navbarsExampleDefault">
                    <ul class="navbar-nav m-auto">
                        <li class="nav-item">
                            <a class="nav-link" href="#">Trang chủ</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="#">Đăng ký</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="#">Đăng nhập</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="compare.jsp">So sánh</a>
                        </li>
                    </ul>

                    <!-- search -->
                    <form action="search" method="post" class="form-inline my-2 my-lg-0">
                        <div class="input-group input-group-sm">
                            <input value="${txtSearch}" name="txt" type="text" class="form-control" aria-label="Small" aria-describedby="inputGroup-sizing-sm" placeholder="Search...">
                            <div class="input-group-append">
                                <button type="submit" class="btn btn-secondary btn-number">
                                    <i class="fa fa-search"></i>
                                </button>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </nav>
        <section class="jumbotron text-center">
            <div class="container">
                <h1 class="jumbotron-heading">Siêu thị ô tô chất lượng cao</h1>
                <p class="lead text-muted mb-0">Uy tín tạo nên thương hiệu</p>
            </div>
        </section>

        <!--end of menu-->
        <div class="container">
            <div class="row">
                <div class="col">
                    <nav aria-label="breadcrumb">
                        <ol class="breadcrumb">
                            <li class="breadcrumb-item"><a href="home.jsp">Home</a></li>
                            <li class="breadcrumb-item"><a href="#">Category</a></li>
                            <li class="breadcrumb-item active" aria-current="#">Sub-category</li>
                        </ol>
                    </nav>
                </div>
            </div>
        </div>

        <form action="comparecar" method="get">
            <button type="submit" style="background-color: #4CAF50; color: white; border: none; padding: 15px 32px; text-align: center;
                    text-decoration: none; display: inline-block; font-size: 14px; margin: 4px 2px; cursor: pointer; border-radius: 4px;">So sánh</button>
            <table>
                <thead>
                    <tr>
                    </tr>
                </thead>

                <tbody>
                    <c:forEach items="${listCar}" var="o">
                        <tr>
                            <td><input type="checkbox" name="ids" value="${o.id}"></td>
                            <td>${o.tenXe}</td>
                            <td><img src="${o.anh}" alt="alt"/></td>
                            <td>${o.gia}</td>
                        </tr>   
                    </c:forEach>  
                </tbody>
            </table>
        </form>

        <!-- các trang -->
        <div class="pagination" style="justify-content: center">
            <c:if test="${tag > 1}">
                <a style="margin: 0 10px" href="search?index=${tag - 1}&txt=${txtSearch != null ? txtSearch : ''}"><< Prev</a>
            </c:if>
            <!-- Hiển thị trang đầu tiên nếu trang hiện tại không nằm ở đầu -->
            <c:if test="${tag > 3}">
                <a style="margin: 0 10px" href="search?index=1&txt=${txtSearch != null ? txtSearch : ''}">1</a>
                <span>...</span> <!-- Dấu 3 chấm nếu cách xa -->
            </c:if>

            <!-- Hiển thị 2 trang trước trang hiện tại, trang hiện tại, và 2 trang sau trang hiện tại -->
            <c:forEach begin="${tag - 2 > 1 ? tag - 2 : 1}" end="${tag + 2 < numPage ? tag + 2 : numPage}" var="i">
                <a class="${tag == i ? 'active' : ''}" style="margin: 0 10px" href="search?index=${i}&txt=${txtSearch != null ? txtSearch : ''}">${i}</a>
            </c:forEach>

            <!-- Hiển thị trang cuối cùng nếu trang hiện tại không nằm ở cuối -->
            <c:if test="${tag < numPage - 2}">
                <span>...</span> <!-- Dấu 3 chấm nếu cách xa -->
                <a style="margin: 0 10px" href="search?index=${numPage}&txt=${txtSearch != null ? txtSearch : ''}">${numPage}</a>
            </c:if>
            <c:if test="${tag < numPage}">
                <a style="margin: 0 10px" href="search?index=${tag + 1}&txt=${txtSearch != null ? txtSearch : ''}">Next >></a>
            </c:if>
        </div>

        <!-- Footer -->
        <footer class="text-light">
            <div class="container">
                <div class="row">
                    <div class="col-md-3 col-lg-4 col-xl-3">
                        <h5>About</h5>
                        <hr class="bg-white mb-2 mt-0 d-inline-block mx-auto w-25">
                        <p class="mb-0">
                            Le Lorem Ipsum est simplement du faux texte employé dans la composition et la mise en page avant impression.
                        </p>
                    </div>

                    <div class="col-md-2 col-lg-2 col-xl-2 mx-auto">
                        <h5>Informations</h5>
                        <hr class="bg-white mb-2 mt-0 d-inline-block mx-auto w-25">
                        <ul class="list-unstyled">
                            <li><a href="">Link 1</a></li>
                            <li><a href="">Link 2</a></li>
                            <li><a href="">Link 3</a></li>
                            <li><a href="">Link 4</a></li>
                        </ul>
                    </div>

                    <div class="col-md-3 col-lg-2 col-xl-2 mx-auto">
                        <h5>Others links</h5>
                        <hr class="bg-white mb-2 mt-0 d-inline-block mx-auto w-25">
                        <ul class="list-unstyled">
                            <li><a href="">Link 1</a></li>
                            <li><a href="">Link 2</a></li>
                            <li><a href="">Link 3</a></li>
                            <li><a href="">Link 4</a></li>
                        </ul>
                    </div>

                    <div class="col-md-4 col-lg-3 col-xl-3">
                        <h5>Contact</h5>
                        <hr class="bg-white mb-2 mt-0 d-inline-block mx-auto w-25">
                        <ul class="list-unstyled">
                            <li><i class="fa fa-home mr-2"></i> My company</li>
                            <li><i class="fa fa-envelope mr-2"></i> email@example.com</li>
                            <li><i class="fa fa-phone mr-2"></i> + 33 12 14 15 16</li>
                            <li><i class="fa fa-print mr-2"></i> + 33 12 14 15 16</li>
                        </ul>
                    </div>
                    <div class="col-12 copyright mt-3">
                        <p class="float-left">
                            <a href="#">Back to top</a>
                        </p>
                        <p class="text-right text-muted">created with <i class="fa fa-heart"></i> by <a href="https://t-php.fr/43-theme-ecommerce-bootstrap-4.html"><i>t-php</i></a> | <span>v. 1.0</span></p>
                    </div>
                </div>
            </div>
        </footer>

        <script>
            $(document).ready(function () {
                $('#compareBtn').click(function () {
                    // Lấy tất cả các ID của các xe được chọn
                    var selectedIds = [];
                    $('.car-checkbox:checked').each(function () {
                        selectedIds.push($(this).val());
                    });

                    if (selectedIds.length === 0) {
                        alert("Vui lòng chọn ít nhất một xe để so sánh.");
                        return;
                    }

                    // Gửi yêu cầu AJAX tới Servlet
                    $.ajax({
                        url: 'comparecar',
                        type: 'POST',
                        data: {id: selectedIds.join(',')}, // Truyền các id dưới dạng chuỗi (ví dụ: "1,2,3")
                        success: function (response) {
                            // Xử lý dữ liệu trả về từ Servlet (ví dụ: hiển thị thông tin so sánh)
                            // Chuyển hướng tới trang so sánh (compare.jsp) hoặc xử lý ngay tại đây
                            window.location.href = "compare.jsp";  // Chuyển hướng đến trang so sánh
                        },
                        error: function (xhr, status, error) {
                            alert("Có lỗi xảy ra khi gửi yêu cầu.");
                        }
                    });
                });
            });
        </script>
    </body>
</html>
