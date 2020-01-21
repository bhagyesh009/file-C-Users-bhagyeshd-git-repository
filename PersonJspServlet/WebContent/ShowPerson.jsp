<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="allPerson">
		<input type="submit" value="Show All">
	</form>
	<br>
	<br>
	<form action="byID">
	Enter your Id : <input type ="text" name="ID" placeholder="Enter Your ID">
		<input type="submit" value="Show By Id">
	</form>
	<br>
	<br>
	<form action="byName">
		Enter your Name : <input type ="text" name="name" placeholder="Enter Your Name">
	
		<input type="submit" value="Show By Name">

	</form>
	<br>
	<br>

	<form action="byMobno">
		Enter Your Mobile No. : <input type ="text" name="mobno" placeholder="Enter Your Mobile No.">
	
		<input type="submit" value="Show By Mobile No.">

	</form>
	<br>
	<br>
</body>
</html>