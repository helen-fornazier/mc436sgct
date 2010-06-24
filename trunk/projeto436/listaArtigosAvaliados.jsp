<%@ page import="DataBase.Material" %>
<%@ page import="Control.Sistema" %>
<% 
//Verifica se é é um avaliador que entrou nesta página
		Sistema sistema = (Sistema)request.getSession().getAttribute("sistema");
		if ( sistema == null || sistema.cLogin.getTipoUsuarioLogado().compareTo("avaliador") != 0){
			RequestDispatcher rdIndex = request.getRequestDispatcher("PaginaInicial");
			rdIndex.forward(request, response);
			return;
		}
 %>
 <jsp:include page="logo.jsp"></jsp:include>
<jsp:include page="barraHorizontalAvaliador.jsp"></jsp:include>

<%@ page import="java.util.ArrayList" %>

		<%--Comentario em JSP --%>
		
		<%--Resgata a variavel de sessao 'arrayArtigos' passada pelo 'CarregaListaArtigos'--%>
		<%
		sistema.cAvaliacao.getListaMateriaisAvaliador();
		ArrayList<Material> materiaisAvaliar = sistema.cAvaliacao.getListaMateriaisAvaliar();
		if (materiaisAvaliar == null)
			materiaisAvaliar = new ArrayList<Material>();
		ArrayList<Material> materiaisAvaliados =  sistema.cAvaliacao.getListaMateriaisAvaliados();
		if (materiaisAvaliados == null)
			materiaisAvaliados = new ArrayList<Material>();
		%>
				<%--Imprime o valor da variavel 'arrayAvaliar'--%>
		<p align="center"><b><font size="5">Alterar Avaliacao</font></b></p>
		
		<% for(int i=0; i<materiaisAvaliados.size(); i++){%>
			<a href="avaliacao.jsp?artigo=<%=i%>&avaliado=1">Artigo <%=i%>: <%=materiaisAvaliados.get(i).getTitulo()%> </a><br> <br>
		<%} %>

<jsp:include page="barraLateral.jsp"></jsp:include>
<jsp:include page="rodape.jsp"></jsp:include>