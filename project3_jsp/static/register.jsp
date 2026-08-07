<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Registration Form</title>

<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet">

<style>
body {
	background:
		url("https://images.unsplash.com/photo-1521791136064-7986c2920216?auto=format&fit=crop&w=1500&q=80");
	background-size: cover;
	background-repeat: no-repeat;
	background-attachment: fixed;
	font-family: Arial, sans-serif;
}

.overlay {
	background: rgba(255, 255, 255, 0.90);
	min-height: 100vh;
	padding: 40px;
}

.card {
	border-radius: 15px;
}
</style>

</head>

<body>

<div class="overlay">

<nav class="navbar navbar-expand-lg navbar-dark bg-success rounded">

<div class="container-fluid">

<a class="navbar-brand fw-bold" href="index.jsp">
JSP Servlet
</a>

</div>

</nav>

<div class="container mt-5">

<div class="row justify-content-center">

<div class="col-md-8">

<div class="card shadow">

<div class="card-header bg-success text-white text-center">

<h2>Registration Form</h2>

</div>

<div class="card-body">

<form action="${pageContext.request.contextPath}/register" method="post">

<div class="row">

<div class="col-md-6 mb-3">
<label class="form-label">First Name</label>
<input type="text" class="form-control"
name="firstName"
pattern="[A-Za-z ]{3,20}"
required>
</div>

<div class="col-md-6 mb-3">
<label class="form-label">Last Name</label>
<input type="text" class="form-control"
name="lastName"
pattern="[A-Za-z ]{3,20}"
required>
</div>

<div class="col-md-6 mb-3">
<label class="form-label">Email</label>
<input type="email"
class="form-control"
name="email"
required>
</div>

<div class="col-md-6 mb-3">
<label class="form-label">Password</label>
<input type="password"
class="form-control"
name="password"
required>
</div>

<div class="col-md-6 mb-3">
<label class="form-label">Confirm Password</label>
<input type="password"
class="form-control"
name="confirmPassword"
required>
</div>

<div class="col-md-6 mb-3">
<label class="form-label">Mobile</label>
<input type="text"
class="form-control"
name="mobile"
pattern="[6-9][0-9]{9}"
maxlength="10"
required>
</div>

<div class="col-md-6 mb-3">
<label class="form-label">Gender</label>

<select class="form-select"
name="gender"
required>

<option value="">Select Gender</option>
<option>Male</option>
<option>Female</option>
<option>Other</option>

</select>

</div>

<div class="col-md-6 mb-3">
<label class="form-label">Date of Birth</label>
<input type="date"
class="form-control"
name="dob"
required>
</div>

<div class="col-md-6 mb-3">
<label class="form-label">Address</label>
<textarea class="form-control"
name="address"
rows="3"
required></textarea>
</div>

<div class="col-md-6 mb-3">
<label class="form-label">City</label>
<input type="text"
class="form-control"
name="city"
pattern="[A-Za-z ]{3,20}"
required>
</div>

</div>

<div class="d-grid">

<input type="submit"
value="Register"
class="btn btn-success">

</div>

</form>

<div class="text-center mt-3">

<a href="index.jsp"
class="btn btn-secondary">
Back to Home
</a>

</div>

<hr>

<h5 class="text-success text-center">
${message}
</h5>

<h5 class="text-danger text-center">
${error}
</h5>

</div>

</div>

</div>

</div>

</div>

</div>

<script
src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js">
</script>

</body>
</html>