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
		<ol class="breadcrumb text-center">
			<li class="breadcrumb-item active">Cargar Resultado del Partido y Figura</li>
		</ol>
		<form:form action="guardar-resultado" method="POST" modelAttribute="partido">
		
			<form:hidden path="id"/>
			<form:label path="equipoLocal" cssStyle="color:white;">${partido.equipoLocal.nombre}:</form:label>&nbsp;&nbsp;&nbsp;
			<form:input type="number" min="0" pattern="^[0-9]+"  required="true" path="golesLocales" />&nbsp;&nbsp;&nbsp;

			<form:label path="equipoVisitante" cssStyle="color:white;">${partido.equipoVisitante.nombre}:</form:label>&nbsp;&nbsp;&nbsp;
			<form:input type="number" min="0" pattern="^[0-9]+" required="true" path="golesVisitantes" />
			<br><br>
			<b style="color:white;">Figura del partido:</b>&nbsp;&nbsp;&nbsp;
			<form:input path="figura" type="text" required="true"/>&nbsp;&nbsp;&nbsp;
			<form:label path="figura.equipo.id" cssStyle="color:white;">Equipo de la figura:</form:label>&nbsp;&nbsp;&nbsp;
			<form:select path="figura.equipo.id">
				<form:option value="${partido.equipoLocal.id}">${partido.equipoLocal.nombre}</form:option>
				<form:option value="${partido.equipoVisitante.id}">${partido.equipoVisitante.nombre}</form:option>
			</form:select>&nbsp;&nbsp;&nbsp;
			
			<form:button type="Submit">Guardar datos</form:button>
	
		</form:form>		
	</div>
</body>
</html>