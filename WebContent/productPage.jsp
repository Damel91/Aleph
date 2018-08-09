
<%@ page language="java" contentType="text/html; charset=windows-1256"
	pageEncoding="windows-1256" import="model.BookBean"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<html>
<head>
<meta http-equiv="Content-Type"
	content="text/html; charset=windows-1256">
<title>Pagina del prodotto</title>
</head>

<body>

	<center>
		<% BookBean currentBook = (BookBean) (request.getAttribute("Book"));%>
		Libro:<br> <br> <br>
		<%=currentBook.getIsbn()%><br>
		<%=currentBook.getAutore()%><br>
		<%=currentBook.getPrezzo()%><br>
		<%=currentBook.getNumeroCopie()%><br>
		<%=currentBook.getGenere()%><br>
		<%=currentBook.getDataOra()%><br>
		<%=currentBook.getCasaEditrice()%><br> <img
			src="Images\<%=currentBook.getImmagine()%>" /><br>
			<br>
			<br>
			
			<form action="CartServlet">
		<fieldset>
		<label></label><input type='hidden' name='submitted' id='submitted' value='<%=currentBook.getIsbn()%>' /> 
			<label for='quantity'>Quantità: </label><input type="text" name='quantity' id = 'quantity' maxlength="10" value='1'/>
			<input type="submit" name='Submit' value='Metti nel carrello' />
		</fieldset>
	</form>

	</center>

</body>
</html>