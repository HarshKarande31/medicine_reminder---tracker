/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qt.medicine_reminder;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author HP
 */
@WebServlet(name = "MedicineController", urlPatterns = {"/MedicineController"})
public class MedicineController extends HttpServlet {

    MedicineDAO ms = new MedicineDAO();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        String message = null;
        if (action == null) {
            response.sendRedirect("dashboard.jsp");
            return;
        }
        Medicines medicine = new Medicines();
        if (action.equals("insert")) {
            try {
                medicine.setName(request.getParameter("medicineName"));
                medicine.setMedicineTime(request.getParameter("medicineTime"));
                medicine.setStartDate(request.getParameter("startDate"));
                medicine.setEndDate(request.getParameter("endDate"));

                message = ms.insert(medicine);

            } catch (Exception e) {
                message = e.getMessage();
            } finally {
                response.sendRedirect("dashboard.jsp?message=" + message);
            }
        } else if (action.equals("delete")) {
            medicine.setMedId(Integer.valueOf(request.getParameter("med_id")));
            message = ms.delete(medicine);
            response.sendRedirect("dashboard.jsp?message=" + message);

        } else if (action.equals("update")) {
            medicine.setMedId(Integer.valueOf(request.getParameter("med_id")));
            medicine.setName(request.getParameter("medicineName"));
            medicine.setMedicineTime(request.getParameter("medicineTime"));
            medicine.setStartDate(request.getParameter("startDate"));
            medicine.setEndDate(request.getParameter("endDate"));

            message = ms.update(medicine);
            response.sendRedirect("dashboard.jsp?message=" + message);
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
    
    public ArrayList<Medicines> findAll() {
        return ms.findAll();
    }

    public Medicines findById(Integer id) {
        return ms.findById(id);
    }
}
