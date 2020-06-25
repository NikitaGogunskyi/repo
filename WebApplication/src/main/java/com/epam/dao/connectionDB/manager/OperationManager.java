package com.epam.dao.connectionDB.manager;

import com.epam.dao.connectionDB.DBCPDataSource;
import com.epam.dao.connectionDB.manager.consumer.DAOConsumer;

import java.sql.Connection;
import java.sql.SQLException;

public abstract class OperationManager {
    private static final DBCPDataSource connectionPool = new DBCPDataSource();

    public abstract <T> T executeOperation(DAOConsumer<T> consumer);

    protected Connection getConnection() throws SQLException {
        try {
            return connectionPool.getConnection();
        } catch (SQLException e) {
            throw new SQLException(e);
        }
    }
}
