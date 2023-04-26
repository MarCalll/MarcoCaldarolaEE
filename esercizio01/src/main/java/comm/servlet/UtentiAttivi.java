package comm.servlet;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

@WebListener
public class UtentiAttivi implements HttpSessionListener {

    int utenti = 0;
    
    public UtentiAttivi() {
    }

    public void sessionCreated(HttpSessionEvent arg0)  { 
    	System.out.println("Utenti attivi:" + ++utenti);
    }

    public void sessionDestroyed(HttpSessionEvent arg0)  { 
    	System.out.println("Utenti attivi:" + --utenti);
    }
	
}
