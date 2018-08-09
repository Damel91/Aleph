package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class OrderDAO {
public static OrderBean register(OrderBean bean) throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException, NamingException {
		
		try{
			Context initContext = new InitialContext();
			Context envContext = (Context) initContext.lookup("java:comp/env");
			DataSource ds = (DataSource) envContext.lookup("jdbc/store");
			Connection conn = ds.getConnection();
			
			int idAcquisto = bean.getIdAcquisto();
			String cliente = bean.getCliente();
			String dataAcquisto = bean.getDataAcquisto();
			Cart cart = bean.getCart();
			ArrayList<BookBean> products = cart.getProducts();
			String sql = "insert into ordine values ('" + idAcquisto + "', '" + cliente + "', '" + dataAcquisto + "', '" + cart.getTotale() +"');"; 
		      PreparedStatement statement = conn.prepareStatement(sql);
		      int es = statement.executeUpdate();
		      
			
			for (BookBean c : products) {
			sql = "insert into libro_ordine values ('" + idAcquisto + "', '" + c.getIsbn() + "', '" + c.getNumeroCopie() + "');"; 
		      statement = conn.prepareStatement(sql);
		      es = statement.executeUpdate();
			
			conn.commit();
			}
			if (es<1) { 
				System.out.println("Dati incompleti"); 
				bean.setValid(false); } 
			else { 				
				System.out.println("Ordine inserito correttamente " + idAcquisto); 
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
