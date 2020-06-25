package com.epam.captcha.keeper.factory;

import com.epam.captcha.keeper.CaptchaKeeper;
import com.epam.captcha.keeper.CookieCaptchaKeeper;
import com.epam.captcha.keeper.HiddenFieldCaptchaKeeper;
import com.epam.captcha.keeper.SessionCaptchaKeeper;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

import static com.epam.constant.Parameter.*;

/**
 * Class<tt>KeeperFactory</tt> is responsible for initialization captcha keepers {@link CaptchaKeeper} be parameters taken form
 * deployment descriptor.
 */
public class KeeperFactory {

    private ServletContext contextServlet;
    private Map<String, CaptchaKeeper> keepers = new HashMap<>();

    public KeeperFactory(HttpServletRequest request) {
        contextServlet = request.getServletContext();
        Long timeout = Long.valueOf(contextServlet.getInitParameter(TIMEOUT));
        keepers.put(SESSION, new SessionCaptchaKeeper(timeout));
        keepers.put(COOKIE, new CookieCaptchaKeeper(timeout));
        keepers.put(HIDDEN_FIELD, new HiddenFieldCaptchaKeeper(timeout));
    }

    public CaptchaKeeper getKeeper() {
        return keepers.get(contextServlet.getInitParameter(CAPTCHA_CONFIG));
    }
}
