<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Edit</title>
        <link href="css/edit.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <div class="edit-product-form">
            <h2>Chỉnh sửa</h2>
            <form action="edit" method="post">
                <div class="form-group">
                    <label for="productId">ID</label>
                    <input value="${edit.id}" type="text" id="carId" name="carId" readonly>
                </div>
                <div class="form-group">
                    <label for="carName">Tên xe</label>
                    <input value="${edit.tenXe}" type="text" id="carName" name="carName">
                </div>
                <div class="form-group">
                    <label for="carImage">Hình ảnh</label>
                    <input value="${edit.anh}" type="text" id="carImage" name="carImage">
                </div>
                <div class="form-group">
                    <label for="carPrice">Giá</label>
                    <input value="${edit.gia}" type="text" id="carPrice" name="carPriceTitle">
                </div>
                <div class="form-group">
                    <label for="carYear">Đời xe</label>
                    <input value="${edit.nam}" type="text" id="carYear" name="carYear">
                </div>
                <div class="form-group">
                    <label for="carOrigin">Xuất xứ</label>
                    <input value="${edit.xuatXu}" type="text" id="carOrigin" name="carOrigin">
                </div>
                <div class="form-group">
                    <label for="carStyle">Kiểu dáng</label>
                    <input value="${edit.kieuDang}" type="text" id="carStyle" name="carStyle">
                </div>
                <div class="form-group">
                    <label for="carSeats">Chỗ ngồi</label>
                    <input value="${edit.choNgoi}" type="text" id="carSeats" name="carSeats">
                </div>
                <div class="form-group">
                    <label for="carSize">Kích thước</label>
                    <input value="${edit.kichThuoc}" type="text" id="carSize" name="carSize">
                </div>    
                <div class="form-group">
                    <label for="carLength">Chiều dài cơ sở</label>
                    <input value="${edit.chieuDai}" type="text" id="carLength" name="carLength">
                </div>
                <div class="form-group">
                    <label for="carWheel">Mâm Xe</label>
                    <input value="${edit.mamXe}" type="text" id="carWheel" name="carWheel">
                </div>
                <div class="form-group">
                    <label for="carTire">Thông số lốp</label>
                    <input value="${edit.lopXe}" type="text" id="carTire" name="carTire">
                </div>
                <div class="form-group">
                    <label for="carWeight">Trọng lượng không tải</label>
                    <input value="${edit.trongLuong}" type="text" id="carWeight" name="carWeight">
                </div>
                <div class="form-group">
                    <label for="carEngine">Động cơ</label>
                    <input value="${edit.dongCo}" type="text" id="carEngine" name="carEngine">
                </div>
                <div class="form-group">
                    <label for="carCapacity">Dung tích</label>
                    <input value="${edit.dungTich}" type="text" id="carCapacity" name="carCapacity">
                </div>
                <div class="form-group">
                    <label for="carPower">Công suất</label>
                    <input value="${edit.congSuat}" type="text" id="carPower" name="carPower">
                </div>
                <div class="form-group">
                    <label for="carTorque">Mô-men Xoắn</label>
                    <input value="${edit.moMen}" type="text" id="carTorque" name="carTorque">
                </div>
                <div class="form-group">
                    <label for="carGearbox">Hộp số</label>
                    <input value="${edit.hopSo}" type="text" id="carGearbox" name="carGearbox">
                </div>
                <div class="form-group">
                    <label for="carDrive">Dẫn động</label>
                    <input value="${edit.danDong}" type="text" id="carDrive" name="carDrive">
                </div>    
                <div class="form-group">
                    <label for="carFrontBreke">Hệ thống phanh trước</label>
                    <input value="${edit.phanhTruoc}" type="text" id="carFrontBreke" name="carFrontBreke">
                </div>    
                <div class="form-group">
                    <label for="carRearBrake">Hệ thống phanh sau</label>
                    <input value="${edit.phanhSau}" type="text" id="carRearBrake" name="carRearBrake">
                </div>
                <div class="form-group">
                    <label for="carSpeed">Tốc độ tối đa</label>
                    <input value="${edit.tocDo}" type="text" id="carSpeed" name="carSpeed">
                </div>
                <div class="form-group">
                    <label for="carAccelerate">Thời gian tăng tốc (0-100 km/h)</label>
                    <input value="${edit.butToc}" type="text" id="carAccelerate" name="carAccelerate">
                </div>
                <div class="form-group">
                    <label for="carConsumption">Tiêu hao trung bình</label>
                    <input value="${edit.tieuHao}" type="text" id="carConsumption" name="carConsumption">
                </div>
                <div class="form-group">
                    <label for="carABS">Hệ thống ABS</label>
                    <input value="${edit.abs}" type="text" id="carABS" name="carABS">
                </div>
                <div class="form-group">
                    <label for="carAirBag">Túi khí</label>
                    <input value="${edit.tuiKhi}" type="text" id="carAirBag" name="carAirBag">
                </div>
                <div class="form-group">
                    <label for="carEBd">Hệ thống EBD</label>
                    <input value="${edit.ebd}" type="text" id="carEBd" name="carEBd">
                </div>
                <div class="form-group">
                    <label for="carESP">Hệ thống ESP</label>
                    <input value="${edit.esp}" type="text" id="carESP" name="carESP">
                </div>
                <div class="form-group">
                    <input type="submit" class="submit-button update" value="Cập nhật">
                </div>
            </form>
            <div class="form-group">
                <a href="car"><input type="submit" class="submit-button cancel" value="Hủy"></a>
            </div>
        </div>
    </body>
</html>
