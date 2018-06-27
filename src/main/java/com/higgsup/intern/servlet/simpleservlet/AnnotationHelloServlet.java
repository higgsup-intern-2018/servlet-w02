package com.higgsup.intern.servlet.simpleservlet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(
        name = "AnnotationHelloServlet",
        urlPatterns = {"/annotation/say-hello"}
)
public class AnnotationHelloServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Allocate a output writer to write the response message into the network socket
        PrintWriter out = response.getWriter();

        // Write the response message
        try {
            out.println("Hello world by Annotation");
        } finally {
            // Always close the output writer
            out.close();
        }
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
}
