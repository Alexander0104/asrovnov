<%@ page import="ru.job4j.crudservlet.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Обновить пользователя</title>
    <h3 style="text-align: center">Изменить иформацию о пользователе</h3>
</head>
<body>
<center>
    <field>
        <legend>Личная информация об пользователе:</legend>
        <form action=<%=request.getContextPath()%>/edit method="post">
            id:<br><input type="text" name="id" value="<%=((User) request.getAttribute("user")).getId()%>" readonly><br>
            name: <br><input type="text" name="name" value="<%=((User) request.getAttribute("user")).getName()%>"><br>
            login:<br><input type="text" name="login" value="<%=((User) request.getAttribute("user")).getLogin()%>"><br>
            email:<br><input type="email" name="email" value="<%=((User) request.getAttribute("user")).getEmail()%>"><br>
            <br><input type="submit" value="update"><br>
        </form>
        <form action=<%=request.getContextPath()%>/users>
            <button type="submit">Показать всех пользователей</button>
        </form>
    </field>
    <p style="text-align: right">jsp version</p>
</center>
</body>
</html>
