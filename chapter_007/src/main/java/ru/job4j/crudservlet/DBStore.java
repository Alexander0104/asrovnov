package ru.job4j.crudservlet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.Properties;

public class DBStore implements Store {

    private static final String QUERIES = "config.properties";
    private static final Logger LOGGER = LoggerFactory.getLogger(DBStore.class);
    private static final DBStore INSTANCE = new DBStore();
    private Properties props;
    private Connection conn;

    public DBStore() {
        try (InputStream reader = getClass().getClassLoader().getResourceAsStream(QUERIES)) {
            this.props = new Properties();
            this.props.load(reader);
            try (PreparedStatement pstmt = connect("create")) {
                pstmt.execute();
            }
        } catch (IOException | SQLException e) {
            LOGGER.error(e.getMessage(), e);
        }
    }

    public static DBStore getInstance() {
        return INSTANCE;
    }

    private PreparedStatement connect(String query)  {
        PreparedStatement pstmt = null;
        try (InputStream reader = getClass().getClassLoader().getResourceAsStream(QUERIES)) {
            Class.forName("org.postgresql.Driver");
            this.props = new Properties();
            this.props.load(reader);
            this.conn = DriverManager.getConnection(
                    this.props.getProperty("url"),
                    this.props.getProperty("username"),
                    this.props.getProperty("password")
            );
            pstmt = this.conn.prepareStatement(
                    this.props.getProperty(query)
            );
        } catch (ClassNotFoundException | IOException | SQLException e) {
            LOGGER.error(e.getMessage(), e);
        }
        return pstmt;
    }


    @Override
    public void add(User user) {
        if (user != null) {
            try (PreparedStatement pstmt = connect("add")) {
                pstmt.setInt(1, user.getId());
                pstmt.setString(2, user.getName());
                pstmt.setString(3, user.getLogin());
                pstmt.setString(4, user.getEmail());
                pstmt.setTimestamp(5, user.getCrateDate());
                pstmt.execute();
            } catch (SQLException e) {
                LOGGER.error(e.getMessage(), e);
            }
        } else {
            LOGGER.error("Попытка добавить нулевого пользователя.");
        }
    }

    @Override
    public void update(User user) {
        if (user != null) {
            try (PreparedStatement pstmt = connect("update")) {
                pstmt.setString(1, user.getName());
                pstmt.setString(2, user.getLogin());
                pstmt.setString(3, user.getEmail());
                pstmt.setInt(4, user.getId());
                pstmt.executeUpdate();
            } catch (SQLException e) {
                LOGGER.error(e.getSQLState(), e);
            }
        } else {
            LOGGER.error("Попытка обновить нулевого пользователя.");
        }
    }

    @Override
    public void delete(int id) {
        if (id >= 0) {
            try (PreparedStatement pstmt = connect("delete")) {
                pstmt.setInt(1, id);
                pstmt.executeUpdate();
            } catch (SQLException e) {
                LOGGER.error(e.getSQLState(), e);
            }
        } else {
            LOGGER.error("Попытка удалить пользователя с отрицательным id.");
        }
    }

    @Override
    public Collection<User> findAll() {
        List<User> result = new LinkedList<>();
        User user;
        try (PreparedStatement pstmt = connect("findAll")) {
            ResultSet resultSet = pstmt.executeQuery();
            while (resultSet.next()) {
                user = new User();
                user.setId(Integer.valueOf(resultSet.getInt("id")));
                user.setName(resultSet.getString("name"));
                user.setLogin(resultSet.getString("login"));
                user.setEmail((resultSet.getString("email")));
                user.setCrateDate(resultSet.getTimestamp("date"));
                result.add(user);
            }
        } catch (SQLException e) {
            LOGGER.error(e.getSQLState(), e);
        }
        return result;
    }

    @Override
    public User findById(int id) {
        User user = null;
        if (id >= 0) {
            try (PreparedStatement pstmt = connect("findById")) {
                pstmt.setInt(1, id);
                ResultSet resultSet = pstmt.executeQuery();
                while (resultSet.next()) {
                    user = new User();
                    user.setId(Integer.valueOf(resultSet.getInt("id")));
                    user.setName(resultSet.getString("name"));
                    user.setLogin(resultSet.getString("login"));
                    user.setEmail((resultSet.getString("email")));
                    user.setCrateDate(resultSet.getTimestamp("date"));
                }
            } catch (SQLException e) {
                LOGGER.error(e.getSQLState(), e);
            }
        } else {
            LOGGER.error("Отрицательный id");
        }
        return user;
    }
}
