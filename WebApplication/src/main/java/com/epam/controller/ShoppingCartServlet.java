package com.epam.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/cart")
public class ShoppingCartServlet extends HttpServlet {
    public static final String SHOPPING_CART_PAGE = "WEB-INF/jsp/shopCart.jsp";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher(SHOPPING_CART_PAGE).forward(request, response);
    }
}
