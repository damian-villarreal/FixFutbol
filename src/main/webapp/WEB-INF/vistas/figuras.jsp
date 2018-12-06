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

		<!-- <h1 style="color:white">Tabla de Figuras</h1> -->
		<ol class="breadcrumb text-center">
			<li class="breadcrumb-item active">Tabla de Figuras</li>
		</ol>
		
		<div class="table-responsive">
			<table class="table table-condensed  table-bordered" style="background-color: white">
			
				<tbody>
					<tr>
						<th>Nombre</th>					
						<th>Equipo</th>
						<th>Cantidad en la que fue Figura</th>	
					</tr>
				</tbody>
				
				<c:forEach items="${figuras}" var="figura">
				<c:if test="${figura.cantFigura!=0}">
					<tbody>
						<tr>													
							<td>${figura.figura.nombreCompleto}</td>
							<td>${figura.figura.equipo.nombre}</td>
							<td>${figura.cantFigura}</td>
    						
						</tr>       
					</tbody>  
      		</c:if>
      			</c:forEach>
			
			</table>
		</div>
</body>
</html>