package com.epam.constant;

public class SQLQuery {

    public static final String GET_USERS_BY_EMAIL = "SELECT email FROM app_db.user WHERE email=?;";
    public static final String GET_USERS_BY_CREDENTIALS = "SELECT * FROM app_db.user WHERE email=?;";
    public static final String GET_ALL_CATEGORIES = "SELECT category.name FROM app_db.category;";
    public static final String GET_ALL_PRODUCTS = "SELECT * FROM app_db.v_book";
    public static final String GET_PRODUCTS_COUNT = "SELECT count(*) FROM app_db.v_book";


    public static final String COST_FIELD = "v_book.cost";
    public static final String CATEGORY_FIELD = "v_book.category";
    public static final String TITLE_FIELD = "v_book.title";
    public static final String AUTHOR_FIELD = "v_book.author";


    public static final String ADD_USER = "INSERT INTO app_db.user VALUES(default, ?, ?, ?);";

    private SQLQuery() {
    }
}
