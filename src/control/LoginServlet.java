package control;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.*;

public class LoginServlet extends HttpServlet {
  private static final long serialVersionUID = 4065176428905113249L;

  public void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, java.io.IOException {
    try {
      UserBean user = new UserBean();
      user.setUserName(request.getParameter("username"));
      user.setPassword(request.getParameter("password"));
      user = UserDAO.login(user);

      if (user.isValid()) {
        HttpSession session = request.getSession(true);
        session.setAttribute("currentSessionUser", user);
        response.sendRedirect("loggedPage.jsp");
      } else
        response.sendRedirect("invalidLogin.jsp");
    } catch (Throwable theException) {
      System.out.println(theException);
    }
  }

}
