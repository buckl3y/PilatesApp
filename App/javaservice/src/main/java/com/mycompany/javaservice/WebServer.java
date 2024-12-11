/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.javaservice;

import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.eclipse.jetty.server.Connector;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.ServerConnector;
import org.eclipse.jetty.servlet.ServletHandler;

/**
 *
 * @author maste
 */
public class WebServer {

    private Server server;
    private int port;
    private String contextPath = "/";

    public WebServer(int port) {
        this.port = port;
    }

    public void boot() throws Exception {
        server = new Server();
        ServerConnector connector = new ServerConnector(server);
        connector.setPort(port);
        server.setConnectors(new Connector[]{connector});

        ServletHandler servletHandler = new ServletHandler();
        servletHandler.addServletWithMapping(BlockingServlet.class, "/status");
        server.setHandler(servletHandler);
        server.start();
    }

    protected void shutdown() {
        if (server != null) {
            try {
                server.stop();
                server.destroy();
                System.out.println("Server stopped.");
            } catch (Exception e) {
            }
        }
    }

    protected int getStatus() throws IOException {
        String url = "http://localhost:" + port + "/status";
        HttpClient client = HttpClientBuilder.create().build();
        HttpGet request = new HttpGet(url);
        HttpResponse response = client.execute(request);
        return response.getStatusLine().getStatusCode();
    }
}
