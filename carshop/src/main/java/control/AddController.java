/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package control;

import dao.DAO;
import dao.DAOImpl;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author Admin
 */
@WebServlet(name = "AddController", urlPatterns = {"/add"})
public class AddController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
    private DAO addDAO = new DAOImpl();
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String tenXe = request.getParameter("carName");
        String anh = request.getParameter("carImage");
        String gia = request.getParameter("carPriceTitle");
        String year = request.getParameter("carYear");
        int nam = Integer.parseInt(year);
        String xuatXu = request.getParameter("carOrigin");
        String kieuDang = request.getParameter("carStyle");
        String seats = request.getParameter("carSeats");
        int choNgoi = Integer.parseInt(seats);
        String kichThuoc = request.getParameter("carSize");
        String length = request.getParameter("carLength");
        int chieuDai = Integer.parseInt(length);
        String mamXe = request.getParameter("carWheel");
        String lopXe = request.getParameter("carTire");
        String weight = request.getParameter("carWeight");
        int trongLuong = Integer.parseInt(weight);
        String dongCo = request.getParameter("carEngine");
        String dungTich = request.getParameter("carCapacity");
        String congSuat = request.getParameter("carPower");
        String moMen = request.getParameter("carTorque");
        String hopSo = request.getParameter("carGearbox");
        String danDong = request.getParameter("carDrive");
        String phanhTruoc = request.getParameter("carFrontBreke");
        String phanhSau = request.getParameter("carRearBrake");
        String tocDo = request.getParameter("carSpeed");
        String accelerate = request.getParameter("carAccelerate");
        float butToc = Float.parseFloat(accelerate);
        String tieuHao = request.getParameter("carConsumption");
        String abs = request.getParameter("carABS");
        String tuiKhi = request.getParameter("carAirBag");
        String ebd = request.getParameter("carEBd");
        String esp = request.getParameter("carESP");
        
        addDAO.addCar(tenXe, anh, gia, nam, xuatXu, kieuDang, choNgoi, kichThuoc, chieuDai, mamXe, lopXe, trongLuong, dongCo, dungTich, congSuat, moMen, hopSo, danDong, phanhTruoc, phanhSau, tocDo, butToc, tieuHao, abs, tuiKhi, ebd, esp);
        response.sendRedirect("car");
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
