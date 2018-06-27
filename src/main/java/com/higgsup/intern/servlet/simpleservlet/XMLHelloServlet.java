package com.higgsup.intern.servlet.simpleservlet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class XMLHelloServlet extends HttpServlet {

    public XMLHelloServlet() {
        System.out.println("This is a constructor");
    }

    @Override
    public void init() throws ServletException {
        super.init();
        System.out.println("call init()");
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        System.out.println("call init(config)");
        String param = config.getInitParameter("testServletInitParam");
        System.out.println("parameters = " + param);
        ServletContext context = config.getServletContext();
        String contextParam = context.getInitParameter("testServletContextParam");
        System.out.println("Context params: " + contextParam);
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("calll service");
        super.service(req, resp);
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        System.out.println("call doGet");

        // Allocate a output writer to write the response message into the network socket
        PrintWriter out = response.getWriter();

        // Write the response message
        try {
            out.println("Hello world by XML");
        } finally {
            // Always close the output writer
            out.close();
        }
    }

    @Override
    public void destroy() {
        System.out.println("Call destroy()......");
        super.destroy();
    }
}