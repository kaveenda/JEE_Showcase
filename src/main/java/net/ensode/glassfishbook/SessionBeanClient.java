package net.ensode.glassfishbook;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name="GuestServlet", urlPatterns={"/guest"})
public class SessionBeanClient extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3927760298464575818L;
	@EJB(name="net/ensode/glassfishbook/SimpleSession")
	private SimpleSession simpleSession;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		execute(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		execute(request, response);
	}

	private void execute(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("printHello", simpleSession.getMessage());
		request.getRequestDispatcher("/Greeting.jsp").forward(request,
				response);
	}
}
