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
		
		 <div id="myCarousel" class="carousel slide" data-ride="carousel">
  			<ol class="carousel-indicators">
    			<li data-target="#myCarousel" data-slide-to="0" class="active"></li>
    			<li data-target="#myCarousel" data-slide-to="1"></li>
    			<li data-target="#myCarousel" data-slide-to="2"></li>
  			</ol>

  			<div class="carousel-inner">
    			<div class="item active">
      				<img src="img/uefa.jpg" width="100%" height="100%">
    			</div>

    			<div class="item">
      				<img src="img/copa.jpg" width="100%">
    			</div>

    			
  			</div>

  			<a class="left carousel-control" href="#myCarousel" data-slide="prev">
    			<span class="glyphicon glyphicon-chevron-left"></span>
    			<span class="sr-only">Previous</span>
  			</a>
  			<a class="right carousel-control" href="#myCarousel" data-slide="next">
    			<span class="glyphicon glyphicon-chevron-right"></span>
    			<span class="sr-only">Next</span>
  			</a>
		</div>
		
		<!-- <div class="jumbotron">
		
			<p><a href="http://localhost:8080/proyecto-limpio-spring/ver-torneos">
  				ver torneos creados
  			</a>
  			</p> 
  			
  			<h1>Elija un tipo de torneo</h1>
  			<a href="http://localhost:8080/proyecto-limpio-spring/crear-liguilla">
  				<button class="btn btn-primary btn-lg">Liguilla</button>
  			</a> 
  			
  			<a href="http://localhost:8080/proyecto-limpio-spring/crear-eliminacion">
  			<button class="btn btn-primary btn-lg">Eliminación Directa</button>
  			</a>
  			
  			<a href="http://localhost:8080/proyecto-limpio-spring/crear-mundial">
  			<button class="btn btn-primary btn-lg">Mundial</button>
  			</a>
		</div> -->
		
		<!-- Placed at the end of the document so the pages load faster -->
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js" ></script>
		<script>window.jQuery || document.write('<script src="../../assets/js/vendor/jquery.min.js"><\/script>')</script>
		<script src="js/bootstrap.min.js" type="text/javascript"></script>
	</body>
</html>
