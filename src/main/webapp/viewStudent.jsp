<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored = "false" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Student Management System</title>
</head>
<body>
<div style="text-align: center; height: 100%; padding: 50px;">
<h1>Student List</h1>
<table style="padding-left: 500px; justify-content: space-around;">
<tr>
<th>ID</th>
<th>Name</th>
<th>Email</th>
<th>PhNo</th>
<th>Action</th>
</tr>
<c:forEach  var="student" items="${students}">
<tr>
<td>${student.getId()}</td>
<td>${student.getName()}</td>
<td>${student.getEmail()}</td>
<td>${student.getPhno()}</td>
<td><a href="updateStudent?id=${student.getId()}"><button>Edit</button></a> <a href="deleteStudent?id=${student.getId()}"><button>Delete</button></a></td>
<td></td>
</tr>
</c:forEach>

<ins><a href="home"><button >Home</button></a></ins>
</table>
</div>
</body>
</html>