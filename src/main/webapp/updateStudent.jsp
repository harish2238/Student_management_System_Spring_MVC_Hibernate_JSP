<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="u" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div style="text-align: center; background-color:teal; height: 100%; padding: 250px;">
<h1>Update Student Details....</h1>
<u:form action="saveUpdateStudent" modelAttribute="student">
<u:input path="id" readonly="true"/><br><br>
<u:input path="name" /><br><br>
<u:input path="email"/><br><br>
<u:input path="phno"/><br><br>
<input type="Submit" value="Update">
</u:form>
</div>

</body>
</html>