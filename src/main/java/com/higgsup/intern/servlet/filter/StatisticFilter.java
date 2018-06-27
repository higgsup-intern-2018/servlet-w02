package com.higgsup.intern.servlet.filter;

import javax.servlet.*;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by quytm on 27/06/18.
 */
public class StatisticFilter implements Filter {

    public void init(FilterConfig filterConfig) throws ServletException {

    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("StatisticFilter: doFilter() ... ");
        PrintWriter out = servletResponse.getWriter();
        long before = System.currentTimeMillis();

        filterChain.doFilter(servletRequest, servletResponse);

        long after = System.currentTimeMillis();

        out.print("<br/>Total response time " + (after - before) + " miliseconds");
    }

    public void destroy() {

    }
}
