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
 * @version 1.3
 * @since 1.3
 */
public class UsersServlet extends HttpServlet {

    private final ValidateService validator = ValidateService.getInstance();
    private static final Logger LOGGER = LogManager.getLogger("Servlet");

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.sendRedirect(String.format("%s/users.jsp", req.getContextPath()));
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String deletingUserId = req.getParameter("id");
        resp.setContentType("text/html");
        String message = "";
        if (deletingUserId != null) {
            if (this.validator.delete(Integer.parseInt(deletingUserId))) {
                message = "Пользователь удален";
            } else {
                message = "Пользователь не найден";
            }
        }
        req.setAttribute("message", message);
        try {
            req.getRequestDispatcher("/users.jsp").forward(req, resp);
        } catch (ServletException | IOException e) {
            LOGGER.error(e.getMessage(), e);
        }
    }
}
