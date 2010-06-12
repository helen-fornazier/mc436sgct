<jsp:include page="logo.jsp"></jsp:include>
<jsp:include page="barraHorizontalAutor.jsp"></jsp:include>
  
<form action="SubmissaoServ" method="get">

<!-- Um titulo centralizado na pagina-->
  <p align="center"><font size="5"><b>Submissao de artigo</b></font></p>

<table>
<tr>
<td>Nome do autor 1:</td>
<td><input type="text" name="autor1" size="50"></td>
<tr>
</tr>
<td>Instituicao:</td>
<td><input type="text" name="inst1" size="20"></td>
<td></td>
</tr>

<tr>
<td>Nome do autor 2:</td>
<td><input type="text" name="autor2" size="50"></td>
<tr>
</tr>
<td>Instituicao:</td>
<td><input type="text" name="inst2" size="20"></td>
<td></td>
</tr>

<tr>
<td>Nome do autor 3:</td>
<td><input type="text" name="autor3" size="50"></td>
<tr>
</tr>
<td>Instituicao:</td>
<td><input type="text" name="inst3" size="20"></td>
<td></td>
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

<table width="433">
<tr>
<td width="129">Areas:</td>
<td width="170"><input type="checkbox" name="ES" value="ES">Engenharia de software</td>
<td width="38"><input type="checkbox" name="IA" value="IA">IA</td>
<td width="58"><input type="checkbox" name="Redes" value="Redes">Redes</td>
<td width="6"></td>
<td width="6"></td>
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