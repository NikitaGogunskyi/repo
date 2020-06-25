package com.epam.util;

import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Objects;

public class ConnectionHolder {
    private static final Logger LOGGER = Logger.getLogger(ConnectionHolder.class);
    private static ThreadLocal<Connection> holder = new ThreadLocal<>();

    public static Connection get() {
        return holder.get();
    }

    public static void set(Connection connection) {
        holder.set(connection);
    }

    public static void rollback(Connection connection) {
        try {
            Objects.requireNonNull(connection).rollback();
        } catch (SQLException | NullPointerException e) {
            LOGGER.error(e);
        }
    }

    public static void close(Connection connection) {
        try {
            if (!Objects.requireNonNull(connection).isClosed()) {
                connection.close();
            }
        } catch (SQLException | NullPointerException e) {
            LOGGER.error(e);
        }
    }
}
