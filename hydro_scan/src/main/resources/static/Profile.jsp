<html>
<head>
    <title>Hydro Scan</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<nav class="navbar navbar-dark bg-primary">

</nav>

<div class="container text-center mt-5">
    <h1 class="text-primary"> Update Profile, ${userId} </h1>
    <form action="upload" method="post">
        <input type="file" name="image">
       name: <input  type="text" name="name">
        <input type="hidden" name="userId">
        <button type="submit" class="btn btn-primary"> Upload </button>
    </form>

</div>
</body>
</html>