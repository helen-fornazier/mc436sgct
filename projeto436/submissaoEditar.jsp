<%@ page import="DataBase.Material" %>
<%@ page import="Control.Sistema" %>
<%@ page import="java.util.ArrayList" %>
<% 
//Verifica se � � um autor que entrou nesta p�gina
		Sistema sistema = (Sistema)request.getSession().getAttribute("sistema");
		if ( sistema == null || sistema.cLogin.getTipoUsuarioLogado().compareTo("autor") != 0){
			RequestDispatcher rdIndex = request.getRequestDispatcher("PaginaInicial");
			rdIndex.forward(request, response);
			return;
		}
 %>
<jsp:include page="logo.jsp"></jsp:include>
<jsp:include page="barraHorizontalAutor.jsp"></jsp:include> 
 <%
int index = Integer.parseInt(request.getParameter("artigo"));
sistema.cSubmissao.setArquivoEmEdicao(index);
ArrayList<Material> materiaisSubmetidos = sistema.cSubmissao.getMateriaisSubmetidos();
Material material = materiaisSubmetidos.get(index);
%>
<!-- Um titulo centralizado na pagina-->
  <p align="center"><b><font size="5">Informa�oes sobre o artigo:</font></b></p>

<table>
	<tr><td><b>T�tulo:</b></td> <td><%= material.getTitulo() %></td></tr>
	<tr><td><b>Autores:</b></td> <td><%= material.getAutores() %></td></tr>
	<tr><td><b>Resumo:</b></td> <td><%= material.getResumo() %></td></tr>
	<tr><td><b>Arquivo:</b></td> <td><%= material.getPwdArquivo() %></td></tr>
	<%if(!(material.getNotas().size() == 1  && material.getNotas().get(0).compareTo(new Integer(-1)) == 0 )) { %>
		<tr><td><b>Notas:</b></td> <td><%= material.getNotas() %></td></tr>
		<% for(int i=0; i < material.getComentarios().size(); i++ ) {%>
			<tr><td><b>Coment�rios:</b></td> <td><%= material.getComentarios().get(i) %></td></tr>
		<% } %>
	<% } %>
	
</table>
<br> <br>
<br> <br>

<!-- Um titulo centralizado na pagina-->
  <p align="center"><b><font size="5">Editar o artigo:</font></b></p>
Para Editar o Arquivo, basta nos enviar seu novo arquivo:
<form action="AlterarArtigoServlet" method="GET">
	<div>
		<input type="file" name="arquivo" size="50">
		<br>
		<% request.getSession().setAttribute("materialASerAlterado", material); %>
		<input type="submit" value="Submeter arquivo"> Esta op��o ir� substituir o arquivo submetido anteriormente.
	</div>
</form>

<br> <br>
<br> <br>

<!-- Um titulo centralizado na pagina-->
  <p align="center"><b><font size="5">Excluir o artigo:</font></b></p>
<form action="ExcluirArtigoServlet" method="GET">
	<div>
		<% request.getSession().setAttribute("materialASerExcluido", material); %>
		<input type="submit" value="Excluir Artigo"> Esta op��o ir� excluir permanetemente o Artigo da confer�ncia.
	</div>
</form>

<jsp:include page="barraLateral.jsp"></jsp:include>
<jsp:include page="rodape.jsp"></jsp:include>