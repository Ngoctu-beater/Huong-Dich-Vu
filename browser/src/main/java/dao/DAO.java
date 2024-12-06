/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import context.DBContext;
import entity.Product;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */
public class DAO {

    public List<Product> getCarsByIds(List<Integer> ids) throws SQLException {
        List<Product> products = new ArrayList<>();
        String query = "SELECT * FROM infoCar WHERE id IN (" + String.join(",", ids.stream().map(String::valueOf).toArray(String[]::new)) + ")";

        try (Connection conn = DBContext.getConnection(); PreparedStatement stmt = conn.prepareStatement(query); ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Product product = new Product();
                product.setId(rs.getInt("id"));
                product.setTenXe(rs.getNString("name"));
                product.setAnh(rs.getString("image"));
                product.setGia(rs.getString("price"));
                product.setNam(rs.getInt("year"));
                product.setXuatXu(rs.getString("origin"));
                product.setKieuDang(rs.getString("style"));
                product.setChoNgoi(rs.getInt("seat"));
                product.setKichThuoc(rs.getString("size"));
                product.setChieuDai(rs.getInt("length"));
                product.setMamXe(rs.getString("wheel"));
                product.setLopXe(rs.getString("tire"));
                product.setTrongLuong(rs.getInt("weight"));
                product.setDongCo(rs.getString("engine"));
                product.setDungTich(rs.getString("capacity"));
                product.setCongSuat(rs.getString("power"));
                product.setMoMen(rs.getString("torque"));
                product.setHopSo(rs.getString("gearbox"));
                product.setDanDong(rs.getString("drive"));
                product.setPhanhTruoc(rs.getString("frontbrake"));
                product.setPhanhSau(rs.getString("rearbrake"));
                product.setTocDo(rs.getString("speed"));
                product.setButToc(rs.getFloat("accelerate"));
                product.setTieuHao(rs.getString("consumption"));
                product.setAbs(rs.getString("abs"));
                product.setTuiKhi(rs.getString("airbag"));
                product.setEbd(rs.getString("ebd"));
                product.setEsp(rs.getString("esp"));
                products.add(product);
            }
        }
        return products;
    }
}
