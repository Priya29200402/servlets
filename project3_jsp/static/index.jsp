<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP Servlet Practice Project</title>

<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet">

<style>
body {
	background:
		url("https://images.unsplash.com/photo-1498050108023-c5249f4df085?auto=format&fit=crop&w=1500&q=80");
	background-size: cover;
	background-repeat: no-repeat;
	background-attachment: fixed;
	font-family: Arial, sans-serif;
}

.overlay {
	background: rgba(255, 255, 255, 0.88);
	min-height: 100vh;
	padding: 40px;
}

.card {
	border: none;
	border-radius: 15px;
	transition: 0.4s;
}

.card:hover {
	transform: translateY(-8px);
	box-shadow: 0 10px 25px rgba(0, 0, 0, 0.3);
}

.btn {
	width: 100%;
}

h1 {
	font-weight: bold;
	color: #0d6efd;
}

.footer {
	margin-top: 60px;
	text-align: center;
	color: gray;
}
</style>

</head>

<body>

	<div class="overlay">

		<nav class="navbar navbar-expand-lg navbar-dark bg-primary rounded shadow">

			<div class="container-fluid">

				<a class="navbar-brand fw-bold" href="index.jsp">
					JSP Servlet
				</a>

			</div>

		</nav>

		<div class="container mt-5">

			<h1 class="text-center mb-5">Welcome to JSP and Servlet</h1>

			<div class="row g-4">


				<div class="col-md-4">

					<div class="card shadow h-100">

						<div class="card-body text-center">

							<h3 class="text-primary">Contact Form</h3>

							<p class="mt-3">
								Contact Form using JSP, Servlet.
							</p>

							<a href="contact.jsp" class="btn btn-primary">
								Open Contact Form
							</a>

						</div>

					</div>

				</div>

				<div class="col-md-4">

					<div class="card shadow h-100">

						<div class="card-body text-center">

							<h3 class="text-success">Register Form</h3>

							<p class="mt-3">
							Registration Form with JSP and Servlet.
							</p>

							<a href="register.jsp" class="btn btn-success">
								Open Register Form
							</a>

						</div>

					</div>

				</div>

				<div class="col-md-4">

					<div class="card shadow h-100">

						<div class="card-body text-center">

							<h3 class="text-warning">Proverb Form</h3>

							<p class="mt-3">
								Proverb Submission using JSP and
								Servlet.
							</p>

							<a href="proverb.jsp" class="btn btn-warning">
								Open Proverb Form
							</a>

						</div>

					</div>

				</div>

			</div>

			<div class="footer">

				<hr>

				<h5> JSP & Servlet Project </h5>

				<p>Developed by:Priya </p>

			</div>

		</div>

	</div>

	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>