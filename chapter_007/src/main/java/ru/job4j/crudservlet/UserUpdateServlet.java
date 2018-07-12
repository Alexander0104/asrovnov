package ru.job4j.crudservlet;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * class UserUpdateServlet.
 * @author Alexander Rovnov.
 * @version 1.5
 * @since 1.5
 */
public class UserUpdateServlet extends HttpServlet {

    private final ValidateService validator = ValidateService.getInstance();
    private static final Logger LOGGER = LogManager.getLogger("Servlet");

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        int updatedUserId = Integer.parseInt(req.getParameter("id"));
        final User updatedUser = this.validator.findById(updatedUserId);
        if (updatedUser != null) {
            req.setAttribute("user", updatedUser);
        } else {
            req.setAttribute("message", "Пользователь не найден");
        }
        try {
            req.getRequestDispatcher("/WEB-INF/views/update.jsp").forward(req, resp);
        } catch (ServletException | IOException e) {
            LOGGER.error(e.getMessage(), e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        User updatedUser = new User(
                req.getParameter("name"),
                req.getParameter("login"),
                req.getParameter("email"),
                req.getParameter("role"),
                req.getParameter("password")
        );
        updatedUser.setId(Integer.parseInt(req.getParameter("id")));
        String message = "";
        String error = "";
        if (this.validator.update(updatedUser)) {
            message = "Пользовательуспешно обновлен";
        } else {
            error = "Пользователь не найден";
        }
        req.setAttribute("message", message);
        req.setAttribute("error", error);
        try {
            req.setAttribute("users", this.validator.findAll());
            req.getRequestDispatcher("/WEB-INF/views/users.jsp").forward(req, resp);
        } catch (ServletException | IOException e) {
            LOGGER.error(e.getMessage(), e);
        }
    }
}
