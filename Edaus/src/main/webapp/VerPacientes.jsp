<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Pacientes</title>
</head>
<body>
	<%@ page import="com.edaus.dao.PacienteDao, com.edaus.bean.Paciente, java.util.* "%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
	
	<h1> Listagem de pacientes </h1>
	
	<%
	List<Paciente> list = PacienteDao.getAllPacientes();
	request.setAttribute("list", list);
	%>
	
	<table border="1">
		<tr>
		<th>ID</th>
		<th>Nome</th>
		<th>Email</th>
		<th>Celular</th>
		<th>Senha</th>
		<th>Sexo</th>
		<th>Cpf</th>
		<th>Editar</th>
		<th>Excluir</th>
		</tr>
		
		<c:forEach items="${list}" var="paciente">
			<tr>
				<td><c:out value="${paciente.id}" /></td>
				<td><c:out value="${paciente.nome}" /></td>
				<td><c:out value="${paciente.email}" /></td>
				<td><c:out value="${paciente.celular}" /></td>
				<td><c:out value="${paciente.senha}" /></td>
				<td><c:out value="${paciente.sexo}" /></td>
				<td><c:out value="${paciente.cpf}" /></td>
				<td><a href="editarform.jsp?id=${paciente.id}">Editar</a></td>
				<td><a href="#">Excluir</a></td>
			</tr>
		</c:forEach>
	</table>
	<br>
	<a href="addpacienteform.jsp">Adicionar novo paciente</a>
</body>
</html>