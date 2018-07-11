<%@ page import="ru.job4j.crudservlet.ValidateService" %>
<%@ page import="ru.job4j.crudservlet.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Все пользователи</title>
</head>
<body>
${message}
<center>
    <table>
        <caption>Все пользователи</caption>
        <tr>
            <th>Id</th>
            <th>Name</th>
            <th>Login</th>
            <th>Email</th>
        </tr>
        <%for (User usr : ValidateService.getInstance().findAll()) {%>
        <tr>
            <td><%=usr.getId()%></td>
            <td><%=usr.getName()%></td>
            <td><%=usr.getLogin()%></td>
            <td><%=usr.getEmail()%></td>
            <td>
                <form action = "<%=request.getContextPath()%>/edit" method="get">
                    <input type="hidden" name="id" value="<%=usr.getId()%>"/>
                    <input type="submit" value="Редактировать"/>
                </form>
            </td>
            <td>
                <form action="<%=request.getContextPath()%>/list" method="post">
                    <input type="hidden" name="id" value="<%=usr.getId()%>"/>
                    <input type="submit" value="Удалить"/>
                </form>
            </td>
        </tr>
        <%}%>
    </table>
</center>
</body>
</html>
