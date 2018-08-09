package control;

import java.text.SimpleDateFormat;
import java.util.Date;

import model.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException; 
import javax.servlet.http.HttpServlet; 
import javax.servlet.http.HttpServletRequest; 
import javax.servlet.http.HttpServletResponse; 
import javax.servlet.http.HttpSession;

public class BookInsertionServlet extends HttpServlet {
	private static final long serialVersionUID = 8831181235830936628L;

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, java.io.IOException { 
		try {
			BookBean book = new BookBean(); 
			book.setIsbn(request.getParameter("isbn"));
			book.setAutore(request.getParameter("author"));
			book.setTitolo(request.getParameter("title"));
			book.setPrezzo(Double.parseDouble(request.getParameter("price")));
			book.setNumeroCopie(Integer.parseInt(request.getParameter("numberOfCopies")));
			book.setGenere(request.getParameter("genre"));
			book.setCasaEditrice(request.getParameter("publishingHouse"));
			book.setAnno(request.getParameter("anno"));
			String immagine = request.getParameter("image");
			int i = immagine.lastIndexOf('\\')+1;
			book.setImmagine(immagine.substring(i));
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			book.setDataOra(sdf.format(new Date()));
			
			book = BookDAO.register(book); 
			
			
		      if (book.isValid()) {
			        request.setAttribute("book", book);
			        response.sendRedirect("registeredBook.jsp");
			      } else {
				        request.setAttribute("book", book);
					      RequestDispatcher view = request.getRequestDispatcher("insertBook.jsp");
					      view.forward(request, response);
			      }
			
		}
		catch (Throwable theException) { System.out.println(theException); } 
		}	

}
