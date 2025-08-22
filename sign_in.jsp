<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Login - Medicine Reminder</title>

  <!-- Bootstrap CSS -->
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
  <!-- Bootstrap Icons -->
  <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.1/font/bootstrap-icons.css" rel="stylesheet">

  <style>
    body {
        background-color: #E6DADA; 
    }

    .login-card {
      max-width: 400px;
      margin: 100px auto;
      padding: 30px;
      border-radius: 15px;
      background-color: #D1B4AE;
      box-shadow: 0px 4px 12px rgba(0, 0, 0, 0.1);
    }

    .btn-custom {
      border-radius: 25px;
    }

    .social-btn {
      margin-top: 10px;
    }

    .social-btn i {
      margin-right: 8px;
    }
  </style>
</head>
<body>

  <!-- Navbar -->
  <nav class="navbar navbar-expand-lg navbar-dark bg-primary">
    <div class="container-fluid">
      <a class="navbar-brand" href="#">
        <img src="https://www.logodee.com/wp-content/uploads/2022/01/29-1.jpg" alt="Logo" width="30" height="24" class="d-inline-block align-text-top">
        Medicine Reminder
      </a>

      <div class="collapse navbar-collapse justify-content-end">
        <ul class="navbar-nav">
          
          <li class="nav-item"><a class="nav-link" href="#">Sign Up</a></li>
        </ul>
      </div>
    </div>
  </nav>

  <!-- Login Card -->
  <div class="login-card">
    <h3 class="text-center mb-4">Sign-in</h3>

    <!-- Login Form -->
    <form action="UserController" method="post">
    <input type="hidden" name="action" value="insert">

    <div class="mb-3">
        <label class="form-label" for="username">Username</label>
        <input type="text" id="username" class="form-control" placeholder="Enter username" name="full_name" required>
    </div>

    <div class="mb-3">
        <label class="form-label" for="email">Email</label>
        <input type="email" id="email" class="form-control" placeholder="Enter email" name="email" required>
    </div>

    <div class="mb-3">
        <label class="form-label" for="password">Password</label>
        <input type="password" id="password" class="form-control" placeholder="Enter password" name="password" required>
    </div>

    <div class="d-grid">
        <button type="submit" class="btn btn-primary btn-custom">Sign-in</button>
    </div>
</form>

    <hr>

    <!-- Social Login Options -->
    <div class="text-center">
      <p>Or continue with</p>
      <div class="d-grid gap-2 social-btn">
        <button class="btn btn-outline-danger btn-custom">
          <i class="bi bi-google"></i> Google
        </button>
        <button class="btn btn-outline-primary btn-custom">
          <i class="bi bi-facebook"></i> Facebook
        </button>
        <button class="btn btn-outline-secondary btn-custom">
          Other
        </button>
      </div>
    </div>

  </div>

  <!-- Bootstrap JS -->
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
