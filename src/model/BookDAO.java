package model;

import java.sql.*;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class BookDAO {

  public static BookBean register(BookBean bean) throws SQLException, InstantiationException,
      IllegalAccessException, ClassNotFoundException, NamingException {

    try {
      Context initContext = new InitialContext();
      Context envContext = (Context) initContext.lookup("java:comp/env");
      DataSource ds = (DataSource) envContext.lookup("jdbc/store");
      Connection conn = ds.getConnection();

      String isbn = bean.getIsbn();
      String autore = bean.getAutore();
      String titolo = bean.getTitolo();
      Double prezzo = bean.getPrezzo();
      int nCopie = bean.getNumeroCopie();
      String genere = bean.getGenere();
      String casaEditrice = bean.getCasaEditrice();
      String immagine = bean.getImmagine();
      String dataOra = bean.getDataOra();
      String anno = bean.getAnno();

      String sql = "insert into libro values ('" + isbn + "', '" + autore + "', '" + titolo + "', '" + prezzo + "', '"
          + nCopie + "', '" + genere + "', '" + immagine + "', '" + dataOra + "', '" + anno + "', '" + casaEditrice
          + "');";
      
      PreparedStatement statement = conn.prepareStatement(sql);
      int es = statement.executeUpdate();
      conn.commit();

      if (es < 1) {
        System.out.println("Dati incompleti");
        bean.setValid(false);
      } else {
        System.out.println("Libro inserito correttamente " + isbn);
        bean.setIsbn(isbn);
        bean.setValid(true);
      }

    } catch (SQLException se) {
      System.out.println("SQL Exception:");
      while (se != null) {
        System.out.println("State  : " + se.getSQLState());
        System.out.println("Message: " + se.getMessage());
        System.out.println("Error  : " + se.getErrorCode());

        se = se.getNextException();
      }
    } catch (Exception e) {
      e.printStackTrace(System.out);
    }

    return bean;
  }

  public static ArrayList<BookBean> getLastTen() throws SQLException, InstantiationException,
      IllegalAccessException, ClassNotFoundException, NamingException {
    ArrayList<BookBean> books = new ArrayList<BookBean>();
    try {
      Context initContext = new InitialContext();
      Context envContext = (Context) initContext.lookup("java:comp/env");
      DataSource ds = (DataSource) envContext.lookup("jdbc/store");
      Connection conn = ds.getConnection();
      String sql = "select * from libro order by data_inserimento desc;";
      PreparedStatement  preparedStatement = conn.prepareStatement(sql);

		ResultSet rs = preparedStatement.executeQuery();
      int i = 0;
      while (rs.next() && i < 10) {
        BookBean book = new BookBean();
        book.setIsbn(rs.getString("isbn"));
        book.setTitolo(rs.getString("titolo"));
        book.setPrezzo(rs.getDouble("prezzo"));
        book.setNumeroCopie(rs.getInt("n_copie"));
        book.setGenere(rs.getString("genere"));
        book.setImmagine(rs.getString("immagine"));
        book.setDataOra(rs.getString("data_inserimento"));
        book.setCasaEditrice(rs.getString("casa_editrice"));
        book.setValid(true);
        books.add(book);
        i++;
      }
      rs.close();

    } catch (SQLException se) {
      System.out.println("SQL Exception:");
      while (se != null) {
        System.out.println("State  : " + se.getSQLState());
        System.out.println("Message: " + se.getMessage());
        System.out.println("Error  : " + se.getErrorCode());

        se = se.getNextException();
      }
    } catch (Exception e) {
      e.printStackTrace(System.out);
    }
    return books;
  }

  public static ArrayList<BookBean> getBooksFromServer() throws SQLException,
      InstantiationException, IllegalAccessException, ClassNotFoundException, NamingException {
    ArrayList<BookBean> books = new ArrayList<BookBean>();
    try {
      Context initContext = new InitialContext();
      Context envContext = (Context) initContext.lookup("java:comp/env");
      DataSource ds = (DataSource) envContext.lookup("jdbc/store");
      Connection conn = ds.getConnection();
      String sql = "select * from libro ;";
      PreparedStatement  preparedStatement = conn.prepareStatement(sql);

		ResultSet rs = preparedStatement.executeQuery();
        BookBean book = new BookBean();
      while (rs.next()) {
        book.setIsbn(rs.getString("isbn"));
        book.setAutore(rs.getString("autore"));
        book.setTitolo(rs.getString("titolo"));
        book.setPrezzo(rs.getDouble("prezzo"));
        book.setNumeroCopie(rs.getInt("n_copie"));
        book.setGenere(rs.getString("genere"));
        book.setImmagine(rs.getString("immagine"));
        book.setDataOra(rs.getString("data_inserimento"));
        book.setCasaEditrice(rs.getString("casa_editrice"));
        book.setValid(true);
        books.add(book);
      }
      rs.close();

    } catch (SQLException se) {
      System.out.println("SQL Exception:");
      while (se != null) {
        System.out.println("State  : " + se.getSQLState());
        System.out.println("Message: " + se.getMessage());
        System.out.println("Error  : " + se.getErrorCode());

        se = se.getNextException();
      }
    } catch (Exception e) {
      e.printStackTrace(System.out);
    }
    return books;
  }
  
  public static ArrayList<BookBean> search(String keyword) throws SQLException,
  InstantiationException, IllegalAccessException, ClassNotFoundException, NamingException {
ArrayList<BookBean> books = new ArrayList<BookBean>();
try {
  Context initContext = new InitialContext();
  Context envContext = (Context) initContext.lookup("java:comp/env");
  DataSource ds = (DataSource) envContext.lookup("jdbc/store");
  Connection conn = ds.getConnection();
  String sql = "select * from libro where autore like '%" + keyword + "%' || titolo like '%" + keyword + "%' || (select * from libro leftjoin casa_editrice where casa_editrice.nome like '%" + keyword + "%');";
  Statement statement = conn.createStatement();
  ResultSet rs = statement.executeQuery(sql);
  while (rs.next()) {
    BookBean book = new BookBean();
    book.setIsbn(rs.getString("isbn"));
    book.setAutore(rs.getString("autore"));
    book.setTitolo(rs.getString("titolo"));
    book.setPrezzo(rs.getDouble("prezzo"));
    book.setNumeroCopie(rs.getInt("n_copie"));
    book.setGenere(rs.getString("genere"));
    book.setImmagine(rs.getString("immagine"));
    book.setDataOra(rs.getString("data_inserimento"));
    book.setCasaEditrice(rs.getString("casa_editrice"));
    book.setValid(true);
    books.add(book);
  }
  rs.close();

} catch (SQLException se) {
  System.out.println("SQL Exception:");
  while (se != null) {
    System.out.println("State  : " + se.getSQLState());
    System.out.println("Message: " + se.getMessage());
    System.out.println("Error  : " + se.getErrorCode());

    se = se.getNextException();
  }
} catch (Exception e) {
  e.printStackTrace(System.out);
}
return books;
}
  
  public static ArrayList<BookBean> searchByIsbn(String keyword) throws SQLException,
  InstantiationException, IllegalAccessException, ClassNotFoundException, NamingException {
ArrayList<BookBean> books = new ArrayList<BookBean>();
try {
  Context initContext = new InitialContext();
  Context envContext = (Context) initContext.lookup("java:comp/env");
  DataSource ds = (DataSource) envContext.lookup("jdbc/store");
  Connection conn = ds.getConnection();
  String sql = "select * from libro where isbn like '%" + keyword + "%';";
  Statement statement = conn.createStatement();
  ResultSet rs = statement.executeQuery(sql);
  BookBean book = new BookBean();
  while (rs.next()) {
	    book.setIsbn(rs.getString("isbn"));
	    book.setAutore(rs.getString("autore"));
	    book.setTitolo(rs.getString("titolo"));
	    book.setPrezzo(rs.getDouble("prezzo"));
	    book.setNumeroCopie(rs.getInt("n_copie"));
	    book.setGenere(rs.getString("genere"));
	    book.setImmagine(rs.getString("immagine"));
	    book.setDataOra(rs.getString("data_inserimento"));
	    book.setCasaEditrice(rs.getString("casa_editrice"));
	    book.setValid(true);
	    books.add(book);
	  }
  rs.close();

} catch (SQLException se) {
  System.out.println("SQL Exception:");
  while (se != null) {
    System.out.println("State  : " + se.getSQLState());
    System.out.println("Message: " + se.getMessage());
    System.out.println("Error  : " + se.getErrorCode());

    se = se.getNextException();
  }
} catch (Exception e) {
  e.printStackTrace(System.out);
}
return books;
}
  
  public static boolean updateCopies(String isbn, String nCopie) throws SQLException,
  InstantiationException, IllegalAccessException, ClassNotFoundException, NamingException {
	  boolean status=false;
try {
  Context initContext = new InitialContext();
  Context envContext = (Context) initContext.lookup("java:comp/env");
  DataSource ds = (DataSource) envContext.lookup("jdbc/store");
  Connection conn = ds.getConnection();
  String sql = "update libro set n_copie = '" + nCopie + "' where isbn='" + isbn + "'"; 
  PreparedStatement  preparedStatement = conn.prepareStatement(sql);
  
  int es = preparedStatement.executeUpdate();
  
  if (es < 1) {
      System.out.println("Dati incompleti");
      status=false;
    } else {
      System.out.println("Modifica effettuata " + nCopie);
      status=true;
    }

} catch (SQLException se) {
  System.out.println("SQL Exception:");
  while (se != null) {
    System.out.println("State  : " + se.getSQLState());
    System.out.println("Message: " + se.getMessage());
    System.out.println("Error  : " + se.getErrorCode());

    se = se.getNextException();
  }
} catch (Exception e) {
  e.printStackTrace(System.out);
}
return status;
}
  
  public static BookBean modifyBook(String precIsbn, BookBean bean) throws SQLException,
  InstantiationException, IllegalAccessException, ClassNotFoundException, NamingException {
try {
  Context initContext = new InitialContext();
  Context envContext = (Context) initContext.lookup("java:comp/env");
  DataSource ds = (DataSource) envContext.lookup("jdbc/store");
  Connection conn = ds.getConnection();
  String isbn = bean.getIsbn();
  String autore = bean.getAutore();
  String titolo = bean.getTitolo();
  Double prezzo = bean.getPrezzo();
  int nCopie = bean.getNumeroCopie();
  String genere = bean.getGenere();
  String casaEditrice = bean.getCasaEditrice();
  String immagine = bean.getImmagine();
  String anno = bean.getAnno();
  
  String sql = "update libro set isbn = '" + isbn + "',set autore = '" + autore + "',set titolo = '" + titolo + "', set prezzo = '" + prezzo + "',set n_copie = '" + nCopie + "',set genere = '" + genere + "',set immagine = '" + immagine + "',set casa_editrice = '" + casaEditrice + "',set anno = '" + anno + "'   where isbn='" + precIsbn + "'"; 
  PreparedStatement  preparedStatement = conn.prepareStatement(sql);
  
  int es = preparedStatement.executeUpdate();
  
  if (es < 1) {
      System.out.println("Dati incompleti");
      bean.setValid(false);
    } else {
      System.out.println("Libro inserito correttamente " + bean.getIsbn());
      bean.setValid(true);
    }

} catch (SQLException se) {
  System.out.println("SQL Exception:");
  while (se != null) {
    System.out.println("State  : " + se.getSQLState());
    System.out.println("Message: " + se.getMessage());
    System.out.println("Error  : " + se.getErrorCode());

    se = se.getNextException();
    

  }
} catch (Exception e) {
  e.printStackTrace(System.out);
}
return bean;
}


}
