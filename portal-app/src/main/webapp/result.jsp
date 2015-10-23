<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>Facebook 2</title>
<%@ include file="header.jsp" %>
</head>
<body>

	<div id="container">
		<div id = "topnav">
			<%@ include file="topnav.jsp" %>
		</div>
		<div id = "content">
			<c:out value="${request }"></c:out>
		</div>
		<div id = "footer">
			<%@include file="footer.jsp" %>
		</div>
	</div>

</body>
</html>
