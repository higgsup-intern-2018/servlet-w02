package com.higgsup.intern.servlet.simpleservlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class ServletClass extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {

        // Allocate a output writer to write the response message into the network socket
        PrintWriter out = response.getWriter();
        response.setContentType("text/html");

        String additionalContent = (String) request.getAttribute("additional_content");

        // Write the response message
        try {
            out.println("Hello <b>world</b>");
            out.println("<br>" + additionalContent);
        } finally {
            // Always close the output writer
            out.close();
        }
    }
}