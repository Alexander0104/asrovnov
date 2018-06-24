package ru.job4j.crudservlet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;


/**
 * class UserUpdateServlet.
 * @author Alexander Rovnov.
 * @version 1.2
 * @since 1.2
 */
public class UserUpdateServlet extends HttpServlet {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserUpdateServlet.class);
    private static final String STORAGE = "storage";
    private static final String USER = "user";
    private static final String USER_ID = "id";
    private static final String USER_NAME = "name";
    private static final String USER_LOGIN = "login";
    private static final String USER_EMAIL = "email";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        try {
            String userId = req.getParameter(USER_ID);
            if (userId != null) {
                Integer id = Integer.valueOf(userId);
                ValidateService storage = (ValidateService) req.getSession().getAttribute(STORAGE);
                User userById = storage.findById(id);
                if (userById == null) {
                    resp.sendRedirect("index.jsp");
                } else {
                    req.setAttribute(USER, userById);
                    req.getRequestDispatcher("update.jsp").forward(req, resp);
                }
            } else {
                req.getRequestDispatcher("users.jsp").forward(req, resp);
            }
        } catch (ServletException | IOException  e) {
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
            ValidateService storage = (ValidateService) req.getSession().getAttribute(STORAGE);
            User user = new User();
            user.setId(Integer.valueOf(req.getParameter(USER_ID)));
            user.setName(req.getParameter(USER_NAME));
            user.setLogin(req.getParameter(USER_LOGIN));
            user.setEmail(req.getParameter(USER_EMAIL));
            user.setCrateDate(storage.findById(Integer.valueOf(req.getParameter(USER_ID))).getCrateDate());
            storage.update(user);
            req.getRequestDispatcher("users.jsp").forward(req, resp);
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
            try {
                resp.sendRedirect("index.jsp");
            } catch (IOException exp) {
                LOGGER.error(exp.getMessage(), exp);
            }
        }
    }
}
