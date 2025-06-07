package estoque.filter;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.Scanner;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;

import estoque.connection.SingleConnection;
import estoque.dao.DaoVersionadorBanco;


@WebFilter(urlPatterns = "/*")
public class FilterAltenticacao extends HttpFilter implements Filter {
       
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Connection connection;

    public FilterAltenticacao() {
        super();
    }

	
	public void destroy() {
		
		try {
			connection.close();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}


	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		chain.doFilter(request, response);
		
	}

	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
		connection = SingleConnection.getConnection();
		System.out.println("1");
		DaoVersionadorBanco daoVersionadorBanco = new DaoVersionadorBanco();
		
		String caminhoPastaSql = fConfig.getServletContext().getRealPath("versionamentoBancoSql") +File.separator;
		
		File[] fileSql = new File(caminhoPastaSql).listFiles();
		
		try {
			for (File file : fileSql) {
				boolean arquivoJavaRodado = daoVersionadorBanco.arquivoSqlRodado(file.getName());
				
				if(!arquivoJavaRodado) {
					FileInputStream entadaArquivo = new FileInputStream(file);
					
					Scanner lerArquivo = new Scanner(entadaArquivo, "UTF-8");
					
					StringBuilder sql = new StringBuilder();
					
					while(lerArquivo.hasNext()) {
						
						sql.append(lerArquivo.nextLine());
						sql.append("\n");
					}
					
					connection.prepareStatement(sql.toString()).execute();
					
					daoVersionadorBanco.gravaArquivoSqlRodado(file.getName());
					
					connection.commit();
					lerArquivo.close();
					System.out.println("2");
					
				}
				
			}
		}catch (Exception e) {
			try {
				connection.rollback();
			}catch (SQLException e1) {
				e1.printStackTrace();
			}
			
			e.printStackTrace();
		}
	}

}
