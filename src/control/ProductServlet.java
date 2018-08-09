package control;

import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.*;

public class ProductServlet extends HttpServlet {
  private static final long serialVersionUID = 192878291956011987L;

  @SuppressWarnings("unchecked")
  public void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, java.io.IOException {
    try {
      String isbn = null;
      ArrayList<BookBean> books;
      BookBean prodotto = new BookBean();

      if (request.getParameter("isbn") != null)
        isbn = (request.getParameter("isbn"));
      HttpSession session = request.getSession();
      books = (ArrayList<BookBean>) (session.getAttribute("Books"));
      for (BookBean book : books)
        if (book.getIsbn().equals(isbn))
          prodotto = book;


      request.setAttribute("Book", prodotto);
      RequestDispatcher view = request.getRequestDispatcher("productPage.jsp");
      view.forward(request, response);


    } catch (Throwable theException) {
      System.out.println(theException);
    }
  }
}
