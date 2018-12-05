<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<nav class="navbar navbar-default">
  <div class="container-fluid">
    <!-- Brand and toggle get grouped for better mobile display -->
    <div class="navbar-header">
      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
      <a class="navbar-brand" href="http://localhost:8080/proyecto-limpio-spring">
      	<span class="glyphicon glyphicon-globe" style="margin-right: 12px"></span>FixFútbol
      </a>
    </div>

    <!-- Collect the nav links, forms, and other content for toggling -->
    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
      <ul class="nav navbar-nav">
        <li class="active">
        	<a href="http://localhost:8080/proyecto-limpio-spring">
        		<span class="glyphicon glyphicon-home" style="margin-right: 12px"></span>Home 
        		<span class="sr-only">(current)</span>
        	</a>
        </li>
        <li>
        	<a href="http://localhost:8080/proyecto-limpio-spring/crear-liguilla" id="crearLiguilla">
        		Crear Liguilla
        	</a>
        </li>
        <!--  <li>
        	<a href="http://localhost:8080/proyecto-limpio-spring/crear-eliminacion">
        		Eliminacion Directa(Proximamente)
        	</a>
        </li>
        <li>
        	<a href="#">Mundial(Proximamente)</a>
        </li>-->
        <li>
        	<a href="http://localhost:8080/proyecto-limpio-spring/ver-torneos"><span class="glyphicon glyphicon-search" style="margin-right: 12px"></span>Ver Torneos</a>
        </li>
<!--         <li> -->
<!--         	<a href="http://localhost:8080/proyecto-limpio-spring/posiciones-torneo"><span class="glyphicon glyphicon-indent-left" style="margin-right: 12px"></span>Ver Posiciones</a> -->
<!--         </li> -->
<!--         <li> -->
<!--         	<a href="http://localhost:8080/proyecto-limpio-spring/posiciones-figura"><span class="glyphicon glyphicon-indent-left" style="margin-right: 12px"></span>Ver Figuras</a> -->
<!--         </li> -->
       <!--   <li>
        	<a href="http://localhost:8080/proyecto-limpio-spring/cargar-resultado"><span class="glyphicon glyphicon-plus" style="margin-right: 12px"></span>Cargar Resultado</a>
        </li>-->
      </ul>
      
      
    </div><!-- /.navbar-collapse -->
  </div><!-- /.container-fluid -->
</nav>