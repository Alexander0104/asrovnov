<%@ page import="ru.job4j.crudservlet.ValidateService" %>
<%@ page import="ru.job4j.crudservlet.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Все пользователи</title>
</head>
<body>
<c:out value="${message}"/>
<center>
    <table>
        <caption>Все пользователи</caption>
        <tr>
            <th>Id</th>
            <th>Name</th>
            <th>Login</th>
            <th>Email</th>
        </tr>
        <c:forEach items="${users}" var="user">
            <tr>
                <td><c:out value="${user.id}"/></td>
                <td><c:out value="${user.name}"/></td>
                <td><c:out value="${user.login}"/></td>
                <td><c:out value="${user.email}"/></td>
                <td>
                    <form action = "${pageContext.servletContext.contextPath}/edit" method="get">
                        <input type="hidden" name="id" value="${user.id}"/>
                        <input type="submit" value="Редактировать"/>
                    </form>
                </td>
                <td>
                    <form action="${pageContext.servletContext.contextPath}/list" method="post">
                        <input type="hidden" name="id" value="${user.id}"/>
                        <input type="submit" value="Удалить"/>
                    </form>
                </td>
            </tr>
        </c:forEach>
    </table>
</center>
</body>
</html>
