<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Главная страница</title>
    <h3 style="text-align: center">Главная страница</h3>
</head>
<body>
<center>
    <field>
        <legend style="text-align: center">Действия</legend>
        <p>
        <form action=<%=request.getContextPath()%>/list>
            <button type='submit'>Показать всех пользователей</button>
        </form>
        <form action=<%=request.getContextPath()%>/create>
            <button type='submit'>Создать пользователя</button>
        </form>
        </p>
    </field>
    <p style="text-align: right">jsp version</p>
</center>
</body>
</html>
