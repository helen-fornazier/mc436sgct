	<%@ page import="Control.Sistema" %>
	<!-- end #logo -->
	<div id="header">
		<div id="menu">
			<ul>
				<li><a href="CarregaInicio">Inicio</a></li>
				<li><a href="SubmissaoServ">Submissao</a></li>
				<li><a href="CarregaListaArtigos">Avaliar</a></li>
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
					
					<td><li><a href="EfetuaLogout">Logout</a></li></td>
					<td><font size="2">logado como <%=sistema.cLogin.getUsuarioLogado().getLogin()%> </font></td>
					
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