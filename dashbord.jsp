<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <title>Dashboard - Medicine Reminder</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
        <style>
            body { background:  #E6DADA; }
            .content { padding: 20px; }
            .card { border-radius: 12px; box-shadow: 0px 4px 10px rgba(0,0,0,0.1); }
        </style>
    </head>
    <body>

        <!-- Navbar -->
        <nav class="navbar navbar-expand-lg navbar-dark bg-primary">
            <div class="container-fluid">
                <img src="https://www.logodee.com/wp-content/uploads/2022/01/29-1.jpg" alt="Logo" width="30" height="24" class="d-inline-block align-text-top">
                Medicine Reminder
                </a>

                <button class="navbar-toggler" type="button" data-bs-toggle="collapse" 
                        data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" 
                        aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>

                <div class="collapse navbar-collapse" id="navbarNav">
                    <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                        <li class="nav-item"><a class="nav-link active" href="#">Home</a></li>
                        <li class="nav-item"><a class="nav-link" href="#">Add Medicine</a></li>

                    </ul>
                    <div class="d-flex">
                        <span class="text-white me-3">Hi, User</span>
                        <button class="btn btn-light btn-sm">Logout</button>
                    </div>
                </div>
            </div>
        </nav>

        <!-- Main Content -->
        <div class="content container-fluid mt-4">
            <h3 class="mb-4">Home</h3>

            <div class="row g-4">
                <!-- Upcoming Reminders -->
                <div class="col-md-4">
                    <div class="card p-3">
                        <h5>Upcoming Reminders</h5>
                        <ul class="list-group list-group-flush">
                            <li class="list-group-item">Paracetamol - 9:00 AM</li>
                            <li class="list-group-item">Vitamin D - 1:00 PM</li>
                            <li class="list-group-item">Cough Syrup - 8:00 PM</li>
                        </ul>
                    </div>
                </div>

                <!-- Medicines Summary -->
                <div class="col-md-4">
                    <div class="card p-3">
                        <h5> My Medicines</h5>
                        <p>Total Medicines: <b>3</b></p>
                        <a href="#" class="btn btn-primary btn-sm">Manage Medicines</a>
                    </div>
                </div>

                <!-- Reports -->
                <div class="col-md-4">
                    <div class="card p-3">
                        <h5>Reports</h5>
                        <p>Feature coming soon...</p>
                        <a href="#" class="btn btn-success btn-sm">View Reports</a>
                    </div>
                </div>
            </div>

            <!-- Medicine Table -->
            <div class="row mt-4">
                <div class="col-md-12">
                    <div class="card p-3">
                        <h5> All Medicines</h5>
                        <table class="table table-striped mt-2">
                            <thead class="table-primary">
                                <tr><th>MedId</th>
                                    <th>MedName</th>
                                    <th>StartDate</th>
                                    <th>EndName</th>
                                    <th>MedTime</th>
                                    <th colspan="2">Action</th>
                                </tr>
                            </thead>
                            <tbody>
                                <tr>
                                    <td></td>
                                    <td></td>
                                    <td></td>
                                    <td></td>
                                    <td></td>
                                    <td></td>
                                     <td></td>
                                     <td></td>
                                </tr>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </div>

    </body>
</html>
