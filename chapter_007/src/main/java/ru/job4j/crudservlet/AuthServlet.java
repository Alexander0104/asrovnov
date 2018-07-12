package ru.job4j.crudservlet;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;

/**
 * class AuthServlet.
 * @author Alexander Rovnov.
 * @version 1.0
 * @since 1.0
 */
public class AuthServlet extends HttpServlet {

    private static final Logger LOGGER = LogManager.getLogger("servlets");
    private ValidateService validator = ValidateService.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        try {
            req.getRequestDispatcher("/WEB-INF/views/auth.jsp").forward(req, resp);
        } catch (ServletException | IOException e) {
            LOGGER.error(e.getMessage(), e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        String action = req.getParameter("action");
        try {
            if (action.equals("signin")) {
                String login = req.getParameter("login");
                String password = req.getParameter("password");
                User foundUser = this.validator.findByLogin(login);
                if (foundUser != null && foundUser.getPassword().equals(password)) {
                    req.getSession().setAttribute("loginRole", new Login(foundUser));
                    resp.sendRedirect(String.format("%s/list", req.getContextPath()));
                } else {
                    req.setAttribute("error", "Неправильный логин или пароль");
                    req.getRequestDispatcher("/WEB-INF/views/auth.jsp").forward(req, resp);
                }
            } else if (req.getParameter("action").equals("signout")) {
                req.getSession().invalidate();
                resp.sendRedirect(String.format("%s/signin", req.getContextPath()));
            }
        } catch (ServletException | IOException e) {
            LOGGER.error(e.getMessage(), e);
        }
    }

    public class Login {
        String login;
        String role;

        public Login(User user) {
            this.login = user.getLogin();
            this.role = user.getRole();
        }

        public String getLogin() {
            return login;
        }

        public String getRole() {
            return role;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            Login loginRole = (Login) o;
            return Objects.equals(login, loginRole.login)
                    && Objects.equals(role, loginRole.role);
        }

        @Override
        public int hashCode() {
            return Objects.hash(login, role);
        }
    }
}
