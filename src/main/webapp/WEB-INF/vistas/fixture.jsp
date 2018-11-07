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

		<div class="container-fluid">
			<div class="col-md-12 main">
				<div class="row">
					<div class="col-md-8 col-md-offset-2">
						<c:if test="${not empty aviso }">
							<ol class="breadcrumb text-center">
								<li class="breadcrumb-item text-success">
									<h2>${aviso}</h2>
								</li>
							</ol>
						</c:if>
						<ol class="breadcrumb text-center">
	          			<li class="breadcrumb-item active">Administración de torneos - Desde aquí los podrá visualizar, crear y modificar.</li>
	     			</ol>
	     			
	     			<c:if test="${aviso != null}">
	     			<ol class="breadcrumb text-center">
	          			<li class="breadcrumb-item active">${aviso}</li>
	     			</ol>
	     			</c:if>
	     			<div class="panel panel-primary">
							<div class="panel-heading">Listado de Torneos</div>
							<div class="container-fluid">
								<div class="row">
									<div class="table-responsive">
										<table class="table table-hover">
											<thead>		
											<tr>
												<th class="text-center">ID</th>
												<th class="text-center">Fecha</th>
												<th class="text-center">Local</th>
												<th class="text-center">Resultado</th>
												<th class="text-center">Visitante</th>
											</tr>
											</thead>
											<c:forEach items="${torneos}" var="e">
											<tbody class="text-center">
												<td>${e.id}</td>
												<td>${e.nombre}</td>
											</tbody>
											</c:forEach>
										</table>
									</div>
								</div>
							</div>
						</div>
						<div class="panel panel-success">
						<div class="panel-heading"><h3 class="panel-title">Creación de un nuevo torneo:</h3></div>
							<ol class="breadcrumb text-center">
	          					<li class="breadcrumb-item active">Desde aquí podrá crear un nuevo toneo, ingrese a continuación un nombre para el mismo.</li>
	     					</ol>
						<div class="container-fluid">
						<form:form class="form-horizontal" role="form" action="crear-torneo" modelAttribute="torneo" method="post" name="crearTorneo">
							<div class="form-group"></div>

							<div class="form-group">
								<div class="col-md-10 col-md-offset-1">
									<div class="input-group">
										<span class="input-group-addon">Nombre</span> 												
										<form:input type="text" class="form-control" path="nombre" name="nombreTorneo" placeholder="Ingrese nombre." required="required"/>
									</div>
								</div>
							</div>
							
							<div class="form-group">
							<div class="col-md-offset-4 col-md-8">
								<a type="submit" data-toggle="modal" data-target="#add" class="btn btn-success">Crear nuevo Torneo</a>
							</div>
						</div>
					</form:form>
					</div>					
					</div>
					<div class="panel panel-warning">
						<div class="panel-heading acomodar"><h3 class="panel-title">Modificación de torneos:</h3>
							<div class="centrar_derecha" aria-label="top Align" data-placement="rigth" data-toggle="tooltip" data-html="true" title="Por el momento, solo se pueden modificar torneos que no tengan ningún partido">
								<div class="glyphicon glyphicon-question-sign" aria-hidden="true"></div>
							</div>
						</div>
							<ol class="breadcrumb text-center">
	          					<li class="breadcrumb-item active">Desde aquí podrá modificar el nombre del torneo seleccionado.</li>
	     					</ol>	
						<div class="container-fluid">

						<form:form class="form-horizontal" role="form" action="actualizar-torneo" modelAttribute="torneo" method="post" name="modificarTorneo">
							<div class="form-group"></div>

							<div class="form-group">
								<div class="col-md-10 col-md-offset-1">
									<div class="input-group center">
										<span class="input-group-addon">Torneo a modificar:</span>																								
											<form:select path="id" class="form-control" required="required">
											<c:forEach items="${equiposSinPartidos}" var="e">														
												<form:option value="${e.id}">${e.nombre}</form:option>
											</c:forEach>
											</form:select>
									</div>
								</div>
							</div>

							<div class="form-group">
								<div class="col-md-10 col-md-offset-1">
									<div class="input-group center">
										<span class="input-group-addon">Nombre</span> 											
										<form:input path="nombre" type="text" class="form-control" name="nombreTorneo" placeholder="Ingrese un nuevo nombre." required="required"/>
									</div>											
								</div>
							</div>							

							<div class="form-group">
								<div class="col-md-offset-4 col-md-8">
									<a type="submit" data-toggle="modal" data-target="#update" class="btn btn-warning">Modicar torneo existente</a>
								</div>
							</div>													
						</form:form>
						</div>
					</div>			
					</div>
				</div>
			</div>
		</div>
		
		<!-- Placed at the end of the document so the pages load faster -->
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js" ></script>
		<script>window.jQuery || document.write('<script src="../../assets/js/vendor/jquery.min.js"><\/script>')</script>
		<script src="js/bootstrap.min.js" type="text/javascript"></script>
	</body>
</html>
