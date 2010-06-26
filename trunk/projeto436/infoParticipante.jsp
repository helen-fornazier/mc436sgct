<%@ page import="Control.Sistema" %>
<% 
//Verifica se é é um participante que entrou nesta página
		Sistema sistema = (Sistema)request.getSession().getAttribute("sistema");
		if ( sistema == null || sistema.cLogin.getTipoUsuarioLogado().compareTo("participante") != 0){
			RequestDispatcher rdIndex = request.getRequestDispatcher("acessoNaoPermitido.jsp");
			rdIndex.forward(request, response);
			return;
		}
%>
<jsp:include page="logo.jsp"></jsp:include>
<jsp:include page="barraHorizontalParticipante.jsp"></jsp:include>
		<center>
		     
      <!--TEXTO DA PAGINA-->       
          <span style="font-size: 8,5pt">O Sistema de Gerenciamento de Conferencias Tecnologicas (SGCT) proposto e
			uma colecao de sistemas e utilitirios usados para anunciar, preparar e apoiar
			uma conferencia tecnologica.

		
		<p>&nbsp;</p>

		Esta e sua pagina de informacoes, aqui serao exibidas as informacoes particulares de cada PARTICIPANTE!

    	</span>
    	
    	</center>
    	
<jsp:include page="barraLateral.jsp"></jsp:include>
<jsp:include page="rodape.jsp"></jsp:include>