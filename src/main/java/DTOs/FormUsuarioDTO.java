package DTOs;

import estoque.model.Usuario;

public class FormUsuarioDTO {
		String msg;
		Usuario usuario;

		public FormUsuarioDTO(String msg, Usuario usuario) {
			this.msg = msg;
			this.usuario = usuario;
		}
	}


