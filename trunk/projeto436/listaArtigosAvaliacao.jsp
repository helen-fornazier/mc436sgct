<jsp:include page="logo.jsp"></jsp:include>
<jsp:include page="barraHorizontalAutor.jsp"></jsp:include>
<%@ page import="DataBase.Material" %>
<%@ page import="Control.Sistema" %>
<% 
//Verifica se � � um autor que entrou nesta p�gina
		Sistema sistema = (Sistema)request.getSession().getAttribute("sistema");
		if ( sistema == null || sistema.cLogin.getTipoUsuarioLogado().compareTo("avaliador") != 0){
			RequestDispatcher rdIndex = request.getRequestDispatcher("acessoNaoPermitido.jsp");
			rdIndex.forward(request, response);
			return;
		}
 %>
 
<%@ page import="java.util.ArrayList" %>

		<%--Comentario em JSP --%>
		
		<%--Resgata a variavel de sessao 'arrayArtigos' passada pelo 'CarregaListaArtigos'--%>
		<%
		
		ArrayList<Material> materiaisAvaliar = sistema.cAvaliacao.getListaMateriaisAvaliar();
		if (materiaisAvaliar == null)
			materiaisAvaliar = new ArrayList<Material>();
		ArrayList<Material> materiaisAvaliados =  sistema.cAvaliacao.getListaMateriaisAvaliados();
		if (materiaisAvaliados == null)
			materiaisAvaliados = new ArrayList<Material>();
		%>
		
		<%--Imprime o valor da variavel 'arrayAvaliar'--%>
		Estes sao os artigos para a avaliacao: <br> <br>
		
		<% for(int i=0; i<materiaisAvaliar.size(); i++){%>
			<a href='avaliacao.jsp?artigo=<%=i%>'>Artigo <%=i%>: <%=materiaisAvaliar.get(i).getTitulo()%></a> <br> <br>
		<%} %>
		
		<br> <br>
		<br> <br>
		
		
				<%--Imprime o valor da variavel 'arrayAvaliar'--%>
		Estes sao os artigos que ja foram avaliados: <br> <br>
		
		<% for(int i=0; i<materiaisAvaliados.size(); i++){%>
			<a href='ConsultaArtigoAvaliado?artigo=<%=i%>'>Artigo <%=i%>: <%=materiaisAvaliados.get(i)%> </a><br> <br>
		<%} %>

<jsp:include page="barraLateral.jsp"></jsp:include>
<jsp:include page="rodape.jsp"></jsp:include>