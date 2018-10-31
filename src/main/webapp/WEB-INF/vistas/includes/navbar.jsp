<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

 <nav class="navbar navbar-default navegador navbar-fixed-top">
        <div class="container-fluid">
            <!-- Brand and toggle get grouped for better mobile display -->
            <div class="navbar-header">
                <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>               
                
		  		 <c:choose>
                    	<c:when test="${AdminId != null}">
		   					<a class="navbar-brand hoverNav" href="http://localhost:8080/proyecto-limpio-spring/ABM-Equipo">
		   						<!-- <img src="img/.png" class="logo"> -->
		   					</a>
		  				</c:when>
	                	<c:otherwise>
	   						<a class="navbar-brand hoverNav" href="http://localhost:8080/proyecto-limpio-spring/index">
	   							<!-- <img src="img/bf.png" class="logo">  -->
	   						</a>
	   					</c:otherwise>
                 </c:choose>		  		
            </div>

            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav">
                                
                	<c:if test="${AdminId == null}">
		   				<li class="hoverNav"><a href="http://localhost:8080/proyecto-limpio-spring/index">Home</a></li>
		  			</c:if>
		  				
                	
		  					  			                  
                </ul>
                <ul class="nav navbar-nav navbar-right">
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">
                    <c:choose>
                    	<c:when test="${userId != null}">
		   						<span>Bienvenido ${nombre}</span>
		  				</c:when>
		  				<c:when test="${AdminId != null}">
		   						<span>Bienvenido ${nombre}</span>
		  				</c:when>
	                	<c:otherwise>
	   						<span>Entrar</span>
	   					</c:otherwise>
                    </c:choose>
                        
                        <span class="caret"></span></a>
                        <ul class="dropdown-menu">
                        
                      <c:choose>
                            <c:when test="${userId != null}">
                            
		   						<li>
		   						<a href="#" data-toggle="modal" data-target="#logout">Salir</a>
		   						</li>
		   					</c:when>	
		   					 <c:when test="${AdminId != null}">
		   						<li>
		   						<a href="#" data-toggle="modal" data-target="#logout">Salir</a>
		   						</li>
		   					</c:when>	   							                    
                            <c:otherwise>
                            	<li><a href="#" data-toggle="modal" data-target="#modalLogin">Iniciar sesión</a></li>
	                            <li><a href="#" data-toggle="modal" data-target="#modalRegistro">Registrarse</a></li>
                            </c:otherwise>                            
	                    </c:choose>
                        </ul>
                    </li>
                </ul>               
            </div><!-- /.navbar-collapse -->
        </div><!-- /.container-fluid -->
    </nav>