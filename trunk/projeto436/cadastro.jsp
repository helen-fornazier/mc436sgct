<jsp:include page="logo.jsp"></jsp:include>
<jsp:include page="barraHorizontalAutor.jsp"></jsp:include>
  
<form action="CadastroServlet" method="get">

	<!-- Um titulo centralizado na pagina-->
  	<p align="center"><font size="5"><b>Cadastro de Usuario</b></font></p>

	<%-- Verifica se os dados passados anteriormente estão corretos--%>
	<%
	String attributeError = (String)request.getSession().getAttribute("attributeError");
	
	if (attributeError != null) { 
		request.getSession().setAttribute("attributeError", null);
	%>
		<font size="1" color="red"><%=attributeError%></font> <br>	
	<%} %>
	
		  
	<font size="1">(Ítens obrigatórios marcados com *)</font>
	
	<table>
		<tr>
			<td>Nome*:</td>
			<td><input type="text" name="nomeUser" size="50"></td>
		</tr>
		<tr>
			<td>Idade*:</td>
			<td><input type="text" name="idade" size="10"></td>
		</tr>
		<tr>
			<td>Sexo*:</td>
			<td>
				<input type="radio" name="sexo" value="feminino"> Feminino<br>
				<input type="radio" name="sexo" value="masculino"> Masculino<br>
			</td>
		</tr>
		<tr>
			<td>CPF*:</td>
			<td><input type="text" name="cpf" size="20"></td>
		</tr>
		<tr>
			<td>Endereço:</td>
			<td><input type="text" name="endereco" size="50"></td>
		</tr>
		<tr>
			<td>Contato:</td>
			<td><input type="text" name="contato" size="50"></td>
		</tr>
	</table>
	
	<table>
		<tr>
			<td>Escolha seu tipo de usuário*:</td>
		</tr>
		<tr>
			<td>
				<input type="radio" name="tipo" value="participante"> Participante<br>
				<input type="radio" name="tipo" value="autor"> Autor<br>
				<input type="radio" name="tipo" value="avaliador"> Avaliador<br>
			</td>
		</tr>
	</table>
	
	<table>
		<tr>
			<td>Login*:</td>
			<td><input type="text" name="login" size="20"></td>
		</tr>
		<tr>
			<td>Senha*:</td>
			<td><input type="password" name="senha1" size="20"></td>
		</tr>
		<tr>
			<td>Digite a senha novamente*:</td>
			<td><input type="password" name="senha2" size="20"></td>
		</tr>
		
		<tr>
		</tr>
	</table>
	
	<table>
		<tr>
			<td>Mande o seu currículo se você for um Autor ou Avaliador*:</td>
		</tr>
		<tr>
			<td><input type="file" name="curriculo" size="50"></td>
		</tr>
		<tr>
			<td>Digite suas qualificações se você for um Avaliador:</td>
		</tr>
		<tr>
			<td><textarea name="qualificacoes" rows="25" cols="70"></textarea></td>
		</tr>
	</table>
	
	<p align="center">
	<input type="submit" name="botaoSubmissao" value="Enviar">
	<input type="reset" name="botaoLimpar" value="Limpar"> </p>
	
</form>

<jsp:include page="barraLateral.jsp"></jsp:include>
<jsp:include page="rodape.jsp"></jsp:include>