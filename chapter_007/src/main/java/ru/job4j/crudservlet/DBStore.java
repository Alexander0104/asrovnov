package ru.job4j.crudservlet;

import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.List;
import java.util.Properties;
import java.util.*;

/**
 * class DBStore.
 * @author Alexander Rovnov.
 * @version 1.2
 * @since 1.2
 */
public class DBStore implements Store {

    private static final Logger LOGGER = LogManager.getLogger("servlets");
    private static final BasicDataSource SOURCE = new BasicDataSource();
    private static final DBStore INSTANCE = new DBStore();
    private static final Properties PROPS = new Properties();

    private DBStore() {
    }

    public static DBStore getInstance() {
        return INSTANCE;
    }

    static {
        try (InputStream stream = DBStore.class.getClassLoader()
                .getResourceAsStream("config.properties")) {
            PROPS.load(stream);
        } catch (IOException e) {
            LOGGER.error(e.getMessage(), e);
        }
        SOURCE.setDriverClassName("org.postgresql.Driver");
        SOURCE.setUrl(PROPS.getProperty("url"));
        SOURCE.setUsername(PROPS.getProperty("username"));
        SOURCE.setPassword(PROPS.getProperty("password"));
        SOURCE.setMinIdle(5);
        SOURCE.setMaxIdle(10);
        SOURCE.setMaxOpenPreparedStatements(100);
        createTable();
    }

    private static void createTable() {
        try (Connection connect = SOURCE.getConnection();
             Statement st = connect.createStatement()) {
            st.execute(PROPS.getProperty("create"));
            st.execute(PROPS.getProperty("root"));
            st.execute(PROPS.getProperty("index"));
        } catch (SQLException e) {
            LOGGER.error(e.getMessage(), e);
        }
    }

    @Override
    public void add(User user) {
        try (Connection connect = SOURCE.getConnection();
             PreparedStatement st = connect.prepareStatement(
                     PROPS.getProperty("add")
             )) {
            st.setString(1, user.getName());
            st.setString(2, user.getLogin());
            st.setString(3, user.getEmail());
            st.setTimestamp(4, new Timestamp(user.getCreateDate().getTimeInMillis()));
            st.setString(5, user.getPassword());
            st.setString(6, user.getRole());
            st.execute();
        } catch (SQLException e) {
            LOGGER.error(e.getMessage(), e);
        }
    }

    @Override
    public void update(User newUser) {
        try (Connection con = SOURCE.getConnection();
             PreparedStatement st = con.prepareStatement(
                     PROPS.getProperty("update")
             )) {
            st.setString(1, newUser.getName());
            st.setString(2, newUser.getLogin());
            st.setString(3, newUser.getEmail());
            st.setString(4, newUser.getPassword());
            st.setString(5, newUser.getRole());
            st.setInt(6, newUser.getId());
            st.execute();
        } catch (SQLException e) {
            LOGGER.error(e.getMessage(), e);
        }
    }

    @Override
    public void delete(int userId) {
        try (Connection con = SOURCE.getConnection();
             PreparedStatement st = con.prepareStatement(
                     PROPS.getProperty("delete")
             )) {
            st.setInt(1, userId);
            st.execute();
        } catch (SQLException e) {
            LOGGER.error(e.getMessage(), e);
        }
    }

    private User createUser(ResultSet rst) throws SQLException {
        User user = new User();
        user.setId(rst.getInt("id"));
        user.setName(rst.getString("name"));
        user.setLogin(rst.getString("login"));
        user.setEmail(rst.getString("email"));
        Calendar createDate = new GregorianCalendar();
        createDate.setTimeInMillis(
                rst.getTimestamp("date").getTime()
        );
        user.setCreateDate(createDate);
        user.setPassword(rst.getString("password"));
        user.setRole(rst.getString("role"));
        return user;
    }

    @Override
    public List<User> findAll() {
        List<User> resultList = new ArrayList<>();
        try (Connection con = SOURCE.getConnection();
             Statement st = con.createStatement();
             ResultSet rst = st.executeQuery(PROPS.getProperty("findAll"))) {
            while (rst.next()) {
                resultList.add(this.createUser(rst));
            }
        } catch (SQLException e) {
            LOGGER.error(e.getMessage(), e);
        }
        return resultList;
    }

    @Override
    public User findById(int id) {
        User user = null;
        try (Connection con = SOURCE.getConnection();
             PreparedStatement st = con.prepareStatement(PROPS.getProperty("findById"))) {
            st.setInt(1, id);
            try (ResultSet rstSet = st.executeQuery()) {
                if (rstSet.next()) {
                    user = this.createUser(rstSet);
                }
            }
        } catch (SQLException e) {
            LOGGER.error(e.getMessage(), e);
        }
        return user;
    }

    @Override
    public User findByLogin(String login) {
        User foundUser = null;
        try (Connection connect = SOURCE.getConnection();
             PreparedStatement st = connect.prepareStatement(
                     PROPS.getProperty("findByLogin")
             )) {
            st.setString(1, login);
            try (ResultSet rstSet = st.executeQuery()) {
                if (rstSet.next()) {
                    foundUser = this.createUser(rstSet);
                }
            }
        } catch (SQLException e) {
            LOGGER.error(e.getMessage(), e);
        }
        return foundUser;
    }

}
