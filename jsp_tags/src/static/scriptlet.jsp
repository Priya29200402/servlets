<html>
<head>
<title>Scriptlet</title>
</head>

<body>
	<h1>Scriptlet Tag</h1>
	<%  String name="Priya";
		int java=85;
		int sql=80;
		int html=90;
		int total=java + sql + html;
		double percentage = total / 3.0;
		String result;

		if (percentage >= 40){
			result="Pass";
		}else{
			result="Fail";
		}  %>

	<h3>Student Name:<%= name %></h3>
	<h3>Java Marks:<%= java %></h3>
	<h3>SQL Marks:<%= sql %></h3>
	<h3>HTML Marks:<%= html %></h3>
	<h3>Total:<%= total %></h3>
	<h3>Percentage:<%= percentage %></h3>
	<h3>Result:<%= result %></h3>

</body>
</html>