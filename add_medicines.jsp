<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Add Medicine - Medicine Reminder</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        body { background-color: #E6DADA; }
        .card-medicine { max-width: 600px; margin: 40px auto; padding: 25px; border-radius: 15px; background-color: #D1B4AE; }
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
                    <li class="nav-item"><a class="nav-link" href="MedicineController">Home</a></li>
                    <li class="nav-item"><a class="nav-link active" href="add_medicines.jsp">Add Medicine</a></li>
                </ul>
            </div>
        </div>
    </nav>
    
    <div class="container">
        <div class="card card-medicine">
            <h3 class="text-center mb-4">Add Medicine</h3>
            <form action="MedicineController" method="post">
                <input type="hidden" name="action" value="insert">
                
                <div class="mb-3">
                    <label for="medicineName" class="form-label">Medicine Name</label>
                    <input type="text" class="form-control" id="medicineName" name="medicineName" placeholder="Enter medicine name" required>
                </div>
                <div class="mb-3">
                    <label for="medicineTime" class="form-label">Medicine Time</label>
                    <input type="time" class="form-control" id="medicineTime" name="medicineTime" required>
                </div>
                <div class="mb-3">
                    <label for="startDate" class="form-label">Start Date</label>
                    <input type="date" class="form-control" id="startDate" name="startDate" required>
                </div>
                <div class="mb-3">
                    <label for="endDate" class="form-label">End Date</label>
                    <input type="date" class="form-control" id="endDate" name="endDate" required>
                </div>
                <div class="d-grid">
                    <button type="submit" class="btn btn-primary">Add Medicine</button>
                </div>
            </form>
        </div>
    </div>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>