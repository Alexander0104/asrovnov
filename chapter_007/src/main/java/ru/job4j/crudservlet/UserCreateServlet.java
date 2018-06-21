package ru.job4j.crudservlet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * class UserCreateServlet.
 * @author Alexander Rovnov.
 * @version 1.0
 * @since 1.0
 */
public class UserCreateServlet extends HttpServlet {

    private static final Logger LOG = LoggerFactory.getLogger(UserCreateServlet.class);
    private static final String STORAGE = "storage";
    private static final String USER_ID = "id";
    private static final String USER_NAME = "name";
    private static final String USER_LOGIN = "login";
    private static final String USER_EMAIL = "email";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("text/html; charset=UTF-8");
        PrintWriter writer = resp.getWriter();
        writer.append(""
                + "<!DOCTYPE html>"
                + "<html lang=\"ru\">"
                + "<head>"
                + "<meta charset=\"utf-8\">"
                + "</head>"
                + "<body>"
                + "<center>"
                + "<p>Введите информацию в форме ниже</p>"
                + "<form action='" + req.getContextPath() + "/create' method='post'>"
                + "  <field>"
                + "    <legend>Личная информация об пользователе:</legend>"
                + "    id:<br><input type='text' name='id'><br>"
                + "    name: <br><input type='text' name='name'><br>"
                + "    login:<br><input type='text' name='login'><br>"
                + "    email:<br><input type='email' name='email'><br>"
                + "          <br><input type='submit' value='Создать'><br><br>"
                + " </form>"
                + " <form action='" + req.getContextPath() + "/users'>"
                + "     <button type='submit'>Показать всех пользователей</button>"
                + " </form>"
                + " </field>"
                + "</center>"
                + "</body>"
                + "</html>");
        writer.flush();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("text/html; charset=UTF-8");
        PrintWriter writer = resp.getWriter();
        ValidateService storage = (ValidateService) req.getSession().getAttribute(STORAGE);
        if (storage == null) {
            storage = ValidateService.getInstance();
        }
        try {
            String userId = req.getParameter(USER_ID);
            User user = new User();
            user.setId(Integer.valueOf(userId));
            user.setName(req.getParameter(USER_NAME));
            user.setLogin(req.getParameter(USER_LOGIN));
            user.setEmail(req.getParameter(USER_EMAIL));
            if (storage.add(user)) {
                req.getSession().setAttribute(STORAGE, storage);
                writer.append("Новый пользователь был успешно создан");
                writer.flush();
                doGet(req, resp);
            } else {
                writer.append("Пользователь с id: " + userId + " существует. "
                        + "Новый пользователь не был создан. выберите новое id");
                writer.flush();
                doGet(req, resp);
            }
        } catch (Exception e) {
            LOG.error(e.getMessage(), e);
            writer.append("Проверьте данные");
            writer.flush();
            doGet(req, resp);
        }
    }
}
