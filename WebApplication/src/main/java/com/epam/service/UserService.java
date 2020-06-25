package com.epam.service;

import com.epam.dao.UserDAO;
import com.epam.dao.connectionDB.manager.OperationManager;
import com.epam.dao.connectionDB.manager.TransactionManager;
import com.epam.entity.User;
import com.epam.exception.UserNotFoundException;

import java.util.Objects;

/**
 * Class <tt>UserService</tt> is layer between {@link com.epam.dao.DAO} and servlets.
 */
public class UserService {
    private OperationManager manager = new TransactionManager();
    private UserDAO userDAO;

    public UserService(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    public boolean isUserAlreadyExist(String email) {
        return Objects.nonNull(email) && manager.executeOperation(() -> userDAO.checkUserByEmail(email));
    }

    public User addUser(User user) {
        return manager.executeOperation(() -> userDAO.save(user));
    }

    public User getUser(String email, String password) throws UserNotFoundException {
        User user = manager.executeOperation(() -> userDAO.getUserByCredentials(email, password));
        if (Objects.nonNull(user)) {
            return user;
        } else {
            throw new UserNotFoundException();
        }
    }
}
