package estoque;

import java.sql.Connection;

import javax.servlet.ServletException;

import org.junit.Test;

import estoque.connection.SingleConnection;
import estoque.filter.FilterAltenticacao;

public class SingleConnectionTest {
	
	
	private Connection connection;
	private FilterAltenticacao filterAltenticacao;
	
	@Test
	public void singleConnectionTest() {
		connection = SingleConnection.getConnection();
	}
	
	@Test
	public void FilterAutenticacao() {
		try {
			filterAltenticacao.init();
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
