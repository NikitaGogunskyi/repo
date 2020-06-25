package com.epam.captcha.keeper;

import nl.captcha.Captcha;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static com.epam.constant.Attribute.CAPTCHA_KEY;
import static com.epam.constant.Parameter.CAPTCHA;

/**
 * Class <tt>CookieCaptchaKeeper</tt> is implementation for {@link CaptchaKeeper} for setting captcha's key to cookies and getting
 * it from there.
 */
public class CookieCaptchaKeeper extends CaptchaKeeper {

    public CookieCaptchaKeeper(Long timeout) {
        super(timeout);
    }

    @Override
    public boolean checkAnswer(HttpServletRequest request) {
        String answer = request.getParameter(CAPTCHA);
        String key = null;
        Cookie[] cookies = request.getCookies();
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals(CAPTCHA_KEY)) {
                key = cookie.getValue();
            }
        }
        Captcha captcha = getCaptcha(key);
        return captcha != null && captcha.isCorrect(answer);
    }


    @Override
    public void sendKey(HttpServletRequest request, HttpServletResponse response) {
        Cookie cookie = new Cookie(CAPTCHA_KEY, getCurrentKey());
        response.addCookie(cookie);
    }

}
