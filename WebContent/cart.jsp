<%@ page language="java" contentType="text/html; charset=windows-1256"
	pageEncoding="windows-1256" import="model.Cart"
	import="java.util.ArrayList" import="model.BookBean"
	%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<% Cart cart = (Cart) (session.getAttribute("Cart"));
ArrayList<BookBean> products = cart.getProducts();
%>
<center>

        
            <table style="width:80%">
                    <tr>
                        <th>Prodotto</th>
                        <th class="text-center"></th>
                        <th class="text-center">Quantit&agrave;</th>
                        <th class="text-center">Prezzo</th>
                        <th class="text-center">Totale</th>
                        <th></th>
                    </tr>
                    <%double subTotale=0;
                    for(BookBean c : products) {
                     subTotale = c.getPrezzo()*c.getNumeroCopie();
                     %>
                         <tr>
                        <td><img src=<%=c.getImmagine()%> width="150" height="200"></th>
                        <td class="text-center"><%=c.getTitolo()%></td>    
                        <td class="text-center"><input type='text'
				name='quantity' id='quantity' maxlength="10" value='<%=c.getNumeroCopie()%>'></td>                  
                        <td class="text-center">$<%=c.getPrezzo()%></td>
                        <td class="text-center">$<%=subTotale%></td>
                        <td class="text-center">
			<form action="RemoveFromCartServlet">
		<fieldset>
			<input type='hidden' name='submitted' id='submitted' value='<%=c.getIsbn()%>' />
			<input type="submit" name='Submit' value='x Remove' />
		</fieldset>
	</form>
                        </td>
                    </tr>          
                    
                    <%}%>
                    <tr class="text-right"><td> Totale     $<%=cart.getTotale()%></td> </tr>
            </table>
            </center>
            
            <rigth>
    <form action="">
		<fieldset>
			<input type="submit" name='Submit' value='Continua lo shopping' />
		</fieldset>
	</form>
	
    <form action="CheckOutServlet" method="post">
		<fieldset>
			<input type="submit" name='Submit' value='Acquista' />
		</fieldset>
	</form>
            
            </rigth>
          
            
            



</body>
</html>