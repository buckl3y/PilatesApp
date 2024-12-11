/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.javaservice;

import org.eclipse.jetty.server.*;
import org.eclipse.jetty.servlet.*;
import java.io.IOException;

/**
 *
 * @author maste
 */
public class WebServer {

    public void boot() {
        int port = Integer.parseInt(System.getenv("BACKEND_PORT"));
        String contextPath = "/";

        Server server = new Server();
        ServerConnector ssl = new ServerConnector(server);
        ssl.setPort(port);
        server.addConnector(ssl);

        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
        context.setContextPath(contextPath);
        server.setHandler(context);
    }
}
