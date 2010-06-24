	<%@ page import="Control.Sistema" %>
	<!-- end #logo -->
	<div id="header">
		<div id="menu">
			<ul>
				<li><a href="PaginaInicial"><font size="1">Inicio</font></a></li>
				<li><a href="infoEvento.jsp"><font size="1">Informacoes</font></a></li>
				<li><a href="submissao.jsp"><font size="1">Submissao</font></a></li>
				<li><a href="listaArtigosSubmetidos.jsp"><font size="1">Consultar</font></a></li>
				<li><a href="listaArtigosSubmetidosEditar.jsp"><font size="1">Editar</font></a></li>
				<li><a href="listaArtigosSubmetidosExcluir.jsp"><font size="1">Excluir</font></a></li>
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