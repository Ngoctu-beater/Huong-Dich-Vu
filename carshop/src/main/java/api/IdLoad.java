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

/**
 *
 * @author Admin
 */
@WebServlet(name = "IdLoad", urlPatterns = {"/api/car"})
public class IdLoad extends HttpServlet {

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

        // Cấu hình CORS
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Methods", "GET");
        response.setHeader("Access-Control-Allow-Headers", "Content-Type");

        // Lấy tham số "id" từ request
        String cid = request.getParameter("cid");

        if (cid == null || cid.isEmpty()) {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            response.getWriter().write("{\"error\":\"Car ID is required\"}");
            return;
        }

        Connection conn = null;
        Car car = null;

        try {
            // Kết nối cơ sở dữ liệu
            conn = DBContext.getConnection();

            // Truy vấn sản phẩm theo ID
            String query = "SELECT * FROM infoCar WHERE id = ?";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, Integer.parseInt(cid));
            ResultSet rs = ps.executeQuery();

            // Nếu tìm thấy sản phẩm, ánh xạ dữ liệu vào đối tượng Car
            if (rs.next()) {
                car = new Car(
                        rs.getInt("id"),
                        rs.getNString("name"),
                        rs.getString("image"),
                        rs.getString("price"),
                        rs.getInt("year"),
                        rs.getString("origin"),
                        rs.getString("style"),
                        rs.getInt("seat"),
                        rs.getString("size"),
                        rs.getInt("length"),
                        rs.getString("wheel"),
                        rs.getString("tire"),
                        rs.getInt("weight"),
                        rs.getString("engine"),
                        rs.getString("capacity"),
                        rs.getString("power"),
                        rs.getString("torque"),
                        rs.getString("gearbox"),
                        rs.getString("drive"),
                        rs.getString("frontbrake"),
                        rs.getString("rearbrake"),
                        rs.getString("speed"),
                        rs.getFloat("accelerate"),
                        rs.getString("consumption"),
                        rs.getString("abs"),
                        rs.getString("airbag"),
                        rs.getString("ebd"),
                        rs.getString("esp")
                );
            }

            // Nếu không tìm thấy, trả về lỗi
            if (car == null) {
                response.setStatus(HttpServletResponse.SC_NOT_FOUND);
                response.getWriter().write("{\"error\":\"Car not found\"}");
                return;
            }

            // Chuyển đổi đối tượng Car thành JSON và trả về
            Gson gson = new Gson();
            String jsonResponse = gson.toJson(car);

            response.setContentType("application/json");
            response.getWriter().write(jsonResponse);

        } catch (IOException | NumberFormatException | SQLException e) {
            e.printStackTrace();
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            response.getWriter().write("{\"error\":\"Unable to fetch car details\"}");
        } finally {
            DBContext.closeConnection(conn);
        }
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
