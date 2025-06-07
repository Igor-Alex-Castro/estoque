package estoque.connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class SingleConnection {

	
	private static String url = "jdbc:oracle:thin:@localhost:1521:XE";
	private static Connection connection = null;
	
	static {
		conectar();
	}
	
	public SingleConnection() {
		conectar();
	}
	
	public static Connection getConnection() {
		return connection;
	}
	
	private static void conectar() {
		try {
			if(connection == null) {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				connection = DriverManager.getConnection(url, "system","admin123");
				connection.setAutoCommit(false);
			}
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
