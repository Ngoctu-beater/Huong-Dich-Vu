/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package shop.crawl;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 *
 * @author Admin
 */
public class Crawl {

    public static void main(String[] args) throws IOException, InterruptedException {
        // Link cơ bản
        String baseURL = "https://oto.com.vn/so-sanh-xe/";

        // Số lượng xe crawl
        int totalCar = 808;

        // thông tin kết nối SQL server
        String urlDB = "jdbc:sqlserver://LAPTOP-HSS8HFAH;databaseName=Car;encrypt=true;trustServerCertificate=true";
        String user = "sa";
        String password = "291004";

        // Truy vấn SQL để chèn dữ liệu vào bảng
        String sqlInsert = "INSERT INTO infoCar\n"
                + "(name, image, price, year, origin, style, seat, size, length, wheel, tire, weight, engine, capacity, power, torque, gearbox"
                + ", drive, frontbrake, rearbrake, speed, accelerate, consumption, abs, airbag, ebd, esp)\n"
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        Connection connection = null;
        PreparedStatement statement = null;

        try {
            // kết nối SQL server
            connection = DriverManager.getConnection(urlDB, user, password);

            for (int i = 2; i <= totalCar; i++) {
                // Link của trang hiện tại
                String url = baseURL + i;

                // Lấy nội dung HTML của trang
                Document doc = Jsoup.connect(url).get();

                // Lấy danh sách các thẻ <ul> có class "list-head-compare"
                Elements elements = doc.select("div[class=list-compare-car column-list-compare-car last-compare-column]");

                // lưu dữ liệu vào SQL
                statement = connection.prepareStatement(sqlInsert);

                // Duyệt qua từng <ul>
                for (Element ul : elements) {
                    Elements titleElements = ul.select("div.item-compare");

                    // Lấy tên xe
                    String tenXe = titleElements.select("h2").text();

                    // Lấy link ảnh
                    String anh = titleElements.select("img").attr("src");

                    // Lấy tất cả các thẻ <li> trong thẻ <ul>
                    Elements liElements = ul.select("ul.list-head-compare li");

                    // Nếu có dữ liệu, lấy thông tin
                    if (!liElements.isEmpty()) {
                        String giaXe = liElements.get(0).select("div.item").text(); // Giá xe
                        String doiXe = liElements.get(1).select("div.item").text(); // Đời xe
                        String xuatXu = liElements.get(2).select("div.item").text(); // Xuất xứ
                        String dangXe = liElements.get(3).select("div.item").text(); // Dáng xe
                        String soCho = liElements.get(4).select("div.item").text(); // Số chỗ ngồi
                        String kichThuoc = liElements.get(5).select("div.item").text(); // Kích thước tổng thể
                        String chieuDai = liElements.get(6).select("div.item").text(); // Chiều dài cơ sở
                        String mamXe = liElements.get(9).select("div.item").text(); // Mâm xe
                        String lopXe = liElements.get(10).select("div.item").text(); // Thông số lốp
                        String trongLuong = liElements.get(11).select("div.item").text(); // Trọng lượng không tải
                        String dongCo = liElements.get(12).select("div.item").text(); // Kiểu động cơ
                        String dungTich = liElements.get(13).select("div.item").text(); // Dung tích
                        String congSuat = liElements.get(14).select("div.item").text(); // Công suất
                        String moMen = liElements.get(15).select("div.item").text(); // Mô-men xoắn
                        String hopSo = liElements.get(16).select("div.item").text(); // Hộp số
                        String danDong = liElements.get(17).select("div.item").text(); // Kiểu dẫn động
                        String phanhTruoc = liElements.get(18).select("div.item").text(); // Hệ thống phanh trước
                        String phanhSau = liElements.get(19).select("div.item").text(); // Hệ thống phanh sau
                        String tocDo = liElements.get(22).select("div.item").text(); // Tốc độ cực đại
                        String thoiGian = liElements.get(23).select("div.item").text(); // Thời gian tăng tốc từ 0-100km/h
                        String tieuHao = liElements.get(24).select("div.item").text(); // Tiêu hao trung bình
                        String abs = liElements.get(43).select("div.item").text(); // Phanh ABS
                        String tuiKhi = liElements.get(44).select("div.item").text(); // Túi khí
                        String ebd = liElements.get(49).select("div.item").text(); // Phanh điện tử
                        String esp = liElements.get(50).select("div.item").text(); // Cân bằng điện tử

                        // set giá trị cho câu truy vấn
                        statement.setString(1, tenXe);
                        statement.setString(2, anh);
                        statement.setString(3, giaXe);
                        statement.setString(4, doiXe);
                        statement.setString(5, xuatXu);
                        statement.setString(6, dangXe);
                        statement.setString(7, soCho);
                        statement.setString(8, kichThuoc);
                        statement.setString(9, chieuDai);
                        statement.setString(10, mamXe);
                        statement.setString(11, lopXe);
                        statement.setString(12, trongLuong);
                        statement.setString(13, dongCo);
                        statement.setString(14, dungTich);
                        statement.setString(15, congSuat);
                        statement.setString(16, moMen);
                        statement.setString(17, hopSo);
                        statement.setString(18, danDong);
                        statement.setString(19, phanhTruoc);
                        statement.setString(20, phanhSau);
                        statement.setString(21, tocDo);
                        statement.setString(22, thoiGian);
                        statement.setString(23, tieuHao);
                        statement.setString(24, abs);
                        statement.setString(25, tuiKhi);
                        statement.setString(26, ebd);
                        statement.setString(27, esp);

                        // chèn data
                        statement.executeUpdate();
                    }
                }
            }
        } catch (SQLException e) {
            System.out.println("Lỗi kết nối!");
            e.printStackTrace();
        } finally {
            // Đảm bảo đóng kết nối và PreparedStatement
            try {
                if (statement != null) {
                    statement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
