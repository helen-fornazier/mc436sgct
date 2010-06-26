<%@ page import="Control.Sistema" %>
	<% 
	Sistema sistema = (Sistema)request.getSession().getAttribute("sistema");
	if(sistema == null){%>
		<jsp:include page="logo.jsp"></jsp:include>
		<jsp:include page="barraHorizontal.jsp"></jsp:include>
	<% }else{ %>
		<% String tipoUsuario = sistema.cLogin.getTipoUsuarioLogado(); %>
		<% if(tipoUsuario.compareTo("participante") == 0){%>
			<jsp:include page="logo.jsp"></jsp:include>
			<jsp:include page="barraHorizontalParticipante.jsp"></jsp:include>
		<% } %>
		<% if(tipoUsuario.compareTo("autor") == 0){%>
			<jsp:include page="logo.jsp"></jsp:include>
			<jsp:include page="barraHorizontalAutor.jsp"></jsp:include>
		<% } %>
		<% if(tipoUsuario.compareTo("avaliador") == 0){%>
			<jsp:include page="logo.jsp"></jsp:include>
			<jsp:include page="barraHorizontalAvaliador.jsp"></jsp:include>
		<% } %>
		<% if(tipoUsuario.compareTo("") == 0){%>
			<jsp:include page="logo.jsp"></jsp:include>
			<jsp:include page="barraHorizontal.jsp"></jsp:include>
		<% } %>
	<% } %>

		<center>
		     
      <!--TEXTO DA PAGINA-->       
  		<p>&nbsp;</p>
 			<% if(sistema == null) { %>
          	<span style="font-size: 8,5pt">Acesso não permitido para usuario nao logado, voltar para sua
          	<% } else { %>
          	<span style="font-size: 8,5pt">Acesso nao permitido para o tipo de usuário <b><%=sistema.cLogin.getTipoUsuarioLogado()%></b>, voltar para sua	
          	<% } %> 
          <a href="PaginaInicial">Página Inicial</a>
          </span>
    	
    	</center>

<jsp:include page="barraLateral.jsp"></jsp:include>
<jsp:include page="rodape.jsp"></jsp:include>