package org.mdeamorin.webapp.session.controllers;

import java.io.IOException;
import java.io.PrintWriter;

import org.mdeamorin.webapp.session.services.SessionService;
import org.mdeamorin.webapp.session.services.SessionServiceImpl;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private final static String USERNAME = "admin";
    private final static String PASSWORD = "12345";
    private SessionService sessionService = new SessionServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        String foundSessionValue = sessionService.getSessionValue(req, "username");
        
        if(foundSessionValue != null) {
            try (PrintWriter out = resp.getWriter()) {
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("    <head>");
                out.println("        <meta charset=\"UTF-8\">");
                out.println("        <title>Hola " + foundSessionValue + "</title>");
                out.println("    </head>");
                out.println("    <body>");
                out.println("        <h1>Hola " + foundSessionValue + " has iniciado sesion con exito</h1>");
                out.println("        <p><a href=\"" + req.getContextPath()  + "/index.html\">Volver</a></p>");
                out.println("        <p><a href=\"" + req.getContextPath()  + "/logout\">Cerrar Sesion</a></p>");
                out.println("    </body>");
                out.println("</html>");
            }
        } else {
            getServletContext().getRequestDispatcher("/login.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        if(USERNAME.equals(username) && PASSWORD.equals(password)) {
            sessionService.setSessionValue(req, "username", password);

            resp.sendRedirect(req.getContextPath() + "/login");
        } else {
            resp.sendError(HttpServletResponse.SC_UNAUTHORIZED, "El usuario no se encuentra autorizado para ingresar.");
        }
    }
}
