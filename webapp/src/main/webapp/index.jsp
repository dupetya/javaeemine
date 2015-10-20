<html>
<head>
<title>Hello World</title>
</head>
<body>
	<form action="ForwardParameterServlet" method="post">
		<input type="text" name="parameter"><br>
		<input type="text" name="parameter2"><br>
		<input type="submit">
	</form>
	
	<%
		String result = (String)request.getAttribute("result");
		if(result != null) {
			%>
			VANVANVANVANVAN
			<%
		}
	%>
</body>
</html>