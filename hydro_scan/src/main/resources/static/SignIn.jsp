<html>
<head>
    <title>Hydro Scan Signup</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<nav class="navbar navbar-dark bg-primary">
    <div class="container">
        <a class="navbar-brand" href="index.html"> Hydro Scan </a>
    </div>
</nav>

<div class="container mt-5">
    <div class="col-md-6 mx-auto">
        <h2 class="text-center text-primary mb-4"> Create Account </h2>
        <form action="signup" method="post">
            <label>User ID</label>
            <input type="text"
                   name="userId"
                   class="form-control mb-3"
                   placeholder="Enter User ID">

            <label>Email</label>
            <input type="email"
                   name="email"
                   class="form-control mb-3"
                   placeholder="Enter Email">

            <label>Password</label>
            <input type="password"
                   name="password"
                   class="form-control mb-3"
                   placeholder="Enter Password">

            <label>Confirm Password</label>
            <input type="password"
                   name="confirmPassword"
                   class="form-control mb-3"
                   placeholder="Confirm Password">

            <button type="submit" class="btn btn-primary"> SignUp</button>
        </form>
    </div>
</div>
     <p <span style="color: green;" align="center">${signIn}</span></p>
</body>
</html>