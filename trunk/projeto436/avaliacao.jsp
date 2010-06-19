<jsp:include page="logo.jsp"></jsp:include>
<jsp:include page="barraHorizontalAvaliador.jsp"></jsp:include>
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
int lista = Integer.parseInt(request.getParameter("avaliado"));
int index = Integer.parseInt(request.getParameter("artigo"));
ArrayList<Material> listaMateriais;
sistema.cAvaliacao.setMaterialAvaliar(index);
sistema.cAvaliacao.setUsarLista(lista);

if(lista == 0){
	listaMateriais = sistema.cAvaliacao.getListaMateriaisAvaliar();
}else{
	listaMateriais = sistema.cAvaliacao.getListaMateriaisAvaliados();
}
	
Material material = listaMateriais.get(index);
%>
<tr>
<td>Titulo do artigo:</td>
<td><%=material.getTitulo() %></td>
<td></td>
<td></td>
<td></td>
</tr>

<tr>
<td>Resumo do artigo:</td>
<td><%=material.getResumo() %></td>
<td></td>
<td></td>
<td></td>
</tr>

<tr>
<td>Download do artigo</td>
<td><a href="<%=material.getPwdArquivo()%>" name="Artigo">Artigo para download</a></td>
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
<%
int i = material.getAvaliadores().indexOf(new Integer(sistema.cAvaliacao.getIdAvaliadorLogado()));
%>
<td><textarea name="comentarios" rows="10" cols="50"><%=material.getComentarios().get(i)%></textarea></td>
<td></td>
<td></td>
<td></td>
<td></td>
</tr>
</table>


<table>
<tr>
<td>Notas</td>

<td>0<input type="radio" name="nota" value="0" <%if(material.getNotas().get(i) == 0){%>checked="checked"<%}%> ></td>
<td>1<input type="radio" name="nota" value="1" <%if(material.getNotas().get(i) == 1){%>checked="checked"<%}%> ></td>
<td>2<input type="radio" name="nota" value="2" <%if(material.getNotas().get(i) == 2){%>checked="checked"<%}%> ></td>
<td>3<input type="radio" name="nota" value="3" <%if(material.getNotas().get(i) == 3){%>checked="checked"<%}%> ></td>
<td>4<input type="radio" name="nota" value="4" <%if(material.getNotas().get(i) == 4){%>checked="checked"<%}%> ></td>
<td>5<input type="radio" name="nota" value="5" <%if(material.getNotas().get(i) == 5){%>checked="checked"<%}%> ></td></tr>
</table>


<input type="submit" name="submitAval" value="Enviar">


</form>

<jsp:include page="barraLateral.jsp"></jsp:include>
<jsp:include page="rodape.jsp"></jsp:include>