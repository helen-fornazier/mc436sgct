
<%@ page import="Control.Sistema" %>
<% 
//Verifica se � � um avaliador que entrou nesta p�gina
		Sistema sistema = (Sistema)request.getSession().getAttribute("sistema");
		if ( sistema == null || sistema.cLogin.getTipoUsuarioLogado().compareTo("avaliador") != 0){
			RequestDispatcher rdIndex = request.getRequestDispatcher("PaginaInicial");
			rdIndex.forward(request, response);
			return;
		}
%>
<jsp:include page="logo.jsp"></jsp:include>
<jsp:include page="barraHorizontalAvaliador.jsp"></jsp:include>
		<center>
		     
      <!--TEXTO DA PAGINA-->       
          <span style="font-size: 8,5pt">O Sistema de Gerenciamento de Conferencias Tecnologicas (SGCT) proposto e
			uma colecao de sistemas e utilitirios usados para anunciar, preparar e apoiar
			uma conferencia tecnologica.
   		  </span>
		
		<p>&nbsp;</p>
		<p>&nbsp;</p>
		AVALIADORRRRRRRRRRRRRRRRRR
		<p>&nbsp;</p>
		<p>&nbsp;</p>
		
          <span style="font-size: 8,5pt">Para realizar a inscricao na <b>Conferencia MC436 2010</b>, acesse sua
          <a href="areaReservada.jsp">Area reservada</a>
          </span>
    	
    	</center>
    	
<jsp:include page="barraLateral.jsp"></jsp:include>
<jsp:include page="rodape.jsp"></jsp:include>