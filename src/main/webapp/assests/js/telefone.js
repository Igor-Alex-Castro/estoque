function limpar(exibeModal) {
								   
								      
								      
								      
									  const tipo = document.getElementById('tipo');
									  const numero = document.getElementById('numero');
									  const idTelefone = document.getElementById('idTelefone');
									  
									  tipo.value = '';
									  numero.value= '';
									  idTelefone.value='';
								    
								    
								      
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
		  
		 
function editar() {

			const idTelefone = $("#idTelefone").val();	
			const idUsuario = $("#idUsuario").val();				   
			const nome = $("#nome").val();
			const tipo = $("#tipo").val();
			const numero = $("#numero").val();
		    
		    console.log(idTelefone);
			if(idTelefone !== null && idTelefone !== ""){
		    $.ajax({
			    url:  "TelefoneServlets", // URL para onde enviar a requisição
			    type: 'POST', // Método da requisição (GET, POST, PUT, etc.)
			    data: {idTelefone, idUsuario , nome, tipo , numero},
			    dataType: 'json',
			success: function(data, textStatus, jqXHR) {
			        // Código a executar quando a requisição for bem-sucedida
			        // 'response' contém a resposta do servid
			        console.log(data);
			        
					$("#idTelefone").val(data.telefone.idTelefone);	
										 $("#idUsuario").val(data.usuario.usuarioId);				   
										 $("#nome").val(data.usuario.usuarioNome);
										 $("#tipo").val(data.telefone.tipoTelefone);
										 $("#numero").val(data.telefone.telefoneUser);
					    
					    
						
			        
			        
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
				$("#modalTexto").text('Selecione um telefone')
							        $("#modalMensagem").addClass("modal-editar").fadeIn();
							        
							        atualizaLista(data);
							        
							        setTimeout(() => {
							        	$("#modalMensagem").fadeOut().removeClass("modal-editar");
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
						
						
						
						
						
	
						 $("#modalTexto").text(data.msg)
						
						 $("#modalMensagem").addClass("modal-submit").fadeIn();
						 		    
						 $("#idTelefone").val(data.telefone.idTelefone);	
						 $("#idUsuario").val(data.usuario.usuarioId);				   
						 $("#nome").val(data.usuario.usuarioNome);
						 $("#tipo").val(data.telefone.tipoTelefone);
						 $("#numero").val(data.telefone.telefoneUser);
						 					  
						 					    	        
						setTimeout(() => {
						 		  $("#modalMensagem").fadeOut().removeClass("modal-editar");
						 }, 5000);
						 		        
						
						atualizaLista(data);
						
					}
					
				})
			})
			  
		  })
		  
		  
		  function atualizaLista(data){
		  			  $("#listaUsers").empty();
		  		        
		  		        for (let i = 0; i < data.telefones.length; i++) {
		  		        	  
		  		        	$("#listaUsers").append("<tr>"+
		  							"<td>"+ data.telefones[i].idTelefone +"</td>" +
		  							"<td>"+ data.telefones[i].idUserTelefone +"</td>" +
		  							"<td>" +data.telefones[i].telefoneUser + "</td>" +
									"<td>" +data.telefones[i].tipoTelefone + "</td>" +
									"<td><a href='TelefoneServlets?acao=ver&idTelefone=" + data.telefones[i].idTelefone + "&idUsuario=" + data.usuario.usuarioId + "'  + class='btn-visualizar'><i class='fas fa-edit'></i> </a>" +
									
									"<a href='javascript:excluir(" + data.telefones[i].idTelefone + "," + data.usuario.usuarioId + ")' class='btn-excluir'><i class='fas fa-times-circle'></i></a></td>"+
		  							
		  						"</tr>");
		  		        }
		  		        
		  		        alert(data.msg);
		  		  }
		 
		  
				  function excluir(idTelefone,  idUsuario) {
				  		
						if(idTelefone !== null && idTelefone !== ""){
					
				  			$.ajax({
				  			    url: "TelefoneServlets", // URL para onde enviar a requisição
				  			    type: 'GET', // Método da requisição (GET, POST, PUT, etc.)
				  			    data: {idTelefone, idUsuario, acao: "excluir"},
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
				  			    
				  			    },
				  			    error: function(error) {
				  			        
				  			        console.log('Erro na requisição: ' + error);
				  			    }
				  			});

											}else{
												
												
												$("#modalTexto").text('Selecione um usuário')
															  			        $("#modalMensagem").addClass("modal-erro").fadeIn();
															  			        
															  			        setTimeout(() => {
															  			        	$("#modalMensagem").fadeOut().removeClass("modal-erro");
															  					}, 5000);
															  			        
											}
							}
							
							
							