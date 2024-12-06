/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package control;

import com.google.gson.Gson;
import dao.DAO;
import dao.DAOImpl;
import entity.Car;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 *
 * @author Admin
 */
@WebServlet(name = "LoadController", urlPatterns = {"/load"})
public class LoadController extends HttpServlet {

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
        String cid = request.getParameter("cid");

        Car car = null; // Khai báo biến Car để lưu kết quả

        try {
            // API endpoint (bao gồm tham số `cid` nếu có)
            String apiUrl = "http://localhost:8080/carshop/api/car?cid=" + cid;

            // Gửi yêu cầu GET tới API
            URL url = new URL(apiUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("Accept", "application/json");

            // Kiểm tra mã phản hồi
            int status = connection.getResponseCode();
            if (status == 200) {
                // Đọc phản hồi JSON từ API
                StringBuilder jsonResponse = new StringBuilder();
                try (BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
                    String inputLine;
                    while ((inputLine = in.readLine()) != null) {
                        jsonResponse.append(inputLine);
                    }
                }

                // Chuyển đổi JSON thành đối tượng Car
                Gson gson = new Gson();
                car = gson.fromJson(jsonResponse.toString(), Car.class);

            } else {
                request.setAttribute("error", "Unable to fetch car details from API. Status code: " + status);
            }

        } catch (IOException e) {
            e.printStackTrace();
            request.setAttribute("error", "Error while connecting to API: " + e.getMessage());
        }

        // Kiểm tra kết quả và chuyển hướng đến trang chỉnh sửa (edit.jsp)
        if (car != null) {
            request.setAttribute("edit", car);
            request.getRequestDispatcher("edit.jsp").forward(request, response);
        } else {
            request.setAttribute("error", "Car details not found.");
            request.getRequestDispatcher("error.jsp").forward(request, response);
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
