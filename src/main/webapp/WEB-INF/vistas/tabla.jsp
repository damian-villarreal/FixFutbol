<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>TABLA DE POSICIONES</h1>

<table>
<tr>
<th>Equipo</th>
<th> PG </th>
<th> PE </th>
<th> PP </th>
<th> GF </th>
<th> GC </th>
<th> DIF </th>
<th> Puntos </th>
</tr>

<c:forEach items="${tablas}" var="tabla">
<tr>
	<td>${tabla.equipo.nombre}</td>
    <td>${tabla.ganados} </td>
    <td>${tabla.empatados} </td>
    <td>${tabla.perdidos} </td>
    <td>${tabla.golesfavor} </td>
    <td>${tabla.golescontra} </td>
    <td>${tabla.diferenciagoles} </td>
    <td>${tabla.puntos} </td>
</tr>         
      </c:forEach>





</table>
</body>
</html>