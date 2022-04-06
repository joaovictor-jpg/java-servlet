<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List,br.com.courseinfo.model.Curso" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Lista Cursos Info</title>
</head>
<body>
	
	<c:import url="logout-parcial.jsp" />

	<h1>Cursos</h1>
	<table border=2>
		<thead>
			<tr>
				<th>Id</th>
				<th>Nome do curso</th>
				<th>Aulas</th>
				<th>Duração</th>
				<th>Data de Criação</th>
				<th>Opções</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${ cursos }" var="curso" >
				<tr>
					<td>${ curso.id }</td>
					<td>${ curso.name }</td>
					<td>${ curso.quantidadeDeAulas }</td>
					<td>${ curso.duracaoDoCurso }</td>
					<td><fmt:formatDate value="${ curso.dataDeCriacao }" pattern="dd/MM/yyyy"/></td>
					<td><a href="/courseinfo/entrada?run=Editar&id=${ curso.id }">Editar</a> <a href="/courseinfo/entrada?run=Excluir&id=${ curso.id }">Excluir</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>