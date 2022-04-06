<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cadastrar Curso</title>
</head>
<body>

	<c:import url="logout-parcial.jsp" />

	<h1>Cadastro de Curso</h1>
	
	<form action="entrada" method="POST">
		<label>Nome:</label><input type="text" name="nome">
		<br>
		<label>Quantidade de aulas:</label><input type="number" name="qtdAulas">
		<br>
		<label>Duração do curso:</label><input type="number" name="tempoDeCurso">
		<br>
		<label>Data de criação:</label><input type="text" name="dataDeCriacao">
		<br>
		<input type="hidden" name="run" value="CadastrarCurso">
		<button type="submit">Enviar</button>
	</form>

</body>
</html>