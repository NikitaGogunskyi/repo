package com.epam.controller;

import com.epam.entity.User;
import com.epam.exception.UserNotFoundException;
import com.epam.service.UserService;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import static com.epam.constant.Attribute.*;
import static com.epam.constant.Message.INVALID_AUTHORIZATION;
import static com.epam.constant.Parameter.EMAIL;
import static com.epam.constant.Parameter.PASSWORD;

@WebServlet("/signIn")
public class AuthorizationServlet extends HttpServlet {

    public static final String AUTHORIZATION_PAGE = "WEB-INF/jsp/authorization.jsp";
    private UserService userService;

    @Override
    public void init(ServletConfig servletConfig) {
        userService = (UserService) servletConfig.getServletContext().getAttribute(USER_SERVICE);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher(AUTHORIZATION_PAGE).forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();
        String email = request.getParameter(EMAIL);
        String password = request.getParameter(PASSWORD);
        try {
            User user = userService.getUser(email, password);
            session.setAttribute(USER, user);
            response.sendRedirect(request.getContextPath() + "/main");
        } catch (UserNotFoundException e) {
            session.setAttribute(AUTHORIZATION_MESSAGE, INVALID_AUTHORIZATION);
            response.sendRedirect(request.getServletPath());
        }
    }
}
