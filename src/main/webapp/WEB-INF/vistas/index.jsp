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
		<div>
		<%@ include file="includes/navbar.jsp" %>
		</div>
		
		<div class="jumbotron">
  			<h1>Elija un tipo de torneo</h1>
  			<p>...</p>
  		<p><a class="btn btn-primary btn-lg" href="#" role="button">Learn more</a></p>
		</div>
		<br>
		<br>
		<br>
		<br>
		<div>
		<p>
			Elegir tipo de torneo
		</p>
		
		<button><a href="./liguilla">Liguilla</a></button>
		<button>Eliminacion directa</button>
		<button>Mundial</button>
		</div>
		
		<!-- Placed at the end of the document so the pages load faster -->
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js" ></script>
		<script>window.jQuery || document.write('<script src="../../assets/js/vendor/jquery.min.js"><\/script>')</script>
		<script src="js/bootstrap.min.js" type="text/javascript"></script>
	</body>
</html>
