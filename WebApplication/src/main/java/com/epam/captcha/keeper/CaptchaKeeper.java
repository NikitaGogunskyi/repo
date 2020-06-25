package com.epam.captcha.keeper;

import nl.captcha.Captcha;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

/**
 * Abstract class <tt>CaptchaKeeper</tt> is responsible for handling captcha {@link Captcha} generated for user's registration. It
 * provides methods to save captcha by spacial key, witch confirms that captcha is the lasts generated one, and present it for
 * checking user's answer. Also set timeout for captcha confirmation. If time was out - captcha would be deleted.
 * <p>
 * Class provides and obliges to override two methods for sending key and checking user answer in specified way.
 */
public abstract class CaptchaKeeper {

    private Map<String, Captcha> captchaStorage = new HashMap<>();
    private Long timeout;
    private String currentKey;

    /**
     * Construct object of specified type.
     *
     * @param timeout is time to captcha should live
     */
    public CaptchaKeeper(Long timeout) {
        this.timeout = timeout;
    }

    public void putCaptcha(Captcha captcha) {
        captchaStorage.put(currentKey, captcha);
    }

    /**
     * Generate key for captcha keeping
     */
    public void generateKey() {
        Date date = new Date();
        currentKey = date.toString();
    }

    /**
     * @return relevant key
     */
    public String getCurrentKey() {
        return currentKey;
    }

    /**
     * Method is used to get captcha to check user's answer.
     *
     * @param key - received key by client
     * @return current captcha {@link Captcha}
     */
    public Captcha getCaptcha(String key) {
        checkTimeout();
        return captchaStorage.get(key);
    }

    /**
     * Method deletes captcha from storage if it's outdated.
     */
    private void checkTimeout() {
        Set<String> keys = new HashSet<>(captchaStorage.keySet());
        for (String key : keys) {
            Captcha captcha = captchaStorage.get(key);
            if (System.currentTimeMillis() - captcha.getTimeStamp().getTime() > timeout) {
                captchaStorage.remove(key);
            }
        }
    }

    /**
     * Method check user's answer.
     *
     * @return true if answer is correct
     */
    public abstract boolean checkAnswer(HttpServletRequest request) throws IOException, ServletException;

    /**
     * Method is used for sending key to user
     *
     * @param request  - {@link HttpServletRequest}
     * @param response - {@link HttpServletResponse}
     */
    public abstract void sendKey(HttpServletRequest request, HttpServletResponse response);
}
