package org.mdeamorin.webapp.headers.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/request-headers")
public class RequestHeadersServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String httpMethod = req.getMethod();
        String requestURI = req.getRequestURI();
        String requestURL = req.getRequestURL().toString();
        String contextPath = req.getContextPath();
        String servletPath = req.getServletPath();
        String ip = req.getLocalAddr();
        String ipClient = req.getRemoteAddr();
        int port = req.getLocalPort();
        String scheme = req.getScheme();
        String host = req.getHeader("host");
        String urlHost = scheme + "://" + host + contextPath + servletPath;
        String urlIp = scheme + "://" + ip + ":" + port + contextPath + servletPath;

        try (PrintWriter out = resp.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("    <head>");
            out.println("        <meta charset=\"UTF-8\">");
            out.println("        <title>Resultado form</title>");
            out.println("    </head>");
            out.println("    <body>");
            out.println("        <h1>Resultado form!</h1>");
            out.println("        <ul>");
                out.println("           <li>Metodo HTTP: " + httpMethod + "</li>");
                out.println("           <li>Request URI: " + requestURI + "</li>");
                out.println("           <li>Request URL: " + requestURL + "</li>");
                out.println("           <li>Context Path: " + contextPath + "</li>");         
                out.println("           <li>Servlet Path: " + servletPath + "</li>");
                out.println("           <li>Local IP: " + ip + "</li>");
                out.println("           <li>Client IP: " + ipClient + "</li>");
                out.println("           <li>Local Port: " + port + "</li>");
                out.println("           <li>Scheme: " + scheme + "</li>");
                out.println("           <li>Host: " + host + "</li>");
                out.println("           <li>Url Host: " + urlHost + "</li>");
                out.println("           <li>Url IP: " + urlIp + "</li>");

                Enumeration<String> headerNames = req.getHeaderNames();
                while (headerNames.hasMoreElements()) {
                    String header = headerNames.nextElement();
                    out.println("<li>" + header + req.getHeader(header) + "</li>");
                }
                out.println("        </ul>");
                out.println("    </body>");
                out.println("</html>");            
            }        
    }
}
