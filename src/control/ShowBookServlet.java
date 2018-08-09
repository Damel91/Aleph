package control;

import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.*;

public class ShowBookServlet extends HttpServlet {
  private static final long serialVersionUID = 3974467558841002647L;

  @SuppressWarnings("unchecked")
  public void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, java.io.IOException {
    try {
      int page = 1, recordsPerPage = 5, noOfPages;
      ArrayList<BookBean> books=null;
      HttpSession session = request.getSession();
      if (session.getAttribute("Books") != null) {

        if (request.getParameter("page") != null)
          page = Integer.parseInt(request.getParameter("page"));

        books = (ArrayList<BookBean>) (session.getAttribute("Books"));
      } else
        books = BookDAO.getBooksFromServer();
      
      if(books.size()>0) {
      noOfPages = (int) Math.ceil((books.size() * 1.0 / recordsPerPage));
      session.setAttribute("Books", books);
      request.setAttribute("noOfPages", noOfPages);
      request.setAttribute("currentPage", page);
      RequestDispatcher view = request.getRequestDispatcher("showBooks.jsp");
      view.forward(request, response);
      }else {
          RequestDispatcher view = request.getRequestDispatcher("noBooks.jsp");
          view.forward(request, response);
      }


    } catch (Throwable theException) {
      System.out.println(theException);
    }
  }
}

