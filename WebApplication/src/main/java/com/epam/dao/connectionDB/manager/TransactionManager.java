package com.epam.dao.connectionDB.manager;

import com.epam.dao.connectionDB.manager.consumer.DAOConsumer;
import com.epam.util.ConnectionHolder;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.SQLException;

public class TransactionManager extends OperationManager {
    private static final Logger LOGGER = Logger.getLogger(TransactionManager.class);

    @Override
    public <T> T executeOperation(DAOConsumer<T> consumer) {
        Connection connection = null;
        T result = null;
        try {
            connection = getConnection();
            connection.setAutoCommit(false);
            connection.setTransactionIsolation(Connection.TRANSACTION_READ_COMMITTED);
            ConnectionHolder.set(connection);
            result = consumer.execute();
            connection.commit();
        } catch (SQLException e) {
            LOGGER.error(e);
            ConnectionHolder.rollback(connection);
        } finally {
            ConnectionHolder.set(null);
            ConnectionHolder.close(connection);
        }
        return result;
    }
}
