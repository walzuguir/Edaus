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
		<th>Sexo</th>
		<th>Cpf</th>
		<th>Editar</th>
		<th>Excluir</th>
		</tr>
		
		<c:forEach items= "${list}" var="paciente">
			<tr>
				<td>${com.edaus.bean.Paciente.getid()}</td>
				<td>${com.edaus.bean.Paciente.getnome()}</td>
				<td>${com.edaus.bean.Paciente.getemail()}</td>
				<td>${com.edaus.bean.Paciente.getcelular()}</td>
				<td>${com.edaus.bean.Paciente.getsexo()}</td>
				<td>${com.edaus.bean.Paciente.getcpf()}</td>
				<td><a href="editarform.jsp?id=${paciente.getid()}">Editar</a></td>
				<td><a href="#">Excluir</a></td>
			</tr>
		</c:forEach>
	</table>
	<br>
	<a href="addpacienteform.jsp">Adicionar novo paciente</a>
</body>
</html>