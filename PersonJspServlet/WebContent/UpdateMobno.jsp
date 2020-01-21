<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

${feedback}<br>
${mobnofeedback}
		<br>
	<form action="updateMobno">

		Enter Your Id: <input type="text" name="ID" placeholder="Enter ID"><br>
		<br> <br> Enter New Mobile No. <input type="text"
			name="mobno" placeholder="Enter New Mobile NO."><br> <br>
		<input type="submit" value="updateMobno">


	</form>


</body>
</html>