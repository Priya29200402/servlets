<html>
<head>
    <title>Hydro Scan Sign In</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<nav class="navbar navbar-dark bg-primary">
    <div class="container">
        <a class="navbar-brand" href="index.html"> Hydro Scan </a>
    </div>
</nav>

<div class="container mt-5">
    <div class="col-md-5 mx-auto">

        <form action="signup" method="post">
            <label>User ID</label>
            <input type="text"
                   name="userId"
                   class="form-control mb-3"
                   placeholder="Enter User ID">
            <label>Password</label>
            <input type="password"
                   name="password"
                   class="form-control mb-3"
                   placeholder="Enter Password">

            <button type="submit"
                    class="btn btn-primary"> Sign UP
            </button>
        </form>
    </div>
</div>
   <p <span style="color: green;" align="center">${signUpDTO}</span></p>
</body>
</html>