package com.epam.dao;

import com.epam.constant.SQLQuery;
import com.epam.entity.Book;
import com.epam.util.ConnectionHolder;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.epam.constant.Parameter.UNCHECKED;

public class ProductDAO implements DAO<Book> {

    @Override
    public Book get(long id) {
        return null;
    }

    @Override
    public List<Book> getAll() throws SQLException {
        PreparedStatement statement = ConnectionHolder.get().prepareStatement(SQLQuery.GET_ALL_PRODUCTS);
        ResultSet rs = statement.executeQuery();
        return getProducts(rs);
    }

    @Override
    public Book save(Book book) {
        return null;
    }

    @Override
    public Book delete(Book book) {
        return null;
    }

    public Map<String, String> getCategories() throws SQLException {
        Map<String, String> categories = new HashMap<>();
        PreparedStatement statement = ConnectionHolder.get().prepareStatement(SQLQuery.GET_ALL_CATEGORIES);
        ResultSet rs = statement.executeQuery();
        while (rs.next()) {
            categories.put(rs.getString(1), UNCHECKED);
        }
        return categories;
    }

    public List<Book> getAll(String query) throws SQLException {
        PreparedStatement statement = ConnectionHolder.get().prepareStatement(query);
        ResultSet rs = statement.executeQuery();
        return getProducts(rs);
    }

    public int getAmount(String query) throws SQLException {
        PreparedStatement statement = ConnectionHolder.get().prepareStatement(query);
        ResultSet rs = statement.executeQuery();
        if (rs.next()) {
            return rs.getInt(1);
        }
        return 0;
    }

    private List<Book> getProducts(ResultSet rs) throws SQLException {
        List<Book> products = new ArrayList<>();
        while (rs.next()) {
            Book book = new Book();
            book.setId(rs.getLong(1));
            book.setTitle(rs.getString(2));
            book.setAuthor(rs.getString(3));
            book.setDescription(rs.getString(4));
            book.setCost(rs.getBigDecimal(5));
            book.setPublicationDate(rs.getDate(6));
            book.setPublisher(rs.getString(7));
            book.setCategory(rs.getString(8));
            products.add(book);
        }
        return products;
    }
}
