<%@ page import="Control.Sistema" %>
<% 
//Verifica se é é um autor que entrou nesta página
		Sistema sistema = (Sistema)request.getSession().getAttribute("sistema");
		if ( sistema == null || sistema.cLogin.getTipoUsuarioLogado().compareTo("autor") != 0){
			RequestDispatcher rdIndex = request.getRequestDispatcher("PaginaInicial");
			rdIndex.forward(request, response);
			return;
		}
%>
<jsp:include page="logo.jsp"></jsp:include>
<jsp:include page="barraHorizontalAutor.jsp"></jsp:include>

		<center>
		     
      <!--TEXTO DA PAGINA-->       
          <span style="font-size: 8,5pt">O Sistema de Gerenciamento de Conferencias Tecnologicas (SGCT) proposto e
			uma colecao de sistemas e utilitirios usados para anunciar, preparar e apoiar
			uma conferencia tecnologica.
   		 
		<p>&nbsp;</p>
		
		Esta e sua pagina principal, aqui serao exividas noticias e informacoes referentes aos AUTORES!
    	
    	 </span>
    	
    	</center>
    	
<jsp:include page="barraLateral.jsp"></jsp:include>
<jsp:include page="rodape.jsp"></jsp:include>