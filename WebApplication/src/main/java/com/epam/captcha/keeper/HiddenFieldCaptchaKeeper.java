package com.epam.captcha.keeper;

import nl.captcha.Captcha;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static com.epam.constant.Attribute.CAPTCHA_KEY;
import static com.epam.constant.Attribute.HIDDEN_FIELD;
import static com.epam.constant.Parameter.CAPTCHA;

/**
 * Class <tt>HiddenFieldCaptchaKeeper</tt> is implementation for {@link CaptchaKeeper} for setting captcha's key to hidden field
 * and getting it from there.
 */
public class HiddenFieldCaptchaKeeper extends CaptchaKeeper {

    public HiddenFieldCaptchaKeeper(Long timeout) {
        super(timeout);
    }

    @Override
    public boolean checkAnswer(HttpServletRequest request) {
        request.getSession().removeAttribute(HIDDEN_FIELD);
        String answer = request.getParameter(CAPTCHA);
        String key = request.getParameter(CAPTCHA_KEY);
        Captcha captcha = getCaptcha(key);
        return captcha != null && captcha.isCorrect(answer);
    }


    @Override
    public void sendKey(HttpServletRequest request, HttpServletResponse response) {
        request.getSession().setAttribute(HIDDEN_FIELD, getCurrentKey());
    }

}
