package estoque.servlets;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import DTOs.FormDelUsuarioDTO;
import DTOs.FormUsuarioDTO;
import estoque.dao.DaoUsuarioEst;
import estoque.model.Usuario;


@WebServlet(urlPatterns= { "/UsuarioServlets", "/estoque/pages/UsuarioServlets", "/pages/UsuarioServlets"})
public class UsuarioServlets extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public UsuarioServlets() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			String acao = request.getParameter("acao");
			String id = request.getParameter("id");
			DaoUsuarioEst daoUsuarioEst = new DaoUsuarioEst();
			
			if(acao.equalsIgnoreCase("ver") && !acao.isEmpty() && acao != null) {
				
				Usuario usuario = daoUsuarioEst.verUsuario(id);
				request.setAttribute("usuario", usuario);
				
				List<Usuario> listUsaurio = daoUsuarioEst.listUsuario();
				request.setAttribute("listUsaurio", listUsaurio);
					
				RequestDispatcher requestDispatcher = request.getRequestDispatcher("/pages/usuario.jsp");
				requestDispatcher.forward(request, response);
			
			
			
			}else if(acao.equalsIgnoreCase("excluir") && !acao.isEmpty() && acao != null) {
				
				daoUsuarioEst.excluirUsuario(id);
				
				List<Usuario> listUsaurio = daoUsuarioEst.listUsuario();
				
				Gson gson = new Gson();
				
				
				
				
				Map<String, String> resposta = new HashMap<String, String>();
				
				FormDelUsuarioDTO formDelUsuarioDTO = new FormDelUsuarioDTO("Usuario deletado", daoUsuarioEst.listUsuario());
				
				response.setContentType("application/json");
				response.setCharacterEncoding("UTF-8");
				response.getWriter().write(gson.toJson(formDelUsuarioDTO));
				
			} else if(acao.equalsIgnoreCase("limpar") && !acao.isEmpty() && acao != null) {
				List<Usuario> listUsaurio = daoUsuarioEst.listUsuario();
				Gson gson = new Gson();
				FormDelUsuarioDTO formDelUsuarioDTO = new FormDelUsuarioDTO("Form limpo", daoUsuarioEst.listUsuario());
				response.setContentType("application/json");
				response.setCharacterEncoding("UTF-8");
				response.getWriter().write(gson.toJson(formDelUsuarioDTO));
			}else {
				
				List<Usuario> listUsaurio = daoUsuarioEst.listUsuario();
				request.setAttribute("listUsaurio", listUsaurio);
					
				RequestDispatcher requestDispatcher = request.getRequestDispatcher("/pages/usuario.jsp");
				requestDispatcher.forward(request, response);
				
			}
			
			
			
			
			
		
		
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try { 
			String id = request.getParameter("id");
			String nome = request.getParameter("nome");
			String email = request.getParameter("email");
			String senha = request.getParameter("senha");
			String login = request.getParameter("login");
			String cep = request.getParameter("cep");
			String logradouro = request.getParameter("logradouro");
			String bairro = request.getParameter("bairro");
			String localidade = request.getParameter("localidade");
			String uf = request.getParameter("uf");
			String numero = request.getParameter("numero");
			String genero = request.getParameter("genero");

			
			
			DaoUsuarioEst daoUsuarioEst = new DaoUsuarioEst();
			
			Usuario usuario = null;
			
			Long idLong = id == null || id.isEmpty() ? 0L : Long.parseLong(id);
			 
			usuario = new Usuario( idLong, nome, login, senha, email, cep, logradouro, bairro, localidade, uf,
					numero, genero);
			
			String msg = null;
			
			if(id == null || id.isEmpty()) {
				 usuario = daoUsuarioEst.insertUsuarioEst(usuario);
				 msg = "Usuario cadastrado com sucesso";
				 
			}else {
				usuario = daoUsuarioEst.updateUsuario(usuario);
				msg = "Usuario editado com sucesso";
			}
			
			
			List<Usuario> listUsaurio = daoUsuarioEst.listUsuario();
			
			FormUsuarioDTO formUsuarioDTO = new FormUsuarioDTO(msg, usuario, listUsaurio);
			 
			Gson gson = new Gson();
			

			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			response.getWriter().write(gson.toJson(formUsuarioDTO));
			
		
			
			
		
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
