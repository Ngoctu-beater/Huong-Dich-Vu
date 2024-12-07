/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package dao;

import entity.Admin;
import entity.Car;
import java.util.List;

/**
 *
 * @author Admin
 */
public interface DAO {
    void deleteCar(String cid);
    boolean addCar(String tenXe, String anh, String gia, int nam, String xuatXu, String kieuDang, int choNgoi, String kichThuoc, int chieuDai, String mamXe, String lopXe, int trongLuong, String dongCo, String dungTich, String congSuat, String moMen, String hopSo, String danDong, String phanhTruoc, String phanhSau, String tocDo, float butToc, String tieuHao, String abs, String tuiKhi, String ebd, String esp);
    void editCar(String tenXe, String anh, String gia, int nam, String xuatXu, String kieuDang, int choNgoi, String kichThuoc, int chieuDai, String mamXe, String lopXe, int trongLuong, String dongCo, String dungTich, String congSuat, String moMen, String hopSo, String danDong, String phanhTruoc, String phanhSau, String tocDo, float butToc, String tieuHao, String abs, String tuiKhi, String ebd, String esp, int id);
    long getTotalPrice();
}
