<%@ page import="Control.Sistema" %>
	
<!-- end #logo -->
<div id="header">
	<div id="menu">
		<ul>
			<li><a href="CarregaInicio">Inicio</a></li>
		</ul>
	</div>
	<!-- end #menu -->
	<div id="search">
		<%
		Sistema sistema = (Sistema)request.getSession().getAttribute("sistema"); 
		if (sistema == null || sistema.cLogin.getUsuarioLogado() == null) {
		%>
			<form action="LoginServlet" method="get">	
				<table>
					<tr>
						<td><font size="2">usuario</font></td>
						<td><input type="text" name="usuario" size="11"></td>
						<td><font size="2">senha</font></td>
						<td><input type="password" name="password" size="11"></td>
						<td><input type="submit" value="      Entrar      " name="botaoLogin"></td>
					</tr>
					<tr>	
						<td></td>
						<td></td>
						<td></td>
						<td></td>
						<td><a href="cadastro.jsp"<font color="white" size="2">     Cadastrar    </font></td></a>
					</tr>
				</table>
			</form>
		<%
		}
		else {
		%>
			<form action="LogoutServlet" method="get">	
				<table>
					<tr>
						<td><font size="2">logado como <%=sistema.cLogin.getUsuarioLogado().getLogin()%> </font></td>
						<td><input type="submit" value="      Sair      " name="botaoLogout"></td>
					</tr>
				</table>
			</form>
		<% } %>	
	</div>
	<!-- end #search -->
</div>
	<!-- end #header -->
</div>
<!-- end #header-wrapper -->
<div id="page">
	<div id="content">