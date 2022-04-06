<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Editar Curso</title>
</head>
<body>

	<c:import url="logout-parcial.jsp" />

	<h1>Editar Curso</h1>
	
	<form action="entrada" method="POST">
		<label>Nome:</label><input type="text" name="nome" value="${ curso.name }">
		<br>
		<label>Quantidade de aulas:</label><input type="number" name="qtdAulas" value="${ curso.quantidadeDeAulas }">
		<br>
		<label>Duração do curso:</label><input type="number" name="tempoDeCurso" value="${ curso.duracaoDoCurso }">
		<br>
		<label>Data de criação:</label><input type="text" name="dataDeCriacao" value='<fmt:formatDate value="${ curso.dataDeCriacao }" pattern="dd/MM/yyyy"/>'>
		<input type="hidden" name="id" value="${ curso.id }">
		<br>
		<input type="hidden" name="run" value="AtualizarCurso">
		<button type="submit">Enviar</button>
	</form>

</body>
</html>