package com.epam.constant;

/**
 * Class <tt>Regex</tt> shouldn't be inherited. It's used only for containing constants. Scope of class is containing regex for
 * validation.
 */
public class Regex {

    public static final String NAME_REGEX = "^[a-zA-Z]+([',. -][a-zA-Z]{2,}){1,}$";
    public static final String EMAIL_REGEX = "^(([^<>()\\[\\]\\\\.,;:\\s@\"]+(\\.[^<>()\\[\\]\\\\.,;:\\s@\"]+)*)|(\".+\"))@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";
    public static final String PASSWORD_REGEX = "^(?=.*[A-Z])(?=.*[0-9])\\w{8,16}$";
    public static final String NUMBER_REGEX = "^\\d+$";
    public static final String SORT_REGEX = "^(?<field>\\w+)\\,\\s(?<order>.*)";

    private Regex() {
    }
}
