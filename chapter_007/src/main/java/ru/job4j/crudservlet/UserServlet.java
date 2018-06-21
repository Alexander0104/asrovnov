package ru.job4j.crudservlet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;

/**
 * class UserServlet.
 * @author Alexander Rovnov.
 * @version 1.1
 * @since 1.1
 */
public class UserServlet extends HttpServlet {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserServlet.class);
    private static final String USER_ID = "id";
    private static final String STORAGE = "storage";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        HttpSession session = req.getSession();
        resp.setContentType("text/html; charset=UTF-8");
        PrintWriter writer = resp.getWriter();
        ValidateService storage = (ValidateService) session.getAttribute(STORAGE);
        String noUsers = "<!DOCTYPE html>"
                + "<head>"
                + "<meta charset=UTF-8>"
                + "<title>From UsersServlet</title>"
                + "</head>"
                + "<body>"
                + "<field>"
                + "<legend>Пока нет ни одного пользователя</legend>"
                + "<form action='" + req.getContextPath() + "/create'>"
                + "             <button type='submit'>Создать нового</button>"
                + " </form>"
                + "</field>"
                + "</body>"
                + "</html>";
        if (storage == null) {
            session.setAttribute(STORAGE, ValidateService.getInstance());
            writer.append(noUsers);
        } else {
            Collection<User> all = storage.findAll();
            if (!all.isEmpty()) {
                StringBuilder builder = new StringBuilder();
                builder.append("<table>"
                        + "<tr>"
                        + "     <th>id</th>"
                        + "     <th>name</th>"
                        + "     <th>login</th>"
                        + "     <th>email</th>"
                        + "     <th>date</th>"
                        + "     <th>action</th>"
                        + "</tr>");
                for (User user : all) {
                    builder.append(""
                            + "<tr>"
                            + "    <td>" + user.getId() + "</td>"
                            + "    <td>" + user.getName() + "</td>"
                            + "    <td>" + user.getLogin() + "</td>"
                            + "    <td>" + user.getEmail() + "</td>"
                            + "    <td>" + user.getCrateDate() + "</td>"
                            + "    <td><form action='" + req.getContextPath() + "/edit' method='get'>"
                            + "             <button value='" + user.getId() + "' name='id' type='submit'>Редактировать</button>"
                            + "        </form>"
                            + "        <form action='" + req.getContextPath() + "/users' method='post'>"
                            + "             <button value='" + user.getId() + "' name='id' type='submit'>Удалить</button>"
                            + "        </form>"
                            + "    </td>"
                            + "</tr>");
                }
                builder.append("</table>");
                writer.append(""
                        + "<!DOCTYPE html>"
                        + "<head>"
                        + "    <meta charset='UTF-8'>"
                        + "    <title>From UsersServlet</title>"
                        + "         <style>"
                        + "             table { font-family: \"Lucida Sans Unicode\", \"Lucida Grande\", Sans-Serif; "
                        +                       "font-size: 15px; border-collapse: collapse; text-align: left;  margin: auto;}"
                        + "             table, th, td { background: #AFCDE7; padding: 10px 20px; text-align: center;}"
                        + "                    th, td { border-style: solid;  border-width: 0 1px 1px 0; border-color: white;}"
                        + "         </style>"
                        + "</head>"
                        + "<center>"
                        + "<body>"
                        + "<field>"
                        + "<legend>Текущие пользователи</legend>"
                        + builder.toString()
                        + "</field>"
                        + "</body>"
                        + "</center>"
                        + "</html>");
            } else {
                writer.append(noUsers);
            }
        }
        writer.flush();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String id = req.getParameter(USER_ID);
        if (id != null) {
            try {
                Integer integerId = Integer.valueOf(id);
                ValidateService storage = (ValidateService) req.getSession().getAttribute(STORAGE);
                storage.delete(integerId);
                doGet(req, resp);
            } catch (Exception e) {
                LOGGER.error(e.getMessage(), e);
                doGet(req, resp);
            }
        } else {
            LOGGER.error("");
            doGet(req, resp);
        }
    }
}
