package com.epam.bean;

import com.epam.entity.User;

import javax.imageio.ImageIO;
import javax.servlet.http.Part;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import static com.epam.constant.Message.*;
import static com.epam.constant.Parameter.*;
import static com.epam.constant.Regex.*;

/**
 * Class <tt>FormBean</tt> is POJO for registration form. Provides methods to set and validate information to register user`s
 * account correctly. Contains Map {@link HashMap} of errors for users, witch will inform him about mistakes.
 */
public class FormBean {

    private Map<String, String> errors = new HashMap<>();
    private String name;
    private String email;
    private String password;
    private boolean agreement;
    private BufferedImage avatar;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name.matches(NAME_REGEX)) {
            this.name = name;
        } else {
            errors.put(NAME, NAME_ERROR_MESSAGE);
        }
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        if (email.matches(EMAIL_REGEX)) {
            this.email = email;
        } else {
            errors.put(EMAIL, EMAIL_ERROR_MESSAGE);
        }
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password, String repeatedPassword) {
        if (password.matches(PASSWORD_REGEX)) {
            if (repeatedPassword.equals(password)) {
                this.password = password;
            } else {
                errors.put(REPEATED_PASSWORD, REPEATED_PASSWORD_ERROR_MESSAGE);
            }
        } else {
            errors.put(PASSWORD, PASSWORD_ERROR_MESSAGE);
        }
    }

    public void setAgreement(String agreement) {
        try {
            this.agreement = agreement.equals("on");
        } catch (NullPointerException e) {
            errors.put(AGREEMENT, AGREEMENT_ERROR);
        }
    }

    public BufferedImage getAvatar() {
        return avatar;
    }

    public void setAvatar(Collection<Part> parts) throws IOException {
        Optional<Part> part = parts.stream().filter(item -> AVATAR.equals(item.getName()) &&
                item.getSize() > 0 &&
                item.getContentType().equals("image/jpeg")).findFirst();
        if (part.isPresent()) {
            InputStream fileContent = part.get().getInputStream();
            this.avatar = ImageIO.read(fileContent);
        } else {
            errors.put(AVATAR, AVATAR_ERROR_MESSAGE);
        }
    }

    public Map<String, String> getErrors() {
        return errors;
    }

    public void putError(String key, String value) {
        errors.put(key, value);
    }

    /**
     * method should be invoked to check established values
     *
     * @return true if field values are correct and registration rules were observed.
     */
    public boolean isValid() {
        return errors.isEmpty() & agreement;
    }

    /**
     * create object of specified type if fields values are correct
     *
     * @return {@link User}
     */
    public User createUser() {
        if (!isValid()) {
            throw new IllegalArgumentException();
        }
        return new User(name, email, password);
    }
}