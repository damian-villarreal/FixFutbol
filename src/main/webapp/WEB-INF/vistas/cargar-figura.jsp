<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ include file="includes/header.jsp"%>
<title>Cargar Figura</title>
</head>
<body>	

<%@ include file="includes/navbar.jsp" %>

	<div class="panel-heading text-center">
		<form:form action="guardar-figura" method="POST" modelAttribute="figura">
			<form:input path="nombreCompleto"/>
			<form:button type="Submit">Guardar Figura</form:button>
		</form:form>
	</div>
</body>
</html>