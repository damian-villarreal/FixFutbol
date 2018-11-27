<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="es">
	<head>
		<%@ include file="includes/header.jsp"%>
	</head>
	<body>
		<%@ include file="includes/navbar.jsp" %>
		
		<div class="col-md-8 col-md-offset-2">
			<ol class="breadcrumb text-center">
				<li class="breadcrumb-item active">
					Partidos disponibles
				</li>
			</ol>
			
	<%-- 		<form:select path="numero" name="fecha" > 
					<option>Seleccione</option>
					<c:forEach items="${fechas}" var="f">
						<form:option value="${f.id}">
							${f.numero}
						</form:option>
					</c:forEach>
				</form:select>--%>
				
			<c:forEach items="${partidos}" var="p">
				<div class="panel panel-primary">
					<div class="panel-heading text-center">
						${p.equipoLocal.nombre} - ${p.equipoVisitante.nombre}
					</div>
					
<!-- 					<span class="input-group-addon"> -->
<!-- 						<button class="btn btn-success">Cargar Resultado</button> -->
<!-- 					</span> -->
				</div>
				
			</c:forEach>
		</div>
						
		<!-- Placed at the end of the document so the pages load faster -->
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js" ></script>
		<script>window.jQuery || document.write('<script src="../../assets/js/vendor/jquery.min.js"><\/script>')</script>
		<script src="js/bootstrap.min.js" type="text/javascript"></script>
	</body>
</html>
