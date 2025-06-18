package estoque.dao;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import estoque.connection.SingleConnection;
import estoque.model.Telefone;

public class DaoTelefoneEst implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Connection connection;
	
	public DaoTelefoneEst() {
		connection = SingleConnection.getConnection();
	}
	
	public int getMaxId() throws SQLException  {
		
		String sql = "SELECT SEQ_EST_TELEFONE.NEXTVAL FROM EST_TELEFONE";
		
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		
		ResultSet resultSet = preparedStatement.executeQuery();
		
		if(resultSet.next()) {
			return resultSet.getInt(1);
		}
		
		return 0;
		
	}
	
	public Telefone insertTelefone(Telefone telefone) throws SQLException {
		
		
		String sql = "INSERT INTO EST_TELEFONE " 
				+ "(TELEFONE_ID, TELEFONE_ID_USU, TELEFONE_TIPO, TELEFONE_NUMBER)"
				+ "VALUES (?,?,?,?)";
		
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		
		telefone.setIdTelefone(Long.parseLong(String.valueOf(getMaxId())));
		
		preparedStatement.setLong(1, telefone.getIdTelefone());
		preparedStatement.setLong(2, telefone.getIdUserTelefone());
		preparedStatement.setString(3, telefone.getTipoTelefone());
		preparedStatement.setString(4, telefone.getTelefoneUser());
		
		preparedStatement.executeUpdate();
		connection.commit();
		
		return telefone;
		
	}
	
	public Telefone updateTelefone(Telefone telefone) throws SQLException {
		String sql = "UPDATE EST_TELEFONE SET TELEFONE_TIPO = ?, TELEFONE_NUMBER = ? WHERE TELEFONE_ID = ?";
		
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		
		preparedStatement.setString(1, telefone.getTipoTelefone());
		preparedStatement.setString(2, telefone.getTelefoneUser());
		preparedStatement.setLong(3, telefone.getIdTelefone());
		
		preparedStatement.executeUpdate();
		
		connection.commit();
		
		return telefone;
	}
	
	public List<Telefone> listaTelefones(String idUserTeledone) throws SQLException{
		
		List<Telefone> listaTelefones = new ArrayList<Telefone>();
		
		String sql = "SELECT * FROM EST_TELEFONE WHERE TELEFONE_ID_USU = ?";
		
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		
		preparedStatement.setString(1, idUserTeledone);

		ResultSet resultSet = preparedStatement.executeQuery();
		
		while(resultSet.next()) {
			Telefone telefone = new Telefone();
			telefone.setIdTelefone(resultSet.getLong("TELEFONE_ID"));
			telefone.setIdUserTelefone(resultSet.getLong("TELEFONE_ID_USU"));
			telefone.setTipoTelefone(resultSet.getString("TELEFONE_TIPO"));
			telefone.setTelefoneUser(resultSet.getString("TELEFONE_NUMBER"));
			
			listaTelefones.add(telefone);
		};
		
		return listaTelefones;
		
	}
	
	public Telefone verTelefone (String idTelfone ) throws SQLException {
		String sql = "SELECT * FROM EST_TELEFONE WHERE TELEFONE_ID = ?";
        
	  PreparedStatement preparedStatement  = connection.prepareStatement(sql);
	  
	  preparedStatement.setLong(1, Long.parseLong(idTelfone));
	  
	  ResultSet resultSet = preparedStatement.executeQuery();
	  
	  resultSet.next();

	  Telefone telefone = new Telefone();
	  telefone.setIdTelefone(resultSet.getLong("TELEFONE_ID"));
	  telefone.setIdUserTelefone(resultSet.getLong("TELEFONE_ID_USU"));
	  telefone.setTipoTelefone(resultSet.getString("TELEFONE_TIPO"));
	  telefone.setTelefoneUser(resultSet.getString("TELEFONE_NUMBER"));
	  
	  return telefone;
	}
	
	public void excluirTelefone(String  idTelfone ) throws SQLException {
		
		String sql = "DELETE FROM EST_TELEFONE WHERE TELEFONE_ID = ? ";
		
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		
		preparedStatement.setString(1, idTelfone );
		
		preparedStatement.executeUpdate();
		
		connection.commit();
	}
	
	

}
