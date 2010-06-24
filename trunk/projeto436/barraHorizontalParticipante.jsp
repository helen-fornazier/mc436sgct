	<%@ page import="Control.Sistema" %>
	<!-- end #logo -->
	<div id="header">
		<div id="menu">
			<ul>
				<li><a href="PaginaInicial"><font size="1">Inicio</font></a></li>
				<li><a href="infoParticipante.jsp"><font size="1">Informaoes do Participante</font></a></li>
				<li><a href="infoEvento.jsp"><font size="1">Informaoes do Evento</font></a></li>
			</ul>
		</div>
		<!-- end #menu -->
		<div id="search">
			<div id="menu">
				<ul>
					<%
					Sistema sistema = (Sistema)request.getSession().getAttribute("sistema");
					%>
					<table>
					
					<td><font size="2">Bem vindo <%=sistema.cLogin.getUsuarioLogado().getNome()%>!</font></td>
					<td><li><a href="LogoutServlet">Logout</a></li></td>
					
					</table>
				</ul>
			</div>
		</div>
		<!-- end #search -->
	</div>
	<!-- end #header -->
</div>
<!-- end #header-wrapper -->
<div id="page">
	<div id="content">