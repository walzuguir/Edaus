<%@page import="com.edaus.dao.PacienteDao"%>
<jsp:useBean id="u" class="com.edaus.bean.Paciente"></jsp:useBean>
<jsp:setProperty property="*" name="u"/>

<%
int i = PacienteDao.updatePaciente(u);
response.sendRedirect("VerPacientes.jsp");
%>