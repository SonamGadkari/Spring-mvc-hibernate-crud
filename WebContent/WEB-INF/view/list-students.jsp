<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
<h2> List Students</h2>
</div>
</div>
<input type="button" value="Add new Student" onclick="window.location.href='showFormForAdd'; return false;"
class="add-button"/>
<div class="container">
<p>List students</p>
<table>
<tr>
<td>ID</td>
<td>FirstName</td>
<td>LastName</td>
<td>Email</td>
<td>Action</td>
<td>Delete</td>
</tr>
<c:forEach items="${students}" var="student">
<c:url var="updateLink" value="/student/showFormForUpdate">
	<c:param name="studentId" value="${student.id}"></c:param>
</c:url>
<c:url var="deleteLink" value="/student/deleteAction">
<c:param name="studentId" value="${student.id}"></c:param>
</c:url>
<tr>
<td>${student.id}</td>
<td>${student.first_name}</td>
<td>${student.last_name}</td>
<td>${student.email}</td>
<td><a href="${updateLink}">Update</a></td>
<td><a href="${deleteLink}" onclick="window.alert('Do you want to delete the record?')">Delete</a></td>
</tr>
</c:forEach>
</table>
</div>

</body>
</html>