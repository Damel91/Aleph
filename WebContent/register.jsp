<%@ page language="java" contentType="text/html; charset=windows-1256"
	pageEncoding="windows-1256"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<html>
<head>
<meta http-equiv="Content-Type"
	content="text/html; charset=windows-1256">
<title>Register Form</title>
</head>

<body>

	<form action="RegisterServlet" method="post">
		<fieldset>
			<legend>Registrazione</legend>
			<input type='hidden' name='submitted' id='submitted' value='1' /> <label
				for='username'>Username:</label><br> <input type='text'
				name='username' id='username' maxlength="50" /><br> <label
				for='email'>Email:</label><br> <input type='text' name='email'
				id='email' maxlength="50" /> <br> <label for='password'>Password:</label><br>
			<input type='password' name='password' id='password' maxlength="50" /><br>
			<label for='nome'>Nome: </label><br> <input type='text'
				name='nome' id='nome' maxlength="50" /><br> <label for='nome'>Cognome:
			</label><br> <input type='text' name='cognome' id='cognome'
				maxlength="50" /><br> <label for='nome'>Indirizzo: </label><br>
			<input type='text' name='indirizzo' id='indirizzo' maxlength="50" /><br>
			<label for='nome'>Città: </label><br> <input type='text'
				name='nome' id='città' maxlength="50" /><br> <label
				for='email'>Nazione:</label><br> <input type='text'
				name='nazione' id='nazione' maxlength="50" /><br> <label
				for='email'>Telefono:</label><br> <input type='text'
				name='telefono' id='telefono' maxlength="50" /><br> <input
				type='submit' name='Submit' value='Submit' />
		</fieldset>
	</form>


	<!--Username: 
<input type="text" name="username"/>
<br> Password:
<input type="text" name="password"/> 
<br> Nome:
<input type="text" name="nome"/> 
<br> Cognome:
<input type="text" name="cognome"/> 
<br> Indirizzo:
<input type="text" name="indirizzo"/>
<br> Città:
<input type="text" name="città"/>
<br> Nazione:
<input type="text" name="nazione"/>
<br> Telefono:
<input type="text" name="telefono"/>
<br> Email:
<input type="text" name="email"/>
<br> 
<input type="submit" value="submit">  -->

</body>
</html>