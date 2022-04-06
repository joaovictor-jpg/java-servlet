<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cadastrar Curso</title>
</head>
<body>

	<h1>Cadastro de Curso</h1>
	
	<form action="entrada" method="POST">
		<label>Login:</label> <input type="text" name="login">
		<label>Senha:</label> <input type="password" name="senha">
		<input type="hidden" name="run" value="Login">
		<button type="submit">Enviar</button>
	</form>

</body>
</html>