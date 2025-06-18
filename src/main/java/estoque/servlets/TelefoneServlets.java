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
import DTOs.FormTelefoneUserDTO;
import DTOs.FormUsuarioDTO;
import estoque.dao.DaoTelefoneEst;
import estoque.dao.DaoUsuarioEst;
import estoque.model.Telefone;
import estoque.model.Usuario;
import service.TelefoneService;

/**
 * Servlet implementation class TelefoneServlets
 */
@WebServlet(urlPatterns = { "/TelefoneServlets" })
public class TelefoneServlets extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private TelefoneService telefoneService = new TelefoneService();

	public TelefoneServlets() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			
			FormTelefoneUserDTO formTelefoneUserDTO = null;
			
			String acao = request.getParameter("acao");

			String idTelfone = request.getParameter("idTelefone");
			String idUserTelefone = request.getParameter("idUsuario");
			String nomeUser = request.getParameter("nome");
			String tipo = request.getParameter("tipo");
			String numero = request.getParameter("numero");
			
			if (  acao != null && acao.equalsIgnoreCase("ver") && !acao.isEmpty()) {
				
				
				formTelefoneUserDTO =  telefoneService.verTelefone(  idUserTelefone,  idTelfone);
			
				montaAtributos(formTelefoneUserDTO, request, response);
			
			}else if( acao != null && acao.equalsIgnoreCase("excluir") && !acao.isEmpty()){
				
				
				formTelefoneUserDTO =  telefoneService.excluirTelefone(idUserTelefone,  idTelfone);
				Gson gson = new Gson();
				response.setContentType("application/json");
				response.setCharacterEncoding("UTF-8");
				response.getWriter().write(gson.toJson(formTelefoneUserDTO));
			
			}else {
				
				formTelefoneUserDTO = telefoneService.listaInicial(idUserTelefone, idTelfone);
			
				montaAtributos(formTelefoneUserDTO, request, response);
				
				
			
			}
			 
			 
			
			
			

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	
			try {
				
				String idTelfone = request.getParameter("idTelefone");
				String idUserTelefone = request.getParameter("idUsuario");
				String nomeUser = request.getParameter("nome");
				String tipo = request.getParameter("tipo");
				String numero = request.getParameter("numero");
				
				TelefoneService telefoneService = new TelefoneService();
				FormTelefoneUserDTO formTelefoneUserDTO = telefoneService.insertOrUpdateTelefone( idTelfone, idUserTelefone,  nomeUser , tipo,   numero );
				
				Gson gson = new Gson();
				response.setContentType("application/json");
				response.setCharacterEncoding("UTF-8");
				response.getWriter().write(gson.toJson(formTelefoneUserDTO));
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	

		

	}
	
	public void montaAtributos(FormTelefoneUserDTO formTelefoneUserDTO, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setAttribute("usuario", formTelefoneUserDTO.getUsuario());
		request.setAttribute("telefones", formTelefoneUserDTO.getTelefones());
		request.setAttribute("telefone", formTelefoneUserDTO.getTelefone());
		
		RequestDispatcher requestDispatcher =
					request.getRequestDispatcher("/pages/telefone.jsp");
					requestDispatcher.forward(request, response);
	}

}
