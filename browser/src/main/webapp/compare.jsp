<%-- 
    Document   : compare
    Created on : Dec 5, 2024, 3:19:06 PM
    Author     : Admin
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>So sánh xe</title>
        <link href="css/compare.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <h1 style="text-align: center;">So sánh xe ô tô</h1>
        <table id="comparison-table">
            <thead>
                <tr>
                    <th>Thông số</th>
                        <c:forEach items="${listCar}" var="o">
                        <th>
                            <image class="car-image" src="${o.anh}" alt="${o.tenXe}">
                            <br><br>${o.tenXe}
                        </th>
                    </c:forEach>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td>Giá xe</td>
                    <c:forEach items="${listCar}" var="o">
                        <td>${o.gia}</td>
                    </c:forEach>
                </tr>
                <tr>
                    <td>Đời xe</td>
                    <c:forEach items="${listCar}" var="o">
                        <td>${o.nam}</td>
                    </c:forEach>
                </tr>
                <tr>
                    <td>Xuất xứ</td>
                    <c:forEach items="${listCar}" var="o">
                        <td>${o.xuatXu}</td>
                    </c:forEach>
                </tr>
                <tr>
                    <td>Kiểu dáng</td>
                    <c:forEach items="${listCar}" var="o">
                        <td>${o.kieuDang}</td>
                    </c:forEach>
                </tr>
                <tr>
                    <td>Số chỗ ngồi</td>
                    <c:forEach items="${listCar}" var="o">
                        <td>${o.choNgoi}</td>
                    </c:forEach>
                </tr>
                <tr>
                    <td>Kích thước</td>
                    <c:forEach items="${listCar}" var="o">
                        <td>${o.kichThuoc}</td>
                    </c:forEach>
                </tr>
                <tr>
                    <td>Chiều dài cơ sở</td>
                    <c:forEach items="${listCar}" var="o">
                        <td>${o.chieuDai}</td>
                    </c:forEach>
                </tr>
                <tr>
                    <td>Mâm xe</td>
                    <c:forEach items="${listCar}" var="o">
                        <td>${o.mamXe}</td>
                    </c:forEach>
                </tr>
                <tr>
                    <td>Lốp xe</td>
                    <c:forEach items="${listCar}" var="o">
                        <td>${o.lopXe}</td>
                    </c:forEach>
                </tr>
                <tr>
                    <td>Trọng lượng</td>
                    <c:forEach items="${listCar}" var="o">
                        <td>${o.trongLuong}</td>
                    </c:forEach>
                </tr>
                <tr>
                    <td>Động cơ</td>
                    <c:forEach items="${listCar}" var="o">
                        <td>${o.dongCo}</td>
                    </c:forEach>
                </tr>
                <tr>
                    <td>Dung tích</td>
                    <c:forEach items="${listCar}" var="o">
                        <td>${o.dungTich}</td>
                    </c:forEach>
                </tr>
                <tr>
                    <td>Công suất</td>
                    <c:forEach items="${listCar}" var="o">
                        <td>${o.congSuat}</td>
                    </c:forEach>
                </tr>
                <tr>
                    <td>Mô-men xoắn</td>
                    <c:forEach items="${listCar}" var="o">
                        <td>${o.moMen}</td>
                    </c:forEach>
                </tr>
                <tr>
                    <td>Hộp số</td>
                    <c:forEach items="${listCar}" var="o">
                        <td>${o.hopSo}</td>
                    </c:forEach>
                </tr>
                <tr>
                    <td>Dẫn động</td>
                    <c:forEach items="${listCar}" var="o">
                        <td>${o.danDong}</td>
                    </c:forEach>
                </tr>
                <tr>
                    <td>Phanh trước</td>
                    <c:forEach items="${listCar}" var="o">
                        <td>${o.phanhTruoc}</td>
                    </c:forEach>
                </tr>
                <tr>
                    <td>Phanh sau</td>
                    <c:forEach items="${listCar}" var="o">
                        <td>${o.phanhSau}</td>
                    </c:forEach>
                </tr>
                <tr>
                    <td>Tốc độ tối đa</td>
                    <c:forEach items="${listCar}" var="o">
                        <td>${o.tocDo}</td>
                    </c:forEach>
                </tr>
                <tr>
                    <td>Bứt tốc (0-100 km/h)</td>
                    <c:forEach items="${listCar}" var="o">
                        <td>${o.butToc}</td>
                    </c:forEach>
                </tr>
                <tr>
                    <td>Tiêu hao nhiên liệu</td>
                    <c:forEach items="${listCar}" var="o">
                        <td>${o.tieuHao}</td>
                    </c:forEach>
                </tr>
                <tr>
                    <td>ABS</td>
                    <c:forEach items="${listCar}" var="o">
                        <td>${o.abs}</td>
                    </c:forEach>
                </tr>
                <tr>
                    <td>Túi khí</td>
                    <c:forEach items="${listCar}" var="o">
                        <td>${o.tuiKhi}</td>
                    </c:forEach>
                </tr>
                <tr>
                    <td>EBD</td>
                    <c:forEach items="${listCar}" var="o">
                        <td>${o.ebd}</td>
                    </c:forEach>
                </tr>
                <tr>
                    <td>ESP</td>
                    <c:forEach items="${listCar}" var="o">
                        <td>${o.esp}</td>
                    </c:forEach>
                </tr>
            </tbody>
        </table>
        <script>
            document.addEventListener("DOMContentLoaded", function () {
                const table = document.getElementById("comparison-table");
                const rows = table.querySelectorAll("tbody tr");

                rows.forEach(row => {
                    const cells = row.querySelectorAll("td");

                    // Kiểm tra số lượng cột (ít nhất 2 xe để so sánh)
                    if (cells.length > 2) {
                        // Tạo danh sách giá trị từ các cột (bỏ cột đầu tiên là thông số)
                        const values = Array.from(cells)
                                .slice(1) // Bỏ cột đầu tiên (Thông số)
                                .map(cell => {
                                    const value = parseValue(cell.textContent.trim());
                                    return value;
                                });

                        // Tìm giá trị lớn nhất và nhỏ nhất trong danh sách
                        const maxValue = Math.max(...values.filter(value => value !== null));
                        const minValue = Math.min(...values.filter(value => value !== null));

                        // Gắn màu cho từng ô dựa trên giá trị
                        cells.forEach((cell, index) => {
                            if (index > 0) { // Bỏ qua cột đầu tiên
                                const value = parseValue(cell.textContent.trim());
                                if (value !== null) {
                                    if (value === maxValue) {
                                        cell.style.color = "green"; // Giá trị cao nhất
                                    } else if (value === minValue) {
                                        cell.style.color = "red";   // Giá trị thấp nhất
                                    } else {
                                        cell.style.color = "orange"; // Giá trị trung bình
                                    }
                                }
                            }
                        });
                    }
                });

                // Hàm xử lý giá trị (chuyển chuỗi thành số nếu cần)
                function parseValue(value) {
                    // Xử lý các trường hợp đặc biệt
                    value = value.replace(/[^\d.,-]/g, ''); // Loại bỏ ký tự không phải số
                    value = value.replace(',', '.');       // Đổi dấu phẩy thành dấu chấm

                    // Chuyển về kiểu số
                    const number = parseFloat(value);
                    return isNaN(number) ? null : number;  // Trả về null nếu không thể chuyển
                }
            });
        </script>
    </body>
</html>
