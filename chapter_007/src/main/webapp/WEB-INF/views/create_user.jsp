<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Создать пользователя</title>
</head>
<body>
<c:out value="${message}"/>
<center>
    <form action="${pageContext.servletContext.contextPath}/create" method="post">
        Login: <input type="text" name="login"/><br>
        Name: <input type="text" name="name"><br>
        Email: <input type="text" name="email"><br>
        <input type="submit">
    </form>
</center>
</body>
</html>
