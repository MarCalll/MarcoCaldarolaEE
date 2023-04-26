package comm.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

@WebFilter("/Inserimento") // dove viene applicato il filtro
public class FiltroCitta implements Filter {

	public FiltroCitta() {
	}

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		if (request.getParameter("cittacorso") != null) {
			String citta = request.getParameter("cittacorso");
			if (citta.equals("Taranto") || citta.equals("Lecce")) {
				request.setAttribute("messaggio",
						"Impossibile registrarsi perche' il corso ha raggiunto capacità massima nella città di " + citta);
				RequestDispatcher dispatcher = request.getRequestDispatcher("/messaggio.jsp");
				dispatcher.forward(request, response);
				
				//si usa !=null perchè all'inizio controlla la città ma esce null quindi gliela fa ricontrollare finchè la trova
			}
		}
		chain.doFilter(request, response);
	}

	public void init(FilterConfig fConfig) throws ServletException {
	}

}
