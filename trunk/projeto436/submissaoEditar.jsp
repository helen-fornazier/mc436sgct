<%@ page import="DataBase.Material" %>
<%@ page import="Control.Sistema" %>
<%@ page import="java.util.ArrayList" %>
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
 <%
int index = Integer.parseInt(request.getParameter("artigo"));
sistema.cSubmissao.setArquivoEmEdicao(index);
ArrayList<Material> materiaisSubmetidos = sistema.cSubmissao.getMateriaisSubmetidos();
Material material = materiaisSubmetidos.get(index);
%>
<!-- Um titulo centralizado na pagina-->
  <p align="center"><b><font size="5">Informaçoes sobre o artigo:</font></b></p>

<table>
	<tr><td><b>Título:</b></td> <td><%= material.getTitulo() %></td></tr>
	<tr><td><b>Autores:</b></td> <td><%= material.getAutores() %></td></tr>
	<tr><td><b>Resumo:</b></td> <td><%= material.getResumo() %></td></tr>
	<tr><td><b>Arquivo:</b></td> <td><%= material.getPwdArquivo() %></td></tr>
	<% int k = 0; %>
	<% for(int i=0; i < material.getNotas().size(); i++ ) { %>
	<% if(material.getNotas().get(i) != -1){ %>
		<% k++; %>
		<tr><td><b>Nota <%=k%>:</b></td> <td><%= material.getNotas().get(i)%></td></tr>
		<tr><td><b>Comentário <%=k%>:</b></td> <td><%= material.getComentarios().get(i) %></td></tr>
		<% } %>
	<% } %>
	<% if(k == 0){ %>
	<tr><td><b>Nota :</b></td> <td>O material ainda nao foi avaliado.</td></tr>
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
		<input type="submit" value="Submeter arquivo"> Esta opção irá substituir o arquivo submetido anteriormente.
	</div>
</form>

<jsp:include page="barraLateral.jsp"></jsp:include>
<jsp:include page="rodape.jsp"></jsp:include>