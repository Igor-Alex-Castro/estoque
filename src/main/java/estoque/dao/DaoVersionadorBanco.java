package estoque.dao;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import estoque.connection.SingleConnection;

public class DaoVersionadorBanco implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private Connection connection;
	
	public DaoVersionadorBanco() {
		connection = SingleConnection.getConnection();	
	}
	
	public int getMaxId() throws SQLException {
		
		String sql = "SELECT SEQ_VERSIONMANETO_BANCO_ESTOQUE.NEXTVAL FROM VERSIONAMENTO_BANCO_ESTOQUE";
		
		PreparedStatement statement = connection.prepareStatement(sql);
		
		ResultSet resultSet = statement.executeQuery();
		if(resultSet.next()) {
			
			return (int) resultSet.getInt(1);
		}
		
		return 0;
	}
	
	public void gravaArquivoSqlRodado(String nomeFile) throws SQLException {
		
		String sql = "INSERT INTO VERSIONAMENTO_BANCO_ESTOQUE (ID, ARQUIVO_SQL) VALUES (?, ?)";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		
		int maxId = getMaxId();
		
		System.out.println(maxId);
		
		preparedStatement.setInt(1, maxId);
		preparedStatement.setString(2, nomeFile);
		
		preparedStatement.execute();
		
	}
	
	
	public boolean arquivoSqlRodado(String nomeArquivo) throws SQLException {
		String sql = "SELECT COUNT( ARQUIVO_SQL) AS RODADO FROM VERSIONAMENTO_BANCO_ESTOQUE WHERE ARQUIVO_SQL = ?";
		
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		
		preparedStatement.setString(1, nomeArquivo);
		
		ResultSet resultSet = preparedStatement.executeQuery();
		
		int quant = 0;
		
		if(resultSet.next()) {
			quant = resultSet.getInt("RODADO");
		}
		
		if(quant > 0) {
			return true;
		}else {
			return false;
		}
		
	}

}
