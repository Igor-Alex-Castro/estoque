package service;

import java.util.List;

import DTOs.FormTelefoneUserDTO;
import estoque.dao.DaoTelefoneEst;
import estoque.dao.DaoUsuarioEst;
import estoque.model.Telefone;
import estoque.model.Usuario;

public class TelefoneService {

	private DaoUsuarioEst daoUsuarioEst = new DaoUsuarioEst();
	private DaoTelefoneEst daoTelefoneEst = new DaoTelefoneEst();

	

	public FormTelefoneUserDTO verTelefone( String idUserTelefone, String idTelfone) throws Exception {

		
		Usuario usuario = null;
		List<Telefone> telefones = null;
		Telefone telefone = null;
		
		
			
			usuario = daoUsuarioEst.verUsuario(idUserTelefone);
			telefones = daoTelefoneEst.listaTelefones(idUserTelefone);
			telefone = daoTelefoneEst.verTelefone(idTelfone);
			
			return new FormTelefoneUserDTO(null, usuario, telefone, telefones);

	
	
		

	}
	
	public FormTelefoneUserDTO excluirTelefone(String idUserTelefone, String idTelfone) throws Exception {
		
		Usuario usuario = null;
		List<Telefone> telefones = null;
		Telefone telefone = null;
		
		
			
			usuario = daoUsuarioEst.verUsuario(idUserTelefone);
			telefones = daoTelefoneEst.listaTelefones(idUserTelefone);
			telefone = daoTelefoneEst.verTelefone(idTelfone);
			daoTelefoneEst.excluirTelefone(idTelfone);
			
			return new FormTelefoneUserDTO("Telefone deletado", usuario, telefone, telefones);

	
		
	
	
	}
	
	
	public FormTelefoneUserDTO listaInicial( String idUserTelefone, String idTelfone) throws Exception {
		
		Usuario usuario = daoUsuarioEst.verUsuario(idUserTelefone);
		List<Telefone> telefones = daoTelefoneEst.listaTelefones(idUserTelefone);
			
		return new FormTelefoneUserDTO(null, usuario, null, telefones);

	}

	public FormTelefoneUserDTO insertOrUpdateTelefone(String idTelfone, String idUserTelefone, String nomeUser , String tipo,  String numero ) throws Exception {


		
		Telefone telefone = new Telefone((idTelfone == "" || idTelfone == null) ? 0L : Long.parseLong(idTelfone),
				Long.parseLong(idUserTelefone), tipo, numero);
		
		if(idTelfone == null || idTelfone.isEmpty()) {
			
			telefone = daoTelefoneEst.insertTelefone(telefone);

		}else {
			telefone = daoTelefoneEst.updateTelefone(telefone);
		}
		
		 FormTelefoneUserDTO formTelefoneUserDTO = listaInicial(  idUserTelefone,  idTelfone);

		return new FormTelefoneUserDTO("Telefone cadastrado com sucesso", formTelefoneUserDTO.getUsuario(),
				telefone, formTelefoneUserDTO.getTelefones());
	}

}
