package com.epam.controller;

import com.epam.bean.FilterBean;
import com.epam.bean.PageBean;
import com.epam.service.ProductService;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Map;
import java.util.Objects;

import static com.epam.constant.Attribute.*;
import static com.epam.constant.Parameter.*;

@WebServlet("/main")
public class MainPageServlet extends HttpServlet {

    public static final String MAIN_PAGE = "mainPage.jsp";

    private ProductService productService;
    private Map<String, String> categories;

    @Override
    public void init(ServletConfig servletConfig) {
        productService = (ProductService) servletConfig.getServletContext().getAttribute(PRODUCT_SERVICE);
        categories = productService.getCategories();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        FilterBean filter = getFilterBean(session);
        PageBean pageBean = getPageBean(session, filter);
        int page = getPage(request);
        pageBean.setCurrentPage(page);
        request.setAttribute(FILTER, filter);
        request.setAttribute(PAGINATOR, pageBean);
        request.setAttribute(PRODUCTS, productService.getProducts(filter.getQuery(), pageBean.getStartIndex(page), filter.getProductNum()));
        request.getRequestDispatcher(MAIN_PAGE).forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();
        FilterBean filter = new FilterBean();
        filter.setCategories(categories);
        filter.setKeyWord(request.getParameter(KEY_WORD));
        filter.setMinCost(request.getParameter(MIN_COST));
        filter.setMaxCost(request.getParameter(MAX_COST));
        filter.setSortBy(request.getParameter(ORDER_BY));
        filter.setProductNum(request.getParameter(ITEMS));
        filter.makeChecked(request.getParameterValues(CATEGORY));
        session.setAttribute(FILTER, filter);
        session.removeAttribute(PAGINATOR);
        response.sendRedirect(request.getServletPath());
    }

    private FilterBean getFilterBean(HttpSession session) {
        FilterBean filter = (FilterBean) session.getAttribute(FILTER);
        if (Objects.isNull(filter)) {
            filter = new FilterBean();
            filter.setCategories(categories);
        }
        return filter;
    }

    private PageBean getPageBean(HttpSession session, FilterBean filter) {
        PageBean pageBean = (PageBean) session.getAttribute(PAGINATOR);
        if (Objects.isNull(pageBean)) {
            pageBean = new PageBean();
            pageBean.setItemsPerPage(filter.getProductNum());
            pageBean.setLastPage(productService.getProductsAmount(filter.getQuery()));
            session.setAttribute(PAGINATOR, pageBean);
        }
        return pageBean;
    }

    private int getPage(HttpServletRequest request) {
        int page = 1;
        String parameter = request.getParameter(PAGE);
        if (Objects.nonNull(parameter)) {
            try {
                page = Integer.parseInt(parameter);
            } catch (NumberFormatException e) {
                return page;
            }
        }
        return page;
    }
}