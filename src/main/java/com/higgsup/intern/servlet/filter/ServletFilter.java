package com.higgsup.intern.servlet.filter;

import javax.servlet.*;
import java.io.IOException;

public class ServletFilter implements Filter{

    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("ServletFilter: init() ...");
    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("ServletFilter: doFilter() ...");
        servletRequest.setAttribute("additional_content", "Hello, this is an additional content. Ahihi!!!");

//        System.out.println("ServletFilter: pre");
        filterChain.doFilter(servletRequest, servletResponse);
    }

    public void destroy() {
        System.out.println("ServletFilter: destroy() ...");
    }
}
