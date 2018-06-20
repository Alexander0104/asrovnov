package ru.job4j.crudservlet;

import java.sql.Timestamp;
import java.util.Objects;

/**
 * class User.
 * @author Alexander Rovnov.
 * @version 1.0
 * @since 1.0
 */
public class User {

    private int id;
    private String name;
    private String login;
    private String email;
    private Timestamp crateDate = new Timestamp(System.currentTimeMillis());

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
    public Timestamp getCrateDate() {
        return crateDate;
    }

    /**
     * Метод setCrateDate.
     * @param crateDate дата создания.
     */
    public void setCrateDate(Timestamp crateDate) {
        this.crateDate = crateDate;
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
                && Objects.equals(crateDate, user.crateDate);
    }

    /**
     * Метод hashCode.
     */
    @Override
    public int hashCode() {
        return Objects.hash(id, name, login, email, crateDate);
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
                + ", crateDate=" + crateDate
                + '}'
                + System.lineSeparator();
    }
}
