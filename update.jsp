<%-- 
    Document   : add_medicines
    Created on : 22-Aug-2025, 11:38:49 AM
    Author     : hp
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <title>Add Medicine - Medicine Reminder</title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <!-- Bootstrap CSS -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
        <style>
            body {
                background-color: #E6DADA;
            }
            .card-medicine {
                max-width: 600px;
                margin: 40px auto;
                padding: 25px;
                border-radius: 15px;
                background-color: #D1B4AE;
                box-shadow: 0 4px 12px rgba(0,0,0,0.1);
            }
            .btn-custom {
                border-radius: 25px;
            }
        </style>
    </head>
    <body>

        <!-- Navbar -->
        <nav class="navbar navbar-expand-lg navbar-dark bg-primary">
            <div class="container-fluid">
                <a class="navbar-brand d-flex align-items-center fw-bold" href="#">
                    <img src="https://www.logodee.com/wp-content/uploads/2022/01/29-1.jpg" alt="Logo" width="30" height="24" class="me-2">
                    Medicine Reminder
                </a>
                <button class="navbar-toggler" type="button" data-bs-toggle="collapse" 
                        data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" 
                        aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>

                <div class="collapse navbar-collapse" id="navbarNav">
                    <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                        <li class="nav-item"><a class="nav-link active" href="#">Dashboard</a></li>
                        <li class="nav-item"><a class="nav-link" href="#">Add Medicine</a></li>
                        <li class="nav-item"><a class="nav-link" href="#">My Medicines</a></li>
                        <li class="nav-item"><a class="nav-link" href="#">Reports</a></li>
                    </ul>
                    <div class="d-flex">
                        <span class="text-white me-3">Hi, User</span>
                        <button class="btn btn-light btn-sm">Logout</button>
                    </div>
                </div>
            </div>
        </nav>

        <div class="container">
            <div class="card card-medicine">
                <%
                    MedicineController mc = new MedicineController();
                    Medicine medicine = mc.findById(Integer.parseInt(request.getParameter("id")));
                    

                %>
                <h3 class="text-center mb-4">Update Medicine</h3>
                <form action="UserController" method="post"> <!-- Replace with your servlet URL -->
                    <input type="hidden" name="action" value="update"/>
                    <input type="hidden" name="id" value="<%= medicine.getUserId()%>"
                           <!-- Medicine Name -->
                    <div class="mb-3">
                        <label for="medicineName" class="form-label">Medicine Name</label>
                        <input type="text" class="form-control" id="medicineName" name="medicineName" placeholder="Enter medicine name" value="<%= medicine.getName()%>" required>
                    </div>

                    <div class="mb-3">
                        <label for="medicineTime" class="form-label">Medicine Time</label>
                        <input type="time" class="form-control" id="medicineTime" name="medicineTime" value="<%= medicine.getMedicineTime() %>" required>
                    </div>

                    <div class="mb-3">
                        <label for="startDate" class="form-label">Start Date</label>
                        <input type="date" class="form-control" id="startDate" name="startDate" value="<%= medicine.getStartDate() %>" required>
                    </div>

                    <div class="mb-3">
                        <label for="endDate" class="form-label">End Date</label>
                        <input type="date" class="form-control" id="endDate" name="endDate" value="<%= medicine.getEndDate() %>" required>
                    </div>

                    <div class="d-grid">
                        <button type="submit" class="btn btn-primary btn-custom">Add Medicine</button>
                    </div>

                </form>
            </div>
        </div>

        <!-- Bootstrap JS -->
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
    </body>
</html>
