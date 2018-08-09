package control;

import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.*;

public class HomeServlet extends HttpServlet {
  private static final long serialVersionUID = -7022167787671981255L;

  public void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, java.io.IOException {
    try {
      ArrayList<BookBean> books;

      HttpSession session = request.getSession();
      session.setAttribute("Books", BookDAO.getBooksFromServer());

      books = BookDAO.getLastTen();
      request.setAttribute("Books", books);
      RequestDispatcher view = request.getRequestDispatcher("home.jsp");
      view.forward(request, response);


    } catch (Throwable theException) {
      System.out.println(theException);
    }
  }
}
