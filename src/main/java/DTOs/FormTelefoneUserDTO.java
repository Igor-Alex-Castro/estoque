package DTOs;

import java.util.ArrayList;
import java.util.List;

import estoque.model.Telefone;
import estoque.model.Usuario;

public class FormTelefoneUserDTO {
		String msg;
		Usuario usuario;
		Telefone telefone;
		List<Telefone> telefones = new ArrayList<Telefone>();

		public FormTelefoneUserDTO(String msg, Usuario usuario, Telefone telefone, List<Telefone>  telefones) {
			this.msg = msg;
			this.usuario = usuario;
			this.telefone = telefone;
			this.telefones = telefones;
		}

		public String getMsg() {
			return msg;
		}

		public void setMsg(String msg) {
			this.msg = msg;
		}

		public Usuario getUsuario() {
			return usuario;
		}

		public void setUsuario(Usuario usuario) {
			this.usuario = usuario;
		}

		public Telefone getTelefone() {
			return telefone;
		}

		public void setTelefone(Telefone telefone) {
			this.telefone = telefone;
		}

		public List<Telefone> getTelefones() {
			return telefones;
		}

		public void setTelefones(List<Telefone> telefones) {
			this.telefones = telefones;
		}
		
		
	}


