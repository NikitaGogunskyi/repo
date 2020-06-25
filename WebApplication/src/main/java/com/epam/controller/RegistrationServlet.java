package com.epam.controller;

import com.epam.bean.FormBean;
import com.epam.captcha.keeper.CaptchaKeeper;
import com.epam.captcha.keeper.factory.KeeperFactory;
import com.epam.entity.User;
import com.epam.image.ImageSource;
import com.epam.service.UserService;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import static com.epam.constant.Attribute.*;
import static com.epam.constant.Message.CAPTCHA_ERROR;
import static com.epam.constant.Message.EXISTING_USER_ERROR;
import static com.epam.constant.Parameter.*;

/**
 * Servlet <tt>RegistrationServlet</tt> is implementation of HttpServlet. Main opportunity of class is handling requests from
 * registration page and generating correct response. Contain main logic of users registration. Accept valid data and send invalid
 * to be entered repeatedly. Uses {@link UserService} to save and check data. Also uses {@link nl.captcha.Captcha} and {@link
 * FormBean} to validate and approve entered values.
 */
@MultipartConfig
@WebServlet("/signUp")
public class RegistrationServlet extends HttpServlet {

    public static final String REGISTRATION_PAGE = "WEB-INF/jsp/registration.jsp";
    private UserService userService;

    @Override
    public void init(ServletConfig servletConfig) {
        userService = (UserService) servletConfig.getServletContext().getAttribute(USER_SERVICE);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        HttpSession session = request.getSession();
        FormBean form = (FormBean) session.getAttribute(FORM);
        CaptchaKeeper keeper = (CaptchaKeeper) session.getAttribute(KEEPER);
        if (form == null) {
            form = new FormBean();
        }
        if (keeper == null) {
            keeper = new KeeperFactory(request).getKeeper();
        }
        keeper.generateKey();
        keeper.sendKey(request, response);
        session.setAttribute(KEEPER, keeper);
        request.setAttribute(FORM, form);
        request.getRequestDispatcher(REGISTRATION_PAGE).forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        HttpSession session = request.getSession();
        FormBean form = new FormBean();
        ImageSource imageSource = new ImageSource(REPOSITORY_PATH + AVATARS_SOURCE);
        form.setName(request.getParameter(NAME));
        form.setEmail(request.getParameter(EMAIL));
        if (userService.isUserAlreadyExist(form.getEmail())) {
            form.putError(EMAIL, EXISTING_USER_ERROR);
        }
        form.setPassword(request.getParameter(PASSWORD), request.getParameter(REPEATED_PASSWORD));
        form.setAgreement(request.getParameter(AGREEMENT));
        CaptchaKeeper keeper = (CaptchaKeeper) session.getAttribute(KEEPER);
        if (!keeper.checkAnswer(request)) {
            form.putError(CAPTCHA, CAPTCHA_ERROR);
        }
        form.setAvatar(request.getParts());
        session.setAttribute(FORM, form);
        if (form.isValid()) {
            User newUser = userService.addUser(form.createUser());
            imageSource.writeImage(form.getAvatar(), String.valueOf(newUser.getId()));
            session.setAttribute(USER, newUser);
            response.sendRedirect(request.getContextPath() + "/main");
        } else {
            response.sendRedirect(request.getServletPath());
        }
    }
}
