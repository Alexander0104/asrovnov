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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Timestamp getCrateDate() {
        return crateDate;
    }

    public void setCrateDate(Timestamp crateDate) {
        this.crateDate = crateDate;
    }

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

    @Override
    public int hashCode() {
        return Objects.hash(id, name, login, email, crateDate);
    }

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
