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
		
		
		<div class="jumbotron">
  			<h1>Elija un tipo de torneo</h1>
  			<a href="http://localhost:8080/proyecto-limpio-spring/fixture.jsp">
  				<button class="btn btn-primary btn-lg">Liguilla</button>
  			</a> 
  			
  			<button class="btn btn-primary btn-lg">Eliminación Directa</button>
  			<button class="btn btn-primary btn-lg">Mundial</button>
		</div>
		
		<!-- Placed at the end of the document so the pages load faster -->
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js" ></script>
		<script>window.jQuery || document.write('<script src="../../assets/js/vendor/jquery.min.js"><\/script>')</script>
		<script src="js/bootstrap.min.js" type="text/javascript"></script>
	</body>
</html>
