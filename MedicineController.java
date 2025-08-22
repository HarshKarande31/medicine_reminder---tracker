package com.qt.medicine_reminder;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "MedicineController", urlPatterns = {"/MedicineController"})
public class MedicineController extends HttpServlet {

    private MedicineDAO ms = new MedicineDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");

        if (action == null) {
            // Default action: show the list of all medicines on the dashboard
            ArrayList<Medicines> medicineList = ms.findAll();
            request.setAttribute("medicines", medicineList);
            request.getRequestDispatcher("dashbord.jsp").forward(request, response);
        } else {
            switch (action) {
                case "edit":
                    // Action to fetch a single medicine for editing
                    int medIdToEdit = Integer.parseInt(request.getParameter("med_id"));
                    Medicines medicine = ms.findById(medIdToEdit);
                    request.setAttribute("medicine", medicine);
                    request.getRequestDispatcher("update.jsp").forward(request, response);
                    break;
                case "delete":
                    // Action to delete a medicine
                    int medIdToDelete = Integer.parseInt(request.getParameter("med_id"));
                    String deleteMessage = ms.delete(medIdToDelete);
                    response.sendRedirect("MedicineController?message=" + deleteMessage);
                    break;
                default:
                    response.sendRedirect("MedicineController");
                    break;
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        String message = "";
        Medicines medicine = new Medicines();

        switch (action) {
            case "insert":
                medicine.setName(request.getParameter("medicineName"));
                medicine.setMedicineTime(request.getParameter("medicineTime"));
                medicine.setStartDate(request.getParameter("startDate"));
                medicine.setEndDate(request.getParameter("endDate"));
                message = ms.insert(medicine);
                break;
            case "update":
                medicine.setMedId(Integer.parseInt(request.getParameter("med_id")));
                medicine.setName(request.getParameter("medicineName"));
                medicine.setMedicineTime(request.getParameter("medicineTime"));
                medicine.setStartDate(request.getParameter("startDate"));
                medicine.setEndDate(request.getParameter("endDate"));
                message = ms.update(medicine);
                break;
        }
        // Redirect back to the main page (dashboard) after POST actions
        response.sendRedirect("MedicineController?message=" + message);
    }

    @Override
    public String getServletInfo() {
        return "Controls CRUD operations for medicines";
    }
}