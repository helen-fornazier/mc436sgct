<jsp:include page="logo.jsp"></jsp:include>
<jsp:include page="barraHorizontalAutor.jsp"></jsp:include>
<%@ page import="Control.Sistema" %>
<%@ page import="DataBase.Material" %>
<%@ page import="java.util.ArrayList" %>

<% 
//Verifica se é é um autor que entrou nesta página
		Sistema sistema = (Sistema)request.getSession().getAttribute("sistema");
		if ( sistema == null || sistema.cLogin.getTipoUsuarioLogado().compareTo("avaliador") != 0){
			RequestDispatcher rdIndex = request.getRequestDispatcher("acessoNaoPermitido.jsp");
			rdIndex.forward(request, response);
			return;
		}
 %>
<!-- Tag de abertura do Form com metodo GET chamando o futuro Servlet AvaliacaoServlet -->
<form action="AvaliacaoServlet" method="GET">

<!-- Um titulo centralizado na pagina-->
  <p align="center"><b><font size="5">Avaliacao de Artigos</font></b></p>
  
<table>


<%
ArrayList<Material> materiaisAvaliar = sistema.cAvaliacao.getListaMateriaisAvaliar();
		if (materiaisAvaliar == null)
			materiaisAvaliar = new ArrayList<Material>();
int index = Integer.parseInt(request.getParameter("artigo"));
Material material = materiaisAvaliar.get(index);
%>

<tr>
<td>Titulo do artigo:</td>
<td><%=material.getTitulo() %></td>
<td></td>
<td></td>
<td></td>
</tr>

<tr>
<td>Download do artigo</td>
<td><a href="../pdfs/algoritmos-adianta-slides.pdf" name="Artigo">Artigo para download</a></td>
<td></td>
<td></td>
<td></td>
</tr>
</table>

<table>
<tr>
<td>Comentarios:</td>
<td></td>
<td></td>
<td></td>
</tr>

<tr>
<td><textarea name="comentarios" rows="10" cols="50"></textarea></td>
<td></td>
<td></td>
<td></td>
<td></td>
</tr>
</table>


<table>
<tr>
<td>Notas</td>

<td>0<input type="radio" name="nota" value="0"></td>
<td>1<input type="radio" name="nota" value="1"></td>
<td>2<input type="radio" name="nota" value="2"></td>
<td>3<input type="radio" name="nota" value="3"></td>
<td>4<input type="radio" name="nota" value="4"></td>
<td>5<input type="radio" name="nota" value="5"></td></tr>
</table>


<input type="submit" name="submitAval" value="Enviar">


</form>

<jsp:include page="barraLateral.jsp"></jsp:include>
<jsp:include page="rodape.jsp"></jsp:include>