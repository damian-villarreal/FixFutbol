<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ include file="includes/header.jsp"%>
<title>Cargar Resultado</title>
</head>
<body>	

<%@ include file="includes/navbar.jsp" %>

	<div class="panel-heading text-center">
		<form:form action="guardar-resultado" method="POST" modelAttribute="partido">
		
			<form:hidden path="id"/>
			<form:label path="equipoLocal">${partido.equipoLocal.nombre}</form:label>
			<form:input type="number" min="0" pattern="^[0-9]+"  required="true" path="golesLocales" />

			<form:label path="equipoVisitante">${partido.equipoVisitante.nombre}</form:label>
			<form:input type="number" min="0" pattern="^[0-9]+" required="true" path="golesVisitantes" />
			<br><br>
			<b>Figura del partido</b>
			<form:input path="figura"/>
			<form:label path="figura.equipo.id">Equipo de la figura</form:label>
			<form:select path="figura.equipo.id">
				<form:option value="${partido.equipoLocal.id}">${partido.equipoLocal.nombre}</form:option>
				<form:option value="${partido.equipoVisitante.id}">${partido.equipoVisitante.nombre}</form:option>
			</form:select>
			
			<form:button type="Submit">Guardar datos</form:button>
	
		</form:form>		
	</div>
</body>
</html>