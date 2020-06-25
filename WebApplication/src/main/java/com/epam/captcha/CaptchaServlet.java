package com.epam.captcha;

import com.epam.captcha.keeper.CaptchaKeeper;
import com.epam.util.WordGenerator;
import nl.captcha.Captcha;
import nl.captcha.backgrounds.GradiatedBackgroundProducer;
import nl.captcha.servlet.CaptchaServletUtil;
import nl.captcha.text.renderer.DefaultWordRenderer;
import nl.captcha.text.renderer.WordRenderer;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

import static com.epam.constant.Attribute.KEEPER;

/**
 * Servlet <tt>CaptchaServlet</tt> is implementation of HttpServlet. Main opportunity of class is creation of picture with special
 * four-digit numerical code to protect application against bot harmful influence. For code generation is used {@link
 * WordGenerator} Class provides methods to handle request and send specified response to client side.
 */
@WebServlet("/captcha")
public class CaptchaServlet extends HttpServlet {

    public static final int WIDTH = 120;
    public static final int HEIGHT = 50;
    private WordGenerator code;
    private WordRenderer wordRenderer;

    @Override
    public void init() {
        List<Color> colors = new ArrayList<>();
        List<Font> fonts = new ArrayList<>();
        colors.add(Color.blue);
        colors.add(Color.red);
        colors.add(Color.pink);
        fonts.add(new Font("Arial", Font.ITALIC, 40));
        fonts.add(new Font("Monospaced", Font.BOLD, 45));
        fonts.add(new Font("Plain", Font.PLAIN, 35));
        code = new WordGenerator();
        wordRenderer = new DefaultWordRenderer(colors, fonts);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        CaptchaKeeper keeper = (CaptchaKeeper) request.getSession().getAttribute(KEEPER);
        Captcha captcha = getCapture();
        keeper.putCaptcha(captcha);
        CaptchaServletUtil.writeImage(response, captcha.getImage());
    }

    /**
     * Method create object to generate captcha image with four-digit numerical value.
     *
     * @return {@link Captcha}
     */
    private Captcha getCapture() {
        return new Captcha.Builder(WIDTH, HEIGHT)
                .addText(code, wordRenderer)
                .addBackground(new GradiatedBackgroundProducer(Color.white, Color.white))
                .gimp()
                .addNoise()
                .addNoise()
                .build();
    }
}