package estoque.model;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Usuario {
	
	private Long usuarioId;
	private String usuarioNome;
	private String usuarioLogin;
	private String usuarioSenha;
	private String usuarioEmail;
	private String usuarioStatus;
	
	private Date usuarioDataCadastro;
	private Date usuarioDataUltAcesso;
	
	private String cep;

	private String logradouro;

	private String bairro;

	private String localidade;

	private String uf;

	private String numero;
	
	private String genero;
	
	private List<Telefone> telefones =  new ArrayList<Telefone>();
	
	
	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public Usuario() {
		
	}
	
	public Usuario(Long usuarioId, String usuarioNome, String usuarioLogin, String usuarioSenha, String usuarioEmail,
			String cep, String logradouro, String bairro, String localidade, String uf, String numero, String genero) {
		super();
		this.usuarioId = usuarioId;
		this.usuarioNome = usuarioNome;
		this.usuarioLogin = usuarioLogin;
		this.usuarioSenha = usuarioSenha;
		this.usuarioEmail = usuarioEmail;
		this.cep = cep;
		this.logradouro = logradouro;
		this.bairro = bairro;
		this.localidade = localidade;
		this.uf = uf;
		this.numero = numero;
		this.genero = genero;
	}


	public Usuario(Long usuarioId, String usuarioNome, String usuarioLogin, String usuarioSenha, String usuarioEmail,
			String usuarioStatus, Date usuarioDataCadastro, Date usuarioDataUltAcesso) {
		super();
		this.usuarioId = usuarioId;
		this.usuarioNome = usuarioNome;
		this.usuarioLogin = usuarioLogin;
		this.usuarioSenha = usuarioSenha;
		this.usuarioEmail = usuarioEmail;
		this.usuarioStatus = usuarioStatus;
		this.usuarioDataCadastro = usuarioDataCadastro;
		this.usuarioDataUltAcesso = usuarioDataUltAcesso;
	}
	

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getLocalidade() {
		return localidade;
	}

	public void setLocalidade(String localidade) {
		this.localidade = localidade;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	
	
	public Long getUsuarioId() {
		return usuarioId;
	}
	public void setUsuarioId(Long usuarioId) {
		this.usuarioId = usuarioId;
	}
	public String getUsuarioNome() {
		return usuarioNome;
	}
	public void setUsuarioNome(String usuarioNome) {
		this.usuarioNome = usuarioNome;
	}
	public String getUsuarioLogin() {
		return usuarioLogin;
	}
	public void setUsuarioLogin(String usuarioLogin) {
		this.usuarioLogin = usuarioLogin;
	}
	public String getUsuarioSenha() {
		return usuarioSenha;
	}
	public void setUsuarioSenha(String usuarioSenha) {
		this.usuarioSenha = usuarioSenha;
	}
	public String getUsuarioEmail() {
		return usuarioEmail;
	}
	public void setUsuarioEmail(String usuarioEmail) {
		this.usuarioEmail = usuarioEmail;
	}
	public String getUsuarioStatus() {
		return usuarioStatus;
	}
	public void setUsuarioStatus(String usuarioStatus) {
		this.usuarioStatus = usuarioStatus;
	}
	public Date getUsuarioDataCadastro() {
		return usuarioDataCadastro;
	}
	public void setUsuarioDataCadastro(Date usuarioDataCadastro) {
		this.usuarioDataCadastro = usuarioDataCadastro;
	}
	public Date getUsuarioDataUltAcesso() {
		return usuarioDataUltAcesso;
	}
	public void setUsuarioDataUltAcesso(Date usuarioDataUltAcesso) {
		this.usuarioDataUltAcesso = usuarioDataUltAcesso;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(usuarioId);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		return Objects.equals(usuarioId, other.usuarioId);
	}

	@Override
	public String toString() {
		return "Usuario [usuarioId=" + usuarioId + ", usuarioNome=" + usuarioNome + ", usuarioLogin=" + usuarioLogin
				+ ", usuarioSenha=" + usuarioSenha + ", usuarioEmail=" + usuarioEmail + ", usuarioStatus="
				+ usuarioStatus + ", usuarioDataCadastro=" + usuarioDataCadastro + ", usuarioDataUltAcesso="
				+ usuarioDataUltAcesso + ", cep=" + cep + ", logradouro=" + logradouro + ", bairro=" + bairro
				+ ", localidade=" + localidade + ", uf=" + uf + ", numero=" + numero + "]";
	}

	public List<Telefone> getTelefones() {
		return telefones;
	}

	public void setTelefones(List<Telefone> telefones) {
		this.telefones = telefones;
	}
	
	

	
}
