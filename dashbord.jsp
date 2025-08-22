<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Dashboard - Medicine Reminder</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        body { background-color: #E6DADA; }
        .content { padding: 20px; }
        .card { border-radius: 12px; box-shadow: 0px 4px 10px rgba(0,0,0,0.1); }
    </style>
</head>
<body>
    <nav class="navbar navbar-expand-lg navbar-dark bg-primary">
        <div class="container-fluid">
            <a class="navbar-brand" href="MedicineController">
                <img src="https://www.logodee.com/wp-content/uploads/2022/01/29-1.jpg" alt="Logo" width="30" height="24" class="d-inline-block align-text-top">
                Medicine Reminder
            </a>
            <div class="collapse navbar-collapse">
                <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                    <li class="nav-item"><a class="nav-link active" href="MedicineController">Home</a></li>
                    <li class="nav-item"><a class="nav-link" href="add_medicines.jsp">Add Medicine</a></li>
                </ul>
            </div>
        </div>
    </nav>

    <div class="content container-fluid mt-4">
        <h3 class="mb-4">Home</h3>

        <c:if test="${not empty param.message}">
            <div class="alert alert-info" role="alert">
                ${param.message}
            </div>
        </c:if>

        <div class="card p-3">
            <div class="d-flex justify-content-between align-items-center">
                <h5>All Medicines</h5>
                <a href="add_medicines.jsp" class="btn btn-success">Add New Medicine</a>
            </div>
            <table class="table table-striped mt-2">
                <thead class="table-primary">
                    <tr>
                        <th>Med ID</th>
                        <th>Med Name</th>
                        <th>Start Date</th>
                        <th>End Date</th>
                        <th>Med Time</th>
                        <th colspan="2">Action</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="med" items="${medicines}">
                        <tr>
                            <td>${med.medId}</td>
                            <td>${med.name}</td>
                            <td>${med.startDate}</td>
                            <td>${med.endDate}</td>
                            <td>${med.medicineTime}</td>
                            <td>
                                <a href="MedicineController?action=edit&med_id=${med.medId}" class="btn btn-sm btn-primary">Edit</a>
                            </td>
                            <td>
                                <a href="MedicineController?action=delete&med_id=${med.medId}" class="btn btn-sm btn-danger" onclick="return confirm('Are you sure you want to delete this medicine?');">Delete</a>
                            </td>
                        </tr>
                    </c:forEach>
                    <c:if test="${empty medicines}">
                        <tr>
                            <td colspan="7" class="text-center">No medicines found. Add one!</td>
                        </tr>
                    </c:if>
                </tbody>
            </table>
        </div>
    </div>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
    
</body>
</html>