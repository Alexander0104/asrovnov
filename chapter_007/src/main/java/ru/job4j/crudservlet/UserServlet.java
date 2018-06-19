package ru.job4j.crudservlet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * class UserServlet.
 * @author Alexander Rovnov.
 * @version 1.0
 * @since 1.0
 */
public class UserServlet extends HttpServlet {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserServlet.class);
    private ValidateService service = ValidateService.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        req.setAttribute("all", service.findAll());
        PrintWriter writer = new PrintWriter(resp.getWriter());
        writer.write(req.getAttribute("all").toString());
        writer.flush();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        switch (req.getParameter("action")) {
            case "userById":
                User user = new User();
                user.setId(Integer.valueOf(req.getParameter("id")));
                user.setName(req.getParameter("name"));
                user.setLogin(req.getParameter("login"));
                user.setEmail(req.getParameter("email"));
                user.setCrateDate(user.getCrateDate());
                if (!service.add(user)) {
                    LOGGER.error("User with same id is already existed");
                }
                break;
            case "update":
                User updateUser = new User();
                updateUser.setId(Integer.valueOf(req.getParameter("id")));
                updateUser.setName(req.getParameter("name"));
                updateUser.setLogin(req.getParameter("login"));
                updateUser.setEmail(req.getParameter("email"));
                if (!service.update(updateUser)) {
                    LOGGER.error("");
                }
                break;
            case "delete":
                if (!service.delete(Integer.valueOf(req.getParameter("id")))) {
                    LOGGER.error("");
                }
                break;
            case "find":
                User byId = service.findById(Integer.valueOf(req.getParameter("id")));
                if (byId != null) {
                    req.setAttribute("userById", byId);
                    PrintWriter writer = new PrintWriter(resp.getWriter());
                    writer.write(req.getAttribute("userById").toString());
                    writer.flush();
                } else {
                    LOGGER.error("");
                }
                break;
            default:
                LOGGER.error("");
                break;
        }
    }

}
