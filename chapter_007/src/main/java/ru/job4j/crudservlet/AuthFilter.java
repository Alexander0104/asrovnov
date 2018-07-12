package ru.job4j.crudservlet;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * class AuthFilter.
 * @author Alexander Rovnov.
 * @version 1.0
 * @since 1.0
 */
public class AuthFilter implements Filter {

    private static final Logger LOGGER = LogManager.getLogger("servlets");

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpSession session = request.getSession();
        try {
            if (!request.getRequestURI().contains("/signin") && session.getAttribute("loginRole") == null) {
                ((HttpServletResponse) resp).sendRedirect(String.format("%s/signin", request.getContextPath()));
            } else {
                chain.doFilter(req, resp);
            }
        } catch (ServletException | IOException e) {
            LOGGER.error(e.getMessage(), e);
        }

    }

    @Override
    public void destroy() {
    }
}
