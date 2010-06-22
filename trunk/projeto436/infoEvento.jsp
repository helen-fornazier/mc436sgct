<%@ page import="Control.Sistema" %>

	<% Sistema sistema = (Sistema)request.getSession().getAttribute("sistema");
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
          <span style="font-size: 12pt">
          O grande evento de uma conferencia tecnologica chama atencao mundial, por isso contaremos com cobertura das seguintes emissoras.
          <br>
          <br>
          <img src="./images/emissoras.jpg" width=100% alt="Cobertura"/>
          <br>
          <br>
          Alem disso, teremos os melhores quartos que se pode imaginar.
          <br>
          <br>
          <img src="./images/motel.jpg" alt="Quarto"/>
          <br>
          <br>
          Ainda teremos a sua disposicao um servico de acompanhantes de primeira, prontas para lhe ajudar em TUDO o que for necessario.
          <br>
          <br>
          <img src="./images/compania.jpg" alt="Acompanhantes"/>
          <br>
          <br>
          Ainda teremos um serviço de massagem personalizado, para ajudar a propiciar momentos de epifania.
          <br>
          <br>
          <img src="./images/massage.jpg" width=100% alt="Massagem"/>
          <br>
          <br>
          Lembramos ainda que o evento sera realizado nas mais belas praias do pais!
          <br>
          <br>
          <img src="./images/praia.jpg" width=100% alt="Acompanhantes"/>
          <br>
          <br>
          Então o que voce está esperando?  Venha logo! Ou voce pode continuar naquele velho esquema das antigas conferencias tecnologicas!
          <br>
          <br>
          <img src="./images/pibic.jpg" width=100% alt="Pibic"/>
          </span>
    	
    	</center>

<jsp:include page="barraLateral.jsp"></jsp:include>
<jsp:include page="rodape.jsp"></jsp:include>