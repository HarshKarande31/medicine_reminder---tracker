<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Login - Medicine Reminder</title>

  <!-- Bootstrap CSS -->
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">

  <style>
    /* Body styling */
    body {
        background-color: #E6DADA; 
    }

    /* Card styling for login form */
    .login-card {
      max-width: 400px;
      margin: 100px auto; /* centers card vertically with space from top */
      padding: 30px;
      border-radius: 15px;
      background-color: #D1B4AE;
      box-shadow: 0px 4px 12px rgba(0, 0, 0, 0.1);
    }

    /* Custom button styling */
    .btn-custom {
      border-radius: 25px;
    }
  </style>
</head>
<body>

  <!-- Navbar -->
  <nav class="navbar navbar-expand-lg navbar-dark bg-primary">
    <div class="container-fluid">
      <!-- Brand -->
      <a class="navbar-brand" href="#">
      <img src="https://www.logodee.com/wp-content/uploads/2022/01/29-1.jpg" alt="Logo" width="30" height="24" class="d-inline-block align-text-top">
       Medicine Reminder
    </a>

      <!-- Navbar links -->
      <div class="collapse navbar-collapse justify-content-end">
        <ul class="navbar-nav">
          <li class="nav-item">
            <a class="nav-link active" href="#">Login</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="#">Sign Up</a>
          </li>
        </ul>
      </div>
    </div>
  </nav>

  <!-- Login Card -->
  <div class="login-card">
    <h3 class="text-center mb-4">Sign-in</h3>

    <!-- Login Form -->
    <form>
      <!-- Username Field -->
      <div class="mb-3">
        <label class="form-label" for="username">Username</label>
        <input type="text" id="username" class="form-control" placeholder="Enter username"  name="full_name" required>
      </div>

      <!-- Password Field -->
      <div class="mb-3">
        <label class="form-label" for="password">Password</label>
        <input type="password" id="password" class="form-control" placeholder="Enter password"  name="password"required>
      </div>

      <!-- Login Button -->
      <div class="d-grid">
        <button type="submit" class="btn btn-primary btn-custom">Sign-in</button>
      </div>
    </form>

    <hr>

  <!-- Bootstrap JS (optional) -->
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
