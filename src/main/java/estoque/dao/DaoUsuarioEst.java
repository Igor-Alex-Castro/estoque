package estoque.dao;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import estoque.connection.SingleConnection;
import estoque.model.Usuario;

public class DaoUsuarioEst implements Serializable {

	
	private static final long serialVersionUID = 1L;
	
	private Connection connection;
	
	
	public DaoUsuarioEst() {
		connection = SingleConnection.getConnection();
	}
	
	
	public int getMaxId() throws SQLException {
		String sql  = "SELECT SEQ_EST_USUARIO.NEXTVAL FROM EST_USUARIO ";
		
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		
		ResultSet resultSet = preparedStatement.executeQuery();
		if(resultSet.next()) {
			return (int) resultSet.getInt(1);
		}
		
		return 0;
	}
	
	public Usuario insertUsuarioEst(Usuario usuario) throws Exception {
		String sql = "INSERT INTO EST_USUARIO "
				+ "(USU_ID, USU_NOME, USU_LOGIN, USU_SENHA, USU_EMAIL,USU_CEP, "
				+ "USU_LOGRADOURO, USU_BAIRRO, USU_LOCALIDADE, USU_UF, "
				+ "USU_NUMERO, USU_STATUS, USU_GENERO) "
				+ "VALUES ( ?,?,?,?,?,?,?,?,?,?,?,?, ?)";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		
		
		
			usuario.setUsuarioId(Long.parseLong(String.valueOf(getMaxId())));
			
			preparedStatement.setLong(1, usuario.getUsuarioId());
			preparedStatement.setString(2, usuario.getUsuarioNome());
			preparedStatement.setString(3, usuario.getUsuarioLogin());
			preparedStatement.setString(4, usuario.getUsuarioSenha());
			preparedStatement.setString(5, usuario.getUsuarioEmail());
			preparedStatement.setString(6, usuario.getCep());
			preparedStatement.setString(7, usuario.getLogradouro());
			preparedStatement.setString(8, usuario.getBairro());
			preparedStatement.setString(9, usuario.getLocalidade());
			preparedStatement.setString(10, usuario.getUf());
			preparedStatement.setString(11, usuario.getNumero());
			preparedStatement.setString(12, "1");
			preparedStatement.setString(13, usuario.getGenero());
		
		
		
		preparedStatement.executeUpdate();
		connection.commit();
		
		return usuario;
	}
	
	public Usuario updateUsuario(Usuario usuario) throws SQLException {
		String sql = "UPDATE EST_USUARIO SET USU_NOME = ?, USU_LOGIN = ?, USU_SENHA = ?, USU_EMAIL = ?, USU_CEP = ?, USU_LOGRADOURO = ?, USU_BAIRRO = ?, USU_LOCALIDADE = ?, USU_UF = ?, USU_NUMERO = ?, USU_STATUS = ?, USU_GENERO = ? WHERE USU_ID = ?";
		
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		
		
		preparedStatement.setString(1, usuario.getUsuarioNome());
		preparedStatement.setString(2, usuario.getUsuarioLogin());
		preparedStatement.setString(3, usuario.getUsuarioSenha());
		preparedStatement.setString(4, usuario.getUsuarioEmail());
		preparedStatement.setString(5, usuario.getCep());
		preparedStatement.setString(6, usuario.getLogradouro());
		preparedStatement.setString(7, usuario.getBairro());
		preparedStatement.setString(8, usuario.getLocalidade());
		preparedStatement.setString(9, usuario.getUf());
		preparedStatement.setString(10, usuario.getNumero());
		preparedStatement.setString(11, "1");
		preparedStatement.setString(12, usuario.getGenero());
		preparedStatement.setLong(13, usuario.getUsuarioId());
		
		preparedStatement.executeUpdate();
		connection.commit();
		
		return usuario;
	
		
	}
	
	public Usuario verUsuario(String usuarioId) throws Exception {
		String sql = "SELECT * FROM EST_USUARIO WHERE USU_ID = ?";
		
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		
		preparedStatement.setLong(1, Long.parseLong(usuarioId));
		
		ResultSet resultSet =  preparedStatement.executeQuery();
		
		resultSet.next();
		
		
		
		Usuario usuario = new Usuario();
	
		usuario.setUsuarioId(resultSet.getLong("USU_ID"));
		usuario.setUsuarioNome(resultSet.getString("USU_NOME"));
		usuario.setUsuarioEmail(resultSet.getString("USU_EMAIL"));
		usuario.setUsuarioLogin(resultSet.getString("USU_LOGIN"));
		usuario.setUsuarioSenha(resultSet.getString("USU_SENHA"));
		usuario.setCep(resultSet.getString("USU_CEP"));
		usuario.setLogradouro(resultSet.getString("USU_LOGRADOURO"));
		usuario.setBairro(resultSet.getString("USU_BAIRRO"));
		usuario.setUf(resultSet.getString("USU_UF"));
		usuario.setNumero(resultSet.getString("USU_NUMERO"));
		usuario.setUsuarioStatus(resultSet.getString("USU_STATUS"));
		usuario.setLocalidade(resultSet.getString("USU_LOCALIDADE"));
		usuario.setGenero(resultSet.getString("USU_GENERO"));
		
		return usuario;
		
	}
	public List<Usuario>  listUsuario() throws SQLException{
		List<Usuario> listUsuario = new ArrayList<Usuario>();
		
		String sql = "SELECT * FROM EST_USUARIO";
		
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		
		ResultSet resultSet =  preparedStatement.executeQuery(sql);
		
		
		
		
		
		while(resultSet.next()) {
			Usuario usuario = new Usuario();
			usuario.setUsuarioId(resultSet.getLong("USU_ID"));
			usuario.setUsuarioNome(resultSet.getString("USU_NOME"));
			usuario.setCep(resultSet.getString("USU_CEP"));
			
			listUsuario.add(usuario);
		}
		
		return listUsuario;
		
	}
	
	public void excluirUsuario(String id) throws SQLException {
		String sql = "DELETE FROM EST_USUARIO WHERE USU_ID = ?";
		
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		
		preparedStatement.setString(1, id);
		
		preparedStatement.executeUpdate();
		
		connection.commit();
	}
	
	
	
	
}
