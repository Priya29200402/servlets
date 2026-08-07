<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Contact Form</title>

<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet">

<style>
body {
	background:
		url("https://images.unsplash.com/photo-1516321318423-f06f85e504b3?auto=format&fit=crop&w=1500&q=80");
	background-size: cover;
	background-repeat: no-repeat;
	background-attachment: fixed;
	font-family: Arial, sans-serif;
}

.overlay {
	background: rgba(255, 255, 255, 0.9);
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

		<nav class="navbar navbar-expand-lg navbar-dark bg-primary rounded">

			<div class="container-fluid">

				<a class="navbar-brand fw-bold" href="index.jsp">
					JSP Servlet Practice
				</a>

			</div>

		</nav>

		<div class="container mt-5">

			<div class="row justify-content-center">

				<div class="col-md-7">

					<div class="card shadow">

						<div class="card-header bg-primary text-white text-center">

							<h2>Contact Form</h2>

						</div>

						<div class="card-body">

							<form action="contact" method="post">

								<div class="mb-3">

									<label class="form-label">Full Name</label>

									<input type="text"
										class="form-control"
										name="name"
										placeholder="Enter Full Name"
										pattern="[A-Za-z ]{3,30}"
										required>

								</div>

								<div class="mb-3">

									<label class="form-label">Email</label>

									<input type="email"
										class="form-control"
										name="email"
										placeholder="Enter Email"
										required>

								</div>

								<div class="mb-3">

									<label class="form-label">Mobile Number</label>

									<input type="text"
										class="form-control"
										name="mobile"
										placeholder="Enter Mobile Number"
										pattern="[6-9][0-9]{9}"
										maxlength="10"
										required>

								</div>

								<div class="mb-3">

									<label class="form-label">Message</label>

									<textarea
										class="form-control"
										name="message"
										rows="4"
										placeholder="Enter Your Message"
										required></textarea>

								</div>

								<div class="d-grid">

									<input type="submit"
										value="Send Contact"
										class="btn btn-primary">

								</div>

							</form>

							<div class="text-center mt-3">

								<a href="index.jsp"
									class="btn btn-secondary">
									Back to Home
								</a>

							</div>

							<hr>

							<span class="text-success fw-bold fs-5">
								${message}
							</span>

							<br>

							<span class="text-danger fw-bold">
								${error}
							</span>

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