package com.epam.dao.connectionDB.manager.consumer;

import java.sql.SQLException;

@FunctionalInterface
public interface DAOConsumer<T> {
    T execute() throws SQLException;
}
