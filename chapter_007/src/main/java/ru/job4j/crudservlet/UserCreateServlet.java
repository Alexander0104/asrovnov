package ru.job4j.crudservlet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * class UserCreateServlet.
 * @author Alexander Rovnov.
 * @version 1.2
 * @since 1.2
 */
public class UserCreateServlet extends HttpServlet {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserCreateServlet.class);
    private static final String STORAGE = "storage";
    private static final String USER_ID = "id";
    private static final String USER_NAME = "name";
    private static final String USER_LOGIN = "login";
    private static final String USER_EMAIL = "email";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        try {
            RequestDispatcher page = req.getRequestDispatcher("create.jsp");
            if (page != null) {
                page.forward(req, resp);
            } else {
                req.getRequestDispatcher("index.jsp").forward(req, resp);
            }
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
            try {
                req.getRequestDispatcher("index.jsp").forward(req, resp);
            } catch (ServletException | IOException exp) {
                LOGGER.error(e.getMessage(), exp);
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        try {
            ValidateService storage = (ValidateService) req.getSession().getAttribute(STORAGE);
            if (storage == null) {
                storage = ValidateService.getInstance();
            }
            String userId = req.getParameter(USER_ID);
            User user = new User();
            user.setId(Integer.valueOf(userId));
            user.setName(req.getParameter(USER_NAME));
            user.setLogin(req.getParameter(USER_LOGIN));
            user.setEmail(req.getParameter(USER_EMAIL));
            if (storage.add(user)) {
                req.getSession().setAttribute(STORAGE, storage);
                req.setAttribute("userInfo", "Новый пользователь был успешно создан");
                req.getRequestDispatcher("create.jsp").forward(req, resp);
                doGet(req, resp);
            } else {
                req.setAttribute("userInfo", "Пользователь с id: " + userId + " существует. "
                        + "Новый пользователь не был создан. выберите новое id");
                req.getRequestDispatcher("create.jsp").forward(req, resp);
            }
        } catch (IllegalArgumentException | ServletException | IOException e) {
            LOGGER.error(e.getMessage(), e);
            req.setAttribute("userInfo", "Проверьте данные");
            try {
                req.getRequestDispatcher("create.jsp").forward(req, resp);
            } catch (ServletException | IOException exp) {
                LOGGER.error(exp.getMessage(), exp);
            }
        }
    }
}
