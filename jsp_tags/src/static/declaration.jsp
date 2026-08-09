<html>
<head>
<title>Declaration</title>
</head>

<body>

	<h1>Declaration Tag</h1>
	<%!  int value=10;

		public int square(int value){
			return value*value;
		}  %>

	<h3>Number:<%=value %></h3>
	<h3>Square:<%=square(value) %></h3>

</body>
</html>