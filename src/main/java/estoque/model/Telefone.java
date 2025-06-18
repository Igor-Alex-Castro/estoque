package estoque.model;

public class Telefone {
	
	private Long idTelefone;
	private Long idUserTelefone;
	private String tipoTelefone;
	private String telefoneUser;
	
	public Telefone() {
		
	}
	
	

	public Telefone(Long idTelefone, Long idUserTelefone, String tipoTelefone, String telefoneUser) {
		super();
		this.idTelefone = idTelefone;
		this.idUserTelefone = idUserTelefone;
		this.tipoTelefone = tipoTelefone;
		this.telefoneUser = telefoneUser;
	}



	public Long getIdTelefone() {
		return idTelefone;
	}

	public void setIdTelefone(Long idTelefone) {
		this.idTelefone = idTelefone;
	}

	public Long getIdUserTelefone() {
		return idUserTelefone;
	}

	public void setIdUserTelefone(Long idUserTelefone) {
		this.idUserTelefone = idUserTelefone;
	}

	public String getTipoTelefone() {
		return tipoTelefone;
	}

	public void setTipoTelefone(String tipoTelefone) {
		this.tipoTelefone = tipoTelefone;
	}

	public String getTelefoneUser() {
		return telefoneUser;
	}

	public void setTelefoneUser(String telefoneUser) {
		this.telefoneUser = telefoneUser;
	}
	
	
	
	
}
