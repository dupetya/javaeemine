<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="tg" tagdir="/WEB-INF/tags"%>
<html>
<head>
<title>Facebook 2 - Register</title>
<%@ include file="./header.jsp"%>
<script src="../scripts/register.js"></script>
</head>
<body>

	<div id="container">
		<div id="topnav">
			<%@ include file="./topnav.jsp"%>
		</div>
		<div id="content">
			<c:if test="${not empty sessionScope.result }">
				<div id="result">

					<c:set var="colr" value="red" />
					<c:choose>
						<c:when test="${sessionScope.result == 'OK' }">
							<c:set var="colr" value="green" />
							<font color="${colr }">Successfully registered user!</font>
						</c:when>

						<c:otherwise>
							<font color="${colr }">${sessionScope.cause }</font>
							<c:remove var="cause"/>
						</c:otherwise>
					</c:choose>
				</div>
				<c:remove var="result"/>
			</c:if>

			<tg:registerForm />
		</div>
		<div id="footer">
			<%@include file="./footer.jsp"%>
		</div>
	</div>

</body>
</html>
