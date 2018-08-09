
<%@ page language="java" contentType="text/html; charset=windows-1256"
	pageEncoding="windows-1256" import="model.BookBean"
	import="java.util.ArrayList"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<html>
<head>
<meta http-equiv="Content-Type"
	content="text/html; charset=windows-1256">

<title>Books list</title>
</head>
<body>

	<center>
		<% ArrayList<BookBean> Books = (ArrayList<BookBean>) (session.getAttribute("Books"));%>
		<% int noOfPages = (int) (request.getAttribute("noOfPages"));%>
		<% int currentPage = (int) (request.getAttribute("currentPage"));%>

		Dati inseriti:<br> <br> <br>
		<%int recordsPerPage = 5; %>
		<%int i = (currentPage-1)*recordsPerPage, max;%>
		<%if(currentPage==noOfPages) max = Books.size()-1;
		 else max = i+(recordsPerPage-1);%>
		<%BookBean currentBook;%>
		<%while (i<=max) {%>
		<%currentBook = Books.get(i); %>
		<a href="ProductServlet?isbn=<%=currentBook.getIsbn()%>"><img src="Images\<%=currentBook.getImmagine()%>"/></a><br>
		<%i++; %>
		<%} %>

		<%if (currentPage!=1) {%>
		<td><a href="ShowBookServlet?page=<%=(currentPage -1)%>">Previous</a></td>
		<%} %>
		<table border="1" cellpadding="5" cellspacing="5">
			<tr>
				<%for( i = 1; i<=noOfPages; i++){ %>
				<%if (currentPage==i){%>
				<td><%= i%></td>
				<%} else {%>
				<td><a href="ShowBookServlet?page=<%=i%>"> <%=i%>
				</a></td>
				<%}}%>
			</tr>
		</table>
		<%if (currentPage<noOfPages) {%>
		<td><a href="ShowBookServlet?page=<%=(currentPage + 1)%>">Next</a></td>
		<%} %>
		
		
			<form action="SearchServlet">
		<fieldset>
			<input type="text" name='keyword' id = 'keyword' maxlength="100" value='Ex..Giovanni Verga'/>
			<input type="submit" name='Submit' value='search' />
		</fieldset>
	</form>

	</center>

</body>
</html>