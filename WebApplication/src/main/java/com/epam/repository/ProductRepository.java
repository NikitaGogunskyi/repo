package com.epam.repository;

import com.epam.bean.FilterBean;
import com.epam.constant.Regex;
import com.epam.dao.query.QueryBuilder;
import com.epam.dao.query.SQLQueryBuilder;
import com.epam.entity.Book;

import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.epam.constant.Parameter.*;
import static com.epam.constant.SQLQuery.*;

public class ProductRepository implements Repository<Book> {
    private List<Book> books;


    @Override
    public void sort(Comparator<Book> comparator) {
        books.sort(comparator);
    }


    @Override
    public List<Book> get() {
        return books;
    }

    @Override
    public List<Book> getSpecified() {
        return null;
    }
}