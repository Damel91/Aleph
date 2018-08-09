
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
		Welcome
		<%= currentUser.getNome() + " " + currentUser.getCognome() %>
	</center>
</body>
</html>