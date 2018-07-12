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
 * @version 1.5
 * @since 1.5
 */
public class UserCreateServlet extends HttpServlet {

    private static final Logger LOGGER = LogManager.getLogger("Servlet");
    private final ValidateService validator = ValidateService.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        try {
            req.getRequestDispatcher("/WEB-INF/views/create_user.jsp").forward(req, resp);
        } catch (IOException | ServletException e) {
            LOGGER.error(e.getMessage(), e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        String name = req.getParameter("name");
        String login = req.getParameter("login");
        String email = req.getParameter("email");
        String role = req.getParameter("role");
        String password = req.getParameter("password");
        String message = "";
        String error = "";
        if (this.validator.add(new User(name, login, email, role, password))) {
            message = "Пользователь добавлен";
        } else {
            error = "Неправильные данные, повторите попытку.";
        }
        req.setAttribute("message", message);
        req.setAttribute("error", error);
        try {
            req.getRequestDispatcher("/WEB-INF/views/create_user.jsp").forward(req, resp);
        } catch (ServletException | IOException e) {
            LOGGER.error(e.getMessage(), e);
        }
    }
}
