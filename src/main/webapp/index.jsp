    <%@taglib prefix="c" uri="http://java.sun.com/jstl/core"%>
<%@taglib prefix="sql" uri="http://java.sun.com/jstl/sql"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>DB results</title>
</head>
<body>

	<sql:setDataSource var="db" driver="com.mysql.cj.jdbc.Driver" url="jdbc:mysql://localhost:3306/userdata" user="root" password="admin"/>
	<sql:query var="rs" dataSource="${db}"> select * from user</sql:query>
	
	<c:forEach items="${rs.rows}" var ="user">
		<c:out value="${user.name}"></c:out>  : <c:out value="${user.email}"></c:out><br>
	</c:forEach>
</body>
</html>