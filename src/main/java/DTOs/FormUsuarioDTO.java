package DTOs;

import java.util.ArrayList;
import java.util.List;

import estoque.model.Usuario;

public class FormUsuarioDTO {
		String msg;
		Usuario usuario;
		List<Usuario> usuarios = new ArrayList<Usuario>();

		public FormUsuarioDTO(String msg, Usuario usuario, List<Usuario>  usuarios) {
			this.msg = msg;
			this.usuario = usuario;
			this.usuarios = usuarios;
		}
	}


