package model;

import java.sql.*;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class UserDAO {

  public static UserBean login(UserBean bean) throws SQLException, InstantiationException,
      IllegalAccessException, ClassNotFoundException, NamingException {

    try {
      Context initContext = new InitialContext();
      Context envContext = (Context) initContext.lookup("java:comp/env");
      DataSource ds = (DataSource) envContext.lookup("jdbc/store");
      Connection conn = ds.getConnection();

      String username = bean.getUsername();
      String password = bean.getPassword();
      String sql = "select * from cliente where username='" + username + "' AND password='"
          + password + "';";
      
      PreparedStatement  preparedStatement = conn.prepareStatement(sql);

		ResultSet rs = preparedStatement.executeQuery();


      boolean more = rs.next();

      if (!more) {
        System.out.println("Utente non registrato!");
        bean.setValid(false);
      } else {
        String nome = rs.getString("nome");
        String cognome = rs.getString("cognome");
        System.out.println("Welcome " + nome);
        bean.setNome(nome);
        bean.setCognome(cognome);
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

  public static UserBean register(UserBean bean) throws SQLException, InstantiationException,
      IllegalAccessException, ClassNotFoundException, NamingException {

    try {
      Context initContext = new InitialContext();
      Context envContext = (Context) initContext.lookup("java:comp/env");
      DataSource ds = (DataSource) envContext.lookup("jdbc/store");
      Connection conn = ds.getConnection();

      String username = bean.getUsername();
      String password = bean.getPassword();
      String nome = bean.getNome();
      String cognome = bean.getCognome();
      String email = bean.getEmail();
      String indirizzo = bean.getIndirizzo();
      String città = bean.getCittà();
      String nazione = bean.getNazione();
      String telefono = bean.getTelefono();


      Statement statement = conn.createStatement();
      String sql = "insert into cliente values ('" + username + "', '" + password + "', '" + nome
          + "', '" + cognome + "', '" + nazione + "', '" + città + "', '" + indirizzo + "', '"
          + telefono + "', '" + email + "');";
      int es = statement.executeUpdate(sql);

      if (es < 1) {
        System.out.println("Dati incompleti");
        bean.setValid(false);
      } else {
        System.out.println("Welcome " + nome);
        bean.setNome(nome);
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
  public static UserBean modifyUser(String precUsername, UserBean bean) throws SQLException,
  InstantiationException, IllegalAccessException, ClassNotFoundException, NamingException {
try {
  Context initContext = new InitialContext();
  Context envContext = (Context) initContext.lookup("java:comp/env");
  DataSource ds = (DataSource) envContext.lookup("jdbc/store");
  Connection conn = ds.getConnection();
  String username = bean.getUsername();
  String password = bean.getPassword();
  String nome = bean.getNome();
  String cognome = bean.getCognome();
  String email = bean.getEmail();
  String indirizzo = bean.getIndirizzo();
  String città = bean.getCittà();
  String nazione = bean.getNazione();
  String telefono = bean.getTelefono();
  
  String sql = "update cliente set username = '" + username + "',set password = '" + password + "',set nome = '" + nome + "',set cognome = '" + cognome + "',set email = '" + email + "',set indirizzo = '" + indirizzo + "',set città = '" + città + "',set telefono = '" + telefono + "',set nazione = '" + nazione + "'   where username='" + precUsername + "'"; 
  PreparedStatement  preparedStatement = conn.prepareStatement(sql);
  
  int es = preparedStatement.executeUpdate();
  
  if (es < 1) {
      System.out.println("Dati incompleti");
      bean.setValid(false);
    } else {
      System.out.println("Utente registrato correttamente " + bean.getUsername());
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


