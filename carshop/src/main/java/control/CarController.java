/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package control;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;
import entity.Car;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
@WebServlet(name = "CarController", urlPatterns = {"/car"})
public class CarController extends HttpServlet {

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

        // Phân trang
        int count, endPage;

        String indexPage = request.getParameter("index");
        if (indexPage == null) {
            indexPage = "1";
        }
        int index = Integer.parseInt(indexPage);

        // nhận tham số tìm kiếm
        String txtSearch = request.getParameter("txt");

        // Khởi tạo list chứa dữ liệu xe
        List<Car> list = new ArrayList<>();

        try {
            // API endpoint
            String apiUrl = "http://localhost:8080/carshop/api/search";

            // Thêm tham số tìm kiếm vào URL nếu có
            if (txtSearch != null && !txtSearch.isEmpty()) {
                apiUrl += "?txt=" + URLEncoder.encode(txtSearch, "UTF-8");
            }

            // Gửi yêu cầu GET tới API
            URL url = new URL(apiUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("Accept", "application/json");

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

                // Chuyển JSON thành danh sách đối tượng Car
                Gson gson = new Gson();
                Type listType = new TypeToken<List<Car>>() {}.getType();
                List<Car> carList = gson.fromJson(jsonResponse.toString(), listType);

                // Tổng số xe
                count = carList.size();

                // Tính số trang
                endPage = count / 20;
                if (count % 20 != 0) {
                    endPage++;
                }

                // Cắt danh sách theo trang
                int start = (index - 1) * 20;
                int end = Math.min(start + 20, count);
                list = carList.subList(start, end);
            } else {
                request.setAttribute("error", "Unable to fetch cars from API");
                endPage = 0;
            }
        } catch (IOException e) {
            e.printStackTrace();
            request.setAttribute("error", "Error while connecting to API");
            endPage = 0;
        }

        // Set dữ liệu lên JSP
        request.setAttribute("listCar", list);
        request.setAttribute("numPage", endPage);
        request.setAttribute("tag", index);
        request.setAttribute("txtSearch", txtSearch); // giữ giá trị tìm kiếm

        // Chuyển tiếp request tới trang JSP
        request.getRequestDispatcher("management.jsp").forward(request, response);
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
