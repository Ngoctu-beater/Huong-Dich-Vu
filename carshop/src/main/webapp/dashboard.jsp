<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Dashboard</title>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap/5.1.3/css/bootstrap.min.css">
        <style>
            body {
                font-family: Arial, sans-serif;
                background-color: #f4f4f4;
            }
            .sidebar {
                height: 100vh;
                background: #343a40;
                color: white;
                position: fixed;
                width: 250px;
            }
            .sidebar .nav-link {
                color: white;
            }
            .sidebar .nav-link:hover {
                background: #495057;
            }
            .content {
                margin-left: 250px;
                padding: 20px;
            }
            .header {
                background: #007bff;
                color: white;
                padding: 20px;
                text-align: center;
            }
            .account-info {
                max-width: 1000px;
                margin: auto;
                padding: 20px;
                background-color: #ffffff;
                border-radius: 8px;
                box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.1);
            }

            .account-info p {
                margin: 10px 0;
            }

            .Img_Admin{
                width: 150px;
                height: 150px;
                border-radius: 20px;

            }

            .content1 {
                margin-left: 200px;
                position: absolute;
                top: 23px;
                padding: 20px;
            }
        </style>
    </head>
    <body>
        <div class="sidebar position-fixed">
            <h5 class="text-center py-3">Thông tin tài khoản</h5>
            <nav class="nav flex-column">
                <a class="nav-link" href="dashboard.jsp"><i class="fas fa-user"></i> Tài khoản</a>
                <a class="nav-link" href="car"><i class="fas fa-car"></i> Quản lý xe</a>
                <a class="nav-link" href="statistics.html"><i class="fas fa-chart-line"></i> Biểu đồ</a>
                <a class="nav-link" href="#"><i class="fas fa-cog"></i> Cài đặt</a>
                <a class="nav-link" href="login.jsp"><i class="fas fa-sign-out-alt"></i> Đăng xuất</a>
            </nav>
        </div>

        <div class="content">
            <div class="account-info">
                <img src="https://viotp.com/images/avatar-default.png" alt="Img_Admin" class="Img_Admin">
                <div class="content1">
                    <h6><strong>User:</strong> Nhom 9</h6> 
                    <h6><strong>Date:</strong> 10/10/2024</h6>
                    <h6><strong>Address:</strong> Dai hoc Cong Nghiep Ha Noi</h6>
                    <h6><strong>Number Phone:</strong> 888888888</h6>
                    <h6><strong>Email:</strong> nhom9@gmail.com</h6>
                </div>

            </div>
        </div>

        <div class="content">
            <div class="account-info">
                <h2 style="text-align: center; font-family:'Franklin Gothic Medium', 'Arial Narrow', Arial, sans-serif;">Thông tin tài khoản</h2>
                <h6><strong>User: Nhóm 9</strong></h6>
                <h6><strong>ID: 2022603558</strong></h6>
                <h6><strong>Tên đăng nhâp: admin</strong></h6>
                <h6><strong>Email: nhom9@gmail.com</strong></h6>
                <h6><Strong>Số điện thoại: 88888888</Strong></h6>
                <h6><strong>Chức vụ: Quản trị viên</strong></h6>
                <h6><strong>Thời gian bắt đầu làm: 09/03/2024</strong></h6>
            </div>
        </div>

        <div class="content">
            <div class="account-info">
                <h6 style="text-align: center;"> &copy; 2024 Nhóm 9 - Phát triển phần mềm hướng dịch vụ</h6>
            </div>
        </div>
    </body>
</html>
