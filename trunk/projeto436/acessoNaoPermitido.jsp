<%@ page import="Control.Sistema" %>
<jsp:include page="logo.jsp"></jsp:include>
<jsp:include page="barraHorizontalAutor.jsp"></jsp:include>

		<center>
		     
      <!--TEXTO DA PAGINA-->       
  		<p>&nbsp;</p>
			<% 
			Sistema sistema = (Sistema)request.getSession().getAttribute("sistema");
 			%>
          <span style="font-size: 8,5pt">Acesso não permitido para o seu tipo de usuário como <b><%=sistema.cLogin.getTipoUsuarioLogado()%></b>, voltar para sua 
          <a href="PaginaInicial">Página Inicial</a>
          </span>
    	
    	</center>

<jsp:include page="barraLateral.jsp"></jsp:include>
<jsp:include page="rodape.jsp"></jsp:include>