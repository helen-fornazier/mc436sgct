<jsp:include page="logo.jsp"></jsp:include>
<jsp:include page="barraHorizontalAutor.jsp"></jsp:include>

<%@ page import="java.util.ArrayList" %>

		<%--Comentario em JSP --%>
		
		<%--Resgata a variavel de sessao 'arrayArtigos' passada pelo 'CarregaListaArtigos'--%>
		<%
		ArrayList arrayAvaliar = new ArrayList();
		ArrayList arrayAvaliados = new ArrayList();
		
		arrayAvaliar = (ArrayList)request.getSession().getAttribute("arrayArtigosAvaliar");
		arrayAvaliados = (ArrayList)request.getSession().getAttribute("arrayArtigosAvaliados");
		%>
		
		<%--Imprime o valor da variavel 'arrayAvaliar'--%>
		Estes sao os artigos para a avaliacao: <br> <br>
		
		<% for(int i=0; i<arrayAvaliar.size(); i++){%>
			<a href='AvaliaArtigo?artigo=<%=i%>'>Artigo <%=i%>: <%=arrayAvaliar.get(i)%></a> <br> <br>
		<%} %>
		
		<br> <br>
		<br> <br>
		
		
				<%--Imprime o valor da variavel 'arrayAvaliar'--%>
		Estes sao os artigos que ja foram avaliados: <br> <br>
		
		<% for(int i=0; i<arrayAvaliados.size(); i++){%>
			<a href='ConsultaArtigoAvaliado?artigo=<%=i%>'>Artigo <%=i%>: <%=arrayAvaliados.get(i)%> </a><br> <br>
		<%} %>

<jsp:include page="barraLateral.jsp"></jsp:include>
<jsp:include page="rodape.jsp"></jsp:include>