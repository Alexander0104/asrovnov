<%@ page import="ru.job4j.crudservlet.ValidateService" %>
<%@ page import="ru.job4j.crudservlet.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Все пользователи</title>
</head>
<body>
<center>
    <c:out value="Вы авторизованы как ${sessionScope.loginRole.login}. Ваша роль: ${sessionScope.loginRole.role}"/>
    <form action="${pageContext.servletContext.contextPath}/signin" method="post">
        <input type="hidden" name="action" value="signout">
        <input type="submit" value="Выход"/>
    </form>
    <c:if test="${message != ''}">
        <div style="background-color: green">
            <c:out value="${message}"/>
        </div>
    </c:if>
    <c:if test="${error != ''}">
        <div style="background-color: red">
            <c:out value="${error}"/>
        </div>
    </c:if>
    <table>
        <caption>Все пользователи</caption>
        <tr>
            <th>Id</th>
            <th>Name</th>
            <th>Login</th>
            <th>Email</th>
            <th>Role</th>
        </tr>
        <c:forEach items="${users}" var="user">
            <tr>
                <td><c:out value="${user.id}"/></td>
                <td><c:out value="${user.name}"/></td>
                <td><c:out value="${user.login}"/></td>
                <td><c:out value="${user.email}"/></td>
                <td><c:out value="${user.role}"/></td>
                <c:if test="${sessionScope.loginRole.role == 'Администратор' || sessionScope.loginRole.login == user.name}">
                    <td>
                        <form action = "${pageContext.servletContext.contextPath}/edit" method="get">
                            <input type="hidden" name="id" value="${user.id}"/>
                            <input type="submit" value="Редактировать"/>
                        </form>
                    </td>
                </c:if>
                <c:if test="${sessionScope.loginRole.role == 'Администратор'}">
                    <td>
                        <form action="${pageContext.servletContext.contextPath}/list" method="post">
                            <input type="hidden" name="id" value="${user.id}"/>
                            <input type="submit" value="Удалить"/>
                        </form>
                    </td>
                </c:if>
            </tr>
        </c:forEach>
    </table>
</center>
</body>
</html>
