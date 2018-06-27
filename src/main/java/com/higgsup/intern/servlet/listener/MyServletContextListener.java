package com.higgsup.intern.servlet.listener;

import com.higgsup.intern.servlet.util.DBConnectionManager;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * Created by quytm on 27/06/18.
 */

public class MyServletContextListener implements ServletContextListener {
    public void contextInitialized(ServletContextEvent event) {
        ServletContext servletContext = event.getServletContext();

        String url = (String) servletContext.getAttribute("DB_URL");
        String user = (String) servletContext.getAttribute("DB_USER");
        String password = (String) servletContext.getAttribute("DB_PASSWORD");
        DBConnectionManager dbManager = new DBConnectionManager(url, user, password);

        servletContext.setAttribute("db_manager", dbManager);
        System.out.println("Init DB Manager for Application");
    }

    public void contextDestroyed(ServletContextEvent event) {
        ServletContext servletContext = event.getServletContext();
        DBConnectionManager dbManager = (DBConnectionManager) servletContext.getAttribute("db_manager");
        if (dbManager != null) {
            dbManager.closeConnection();
            System.out.println("Close DB");
        }
    }
}