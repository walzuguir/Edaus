<%@page import="com.edaus.dao.PacienteDao"%>
<jsp:useBean id="p" class="com.edaus.bean.Paciente"></jsp:useBean>
<jsp:setProperty property="*" name="p"/>

<%
    int i = PacienteDao.updatePaciente(p);
	response.sendRedirect("VerPacientes.jsp");
%>  

Record:<br>
<jsp:getProperty property="id" name="p"/><br>
<jsp:getProperty property="nome" name="p"/><br>
<jsp:getProperty property="email" name="p"/><br>
<jsp:getProperty property="celular" name="p"/><br>
<jsp:getProperty property="senha" name="p"/><br>
<jsp:getProperty property="sexo" name="p"/><br>
<jsp:getProperty property="cpf" name="p"/><br>