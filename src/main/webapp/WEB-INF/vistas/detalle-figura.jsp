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

		<h1>Tabla de Figuras</h1>
		
		<div class="table-responsive">
			<table class="table table-condensed  table-bordered">
			
				<tbody>
					<tr>
						<th>Nombre</th>					
						<th>Equipo</th>
						<th>Veces Figura</th>	
					</tr>
				</tbody>
				
				<c:forEach items="${figuras}" var="figura">
					<tbody>
						<tr>													
							<td>${figura.nombreCompleto}</td>
							<td>${figura.equipo.nombre}</td>
							<td>${figura.vecesFigura}</td>
    						
						</tr>       
					</tbody>  
      			</c:forEach>
			
			</table>
		</div>
</body>
</html>