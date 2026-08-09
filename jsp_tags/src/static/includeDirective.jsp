<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Include Directive Example</title>
</head>

<body>

	<%@ include file="heading.jsp"%>
     <h2>Include Directive Explanation</h2>

	<p style="text-align: justify; max-width: 600px;">The JSP include directive is a mechanism used to insert the source code of one file into another JSP page at translation time (when the JSP is compiled into a servlet). It behaves as a static import, meaning the raw content of the target file is physically copied and merged into the main file before compilation occurs.</p>

</body>
</html>