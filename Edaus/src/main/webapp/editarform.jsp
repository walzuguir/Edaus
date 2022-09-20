<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Editor de pacientes</title>
</head>
<body>	
	<%@ page import= "com.edaus.bean.Paciente, com.edaus.dao.PacienteDao" %>
	
	<%
		String id = request.getParameter("id");
		Paciente paciente = PacienteDao.getRegistroById(Integer.parseInt(id));
	%>
		
	<h1>Editor de Pacientes</h1>
	
	<form action="editpaciente.jsp"  method="post">
		<input type="hidden" name ="id" value="<%=paciente.getid()%>"/>
		<table>
			<tr>
				<td>Nome: </td>
				<td><input type="text" name="nome" value="<%=paciente.getnome()%>"/></td>
			</tr>	
			<tr>
				<td>Email: </td>
				<td><input type="email" name="Email" value="<%=paciente.getemail()%>"/></td>
			</tr>
			<tr>
				<td>Celular: </td>
				<td><input type="text" name="Celular" value="<%=paciente.getcelular()%>"/></td>
			</tr>
			<tr>
				<td>Senha: </td>
				<td><input type="password" name="Senha" value="<%=paciente.getsenha()%>"/></td>
			</tr>
			<tr>
				<td>Sexo: </td>
				<td><input type="text" name="Sexo" value="<%=paciente.getsexo()%>"/></td>
			</tr>
			<tr>
				<td>Cpf: </td>
				<td><input type="text" name="CPF" value="<%=paciente.getcpf()%>"/></td>
			</tr>
			<tr>
				<td colspan="2"><input> type ="submit" value ="Editar Paciente"</td>
			</tr>
		</table>
	</form>








</body>
</html>