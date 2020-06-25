package com.epam.captcha.keeper;

import nl.captcha.Captcha;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static com.epam.constant.Attribute.CAPTCHA_KEY;
import static com.epam.constant.Parameter.CAPTCHA;

/**
 * Class <tt>SessionCaptchaKeeper</tt> is implementation for {@link CaptchaKeeper} for setting captcha's key to session and
 * getting it from there.
 */
public class SessionCaptchaKeeper extends CaptchaKeeper {

    public SessionCaptchaKeeper(Long timeout) {
        super(timeout);
    }

    @Override
    public boolean checkAnswer(HttpServletRequest request) {
        String answer = request.getParameter(CAPTCHA);
        String key = (String) request.getSession().getAttribute(CAPTCHA_KEY);
        Captcha captcha = getCaptcha(key);
        return captcha != null && captcha.isCorrect(answer);
    }


    @Override
    public void sendKey(HttpServletRequest request, HttpServletResponse response) {
        request.getSession().setAttribute(CAPTCHA_KEY, getCurrentKey());
    }
}
