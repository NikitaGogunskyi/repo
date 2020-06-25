package com.epam.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LogoutFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException {
        HttpSession session = ((HttpServletRequest) request).getSession();
        session.invalidate();
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        httpResponse.sendRedirect("/main");
    }

    @Override
    public void destroy() {

    }
}
