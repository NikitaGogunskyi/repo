package com.epam.dao;


import java.sql.SQLException;
import java.util.List;

/**
 * The <tt>DAO</tt> interface is used for creation objects of specifies classes. The user of this interface has the ability to
 * produce CRUD operations with data storage.
 *
 * @author Mykyta_Hohunskyi
 */

public interface DAO<T> {

    T get(long id);

    List<T> getAll() throws SQLException;

    T save(T t) throws SQLException;

    T delete(T t);
}

