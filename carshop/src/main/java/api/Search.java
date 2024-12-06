/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package api;

import com.google.gson.Gson;
import context.DBContext;
import entity.Car;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
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
@WebServlet(name = "Search", urlPatterns = {"/api/search"})
public class Search extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        // cấu hình CORS
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE");
        response.setHeader("Access-Control-Allow-Headers", "Content-Type");

        String txtSearch = request.getParameter("txt"); // Lấy tham số tìm kiếm
        List<Car> list = new ArrayList<>();

        try (Connection conn = DBContext.getConnection(); PreparedStatement ps = prepareStatement(conn, txtSearch); ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                list.add(mapResultSetToCar(rs)); // Ánh xạ ResultSet -> Car
            }

            // Chuyển danh sách thành JSON
            Gson gson = new Gson();
            String json = gson.toJson(list);

            // Gửi JSON về client
            response.setContentType("application/json");
            response.getWriter().write(json);
        } catch (SQLException e) {
            e.printStackTrace();
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            response.getWriter().write("{\"error\":\"Unable to fetch cars\"}");
        }
    }

    // Chuẩn bị câu truy vấn SQL tùy thuộc vào txtSearch
    protected PreparedStatement prepareStatement(Connection conn, String txtSearch) throws SQLException {
        String query = (txtSearch == null || txtSearch.isEmpty())
                ? "SELECT * FROM infoCar"
                : "SELECT * FROM infoCar WHERE name LIKE ?";
        PreparedStatement ps = conn.prepareStatement(query);
        if (txtSearch != null && !txtSearch.isEmpty()) {
            ps.setString(1, "%" + txtSearch + "%");
        }
        return ps;
    }

    // Ánh xạ ResultSet thành đối tượng Car
    protected Car mapResultSetToCar(ResultSet rs) throws SQLException {
        Car car = new Car();
        car.setId(rs.getInt("id"));
        car.setTenXe(rs.getNString("name"));
        car.setAnh(rs.getString("image"));
        car.setGia(rs.getString("price"));
        car.setNam(rs.getInt("year"));
        car.setXuatXu(rs.getString("origin"));
        car.setKieuDang(rs.getString("style"));
        car.setChoNgoi(rs.getInt("seat"));
        car.setKichThuoc(rs.getString("size"));
        car.setChieuDai(rs.getInt("length"));
        car.setMamXe(rs.getString("wheel"));
        car.setLopXe(rs.getString("tire"));
        car.setTrongLuong(rs.getInt("weight"));
        car.setDongCo(rs.getString("engine"));
        car.setDungTich(rs.getString("capacity"));
        car.setCongSuat(rs.getString("power"));
        car.setMoMen(rs.getString("torque"));
        car.setHopSo(rs.getString("gearbox"));
        car.setDanDong(rs.getString("drive"));
        car.setPhanhTruoc(rs.getString("frontbrake"));
        car.setPhanhSau(rs.getString("rearbrake"));
        car.setTocDo(rs.getString("speed"));
        car.setButToc(rs.getFloat("accelerate"));
        car.setTieuHao(rs.getString("consumption"));
        car.setAbs(rs.getString("abs"));
        car.setTuiKhi(rs.getString("airbag"));
        car.setEbd(rs.getString("ebd"));
        car.setEsp(rs.getString("esp"));
        return car;
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
