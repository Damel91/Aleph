package model;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class AuthorDAO {
public static AuthorBean register(AuthorBean bean) throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException, NamingException {
		
		try{
			Context initContext = new InitialContext();
			Context envContext = (Context) initContext.lookup("java:comp/env");
			DataSource ds = (DataSource) envContext.lookup("jdbc/store");
			Connection conn = ds.getConnection();
		
			String idAutore = bean.getIdAutore(); 
			String nome = bean.getNome();
			String cognome = bean.getCognome();
			String nazione = bean.getNazione();
			String dataDiNascita = bean.getDataDiNascita(); 
			
			Statement statement = conn.createStatement();
			String sql = "insert into autore values ('" + idAutore + "', '" + nome + "', '" + cognome + "', '" + dataDiNascita +"', '" + nazione + "');"; 
			int es = statement.executeUpdate(sql);
			
			if (es<1) { 
				System.out.println("Dati incompleti"); 
				bean.setValid(false); } 
			else { 				
				System.out.println("Autore inserito correttamente " + idAutore); 
				bean.setIdAutore(idAutore); 
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
	
		return bean; }
}
