package control;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.*;

public class RegisterServlet extends HttpServlet {
  private static final long serialVersionUID = -671948015707866747L;

  public void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, java.io.IOException {
    try {
      UserBean user = new UserBean();
      user.setUserName(request.getParameter("username"));
      user.setPassword(request.getParameter("password"));
      user.setNome(request.getParameter("nome"));
      user.setCognome(request.getParameter("cognome"));
      user.setEmail(request.getParameter("email"));
      user.setIndirizzo(request.getParameter("indirizzo"));
      user.setCittà(request.getParameter("città"));
      user.setNazione(request.getParameter("nazione"));
      user.setTelefono(request.getParameter("telefono"));

      user = UserDAO.register(user);

      if (user.isValid()) {
	        HttpSession session = request.getSession(true);
	        session.setAttribute("currentSessionUser", user);
	        response.sendRedirect("registeredPage.jsp");
	      } else {
		        request.setAttribute("user", user);
			      RequestDispatcher view = request.getRequestDispatcher("registerPage.jsp");
			      view.forward(request, response);
	      }

    } catch (Throwable theException) {
      System.out.println(theException);
    }
  }



}
