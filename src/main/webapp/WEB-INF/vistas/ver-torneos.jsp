<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="es">
<head>
<%@ include file="includes/header.jsp"%>
</head>
<body>
	<%@ include file="includes/navbar.jsp"%>

	<div class="col-md-8 col-md-offset-2">
		<ol class="breadcrumb text-center">
			<li class="breadcrumb-item active">Torneos creados</li>
		</ol>
		<table class="table bg-">
			<thead class="thead-dark">
				<tr>
					<td>Nombre</td>
					<td>Tipo de torneo</td>
				</tr>
			</thead>
			<tbody>
			
				<c:forEach items="${torneos}" var="torneo">
					<tr>
					<td>
					<a href="http://localhost:8080/proyecto-limpio-spring/detalle-torneo?idTorneo=${torneo.id}">
						${torneo.nombre}
						</a>
						</td>
						<td>${torneo.tipoTorneo}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>

	<!-- Placed at the end of the document so the pages load faster -->
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
	<script>window.jQuery || document.write('<script src="../../assets/js/vendor/jquery.min.js"><\/script>')</script>
	<script src="js/bootstrap.min.js" type="text/javascript"></script>
</body>
</html>
