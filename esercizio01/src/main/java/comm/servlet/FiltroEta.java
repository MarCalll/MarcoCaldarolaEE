package comm.servlet;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

/**
 * Servlet Filter implementation class FiltroEta
 */
@WebFilter("/Inserimento")
public class FiltroEta implements Filter {

	public FiltroEta() {

	}

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
	
		if (request.getParameter("eta") != null) {
			int eta = Integer.parseInt(request.getParameter("eta"));
			if (eta>= 45) {
				request.setAttribute("messaggio", "Troppo vecchio per accedere al corso");
				RequestDispatcher dispatcher = request.getRequestDispatcher("/messaggio.jsp");
				dispatcher.forward(request, response);
			}
		}
		
		chain.doFilter(request, response);
	}

	public void init(FilterConfig fConfig) throws ServletException {
	}

}
