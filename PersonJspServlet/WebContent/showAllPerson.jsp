<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<table>
<tr>
<th>ID</th>
<th>Name</th>
<th>Mobile No.</th>
</tr>
<c:forEach var="person" items="${personData}">


<tr>
<td>${person.id}</td>
<td>${person.name}</td>
<td>${person.mobno}</td>
</tr>>
</c:forEach>


</table>
	
</body>
</html>