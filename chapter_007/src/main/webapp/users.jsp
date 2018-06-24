<%@ page import="ru.job4j.crudservlet.ValidateService" %>
<%@ page import="static ru.job4j.crudservlet.UserServlet.STORAGE" %>
<%@ page import="ru.job4j.crudservlet.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Все пользователи</title>
    <h3 style="text-align:center">Все пользователи</h3>
    <meta charset='UTF-8'>
    <style>
        table { font-family: \"Lucida Sans Unicode\", \"Lucida Grande\", Sans-Serif;
            font-size: 15px; border-collapse: collapse; text-align: left;  margin: auto;}
        table, th, td { background: #AFCDE7; padding: 10px 20px; text-align: center;}
        th, td { border-style: solid;  border-width: 0 1px 1px 0; border-color: white;}
    </style>
</head>
<body>
<center>
    <field>
        <table>
            <tr>
                <th>id</th>
                <th>name</th>
                <th>login</th>
                <th>email</th>
                <th>date</th>
                <th>action</th>
            </tr>
            <% for (User user : ((ValidateService)session.getAttribute(STORAGE)).findAll()) {%>
            <tr>
                <td><%=user.getId()%></td>
                <td><%=user.getName()%></td>
                <td><%=user.getLogin()%></td>
                <td><%=user.getEmail()%></td>
                <td><%=user.getCrateDate()%></td>
                <td><form action=<%=request.getContextPath()%>/edit method='get'>
                    <button value=<%=user.getId()%> name='id' type='submit'>Редактировать</button>
                </form>
                    <form action=<%=request.getContextPath()%>/remove method='post'>
                        <button value='<%=user.getId()%>' name='id' type='submit'>Удалить</button>
                    </form>
                </td>

            </tr>
            <% } %>
        </table>
    </field>
    <p style="text-align: right">jsp version</p>
</center>
</body>
</html>
