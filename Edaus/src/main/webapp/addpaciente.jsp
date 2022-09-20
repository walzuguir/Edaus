<%@page import="com.edaus.dao.PacienteDao" %>
<jsp:useBean id="u" class="com.edaus.bean.Paciente"></jsp:useBean>
<jsp:setProperty property="*" name="u"/>

<%
	int i = PacienteDao.salvarPaciente(u);

	if(i > 0) {
		response.sendRedirect("addpaciente-success.jsp");
	}else{
		response.sendRedirect("addpaciente-error.jsp");
	}
%>