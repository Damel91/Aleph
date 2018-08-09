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
import model.Cart;

public class CartServlet extends HttpServlet{
  private static final long serialVersionUID = -8990262356350747L;
  @SuppressWarnings({ "unchecked", "unused" })
  
  public void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, java.io.IOException {
    try {
      int quantity;
      ArrayList<BookBean> books;
      BookBean product = null;
      HttpSession session = request.getSession();
      Cart cart;
      if(session.getAttribute("Cart")!=null)
    	  cart =(Cart) session.getAttribute("Cart");
      else
          cart = new Cart();
      
      String isbn = request.getParameter("submitted");
      quantity = Integer.parseInt(request.getParameter("quantity"));
      
      

        books = (ArrayList<BookBean>) (session.getAttribute("Books"));
        for (BookBean book : books)
          if (book.getIsbn().equals(isbn))
            product = book;
        
        
        
        cart.addBook(product, quantity);
        
        
      session.setAttribute("Cart", cart);
      RequestDispatcher view = request.getRequestDispatcher("Cart.jsp");
      view.forward(request, response);


    } catch (Throwable theException) {
      System.out.println(theException);
    }
  }
}
