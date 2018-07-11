package ru.job4j.crudservlet;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * class UserCreateServlet.
 * @author Alexander Rovnov.
 * @version 1.3
 * @since 1.3
 */
public class UserCreateServlet extends HttpServlet {

    private static final Logger LOGGER = LogManager.getLogger("Servlet");
    private final ValidateService validator = ValidateService.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        try {
            resp.sendRedirect(String.format("%s/create_user.jsp", req.getContextPath()));
        } catch (IOException e) {
            LOGGER.error(e.getMessage(), e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        String name = req.getParameter("name");
        String login = req.getParameter("login");
        String email = req.getParameter("email");
        String message;
        if (this.validator.add(new User(name, login, email))) {
            message = "Пользователь добавлен";
        } else {
            message = "Неправильные данные, повторите попытку.";
        }
        req.setAttribute("message", message);
        try {
            req.getRequestDispatcher("/create_user.jsp").forward(req, resp);
        } catch (ServletException | IOException e) {
            LOGGER.error(e.getMessage(), e);
        }
    }
}
