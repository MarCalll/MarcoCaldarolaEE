package comm.servlet;


import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Inserimento")
public class Inserimento extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Inserimento() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String tipo = request.getParameter("tipo");
		
		if (tipo.equals("Insegnante")) {
			request.getRequestDispatcher("Insegnante.html").forward(request, response);
		}
		else if (tipo.equals("Studente")){
			request.getRequestDispatcher("Studente.html").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String nome = request.getParameter("nome");
		String cognome = request.getParameter("cognome");
		String eta = request.getParameter("eta");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String tipo = request.getParameter("tipo");
		RequestDispatcher dispatcher = request.getRequestDispatcher("/messaggio.jsp");

		if (nome.isEmpty() || cognome.isEmpty()|| eta.isEmpty() || email.isEmpty() || password.isEmpty()) {
			request.setAttribute("messaggio", "Inserimento non riuscito per dati mancanti");
			dispatcher.forward(request, response);
		} else {
			if (tipo.equals("Studente")) {
				request.setAttribute("messaggio", "Lo " + tipo + " " + nome + " e' stato assegnato al corso.");
				dispatcher.forward(request, response);
			} else if (tipo.equals("Insegnante")){
				request.setAttribute("messaggio", "L' " + tipo + " " + nome + " e' stato assegnato al corso.");
				dispatcher.forward(request, response);
			}
		}
	}

}
