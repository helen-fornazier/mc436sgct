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
<form action="SubmissaoServlet" method="get">

<!-- Um titulo centralizado na pagina-->
  <p align="center"><font size="5"><b>Submissao de artigo</b></font></p>

<table>
<tr>
<td>Nome dos autores:</td>
<td><input type="text" name="autores" size="50"></td>
</tr>

<tr>
<td>Titulo artigo</td>
<td><input type="text" name="titulo" size="20"></td>
<td></td>
<td></td>
<td></td>
</tr>


<tr>
<td valign="top">Resumo:</td>
<td><textarea name="resumo" rows="10" cols="40"></textarea></td>
<td></td>
<td></td>
<td></td>
</tr>
</table>

<table>
<tr>
<td>Arquivo para upload:</td>
<td><input type="file" name="arquivo" size="50"></td>
<td></td>
<td></td>
<td></td>
</tr>
</table>


<p align="center">


<input type="submit" name="botaoSubmissao" value="Enviar">
<input type="reset" name="botaoLimpar" value="Limpar"> </p>


</form>

<jsp:include page="barraLateral.jsp"></jsp:include>
<jsp:include page="rodape.jsp"></jsp:include>