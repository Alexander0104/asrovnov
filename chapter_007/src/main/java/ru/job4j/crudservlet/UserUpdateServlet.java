package ru.job4j.crudservlet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * class UserUpdateServlet.
 * @author Alexander Rovnov.
 * @version 1.0
 * @since 1.0
 */
public class UserUpdateServlet extends HttpServlet {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserUpdateServlet.class);
    private static final String STORAGE = "storage";
    private static final String USER_ID = "id";
    private static final String USER_NAME = "name";
    private static final String USER_LOGIN = "login";
    private static final String USER_EMAIL = "email";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("text/html; charset=UTF-8");
        PrintWriter writer = resp.getWriter();
        String userId = req.getParameter(USER_ID);
        if (userId != null) {
            try {
                Integer id = Integer.valueOf(userId);
                ValidateService storage = (ValidateService) req.getSession().getAttribute(STORAGE);
                User userById = storage.findById(id);
                if (userById == null) {
                    writer.append(""
                            + "<!DOCTYPE html>"
                            + "<html>"
                            + "<meta charset='utf-8'>"
                            + "<body>"
                            + "<p>Нет пользователя с текущим id " + userId + "</p>"
                            + " <form action='" + req.getContextPath() + "/users'>"
                            + "     <button type='submit'>Показать всех пользователей</button>"
                            + " </form>"
                            + " </fieldset>"
                            + "</body>"
                            + "</html>");
                } else {
                    writer.append(""
                            + "<!DOCTYPE html>"
                            + "<html>"
                            + "<body>"
                            + "<center>"
                            + "<p>Изменить информацию об пользователе в форме ниже</p>"
                            + "<form action='" + req.getContextPath() + "/edit' method='post'>"
                            + "  <field>"
                            + "    <legend>Личная информация об пользователе:</legend>"
                            + "    id:   <br><input type='text' name='id' value='" + userById.getId() + "' readonly><br>"
                            + "    name: <br><input type='text' name='name' value='" + userById.getName() + "'><br>"
                            + "    login:<br><input type='text' name='login' value='" + userById.getLogin() + "'><br>"
                            + "    email:<br><input type='email' name='email' value='" + userById.getEmail() + "'><br>"
                            + "          <br><input type='submit' value='Обновить'><br><br>"
                            + " </form>"
                            + " <form action='" + req.getContextPath() + "/users'>"
                            + "     <button type='submit'>Показать всех пользователей</button>"
                            + " </form>"
                            + " </field>"
                            + "</center>"
                            + "</body>"
                            + "</html>");
                }
            } catch (Exception e) {
                LOGGER.error(e.getMessage(), e);
                writer.append(""
                        + "<!DOCTYPE html>"
                        + "<html>"
                        + "<body>"
                        + " <form action='" + req.getContextPath() + "/create'>"
                        + "     <button type='submit'>Создать</button>"
                        + " </form>"
                        + "</body>"
                        + "</html>");
                writer.flush();
            }
        }
        writer.flush();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("text/html; charset=UTF-8");
        PrintWriter writer = resp.getWriter();
        ValidateService storage = (ValidateService) req.getSession().getAttribute(STORAGE);
        try {
            User user = new User();
            user.setId(Integer.valueOf(req.getParameter(USER_ID)));
            user.setName(req.getParameter(USER_NAME));
            user.setLogin(req.getParameter(USER_LOGIN));
            user.setEmail(req.getParameter(USER_EMAIL));
            user.setCrateDate(storage.findById(Integer.valueOf(req.getParameter(USER_ID))).getCrateDate());
            if (storage.update(user)) {
                writer.append(""
                        + "<!DOCTYPE html>"
                        + "<html>"
                        + "<body>"
                        + " <form action='" + req.getContextPath() + "/users'>"
                        + "     <button type='submit'>Показать всех пользователей</button>"
                        + " </form>"
                        + "</body>"
                        + "</html>");
                writer.flush();
            } else {
                writer.append("Проверьте данные");
                writer.append(""
                        + "<!DOCTYPE html>"
                        + "<html>"
                        + "<body>"
                        + " <form action='" + req.getContextPath() + "/create'>"
                        + "     <button type='submit'>Создать</button>"
                        + " </form>"
                        + "</body>"
                        + "</html>");
                writer.flush();
            }
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
            writer.append("Проверьте данные");
            writer.append(""
                    + "<!DOCTYPE html>"
                    + "<html>"
                    + "<body>"
                    + " <form action='" + req.getContextPath() + "/create'>"
                    + "     <button type='submit'>Создать</button>"
                    + " </form>"
                    + "</body>"
                    + "</html>");
            writer.flush();
            doGet(req, resp);
        }
    }
}
