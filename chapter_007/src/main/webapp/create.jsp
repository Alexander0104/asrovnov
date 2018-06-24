<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Создать пользователя</title>
    <h3 style="text-align: center">Напишите информацию о пользователе в форме ниже</h3>
</head>
<body>
<center>
    <field>
        <%if (request.getAttribute("userInfo") == null) {
            request.setAttribute("userInfo", "Создать пользователя");
        }%>
        <p style="font-style: italic"><%=request.getAttribute("userInfo")%></p>
        <form action=<%=request.getContextPath()%>/create method='post'>
            id:<br><input type='text' name='id'><br>
            name: <br><input type='text' name='name'><br>
            login:<br><input type='text' name='login'><br>
            email:<br><input type='email' name='email'><br>
            <br><input type='submit' value='Создать'><br>
        </form>
        <form action=<%=request.getContextPath()%>/users>
            <button type='submit'>Показать всех пользователей</button>
        </form>
    </field>
    <p style="text-align: right">jsp version</p>
</center>
</body>
</html>
