<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<!DOCTYPE html>
<html lang="pt-BR">

<jsp:include page="../base/head.jsp"></jsp:include>

<body>

	<!-- Cabeçalho -->
	
	<jsp:include page="../base/header.jsp"></jsp:include>
	<!-- Menu lateral -->
	
	<jsp:include page="../base/nav.jsp"></jsp:include>
	
	<div id="modalMensagem" class="modal-mensagem">
		<p id="modalTexto"></p>
	</div>
	
	<!-- Conteúdo principal -->
	<div class="main-content">
		<!-- Formulário Atualizado -->
		<div class="form-container">
			<h2>Cadastro</h2>
			<form class="form-grid" id="formUsuario" action="UsuarioServlets"
				method="post">
				<input type="text" placeholder="ID" value="${usuario.usuarioId}" name="id" id="id" readonly="readonly"> 
				
				<input type="text" placeholder="Nome" name="nome" id="nome" value="${usuario.usuarioNome}" required>
				<input type="text" placeholder="CEP" name="cep" id="cep" autocomplete="nome" value="${usuario.cep}"> 
				<input type="text" placeholder="Logradouro" name="logradouro" id="logradouro"value="${ usuario.logradouro }"> 
				<input type="text" placeholder="Bairro" name="bairro" id="bairro" value="${usuario.bairro}"> 
				<input type="text" placeholder="Localidade" name="localidade" id="localidade" value="${usuario.localidade}">
				<input type="text" placeholder="UF" name="uf" id="uf" value="${usuario.uf}">
				<input type="text" placeholder="Numero" name="numero" id="numero" value="${usuario.numero}" > 
				<input type="email" placeholder="Email" name="email" id="email" value="${usuario.usuarioEmail}" > 
				<div class="genero-group">
				<label>
  					<input type="radio" name="genero"  value="masculino"
  					
  					${ usuario.genero == "masculino" ? 'checked' : ''} /> Masculino
				</label>
			<label>
  				<input type="radio" name="genero"   value="feminino" ${ usuario.genero == "feminino" ? 'checked' : ''} /> Feminino
			</label>
			</div>
				<input type="text" placeholder="Login" autocomplete="off" name="login" id="login" required value="${usuario.usuarioLogin }">
				<input type="password" placeholder="Senha" autocomplete="off" name="senha" id="senha" required="required" value="${usuario.usuarioSenha}">
				<div class="btn-group">
					<button type="submit"><i class="fas fa-paper-plane"> </i>Enviar</button>
					<button type="button" onclick="limpar()"><i class="fas fa-eraser"></i> Limpar</button>
					<button type="button" onclick="editar('${ usuario}')"><i class="fas fa-edit"></i>  Editar</button>
					<button type="button" onclick="excluir('${usuario.usuarioId}')"><i class="fas fa-times-circle"></i> Excluir</button>
					
					
					
					<a href="<%= request.getContextPath() %>/TelefoneServlets?idUsuario=${ usuario.usuarioId}&nome=${usuario.usuarioNome}"  class="btn-telefone-link" id="btn-telefone-link"><i class="fa fa-phone-square"></i> Telefone</a>
					
					</div>
				
			</form>
		
		</div>

		<!-- Tabela -->
		<div class="table-container">
			<table>
				<thead>
					<tr>
						<th>ID</th>
						<th>Nome</th>
						<th>CEP</th>
						<th>Visualizar</th>
					</tr>
				</thead>
				
				
				<tbody id="listaUsers">
				<c:forEach var="user" items="${listUsaurio}">
					
					<tr>
						<td><c:out value="${user.usuarioId}"/></td>
						<td><c:out value="${user.usuarioNome}"/></td>
						<td><c:out value="${user.cep}"/></td>
						<td><a href="UsuarioServlets?acao=ver&id=${user.usuarioId}" class="btn-visualizar"><i class="fas fa-edit"></i> </a>
						<a href="javascript:excluir(${ usuarios.usuarioId}" class="btn-excluir"><i class="fas fa-times-circle"></i></a>
					</tr>
				
				</c:forEach>
				</tbody>
			</table>
		</div>
	</div>

	<jsp:include page="../base/footer.jsp"></jsp:include>
	<jsp:include page="../base/javascriptfileusuario.jsp"></jsp:include>
	
	<script>
		
		
	</script>

</body>
</html>