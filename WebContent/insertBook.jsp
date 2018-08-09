<%@ page language="java" contentType="text/html; charset=windows-1256"
	pageEncoding="windows-1256"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<html>
<head>
<meta http-equiv="Content-Type"
	content="text/html; charset=windows-1256">
<title>Book Insertion</title>
</head>

<body>

	<form action="BookInsertionServlet" method="post">
		<fieldset>
			<legend>Book insertion</legend>
			<input type='hidden' name='submitted' id='submitted' value='1' /> <label
				for='isbn'>Isbn:</label><br> <input type='text' name='isbn'
				id='isbn' maxlength="50" /><br> <label
				for='title'>Title:</label><br> <input type='text' name='title'
				id='title' maxlength="50" /><br> 
				<label for='author'>Author/s:</label><br> <input type='text' name='author'
				id='author' maxlength="100" /><br> <label for='price'>Price:</label><br>
				<label for='price'>Price:</label><br>
			<input type='text' name='price' id='price' maxlength="50" /> <br>
			<label for='numberOfCopies'>Number of copies:</label><br> <input
				type='text' name='numberOfCopies' id='numberOfCopies' maxlength="50" /><br>
			<label for='genre'>Genre: </label><br> <input type='text'
				name='genre' id='genre' maxlength="50" /><br> <label
				for='publishingHouse'>Publishing House: </label><br> <input
				type='text' name='publishingHouse' id='publishingHouse'
				maxlength="50" /><br>
				<label for='year'>Year: </label><br> <input type='text'
				name='year' id='year' maxlength="50" /><br>
				 <label for='image'>Image: </label><br>
			<input type='file' name='image' id='image' maxlength="100" /><br>
			<input type='submit' name='Submit' value='Submit' />
		</fieldset>
	</form>

	<form action="ShowBookServlet">
		<fieldset>
			<legend>See all book</legend>
			<input type="submit" name='Submit' value='Show all book' />
		</fieldset>
	</form>

	<!--Isbn: 
<input type="text" name="isbn"/>
<br> Price:
<input type="text" name="price"/> 
<br> Number of Copies:
<input type="text" name="numberOfCopies"/> 
<br> Genre:
<input type="text" name="genre"/> 
<br> Publishing House:
<input type="text" name="publishingHouse"/>
<br> 
<input type="submit" value="submit">  -->

</body>
</html>