package control;

import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.BookBean;
import model.BookDAO;

public class SearchServlet extends HttpServlet {
  private static final long serialVersionUID = 7247393583289629719L;

  @SuppressWarnings({ "unchecked", "unused" })
  public void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, java.io.IOException {
    try {
      int page = 1, recordsPerPage = 5, noOfPages;
      String Keyword;
      ArrayList<BookBean> books = null;
      
      Keyword = request.getParameter("keyword");
      if (!Keyword.isEmpty()) books = BookDAO.search(request.getParameter("Keyword"));
      
      
      if(!Keyword.isEmpty()||(books.size()>0||books!=null)) {
      HttpSession session = request.getSession();
      noOfPages = (int) Math.ceil((books.size() * 1.0 / recordsPerPage));
      session.setAttribute("Books", books);
      request.setAttribute("noOfPages", noOfPages);
      request.setAttribute("currentPage", page);
      RequestDispatcher view = request.getRequestDispatcher("showBooks.jsp");
      view.forward(request, response);
      } else {
          RequestDispatcher view = request.getRequestDispatcher("noBooks.jsp");
          view.forward(request, response);
      }


    } catch (Throwable theException) {
      System.out.println(theException);
    }
  }
}
