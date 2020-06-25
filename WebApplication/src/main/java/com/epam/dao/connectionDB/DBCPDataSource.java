package com.epam.dao.connectionDB;

import org.apache.log4j.Logger;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

import static com.epam.constant.Parameter.JDBC_MYSQL_DATABASE;

public class DBCPDataSource {
    private static final Logger LOGGER = Logger.getLogger(DBCPDataSource.class);
    private DataSource ds;

    public DBCPDataSource() {
        try {
            ds = (DataSource) new InitialContext().lookup(JDBC_MYSQL_DATABASE);
        } catch (NamingException e) {
            LOGGER.error("Failed to connect." + e);
        }
    }

    public Connection getConnection() throws SQLException {
        return ds.getConnection();
    }
}
