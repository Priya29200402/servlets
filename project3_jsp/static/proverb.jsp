<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Proverb Form</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>

<div class="container mt-5">
    <div class="card shadow">
        <div class="card-header bg-primary text-white text-center">
            <h2>Proverb Form</h2>
        </div>
        <div class="card-body">
            <form action="proverb" method="post">

                <div class="mb-3">
                    <label class="form-label">Full Name</label>
                    <input type="text" class="form-control" name="name" placeholder="Enter Full Name" pattern="[A-Za-z ]{3,30}" required value="${name}">
                </div>

                <div class="mb-3">
                    <label class="form-label">Email</label>
                    <input type="email" class="form-control" name="email" placeholder="Enter Email" required value="${email}">
                </div>

                <div class="mb-3">
                    <label class="form-label">Mobile Number</label>
                    <input type="text" class="form-control" name="mobile" placeholder="Enter Mobile Number" pattern="[6-9][0-9]{9}" maxlength="10" required value="${mobile}">
                </div>

                <div class="mb-3">
                    <label class="form-label">Proverb / Message</label>
                    <textarea class="form-control" name="proverb" rows="4" placeholder="Enter Proverb" required>${proverb}</textarea>
                </div>

                <div class="mb-3">
                    <label class="form-label">City</label>
                    <input type="text" class="form-control" name="city" placeholder="Enter City" pattern="[A-Za-z ]{2,30}" required value="${city}">
                </div>

                <div class="d-grid">
                    <input type="submit" value="Submit Proverb" class="btn btn-primary">
                </div>

            </form>

            <hr>

            <div class="text-center">
                <h5 class="text-success">${message}</h5>
            </div>

            <div class="mt-3">
                <a href="index.jsp" class="btn btn-secondary">Back to Home</a>
            </div>
        </div>
    </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>