<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Dashboard</title>
        <link href="css/dashboard.css" rel="stylesheet" type="text/css"/>
        <link href="css/menu.css" rel="stylesheet" type="text/css"/>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap/5.1.3/css/bootstrap.min.css">
    </head>
    <body>
        <div class="container" style="margin: 0; max-width: 100%">
            <div class="menu">
                <jsp:include page="menu.jsp" />
            </div>
            
            <div class="content">
                <div class="account-info">
                    <img src="https://viotp.com/images/avatar-default.png" alt="Img_Admin" class="Img_Admin">
                    <div class="content1">
                        <h6><strong>User:</strong> Nhom 9</h6> 
                        <h6><strong>Date:</strong> 11/05/2024</h6>
                        <h6><strong>Address:</strong> Dai hoc Cong Nghiep Ha Noi</h6>
                        <h6><strong>Number Phone:</strong> 888888888</h6>
                        <h6><strong>Email:</strong> nhom9@gmail.com</h6>
                    </div>
                </div>
            </div>

            <div class="content">
                <div class="account-info">
                    <h2 style="text-align: center; font-family:'Franklin Gothic Medium', 'Arial Narrow', Arial, sans-serif;">Thong tin tai khoan</h2>
                    <h6><strong>User: Nhom 9</strong></h6>
                    <h6><strong>ID: 20241IT6151004</strong></h6>
                    <h6><strong></strong></h6>
                </div>
            </div>
        </div>
    </body>
</html>
