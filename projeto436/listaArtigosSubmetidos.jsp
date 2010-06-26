<%@ page import="DataBase.Material" %>
<%@ page import="Control.Sistema" %>
<% 
//Verifica se é é um autor que entrou nesta página
		Sistema sistema = (Sistema)request.getSession().getAttribute("sistema");
		if ( sistema == null || sistema.cLogin.getTipoUsuarioLogado().compareTo("autor") != 0){
			RequestDispatcher rdIndex = request.getRequestDispatcher("acessoNaoPermitido.jsp");
			rdIndex.forward(request, response);
			return;
		}
%>
<jsp:include page="logo.jsp"></jsp:include>
<jsp:include page="barraHorizontalAutor.jsp"></jsp:include>
<%@ page import="java.util.ArrayList" %>

		<%--Comentario em JSP --%>
		
		<%--Resgata a variavel de sessao 'arrayArtigos' passada pelo 'CarregaListaArtigos'--%>
		<%
		
		ArrayList<Material> materiaisSubmetidos = sistema.cSubmissao.getMateriaisSubmetidos();
		if (materiaisSubmetidos == null)
			materiaisSubmetidos = new ArrayList<Material>();
		%>
		
		<%--Imprime o valor da variavel 'arrayAvaliar'--%>
		<p align="center"><b><font size="5">Consultar o artigo</font></b></p>
		
		<% for(int i=0; i<materiaisSubmetidos.size(); i++){%>
			<a href="submissaoConsultar.jsp?artigo=<%=i%>">Artigo <%=i%>: <%=materiaisSubmetidos.get(i).getTitulo()%></a> <br> <br>
		<%} %>
<jsp:include page="barraLateral.jsp"></jsp:include>
<jsp:include page="rodape.jsp"></jsp:include>