<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<!DOCTYPE html>
<html lang="pt-BR">
<head>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<script src="https://code.jquery.com/jquery-3.7.1.min.js"
	integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo="
	crossorigin="anonymous"></script>
<title>Template Responsivo</title>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.0/css/all.min.css">
<style>
* {
	box-sizing: border-box;
	margin: 0;
	padding: 0;
}

body {
	font-family: Arial, sans-serif;
	background-color: #f0f2f5;
	min-height: 100vh;
}

/* Cabeçalho */
header {
	background-color: #007bff;
	color: white;
	padding: 15px 20px;
	display: flex;
	justify-content: space-between;
	align-items: center;
	position: fixed;
	top: 0;
	left: 0;
	width: 100%;
	z-index: 1000;
}

header h1 {
	font-size: 20px;
}

.header-right {
	display: flex;
	align-items: center;
	gap: 10px;
	position: relative;
}

/* Dropdown */
.dropdown {
	position: relative;
}

.dropdown-btn {
	background: white;
	color: #007bff;
	border: none;
	padding: 8px 12px;
	border-radius: 5px;
	cursor: pointer;
	font-weight: bold;
}

.dropdown-menu {
	display: none;
	position: absolute;
	right: 0;
	top: 120%;
	background-color: white;
	box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
	border-radius: 5px;
	overflow: hidden;
	z-index: 1000;
	min-width: 160px;
}

.dropdown-menu a {
	display: block;
	padding: 10px 15px;
	color: #333;
	text-decoration: none;
	border-bottom: 1px solid #eee;
}

.dropdown-menu a:last-child {
	border-bottom: none;
}

.dropdown-menu a:hover {
	background-color: #f1f1f1;
}

/* Mostrar menu ao ativar */
.dropdown.active .dropdown-menu {
	display: block;
}

.login-btn, .menu-toggle {
	background: white;
	color: #007bff;
	border: none;
	padding: 8px 16px;
	border-radius: 5px;
	cursor: pointer;
	margin-left: 10px;
}

.menu-toggle {
	display: none;
}

/* Sidebar */
.sidebar {
	position: fixed;
	top: 60px;
	left: 0;
	width: 200px;
	height: calc(100% - 60px);
	background-color: #ffffff;
	box-shadow: 2px 0 5px rgba(0, 0, 0, 0.1);
	padding-top: 20px;
	transition: transform 0.3s ease;
}

.sidebar ul {
	list-style: none;
}

.sidebar li {
	padding: 12px 20px;
	border-bottom: 1px solid #eee;
}

.sidebar li:hover {
	background-color: #f0f2f5;
	cursor: pointer;
}

/* Conteúdo principal */
.main-content {
	margin-left: 200px;
	margin-top: 60px;
	padding: 30px 20px 80px;
}

.form-container, .table-container {
	background: #fff;
	padding: 30px;
	border-radius: 10px;
	box-shadow: 0 4px 10px rgba(0, 0, 0, 0.1);
	margin-bottom: 30px;
}

.form-container h2 {
	margin-bottom: 20px;
	text-align: center;
	color: #333;
}

.form-container input {
	width: 100%;
	padding: 10px;
	margin: 8px 0;
	border: 1px solid #ccc;
	border-radius: 5px;
}

.form-container button {
	width: 100%;
	padding: 10px;
	margin-top: 12px;
	border: none;
	border-radius: 5px;
	background-color: #007bff;
	color: white;
	font-size: 16px;
	cursor: pointer;
	transition: background 0.3s ease;
}

.form-container button:hover {
	background-color: #0056b3;
}

.table-container {
	overflow-x: auto;
}

/* Grid de 2 colunas para o formulário */
.form-grid {
	display: grid;
	grid-template-columns: 1fr 1fr;
	gap: 15px;
}

.form-grid input {
	width: 100%;
}

.form-grid button {
	width: 100%;
}

.genero-group {
  display: flex;
  gap: 20px;
  align-items: center;
  padding: 10px;
  border: 1px solid #ccc; /* mesma borda dos inputs */
  border-radius: 5px;      /* mesmo arredondamento dos inputs */
  background-color: white; /* fundo igual ao input */
  margin: 8px 0;
}

.genero-group label {
  display: flex;
  align-items: center;
  gap: 5px;
  font-weight: normal;
}

.btn-group {
	grid-column: span 2;
	display: flex;
	justify-content: space-between;
	gap: 10px;
	flex-wrap: nowrap;
}

.btn-group button {
	flex: 1 1 0;
	padding: 10px;
	font-weight: bold;
	border: none;
	border-radius: 5px;
	cursor: pointer;
	color: white;
	display: flex;
	align-items: center;
	justify-content: center;
	gap: 8px;
	white-space: nowrap;
}

.btn-group button[type="submit"] {
	background-color: #007bff;
}

.btn-group button:nth-child(2) {
	background-color: #ffc107;
}

.btn-group button:nth-child(3) {
	background-color: #17a2b8;
}

.btn-group button:nth-child(4) {
	background-color: #dc3545;
}

.btn-group button:hover {
	opacity: 0.9;
}

.btn-excluir{

display: inline-block;
  background-color: #dc3545;
  color: white;
  padding: 8px 12px;
  border-radius: 5px;
  text-decoration: none;
  font-weight: bold;
  transition: background-color 0.3s ease;
	

}

/* Em telas pequenas, volta a uma coluna */
@media ( max-width : 600px) {
	.form-grid {
		grid-template-columns: 1fr;
	}
	.form-grid div {
		grid-column: span 1 !important;
	}
}

table {
	width: 100%;
	border-collapse: collapse;
	min-width: 600px;
}

thead {
	background-color: #007bff;
	color: white;
}

th, td {
	padding: 12px 15px;
	text-align: left;
	border-bottom: 1px solid #ddd;
}

tbody tr:hover {
	background-color: #f1f1f1;
}

.btn-visualizar {
  display: inline-block;
  background-color: #17a2b8;
  color: white;
  padding: 8px 12px;
  border-radius: 5px;
  text-decoration: none;
  font-weight: bold;
  transition: background-color 0.3s ease;
}

.btn-visualizar:hover {
  background-color: #138496;
}

.custom-alert {
	position: fixed;
	top: 70px;
	left: 50%;
	transform: translateX(-50%);
	background-color: #28a745;
	color: white;
	padding: 15px 30px;
	border-radius: 5px;
	font-weight: bold;
	display: none;
	z-index: 1001;
	box-shadow: 0 4px 10px rgba(0, 0, 0, 0.2);
}

/* Rodapé */
footer {
	background-color: #007bff;
	color: white;
	text-align: center;
	padding: 15px;
	position: fixed;
	bottom: 0;
	left: 200px;
	
	
	width: calc(100% - 200px);
}

.modal-mensagem {
display: none;
  position: fixed;
  top: 80px;
  left: 50%;
  transform: translateX(-50%);
  color: white;
  padding: 15px 25px;
  border-radius: 6px;
  font-weight: bold;
  z-index: 9999;
  box-shadow: 0 4px 12px rgba(0, 0, 0, 0.25);
 /* animation: fadeOut 5s forwards;*/
  display:none;
}

.modal-erro {
  background-color: #dc3545; /* vermelho */
}

.modal-submit {
  background-color: #007bff; /* verde */
}

.modal-editar {
  background-color: #17a2b8;
}

.modal-limpar {
	background-color: #ffc107;
}



@keyframes fadeOut {
  0% { opacity: 1; }
  80% { opacity: 1; }
  100% { opacity: 0; display: none; }
}
/* Responsivo */
@media ( max-width : 768px) {
	.sidebar {
		transform: translateX(-100%);
		width: 200px;
		position: fixed;
		z-index: 999;
	}
	.sidebar.active {
		transform: translateX(0);
	}
	.main-content {
		margin-left: 0;
	}
	footer {
		left: 0;
		width: 100%;
	}
	.menu-toggle {
		display: inline-block;
	}
}
</style>
</head>
<body>

	<!-- Cabeçalho -->
	<header>
		<h1>Meu Sistema</h1>
		<div class="header-right">
			<button class="menu-toggle" onclick="toggleSidebar()">☰</button>

			<div class="dropdown">
				<button onclick="toggleDropdown()" class="dropdown-btn">👤
					Usuário ▾</button>
				<div id="dropdown-menu" class="dropdown-menu">

					<a href="#"><i class="fas fa-cog"></i> Configurações</a> <a
						href="#"><i class="fas fa-sign-out-alt"></i> Logout</a>
				</div>
			</div>
		</div>
	</header>

	<!-- Menu lateral -->
	<nav class="sidebar" id="sidebar">
		<ul>
			<li>Início</li>
			<li>Cadastro</li>
			<li>Relatórios</li>
			<li>Usuários</li>
			<li>Configurações</li>
		</ul>
	</nav>
	<!--<c:if test="${msg != null || msg.isEmpty()  }">-->
		
	<!--</c:if>-->
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
					<button type="button" onclick="limpar(true)"><i class="fas fa-eraser"></i> Limpar</button>
					<button type="button" onclick="editar('${ usuario}')"><i class="fas fa-edit"></i>  Editar</button>
					<button type="button" onclick="excluir('${usuario.usuarioId}')"><i class="fas fa-times-circle"></i> Excluir</button>
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
				
				
				<tbody>
				<c:forEach var="user" items="${listUsaurio}">
					
					<tr>
						<td><c:out value="${user.usuarioId}"/></td>
						<td><c:out value="${user.usuarioNome}"/></td>
						<td><c:out value="${user.cep}"/></td>
						<td><a href="UsuarioServlets?acao=ver&id=${user.usuarioId}" class="btn-visualizar"><i class="fas fa-edit"></i> </a>
						<a href="UsuarioServlets?acao=ver&id=${user.usuarioId}" class="btn-excluir"><i class="fas fa-times-circle"></i></a></td>
						
					</tr>
				
				</c:forEach>
				</tbody>
			</table>
		</div>
	</div>

	<!-- Rodapé -->
	<footer> &copy; 2025 Meu Sistema. Todos os direitos
		reservados. </footer>

	<!-- JavaScript para o menu hamburguer -->
	
	<script>
		function toggleSidebar() {
			const sidebar = document.getElementById('sidebar');
			sidebar.classList.toggle('active');
		}

		function toggleDropdown() {
			const dropdown = document.querySelector('.dropdown');
			dropdown.classList.toggle('active');
		}

		// Fecha o menu dropdown ao clicar fora
		window.addEventListener('click', function(e) {
			const dropdown = document.querySelector('.dropdown');
			if (!dropdown.contains(e.target)) {
				dropdown.classList.remove('active');
			}
		});

		$(document)
				.ready(
						function() {

							//Quando o campo cep perde o foco.
							$("#cep")
									.blur(
											function() {

												//Nova variável "cep" somente com dígitos.
												var cep = $(this).val()
														.replace(/\D/g, '');

												//Verifica se campo cep possui valor informado.
												if (cep != "") {

													//Expressão regular para validar o CEP.
													var validacep = /^[0-9]{8}$/;

													//Valida o formato do CEP.
													if (validacep.test(cep)) {

														//Preenche os campos com "..." enquanto consulta webservice.

														//Consulta o webservice viacep.com.br/
														$
																.getJSON(
																		"https://viacep.com.br/ws/"
																				+ cep
																				+ "/json/?callback=?",
																		function(
																				dados) {

																			if (!("erro" in dados)) {
																				//Atualiza os campos com os valores da consulta.
																				$(
																						"#logradouro")
																						.val(
																								dados.logradouro);
																				$(
																						"#bairro")
																						.val(
																								dados.bairro);
																				$(
																						"#localidade")
																						.val(
																								dados.localidade);
																				$(
																						"#uf")
																						.val(
																								dados.uf);
																			} //end if.
																			else {
																				//CEP pesquisado não foi encontrado.
																				limpa_formulário_cep();
																				alert("CEP não encontrado.");
																			}
																		});
													} //end if.
													else {
														//cep é inválido.
														limpa_formulário_cep();
														alert("Formato de CEP inválido.");
													}
												} //end if.
												else {
													//cep sem valor, limpa formulário.
													limpa_formulário_cep();
												}
											});
						});
		
	
		
		
		
		  function editar() {
		    alert("🔧 Modo de edição ativado.");
		    var  url = "<%=request.getContextPath()%>" 
		    
		    const id = $("#id").val();
		    const nome = $("#nome").val();
		    const email = $("#email").val();
		    const cep = $("#cep").val();
		    const logradouro = $("#logradouro").val();
		    const bairro = $("#bairro").val();
		    const localidade = $("#localidade").val();
		    const uf = $("#uf").val();
		    const numero = $("#numero").val();
		    const login = $("#login").val();
		    const senha = $("#senha").val();
		    const genero = $('input[name="genero"]:checked').val();
		    
		    console.log(genero);
		    
		    $.ajax({
			    url: url + "/UsuarioServlets", // URL para onde enviar a requisição
			    type: 'POST', // Método da requisição (GET, POST, PUT, etc.)
			    data: {id, nome, email, cep, logradouro, bairro, localidade, uf, numero,  login, senha, genero},
			    dataType: 'json',
			success: function(data, textStatus, jqXHR) {
			        // Código a executar quando a requisição for bem-sucedida
			        // 'response' contém a resposta do servid
			        console.log(data.usuario);
			        
						$("#id").val(data.usuario.usuarioId);
					    $("#nome").val(data.usuario.usuarioNome);
					    $("#email").val(data.usuario.usuarioEmail);
					    $("#cep").val(data.usuario.cep);
					    $("#logradouro").val(data.usuario.logradouro);
					    $("#bairro").val(data.usuario.bairro);
					    $("#localidade").val(data.usuario.localidade);
					    $("#uf").val(data.usuario.uf);
					    $("#numero").val(data.usuario.numero);
					    $("#login").val(data.usuario.usuarioLogin);
					    $("#senha").val(data.usuario.usuarioSenha);
					    
					    console.log(data.usuario.genero === "masculino")
					    
					    if (data.usuario.genero === "masculino") {
					        $("input[name='genero'][value='masculino']").prop("checked", true);
					      } else {
					        $("input[name='genero'][value='feminino']").prop("checked", true);
					      }
						
			        
			        
			        $("#modalTexto").text(data.msg)
			        $("#modalMensagem").addClass("modal-editar").fadeIn();
			        
			        setTimeout(() => {
			        	$("#modalMensagem").fadeOut().removeClass("modal-editar");
					}, 5000);
			        
			    },
			    error: function(error) {
			        // Código a executar em caso de erro
			        // 'error' contém informações sobre o erro
			        console.log('Erro na requisição: ' + error);
			    }
			});
		  

				
		    
		     
		    
		  }
		  
		  function excluir(id) {
		
			var  url = "<%=request.getContextPath()%>" 

			$.ajax({
			    url: url + "/UsuarioServlets", // URL para onde enviar a requisição
			    type: 'GET', // Método da requisição (GET, POST, PUT, etc.)
			    data: {id: id, acao: "excluir"},
			    dataType: 'json',
			success: function(data, textStatus, jqXHR) {
			        // Código a executar quando a requisição for bem-sucedida
			        // 'response' contém a resposta do servid
			        console.log(data)
			        $("#modalTexto").text(data.msg)
			        $("#modalMensagem").addClass("modal-erro").fadeIn();
			        
			        setTimeout(() => {
			        	$("#modalMensagem").fadeOut().removeClass("modal-erro");
					}, 5000);
			        
			       	 
			        alert(data.msg);
			        limpar(false)
			        //$('#resultado').html(response); // Exibe a resposta numa div com id "resultado"
			    },
			    error: function(error) {
			        // Código a executar em caso de erro
			        // 'error' contém informações sobre o erro
			        console.log('Erro na requisição: ' + error);
			    }
			});
			
		}

		  function limpar(exibeModal) {
		   
		      
		      const form = document.getElementById("formUsuario");
		      const inputs = form.getElementsByTagName('input');;
		      
		      for (let i = 0; i <inputs.length; i++) {
		    	   // Ou qualquer ação que você queira realizar com cada input
		    	   inputs[i].value = '';
		   	 }
		      
		     $('input[name="genero"]:checked').prop("checked", false);
		    
		      
		      document.getElementById("modalTexto").textContent  = 'Formulário limpo com sucesso'
		      
		      
		    	  if(exibeModal) {
		      
		      const modal = document.getElementById("modalMensagem");
		      
		      
		      modal.classList.add("modal-limpar");
		      modal.style.display = "block",
		      
		        
		        setTimeout(() => {
		        	modal.style.display = "none";
		        	
		        	modal.classList.remove("modal-limpar");
		        	
				}, 5000);
		    }
		    
		  }
		  
		  $(document).ready(function () {
			$("#formUsuario").on("submit", function (e) {
				e.preventDefault();
				
				$.ajax({
					url: $(this).attr("action"),
					type: $(this).attr("method"),
					data: $(this).serialize(),
					dataType: "json",
					success: function (data) {
						
						$("#modalTexto").text(data.msg);
						$("#modalMensagem").addClass("modal-submit").fadeIn();
						
						$("#id").val(data.usuario.usuarioId);
					    $("#nome").val(data.usuario.usuarioNome);
					    $("#email").val(data.usuario.usuarioEmail);
					    $("#cep").val(data.usuario.cep);
					    $("#logradouro").val(data.usuario.logradouro);
					    $("#bairro").val(data.usuario.bairro);
					    $("#localidade").val(data.usuario.localidade);
					    $("#uf").val(data.usuario.uf);
					    $("#numero").val(data.usuario.numero);
					    $("#login").val(data.usuario.usuarioLogin);
					    $("#senha").val(data.usuario.usuarioSenha);
					    
						console.log(data);
						setTimeout(() => {
					          $("#modalMensagem").fadeOut().removeClass("modal-submit");
					        }, 5000);
						
					}
					
				})
			})
			  
		  })
		  
		  /*
		  window.addEventListener("DOMContentLoaded", () => {
			    const modal = document.getElementById("modalMensagem");
			    
			    const modalTexto = document.getElementById("modalTexto");
			   
			    
			    alert(msg)
			    
			    if (modal && modalTexto) {
		            modalTexto.textContent = "sss";
		            modal.classList.add("modal-submit");
		            //modal.style.display = "block";

		            setTimeout(() => {
		              modal.style.display = "none";
		            }, 5000);
			    }
			  });
		  */
		  
		
	</script>

</body>
</html>