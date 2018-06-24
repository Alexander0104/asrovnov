<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Пустое хранилище</title>
    <h3 style="text-align: center">Пока нет ни одного пользователя</h3>
</head>
<body>
<center>
    <field>
        <legend style="text-align: center">Чтобы создать нового пользователя нажмите кнопку "Создать"</legend>
        <p>
        <form action=<%=request.getContextPath()%>/create>
            <button type='submit'>Создать</button>
        </form>
        </p>
    </field>
    <p style="text-align: right">jsp version</p>
</center>
</body>
</html>
