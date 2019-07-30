<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link type="text/css"
	  rel="stylesheet"
	  href="${pageContext.request.contextPath}/resources/css/style.css">
	  
</head>
<body>
<div id="wrapper">
<div id="header">
<h2> Save Students</h2>
</div>
</div>
<form:form action="processForm" modelAttribute="student" method="POST">
<tr>
<form:hidden path="id" />
<td><label>First Name:</label></td>
<td><form:input path="first_name" value="${student.first_name}"/></td>
</tr>
<tr>
<td><label>Last Name:</label></td>
<td><form:input path="last_name" value="${student.last_name}"/></td>
</tr>
<tr>
<td><label>Email:</label></td>
<td><form:input path="email" value="${student.email}"/></td>
</tr>
<tr>
<td><input type="submit" value="save"/></td>
</tr>
</form:form>
<div style="clear;both;"></div>
<p>
<a href="${pageContext.request.contextPath}/student/list">Back to List</a>
</p>
</body>
</html>