package ru.job4j.crudservlet;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import ru.job4j.crudservlet.UserServlet.Message.Type;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.*;
import java.util.function.Function;

import java.io.IOException;

/**
 * class UserServlet.
 * @author Alexander Rovnov.
 * @version 1.3
 * @since 1.3
 */
public class UserServlet extends HttpServlet {

    private final static Logger LOGGER = LogManager.getLogger("servlets");
    private final ValidateService validator = ValidateService.getInstance();
    private final DispatchPattern dispatch = new DispatchPattern();

    @Override
    public void init() {
        this.dispatch.init();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        resp.setContentType("text/html");
        try {
            PrintWriter writer = new PrintWriter(resp.getOutputStream());
            writer.append("Все пользователи:");
            for (User currentUser : this.validator.findAll()) {
                writer.println(String.format(
                        "Id: %s, Name: %s, Login: %s, Email: %s",
                        currentUser.getId(), currentUser.getName(), currentUser.getLogin(),
                        currentUser.getEmail()
                ));
            }
            writer.flush();
        } catch (IOException e) {
            LOGGER.error(e.getMessage(), e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        Message msg = new Message(
                req.getParameter("action"),
                req.getParameter("id"),
                req.getParameter("name"),
                req.getParameter("login"),
                req.getParameter("email")
        );
        try {
            PrintWriter writer = new PrintWriter(resp.getOutputStream());
            resp.setContentType("text/html");
            if (this.dispatch.sent(msg)) {
                writer.append("Готово");
            } else {
                writer.append("Действие не выполнено");
            }
            writer.flush();
        } catch (IOException e) {
            LOGGER.error(e.getMessage(), e);
        }

    }

    public class DispatchPattern {

        private final Map<Message.Type, Function<Message, Boolean>> dispatch = new HashMap<>();

        Function<Message, Boolean> addUser() {
            return message -> validator.add(new User(message));
        }

        Function<Message, Boolean> updateUser() {
            return message -> validator.update(new User(message));
        }

        Function<Message, Boolean> deleteUser() {
            return message -> validator.delete(Integer.parseInt(message.getId()));
        }

        void load(Type type, Function<Message, Boolean> handle) {
            this.dispatch.put(type, handle);
        }

        void init() {
            this.load(Type.ADD, this.addUser());
            this.load(Type.DELETE, this.deleteUser());
            this.load(Type.UPDATE, this.updateUser());
        }

        boolean sent(final Message msg) {
            return this.dispatch.get(msg.getType()).apply(msg);
        }
    }

    static class Message {

        private Type type;
        private String id;
        private String name;
        private String login;
        private String email;
        private Calendar createDate = new GregorianCalendar();

        Message(String type, String id, String name, String login, String email) {
            this.type = Enum.valueOf(Type.class, type.toUpperCase());
            this.id = id;
            this.name = name;
            this.login = login;
            this.email = email;
            this.createDate.setTime(new Date());
        }

        enum Type {
            ADD,
            UPDATE,
            DELETE
        }

        public String getId() {
            return this.id;
        }

        public String getName() {
            return name;
        }

        public String getLogin() {
            return login;
        }

        public String getEmail() {
            return email;
        }

        public Calendar getCreateDate() {
            return this.createDate;
        }

        public Type getType() {
            return this.type;
        }
    }
}
