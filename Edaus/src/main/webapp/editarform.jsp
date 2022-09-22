<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Editor de pacientes</title>
</head>
<body>
	<%@ page import="com.edaus.bean.Paciente, com.edaus.dao.PacienteDao"%>

	<%
	String id = request.getParameter("id");

	int idPaciente = Integer.parseInt(id);

	Paciente p = new Paciente();

	p = PacienteDao.getRegistroById(idPaciente);
	%>
	<h1>Editor de Pacientes</h1>
	<input type="hidden" name="id" value="<%=p.getid()%>"/>

	<form action="editpaciente.jsp" method="post">
		<table>
			<tr>
				<td>Nome:</td>
				<td><input type="text" name="nome" value="<%=p.getnome()%>" /></td>
			</tr>
			<tr>
				<td>Email:</td>
				<td><input type="email" name="email" value="<%=p.getemail()%>" /></td>
			</tr>
			<tr>
				<td>Celular:</td>
				<td><input type="text" name="celular"
					value="<%=p.getcelular()%>" /></td>
			</tr>
			<tr>
				<td>Senha:</td>
				<td><input type="password" name="senha"
					value="<%=p.getsenha()%>" /></td>
			</tr>
			<tr>
				<td>Sexo:</td>
				<td><input type="text" name="sexo" value="<%=p.getsexo()%>" /></td>
			</tr>
			<tr>
				<td>Cpf:</td>
				<td><input type="text" name="cpf" value="<%=p.getcpf()%>" /></td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value="Atualizar Paciente" /></td>
			</tr>
		</table>
	</form>