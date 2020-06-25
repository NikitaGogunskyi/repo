package com.epam.dao;

import com.epam.constant.SQLQuery;
import com.epam.entity.User;
import com.epam.util.ConnectionHolder;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

/**
 * Class <tt>UserDAO</tt> is implementation of {@link DAO} for process user's data flow.
 */
public class UserDAO implements DAO<User> {

    /**
     * Method is used to check email for uniqueness.
     *
     * @param email - entered user's email
     * @return true if email isn't already exists
     */
    public boolean checkUserByEmail(String email) throws SQLException {
        String sql = SQLQuery.GET_USERS_BY_EMAIL;
        boolean result = false;
        PreparedStatement statement = ConnectionHolder.get().prepareStatement(sql);
        statement.setString(1, email);
        ResultSet rs = statement.executeQuery();
        if (rs.next()) {
            result = true;
        }
        return result;
    }

    @Override
    public User get(long id) {
        return null;
    }

    @Override
    public List<User> getAll() {
        return null;
    }

    @Override
    public User save(User user) throws SQLException {
        String sql = SQLQuery.ADD_USER;
        PreparedStatement statement = ConnectionHolder.get().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        statement.setString(1, user.getName());
        statement.setString(2, user.getEmail());
        statement.setString(3, user.getPassword());
        statement.executeUpdate();
        ResultSet rs = statement.getGeneratedKeys();
        if (rs.next()) {
            user.setId(rs.getInt(1));
        }
        return user;
    }

    @Override
    public User delete(User user) {
        return null;
    }

    public User getUserByCredentials(String email, String password) throws SQLException {
        String sql = SQLQuery.GET_USERS_BY_CREDENTIALS;
        User user = null;
        PreparedStatement statement = ConnectionHolder.get().prepareStatement(sql);
        statement.setString(1, email);
        ResultSet rs = statement.executeQuery();
        if (rs.next()) {
            if (rs.getString(4).equals(password)) {
                user = new User(rs.getString(2), rs.getString(3), rs.getString(4));
                user.setId(rs.getInt(1));
            }
        }
        return user;
    }
}