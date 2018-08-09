<%@ page language="java" contentType="text/html; charset=windows-1256"
	pageEncoding="windows-1256" import="model.*"
	import="java.util.ArrayList"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<center>
<a href="ShowBookServlet">Show all books</a><br>

		<% ArrayList<BookBean> Books = BookDAO.getLastTen();%>

		Ultime Novità:<br> <br> <br>
		<%for (BookBean currentBook : Books ) {%>
		<a href="ProductServlet?isbn=<%=currentBook.getIsbn()%>"><img src="Images\<%=currentBook.getImmagine()%>"/></a><br>
		<%} %>

</center>

</body>
</html>