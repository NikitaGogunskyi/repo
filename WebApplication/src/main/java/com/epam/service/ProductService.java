package com.epam.service;

import com.epam.dao.ProductDAO;
import com.epam.dao.connectionDB.manager.OperationManager;
import com.epam.dao.connectionDB.manager.TransactionManager;
import com.epam.dao.query.QueryBuilder;
import com.epam.entity.Book;

import java.util.List;
import java.util.Map;

import static com.epam.constant.SQLQuery.GET_ALL_PRODUCTS;
import static com.epam.constant.SQLQuery.GET_PRODUCTS_COUNT;

public class ProductService {

    private OperationManager manager = new TransactionManager();
    private ProductDAO productDAO;

    public ProductService(ProductDAO productDAO) {
        this.productDAO = productDAO;
    }

    public List<Book> getProducts() {
        return manager.executeOperation(() -> productDAO.getAll());
    }

    public List<Book> getProducts(QueryBuilder query, int from, int amount) {
        query.setSelect(GET_ALL_PRODUCTS);
        query.setLimit(from, amount);
        return manager.executeOperation(() -> productDAO.getAll(query.build()));
    }

    public Map<String, String> getCategories() {
        return manager.executeOperation(() -> productDAO.getCategories());
    }

    public int getProductsAmount(QueryBuilder query) {
        query.setSelect(GET_PRODUCTS_COUNT);
        return manager.executeOperation(() -> productDAO.getAmount(query.build()));
    }
}
