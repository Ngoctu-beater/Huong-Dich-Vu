/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author Admin
 */
public class Product {

    private int id;
    private String tenXe; // tên xe
    private String anh; // hình ảnh
    private String gia; // giá xe
    private int nam; // đời xe
    private String xuatXu; // xuất xứ
    private String kieuDang; // kiểu dáng
    private int choNgoi; // số chỗ ngồi
    private String kichThuoc; // kích thước tổng thể
    private int chieuDai; // chiều dài cơ sở
    private String mamXe; // mâm xe
    private String lopXe; // thông số lốp xe
    private int trongLuong; // trọng lượng ko tải
    private String dongCo; // kiểu động cơ
    private String dungTich; // dung tích
    private String congSuat; // công suất
    private String moMen; // mô-men xoắn
    private String hopSo; // hộp số
    private String danDong; // kiểu dẫn động
    private String phanhTruoc; // hệ thống phanh trước
    private String phanhSau; // hệ thống phanh sau
    private String tocDo; // tốc độ tối đa
    private float butToc; // thời gian tăng từ 0-100km/h
    private String tieuHao; // mức tiêu hao trung bình
    private String abs; // hệ thống abs
    private String tuiKhi; // hệ thống túi khí
    private String ebd; // hệ thống ebd
    private String esp; // hệ thống esp

    public Product() {
    }

    public Product(int id, String tenXe, String anh, String gia, int nam, String xuatXu, String kieuDang, int choNgoi, String kichThuoc, int chieuDai, String mamXe, String lopXe, int trongLuong, String dongCo, String dungTich, String congSuat, String moMen, String hopSo, String danDong, String phanhTruoc, String phanhSau, String tocDo, float butToc, String tieuHao, String abs, String tuiKhi, String ebd, String esp) {
        this.id = id;
        this.tenXe = tenXe;
        this.anh = anh;
        this.gia = gia;
        this.nam = nam;
        this.xuatXu = xuatXu;
        this.kieuDang = kieuDang;
        this.choNgoi = choNgoi;
        this.kichThuoc = kichThuoc;
        this.chieuDai = chieuDai;
        this.mamXe = mamXe;
        this.lopXe = lopXe;
        this.trongLuong = trongLuong;
        this.dongCo = dongCo;
        this.dungTich = dungTich;
        this.congSuat = congSuat;
        this.moMen = moMen;
        this.hopSo = hopSo;
        this.danDong = danDong;
        this.phanhTruoc = phanhTruoc;
        this.phanhSau = phanhSau;
        this.tocDo = tocDo;
        this.butToc = butToc;
        this.tieuHao = tieuHao;
        this.abs = abs;
        this.tuiKhi = tuiKhi;
        this.ebd = ebd;
        this.esp = esp;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTenXe() {
        return tenXe;
    }

    public void setTenXe(String tenXe) {
        this.tenXe = tenXe;
    }

    public String getAnh() {
        return anh;
    }

    public void setAnh(String anh) {
        this.anh = anh;
    }

    public String getGia() {
        return gia;
    }

    public void setGia(String gia) {
        this.gia = gia;
    }

    public int getNam() {
        return nam;
    }

    public void setNam(int nam) {
        this.nam = nam;
    }

    public String getXuatXu() {
        return xuatXu;
    }

    public void setXuatXu(String xuatXu) {
        this.xuatXu = xuatXu;
    }

    public String getKieuDang() {
        return kieuDang;
    }

    public void setKieuDang(String kieuDang) {
        this.kieuDang = kieuDang;
    }

    public int getChoNgoi() {
        return choNgoi;
    }

    public void setChoNgoi(int choNgoi) {
        this.choNgoi = choNgoi;
    }

    public String getKichThuoc() {
        return kichThuoc;
    }

    public void setKichThuoc(String kichThuoc) {
        this.kichThuoc = kichThuoc;
    }

    public int getChieuDai() {
        return chieuDai;
    }

    public void setChieuDai(int chieuDai) {
        this.chieuDai = chieuDai;
    }

    public String getMamXe() {
        return mamXe;
    }

    public void setMamXe(String mamXe) {
        this.mamXe = mamXe;
    }

    public String getLopXe() {
        return lopXe;
    }

    public void setLopXe(String lopXe) {
        this.lopXe = lopXe;
    }

    public int getTrongLuong() {
        return trongLuong;
    }

    public void setTrongLuong(int trongLuong) {
        this.trongLuong = trongLuong;
    }

    public String getDongCo() {
        return dongCo;
    }

    public void setDongCo(String dongCo) {
        this.dongCo = dongCo;
    }

    public String getDungTich() {
        return dungTich;
    }

    public void setDungTich(String dungTich) {
        this.dungTich = dungTich;
    }

    public String getCongSuat() {
        return congSuat;
    }

    public void setCongSuat(String congSuat) {
        this.congSuat = congSuat;
    }

    public String getMoMen() {
        return moMen;
    }

    public void setMoMen(String moMen) {
        this.moMen = moMen;
    }

    public String getHopSo() {
        return hopSo;
    }

    public void setHopSo(String hopSo) {
        this.hopSo = hopSo;
    }

    public String getDanDong() {
        return danDong;
    }

    public void setDanDong(String danDong) {
        this.danDong = danDong;
    }

    public String getPhanhTruoc() {
        return phanhTruoc;
    }

    public void setPhanhTruoc(String phanhTruoc) {
        this.phanhTruoc = phanhTruoc;
    }

    public String getPhanhSau() {
        return phanhSau;
    }

    public void setPhanhSau(String phanhSau) {
        this.phanhSau = phanhSau;
    }

    public String getTocDo() {
        return tocDo;
    }

    public void setTocDo(String tocDo) {
        this.tocDo = tocDo;
    }

    public float getButToc() {
        return butToc;
    }

    public void setButToc(float butToc) {
        this.butToc = butToc;
    }

    public String getTieuHao() {
        return tieuHao;
    }

    public void setTieuHao(String tieuHao) {
        this.tieuHao = tieuHao;
    }

    public String getAbs() {
        return abs;
    }

    public void setAbs(String abs) {
        this.abs = abs;
    }

    public String getTuiKhi() {
        return tuiKhi;
    }

    public void setTuiKhi(String tuiKhi) {
        this.tuiKhi = tuiKhi;
    }

    public String getEbd() {
        return ebd;
    }

    public void setEbd(String ebd) {
        this.ebd = ebd;
    }

    public String getEsp() {
        return esp;
    }

    public void setEsp(String esp) {
        this.esp = esp;
    }
}
