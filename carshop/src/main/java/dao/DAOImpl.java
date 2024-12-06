/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import context.DBContext;
import entity.Company;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class DAOImpl implements DAO {

    // xóa
    @Override
    public void deleteCar(String cid) {
        Connection conn = null;

        try {
            conn = DBContext.getConnection();
            String query = "DELETE FROM infoCar\n"
                    + "WHERE id = ?";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, cid);
            ps.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(DAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            DBContext.closeConnection(conn);
        }
    }

    // thêm
    @Override
    public boolean addCar(String tenXe, String anh, String gia, int nam, String xuatXu, String kieuDang, int choNgoi, String kichThuoc, int chieuDai, String mamXe, String lopXe, int trongLuong, String dongCo, String dungTich, String congSuat, String moMen, String hopSo, String danDong, String phanhTruoc, String phanhSau, String tocDo, float butToc, String tieuHao, String abs, String tuiKhi, String ebd, String esp) {
        Connection conn = null;

        try {
            conn = DBContext.getConnection();
            String query = "INSERT INTO infoCar\n"
                    + "(name, image, price, year, origin, style, seat, size, length, wheel, tire, weight, engine, capacity, power, torque, gearbox, "
                    + "drive, frontbrake, rearbrake, speed, accelerate, consumption, abs, airbag, ebd, esp)\n"
                    + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, tenXe);
            ps.setString(2, anh);
            ps.setString(3, gia);
            ps.setInt(4, nam);
            ps.setString(5, xuatXu);
            ps.setString(6, kieuDang);
            ps.setInt(7, choNgoi);
            ps.setString(8, kichThuoc);
            ps.setInt(9, chieuDai);
            ps.setString(10, mamXe);
            ps.setString(11, lopXe);
            ps.setInt(12, trongLuong);
            ps.setString(13, dongCo);
            ps.setString(14, dungTich);
            ps.setString(15, congSuat);
            ps.setString(16, moMen);
            ps.setString(17, hopSo);
            ps.setString(18, danDong);
            ps.setString(19, phanhTruoc);
            ps.setString(20, phanhSau);
            ps.setString(21, tocDo);
            ps.setFloat(22, butToc);
            ps.setString(23, tieuHao);
            ps.setString(24, abs);
            ps.setString(25, tuiKhi);
            ps.setString(26, ebd);
            ps.setString(27, esp);

            return ps.executeUpdate() > 0;
        } catch (SQLException ex) {
            Logger.getLogger(DAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            DBContext.closeConnection(conn);
        }
        return false;
    }

    // chỉnh sửa
    @Override
    public void editCar(String tenXe, String anh, String gia, int nam, String xuatXu, String kieuDang, int choNgoi, String kichThuoc, int chieuDai, String mamXe, String lopXe, int trongLuong, String dongCo, String dungTich, String congSuat, String moMen, String hopSo, String danDong, String phanhTruoc, String phanhSau, String tocDo, float butToc, String tieuHao, String abs, String tuiKhi, String ebd, String esp, int id) {
        Connection conn = null;

        try {
            conn = DBContext.getConnection();
            String query = "UPDATE infoCar SET name = ?, image = ?, price = ?, year = ?, origin = ?, "
                    + "style = ?, seat = ?, size = ?, length = ?, wheel = ?, tire = ?, "
                    + "weight = ?, engine = ?, capacity = ?, power = ?, torque = ?, gearbox = ?, "
                    + "drive = ?, frontbrake = ?, rearbrake = ?, speed = ?, accelerate = ?, "
                    + "consumption = ?, abs = ?, airbag = ?, ebd = ?, esp = ? WHERE id = ?";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, tenXe);
            ps.setString(2, anh);
            ps.setString(3, gia);
            ps.setInt(4, nam);
            ps.setString(5, xuatXu);
            ps.setString(6, kieuDang);
            ps.setInt(7, choNgoi);
            ps.setString(8, kichThuoc);
            ps.setInt(9, chieuDai);
            ps.setString(10, mamXe);
            ps.setString(11, lopXe);
            ps.setInt(12, trongLuong);
            ps.setString(13, dongCo);
            ps.setString(14, dungTich);
            ps.setString(15, congSuat);
            ps.setString(16, moMen);
            ps.setString(17, hopSo);
            ps.setString(18, danDong);
            ps.setString(19, phanhTruoc);
            ps.setString(20, phanhSau);
            ps.setString(21, tocDo);
            ps.setFloat(22, butToc);
            ps.setString(23, tieuHao);
            ps.setString(24, abs);
            ps.setString(25, tuiKhi);
            ps.setString(26, ebd);
            ps.setString(27, esp);
            ps.setInt(28, id);
            ps.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(DAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            DBContext.closeConnection(conn);
        }
    }

    @Override
    public List<Company> getByName() {
        Connection conn = null;
        List<Company> list = new ArrayList<>();
        try {
            conn = DBContext.getConnection();
            String query = "SELECT [name] FROM Company";
            PreparedStatement ps = conn.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Company company = new Company();
                company.setName(rs.getString("name"));
                list.add(company);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            DBContext.closeConnection(conn);
        }
        return list;
    }
}
