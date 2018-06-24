package ru.job4j.crudservlet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.IOException;
import java.util.Collection;

/**
 * class UserServlet.
 * @author Alexander Rovnov.
 * @version 1.2
 * @since 1.2
 */
public class UserServlet extends HttpServlet {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserServlet.class);
    private static final String USER_ID = "id";
    public static final String STORAGE = "storage";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        try {
            HttpSession session = req.getSession();
            ValidateService storage = (ValidateService) session.getAttribute(STORAGE);
            if (storage == null) {
                RequestDispatcher page = req.getRequestDispatcher("empty.jsp");
                page.forward(req, resp);
            } else {
                Collection<User> all = storage.findAll();
                if (!all.isEmpty()) {
                    resp.sendRedirect("users.jsp");
                } else {
                    resp.sendRedirect("empty.jsp");

                }
            }
        } catch (ServletException | IOException e) {
            LOGGER.error(e.getMessage(), e);
            try {
                resp.sendRedirect("index.jsp");
            } catch (IOException exp) {
                LOGGER.error(exp.getMessage(), exp);
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        try {
            String id = req.getParameter(USER_ID);
            if (id != null) {
                Integer integerId = Integer.valueOf(id);
                ValidateService storage = (ValidateService) req.getSession().getAttribute(STORAGE);
                storage.delete(integerId);
                doGet(req, resp);
            } else {
                LOGGER.error("");
                doGet(req, resp);
            }
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
            doGet(req, resp);
        }
    }
}
