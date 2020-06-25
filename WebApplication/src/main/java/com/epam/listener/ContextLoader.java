package com.epam.listener;

import com.epam.dao.ProductDAO;
import com.epam.dao.UserDAO;
import com.epam.service.ProductService;
import com.epam.service.UserService;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import static com.epam.constant.Attribute.*;

/**
 * Class <tt>ContextLoader</tt> is used to generate necessary objects firstly and make them available to another servlets.
 */
public class ContextLoader implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        UserDAO userDAO = new UserDAO();
        ProductDAO productDAO = new ProductDAO();
        ProductService productService = new ProductService(productDAO);
        UserService userService = new UserService(userDAO);
        DiskFileItemFactory fileUpLoaderFactory = new DiskFileItemFactory();
        servletContextEvent.getServletContext().setAttribute(PRODUCT_SERVICE, productService);
        servletContextEvent.getServletContext().setAttribute(USER_SERVICE, userService);
        servletContextEvent.getServletContext().setAttribute(UPLOADER_FACTORY, fileUpLoaderFactory);
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}