<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<!DOCTYPE html>
<html lang="pt-BR">

<jsp:include page="../base/head.jsp"></jsp:include>

<body>

	<!-- Cabeçalho -->

	<jsp:include page="../base/header.jsp"></jsp:include>
	
	<jsp:include page="../base/nav.jsp"></jsp:include>
	
	<div id="modalMensagem" class="modal-mensagem">
		<p id="modalTexto"></p>
	</div>

<div class="main-content">
		<!-- Formulário Atualizado -->
		<div class="form-container">
			<h2>Telefone</h2>
			<form class="form-grid" id="formUsuario" action="TelefoneServlets"
				method="post">
								<input type="text" placeholder="ID telefone" value="${telefone.idTelefone }" name="idTelefone" id="idTelefone" readonly="readonly"> 
				<label>
					<input type="text" placeholder="ID usuario" value="${usuario.usuarioId }" name="idUsuario" id="idUsuario" readonly="readonly"> 
				</label>
				
				<input type="text" placeholder="Nome" name="nome" id="nome" value="${usuario.usuarioNome}" readonly="readonly" >
				<input type="text" placeholder="CPF" name="cpf" id="cpf" autocomplete="nome" value="" readonly="readonly"> 
				<input type="text" placeholder="Tipo" name="tipo" id="tipo" value="${telefone.tipoTelefone}" required > 
				<input type="text" placeholder="Numero" name="numero" id="numero" value="${telefone.telefoneUser }" required> 
				
				<div class="btn-group">
					<button type="submit"><i class="fas fa-paper-plane"> </i>Enviar</button>
					<button type="button" onclick="limpar(true)"><i class="fas fa-eraser"></i> Limpar</button>
					<button type="button" onclick="editar()"><i class="fas fa-edit"></i>  Editar</button>
					<button type="button" onclick="excluir('${telefone.idTelefone}', '${ usuario.usuarioId  }')"><i class="fas fa-times-circle"></i> Excluir</button>
			   </div>
				
			</form>
			</div>
			
			
			<div class="table-container">
			<table>
				<thead>
					<tr>
						<th>ID telefone</th>
						<th>ID usuario</th>
						<th>Tipo</th>
						<th>Numero</th>
						<th>Visualizar</th>
					</tr>
				</thead>

				<tbody id="listaUsers">
				<c:forEach var="tel" items="${telefones}">
					
					<tr>
				
		  							<td> <c:out value="${ tel.idTelefone}"/> </td> 
		  							<td> <c:out value="${ usuario.usuarioId}"/> </td>
									<td><c:out value="${ tel.tipoTelefone}"/> </td>
									<td><c:out value="${ tel.telefoneUser}"/> </td>
									<td><a href="TelefoneServlets?acao=ver&idTelefone=${tel.idTelefone}&idUsuario=${usuario.usuarioId}" class="btn-visualizar"><i class='fas fa-edit'></i> </a>
															<a href="javascript:excluir(${tel.idTelefone }, ${usuario.usuarioId })" class="btn-excluir"><i class='fas fa-times-circle'></i></a></td>
		  							
		  						
						
						
					</tr>
				
				</c:forEach>
				
				</tbody>
			</table>
			</div>
			</div>

	

	<jsp:include page="../base/footer.jsp"></jsp:include>

	<jsp:include page="../base/javascriptfiletelefone.jsp"></jsp:include>

</body>
</html>