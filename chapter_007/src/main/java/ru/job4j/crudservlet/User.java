package ru.job4j.crudservlet;

import java.util.Calendar;
import java.util.Objects;

/**
 * class User.
 * @author Alexander Rovnov.
 * @version 1.1
 * @since 1.1
 */
public class User {

    private int id;
    private String name;
    private String login;
    private String email;
    private Calendar createDate;

    public User() {
    }

    public User(String name, String login, String email) {
        this.name = name;
        this.login = login;
        this.email = email;
    }

    public User(UserServlet.Message msg) {
        this.id = Integer.parseInt(msg.getId());
        this.name = msg.getName();
        this.login = msg.getLogin();
        this.email = msg.getEmail();
        this.createDate = msg.getCreateDate();
    }

    /**
     * Метод getId.
     * @return id пользователя.
     */
    public int getId() {
        return id;
    }

    /**
     * Метод setId.
     * @param id пользователя.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Метод getName.
     * @return name пользователя.
     */
    public String getName() {
        return name;
    }

    /**
     * Метод setName.
     * @param name пользователя.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Метод getLogin.
     * @return login пользователя.
     */
    public String getLogin() {
        return login;
    }

    /**
     * Метод setLogin.
     * @param login пользователя.
     */
    public void setLogin(String login) {
        this.login = login;
    }

    /**
     * Метод getEmail.
     * @return email пользователя.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Метод setEmail.
     * @param email пользователя.
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Метод getCrateDate.
     * @return crateDate дата создания.
     */
    public Calendar getCreateDate() {
        return this.createDate;
    }

    /**
     * Метод setCrateDate.
     * @param createDate дата создания.
     */
    public void setCreateDate(Calendar createDate) {
        this.createDate = createDate;
    }

    /**
     * Метод equals.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        User user = (User) o;
        return id == user.id
                && Objects.equals(name, user.name)
                && Objects.equals(login, user.login)
                && Objects.equals(email, user.email)
                && Objects.equals(createDate, user.createDate);
    }

    /**
     * Метод hashCode.
     */
    @Override
    public int hashCode() {
        return Objects.hash(id, name, login, email, createDate);
    }

    /**
     * Метод toString.
     */
    @Override
    public String toString() {
        return "User{"
                + "id=" + id
                + ", name='" + name + '\''
                + ", login='" + login + '\''
                + ", email='" + email + '\''
                + ", crateDate=" + createDate
                + '}'
                + System.lineSeparator();
    }
}
