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
			<li class="breadcrumb-item active">Partidos disponibles</li>
		</ol>

		<p>Seleccione número de fecha:</p>
		<div class="form-group">
			<select class="form-control">
				<option>Todas</option>
				<c:forEach var="f" items="${fechas}">
					<option value="${f.numero}">${f.numero}</option>>
				</c:forEach>
			</select>
		</div>

		<c:forEach var="f" items="${fechas}">
			<div class="panel panel-primary" id="${f.numero}">
				<div class="panel-heading text-center" id="${f.numero}">Fecha
					${f.numero}</div>
				<c:forEach items="${partidos}" var="p">
					<c:if test="${f.numero == p.fecha.numero }">
						<div class="panel-body text-center">
							
									<div class="col-md-4">
									<img alt="" height="50px" src="${p.equipoLocal.logo}">
									${p.equipoLocal.nombre}</div>
									<div class="col-md-4">
										<p>VS</p>
				
									</div>
									<div class="col-md-4">${p.equipoVisitante.nombre}
									<img alt="" height="50px" src="${p.equipoVisitante.logo}">
									</div>

						
						</div>
					</c:if>
				</c:forEach>

			</div>
		</c:forEach>
		
	</div>

	<!-- Placed at the end of the document so the pages load faster -->
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
	<script>
		window.jQuery
				|| document
						.write('<script src="../../assets/js/vendor/jquery.min.js"><\/script>')
	</script>
	<script src="js/bootstrap.min.js" type="text/javascript"></script>
</body>
</html>
