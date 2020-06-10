<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h2>Saving Alien Data</h2>
	<form action="addAlien">
		Id&nbsp;&nbsp;:&nbsp;<input type="text" name="aid">
		Name:&nbsp;<input type="text" name="aname">
		Technology:&nbsp;<input type="text" name="tech">
		<input type="submit">
	</form>
	<br>
	<h2>Getting Alien Data based on ID</h2>
	<form action="getAlien">
		Id&nbsp;&nbsp;:&nbsp;<input type="text" name="aid">
		<input type="submit">
	</form>
	<br>
	<h2>Getting Alien Data based on technology</h2>
	<form action="getAlienByTech">
		Technology&nbsp;&nbsp;:&nbsp;<input type="text" name="tech">
		<input type="submit">
	</form>
</body>
</html>