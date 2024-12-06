<%-- 
    Document   : add
    Created on : Nov 16, 2024, 2:12:35 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add</title>
        <link href="css/add.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <div class="add-product-form">
            <h2>Thêm mới</h2>
            <form action="AddController" method="post">
                <div class="form-group">
                    <label for="carName">Tên xe</label>
                    <input type="text" id="carName" name="carName">
                </div>
                <div class="form-group">
                    <label for="carPrice">Giá chữ</label>
                    <input type="text" id="carPrice" name="carPriceTitle">
                </div>
                <div class="form-group">
                    <label for="carPrice">Giá số</label>
                    <input type="text" id="carPrice" name="carPrice">
                </div>   
                <div class="form-group">
                    <label for="carYear">Năm sản xuất</label>
                    <input type="text" id="carYear" name="carYear">
                </div>    
                <div class="form-group">
                    <label for="carStatus">Tình trạng</label>
                    <input type="text" id="carStatus" name="carStatus">
                </div>
                <div class="form-group">
                    <label for="carHasgone">Đã đi</label>
                    <input type="text" id="carHasgone" name="carHasgone">
                </div>
                <div class="form-group">
                    <label for="carOrigin">Xuất xứ</label>
                    <input type="text" id="carOrigin" name="carOrigin">
                </div>
                <div class="form-group">
                    <label for="carStyle">Kiểu dáng</label>
                    <input type="text" id="carStyle" name="carStyle">
                </div>
                <div class="form-group">
                    <label for="carGearbox">Hộp số</label>
                    <input type="text" id="carGearbox" name="carGearbox">
                </div>
                <div class="form-group">
                    <label for="carEngine">Động cơ</label>
                    <input type="text" id="carEngine" name="carEngine">
                </div>
                <div class="form-group">
                    <label for="carExterior">Ngoại thất</label>
                    <input type="text" id="carExterior" name="carExterior">
                </div>
                <div class="form-group">
                    <label for="carInterior">Nội thất</label>
                    <input type="text" id="carInterior" name="carInterior">
                </div>    
                <div class="form-group">
                    <label for="carSeats">Chỗ ngồi</label>
                    <input type="text" id="carSeats" name="carSeats">
                </div>    
                <div class="form-group">
                    <label for="carDoors">Số cửa</label>
                    <input type="text" id="carDoors" name="carDoors">
                </div>    
                <div class="form-group">
                    <label for="carDrive">Dẫn động</label>
                    <input type="text" id="carDrive" name="carDrive">
                </div>    
                <div class="form-group">
                    <label for="carDescribe">Mô tả</label>
                    <input type="text" id="carDescribe" name="carDescribe">
                </div>    
                <div class="form-group">
                    <label for="carLink">Link</label>
                    <input type="text" id="carLink" name="carLink">
                </div>    
                <div class="form-group">
                    <input type="submit" class="submit-button add" value="Thêm">
                </div>
            </form>
            <div class="form-group">
                <a href="CarController"><input type="submit" class="submit-button cancel" value="Hủy"></a>
            </div>
        </div>
    </body>
</html>
