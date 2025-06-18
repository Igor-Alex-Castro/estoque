package DTOs;

import java.util.ArrayList;
import java.util.List;

import estoque.model.Usuario;

public class FormDelUsuarioDTO {
		String msg;
		List<Usuario> usuarios = new ArrayList<Usuario>();

		public FormDelUsuarioDTO(String msg, List<Usuario>  usuarios) {
			this.msg = msg;
			this.usuarios = usuarios;
		}
	}


