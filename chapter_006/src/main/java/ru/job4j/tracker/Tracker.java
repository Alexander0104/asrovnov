package ru.job4j.tracker;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.Properties;
import java.util.Random;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * base class Tracker.
 * @author Alexander Rovnov.
 * @version 1.2
 * @since 1.2
 */
public class Tracker implements AutoCloseable {

    private static final String TRACKER_QUERIES = "db_conf.properties";
    private static final Logger LOGGER = LoggerFactory.getLogger(Tracker.class);
    private static final Random RN = new Random();
    private Properties props;
    private Connection conn;

    public void init() {
        try (InputStream reader = getClass().getClassLoader().getResourceAsStream(TRACKER_QUERIES)) {
            this.props = new Properties();
            this.props.load(reader);
            try (PreparedStatement pstmt = connect("create")) {
                pstmt.execute();
            }
        } catch (IOException | SQLException e) {
            LOGGER.error(e.getMessage(), e);
        } finally {
            this.close();
        }
    }

    private PreparedStatement connect(String query)  {
        PreparedStatement pstmt = null;
        try {
            this.conn = DriverManager.getConnection(
                    this.props.getProperty("url"),
                    this.props.getProperty("username"),
                    this.props.getProperty("password")
            );
            pstmt = this.conn.prepareStatement(
                    this.props.getProperty(query)
            );
        } catch (SQLException e) {
            LOGGER.error(e.getMessage(), e);
        }
        return pstmt;
    }

    /**
     * Метод add.
     * Метод добавления заявки в хранилище.
     * @param item новая заявка.
     */
    public Item add(Item item) {
        try (PreparedStatement pstmt = connect("add")) {
            if (item.getId() == null) {
                item.setId(this.generateId());
            }
            pstmt.setString(1, item.getId());
            pstmt.setString(2, item.getName());
            pstmt.setString(3, item.getDescription());
            pstmt.setString(4, item.getCreate());
            pstmt.setString(5, item.getComment());
            pstmt.execute();
        } catch (SQLException e) {
            LOGGER.error(e.getMessage(), e);
        } finally {
            close();
        }
        return item;
    }

    /**
     * Метод generateId.
     * Метод генерирует уникальный ключ для заявки.
     * Так как у заявки нет уникальности полей, имени и описание. Для идентификации нам нужен уникальный ключ.
     * @return Уникальный ключ.
     */
    private String generateId() {
        return String.valueOf(System.currentTimeMillis() + RN.nextInt(100));
    }

    /**
     * Метод findById.
     * Метод получения заявки по id.
     * @param id заявки.
     * @return Возвращет найденую заявку, если заявка не найдена возвращает null.
     */
    public Item findById(String id) {
        Item found = null;
        try (PreparedStatement pstmt = connect("findById")) {
            pstmt.setString(1, id);
            try (ResultSet rs = pstmt.executeQuery()) {
                rs.next();
                found = new Item(
                        rs.getString("name"),
                        rs.getString("description"),
                        rs.getString("created"),
                        rs.getString("comment")
                );
                found.setId(rs.getString("id"));
            }
        } catch (SQLException e) {
            LOGGER.error(e.getMessage(), e);
        } finally {
            close();
        }
        return found;
    }

    /**
     * Метод findAll.
     * Метод получения всех заявок.
     * @return возвращает копию массива this.items без null элементов.
     */
    public ArrayList<Item> findAll() {
        ArrayList<Item> result = new ArrayList<>();
        try (PreparedStatement pstmt = connect("findAll");
             ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                Item item = new Item(
                        rs.getString("name"),
                        rs.getString("description"),
                        rs.getString("created"),
                        rs.getString("comment")
                );
                item.setId(rs.getString("id"));
                result.add(item);
            }
        } catch (SQLException e) {
            LOGGER.error(e.getMessage(), e);
        } finally {
            close();
        }
        return result;
    }

    /**
     * Метод findByName.
     * Метод получения списка по имени.
     * @param key имя заявки
     * @return возвращает копию массива this.items с key(именами).
     */
    public ArrayList<Item> findByName(String key) {
        ArrayList<Item> list = new ArrayList<>();
        try (PreparedStatement pstmt = connect("findByName")) {
            pstmt.setString(1, key);
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    Item item = new Item(
                            rs.getString("name"),
                            rs.getString("description"),
                            rs.getString("created"),
                            rs.getString("comment")
                    );
                    item.setId(rs.getString("id"));
                    list.add(item);
                }
            }
        } catch (SQLException e) {
            LOGGER.error(e.getMessage(), e);
        } finally {
            close();
        }
        return list;
    }

    /**
     * Метод replace.
     * Метод замены заявки по id.
     * @param id заявки
     * @param item новая заявка.
     */
    public void replace(String id, Item item) {
        try (PreparedStatement pstmt = connect("update")) {
            pstmt.setString(1, item.getName());
            pstmt.setString(2, item.getDescription());
            pstmt.setString(3, item.getCreate());
            pstmt.setString(4, item.getComment());
            pstmt.setString(5, id);
            pstmt.execute();
        } catch (SQLException e) {
            LOGGER.error(e.getMessage(), e);
        } finally {
            close();
        }
    }

    /**
     * Метод delete.
     * Метод удаления заявки по id.
     * @param id заявки
     */
    public void delete(String id) {
        try (PreparedStatement pstmt = connect("delete")) {
            pstmt.setString(1, id);
            pstmt.execute();
        } catch (SQLException e) {
            LOGGER.error(e.getMessage(), e);
        } finally {
            close();
        }
    }

    @Override
    public void close() {
        try {
            if (this.conn != null) {
                this.conn.close();
            }
        } catch (SQLException e) {
            LOGGER.error(e.getMessage(), e);
        }
    }
}
