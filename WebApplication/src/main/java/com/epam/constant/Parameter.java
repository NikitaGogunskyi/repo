package com.epam.constant;


/**
 * Class <tt>HTMLMessages</tt> shouldn't be inherited. It's used only for containing constants. Scope of class is containing
 * parameters for methods and functions.
 */
public class Parameter {
    //source links
    public static final String JDBC_MYSQL_DATABASE = "java:comp/env/jdbc/database";
    public static final String REPOSITORY_PATH = "src/main/webapp/WEB-INF/repository";
    public static final String AVATARS_SOURCE = "/avatars";
    //context parameters
    public static final String CAPTCHA_CONFIG = "captchaConfig";
    public static final String SESSION = "session";
    public static final String COOKIE = "cookies";
    public static final String HIDDEN_FIELD = "hiddenField";
    //request parameters
    public static final String NAME = "name";
    public static final String EMAIL = "email";
    public static final String PASSWORD = "password";
    public static final String REPEATED_PASSWORD = "repeatedPassword";
    public static final String AGREEMENT = "agreement";
    public static final String CAPTCHA = "captcha";
    public static final String AVATAR = "avatar";
    public static final String TIMEOUT = "timeout";

    public static final String UNCHECKED = "unchecked";
    public static final String CHECKED = "checked";
    public static final String CATEGORY = "category";
    public static final String ORDER_BY = "order";
    public static final String ITEMS = "items";
    public static final String KEY_WORD = "keyWord";
    public static final String MIN_COST = "minCost";
    public static final String MAX_COST = "maxCost";

    public static final String PRICE_LOW = "price, low to high";
    public static final String PRICE_HIGH = "price, high to low";

    public static final String FIELD = "field";
    public static final String ORDER = "order";
    public static final String PRICE = "price";
    public static final String PAGE = "page";
    public static final String PAGINATOR = "paginator";
    public static final String HIGH_TO_LOW = "high to low";
    public static final int DEFAULT_ITEMS_COUNT = 3;

    private Parameter() {
    }
}
