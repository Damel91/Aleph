package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class PublishingHouseDAO {
public static PublishingHouseBean register(PublishingHouseBean bean) throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException, NamingException {
		
		try{
			Context initContext = new InitialContext();
			Context envContext = (Context) initContext.lookup("java:comp/env");
			DataSource ds = (DataSource) envContext.lookup("jdbc/store");
			Connection conn = ds.getConnection();
		
			String idCasaEditrice = bean.getIdCasaEditrice(); 
			String nome = bean.getNome();
			String telefono = bean.getTelefono();
			String indirizzo = bean.getIndirizzo(); 
			String sql = "insert into casa_editrice values ('" + idCasaEditrice + "', '" + nome + "', '" + telefono  + indirizzo + "');"; 
		      PreparedStatement statement = conn.prepareStatement(sql);
		      int es = statement.executeUpdate();
			conn.commit();
			if (es<1) { 
				System.out.println("Dati incompleti"); 
				bean.setValid(false); } 
			else { 				
				System.out.println("Casa editrice inserita correttamente " + idCasaEditrice); 
				bean.setIdCasaEditrice(idCasaEditrice); 
				bean.setValid(true); 
				} 
		
		
		} catch (SQLException se) {
            System.out.println("SQL Exception:");
            while (se != null) {
                System.out.println("State  : " + se.getSQLState());
                System.out.println("Message: " + se.getMessage());
                System.out.println("Error  : " + se.getErrorCode());

                se = se.getNextException();
            }}
            catch (Exception e) { 
			e.printStackTrace(System.out);} 
	
		return bean; 
		}

public static PublishingHouseBean modifyPublishingHouse(String precId, PublishingHouseBean bean) throws SQLException,
InstantiationException, IllegalAccessException, ClassNotFoundException, NamingException {
try {
Context initContext = new InitialContext();
Context envContext = (Context) initContext.lookup("java:comp/env");
DataSource ds = (DataSource) envContext.lookup("jdbc/store");
Connection conn = ds.getConnection();

String idCasaEditrice = bean.getIdCasaEditrice(); 
String nome = bean.getNome();
String telefono = bean.getTelefono();
String indirizzo = bean.getIndirizzo(); 

String sql = "update cliente set id_casa_editrice = '" + idCasaEditrice + "',set nome = '" + nome + "',set telefono = '" + telefono + "',set indirizzo = '" + indirizzo + "' where id_casa_editrice ='" + precId + "'"; 
PreparedStatement  preparedStatement = conn.prepareStatement(sql);

int es = preparedStatement.executeUpdate();

if (es < 1) {
    System.out.println("Dati incompleti");
    bean.setValid(false);
  } else {
    System.out.println("Utente registrato correttamente " + bean.getIdCasaEditrice());
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

public static ArrayList<PublishingHouseBean> searchById(String keyword) throws SQLException,
InstantiationException, IllegalAccessException, ClassNotFoundException, NamingException {
	ArrayList<PublishingHouseBean> pBHS = new ArrayList<PublishingHouseBean>();
try {
Context initContext = new InitialContext();
Context envContext = (Context) initContext.lookup("java:comp/env");
DataSource ds = (DataSource) envContext.lookup("jdbc/store");
Connection conn = ds.getConnection();
String sql = "select * from casa_editrice where id_casa_editrice like '%" + keyword + "%';";
Statement statement = conn.createStatement();
ResultSet rs = statement.executeQuery(sql);
PublishingHouseBean pBH = new PublishingHouseBean();
while (rs.next()) {
  pBH.setIdCasaEditrice(rs.getString("id_casa_editrice"));
  pBH.setNome(rs.getString("nome"));
  pBH.setIndirizzo(rs.getString("indirizzo"));
  pBH.setTelefono(rs.getString("telefono"));
  pBH.setValid(true);
  pBHS.add(pBH);
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
return pBHS;
}
public static ArrayList<PublishingHouseBean> getPublishingHouses(String keyword) throws SQLException,
InstantiationException, IllegalAccessException, ClassNotFoundException, NamingException {
	ArrayList<PublishingHouseBean> pBHS = new ArrayList<PublishingHouseBean>();
try {
Context initContext = new InitialContext();
Context envContext = (Context) initContext.lookup("java:comp/env");
DataSource ds = (DataSource) envContext.lookup("jdbc/store");
Connection conn = ds.getConnection();
String sql = "select * from casa_editrice";
Statement statement = conn.createStatement();
ResultSet rs = statement.executeQuery(sql);
PublishingHouseBean pBH = null;
while (rs.next()) {
  pBH.setIdCasaEditrice(rs.getString("id_casa_editrice"));
  pBH.setNome(rs.getString("nome"));
  pBH.setIndirizzo(rs.getString("indirizzo"));
  pBH.setTelefono(rs.getString("telefono"));
  pBH.setValid(true);
  pBHS.add(pBH);
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
return pBHS;
}
}
