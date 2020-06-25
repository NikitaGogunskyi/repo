package com.epam.constant;

/**
 * Class <tt>HTMLMessages</tt> shouldn't be inherited. It's used only for containing constants. Scope of class is containing regex
 * for html messages.
 */
public class Message {

    public static final String NAME_ERROR_MESSAGE = "* Enter your full name";
    public static final String PASSWORD_ERROR_MESSAGE = "* Your password does not conform to secure requirements";
    public static final String EMAIL_ERROR_MESSAGE = "* Wrong format of email";
    public static final String AVATAR_ERROR_MESSAGE = "* Image wasn't uploaded";
    public static final String REPEATED_PASSWORD_ERROR_MESSAGE = "* Passwords does not match";
    public static final String EXISTING_USER_ERROR = "This email is already used by another user. Enter another one";
    public static final String AGREEMENT_ERROR = "color: red;";
    public static final String CAPTCHA_ERROR = "border-color: red;";
    public static final String INVALID_AUTHORIZATION = "Invalid username/password!";

    private Message() {
    }
}
