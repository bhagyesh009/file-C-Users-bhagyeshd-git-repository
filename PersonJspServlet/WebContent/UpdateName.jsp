<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
${namefeedback}
		
		<br>
${feedback}

<br>
	<form action="updateName">
			Enter Your Id: <input type="text" name ="ID" placeholder="Enter ID"><br><br>
			Enter New Name: <input type="text" name="name" placeholder="Enter New Name"><br>
				<br> <input type="submit" value="updateName">


	</form>


</body>
</html>