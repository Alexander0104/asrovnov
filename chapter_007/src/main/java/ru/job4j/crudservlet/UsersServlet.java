package ru.job4j.crudservlet;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * class UsersServlet.
 * @author Alexander Rovnov.
 * @version 1.5
 * @since 1.5
 */
public class UsersServlet extends HttpServlet {

    private final ValidateService validator = ValidateService.getInstance();
    private static final Logger LOGGER = LogManager.getLogger("Servlet");

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        try {
            req.setAttribute("users", this.validator.findAll());
            req.getRequestDispatcher("/WEB-INF/views/users.jsp").forward(req, resp);
        } catch (ServletException | IOException e) {
            LOGGER.error(e.getMessage(), e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String deletingUserId = req.getParameter("id");
        resp.setContentType("text/html");
        String message = "";
        String error = "";
        if (deletingUserId != null) {
            if (this.validator.delete(Integer.parseInt(deletingUserId))) {
                message = "Пользователь удален";
            } else {
                error = "Пользователь не найден";
            }
        }
        req.setAttribute("message", message);
        req.setAttribute("error", error);
        req.setAttribute("users", this.validator.findAll());
        try {
            req.getRequestDispatcher("/WEB-INF/views/users.jsp").forward(req, resp);
        } catch (ServletException | IOException e) {
            LOGGER.error(e.getMessage(), e);
        }
    }
}
