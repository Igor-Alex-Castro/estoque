


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
			if(id  !== null && id !== ""){
		    $.ajax({
			    url:  "UsuarioServlets", // URL para onde enviar a requisição
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
			        
			        atualizaLista(data);
			        
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
		  }else{
			
				
				
				$("#modalTexto").text('Selecione um usuario')
						        $("#modalMensagem").addClass("modal-editar").fadeIn();
						        
						        
						        
						        setTimeout(() => {
						        	$("#modalMensagem").fadeOut().removeClass("modal-editar");
								}, 5000);
		  }

				
		    
		     
		    
		  }
		  
		  function atualizaLista(data){
			  $("#listaUsers").empty();
		        
		        for (let i = 0; i < data.usuarios.length; i++) {
		        	  
		        	$("#listaUsers").append("<tr>"+
							"<td>"+ data.usuarios[i].usuarioId +"</td>" +
							"<td>"+ data.usuarios[i].usuarioNome +"</td>" +
							"<td>" +data.usuarios[i].cep + "</td>" +
							"<td><a href='UsuarioServlets?acao=ver&id=" + data.usuarios[i].usuarioId +"' class='btn-visualizar'><i class='fas fa-edit'></i> </a>" +
							"<a href='javascript:excluir(" + data.usuarios[i].usuarioId + ")' class='btn-excluir'><i class='fas fa-times-circle'></i></a></td>" +
						"</tr>");
		        }
		        
		        alert(data.msg);
		  }
		  
		  function excluir(id) {
			console.log(id);
			const idInput = $("#id").val();
		
			if(idInput  !== null && idInput  !== ""){
			$.ajax({
			    url: "UsuarioServlets", // URL para onde enviar a requisição
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
			        
			        atualizaLista(data);
			        
			        limpar(false)
			        //$('#resultado').html(response); // Exibe a resposta numa div com id "resultado"
			    },
			    error: function(error) {
			        // Código a executar em caso de erro
			        // 'error' contém informações sobre o erro
			        console.log('Erro na requisição: ' + error);
			    }
			});
			}else{
				
				$("#modalTexto").text("Selecione um usuario")
						        $("#modalMensagem").addClass("modal-erro").fadeIn();
						        
						       
						        
						        setTimeout(() => {
						        	$("#modalMensagem").fadeOut().removeClass("modal-erro");
								}, 5000);
						        
				
			}
			//window.location.reload();
			
			
			
		}
		
		
		function telefone(idUsuario, nome) {
			console.log(id);
			
			$.ajax({
						    url: "TelefoneServlets", // URL para onde enviar a requisição
						    type: 'GET', // Método da requisição (GET, POST, PUT, etc.)
						    data: {idUsuario, nome},
						    dataType: 'json',
						success: function(data, textStatus, jqXHR) {
						        // Código a executar quando a requisição for bem-sucedida
						        // 'response' contém a resposta do servid
								window.location.href = "http://localhost:8080/estoque/pages/telefone.jsp";
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
						
						
						atualizaLista(data);
						
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
		 
			  function ocultar(){
				concole.log('entrei');
			  }
		  