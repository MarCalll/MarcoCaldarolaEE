package comm.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Servlet")
public class Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Servlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String nome = request.getParameter("nome");
		String cognome = request.getParameter("cognome");
		String eta = request.getParameter("eta");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String tipo = request.getParameter("tipo");

		if (nome == null || cognome == null || eta == null || email == null || password == null) {
			response.getWriter().print("Inserimento non riuscito per dati mancanti");
		} else {
			if(tipo.equals("Studente")) {
				response.getWriter().print("Lo studente " + nome + " è stato iscritto al corso");
			}
			else {
				response.getWriter().print("L'insegnante " + nome + " è stato assegnato al corso");
			}
		}

	}

}
