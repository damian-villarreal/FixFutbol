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
		
		<h2>${mensaje}</h2>
		
		<div class="table-responsive">
			<table class="table table-condensed  table-bordered">
			
				<tbody>
				
					<tr>
						<th>Nombre<th>					
						<th>Equipo</th>
						<th>Veces Figura</th>
				
					</tr>
				</tbody>
				<!--<c:forEach items="${tablas}" var="tabla"  >
				
					<tbody>
						<tr>
																				
							<td>${tabla.equipo.nombre}</td>
							<td>${tabla.jugados}</td>
    						<td>${tabla.ganados} </td>
    						<td>${tabla.empatados} </td>
    						<td>${tabla.perdidos} </td>
    						<td>${tabla.golesfavor} </td>
    						<td>${tabla.golescontra} </td>
    						<td>${tabla.diferenciagoles} </td>
    						<td>${tabla.puntos} </td>
						</tr>       
					</tbody>  
      			</c:forEach>-->
			</table>
		</div>
		
</body>
</html>