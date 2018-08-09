
<%@ page language="java" contentType="text/html; charset=windows-1256"
	pageEncoding="windows-1256" import="model.BookBean"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<html>
<head>
<meta http-equiv="Content-Type"
	content="text/html; charset=windows-1256">
<title>Book insertion succesfully</title>
</head>

<body>

	<center>
		<% BookBean currentBook = (BookBean) (request.getAttribute("book"));%>
		Dati inseriti:<br> <br> <br>
		<%=currentBook.getIsbn()%><br>
		<%=currentBook.getPrezzo()%><br>
		<%=currentBook.getNumeroCopie()%><br>
		<%=currentBook.getGenere()%><br>
		<%=currentBook.getDataOra()%><br>
		<%=currentBook.getCasaEditrice()%><br> <img
			src="Images\<%=currentBook.getImmagine()%>" /><br>

	</center>

</body>
</html>