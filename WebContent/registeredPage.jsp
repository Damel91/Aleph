
<%@ page language="java" contentType="text/html; charset=windows-1256"
	pageEncoding="windows-1256" import="model.UserBean"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<html>
<head>
<meta http-equiv="Content-Type"
	content="text/html; charset=windows-1256">
<title>User Logged Successfully</title>
</head>

<body>

	<center>
		<% UserBean currentUser = (UserBean) (session.getAttribute("currentSessionUser"));%>
		Ciao
		<%= currentUser.getNome() + " " + currentUser.getCognome() %>
		<br> <br> <br> I tuoi dati:<br> <br> <br>
		<%=currentUser.getUsername()%><br>
		<%=currentUser.getEmail()%><br>

	</center>
</body>
</html>