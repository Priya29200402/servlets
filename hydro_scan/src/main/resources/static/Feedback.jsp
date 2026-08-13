<html>
<head>
    <title>Hydro Scan Feedback</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<nav class="navbar navbar-dark bg-primary">
    <div class="container">
        <a class="navbar-brand" href="index.html"> Hydro Scan </a>
        <div>
            <a class="text-white me-3" href="SignUp.jsp"> SignUp </a>
            <a class="text-white me-3" href="SignIn.jsp"> SignIn </a>
            <a class="text-white" href="Feedback.jsp"> Feedback </a>
        </div>
    </div>
</nav>

<div class="container mt-5">
    <div class="col-md-6 mx-auto">
        <h2 class="text-center text-primary mb-4"> Feedback </h2>
        <form action="feedback" method="post">
            <label>Name</label>
            <input type="text"
                   name="name"
                   class="form-control mb-3"
                   placeholder="Enter Name">

            <label>Email</label>
            <input type="email"
                   name="email"
                   class="form-control mb-3"
                   placeholder="Enter Email">

            <label>Mobile</label>
            <input type="text"
                   name="mobile"
                   class="form-control mb-3"
                   placeholder="Enter Mobile">

            <label>Comment</label>
            <input type="text"
                   name="comment"
                   class="form-control mb-3"
                   placeholder="Enter Comment">

            <button type="submit" class="btn btn-primary"> Submit </button>
        </form>
    </div>
</div>
     <p <span style="color: green;" align="center">${feedback}</span></p>
</body>
</html>
